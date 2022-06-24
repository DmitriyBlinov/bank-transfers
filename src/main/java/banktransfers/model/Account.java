package banktransfers.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Account {
    private String id;
    private int money;
    private static final Logger logger = LoggerFactory.getLogger(Account.class);

    public Account(String id) {
        this.money = 10000;
        this.id = id;
    }

    public synchronized void deposit(int amount) {
        logger.info("Deposit {} TO {}", amount, this.id);
        money += amount;
    }

    public synchronized boolean withdraw(int amount) {
        if (money > amount) {
            money -= amount;
            logger.info("Withdraw {} FROM {}", amount, this.id);
            return true;
        }
        logger.error("The account ID {} doesn't have enough money", this.id );
        return false;
    }

    public Integer getMoney() {
        return money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}