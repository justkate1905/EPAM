package t01.Synchronized;

/**
 * Created by Katerina on 05.04.2017.
 */
public class Account {

    final int aID;
    private int balance;

    public Account(int id){
        this(id, 0);
    }

    public Account(int id, int balance) {
        this.balance = balance;
        this.aID = id;
    }


    public synchronized void deposit(int amount) {
        int x = balance + amount;
        try{
            Thread.sleep(15);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        balance = x;
    }

    public synchronized void withdraw(int amount) {
        int x = balance - amount;
        try{
            Thread.sleep(20);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        balance = x;
    }

    public int getBalance() {
        return balance;
    }
    public int getId() {
        return aID;
    }
}

