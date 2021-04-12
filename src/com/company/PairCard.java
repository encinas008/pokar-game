package com.company;

import java.util.ArrayList;
import java.util.List;

public class PairCard implements CheckDeckOfCard{

    private static final int COUNTER_FOR_SAME_VALUE = 2;
    private static final int INDEX_ADDITIONAL = 2;

    @Override
    public List<Card> execute(List<Card> cards) {
        List<Card> cardsCopy = new ArrayList<>(cards);

        Card maximumPairCard = null;
        int indexMaximumCard = -1;

        int index = 0;
        int limitIndexToCheckPair = cardsCopy.size() - 1;
        while (index < limitIndexToCheckPair) {
            Card card = cardsCopy.get(index);
            int counter = counterByDigit(cardsCopy, card.getValue());
            if (counter == COUNTER_FOR_SAME_VALUE) {
                if (maximumPairCard == null) {
                    maximumPairCard = card;
                    indexMaximumCard = index;
                }

                if (card.getValue() > maximumPairCard.getValue()) {
                    maximumPairCard = card;
                    indexMaximumCard = index;
                }
            }
            index = index + 1;
        }

        if (maximumPairCard != null)  {
            int limitIndex = indexMaximumCard + INDEX_ADDITIONAL;
            List<Card> subList = cardsCopy.subList(indexMaximumCard, limitIndex);
            return subList;
        }

        return new ArrayList<>();
    }

    private int counterByDigit(List<Card> cards, int value) {
        int counter = 0;
        for (Card card : cards) {
            if (card.getValue() == value) {
                counter++;
            }

            if (counter == COUNTER_FOR_SAME_VALUE) {
                return counter;
            }
        }

        return counter;
    }

}
