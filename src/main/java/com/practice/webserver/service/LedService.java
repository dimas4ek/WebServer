package com.practice.webserver.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

@Service
public class LedService {

    private static final String ESP8266_IP = "esp8266-ip-address";
    public static final int ESP8266_PORT = 0;

    public void turnOn() {
        System.out.println("on");
        sendRequest("LED=ON");
    }

    public void turnOff() {
        System.out.println("off");
        sendRequest("LED=OFF");
    }

    private void sendRequest(String message) {
        try {
            Socket socket = new Socket(ESP8266_IP, ESP8266_PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            socket.close();
            out.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
