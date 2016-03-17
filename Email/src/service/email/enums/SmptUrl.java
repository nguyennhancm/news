package service.email.enums;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 8/27/2015
 * Time: 10:19 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public enum SmptUrl {
    GMAIL("smtp.gmail.com"),
    YAHOO("smtp.mail.yahoo.com"),
    HOTMAIL("smtp.live.com"),
    AOL("smtp.aol.com"),
    GMX("mail.gmx.com"),
    PHUCANKID("mail.phucankid.com");

    private String value;

    private SmptUrl(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
