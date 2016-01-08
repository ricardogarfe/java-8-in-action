package org.ricardogarfe.java;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TransactionStreamsTest {

    private TransactionStreams transactionStreams = new TransactionStreams();

    private static Integer FILTERED_YEAR = 2011;
    private static String MILAN = "Milan";
    private static final String CAMBRIDGE = "Cambridge";
    private static String FIRST_TRADER_NAME = "Alan";

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Trader> traders = Arrays.asList(
            raoul,
            mario,
            alan,
            brian);

    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    //    1. Find all transactions in the year 2011 and sort them by value (small to high).
    @Test
    public void testSortTransactionsByYear() throws Exception {

        List<Transaction> transactionSortedByYear = transactionStreams.sortTransactionsByYear(transactions, FILTERED_YEAR);
        Assert.assertTrue("Transactions in 2011 are not correct.", transactionSortedByYear.size() == 2);

        transactionSortedByYear.forEach(System.out::println);
    }

    //    2. What are all the unique cities where the traders work?
    @Test
    public void testUniqueCitiesFromTraders() throws Exception {

        List<String> expectedCities = Arrays.asList(
                "Cambridge",
                "Milan");

        List<String> citiesFromTraders = transactionStreams.uniqueCitiesFromTraders(transactions);
        Assert.assertTrue("There are different cities from traders.", expectedCities.equals(citiesFromTraders));

        citiesFromTraders.forEach(System.out::println);
    }

    //    3. Find all traders from Cambridge and sort them by name.
    @Test
    public void testFindTradersFromCitySortByName() throws Exception {

        List<Trader> tradersFromCitySortByName = transactionStreams.findTradersFromCitySortByName(transactions, CAMBRIDGE);
        Assert.assertTrue("There aren't Traders in " + CAMBRIDGE, !tradersFromCitySortByName.isEmpty());

        tradersFromCitySortByName.forEach(System.out::println);
    }

    //    4. Return a string of all traders’ names sorted alphabetically.
    @Test
    public void testTraderNamesSortedByName() throws Exception {

        String traderNamesSortedByName = transactionStreams.traderNamesSortedByName(transactions);
        Assert.assertTrue("Incorrect first trader ordered.", traderNamesSortedByName.startsWith(FIRST_TRADER_NAME));
    }

    //    5. Are any traders based in Milan?
    @Test
    public void testCheckTradersByCity() throws Exception {

        Optional<Trader> traderInCity = transactionStreams.checkTradersByCity(transactions, MILAN);
        Assert.assertTrue("There are no traders in " + MILAN, traderInCity.isPresent());
    }

    //    6. Print all transactions’ values from the traders living in Cambridge.
    @Test
    public void testTransactionValuesFromTradersFromCambridge() throws Exception {

        List<Integer> transactionValuesFromCambridge = transactionStreams.transactionValuesFromCambridge(transactions);
        Assert.assertTrue("There are no correct transaction values from Cambridge.", transactionValuesFromCambridge.size() == 4);

        transactionValuesFromCambridge.forEach(System.out::println);
    }

//    7. What’s the highest value of all the transactions?
//    8. Find the transaction with the smallest value.

}
