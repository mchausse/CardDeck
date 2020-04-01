package com.mchausse.model;

/**
 * This class represents a playing card. It can be any of the 
 * 54 (with jokers) cards of a deck.
 * 
 *
 * @author Maxime
 * @date March 31, 2020
 */
public class Card {
    private final String NAME;
    private final int VALUE;
    private final String KIND;
    private final boolean JOKER;
    private final String COLOR;
    private boolean faceUp;
    
    public Card(int value, String kind) {
        this.NAME = assignName(value);
        this.VALUE = value;
        this.KIND = kind.toUpperCase();
        this.COLOR = assignColor(kind);
        this.JOKER = false;
        this.faceUp = false;
    }
    
    public Card(String color) {
        this.NAME = assignName(0);
        this.VALUE = 0;
        this.COLOR = color.toUpperCase();
        this.KIND = null;
        this.JOKER = true;
        this.faceUp = false;
    }

    public String getName() {
        return this.NAME;
    }

    public int getValue() {
        return this.VALUE;
    }

    public String getKind() {
        return this.KIND;
    }
    
    public String getColor() {
        return this.COLOR;
    }

    public boolean isJoker() {
        return this.JOKER;
    }

    public boolean isFaceUp() {
        return this.faceUp;
    }
    
    public Card turn() {
        this.faceUp = true;
        return this;
    }
    
    @Override
    public String toString() {
        if(this.faceUp) {
            if(this.JOKER) {
                return this.COLOR +" "+this.NAME;
            } else {
                return this.NAME+"("+this.VALUE+") of "+this.KIND;
            }
        } else {
            return "Hidden card";
        }
    }
    
    private String assignName(int value) {
        switch(value) {
            case 1:
                return "Ace";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            case 0:
                return "Joker";
            default:
                return "Unknown";
        }
    }
    private String assignColor(String type) {
        if("SPADES".equals(type.toUpperCase()) || "CLUBS".equals(type.toUpperCase())) {
            return "BLACK";
        }
        return "RED";
    }
}
