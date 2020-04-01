package com.mchausse.testModel;

import com.mchausse.model.Card;

/**
 * 
 * @author Maxime
 * @date March 31, 2020
 */
public class TestCard {
    public static void main(String[] args) {
        String[] types = new String[]{"Clubs","Diamonds","Hearts","Spades"};
        Card[] deck = new Card[54];
        int deckSize = 0;
        
        for(int type = 0; type < 4; type++) {
            for(int number = 1; number < 14; number++) {
                deck[deckSize++] = new Card(number, types[type]);
            }
        }
        deck[deckSize++] = new Card("BLACK");
        deck[deckSize++] = new Card("RED");
        
        int i = 0;
        for(Card c : deck ) {
            if(i == 10) {
                System.out.println();
                i=0;
            }
            System.out.print(c+"\t");
            c.turn();
            i++;
        }
        
        System.out.println();
        System.out.println();
        
        i = 0;
        for(Card c : deck ) {
            if(i == 10) {
                System.out.println();
                i=0;
            }
            System.out.print(c+"\t");
            i++;
        }
    }
    
}
