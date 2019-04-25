package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    DataInputStream in;
    Socket socket;

    Server(int port){
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("server created");
            System.out.println("waiting for client");
            socket = serverSocket.accept();
            System.out.println("client connected");
            in = new DataInputStream(socket.getInputStream());
            String line ="";
            while(!line.equalsIgnoreCase("over")){
                line  = in.readUTF();
                System.out.println("*********"+line);
            }
        }catch (IOException e){

        }
    }

    public static  void main(String[] arg){
        Server server = new Server(5000);
    }
}
