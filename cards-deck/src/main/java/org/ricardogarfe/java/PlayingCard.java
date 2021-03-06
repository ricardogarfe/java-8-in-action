package org.ricardogarfe.java;

public class PlayingCard implements Card{

  private Suit suit;
  private Rank rank;

  public Suit getSuit() {
    return null;
  }

  public Rank getRank() {
    return null;
  }

  public PlayingCard(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PlayingCard that = (PlayingCard) o;

    if (suit != that.suit) return false;
    return rank == that.rank;
  }

  @Override
  public int hashCode() {
    return ((suit.value()-1)*13)+rank.value();
  }

  public int compareTo(Card o) {
    return this.hashCode() - o.hashCode();
  }

}
