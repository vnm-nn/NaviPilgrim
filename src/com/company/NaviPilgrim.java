package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

                String text;

                do {
                    text = reader.readLine();
                    if (text != null && text.indexOf('*') != -1) {
                        //text.replaceAll("\\s+","");
                        System.out.println(text);
                        String subStr = text.substring(text.indexOf('$'), text.indexOf('*'));
                        System.out.println(subStr);
                        List<String> parsStr = Arrays.asList(subStr.split(","));
                        System.out.println(parsStr);
                        Map<String, Integer> map =
                                Arrays.stream(subStr.split(",")).collect(Collectors.toMap(s -> s, s -> 0));
                        System.out.println(map);
//                        List<Item>  = IntStream.mapToObj(Item::new).collect(Collectors.toList());
//
//                        Map<String, Item> map =
//                                list.stream().collect(Collectors.toMap(Item::getKey, item -> item));
//
//                        map.forEach((k, v) -> System.out.println(k + " => " + v));
                    }

                } while (text != null);

                socket.close();
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

//    public Map<Integer, Data> convertListAfterJava8(List<Data> list){
//        Map<Integer, Data> map = list.stream()
//                .collect(Collectors.toMap(Data::getId, Function.identity()));
//        return map;
//    }
}