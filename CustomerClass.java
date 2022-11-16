package BankingApp;

import java.util.*;

public class CustomerClass {
    private String accountName ;
    private int accountNUmber;
    private String passWord;
    private double depositedAmount;
    private double accountBalance;
    private  List <Transaction >transactionHistory=new ArrayList<>();
    private GiftCard giftCard;

    public GiftCard getGiftCard() {
        return giftCard;
    }

    public void setGiftCard(GiftCard giftCard) {
        this.giftCard = giftCard;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getAccountNUmber() {
        return accountNUmber;
    }

    public void setAccountNUmber(int accountNUmber) {
        this.accountNUmber = accountNUmber;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public double getDepositedAmount() {
        return depositedAmount;
    }

    public void setDepositedAmount(double depositedAmount) {
        this.depositedAmount = depositedAmount;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public  List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    CustomerClass(int accountNumber , String accountName , double depositedAmount, String passWord ){
        super();
        this.accountNUmber = accountNumber;
        this.accountName = accountName;
        this.accountBalance =depositedAmount;
        this.passWord = passWord;
        this.depositedAmount = depositedAmount;
        this.transactionHistory=transactionHistory;
    }

    @Override
    public String toString() {
        return ("accountName=" + accountName + ", accountNumber=" + accountNUmber + ", AccountBalance=" + accountBalance);
    }

}
