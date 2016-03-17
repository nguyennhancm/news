package tv.news.enums;

/**
 * Created with IntelliJ IDEA.
 * User: NTD
 * Date: 6/26/2015
 * Time: 2:33 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public enum CategoryType {
    CATALOG_CATEGORY("CATALOG_CATEGORY"),
    TAGS_CATEGORY("TAGS_CATEGORY"),
    VIDEO_CATEGORY("VIDEO_CATEGORY"),
    ALBUM_CATEGORY("ALBUM_CATEGORY"),
    SLIDE_CATEGORY("SLIDE_CATEGORY");
    private String value;

    private CategoryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
