package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RealScale implements CheckDeckOfCard {

    private static final int DIFFERENCE_OF_ONE = 1;
    private static final int INDEX_FIRST_ELEMENT = 0;
    private static final char AS_CARD = 'A';

    @Override
    public List<Card> execute(List<Card> cards) {
        Card firstCard = cards.get(INDEX_FIRST_ELEMENT);
        if (firstCard.getName() != AS_CARD) {
            return new ArrayList<>();
        }

        cards.sort(Comparator.naturalOrder());

        Card card = cards.get(INDEX_FIRST_ELEMENT);
        for (int index = 1; index < cards.size(); index++) {
            Card currentCard = cards.get(index);
            int difference = currentCard.getValue() - card.getValue();
            if (difference != DIFFERENCE_OF_ONE || card.getSymbol() != currentCard.getSymbol()) {
                return new ArrayList<>();
            }
            card = cards.get(index);
        }

        return cards;
    }

}
