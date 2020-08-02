package com.lzw.java.design.patterns.structure.composite;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/2 20:05
 * @Description: TODO
 */
public class File extends FileSystemNode{
    public File(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        return 1;
    }

    @Override
    public long countSizeOfFiles() {
        java.io.File file = new java.io.File(path);
        if (!file.exists()){
            return 0;
        }
        return file.length();
    }
}
