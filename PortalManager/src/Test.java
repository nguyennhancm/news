//import it.sauronsoftware.ftp4j.FTPClient;
//
//import java.io.File;
//
///**
// * Created with IntelliJ IDEA.
// * User: NTD
// * Date: 6/23/2015
// * Time: 11:36 PM
// * Long Van Soft Solution JSC
// * To change this template use File | Settings | File Templates.
// */
//public class Test {
//    public static void main(String[] args) {
//                /* Check for input data */
////        if (args.length != 3) {
////            System.err.println("Usage: java FTP_FileUpload " + "<IpAddress> <UserName> <Password>");
////            System.err.println("Example: java FTP_FileUpload 1.2.3.4 other other");
////            System.exit(1);
////        }
//
//        // Assignment
//        String ipAddress = "103.27.237.24";
////        String userName = args[1];
////        String password = args[2];
////
////        System.out.println("Ip Address = " + ipAddress);
////        System.out.println("User = " + userName);
////        System.out.println("Pass = " + password);
//
//        // FTP Program operations start from here
//        FTPClient client = new FTPClient();
//        try {
//            // Get the FTP Connection from the Utility class
//            client.connect(ipAddress, 22);
//            client.login("admin", "ztpn015");
//
//            if (client != null) {
//                try {
//                    //Define the File with complete path to be uploaded
//                    String filePath = "sample.tar";
//                    File fileUpload = new File(filePath);
//                    System.out.println("Uploading the " + filePath + " to Remote Machine");
//
//                    //Upload the file
//                    client.upload(fileUpload);
//                    System.out.println("Successfully Uploaded the " + filePath + " File to Remote Machine");
//                } catch (Exception e) {
//                    System.err.println("ERROR : Error in Transfering File to Remote Machine");
//                    System.exit(3);
//                }
//            }
//        } catch (Exception e) {
//            System.err.println("ERROR : Error in Connecting to Remote Machine");
//            System.exit(1);
//        } finally {
//            if (client != null) {
//                try {
//                    client.disconnect(true);
//                } catch (Exception e) {
//                    System.err.println("ERROR : Error in disconnecting the Remote Machine");
//                }
//            }
//        }
//        System.exit(0);
//    }
//}
