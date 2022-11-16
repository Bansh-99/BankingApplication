package BankingApp;



public class Transaction {
    private double Amount;
    private String timeStamp;
    private  String Reason;

    public Transaction(double amount, String reason, String timeStamp) {
        super();
        Amount = amount;
        this.timeStamp = timeStamp;
        Reason = reason;
    }

    public double getAmount() {
        return Amount;
    }
    public void setAmount(double amount) {
        Amount = amount;
    }
    public String getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
    public String getReason() {
        return Reason;
    }
    public void setReason(String reason) {
        Reason = reason;
    }
    @Override
    public String toString() {
        return "Transaction [Amount=" + Amount + ", timeStamp=" + timeStamp + ", Reason=" + Reason + "]";
    }
}
