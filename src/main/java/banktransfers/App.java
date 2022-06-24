package banktransfers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import banktransfers.model.Account;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private final static int MAX_OPERATIONS = 30;
    private final static int MAX_ACCOUNTS = 4;
    private final static int MAX_AMOUNT = 10000;
    private final static int MAX_THREADS = 2;
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    private static final ExecutorService pool = Executors.newFixedThreadPool(MAX_THREADS);
    private static ArrayList<Account> listOfAccounts;

    public static void main(String[] args) {
        createAccounts();
        performOperations(listOfAccounts);
        saveResultsToLog();
        pool.shutdown();
    }

    private static void performOperations(ArrayList<Account> listOfAccounts) {
        int completedOperations = 0;
        Random random = new Random();
        while (isCompleted(completedOperations)) {
            List<Future> listOfFutures = new ArrayList<>();
            for (int i = 0; i < MAX_THREADS; i++) {
                TransferThread newThread = new TransferThread(listOfAccounts.get(random.nextInt(MAX_ACCOUNTS)), listOfAccounts.get(random.nextInt(MAX_ACCOUNTS)), random.nextInt(MAX_AMOUNT));
                listOfFutures.add(pool.submit(newThread));
            }

            try {
                for (Future<Boolean> future : listOfFutures) {
                    if (future.get()) {
                        completedOperations += 1;
                    }
                }
            } catch (InterruptedException | ExecutionException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static void createAccounts() {
        listOfAccounts = new ArrayList<>();
        for (int i = 0; i < MAX_ACCOUNTS; i++) {
            String id = RandomStringUtils.randomAlphabetic(10);
            listOfAccounts.add(new Account(id));
        }
    }

    private static void saveResultsToLog() {
        for (Account account : listOfAccounts) {
            logger.info("Final amount of money for ID {}: {}", account.getId(), account.getMoney());
        }
    }

    public static boolean isCompleted(int amountOfOperations) {
        return amountOfOperations < MAX_OPERATIONS;
    }
}