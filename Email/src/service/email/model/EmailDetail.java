package service.email.model;

import service.email.entities.File;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 9/23/2015
 * Time: 6:54 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public class EmailDetail {
    private String emailAddress;
    private File file;
    private String statusSend = "";
    private int qualitySend;
    private Date dateSendEnd;
    private boolean selected;
    private List<String> accountSend;
    private List<String> templateSend;

    public EmailDetail() {
    }

    public EmailDetail(EmailDetail emailDetail) {
        this.emailAddress = emailDetail.emailAddress;
        this.file = emailDetail.file;
        this.statusSend = emailDetail.statusSend;
        this.qualitySend = emailDetail.qualitySend;
        this.dateSendEnd = emailDetail.dateSendEnd;
        this.selected = emailDetail.selected;
        this.accountSend = emailDetail.accountSend;
        this.templateSend = emailDetail.templateSend;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getStatusSend() {
        return statusSend;
    }

    public void setStatusSend(String statusSend) {
        this.statusSend = statusSend;
    }

    public int getQualitySend() {
        return qualitySend;
    }

    public void setQualitySend(int qualitySend) {
        this.qualitySend = qualitySend;
    }

    public Date getDateSendEnd() {
        return dateSendEnd;
    }

    public void setDateSendEnd(Date dateSendEnd) {
        this.dateSendEnd = dateSendEnd;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public List<String> getAccountSend() {
        return accountSend;
    }

    public void setAccountSend(List<String> accountSend) {
        this.accountSend = accountSend;
    }

    public List<String> getTemplateSend() {
        return templateSend;
    }

    public void setTemplateSend(List<String> templateSend) {
        this.templateSend = templateSend;
    }
}
