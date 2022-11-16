package BankingApp;

import java.util.Random;

public class GiftCard {
    private long GiftCardNum;
    private String GiftCardpassword;
    private long GiftCArdBalance;

    public long getTopupBalance() {
        return GiftCArdBalance;
    }

    public void setTopupBalance(long topupBalance) {
        this.GiftCArdBalance = topupBalance;
    }

    public long getGiftCardNum() {
        return GiftCardNum;
    }

    public void setGiftCardNum(long giftCardNum) {
        GiftCardNum = giftCardNum;
    }

    public String getGiftCardpassword() {
        return GiftCardpassword;
    }

    public void setGiftCardpassword(String giftCardpassword) {
        GiftCardpassword = giftCardpassword;
    }

    public long getGiftCArdBalance() {
        return GiftCArdBalance;
    }

    public void setGiftCArdBalance(long giftCArdBalance) {
        GiftCArdBalance = giftCArdBalance;
    }

    public GiftCard() {
        GiftCardNum = 10000;
        String GiftCardpassword;

    }

    public void PassWordGenerator()
    {
        String Upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Lower = "abcdefghijklmnopqrstuvwxyz";
        String Num = "0123456789";
        String SpecialChar = "~!@#$%^&*()_+-=?/>.<,";
        String Combination = Num;

        int length = 4;
        char[] password = new char[length];
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            password[i] = Combination.charAt(r.nextInt(Combination.length()));
        }
        this.GiftCardpassword= new String(password);

    }

    @Override
    public String toString() {
        return "GiftCardNum=" + GiftCardNum + ", GiftCardpassword=" + GiftCardpassword + ", GiftCArdBalance="
                + GiftCArdBalance;
    }

}
