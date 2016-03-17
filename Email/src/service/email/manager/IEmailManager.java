package service.email.manager;

import service.email.entities.*;

import service.email.entities.File;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 9/25/2015
 * Time: 7:43 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public interface IEmailManager {

    public Email saveEmail(Email email);

    public User saveUser(User user);

    public EmailAccount saveEmailAccount(EmailAccount emailAccount);

    public File saveFile(File file);

    public Template saveTemplate(Template template);

    public SendEmail saveSendEmail(SendEmail sendEmail);

    public Email getEmail(String emailId);

    public File getFile(String fileId);

    public EmailAccount getEmailAccount(String emailAccountId, String userId);

    public Template getTemplate(String templateId);

    public List<File> getAllFileByUser(String userId);

    public List<Email> getEmailByFile(String file_Id);

    public List<Template> getTemplateByUser(String userId);

    public List<EmailAccount> getEmailAccountByUser(String userId);

    public List<SendEmail> getSendEmailByEmailAccount(String emailAccountId);

    public List<SendEmail> getSendEmailByEmail(String emailId);

    public List<SendEmail> getSendEmailByTemplate(String templateId);

    public List<SendEmail> getCountEmailSend(String emailId, String fileId);

    public boolean deleteEmail(String emailAddress, String fileId);

    public boolean deleteFile(String fileId);
}
