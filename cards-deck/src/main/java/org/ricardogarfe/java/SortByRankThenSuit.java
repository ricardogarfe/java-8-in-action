package org.ricardogarfe.java;


import java.util.Comparator;

public class SortByRankThenSuit implements Comparator<Card> {
  public int compare(Card firstCard, Card secondCard) {
    int compVal =
        firstCard.getRank().value() - secondCard.getRank().value();
    if (compVal != 0)
      return compVal;
    else
      return firstCard.getSuit().value() - secondCard.getSuit().value();
  }
}