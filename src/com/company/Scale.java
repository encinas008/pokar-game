package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Scale implements CheckDeckOfCard {

    private static final int DIFFERENCE_OF_ONE = 1;
    private static final int INDEX_FIRST_ELEMENT = 0;

    @Override
    public List<Card> execute(List<Card> cards) {
        cards.sort(Comparator.naturalOrder());

        Card card = cards.get(INDEX_FIRST_ELEMENT);
        for (int index = 1; index < cards.size(); index++) {
            Card currentCard = cards.get(index);
            int difference = currentCard.getValue() - card.getValue();
            if (difference != DIFFERENCE_OF_ONE) {
                return new ArrayList<>();
            }
            card = cards.get(index);
        }

        return cards;
    }

}
