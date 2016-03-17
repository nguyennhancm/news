package service.email.bean;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import service.email.entities.Template;
import service.ultils.BaseEmailBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 10/5/2015
 * Time: 9:21 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@SessionScoped
@ManagedBean(name = "TemplateManager")
public class TemplateManagerBean extends BaseEmailBean {
    private List<Template> templateList;
    private String templateName;
    private String title;
    private String fileTemplatePath = System.getProperty("email.template.upload") + "/" + defaultUserId + "/";

    public void handleFileUpload(FileUploadEvent event) {
        UploadedFile file = event.getFile();
        String fileName = file.getFileName();
        if (fileName.endsWith(".ftl") || fileName.endsWith(".html")) {
            String fileName1 = saveFileToStorage(file, fileTemplatePath);
            String  fileNameNew = "";
            if (fileName1.endsWith(".html")){
                try {
                    File oldFile = new File(fileTemplatePath + fileName1);
                    File file1 = new File(fileTemplatePath + fileNameNew);
                    oldFile.renameTo(file1);
                } catch (Exception e) {
                    addValidateError(null, "Có lỗi xãy ra khi upload template" + templateName);
                }
                fileNameNew = fileName1.split(".html")[0] + ".ftl";
            }else {fileNameNew = fileName1;}
            Template template = new Template();
            template.setTemplateId(getSequenceValue().getSequenceValueItem(Template.class));
            template.setUserId(defaultUserId);
            template.setTemplateName(templateName);
            template.setFileName(fileNameNew);
            template.setCreateTime(new Timestamp(new Date().getTime()));
            template.setUpdateTime(new Timestamp(new Date().getTime()));
            getEmailController().saveTemplate(template);
            getTemplateList().add(template);
            addMessagesInfo(null, "Đã thêm tempale " + templateName);
        }
    }


    public List<Template> getTemplateList() {
        if (null == templateList) templateList = getEmailController().getTemplateByUser(defaultUserId);
        return templateList;
    }

    public void setTemplateList(List<Template> templateList) {
        this.templateList = templateList;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }
}
