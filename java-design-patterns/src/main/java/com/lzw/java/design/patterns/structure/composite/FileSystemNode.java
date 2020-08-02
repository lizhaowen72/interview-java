package com.lzw.java.design.patterns.structure.composite;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/2 20:04
 * @Description: TODO
 */
public abstract class FileSystemNode {
    protected String path;

    public FileSystemNode(String path) {
        this.path = path;
    }

    public abstract int countNumOfFiles();

    public abstract long countSizeOfFiles();

    public String getPath() {
        return path;
    }
}
