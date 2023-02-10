package com.practice.webserver.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

@Service
public class GPSService {

    private static final String ESP8266_IP = "esp8266-ip-address";
    public static final int ESP8266_PORT = 0;

    public String getLocation() {

        try {
            Socket socket = new Socket(ESP8266_IP, ESP8266_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            socket.close();
            return content.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
