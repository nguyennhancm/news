package service.email.bean;

import org.apache.commons.validator.GenericValidator;
import org.primefaces.context.RequestContext;
import service.email.entities.Email;
import service.email.entities.File;
import service.email.model.EmailDetail;
import service.ultils.BaseEmailBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 10/2/2015
 * Time: 2:26 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "EmailManager")
@SessionScoped
public class EmailManagerBean extends BaseEmailBean {
    private HashMap<String, EmailDetail> emailDetailHashMap;
    private List<EmailDetail> emailList;
    private List<EmailDetail> emailDetailListFilter;
    private List<File> fileList;
    private String fileFilter = "0";
    private int emailQuality = 50;
    private String statusSend = "a";
    private boolean selectAllEmail = true;
    private File fileDelete;
    private String addEmailAddress;
    private String addEmailName;
    private String addAddress;
    private String addPhone;


    public void deleteEmail() {
        int countEmailDelete = 0;
        for (EmailDetail emailDetail : getEmailDetailListFilter()) {
            if (emailDetail.isSelected()) {
                boolean del = getEmailController().deleteEmail(emailDetail.getEmailAddress(), emailDetail.getFile().getFileId());
                if (del) getEmailDetailHashMap().remove(emailDetail.getEmailAddress() + emailDetail.getFile().getFileId());
                countEmailDelete++;
            }
        }
        if (countEmailDelete > 0) {
            onChangeFilter();
            addMessagesInfo(null, "Đã xóa " + countEmailDelete + " email!");
        } else {
            addValidateError(null, "Không có email được chọn!!");
        }
    }

    public void deleteFile(){
        if (getEmailController().deleteFile(fileDelete.getFileId())){
            int countEmailDeleted = 0;
            for (EmailDetail emailDetail : getEmailController().getEmailByFile(fileDelete.getFileId())) {
                emailDetailHashMap.remove(emailDetail.getEmailAddress() + emailDetail.getFile().getFileId());
                countEmailDeleted++;
            }
            java.io.File oldFile = new java.io.File(fileEmailPath + "/" + fileDelete.getFileName());
            java.io.File file = new java.io.File(fileEmailPath + "/deleted_" + fileDelete.getFileName());
            if (oldFile.renameTo(file)) {
            }
            onChangeFilter();
            reloadFile();
            addMessagesInfo(null, "Đã xóa file " + fileDelete.getFileName() + " và " + countEmailDeleted + " Email!!!");
        }


    }

    public void reloadFile(){
        fileList = getEmailController().getAllFileByUser(defaultUserId);
    }


    public void addEmail(){
        if (GenericValidator.isEmail(addEmailAddress)){
            Email email = new Email();
            email.setEmailAddress(addEmailAddress);
            //
            email.setFileId("150930");
            email.setCreateTime(new Timestamp(new Date().getTime()));
            getEmailController().saveEmail(email);
            EmailDetail emailDetail = new EmailDetail();
            emailDetail.setEmailAddress(email.getEmailAddress());
            emailDetail.setFile(getEmailController().getFile("150930"));
            emailDetail.setSelected(true);
            emailDetailHashMap.put(emailDetail.getEmailAddress() + emailDetail.getFile().getFileId(), emailDetail);
            onChangeFilter();
            RequestContext.getCurrentInstance().execute("PF('addEmailW').hide();");
            addMessagesInfo(null, "Đã thêm email +" + emailDetail.getEmailAddress());
        }else {
            addValidateError("messages1", "Vui lòng nhập email!!");
        }
    }

