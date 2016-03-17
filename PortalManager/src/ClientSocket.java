/**
 * Created with IntelliJ IDEA.
 * User: NTD
 * Date: 6/13/2015
 * Time: 9:56 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
// Client Side


public class ClientSocket {

//    public void run() {
//        try {
//            int serverPort = 6996;
//            InetAddress host = InetAddress.getByName("localhost");
//            System.out.println("Connecting to server on port " + serverPort);
//
//            Socket socket = new Socket(host, serverPort);
//            //Socket socket = new Socket("127.0.0.1", serverPort);
//            System.out.println("Just connected to " + socket.getRemoteSocketAddress());
//            PrintWriter toServer =
//                    new PrintWriter(socket.getOutputStream(), true);
//            BufferedReader fromServer =
//                    new BufferedReader(
//                            new InputStreamReader(socket.getInputStream()));
//            toServer.println("Hello from " + socket.getLocalSocketAddress());
//            String line = fromServer.readLine();
//            System.out.println("Client received: " + line + " from Server");
//
//
//            OutputStream os = socket.getOutputStream();
//            ObjectOutputStream oos = new ObjectOutputStream(os);
//            InputStream is = socket.getInputStream();
//            ObjectInputStream ois = new ObjectInputStream(is);
//
//            oos.writeObject(new String("Chào server tôi gửi cho bạn một data nhé!"));
//            oos.writeObject(new Integer(1));
//            oos.writeObject(new StoreData(2, 2000));
//
//            oos.close();
//            os.close();
//            socket.close();
//
//            toServer.close();
//            fromServer.close();
//            socket.close();
//
//        } catch (UnknownHostException ex) {
//            ex.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        ClientSocket client = new ClientSocket();
//        client.run();
//    }
}