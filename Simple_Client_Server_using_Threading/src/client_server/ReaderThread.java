package client_server;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ReaderThread implements  Runnable{

    ObjectInputStream ois;
    String name;

    ReaderThread(ObjectInputStream ois, String name){
        this.ois= ois;
        this.name = name;
        new Thread(this).start();
    }
    @Override
    public void run() {
        try {
            //recieve from server
            Object fromServer = ois.readObject();
            System.out.println(name + "From Server: " + (String) "recieved");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
