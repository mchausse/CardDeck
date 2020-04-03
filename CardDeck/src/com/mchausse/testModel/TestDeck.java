package com.mchausse.testModel;

import com.mchausse.model.Deck;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Maxime Chaussé
 * @date April 3, 2020
 */
public class TestDeck {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Deck deck1 = new Deck();
        //System.out.println(deck1);
        deck1.flipFirst();
        System.out.println(deck1);
        System.out.println(deck1);
        
    }
    
}
