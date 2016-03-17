package portal.news.bean.upload;

import com.google.gson.Gson;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: NTD
 * Date: 3/18/2015
 * Time: 10:35 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "chatUploadImageServlet", urlPatterns = "/chatUploadImageServlet/*")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class ChatUploadImageServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(getClass());
    private String path_Save_DIR = null;

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat hourFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat hourFormat1 = new SimpleDateFormat("MM-yyyy");
        String toDate = hourFormat.format(calendar.getTime());
        Date today = calendar.getTime();


        path_Save_DIR = System.getProperty("ntd.fb.uploadImages");
        String savePath = "";
        String relativePath = String.valueOf(hourFormat1);
        if (null != request.getParameter("relativePath"))
            relativePath = request.getParameter("relativePath");
        String type = request.getParameter("fileType");
        savePath = path_Save_DIR + File.separator + "Upload";
        savePath += File.separator + relativePath;
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        String name = toDate;
        if (type.equals("jpg") || type.equals("png") || type.equals("bmp") || type.equals("gif") || type.equals("tiff") || type.equals("jpeg")) {
            for (Part part : request.getParts()) {
                name = extractFileName(part);
                if (!"".equals(name) && null != name) {
                    String random = request.getParameter("styleClass");
                    part.write(savePath + File.separator + random + "." + type);
                    // TODO request get image, after write resize image.
                    Gson gson = new Gson();
                    String linkImg = "/imagesUpload/Upload/" + relativePath + "/" + random + "." + type;
                    ChatUploadImage chatUploadImage = new ChatUploadImage(linkImg, random);
                    String success = gson.toJson(chatUploadImage);
                    PrintWriter out = resp.getWriter();
                    out.write(success);
                    out.flush();
                    out.close();
                }
            }
        } else {
            //TODO
            logger.info("File Type Invalid Format !");
        }
    }

    /**
     * Extracts file name from HTTP header content-disposition
     */

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    public void genSingleThumbnail(String basePath, String originalFileID, String thumbnailName, int width, int height) throws IOException {
        String fullPath = basePath + originalFileID;
        Thumbnails.of(new File(fullPath))
                .size(width, height)
                .outputQuality(1)
                .toFile(new File(basePath + thumbnailName));

    }


    private final static class ChatUploadImage {

        private final String link;
        private final String styleClass;

        public ChatUploadImage(String link, String styleClass) {
            this.link = link;
            this.styleClass = styleClass;
        }

        public String toString() {
            return "{\"styleClass\" : \"" + styleClass + "\",\"link\" :  \"" + link + "\"}";
        }
    }
}
