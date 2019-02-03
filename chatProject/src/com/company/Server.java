package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    public static ServerSocket serverSocket;
    public static int portNumber = 4444;
    public static ArrayList<ClientThread> clientThreads;

    public static void main(String[] args) {
        serverSocket = null;
        try{
             serverSocket = new ServerSocket(portNumber);
             acceptClients();
        }
        catch (IOException e){
            System.err.println("Could not listen on port "  + portNumber);
            e.printStackTrace();
        }
    }

    public static void acceptClients(){
        clientThreads = new ArrayList<>();
        while(true){
            try{
                Socket socket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(socket);
                Thread thread = new Thread(clientThread);
                thread.start();
                clientThreads.add(clientThread);
            }
            catch (IOException e){
                System.err.println("Accept Failed on " + portNumber);
                e.printStackTrace();
            }
        }
    }
}
