package banktransfers;

import banktransfers.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.Callable;

public class TransferThread implements Callable<Boolean> {
    private final Account from;
    private final Account to;
    private final int amount;
    private static final Logger logger = LoggerFactory.getLogger(TransferThread.class);

    public TransferThread(Account fromAccount, Account toAccount, int amount) {
        this.from = fromAccount;
        this.to = toAccount;
        this.amount = amount;
    }

    @Override
    public Boolean call() {
        System.out.println(Thread.currentThread().getName());
        boolean temp = transfer(from, to, amount);
        Random randomTime = new Random();
        sleep(randomTime.nextInt(2000 - 1000));
        return temp;
    }

    private void sleep(long timeMillis) {
        try {
            Thread.sleep(timeMillis);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public static boolean transfer(Account fromAccount, Account toAccount, int amount) {
        if (fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            return true;
        }
        return false;
    }
}