package service.email.controller.impl;

import service.email.controller.IEmailController;
import service.email.entities.*;
import service.email.model.EmailDetail;
import service.email.utils.controller.BaseController;

import service.email.entities.File;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 9/25/2015
 * Time: 7:44 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "EmailController")
public class EmailController extends BaseController implements IEmailController {
    @Override
    public Email saveEmail(Email email) {
        return getEmailManager().saveEmail(email);
    }

    @Override
    public User saveUser(User user) {
        return getEmailManager().saveUser(user);
    }

    @Override
    public EmailAccount saveEmailAccount(EmailAccount emailAccount) {
        return getEmailManager().saveEmailAccount(emailAccount);
    }

    @Override
    public File saveFile(File file) {
        return getEmailManager().saveFile(file);
    }

    @Override
    public Template saveTemplate(Template template) {
        return getEmailManager().saveTemplate(template);
    }

    @Override
    public SendEmail saveSendEmail(SendEmail sendEmail) {
        return getEmailManager().saveSendEmail(sendEmail);
    }

    @Override
    public Email getEmail(String emailId) {
        return getEmailManager().getEmail(emailId);
    }

    @Override
    public EmailAccount getEmailAccount(String emailAccountId, String userId) {
        return getEmailManager().getEmailAccount(emailAccountId, userId);
    }

    @Override
    public Template getTemplate(String templateId) {
        return getEmailManager().getTemplate(templateId);
    }

    @Override
    public List<File> getAllFileByUser(String userId) {
        return getEmailManager().getAllFileByUser(userId);
    }

    @Override
    public List<EmailDetail> getEmailByFile(String file_Id) {
        List<EmailDetail> emailDetailList = new ArrayList<EmailDetail>();
        List<Email> emailList = getEmailManager().getEmailByFile(file_Id);
        if (null != emailList){
            for (Email email: emailList){
                EmailDetail emailDetail = new EmailDetail();
                emailDetail.setEmailAddress(email.getEmailAddress());
                emailDetail.setFile(getEmailManager().getFile(email.getFileId()));
                emailDetail.setSelected(true);
                //Check status email
                List<SendEmail> sendEmails = getEmailManager().getCountEmailSend(email.getEmailAddress(), email.getFileId());
                int count = sendEmails.size();
                if (count >= 1){
                    emailDetail.setQualitySend(count);
                    emailDetail.setDateSendEnd(sendEmails.get(0).getCreateTime());
                    emailDetail.setStatusSend(sendEmails.get(0).getStatusId());
                }
                emailDetailList.add(emailDetail);
            }
        }

        return emailDetailList;
    }

    @Override
    public List<Template> getTemplateByUser(String userId) {
        return getEmailManager().getTemplateByUser(userId);
    }

    @Override
    public List<EmailAccount> getEmailAccountByUser(String userId) {
        return getEmailManager().getEmailAccountByUser(userId);
    }

    @Override
    public List<SendEmail> getSendEmailByEmailAccount(String emailAccountId) {
        return getEmailManager().getSendEmailByEmailAccount(emailAccountId);
    }

    @Override
    public List<SendEmail> getSendEmailByEmail(String emailId) {
        return getEmailManager().getSendEmailByEmail(emailId);
    }

    @Override
    public List<SendEmail> getSendEmailByTemplate(String templateId) {
        return getEmailManager().getSendEmailByTemplate(templateId);
    }

    @Override
    public boolean deleteEmail(String emailAddress, String fileId) {
        return getEmailManager().deleteEmail(emailAddress, fileId);
    }

    @Override
    public boolean deleteFile(String fileId) {
        return getEmailManager().deleteFile(fileId);
    }

    @Override
    public File getFile(String fileId) {
        return getEmailManager().getFile(fileId);
    }
}
