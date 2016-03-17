package service.email.enums;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 8/27/2015
 * Time: 10:19 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public enum JndiEmail {
    GMAIL("java:/GmailMailService"),
    YAHOO("java:/YahooMailService"),
    HOTMAIL("java:/HotMailService"),
    AOL("java:/aolMailService"),
    GMX("java:/gmxMailService"),
    PHUCANKID("java:/java:/PhucAnKidMailService");

    private String value;

    private JndiEmail(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
