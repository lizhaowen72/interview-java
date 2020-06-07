package com.lzw.java.concurrent.practice.lession004;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/7 15:51
 * @Description: TODO
 */
public class Account {
    // 锁:保护账户余额 ,加final 修饰:: 这是个最佳实践。只是为了防止一不小心改变了它。搞成final类型，就再也改变不了
    private final Object balLock = new Object();
    // 账户余额
    private Integer balance;
    // 锁:保护账户密码
    private final Object pwLock = new Object();
    // 账户密码
    private String password;

    // 锁:保护转账操作
    private Object objLock;

    // 要求在创建Account对象的时候必须传入同一个对象.
    // 如果创建Account对象时,传入的lock不是同一个对象,
    // 会出现锁自家门来保护他家资产的荒唐事.在真实的项目场景
    // 中,创建Account对象的代码分散在多个工程中,传入共享的lock真的很难
    public Account(Object objLock) {
        this.objLock = objLock;
    }

    // 取款
    void withdraw(Integer amt) {
        synchronized (balLock) {
            if (this.balance > amt) {
                this.balance -= amt;
            }
        }
    }

    // 查看余额
    Integer getBalance() {
        synchronized (balLock) {
            return balance;
        }
    }

    // 更改密码
    void updatePassword(String pw) {
        synchronized (pwLock) {
            this.password = pw;
        }
    }
    // 查询密码

    String getPassword() {
        synchronized (pwLock) {
            return password;
        }
    }

    // 转账操作 不安全
    void transfer(Account target, int amt) {
        if (this.balance > amt) {
            this.balance -= amt;
            target.balance += amt;
        }
    }

    // 转账操作 安全
    void transfer2(Account target, int amt) {
        synchronized (objLock) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }

    // 转账操作3 安全
    void transfer3(Account target, int amt) {
        synchronized (Account.class) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }
}
