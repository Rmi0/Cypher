package com.company;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Encryptor enc = new Encryptor();
        File f = f = new File("C:\\GIT\\DropExample\\dropwizard\\Cypher\\src\\com\\company/test.enc");
        List<String> lines = enc.decrypt(f);
        for (String s : lines) {
            System.out.println(s);
        }
        System.exit(0);
        f = new File("C:\\GIT\\DropExample\\dropwizard\\Cypher\\src\\com\\company/test.txt");
        lines = enc.encrypt(f);
        f = new File("C:\\GIT\\DropExample\\dropwizard\\Cypher\\src\\com\\company/test.enc");
        FileWriter fw = new FileWriter(f);
        fw.write("");
        for (String s : lines) {
            System.out.println(s);
            fw.append(s+System.getProperty("line.separator"));
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        lines = enc.decrypt(f);
        for (String s : lines) {
            System.out.println(s);
        }
    }
}
