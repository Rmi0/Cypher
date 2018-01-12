package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by client on 22.12.2017.
 */
public class Encryptor {

    public Encryptor() {

    }

    public List<String> encrypt(File f) throws Exception {
        if (!f.exists() | f.isDirectory()) return null;

        BufferedReader br = new BufferedReader(new FileReader(f));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            if (line == "") {
                lines.add(line);
                continue;
            }
            line = flipPairs(line);
            line = new StringBuilder(line).reverse().toString();
            line = encryptBinary(line);
            lines.add(line);
        }
       return lines;
    }

    public List<String> decrypt(File f) throws Exception {
        if (!f.exists() | f.isDirectory()) return null;

        BufferedReader br = new BufferedReader(new FileReader(f));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            if (line == "") {
                lines.add(line);
                continue;
            }
            line = decryptBinary(line);
            line = new StringBuilder(line).reverse().toString();
            line = flipPairs(line);
            lines.add(line);
        }
        return lines;
    }

    private String flipPairs(String line) {
        char[] charLine = line.toCharArray();
        for (int i = 1; i < line.length(); i+=2) {
            char c1 = charLine[i];
            charLine[i] = charLine[i-1];
            charLine[i-1] = c1;
        }
        return new String(charLine);
    }

    public String encryptBinary(String line) {
        char[] charLine = line.toCharArray();
        for (int i = 0; i < line.length(); i++) {
            char c = charLine[i];
            int left = c & 240;
            int right = c & 15;
            left=left>>4;
            right = right<<4;
            c=(char)(left+right);
            charLine[i] = c;
        }
        return new String(charLine);
    }

    public String decryptBinary(String line) {
        char[] charLine = line.toCharArray();
        for (int i = 0; i < line.length(); i++) {
            char c = charLine[i];
            int left = c & 240;
            int right = c & 15;
            left=left>>4;
            right = right<<4;
            c=(char)(left+right);
            charLine[i] = c;
        }
        return new String(charLine);
    }

}
