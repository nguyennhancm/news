package service.email;

import com.sun.mail.smtp.SMTPTransport;

import javax.faces.bean.ManagedBean;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 10/4/2015
 * Time: 7:23 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "TestSendEmail")
public class TestSendEmail {
    public String sendEmailOther() {
        final String username = "info@phucankid.com";
        final String password = "huydung";

        try {
            Properties props = System.getProperties();
//            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.host", "mail.phucankid.com");
            props.put("mail.smtp.auth", "true");

            Session mailSession = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            mailSession.setDebug(true);
            Transport transport = mailSession.getTransport("smtp");
            MimeMessage message = new MimeMessage(mailSession);
            message.setSentDate(new java.util.Date());
            message.setSubject("Hi Test");
            message.setFrom(new InternetAddress(username));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("nguyenvannhan@lvsolution.vn"));
            MimeMultipart multipart = new MimeMultipart("related");
// first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent("Hi test", "text/html");
// add it
            multipart.addBodyPart(messageBodyPart);
// put everything together
            message.setContent(multipart);

            transport.connect("mail.phucankid.com", username, password);
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transport.close();
            System.out.println("send email success");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    public String sendGmail() {
        final String username = "nguyennnhancm@gmail.com";
        final String password = "123456";

        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        Properties props = new Properties();
        props.setProperty("mail.smtps.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.setProperty("mail.smtps.auth", "true");

        props.put("mail.smtps.quitwait", "false");

        Session session = Session.getInstance(props, null);

        try {

            // -- Create a new message --
            final MimeMessage msg = new MimeMessage(session);

            // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress(username));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("nguyennhancm@gmail.com", false));
            msg.setSubject("Test");
            msg.setText("Test", "utf-8");
            msg.setSentDate(new Date());

            SMTPTransport t = (SMTPTransport) session.getTransport("smtps");

            t.connect("smtp.gmail.com", username, password);
            t.sendMessage(msg, msg.getAllRecipients());
            t.close();
            System.out.println("send email success");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

//    public static void main(String[] args){
//        System.out.println(20/60);
//    }
}
