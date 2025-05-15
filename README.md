# Bank Transfers

Application for transferring money between automatically generated accounts

## User manual
### Application launch
Using the terminal:
1. Open the terminal in proceed to the ```*/target``` directory
2. Execute the following command: ```java -cp BankTransfers-1.0-SNAPSHOT-jar-with-dependencies.jar banktransfers.App```
3. Wait for the program to complete, the logs will be available in the following directory ```*/logs```

Using the IDEA:
1. Execute Run command for the App.class
2. Wait for the program to complete, the logs will be available in the following directory ```*/logs```

### Configurations

All constant variables responsible for the number of processed accounts, threads and operations could be found in the App.class. Changing the following variables will result in app execution:
* MAX_OPERATIONS - number of operations performed during the app launch
* MAX_ACCOUNTS - number of created accounts
* MAX_AMOUNT - max inital amount of money on 1 account
* MAX_THREADS - max number of created threads
