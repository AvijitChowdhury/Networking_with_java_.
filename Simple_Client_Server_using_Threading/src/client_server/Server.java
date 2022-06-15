package client_server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(22222);
        System.out.println("Server Started................");

        while(true) {

            Socket socket = serverSocket.accept();
            System.out.println("Client Connected.............");

            //new server thread
            new ServerThread(socket);


        }
    }
}

class ServerThread implements  Runnable{
    Socket clientSocket;
    Thread t;

    ServerThread(Socket  clientSocket){
        this.clientSocket = clientSocket;
        t  = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            while(true) {
                //read from client
                Object clientMessage = ois.readObject();
                if(clientMessage==null){
                    break;
                }
                System.out.println("From Client: " + (String) clientMessage);

                String serverMessage = (String) clientMessage;
                serverMessage = serverMessage.toUpperCase();

                //send to client
                oos.writeObject(serverMessage);
            }   } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}