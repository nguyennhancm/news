package tv.servlet;

import org.apache.commons.validator.GenericValidator;
import org.apache.log4j.Logger;
import tv.utils.ImageResize;
import tv.utils.RequestDevice;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 10/15/2015
 * Time: 6:46 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "getImageServlet", urlPatterns = {"/upload/images/*"})
public class GetImageServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(getClass());
    private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.
    protected long createTime = System.currentTimeMillis();
    protected String eTag = null;
    protected long lastModified = -1;
    protected long expires = -1;
    private static final long DEFAULT_EXPIRE_TIME = 604800000L; // ..ms = 1 week.

    private String mediumPath; // w640
    private String originalPath;
    private String smallPath; // w330
    private String iconPath; // w140
    private String defaultImagePath;
    private String fixedPath; // width X height

    public String getMediumPath() {
        if (null == mediumPath) mediumPath = System.getProperty("news.upload.images.medium");
        return mediumPath;
    }

    public String getOriginalPath() {
        if (null == originalPath) originalPath = System.getProperty("news.upload.images.original");
        return originalPath;
    }

    public String getSmallPath() {
        if (null == smallPath) smallPath = System.getProperty("news.upload.images.small");
        return smallPath;
    }

    public String getIconPath() {
        if (null == iconPath) iconPath = System.getProperty("news.upload.images.icon");
        return iconPath;
    }

    public String getDefaultImagePath() {
        if (null == defaultImagePath) defaultImagePath = "news.upload.images.default";
        return defaultImagePath;
    }

    public String getFixedPath() {
        if (null == fixedPath) fixedPath = System.getProperty("news.upload.images.fixed");
        return fixedPath;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RequestDevice uAgentInfo = new RequestDevice(request.getHeader("user-agent"), "*/*");
            boolean mobile = uAgentInfo.detectMobileQuick();
            if (!mobile) {
                String pathSub = request.getRequestURI();
                if (null != pathSub) {
                    String imagePath = pathSub.substring(pathSub.indexOf("/upload/images/") + 14, pathSub.length());
                    String locatePath = "";
                    String imageSize = request.getParameter("size");
                    if (!GenericValidator.isBlankOrNull(imageSize)) {
                        if (imageSize.equals("medium")) locatePath = getMediumPath();
                        else if (imageSize.equals("small")) locatePath = getSmallPath();
                        else if (imageSize.equals("icon")) locatePath = getIconPath();
//                else if (imagePath.startsWith("/lager/")) locatePath = getOriginalPath();
//                else if (imagePath.startsWith("/default/")) locatePath = getDefaultImagePath();
                        // check Width X Height -> get fixed .........
                    } else {
                        imageSize = "medium";
                        locatePath = getMediumPath(); //tam thoi chi lay max width = medium
                    }
                    File image;
                    if (!GenericValidator.isBlankOrNull(locatePath)) {
                        String toPath = locatePath + File.separator + imagePath;
                        image = new File(toPath);
                        if (!image.exists()) {
                            image.getParentFile().mkdirs(); // tạo thư mục mới để copy sang
                            String imageOriginalPath = getOriginalPath() + File.separator + imagePath;
                            image = new File(imageOriginalPath);
                            if (image.exists()) {
                                int toWidth = 500;
                                if (imageSize.equals("medium")) {
                                    toWidth = 680;
                                } else if (imageSize.equals("small")) {
                                    toWidth = 330;
                                } else if (imageSize.equals("icon")) {
                                    toWidth = 140;
                                }
                                BufferedImage bImg = ImageIO.read(image);
                                int widthOriginal = bImg.getWidth();
                                if (widthOriginal > toWidth) {

                                    ImageResize.resizeWidth(imageOriginalPath, toPath, toWidth);
                                    image = new File(toPath);
                                }
                            } else {
                                image = new File(getOriginalPath() + "/default_image.jpg");
                            }

                        }

                    } else {
                        imagePath = getOriginalPath() + File.separator + imagePath;
                        image = new File(imagePath);
                        if (!image.exists()) {
                            image = new File(getOriginalPath() + "/default_image.jpg");
                        }
                    }

                    response.reset();
                    response.setContentType("image/jpeg");
                    Files.copy(image.toPath(), response.getOutputStream());
                    return;
                }
            } else {
                // chuyen sang m.dulichcantho.vn
            }
        } catch (Exception e) {
            logger.warn("Could not get image upload: " + e.getMessage());
            return;
        }
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return;
    }


    private static void setCacheTag(File image, HttpServletRequest request, HttpServletResponse response) {
        // Prepare some variables. The ETag is an unique identifier of the file.
        String fileName = image.getName();
        long length = image.length();
        long lastModified = image.lastModified();
        String eTag = fileName + "_" + length + "_" + lastModified;
        long expires = System.currentTimeMillis() + DEFAULT_EXPIRE_TIME;

        // Validate request headers for caching ---------------------------------------------------

        // If-None-Match header should contain "*" or ETag. If so, then return 304.
        String ifNoneMatch = request.getHeader("If-None-Match");
        if (ifNoneMatch != null && matches(ifNoneMatch, eTag)) {
            response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
            response.setHeader("ETag", eTag); // Required in 304.
            response.setDateHeader("Expires", expires); // Postpone cache with 1 week.
            return;
        }

        // If-Modified-Since header should be greater than LastModified. If so, then return 304.
        // This header is ignored if any If-None-Match header is specified.
        long ifModifiedSince = request.getDateHeader("If-Modified-Since");
        if (ifNoneMatch == null && ifModifiedSince != -1 && ifModifiedSince + 1000 > lastModified) {
            response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
            response.setHeader("ETag", eTag); // Required in 304.
            response.setDateHeader("Expires", expires); // Postpone cache with 1 week.
            return;
        }

        if (null == ifNoneMatch && ifModifiedSince == -1) {
//            response.setHeader(HTTPCacheHeader.CACHE_CONTROL.getName(), cacheControl.toString());
            response.setDateHeader("Expires", expires); // Postpone cache with 1 week.
        }


    }


    /**
     * Returns true if the given match header matches the given value.
     *
     * @param matchHeader The match header.
     * @param toMatch     The value to be matched.
     * @return True if the given match header matches the given value.
     */
    private static boolean matches(String matchHeader, String toMatch) {
        String[] matchValues = matchHeader.split("\\s*,\\s*");
        Arrays.sort(matchValues);
        return Arrays.binarySearch(matchValues, toMatch) > -1
                || Arrays.binarySearch(matchValues, "*") > -1;
    }

    public static File getImageFile(String imagePath, String imageId) throws UnsupportedEncodingException {
        File image = new File(imagePath, URLDecoder.decode(imageId, "UTF-8"));
        return image;
    }

}
