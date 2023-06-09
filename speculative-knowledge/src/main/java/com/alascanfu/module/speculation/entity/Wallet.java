package com.alascanfu.module.speculation.entity;

import com.alascanfu.module.speculation.exception.InsufficientAmountException;
import com.alascanfu.module.speculation.exception.InvalidAmountException;

import java.math.BigDecimal;

/**
 * <p>
 * 虚拟钱包
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2023/7/2 0:56
 **/

public class Wallet {
    private String id;
    private long createTime;
    private BigDecimal balance;
    private long balanceLastModifiedTime;
    // ...省略其他属性...
    
    public Wallet() {
        this.id = IdGenerator.getInstance().generate();
        this.createTime = System.currentTimeMillis();
        this.balance = BigDecimal.ZERO;
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }
    
    // 注意：下面对get方法做了代码折叠，是为了减少代码所占文章的篇幅
    public String getId() { return this.id; }
    public long getCreateTime() { return this.createTime; }
    public BigDecimal getBalance() { return this.balance; }
    public long getBalanceLastModifiedTime() { return this.balanceLastModifiedTime;  }
    
    public void increaseBalance(BigDecimal increasedAmount) throws InvalidAmountException {
        if (increasedAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidAmountException("...");
        }
        this.balance.add(increasedAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }
    
    public void decreaseBalance(BigDecimal decreasedAmount) throws InsufficientAmountException, InvalidAmountException {
        if (decreasedAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidAmountException("...");
        }
        if (decreasedAmount.compareTo(this.balance) > 0) {
            throw new InsufficientAmountException("...");
        }
        this.balance.subtract(decreasedAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }
}
