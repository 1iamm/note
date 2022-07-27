package com.liam;

/**
 * @author Liam Li
 * @date 2022/2/25
 * @Description
 */
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100,"结婚基金");

        Bank you = new Bank(account, 50, "你");
        Bank girlFriend = new Bank(account,100,"女朋友");

        you.start();
        girlFriend.start();

    }
}

class Account{
    int money;
    String Name;

    public Account(int money, String name) {
        this.money = money;
        this.Name = name;
    }
}

class Bank extends Thread{

    Account account;
    int drawMoney;

    public Bank(Account account, int drawMoney, String name){
        super(name);
        this.account = account;
        this.drawMoney = drawMoney;
    }



    @Override
    public void run() {
        if (account.money - drawMoney < 0) {
            System.out.println("钱不够了！");
            return;
        }
        account.money = account.money - drawMoney;
        System.out.println(account.Name + "里还有" + account.money + "块钱");
    }
}
