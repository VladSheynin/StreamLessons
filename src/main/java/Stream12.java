//*Задача12
//Для списка транзакций:
//
//    record Transaction(String id, double amount, String currency) {}
//    List<Transaction> transactions = ...;
//
//    Найдите:
//    - Транзакции в USD с суммой > 100.
//    - Сумму всех транзакций в EUR.

import java.util.ArrayList;
import java.util.List;

public class Stream12 {
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("1", 125.00, "EUR"));
        transactions.add(new Transaction("2", 200.00, "USD"));
        transactions.add(new Transaction("3", 5000.00, "USD"));
        transactions.add(new Transaction("4", 90.00, "USD"));
        transactions.add(new Transaction("5", 5555.00, "EUR"));
        transactions.add(new Transaction("6", 1.00, "RUB"));
        List<Transaction> listUSD = transactions.stream()
                .filter((t) -> t.currency() == "USD")
                .toList();
        double sumEUR = transactions.stream()
                .filter((t) -> t.currency() == "EUR")
                .map(t -> (double) t.amount())
                .reduce(Double::sum)
                .get();

        System.out.println("Список транзакций в долларах: \n" + listUSD);
        System.out.println("Общая сумма в евро = " + sumEUR + " EUR");
    }

    record Transaction(String id, double amount, String currency) {
    }
}
