package com.singh.aakash.dbconnector;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//import static android.support.v4.app.ActivityCompat.startActivity;

public class DBForProducts {
    //Product product;
    //List<String> categories;
    List<String> productsList;
    Context context;
    String categoryFound;
    List<String> toBeSent;
    String placeId;

    public void execute(){
        ConnectToServer connectToServer=new ConnectToServer();
        connectToServer.execute(categoryFound);
    }
    public DBForProducts(Context context,String categoryFound,String placeId) {
        this.categoryFound=categoryFound;
        //categories=new ArrayList<>();
        this.context=context;
        this.placeId=placeId;
        productsList=new ArrayList<>();
        toBeSent=new ArrayList<>();
        toBeSent.add(placeId);
        toBeSent.add(categoryFound);

        //this.product = product;
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
        protected void onPostExecute(String s) {
//            Intent intent=new Intent(context,Category_intent.class);
//            intent.putStringArrayListExtra("arrayOfProducts",(ArrayList)productsList);
//            //intent.putStringArrayListExtra("arrayOfCats", (ArrayList<String>) categories);
//            context.startActivity(intent);
            Intent intent=new Intent(context,Products_List.class);
            intent.putStringArrayListExtra("arrayOfProducts",(ArrayList<String>)productsList);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }

        @Override
        protected String doInBackground(String... params) {
            //String ss=params[0];
            String serverName = "10.0.3.2";
            //String serverName = "191.168.1.12";
            int port = 3002;
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
                out.writeObject(toBeSent);
                out.flush();
                //out.close();



                Log.v("fuck", "i am here");

                InputStream inFromServer = client.getInputStream();
                Log.v("fuck","i am here2");
                ObjectInputStream in = new ObjectInputStream(inFromServer);
                Log.v("fuck","i am here3");
                productsList= (ArrayList<String>)in.readObject();
                //categories=(ArrayList<String>) in.readObject();
                //product=(Product)in.readObject();
                Log.v("fuck","i am here4");
                //in.close();
                Log.v("fuck", "i am here5");


                client.close();
                in.close();
                out.close();
                Log.v("fuck", "i am here6");
//                for(String s:categories){
//                    Log.v("recieved",s);
//                }

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
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return "success";
        }
    }
}




























//
//import android.content.Context;
//import android.content.Intent;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.ObjectInputStream;
//import java.io.OutputStream;
//import java.net.Socket;
//import java.util.ArrayList;
//import java.util.List;
//
////import static android.support.v4.app.ActivityCompat.startActivity;
//
//public class DBForProducts {
//    //Product product;
//    //List<String> categories;
//    List<String> productsList;
//    Context context;
//    String categoryFound;
//
//    public void execute(){
//        ConnectToServer connectToServer=new ConnectToServer();
//        connectToServer.execute(categoryFound);
//    }
//    public DBForProducts(Context context,String categoryFound) {
//        this.categoryFound=categoryFound;
//        //categories=new ArrayList<>();
//        this.context=context;
//        productsList=new ArrayList<>();
//        //this.product = product;
////        String serverName = "localhost";
////        int port = 3000;
////        try {
//
////            Log.v("fuck this port ", serverName);
////            Socket client = new Socket(serverName, port);
////            Log.v("fuck", "connected");
////            OutputStream outToServer = client.getOutputStream();
////            ObjectOutputStream out = new ObjectOutputStream(outToServer);
////            out.writeObject(product);
////            out.flush();
////            Log.v("fuck", "i am here");
////            client.close();
////            //        + client.getLocalSocketAddress());
////            //out.writeUTF("what's up");
////            //InputStream inFromServer = client.getInputStream();
////            //ObjectInputStream in =
////            //        new ObjectInputStream(inFromServer);
////            //product=(Product)in.readObject();
////            //in.close();
////            //System.out.println(product.toString());
////            //System.out.println("Server says " + in.readObject());
////            //client.close();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//    }
//
//
//    public class ConnectToServer extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected void onPostExecute(String s) {
////            Intent intent=new Intent(context,Category_intent.class);
////            intent.putStringArrayListExtra("arrayOfProducts",(ArrayList)productsList);
////            //intent.putStringArrayListExtra("arrayOfCats", (ArrayList<String>) categories);
////            context.startActivity(intent);
//            Intent intent=new Intent(context,Products_List.class);
//            intent.putStringArrayListExtra("arrayOfProducts",(ArrayList<String>)productsList);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(intent);
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//            //String ss=params[0];
//            String serverName = "10.0.3.2";
//            //String serverName = "191.168.1.12";
//            int port = 3002;
//            try {
////            System.out.println("Connecting to " + serverName +
////                    " on port " + port);
//                Log.v("fuck this port ", serverName);
//                Socket client = new Socket(serverName, port);
////            System.out.println("Just connected to "
////                    + client.getRemoteSocketAddress());
//                Log.v("fuck", "connected");
//                OutputStream outToServer = client.getOutputStream();
//                DataOutputStream out = new DataOutputStream(outToServer);
//                out.writeUTF(categoryFound);
//                out.flush();
//                //out.close();
//
//
//
//                Log.v("fuck", "i am here");
//
//                InputStream inFromServer = client.getInputStream();
//                Log.v("fuck","i am here2");
//                ObjectInputStream in = new ObjectInputStream(inFromServer);
//                Log.v("fuck","i am here3");
//                productsList= (ArrayList<String>)in.readObject();
//                //categories=(ArrayList<String>) in.readObject();
//                //product=(Product)in.readObject();
//                Log.v("fuck","i am here4");
//                //in.close();
//                Log.v("fuck", "i am here5");
//
//
//                client.close();
//                in.close();
//                out.close();
//                Log.v("fuck", "i am here6");
////                for(String s:categories){
////                    Log.v("recieved",s);
////                }
//
//                //        + client.getLocalSocketAddress());
//                //out.writeUTF("what's up");
//                //InputStream inFromServer = client.getInputStream();
//                //ObjectInputStream in =
//                //        new ObjectInputStream(inFromServer);
//                //product=(Product)in.readObject();
//                //in.close();
//                //System.out.println(product.toString());
//                //System.out.println("Server says " + in.readObject());
//                //client.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//
//            return "success";
//        }
//    }
//}