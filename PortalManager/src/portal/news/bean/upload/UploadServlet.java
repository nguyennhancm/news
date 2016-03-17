package portal.news.bean.upload;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
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
@WebServlet(name = "uploadServlet", urlPatterns = "/uploadServlet/*")
public class UploadServlet extends HttpServlet {
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
        processRequest(request, resp,savePath);

    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response,String path)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Create path components to save the file
//        final String path = request.getParameter("destination");
        final Part filePart = request.getPart("file");
        final String fileName = getFileName(filePart);

        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();

        try {
            out = new FileOutputStream(new File(path + File.separator
                    + fileName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            writer.println("New file " + fileName + " created at " + path);
        } catch (FileNotFoundException fne) {
            writer.println("You either did not specify a file to upload or are "
                    + "trying to upload a file to a protected or nonexistent "
                    + "location.");
            writer.println("<br/> ERROR: " + fne.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
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
