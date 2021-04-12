package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ColorCard implements CheckDeckOfCard {

    private static final int INDEX_FIRST_ELEMENT = 0;

    @Override
    public List<Card> execute(List<Card> cards) {
        Card card = cards.get(INDEX_FIRST_ELEMENT);
        for (int index = 1; index < cards.size(); index++) {
            Card currentCard = cards.get(index);
            if (card.getSymbol() != currentCard.getSymbol()) {
                return new ArrayList<>();
            }
        }

        return cards;
    }

}
