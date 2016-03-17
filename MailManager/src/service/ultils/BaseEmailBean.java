package service.ultils;

import org.primefaces.model.UploadedFile;
import service.email.controller.IEmailController;
import service.email.model.EmailDetail;
import service.email.utils.lookup.LocalLookup;
import service.email.utils.valueItem.manager.ISequenceValue;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/5/2015
 * Time: 4:25 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseEmailBean {

    Logger logger = null;
    protected String defaultUserId = "150930";
    protected String fileEmailPath = System.getProperty("email.file.upload") + "/" + defaultUserId + "/";
    protected String templateFolder = System.getProperty("email.template.upload") + "/" + defaultUserId;
    private IEmailController emailController;
    private ISequenceValue sequenceValue;
    SHA1Encoding encoding;

    public IEmailController getEmailController() {
        if (null == emailController) emailController = LocalLookup.getEmailController();
        return emailController;
    }

    public ISequenceValue getSequenceValue() {
        if (null == sequenceValue) sequenceValue = LocalLookup.getSequenceValue();
        return sequenceValue;
    }

    public void addMessagesInfo(String componentId, String messages) {
        FacesContext.getCurrentInstance().addMessage(componentId, new FacesMessage(FacesMessage.SEVERITY_INFO, messages, null));
    }

    public void addValidateError(String componentId, String validatorMessage) {
        FacesContext.getCurrentInstance().addMessage(componentId, new FacesMessage(FacesMessage.SEVERITY_ERROR, validatorMessage, null));
    }

    public void addError(String logDetail, Exception e) {
        getLogger().log(Level.WARNING, logDetail, e);
    }

    public abstract String getClassName();

    public Logger getLogger() {
        if (null == logger) {
            logger = Logger.getLogger(getClassName());
        }
        return logger;
    }

    public HttpSession getSession(){
        return getRequest().getSession();
    }

    public HttpServletRequest getRequest(){
        FacesContext context = FacesContext.getCurrentInstance();
        return (HttpServletRequest) context.getExternalContext().getRequest();
    }

    public SHA1Encoding getEncoding() {
        if (null == encoding)  encoding = new SHA1Encoding();
        return encoding;
    }

    public void setEncoding(SHA1Encoding encoding) {
        this.encoding = encoding;
    }

    public String saveFileToStorage(UploadedFile file, String filePath) {
        String fileName = "";
        String prefix = "";
        try {
            byte[] readData = new byte[1024];
            InputStream inputStream = null;
            inputStream = file.getInputstream();
            if (file.getFileName() != null) {
                fileName = file.getFileName().trim();
                if (fileName.indexOf("\\") >= 0) {
                    String[] fileNames = fileName.split("\\\\");
                    fileName = fileNames[fileNames.length - 1];
                }

                String name = "";
                if (fileName.indexOf(".") > 0) {
                    String temp[] = fileName.split("\\.");
                    prefix = temp[temp.length - 1];
                    for (int i = 0; i < temp.length - 1; i++) {
                        name += temp[i];
                    }
                }
                fileName = UnicodeUtils.unicode2Nosign(name);
                fileName = UnicodeUtils.removeSpecialCharacter(fileName);

            }
            do {
                fileName = fileName.replaceAll(" ", "");
            } while (fileName.contains(" "));
            java.io.File outFile = new java.io.File(filePath + fileName + "." + prefix);
            if (outFile.exists()) {
                fileName = fileName + "_" + new Timestamp(new Date().getTime()).toString().replace(":", "-").replace(" ", "_");
                outFile = new java.io.File(filePath + fileName + "." + prefix);
            }
            outFile.getParentFile().mkdirs();
            OutputStream outputStream = new FileOutputStream(outFile);
            int i = inputStream.read(readData);
            while (i != -1) {
                outputStream.write(readData, 0, i);
                i = inputStream.read(readData);
            }
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName + "." + prefix;
    }

    List<EmailDetail> emailDetailsCompile;

    public List<EmailDetail> getEmailDetailsCompile() {
        if (null == emailDetailsCompile) emailDetailsCompile = new ArrayList<EmailDetail>();
        return emailDetailsCompile;
    }

    public boolean validateSendEmail(String emailAccount, String template){
        boolean validate = true;
        if (emailAccount.equals("0")){
            addValidateError(null, "Bạn chưa chọn tài khoản gửi!");
            validate = false;
        }
        if (template.equals("0")){
            addValidateError(null, "Bạn chưa chọn template gửi!");
            validate = false;
        }
        return validate;
    }
    public boolean validateSelected(boolean isSelectEmail){
        boolean validate = true;
        if(!isSelectEmail){
            addValidateError(null, "Bạn chưa chọn email gửi!");
            validate = false;
        }
        return validate;
    }

    public String parseTime(int seconds){
        String parseString = "";
        String secondsS = " giây";
        String minutes = " phút ";
        String hours = " giờ ";
        if (seconds < 60){
            parseString = seconds + secondsS;
        }else if (60 <= seconds && seconds < 3600){
            if (seconds % 60 == 0)
            parseString = seconds/60 + minutes;
            else parseString = seconds/60 + minutes + seconds%60 + secondsS;
        } else if (seconds >= 3600){
            int redundancy = seconds%(60*60);
            if(redundancy == 0) parseString = seconds/(60*60) + hours;
            else {
               if (redundancy%60 == 0) parseString += redundancy/60 + minutes;
                else parseString += redundancy/60 + minutes + redundancy%60 + secondsS;
            }
        }
        return parseString;
    }
}
