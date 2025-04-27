package com.bistu.exr.util;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class XORUtil {
    private static final String KEY = "bankAccount";

    public static String encrypt(String input){
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0;i < input.length();i ++){
            char c = input.charAt(i);
            char keyChar = KEY.charAt(i % KEY.length());
            char encryptedChar = (char)(c ^ keyChar);
            encrypted.append(encryptedChar);
        }

        return encrypted.toString();
    }

    public static String decrypt(String input){
        return encrypt(input);
    }
}