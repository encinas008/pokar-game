package com.company;

import java.util.List;

public class Player {

    private final List<Card> cards;

    public Player(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> play(CheckDeckOfCard checkDeckOfCard) {
        return checkDeckOfCard.execute(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

}
