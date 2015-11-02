package com.singh.aakash.dbconnector;
import android.os.AsyncTask;
import android.util.Log;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InsertCategory {
    List<String> toBesent;

    public void execute(){
        ConnectToServer connectToServer=new ConnectToServer();
        connectToServer.execute();
    }
    public InsertCategory(String placeId, String category) {
        toBesent=new ArrayList<>();
        toBesent.add(placeId);
        toBesent.add(category);
        toBesent.add("cat");
//        String serverName = "localhost";
//        int port = 3000;
//        try {

//            Log.v("fuck this port ", serverName);
//            Socket client = new Socket(serverName, port);
//            Log.v("fuck", "connected");
//            OutputStream outToServer = client.getOutputStream();
//            ObjectOutputStream out = new ObjectOutputStream(outToServer);
//            out.writeObject(product);
//            out.flush();
//            Log.v("fuck", "i am here");
//            client.close();
//            //        + client.getLocalSocketAddress());
//            //out.writeUTF("what's up");
//            //InputStream inFromServer = client.getInputStream();
//            //ObjectInputStream in =
//            //        new ObjectInputStream(inFromServer);
//            //product=(Product)in.readObject();
//            //in.close();
//            //System.out.println(product.toString());
//            //System.out.println("Server says " + in.readObject());
//            //client.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    public class ConnectToServer extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... params) {

            String serverName = "10.0.3.2";
            //String serverName = "191.168.1.12";
            int port = 3001;
            try {
//            System.out.println("Connecting to " + serverName +
//                    " on port " + port);
                Log.v("fuck this port ", serverName);
                Socket client = new Socket(serverName, port);
//            System.out.println("Just connected to "
//                    + client.getRemoteSocketAddress());
                Log.v("fuck", "connected");
                OutputStream outToServer = client.getOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(outToServer);
                out.writeObject(toBesent);
                out.flush();
                Log.v("fuck", "i am here");
                client.close();
                //        + client.getLocalSocketAddress());
                //out.writeUTF("what's up");
                //InputStream inFromServer = client.getInputStream();
                //ObjectInputStream in =
                //        new ObjectInputStream(inFromServer);
                //product=(Product)in.readObject();
                //in.close();
                //System.out.println(product.toString());
                //System.out.println("Server says " + in.readObject());
                //client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "success";
        }
    }
}
