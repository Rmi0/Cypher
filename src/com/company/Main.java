package com.company;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {



        Encryptor enc = new Encryptor();

        System.out.println(enc.encryptBinary("EFG"));
        System.out.println(enc.decryptBinary("Tdt"));
        List<String> lines;
        File f,f2;
        f = new File("C:\\GIT\\DropExample\\dropwizard\\Cypher\\src\\com\\company/test.txt");
        lines = enc.encrypt(f);
        f2 = new File("C:\\GIT\\DropExample\\dropwizard\\Cypher\\src\\com\\company/test.enc");
        FileWriter fw = new FileWriter(f2);
        fw.write("");
        System.out.println("------------------------------------------");
        for (String s : lines) {
            System.out.println(s);
            fw.append(s+System.getProperty("line.separator"));
        }
        fw.flush();
        fw.close();
        System.out.println("-----------------------------------------------------------------------------------------");
        lines = enc.decrypt(f2);
        for (String s : lines) {
            System.out.println(s);
        }
    }
}
