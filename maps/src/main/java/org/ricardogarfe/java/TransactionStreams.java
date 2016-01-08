package org.ricardogarfe.java;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class TransactionStreams {


    public List<Transaction> sortTransactionsByYear(List<Transaction> transactions, Integer year) {

        return transactions.stream()
                .filter(t -> t.getYear() == year)
                .sorted(comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }

    public List<String> uniqueCitiesFromTraders(List<Trader> traders) {

        return traders.stream()
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Trader> findTradersFromCitySortByName(List<Trader> traders, String city) {

        return traders.stream()
                .filter(t -> city == t.getCity())
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());
    }

    public String traderNamesSortedByName(List<Trader> traders) {

        return traders.stream()
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.joining());
    }

    public Optional<Trader> checkTradersByCity(List<Trader> traders, String city) {

        return traders.stream()
                .filter(t -> city == t.getCity())
                .findAny();
    }
}
