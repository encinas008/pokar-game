package com.company;

import java.util.ArrayList;
import java.util.List;

public class ThreeCard implements CheckDeckOfCard {

    private static final int COUNTER_FOR_THREE_CARD_SAME_VALUE = 3;
    private static final int MAXIMUM_INDEX_TO_REVIEW = 2;
    private static final int INDEX_ADDITIONAL = 3;

    @Override
    public List<Card> execute(List<Card> cards) {
        List<Card> cardsCopy = new ArrayList<>(cards);

        for (int index = 0; index <= MAXIMUM_INDEX_TO_REVIEW; index = index + 2) {
            Card card = cardsCopy.get(index);
            int counter = counterByDigit(cardsCopy, card.getValue());
            if (counter == COUNTER_FOR_THREE_CARD_SAME_VALUE) {
                int indexLimit = index + INDEX_ADDITIONAL;
                return cardsCopy.subList(index, indexLimit);
            }
        }

        return new ArrayList<>();
    }

    private int counterByDigit(List<Card> cards, int value) {
        int counter = 0;
        for (Card card : cards) {
            if (card.getValue() == value) {
                counter++;
            }
        }

        return counter;
    }

}
