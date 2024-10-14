package com.huberthvladimir.urlshortening.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomIdGenerator {

    private final static char[] base62chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    private final static Random random = new Random();

    public String getBase64(int length) {
        var sb = new StringBuilder(length);

        for (int i = 0; i < length; i++)
            sb.append(base62chars[random.nextInt(64)]);

        return sb.toString();
    }
}
