package com.lzw.java.design.patterns.structure.proxy;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 16:06
 * @Description: TODO
 */
public interface IUserController {
    UserVo login(String telephone,String password);
    UserVo register(String telephone,String password);
}
