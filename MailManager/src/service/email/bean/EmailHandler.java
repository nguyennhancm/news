package service.email.bean;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 9/22/2015
 * Time: 4:22 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public class EmailHandler implements Serializable {
    private Logger logger = Logger.getLogger(getClass().getName());
    private Session mailSession;
    private String defaultTemplateFolder = "/template";
    private String defaultOutputEmailContent = "text/html;charset=utf-8";

    private String defaultTemplateFile = ".ftl";

    public void lookupMail(String jndi) {
        try {
            if (null == mailSession) mailSession = (Session) new InitialContext().lookup(jndi);
        } catch (NamingException ex) {
            logger.log(Level.WARNING, "Lookup Mail JNDI Error", ex);
        }
    }

    public void sendEmail(String jndi, String from, String recipient, String subject, String content, Date sendDate) {
        lookupMail(jndi);
        try {
            MimeMessage message = new MimeMessage(mailSession);
            Address f = new InternetAddress(from);
            Address t = new InternetAddress(recipient);
            message.setFrom(f);
            message.setRecipient(Message.RecipientType.TO, t);
            message.setSentDate(sendDate);
            message.setSubject(subject, "UTF-8");
            message.setContent(content, defaultOutputEmailContent);
            Transport.send(message);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Something Error in mail", ex);
        }
    }

    public String ftlParser(String template, HashMap<String, Object> data) {
        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("UTF-8");
        cfg.setClassForTemplateLoading(getClass(), defaultTemplateFolder);
        StringWriter out = new StringWriter();
        try {
            cfg.setObjectWrapper(new DefaultObjectWrapper());
            Template index = cfg.getTemplate(template + defaultTemplateFile);
            index.process(data, out);
            out.flush();
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Error while parse ftl template", ex);
        }
        return out.toString();
    }

    public String getDefaultTemplateFolder() {
        return defaultTemplateFolder;
    }

    public void setDefaultTemplateFolder(String defaultTemplateFolder) {
        this.defaultTemplateFolder = defaultTemplateFolder;
    }

    public String getDefaultOutputEmailContent() {
        return defaultOutputEmailContent;
    }

    public void setDefaultOutputEmailContent(String defaultOutputEmailContent) {
        this.defaultOutputEmailContent = defaultOutputEmailContent;
    }

    public String getDefaultTemplateFile() {
        return defaultTemplateFile;
    }

    public void setDefaultTemplateFile(String defaultTemplateFile) {
        this.defaultTemplateFile = defaultTemplateFile;
    }
}
