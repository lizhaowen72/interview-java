package com.lzw.java.concurrent.practice.lession029;

import java.util.Objects;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/4 11:27
 * @Description: 路由信息
 */
public final class Router {
    private final String ip;
    private final Integer port;
    private final String iface;

    // 构造函数
    public Router(String ip, Integer port, String iface) {
        this.ip = ip;
        this.port = port;
        this.iface = iface;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Router router = (Router) o;
        return Objects.equals(ip, router.ip) &&
                Objects.equals(port, router.port) &&
                Objects.equals(iface, router.iface);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port, iface);
    }

    public String getIp() {
        return ip;
    }

    public Integer getPort() {
        return port;
    }

    public String getIface() {
        return iface;
    }
}
