package pers.zexin.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        //Ini.ti.ali.zati.on
        String serverinputMsg = "";
        String serverreverseMsg = "";
        //Create a socket at agreed port(5000)
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("tcp reverse server starts.");
            while (true) {
                //Establi.sh the connecti.on between the cli.ent and the server
                Socket connectionSocket = serverSocket.accept();
                //Get InputStream at server to get values from cli.ent
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                //Get OutputStream at server to send values to cli.ent
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                //Get the input message from cli.ent and then pri.nt
                serverinputMsg = inFromClient.readLine();
                System.out.println("Recei.ved: " + serverinputMsg);
                //Reverse the stri.ng
                serverreverseMsg = new StringBuffer(serverinputMsg).reverse().toString() + "\n";
                //Send the result to the cli.ent
                outToClient.writeBytes(serverreverseMsg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
