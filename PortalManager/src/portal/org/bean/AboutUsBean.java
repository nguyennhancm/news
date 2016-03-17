package portal.org.bean;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import portal.news.bean.NewsManagerBean;
import portal.utils.BasePortalBean;
import portal.utils.UnicodeUtils;
import tv.user.entities.Party;
import tv.user.entities.PartyAttribute;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/10/2015
 * Time: 2:05 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@SessionScoped
@ManagedBean(name = "AboutUs")
public class AboutUsBean extends BasePortalBean {
    private Party party;
    private List<PartyAttribute> imagesList;
    private int sequenceImage = 0;

    @ManagedProperty(value = "#{NewsManager}")
    private NewsManagerBean newsManagerBean;

    public String updateInfo() {
        getUserController().save(party);
        for (PartyAttribute image: getImagesList()){
            getUserController().save(image);
        }
        newsManagerBean.getUserData().getOrganizationData().setParty(party);
        newsManagerBean.getUserData().getOrganizationData().setImagesList(imagesList);
        addMessagesInfo(null, " Cập nhật thông tin thành công!");
        return "";
    }


    public String removeImage(PartyAttribute image) {
        for (PartyAttribute ima : imagesList) {
            if (ima.getAttrName().equals(image.getAttrName())) {
                imagesList.remove(ima);
                return "";
            }
        }
        return "";
    }

    public boolean validateImage(UploadedFile file) {
        if (file == null || file.getContentType().indexOf("image") < 0) {
            addMessagesInfo(null, "Cập nhật hình ảnh: tập tin" + file.getFileName() + " không hợp lệ");
            return false;
        }
        return true;
    }

    public synchronized void handleFileUpload(FileUploadEvent event) {
        handleFileUpload(event, false);

    }

    public void handleFileUpload(FileUploadEvent event, boolean uploadToPublicServer) {

        UploadedFile file = event.getFile();
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
            java.io.File outFile = new java.io.File(getImageRootPath() + "/" + getParty().getPartyId() + "/" + fileName + "." + prefix);
            if (outFile.exists()) {
                fileName = fileName + "_" + new Timestamp(new Date().getTime()).toString().replace(":", "-").replace(" ", "_");
                outFile = new java.io.File(getImageRootPath() + "/" + getParty().getPartyId() + "/" + fileName + "." + prefix);
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
            ///////////////////////
            getSequenceImage();
            PartyAttribute imageAttribute = new PartyAttribute();
            imageAttribute.setPartyId(getParty().getPartyId());
            imageAttribute.setAttrName(String.valueOf(++sequenceImage) + "_PARTY_IMAGE");
            imageAttribute.setAttrValue(fileName + "." + prefix);
            getImagesList().add(imageAttribute);

        } catch (Exception e) {
            getLogger().warning(e.getMessage());
        }
    }

    public String getImageRootPath() {
        return System.getProperty("news.upload.images.original");
    }

    public Party getParty() {
        if (null == party){
            party = newsManagerBean.getUserData().getOrganizationData().getParty();
        }
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public int getSequenceImage() {
        if (sequenceImage == -1) {
            int max = 0;
            for (PartyAttribute image : getImagesList()) {
                int seq = Integer.valueOf(image.getAttrName().split("_")[0]);
                if (seq > max) {
                    max = seq;
                }
            }
            sequenceImage = max;
        }
        return sequenceImage;
    }

    public NewsManagerBean getNewsManagerBean() {
        return newsManagerBean;
    }

    public void setNewsManagerBean(NewsManagerBean newsManagerBean) {
        this.newsManagerBean = newsManagerBean;
    }

    public List<PartyAttribute> getImagesList() {
        if (null == imagesList){
            imagesList = newsManagerBean.getUserData().getOrganizationData().getImagesList();
        }
        return imagesList;
    }

    public void setImagesList(List<PartyAttribute> imagesList) {
        this.imagesList = imagesList;
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }
}
