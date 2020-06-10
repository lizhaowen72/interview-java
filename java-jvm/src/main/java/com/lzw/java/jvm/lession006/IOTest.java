package com.lzw.java.jvm.lession006;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/10 21:00
 * @Description: TODO
 */
public class IOTest {
    private static final String path = "F:\\tools\\interview-java\\java-jvm\\src\\main\\java\\com\\lzw\\java\\jvm\\lession006\\";

    public static void main(String[] args) throws IOException {
        FileInputStream in0 = null;
        FileInputStream in1 = null;
        FileInputStream in2 = null;
        try {
            in0 = new FileInputStream(new File(path + "in0.txt"));
            try {
                in1 = new FileInputStream(new File(path + "in1.txt"));
                try {
                    in2 = new FileInputStream(new File(path + "in2.txt"));
                } finally {
                    if (in2 != null) {
                        in2.close();
                    }
                }
            } finally {
                if (in1 != null) {
                    in1.close();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in0 != null) {
                in0.close();
            }
        }
    }
}
