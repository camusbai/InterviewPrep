package com.camusbai.exercise.design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class DeckCard {
    Queue<Card> deck;

    public DeckCard(){
        init();
    }

    public void init(){
        deck = new LinkedList<>();
        for (int i = 1; i < 53; i++) {
            deck.offer(new Card(i));
        }
    }

    public void shuffle(){
        Queue<Card> newDeck = new LinkedList<>();
        while (!deck.isEmpty()) {
            int pos = new Random().nextInt(deck.size() + 1);
            Iterator<Card> iter = deck.iterator();
            while(pos!=0){
                iter.next();
            }
            deck.remove();
            deck.remove(iter.next());
        }
        deck = newDeck;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for (Card card : deck) {
            str.append(card.toString()).append(" => ");
        }
        str.delete(str.length() - 4, str.length());
        return str.toString();
    }

    class Card{
        public Card(int val) {
            this.val = val;
        }

        int val;
        public String toString(){
            int quotient = (val - 1) / 13;
            int remainder = val % 13;
            Suit suit;
            switch(quotient){
                case 0:
                    suit = Suit.CLUB;
                    break;
                case 1:
                    suit = Suit.SPADE;
                    break;
                case 2:
                    suit = Suit.DIAMOND;
                    break;
                case 3:
                    suit = Suit.HEART;
                    break;
                default:
                    return "UNKNOWN_CARD(val:" + val+")";
            }

            String number = Integer.toString(remainder);
            if (remainder == 11) {
                number = "J";
            }else if (remainder == 12) {
                number = "Q";
            }else if (remainder == 0) {
                number = "K";
            }
            return suit.val + number;
        }
    }

    enum Suit{
        CLUB("C"),
        SPADE("S"),
        DIAMOND("D"),
        HEART("H");

        private String val;

        Suit(String val) {
            this.val = val;
        }
    }
}
