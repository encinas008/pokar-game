package com.company;

import java.util.Comparator;
import java.util.List;

public class HighCard implements CheckDeckOfCard {

    @Override
    public List<Card> execute(List<Card> cards) {
        cards.sort(Comparator.reverseOrder());
        return cards;
    }

}
