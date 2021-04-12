package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Card implements Comparable<Card> {

    private static final String CARD_TEMPLATE = "name = %s, value: %d, symbol: %s";

    private char name;
    private Integer value;
    private char symbol;

    public Card(char name, int value, char symbol) {
        this.name = name;
        this.value = value;
        this.symbol = symbol;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public static List<Card> getCardsFromList(List<String> c) {
        List<Card> cardsObject = new ArrayList<>();
        for (String cc : c) {
            char name = cc.charAt(0);
            char symbol = cc.charAt(1);
            int value = getValue(cc);
            Card card = new Card(name, value, symbol);
            cardsObject.add(card);
        }

        return cardsObject;
    }

    private static int getValue(String cc) {
        int value;
        switch (cc.charAt(0)) {
            case 'T':
                value = 10;
                break;
            case 'J':
                value = 11;
                break;
            case 'Q':
                value = 12;
                break;
            case 'K':
                value = 13;
                break;
            case 'A':
                value = 14;
                break;
            default:
                value = Character.getNumericValue(cc.charAt(0));
        }

        return value;
    }

    @Override
    public String toString() {
        return String.format(CARD_TEMPLATE, name, value, symbol);
    }

    @Override
    public int compareTo(Card card) {
        return this.value.compareTo(card.getValue());
    }

}