    public void onChangeFilter() {
        emailDetailListFilter = new ArrayList<EmailDetail>();
        for (EmailDetail emailDetail : getEmailList()) {
            if (fileFilter.equals("0")) {
                //check đã gửi
                if (statusSend.equals("a")) {
                    emailDetailListFilter.add(new EmailDetail(emailDetail));
                } else if (statusSend.equals("-1")) {
                    if (emailDetail.getQualitySend() > 0) {
                        emailDetailListFilter.add(new EmailDetail(emailDetail));
                    }
                } else if (statusSend.equals("s")) {
                    if (emailDetail.getStatusSend().equals("đang gửi...")) {
                        emailDetailListFilter.add(new EmailDetail(emailDetail));
                    }
                } else if (statusSend.equals("n")) {
                    if (emailDetail.getQualitySend() > 3)
                        emailDetailListFilter.add(new EmailDetail(emailDetail));
                } else if (String.valueOf(emailDetail.getQualitySend()).equals(statusSend)) {
                    emailDetailListFilter.add(new EmailDetail(emailDetail));
                }

            } else if (emailDetail.getFile().getFileId().equals(fileFilter)) {
                //check đã gửi
                if (statusSend.equals("a")) {
                    emailDetailListFilter.add(new EmailDetail(emailDetail));
                } else if (statusSend.equals("-1")) {
                    if (emailDetail.getQualitySend() > 0) {
                        emailDetailListFilter.add(new EmailDetail(emailDetail));
                    }
                } else if (statusSend.equals("s")) {
                    if (emailDetail.getStatusSend().equals("đang gửi...")) {
                        emailDetailListFilter.add(new EmailDetail(emailDetail));
                    }
                } else if (statusSend.equals("n")) {
                    if (emailDetail.getQualitySend() > 3)
                        emailDetailListFilter.add(new EmailDetail(emailDetail));
                } else if (String.valueOf(emailDetail.getQualitySend()).equals(statusSend)) {
                    emailDetailListFilter.add(new EmailDetail(emailDetail));
                }
            }
        }
        if (emailDetailListFilter.size() > emailQuality)
            emailDetailListFilter = emailDetailListFilter.subList(0, emailQuality);
    }

    public void refreshEmailList() {
        onChangeFilter();
        addMessagesInfo(null, "Đã làm mới danh sách!");
    }

    public HashMap<String, EmailDetail> getEmailDetailHashMap() {
        if (null == emailDetailHashMap) {
            emailDetailHashMap = new HashMap<String, EmailDetail>();
            for (File file : getFileList()) {
                for (EmailDetail emailDetail : getEmailController().getEmailByFile(file.getFileId())) {
                    emailDetailHashMap.put(emailDetail.getEmailAddress() + emailDetail.getFile().getFileId(), emailDetail);
                }
            }

        }
        return emailDetailHashMap;
    }

    public void setEmailDetailHashMap(HashMap<String, EmailDetail> emailDetailHashMap) {
        this.emailDetailHashMap = emailDetailHashMap;
    }

    public List<EmailDetail> getEmailList() {
        emailList = new ArrayList<EmailDetail>(getEmailDetailHashMap().values());
        return emailList;
    }

    public void setEmailList(List<EmailDetail> emailList) {
        this.emailList = emailList;
    }

    public List<EmailDetail> getEmailDetailListFilter() {
        if (null == emailDetailListFilter) {
            onChangeFilter();
        }
        if (getEmailDetailsCompile().size() > 0) {
            for (EmailDetail emailDetail : getEmailDetailsCompile()) {
                getEmailDetailHashMap().put(emailDetail.getEmailAddress() + emailDetail.getFile().getFileId(), emailDetail);
            }
            onChangeFilter();
        }
        return emailDetailListFilter;
    }

    public void setEmailDetailListFilter(List<EmailDetail> emailDetailListFilter) {
        this.emailDetailListFilter = emailDetailListFilter;
    }

    public List<File> getFileList() {
        if (null == fileList){
            fileList = new ArrayList<File>();
            fileList = getEmailController().getAllFileByUser(defaultUserId);
        }
        return fileList;
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

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public String getFileFilter() {
        return fileFilter;
    }

    public void setFileFilter(String fileFilter) {
        this.fileFilter = fileFilter;
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

    public boolean isSelectAllEmail() {
        return selectAllEmail;
    }

    public void setSelectAllEmail(boolean selectAllEmail) {
        this.selectAllEmail = selectAllEmail;
    }

    public File getFileDelete() {
        return fileDelete;
    }

    public void setFileDelete(File fileDelete) {
        this.fileDelete = fileDelete;
    }

    public String getAddEmailAddress() {
        return addEmailAddress;
    }

    public void setAddEmailAddress(String addEmailAddress) {
        this.addEmailAddress = addEmailAddress;
    }

    public String getAddEmailName() {
        return addEmailName;
    }

    public void setAddEmailName(String addEmailName) {
        this.addEmailName = addEmailName;
    }

    public String getAddAddress() {
        return addAddress;
    }

    public void setAddAddress(String addAddress) {
        this.addAddress = addAddress;
    }

    public String getAddPhone() {
        return addPhone;
    }

    public void setAddPhone(String addPhone) {
        this.addPhone = addPhone;
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }
}
