package com.eadp.userserviceapi.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class KeyManager {

    private final  String CHARS="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_";

    public String generateKey(int length){


            StringBuilder stringBuilder=new StringBuilder();
            for (int i = 0; i <length ; i++) {
                stringBuilder.append(CHARS.charAt(new Random().nextInt(62)));

            }
            return  "USER-"+stringBuilder.toString();
        }

}
