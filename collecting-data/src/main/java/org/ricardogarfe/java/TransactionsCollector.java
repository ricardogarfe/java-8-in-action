package org.ricardogarfe.java;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class TransactionsCollector {

  public Map<Currency, List<Transaction>> getTransactionsByCurrenciesJDK7(List<Transaction> transactions) {

    Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();
    for (Transaction transaction :
        transactions) {
      Currency currency = transaction.getCurrency();

      List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);

      if (transactionsForCurrency == null) {
        transactionsForCurrency = new ArrayList<>();
        transactionsByCurrencies.put(currency, transactionsForCurrency);
      }
      transactionsForCurrency.add(transaction);
    }
    return transactionsByCurrencies;
  }

  public Map<Currency, List<Transaction>> getTransactionsByCurrencies(List<Transaction> transactions) {
    Map<Currency, List<Transaction>> transactionsByCurrencies =
        transactions.stream().collect(groupingBy(Transaction::getCurrency));

    return transactionsByCurrencies;
  }
}
