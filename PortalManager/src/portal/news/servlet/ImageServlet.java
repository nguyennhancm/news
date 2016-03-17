package portal.news.servlet;

import org.apache.log4j.Logger;
import portal.news.bean.upload.ResizeImage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: NTD
 * Date: 5/29/2015
 * Time: 8:33 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "imageServlet", urlPatterns = {"/imagesUpload/*"})
public class ImageServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(getClass());
    private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.
    protected long createTime = System.currentTimeMillis();
    protected String eTag = null;
    protected long lastModified = -1;
    protected long expires = -1;
    private static final long DEFAULT_EXPIRE_TIME = 604800000L; // ..ms = 1 week.

    private String pathDir;
    private String pathDirForum;


    public String getPath() {
        if (null == pathDir) {
            pathDir = System.getProperty("ntd.fb.uploadImages");
        }
        return pathDir;
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String pathSub = request.getRequestURI();
            if (null != pathSub) {
                String imagePath = pathSub.substring(pathSub.indexOf("imagesUpload") + 12, pathSub.length());
                imagePath = getPath() + File.separator + imagePath;
                File image = new File(imagePath.substring(0, imagePath.length() - 4) + "football" + ".jpg");
                if (!image.exists()) {
                    ResizeImage.resizeImage(imagePath, imagePath.substring(0, imagePath.length() - 4) + "football" + ".jpg", 0, 0);
                    image = new File(imagePath.substring(0, imagePath.length() - 4) + "football" + ".jpg");
                }
                response.reset();
                response.setContentType("image/jpeg");
                Files.copy(image.toPath(), response.getOutputStream());
                return;
            }
        } catch (Exception e) {
            logger.warn("Could not get image: " + e.getMessage());
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

