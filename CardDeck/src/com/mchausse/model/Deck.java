package com.mchausse.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Maxime Chaussé
 * @date April 3, 2020
 */
public class Deck {
    private final UUID ID;
    private final String NAME;
    private static int numberOfDecks = 0;
    private int sizeDeck;
    private int sizeDiscardDeck;
    private ArrayDeque<Card> deck;
    private ArrayDeque<Card> discardDeck;
    
    public Deck() {
        this("Deck "+getNumberOfDecks(),true);
    }
    
    public Deck(String name) {
        this(name,true);
    }
    
    public Deck(String name, Card[] cards) {
        this.ID = UUID.randomUUID();
        this.NAME = name;
        this.deck.addAll(Arrays.asList(cards));
        this.sizeDeck = deck.size();
        numberOfDecks++;
        this.sizeDiscardDeck = 0;
        this.discardDeck = new ArrayDeque();
    }
    
    public Deck(String name, int numberOfDeck) {
        this(name, numberOfDeck,true);
    }
    
    public Deck(int numberOfDeck) {
        this("Deck "+getNumberOfDecks(), numberOfDeck,true);
    }
    
    public Deck(String name, int numberOfDeck, boolean jokers) {
        this.ID = UUID.randomUUID();
        this.NAME = name;
        if(jokers) {
            for(int i = 0; i < numberOfDeck; i++) {
                createDeckOf54().forEach((c) -> {
                    this.deck.add(c);
                });
            }
        } else {
            for(int i = 0; i < numberOfDeck; i++) {
                createDeckOf52().forEach((c) -> {
                    this.deck.add(c);
                });
            }
        }
        this.sizeDeck = deck.size();
        numberOfDecks++;
        this.sizeDiscardDeck = 0;
        this.discardDeck = new ArrayDeque();
    }

    public int getSizeDeck() {
        return sizeDeck;
    }

    public int getSizeDiscardDeck() {
        return sizeDiscardDeck;
    }

    public ArrayDeque<Card> getDiscardDeck() {
        return discardDeck;
    }

    public static int getNumberOfDecks() {
        return numberOfDecks;
    }

    public int getNumberOfCards() {
        return sizeDeck;
    }

    public UUID getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public ArrayDeque<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayDeque<Card> deck) {
        this.deck = deck;
    }
    
    public Deck(String name, boolean jokers) {
        this.ID = UUID.randomUUID();
        this.NAME = name;
        if(jokers) {
            this.deck = createDeckOf54();
        } else {
            this.deck = createDeckOf52();
        }
        this.sizeDeck = deck.size();
        numberOfDecks++;
    }
    
    public void shuffle() {
        List<Card> newDeck = new ArrayList<>();
        this.deck.forEach((c) -> {
            newDeck.add(c);
        });
        this.deck.clear();
        Collections.shuffle(newDeck);
        newDeck.forEach((c) -> {
            this.deck.add(c);
        });
    }
    
    public void flipFirst() {
        this.deck.getFirst().flip();
    }
    
    public Card next() {
        Card c = this.deck.removeFirst();
        
        return c;
    }
    
    @Override
    public String toString() {
        String string = "";
        int i = 0;
        for(Card c : deck ) {
            if(i == 10) {
                string+="\n";
                i=0;
            }
            string+= c+"\t";
            i++;
        }
        return string;
    }
    
    private ArrayDeque<Card> createDeckOf54() {
        ArrayDeque<Card> newDeck;
        newDeck = createDeckOf52();
        newDeck.add(new Card("BLACK"));
        newDeck.add(new Card("RED"));
        return newDeck;
    }
    
    private ArrayDeque<Card> createDeckOf52() {
        String[] types = new String[]{"Clubs","Diamonds","Hearts","Spades"};
        ArrayDeque<Card> newDeck;
        newDeck = new ArrayDeque<>();
        
        for(int type = 0; type < 4; type++) {
            for(int number = 1; number < 14; number++) {
                newDeck.add(new Card(number, types[type]));
            }
        }
        return newDeck;
    }
}
