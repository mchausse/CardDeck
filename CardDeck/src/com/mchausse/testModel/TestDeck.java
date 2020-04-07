package com.mchausse.testModel;

import com.mchausse.model.Card;
import com.mchausse.model.Deck;

/**
 *
 * @author Maxime Chaussé
 * @date April 3, 2020
 */
public class TestDeck {
    public static void main(String[] args) {
        Deck deck1 = new Deck();
        System.out.println(deck1);
        //System.out.println(deck1);
        deck1.shuffle();
        Card c = deck1.next().flip();
        System.out.println(c);
        System.out.println(deck1);
        
    }
    
}
