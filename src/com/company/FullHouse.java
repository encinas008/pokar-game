package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FullHouse implements CheckDeckOfCard {

    @Override
    public List<Card> execute(List<Card> cards) {
        List<Card> cardsCopy = new ArrayList<>(cards);

        cardsCopy.sort(Comparator.reverseOrder());
        ThreeCard threeCard = new ThreeCard();

        List<Card> resultThreeCard = threeCard.execute(cardsCopy);

        if (!resultThreeCard.isEmpty()) {
            List<Card> result = new ArrayList<>(resultThreeCard);
            cardsCopy.removeIf(resultThreeCard::contains);
            PairCard pairCard = new PairCard();
            List<Card> resultPairCard = pairCard.execute(cardsCopy);
            if (!resultPairCard.isEmpty()) {
                result.addAll(resultPairCard);
                return result;
            }

            return new ArrayList<>();
        }

        return new ArrayList<>();
    }

}
