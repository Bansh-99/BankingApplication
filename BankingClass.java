package BankingApp;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankingClass
{
    int Topup = 0;
    int GiftCardbalance = 0;
    String accountName;
    String PassWord;
    int depositedAmount;


    static int accountNumber = 1000;
    static int giftCardNum = 10000;
    static Map<Integer, CustomerClass> customersData = new HashMap<>();

    public static void main(String[] args) {

        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println("press 1. to Create New Account ");
            System.out.println("press 2. to Login ");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    // To create Account
                    System.out.println("Enter your Full Name ");
                    String accountName = s.next();
                    System.out.println("Enter Your PassWord");
                    System.out.println("Password Should Contain Minimum 8 Characters to Maximum 12 Characters");
                    System.out.println("Including UpperCase,LowerCase,Number & Special Character ");
                    String accPassWord = s.next();

                    int upper  =  0;
                    int lower  =  0;
                    int number =  0;
                    int special=  0;
                    int combination = upper+lower+number+special;

                    for(int i=0; i<accPassWord.length(); i++) {
                        if (accPassWord.charAt(i) >= 65 && accPassWord.charAt(i) <= 90) {
                            upper++;
                        }
                        if (accPassWord.charAt(i) >= 97 && accPassWord.charAt(i) <= 122) {
                            lower++;
                        }
                        if (accPassWord.charAt(i) >= 48 && accPassWord.charAt(i) <= 57) {
                            number++;
                        }

                        if (accPassWord.charAt(i) >= 33 && accPassWord.charAt(i) <= 47 || accPassWord.charAt(i) >= 58 && accPassWord.charAt(i) <= 64
                                || accPassWord.charAt(i) >= 91 && accPassWord.charAt(i) <= 96 || accPassWord.charAt(i) >= 123 && accPassWord.charAt(i) <= 126) {
                            special++;
                        }
                    }


                    if (accPassWord.length() > 7 && accPassWord.length() <= 12 && special!=0 && upper!=0 && lower!=0 && number!=0) {
                        String encryptedPassword = encryptMyPassword(accPassWord);
                    }
                    else {
                        System.out.println("Sorry,Try again with Strong Password");
                        System.out.println("Password Should Contain Minimum 8 Characters to Maximum 12 Characters");
                        System.out.println("Including UpperCase,LowerCase,Number & Special Character ");
                        System.out.println("----------------------------------------------------------------------------");
                        break;
                    }





                    System.out.println("Enter Initial Deposit Amount ");
                    double depositedAmount = s.nextInt();

                    if(depositedAmount<999){
                        System.out.println(" Sorry,Minimum Deposit Amount is 1000");
                        System.out.println("----------------------------------------------------------------------------");
                        break;
                    }

                    String encryptedPassword = encryptMyPassword(accPassWord);
                    CustomerClass customer = new CustomerClass(++accountNumber,accountName, depositedAmount,encryptedPassword);
                    System.out.println("Account Created Successfully ");
                    System.out.println("Account Details : "+customer);
                    customersData.put(customer.getAccountNUmber(), customer);

                    GiftCard GiftCard = new GiftCard();
                    GiftCard.setGiftCardNum(++giftCardNum);
                    GiftCard.PassWordGenerator();
                    customer.setGiftCard(GiftCard);

                    // System.out.println("AccountName = " + accountName + ", AccountNumber = " + accountNumber
                    //     + ", Account BAlance = " + depositedAmount);
                    System.out.println("----------------------------------------------------------------------------");
                    break;

                case 2:
                    // To Login

                    System.out.println("Enter your Account Number ");
                    int accountNumber = s.nextInt();
                    System.out.println("Enter your Password ");
                    String passWord = s.next();
                    CustomerClass customerData = customersData.get(accountNumber);

                    //System.out.println( customerData);
                    //System.out.println( customerData.getPassWord());

                    if (customerData.getPassWord().equals(encryptMyPassword( passWord))) {
                        System.out.println(" Account Details  : " + customerData);
                        System.out.println(" Gift Details :" + customerData.getGiftCard());
                        System.out.println("----------------------------------------------------------------------------");



                        while (true) {
                            System.out.println("press 1. for Gift Card ");
                            System.out.println("press 2. for Top up ");
                            System.out.println("press 3. for Transaction History ");
                            System.out.println("press 4. for Purchasing ");
                            System.out.println("press 5. to EXIT ");

                            int Select = s.nextInt();
                            switch (Select) {

                                case 1:  // giftcard
                                    System.out.println(" Enter Your Gift Card Number ");
                                    long giftCardNum = s.nextLong();
                                    System.out.println("Enter Your Gift Card Pin ");
                                    String giftCardPassword = s.next();
                                    if (giftCardPassword.equalsIgnoreCase(customerData.getGiftCard().getGiftCardpassword())) {
                                        System.out.println("Gift Card Number " + customerData.getGiftCard().getGiftCardNum());
                                        System.out.println("Gift Card Balance " + customerData.getGiftCard().getGiftCArdBalance());
                                    } else {
                                        System.out.println("Wrong passsword");
                                    }
                                    System.out.println("----------------------------------------------------------------------------");
                                    break;
                                case 2:   // topup
                                    System.out.println(" Enter Topup Amount ");
                                    int topupAmount = s.nextInt();
                                    System.out.println(" Enter Account Password ");
                                    String password = s.next();
                                    if (encryptMyPassword(password).equals(customerData.getPassWord())) {
                                        if (customerData.getAccountBalance() < 50 || topupAmount > customerData.getAccountBalance() + 300) {
                                            System.out.println("sorry you don't have sufficient balance");
                                        } else {
                                            customerData.getGiftCard().setTopupBalance(customerData.getGiftCard().getTopupBalance() + topupAmount);
                                            customerData.setAccountBalance(customerData.getAccountBalance() - topupAmount);
                                            Transaction transaction = new Transaction(topupAmount, "debited for topup", LocalDateTime.now().toString());
                                            customerData.getTransactionHistory().add(transaction);
                                            System.out.println(" Topup Amount Successfully Credited to your Wallet, Your Current Balance is : "
                                                    + customerData.getAccountBalance() + " Topup Balance is "
                                                    + customerData.getGiftCard().getTopupBalance());
                                        }
                                    }
                                    else{
                                        System.out.println("Wrong passsword");
                                    }
                                    System.out.println("----------------------------------------------------------------------------");
                                    break;
                                case 3:  //History
                                    System.out.println("Enter Your Account PassWord ");
                                    String Password = s.next();
                                    if (encryptMyPassword(Password).equals(customerData.getPassWord())) {
                                        for (Transaction i : customerData.getTransactionHistory()) {
                                            System.out.println(i);
                                            System.out.println("Clear Balance = "+customerData.getAccountBalance());
                                        }

                                    } else {
                                        System.out.println("Wrong passsword");
                                    }
                                    System.out.println("----------------------------------------------------------------------------");
                                    break;

                                case 4: //purchase
                                    System.out.println(customerData);
                                    System.out.println(customerData.getGiftCard().getGiftCArdBalance());
                                    System.out.println("Purchase Amount ");
                                    long purchaseAmount = s.nextLong();
                                    if (purchaseAmount <= customerData.getGiftCard().getGiftCArdBalance()) {
                                        System.out.println("Enter Gift Card Password ");
                                        String gftpswd = s.next();
                                        if (gftpswd.equals(customerData.getGiftCard().getGiftCardpassword())) {
                                            customerData.getGiftCard().setGiftCArdBalance(
                                                    customerData.getGiftCard().getGiftCArdBalance() - purchaseAmount);
                                            System.out.println("Purchased Successfully , Your Current Gift Card Balance is "
                                                    + customerData.getGiftCard().getGiftCArdBalance());
                                            System.out.println(customerData);
                                        }
                                        else {
                                            System.out.println("Wrong Password");
                                        }
                                        System.out.println("----------------------------------------------------------------------------");
                                        break;
                                    } else
                                        System.out.println("Sorry you don't have sufficient balance in gift card balance");


                                default:
                                    return;
                            }
                        }
                    }
                default :
                    return;
            }
        }
    }
    private static String encryptMyPassword (String Password){
        char[] characters = Password.toCharArray();
        StringBuilder encryptedValue = new StringBuilder();
        for (int i = 0; i < characters.length; i++) {
            encryptedValue.append((char) ((int) Password.charAt(i) + 1));
        }
        return encryptedValue.toString();
    }
}