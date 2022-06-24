# Bank Transfers

Приложение для перевода денег между автоматически-генерируемыми аккаунтами

### Запуск приложения
С помощью командной строки:
1. Открыть cmd в директории ```*/target```
2. Выполнить команду ```java -cp BankTransfers-1.0-SNAPSHOT-jar-with-dependencies.jar banktransfers.App```
3. Дождаться завершения программы, логи будут доступны в директории ```*/logs```

С помощью IDE:
1. Выполнить команду Run у класса App
2. Дождаться завершения программы, логи будут доступны в директории ```*/logs```

### Изменение конфигурации

Все константные переменные, отвечающие за кол-во обрабатываемых аккаунтов, тредов и операций, находятся в классе App. Изменение следующих переменных меняет и исполнение самого приложения:
* MAX_OPERATIONS - кол-во совершаемых операций в течение работы приложения;
* MAX_ACCOUNTS - кол-во создаваемых программой аккаунтов;
* MAX_AMOUNT - граничная сумма перевода;
* MAX_THREADS - кол-во создаваемых потоков.
