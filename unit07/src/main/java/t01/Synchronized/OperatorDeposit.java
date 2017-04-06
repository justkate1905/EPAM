package t01.Synchronized;

public class OperatorDeposit extends Thread {
    private Account account;
    private int amount;

    public OperatorDeposit(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    public void run() {
        account.deposit(amount);

    }
}
