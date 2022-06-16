package client_server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args)throws IOException {
        System.out.println("Cilent started : ");
        Socket socket =  new Socket("127.0.0.1",22222);
        System.out.println("Client Connected...........");

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream oois = new ObjectInputStream(socket.getInputStream());

        Scanner sc = new Scanner(System.in);

        new ReaderThread(oois, "client1");
        new WriterThread(oos, "client1");
//        while(true) {
//            String message = sc.nextLine();
//            if(message.equals("exits")){
//                break;
//            }
//            //send to server
//            oos.writeObject(message);
//            new ReaderThread(oois, "client1");
//
//        }
       // socket.close();
    }

}