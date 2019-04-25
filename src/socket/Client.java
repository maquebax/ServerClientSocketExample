package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    DataInputStream in;
    DataOutputStream out;
    Socket socket;

    Client(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("client created");
            in = new DataInputStream(System.in);
            out = new DataOutputStream( socket.getOutputStream());
            String line = "";
            while (!line.equalsIgnoreCase("Over")) {
                line = in.readLine();
                out.writeUTF(line);
            }


        } catch (IOException e) {
        System.out.println("eeeeeee   "+e.getMessage());
        }
    }
public static  void main(String arg[]){
        Client client  = new Client("127.0.0.1",5000);
    }


}
