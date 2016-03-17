package tv.news.model;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 12/27/2015
 * Time: 4:12 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public class Tags {
    private String tagsId;
    private String tagsName;
    private String tagsLink;

    public Tags() {
    }

    public String getTagsId() {
        return tagsId;
    }

    public void setTagsId(String tagsId) {
        this.tagsId = tagsId;
    }

    public String getTagsName() {
        return tagsName;
    }

    public void setTagsName(String tagsName) {
        this.tagsName = tagsName;
    }

    public String getTagsLink() {
        return tagsLink;
    }

    public void setTagsLink(String tagsLink) {
        this.tagsLink = tagsLink;
    }
}
