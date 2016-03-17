package service.email.bean;

import org.apache.commons.validator.GenericValidator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import service.email.entities.Email;
import service.email.entities.File;
import service.email.model.EmailDetail;
import service.ultils.BaseEmailBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 9/22/2015
 * Time: 4:22 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "FileUploadView")
@SessionScoped
public class FileUploadView extends BaseEmailBean {
    private List<Email> emailList;
    private List<File> fileList;
    private StreamedContent fileExcel;

    @ManagedProperty(value = "#{EmailManager}")
    EmailManagerBean emailManagerBean;

    public StreamedContent getFileExcel() {
        if (null == fileExcel) {
            InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/file_samples/email_file_sample.xls");
            fileExcel = new DefaultStreamedContent(stream, "application/xls", "email_file_sample.xls");
        }
        return fileExcel;
    }


    public void handleFileUpload(FileUploadEvent event) {
        UploadedFile file = event.getFile();
        String fileName = file.getFileName();
        if (fileName.endsWith(".xls") || fileName.endsWith(".xlsx")) {
            emailList = new ArrayList<Email>();
            getEmailList().addAll(getEmailFromFileExcel(file));
        } else if (fileName.endsWith(".txt")) {
            //
        }
        if (emailList.size() > 0) {
            String fileName1 = saveFileToStorage(file, fileEmailPath);
            File file1 = saveFile(fileName1);
            for (Email email : emailList) {
                email.setFileId(file1.getFileId());
                email.setCreateTime(new Timestamp(new Date().getTime()));
                getEmailController().saveEmail(email);
                EmailDetail emailDetail = new EmailDetail();
                emailDetail.setEmailAddress(email.getEmailAddress());
                emailDetail.setFile(file1);
                emailDetail.setSelected(true);
                emailDetail.setQualitySend(0);
                //add email detail list by file
                emailManagerBean.getEmailDetailHashMap().put(emailDetail.getEmailAddress() + emailDetail.getFile().getFileId(), emailDetail);
            }
            emailManagerBean.onChangeFilter();
            fileList.add(file1);
            emailManagerBean.reloadFile();
            addMessagesInfo(null, "Đã thêm file " + fileName1 + " và " + emailList.size() + " email vào hệ thống!");

        } else {
            //khong co email nao
            addValidateError(null, "Không tìm thấy email nào trong file " + fileName);
        }
    }

    public File saveFile(String fileName) {
        File file = new File();
        file.setFileId(getSequenceValue().getSequenceValueItem(File.class));
        file.setFileTypeId("excel");
        file.setFileName(fileName);
        file.setUserId(defaultUserId);
        file.setCreateTime(new Timestamp(new Date().getTime()));
        getEmailController().saveFile(file);
        return file;
    }

    public List<Email> getEmailFromFileExcel(UploadedFile file) {
        List<Email> emails = new ArrayList<Email>();
        try {
            InputStream fileInputStream = file.getInputstream();
            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet sheet = workbook.getSheet("Sheet1");
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {
                Row row = (Row) rowIterator.next();
                Cell emailAddress = row.getCell(0);
                //validate email
                String emailS = cellToString(emailAddress).trim();
                if (GenericValidator.isEmail(emailS) && emailS.length() < 255) {
                    Cell emailName = row.getCell(1);
                    Cell postalAddress = row.getCell(2);
                    Cell phoneNumber = row.getCell(3);
                    Email email = new Email();
                    email.setEmailAddress(emailS);
                    if (null != cellToString(emailName)&& !cellToString(emailName).equals("")) email.setEmailName(cellToString(emailName));
                    if (null != cellToString(postalAddress) && !cellToString(postalAddress).equals("")) email.setPostalAddress(cellToString(postalAddress));
                    if (null != cellToString(phoneNumber) && !cellToString(phoneNumber).equals("")) email.setPhoneNumber(cellToString(phoneNumber));
                    emails.add(email);
                }
            }
        }catch (IOException e) {
            addValidateError(null, "Có lỗi khi đọc file " + file.getFileName() + " , Vui lòng kiểm tra và Upload lại!");
            getLogger().log(Level.WARNING, "file " + file.getFileName() + " wrong format!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        return emails;

    }

    public String cellToString(Cell cell) {
        int type;
        Object result = new Object();
        if (null != cell) {
            type = cell.getCellType();
            switch (type) {

                case 0: // numeric value in Excel
                    result = cell.getNumericCellValue();
                    String str = result.toString();
                    for (int i = 0; i < 20; i++) {
                        if (str.endsWith("E" + i) || str.endsWith("e" + i)) {
                            str = str.replace("E" + i, "");
                            str = str.replace("e" + i, "");
                        }
                    }
                    result = str;
                    break;
                case 1: // String Value in Excel
                    result = cell.getStringCellValue();
                    break;
                default:
                    result = "";
            }
        }
        return result.toString();
    }

    public List<Email> getEmailList() {
        if (null == emailList) emailList = new ArrayList<Email>();
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

    public List<File> getFileList() {
        if (null == fileList){
            fileList = getEmailController().getAllFileByUser(defaultUserId);
            if (null == fileList) fileList = new ArrayList<File>();
        }
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public EmailManagerBean getEmailManagerBean() {
        return emailManagerBean;
    }

    public void setEmailManagerBean(EmailManagerBean emailManagerBean) {
        this.emailManagerBean = emailManagerBean;
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }
}
