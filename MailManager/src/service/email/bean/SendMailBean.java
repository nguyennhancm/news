package service.email.bean;

import com.sun.mail.smtp.SMTPTransport;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import service.email.entities.EmailAccount;
import service.email.entities.SendEmail;
import service.email.entities.Template;
import service.email.model.EmailDetail;
import service.ultils.BaseEmailBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.security.Security;
import java.sql.Timestamp;
import java.util.*;
import java.util.logging.Level;


/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 9/23/2015
 * Time: 6:50 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@SessionScoped
@ManagedBean(name = "SendMail")
public class SendMailBean extends BaseEmailBean implements Runnable {
    private String templateSelected;
    private String fileType;
    private String fileName;
    private int countEmail;
    private List<EmailDetail> emailDetailList;
    private List<EmailDetail> emailDetailListFilter;
    private String fileFilter = "0";
    private String fromEmail;
    private int timeSend = 1;
    private boolean selectAllEmail = true;
    private int emailQuality = 50;
    private String statusSend = "a";
    private int countEmailSend = 0;
    private String timeExpected = "";

    @ManagedProperty(value = "#{EmailManager}")
    EmailManagerBean emailManagerBean;

    public SendMailBean() {
    }

    public SendMailBean(String templateSelected, List<EmailDetail> emailDetailListFilter, String fromEmail, int timeSend) {
        this.templateSelected = templateSelected;
        this.emailDetailListFilter = emailDetailListFilter;
        this.fromEmail = fromEmail;
        this.timeSend = timeSend;
    }

    public void confirmSendEmail(){
        countEmailSend = 0;
        if ((validateSendEmail(fromEmail, templateSelected))) {
            for (EmailDetail emailDetail : getEmailDetailListFilter()) {
                if (emailDetail.isSelected()) {
                    countEmailSend++;
                }
            }
            if (validateSelected(countEmailSend > 0)) {
                timeExpected = parseTime(countEmailSend * timeSend);
                RequestContext.getCurrentInstance().execute("PF('confirmSendEmail').show();");
            }
        }


    }

    public String sendMail() {
        //validate
        countEmailSend = 0;
        if ((validateSendEmail(fromEmail, templateSelected))) {
            for (EmailDetail emailDetail : getEmailDetailListFilter()) {
                if (emailDetail.isSelected()) {
                    emailDetail.setStatusSend("đang gửi...");
                    emailDetail.setSelected(false);
                    emailManagerBean.getEmailDetailHashMap().put(emailDetail.getEmailAddress() + emailDetail.getFile().getFileId(), emailDetail);
                    countEmailSend++;
                }
            }
            if (validateSelected(countEmailSend > 0)) {
                setSelectAllEmail(false);
                emailManagerBean.setSelectAllEmail(false);
                onChangeFilter();
                emailManagerBean.onChangeFilter();
                SendMailBean sendMailBean = new SendMailBean(templateSelected, emailDetailListFilter, fromEmail, timeSend * 1000);
                Thread t = new Thread(sendMailBean);
                t.start();
                RequestContext.getCurrentInstance().execute("PF('confirmSendEmail').hide();");
                addMessagesInfo(null, "Hệ thống đang gửi " + countEmailSend + " email, dự khiến sẽ gửi xong trong " + parseTime(countEmailSend * timeSend ) + ".");
            }
        }
        return "";
    }

