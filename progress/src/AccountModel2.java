import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountModel2 {
    private Lock accountLock = new ReentrantLock();
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double money) {
        //锁住
        accountLock.lock();
        double newB=balance+money;
        try {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance=newB;
        } finally {
            accountLock.unlock();
        }
    }
    public AccountModel2() {
    }
}
