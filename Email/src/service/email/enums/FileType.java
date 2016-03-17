package service.email.enums;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 8/27/2015
 * Time: 10:19 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public enum FileType {
    EXCEL("EXCEL"),
    TXT("TXT");
    private String value;

    private FileType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
