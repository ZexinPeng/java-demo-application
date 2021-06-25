package pers.zexin.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        String input = "";
        String reverse = "";
        try {
            Socket clientSocket = new Socket("localhost", 5000);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            input = inFromUser.readLine();

            outToServer.writeBytes(input + "\n");

            reverse = inFromServer.readLine();
            System.out.println("From SERVER: " + reverse);

            clientSocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
