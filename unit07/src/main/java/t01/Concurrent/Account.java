package t01.Concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Katerina on 05.04.2017.
 */
public class Account {

    final int aID;
    private int balance;
    private final Lock lock = new ReentrantLock();

    public Account(int id) {
        this(id, 0);
    }

    public Account(int id, int balance) {
        this.balance = balance;
        this.aID = id;
    }


    public void deposit(int amount) {
        try{
            lock.lock();
            int x = balance + amount;
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = x;
        }
        finally{
            lock.unlock();
        }
    }

    public void withdraw(int amount) {
        lock.lock();
        int x = balance - amount;
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = x;
        lock.unlock();
    }

    public int getBalance() {
        return balance;
    }

    public int getId() {
        return aID;
    }
}

