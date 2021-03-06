package org.ricardogarfe.java;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class TransactionStreams {

    private static final String CAMBRIDGE = "Cambridge";

    public List<Transaction> sortTransactionsByYear(List<Transaction> transactions, Integer year) {

        return transactions.stream()
                .filter(t -> t.getYear() == year)
                .sorted(comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }

    public List<String> uniqueCitiesFromTraders(List<Transaction> transactions) {

        return transactions.stream()
                .map(transaction ->transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Trader> findTradersFromCitySortByName(List<Transaction> transactions, String city) {

        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals(city))
                .sorted(comparing(Trader::getName))
                .distinct()
                .collect(Collectors.toList());
    }

    public String traderNamesSortedByName(List<Transaction> transactions) {

        return transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
    }

    public Optional<Trader> checkTradersByCity(List<Transaction> transactions, String city) {

        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> city == t.getCity())
                .findAny();
    }

    public List<Integer> transactionValuesFromCambridge(List<Transaction> transactions) {

        return transactions.stream()
                .filter(t -> CAMBRIDGE.equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
    }

    public Optional<Integer> highestTransactionValue(List<Transaction> transactions) {

        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
    }

    public Optional<Integer> smallestTransactionValue(List<Transaction> transactions) {

        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
    }
}
