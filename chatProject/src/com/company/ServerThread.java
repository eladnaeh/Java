package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread implements Runnable {

    private Socket socket;
    private String name;
    private BufferedReader serverIn;
    private BufferedReader userIn;
    private PrintWriter out;

    public ServerThread(Socket socket) {
        this.socket = socket;
        this.name = name;
    }

    public static void main(String[] args) {
        Socket socket = null;
        System.out.println("please enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        scanner.close();
        int portNumber = 4444;
    }

    @Override
    public void run() {
        try{
            serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            userIn = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(socket.getOutputStream(), true);

            while (!socket.isClosed()){
                if(serverIn.ready()){
                    String input = serverIn.readLine();
                    if(input != null){
                        System.out.println(input);
                    }
                }
                if(userIn.ready()){
                    System.out.println(name + " > " + userIn.readLine());
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
