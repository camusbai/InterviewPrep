package com.camusbai.exercise.design;

public class Main {
    public static void main(String[] args) {
        DeckCard deck = new DeckCard();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);
    }
}
