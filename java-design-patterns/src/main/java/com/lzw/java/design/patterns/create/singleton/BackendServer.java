package com.lzw.java.design.patterns.create.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 11:48
 * @Description: TODO
 */
public class BackendServer {
    private long serverNo;
    private String serverAddress;

    private static final int server_count =3;

    private static final Map<Long,BackendServer> serverInstance = new HashMap<>();

    static {
        serverInstance.put(1L,new BackendServer(1L,"192.138.22.130:8080"));
        serverInstance.put(2L,new BackendServer(1L,"192.138.22.131:8080"));
        serverInstance.put(3L,new BackendServer(1L,"192.138.22.132:8080"));
    }

    public BackendServer(long serverNo, String serverAddress) {
        this.serverNo = serverNo;
        this.serverAddress = serverAddress;
    }

    public BackendServer getInstance(long serverNo){
        return serverInstance.get(serverNo);
    }
    public BackendServer getRandomInstance(){
        Random r = new Random();
        int no = r.nextInt(server_count)+1;
        return  serverInstance.get(no);
    }
}
