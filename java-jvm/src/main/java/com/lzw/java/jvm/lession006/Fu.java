package com.lzw.java.jvm.lession006;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/10 21:08
 * @Description: TODO
 */
public class Fu implements AutoCloseable {
    private static final String path = "F:\\tools\\interview-java\\java-jvm\\src\\main\\java\\com\\lzw\\java\\jvm\\lession006\\";

    private final String name;

    public Fu(String name) {
        this.name = name;
    }

    @Override
    public void close() throws Exception {
        throw new RuntimeException(name);
    }

    public static void main(String[] args) throws Exception {
        try (Fu f0 = new Fu(path + "in0.txt");
             Fu f1 = new Fu(path + "in1.txt");
             Fu f2 = new Fu(path + "in2.txt");) {
            throw new RuntimeException("initial");
        }
    }
}
