package com.company;

import java.util.ArrayList;
import java.util.List;

public class FourClass implements CheckDeckOfCard {

    private static final int COUNTER_FOUR_OF_CLASS = 4;
    private static final int MAXIMUM_INDEX_TO_REVIEW = 2;

    @Override
    public List<Card> execute(List<Card> cards) {
        for(int index = 0; index < MAXIMUM_INDEX_TO_REVIEW; index++) {
            Card card = cards.get(index);
            int counter = counterByDigit(cards, card.getValue());
            if (counter == COUNTER_FOUR_OF_CLASS) {
                return cards;
            }
        }

        return new ArrayList<>();
    }

    private int counterByDigit(List<Card> cards, int value) {
        int counter = 0;
        for (Card card : cards) {
            if (card.getValue() != value) {
                return 0;
            }
            counter++;
        }

        return counter;
    }

}