    public void sendEmailInNewThread() {
        final EmailAccount emailAccount = getEmailController().getEmailAccount(fromEmail, defaultUserId);
        Template template = getEmailController().getTemplate(templateSelected);
        HashMap<String, Object> profileData = new HashMap<String, Object>();
        String content = ftlParser(profileData, templateFolder, template.getFileName());
        List<EmailDetail> sendList = new ArrayList<EmailDetail>(emailDetailListFilter);
        if (emailAccount.getSsl().equals("N")) {
            try {
                Properties props = System.getProperties();
//              props.setProperty("mail.transport.protocol", "smtp");
                props.setProperty("mail.host", emailAccount.getEmailSmtp());
                props.put("mail.smtp.auth", "true");
                props.setProperty("mail.smtp.port", String.valueOf(emailAccount.getPort()));

                Session mailSession = Session.getInstance(props, new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(emailAccount.getEmailAccount(), emailAccount.getPassword());
                    }
                });
                mailSession.setDebug(true);
                Transport transport = mailSession.getTransport("smtp");
                transport.connect(emailAccount.getEmailSmtp(), emailAccount.getEmailAccount(), emailAccount.getPassword());
                MimeMessage message = new MimeMessage(mailSession);
                message.setSentDate(new java.util.Date());
                message.setSubject(template.getTitle());
                message.setFrom(new InternetAddress(emailAccount.getEmailAccount()));

                MimeMultipart multipart = new MimeMultipart("related");
                BodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setContent(content, "text/html;charset=utf-8");
                multipart.addBodyPart(messageBodyPart);
                message.setContent(multipart);
                for (EmailDetail emailDetail : sendList) {
                    if (emailDetail.getStatusSend().equals("đang gửi...")) {

                        String sendStatus = "success";
                        try {
                            sendEmailNonSSl(transport, message, emailDetail.getEmailAddress());

                        } catch (Exception e) {
                            sendStatus = "fail";
                            getLogger().log(Level.WARNING, "Error while send email non ssl" + emailDetail.getEmailAddress(), e.getMessage());
                        }
                        // save send email
                        SendEmail sendEmail = new SendEmail();
                        sendEmail.setSendEmailId(getSequenceValue().getSequenceValueItem(SendEmail.class));
                        sendEmail.setEmailFrom(emailAccount.getEmailAccount());
                        sendEmail.setEmailTo(emailDetail.getEmailAddress());
                        sendEmail.setTemplateId(template.getTemplateId());
                        sendEmail.setSubject(template.getTitle());
                        sendEmail.setContent(content);
                        sendEmail.setStatusId(sendStatus);
                        sendEmail.setFileId(emailDetail.getFile().getFileId());
                        sendEmail.setFileId(emailDetail.getFile().getFileId());
                        sendEmail.setCreateTime(new Timestamp(new Date().getTime()));
                        getEmailController().saveSendEmail(sendEmail);
                        emailDetail.setQualitySend(emailDetail.getQualitySend() + 1);
                        emailDetail.setStatusSend(sendStatus);
                        emailDetail.setDateSendEnd(sendEmail.getCreateTime());
                        getEmailDetailsCompile().add(emailDetail);
                        //
                    }
                    try {
                        Thread.sleep(timeSend);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
                transport.close();
            } catch (MessagingException e) {

                throw new RuntimeException(e);
            }
        } else if (emailAccount.getSsl().equals("Y")) {
            try {
                Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
                Properties props = new Properties();
                props.setProperty("mail.smtps.host", emailAccount.getEmailSmtp());
                props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
                props.setProperty("mail.smtp.socketFactory.fallback", "false");
                props.setProperty("mail.smtp.port", String.valueOf(emailAccount.getPort()));
                props.setProperty("mail.smtp.socketFactory.port", String.valueOf(emailAccount.getPort()));
                props.setProperty("mail.smtps.auth", "true");
                props.put("mail.smtps.quitwait", "false");
                Session session = Session.getInstance(props, null);

                MimeMessage message = new MimeMessage(session);
                message.setSentDate(new java.util.Date());
                message.setSubject(template.getTitle());
                message.setFrom(new InternetAddress(emailAccount.getEmailAccount()));

                MimeMultipart multipart = new MimeMultipart("related");
                BodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setContent(content, "text/html;charset=utf-8");
                multipart.addBodyPart(messageBodyPart);
                message.setContent(multipart);
                SMTPTransport transport = (SMTPTransport) session.getTransport("smtps");
                transport.connect(emailAccount.getEmailSmtp(), emailAccount.getEmailAccount(), emailAccount.getPassword());

                for (EmailDetail emailDetail : sendList) {
                    if (emailDetail.getStatusSend().equals("đang gửi...")) {
                        String sendStatus = "success";
                        try {
                            sendEmailSSl(transport, message, emailDetail.getEmailAddress());

                        } catch (Exception e) {
                            sendStatus = "fail";
                            getLogger().log(Level.WARNING, "Error while send email ssl" + emailDetail.getEmailAddress(), e.getMessage());
                        }
                        // save send email
                        SendEmail sendEmail = new SendEmail();
                        sendEmail.setSendEmailId(getSequenceValue().getSequenceValueItem(SendEmail.class));
                        sendEmail.setEmailFrom(emailAccount.getEmailAccount());
                        sendEmail.setEmailTo(emailDetail.getEmailAddress());
                        sendEmail.setTemplateId(template.getTemplateId());
                        sendEmail.setSubject(template.getTitle());
                        sendEmail.setContent(content);
                        sendEmail.setStatusId(sendStatus);
                        sendEmail.setFileId(emailDetail.getFile().getFileId());
                        sendEmail.setCreateTime(new Timestamp(new Date().getTime()));
                        getEmailController().saveSendEmail(sendEmail);
                        emailDetail.setQualitySend(emailDetail.getQualitySend() + 1);
                        emailDetail.setStatusSend(sendStatus);
                        emailDetail.setDateSendEnd(sendEmail.getCreateTime());
                        getEmailDetailsCompile().add(emailDetail);
                    }
                    try {
                        Thread.sleep(timeSend);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
                transport.close();
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onChangeFilter() {
        emailDetailListFilter = new ArrayList<EmailDetail>();
        for (EmailDetail emailDetail : getEmailDetailList()) {
            if (fileFilter.equals("0")) {
                //check đã gửi
                if (statusSend.equals("a")) {
                    emailDetailListFilter.add(emailDetail);
                } else if (statusSend.equals("-1")) {
                    if (emailDetail.getQualitySend() > 0) {
                        emailDetailListFilter.add(emailDetail);
                    }
                } else if (statusSend.equals("s")) {
                    if (emailDetail.getStatusSend().equals("đang gửi...")) {
                        emailDetailListFilter.add(emailDetail);
                    }
                } else if (statusSend.equals("n")) {
                    if (emailDetail.getQualitySend() > 3)
                        emailDetailListFilter.add(emailDetail);
                } else if (String.valueOf(emailDetail.getQualitySend()).equals(statusSend)) {
                    emailDetailListFilter.add(emailDetail);
                }

            } else if (emailDetail.getFile().getFileId().equals(fileFilter)) {
                //check đã gửi
                if (statusSend.equals("a")) {
                    emailDetailListFilter.add(emailDetail);
                } else if (statusSend.equals("-1")) {
                    if (emailDetail.getQualitySend() > 0) {
                        emailDetailListFilter.add(emailDetail);
                    }
                } else if (statusSend.equals("s")) {
                    if (emailDetail.getStatusSend().equals("đang gửi...")) {
                        emailDetailListFilter.add(emailDetail);
                    }
                } else if (statusSend.equals("n")) {
                    if (emailDetail.getQualitySend() > 3)
                        emailDetailListFilter.add(emailDetail);
                } else if (String.valueOf(emailDetail.getQualitySend()).equals(statusSend)) {
                    emailDetailListFilter.add(emailDetail);
                }
            }
        }
        if (emailDetailListFilter.size() > emailQuality)
            emailDetailListFilter = emailDetailListFilter.subList(0, emailQuality);
    }

    public void refreshEmailList(){
        onChangeFilter();
        addMessagesInfo(null, "Đã làm mới danh sách!");
    }

    public void selectAllAction() {
        if (selectAllEmail) {
            for (EmailDetail emailDetail : emailDetailListFilter) {
                if (!emailDetail.getStatusSend().equals("đang gửi...")) emailDetail.setSelected(true);
            }
        } else {
            for (EmailDetail emailDetail : emailDetailListFilter) {
                if (!emailDetail.getStatusSend().equals("đang gửi...")) emailDetail.setSelected(false);
            }
        }
    }

    public void ajaxAction() {
    }

    public String templateName(){
        if (null != templateSelected) return getEmailController().getTemplate(templateSelected).getTemplateName();
        return "";
    }

    public void sendEmailNonSSl(Transport transport, MimeMessage message, String toEmail) {
        try {
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            getLogger().log(Level.INFO, "send email " + toEmail + " success!!!!!!!!!!!!!!!!!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public void sendEmailSSl(Transport transport, MimeMessage message, String toEmail) {
        try {
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            getLogger().log(Level.INFO, "send email " + toEmail + " success!!!!!!!!!!!!!!!!!!!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public String ftlParser(HashMap<String, Object> data, String templateFolder, String templateFile) {
        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("UTF-8");
        try {
//            getLogger().log(Level.INFO, "Template path " + templateFolder, templateFolder);
            cfg.setDirectoryForTemplateLoading(new File(templateFolder));
        } catch (IOException e) {
            getLogger().log(Level.WARNING, "Error while setDirectoryForTemplateLoading template", e.getMessage());
        }
        StringWriter out = new StringWriter();
        try {
            cfg.setObjectWrapper(new DefaultObjectWrapper());
            freemarker.template.Template index = cfg.getTemplate(templateFile);
            index.process(data, out);
            out.flush();
        } catch (Exception ex) {
            getLogger().log(Level.WARNING, "Error while parse ftl template", ex.getMessage());
        }
        return out.toString();
    }

    public boolean validateFromMail(String fromMail, String password) {
        boolean valid = true;

        return valid;
    }


    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Upload file ", event.getFile().getFileName() + " thành công.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getTemplateSelected() {
        return templateSelected;
    }

    public void setTemplateSelected(String templateSelected) {
        this.templateSelected = templateSelected;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getCountEmail() {
        return countEmail;
    }

    public void setCountEmail(int countEmail) {
        this.countEmail = countEmail;
    }

    public List<EmailDetail> getEmailDetailList() {
        emailDetailList = emailManagerBean.getEmailList();
        return emailDetailList;
    }

    public void setEmailDetailList(List<EmailDetail> emailDetailList) {
        this.emailDetailList = emailDetailList;
    }

    public List<EmailDetail> getEmailDetailListFilter() {
//        if (null == emailDetailListFilter) {
//
//            emailDetailListFilter = new ArrayList<EmailDetail>();
//            if (getEmailDetailList().size() > emailQuality)
//                emailDetailListFilter = getEmailDetailList().subList(0, emailQuality);
//            else emailDetailListFilter.addAll(getEmailDetailList());
//        }
        onChangeFilter();
        if (getEmailDetailsCompile().size() > 0) {
            for (EmailDetail emailDetail : getEmailDetailsCompile()) {
                emailManagerBean.getEmailDetailHashMap().put(emailDetail.getEmailAddress() + emailDetail.getFile().getFileId(), emailDetail);
            }
            getEmailDetailsCompile().clear();
            onChangeFilter();
            emailManagerBean.onChangeFilter();

        }
        return emailDetailListFilter;
    }

    public void setEmailDetailListFilter(List<EmailDetail> emailDetailListFilter) {
        this.emailDetailListFilter = emailDetailListFilter;
    }

    public String getFileFilter() {
        return fileFilter;
    }

    public void setFileFilter(String fileFilter) {
        this.fileFilter = fileFilter;
    }

    public EmailManagerBean getEmailManagerBean() {
        return emailManagerBean;
    }

    public void setEmailManagerBean(EmailManagerBean emailManagerBean) {
        this.emailManagerBean = emailManagerBean;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public int getTimeSend() {
        return timeSend;
    }

    public void setTimeSend(int timeSend) {
        this.timeSend = timeSend;
    }

    public boolean isSelectAllEmail() {
        return selectAllEmail;
    }

    public void setSelectAllEmail(boolean selectAllEmail) {
        this.selectAllEmail = selectAllEmail;
    }

    public int getEmailQuality() {
        return emailQuality;
    }

    public void setEmailQuality(int emailQuality) {
        this.emailQuality = emailQuality;
    }

    public String getStatusSend() {
        return statusSend;
    }

    public void setStatusSend(String statusSend) {
        this.statusSend = statusSend;
    }

    public String getTemplateFolder() {
        return templateFolder;
    }

    public void setTemplateFolder(String templateFolder) {
        this.templateFolder = templateFolder;
    }

    public int getCountEmailSend() {
        return countEmailSend;
    }

    public void setCountEmailSend(int countEmailSend) {
        this.countEmailSend = countEmailSend;
    }

    public String getTimeExpected() {
        return timeExpected;
    }

    public void setTimeExpected(String timeExpected) {
        this.timeExpected = timeExpected;
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }

    @Override
    public void run() {
        sendEmailInNewThread();

    }
}
