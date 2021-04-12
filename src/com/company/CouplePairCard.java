package com.company;

import java.util.ArrayList;
import java.util.List;

public class CouplePairCard implements CheckDeckOfCard {

    private static final int INDEX_FIRS_ELEMENT = 0;
    private static final int COUNTER_COUPLE_PAIR = 2;

    @Override
    public List<Card> execute(List<Card> cards) {
        PairCard pairCard = new PairCard();
        List<Card> cardsCopy = new ArrayList<>(cards);

        List<Card> couplePairCards = new ArrayList<>();
        int counter = 0;
        for (int index = 0; index < 2; index++) {
            List<Card> resultPairCard = pairCard.execute(cardsCopy);
            if (!resultPairCard.isEmpty()) {
                couplePairCards.addAll(resultPairCard);
                counter++;
                int pairCardValue = resultPairCard.get(INDEX_FIRS_ELEMENT).getValue();
                cardsCopy.removeIf(x -> x.getValue() == pairCardValue);
            }
        }

        if (counter == COUNTER_COUPLE_PAIR) {
            return couplePairCards;
        }

        return new ArrayList<>();
    }

}
