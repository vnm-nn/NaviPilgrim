package com.company;

import java.io.*;
import java.net.*;
import java.security.spec.RSAOtherPrimeInfo;

public class NaviPilgrim {

    public static void main(String[] args) {

        int port = 5500;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server is listening on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

//hi zybls
                String text;
                do {
                    text = reader.readLine();
                    if (text != null && text.indexOf('*') != -1) {
                        //text.replaceAll("\\s+","");
                        System.out.println(text);
                        String subStr = text.substring(text.indexOf('$'), text.indexOf('*') + 1);
                        System.out.println(subStr);
                    }

                } while (text != null);

                socket.close();
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}