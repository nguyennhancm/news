package service.email.manager.impl;

import service.email.entities.*;
import service.email.manager.IEmailManager;
import service.email.utils.manager.BaseManager;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 9/25/2015
 * Time: 7:43 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "EmailManager")
public class EmailManager extends BaseManager implements IEmailManager {

    @Override
    public Email saveEmail(Email email) {
        return getEntityManager().merge(email);
    }

    @Override
    public User saveUser(User user) {
        return getEntityManager().merge(user);
    }

    @Override
    public EmailAccount saveEmailAccount(EmailAccount emailAccount) {
        return getEntityManager().merge(emailAccount);
    }

    @Override
    public File saveFile(File file) {
        return getEntityManager().merge(file);
    }

    @Override
    public Template saveTemplate(Template template) {
        return getEntityManager().merge(template);
    }

    @Override
    public SendEmail saveSendEmail(SendEmail sendEmail) {
        return getEntityManager().merge(sendEmail);
    }

    @Override
    public Email getEmail(String emailId) {
        return getEntityManager().find(Email.class, emailId);
    }

    @Override
    public File getFile(String fileId) {
        return getEntityManager().find(File.class, fileId);
    }

    @Override
    public EmailAccount getEmailAccount(String emailAccountId, String userId) {
        Query query = getEntityManager().createQuery("select a from EmailAccount a where a.emailAccount=:emailAccountId " +
                "and a.userId=:userId");
        query.setParameter("emailAccountId", emailAccountId);
        query.setParameter("userId", userId);
        EmailAccount emailAccount = (EmailAccount) query.getResultList().get(0);
        return emailAccount;
    }

    @Override
    public Template getTemplate(String templateId) {
        return getEntityManager().find(Template.class, templateId);
    }

    @Override
    public List<File> getAllFileByUser(String userId) {
        Query query = getEntityManager().createQuery("select f from File f where f.userId=:userId and f.statusId is NULL ");
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Email> getEmailByFile(String fileId) {
        Query query = getEntityManager().createQuery("select e from Email e where e.fileId=:fileId and e.statusId is NULL");
        query.setParameter("fileId", fileId);
        return query.getResultList();
    }

    @Override
    public List<Template> getTemplateByUser(String userId) {
        Query query = getEntityManager().createQuery("select t from Template t where t.userId=:userId and t.statusId is NULL");
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<EmailAccount> getEmailAccountByUser(String userId) {
        Query query = getEntityManager().createQuery("select a from EmailAccount a where a.userId=:userId and a.statusId is NULL ");
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<SendEmail> getSendEmailByEmailAccount(String emailFrom) {
        Query query = getEntityManager().createQuery("select s from SendEmail s where s.emailFrom=:emailFrom");
        query.setParameter("emailFrom", emailFrom);
        return query.getResultList();
    }

    @Override
    public List<SendEmail> getSendEmailByEmail(String emailTo) {
        Query query = getEntityManager().createQuery("select s from SendEmail s where s.emailTo=:emailTo");
        query.setParameter("emailTo", emailTo);
        return query.getResultList();
    }

    @Override
    public List<SendEmail> getSendEmailByTemplate(String templateId) {
        Query query = getEntityManager().createQuery("select s from SendEmail s where s.templateId=:templateId");
        query.setParameter("templateId", templateId);
        return query.getResultList();
    }

    @Override
    public List<SendEmail> getCountEmailSend(String emailId, String fileId) {
        Query query = getEntityManager().createQuery("select s from SendEmail s where s.emailTo=:emailId and s.fileId=:fileId order by s.createTime DESC ");
        query.setParameter("emailId", emailId);
        query.setParameter("fileId", fileId);
        List<SendEmail> sendEmails = query.getResultList();
        if (null == sendEmails) sendEmails = new ArrayList<SendEmail>();
        return sendEmails;
    }

    @Override
    public boolean deleteEmail(String emailAddress, String fileId) {
        Query query = getEntityManager().createQuery("update Email e set e.statusId='deleted' where e.emailAddress=:emailAddress and e.fileId=:fileId");
        query.setParameter("emailAddress",emailAddress);
        query.setParameter("fileId",fileId);
        if (query.executeUpdate()>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFile(String fileId) {
        Query query = getEntityManager().createQuery("update File f set f.statusId='deleted' where f.fileId=:fileId");
        query.setParameter("fileId",fileId);
        if (query.executeUpdate()>0){
            return true;
        }
        return false;
    }
}
