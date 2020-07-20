package com.group_online.groupOnline.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class vk_worker {

    public String getToken(){

        String token = "";

        String login = "";

        String password = "";

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://oauth.vk.com/token?grant_type=password&client_id=2274003&client_secret=hHbZxrka2uZ6jB1inYsH&username=" + login + "&password=" + password;

        return token;
    }

    public String req(String url){

        return "";
    }
}
