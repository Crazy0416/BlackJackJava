package com.blackjack.www;

public class Card {

    private final String PATTERN;
    private final int NUMBER;

    public Card(String pattern, int number) {
        PATTERN = pattern;
        NUMBER = number;
    }

    public String getPATTERN() {
        return PATTERN;
    }

    public int getNUMBER() {
        return NUMBER;
    }
}
