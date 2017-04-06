package t01.Synchronized;

public class OperatorWithdraw extends Thread {
    private Account account;
    private int amount;

    public OperatorWithdraw(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    public void run() {
        account.withdraw(amount);

    }
}


