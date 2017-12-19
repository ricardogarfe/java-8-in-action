package org.ricardogarfe.java;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class StandardDeck implements Deck {

    private List<Card> entireDeck;
    private Deck deck;

    public List<Card> getCards() {
        return entireDeck;
    }

    public Deck deckFactory() {
        return this.deck;
    }

    public int size() {
        return this.entireDeck.size();
    }

    public void addCard(Card card) {
        this.entireDeck.add(card);
    }

    public void addCards(List<Card> cards) {
        this.entireDeck = cards;
    }

    public void addDeck(Deck deck) {

    }

    public void shuffle() {

    }

    public void sort() {
        Collections.sort(entireDeck);
    }

    public void sort(Comparator<Card> c) {
        Collections.sort(entireDeck, c);
    }

    public String deckToString() {
        return null;
    }

    public Map<Integer, Deck> deal(int players, int numberOfCards) throws IllegalArgumentException {
        return null;
    }
}