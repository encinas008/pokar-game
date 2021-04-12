package com.company;

import java.util.*;

public class Game {

    private static final String DELIMITER_CARDS = " ";

    private Player playerOne;
    private Player playerTwo;

    private int counterWinsPlayerOne;
    private int counterWinsPlayerTwo;

    private Map<PriorityGame, CheckDeckOfCard> mapPriorityGames = new HashMap();

    private List<PriorityGame> gamesToPlayWithHighCard = Arrays.asList(
            PriorityGame.REAL_SCALE
    );

    public Game() {
        mapPriorityGames.put(PriorityGame.REAL_SCALE, new RealScale());
        mapPriorityGames.put(PriorityGame.COLOR_SCALE, new ColorScale());
        mapPriorityGames.put(PriorityGame.FOUR_OF_CLASS, new FourClass());
        mapPriorityGames.put(PriorityGame.FULL_HOUSE, new FullHouse());
        mapPriorityGames.put(PriorityGame.COLOR, new ColorCard());
        mapPriorityGames.put(PriorityGame.SCALE, new Scale());
        mapPriorityGames.put(PriorityGame.THREE_CARDS_SAME_VALUE, new ThreeCard());
        mapPriorityGames.put(PriorityGame.COUPLE_PAIR_CARD, new CouplePairCard());
        mapPriorityGames.put(PriorityGame.PAIR_CARD, new PairCard());
        mapPriorityGames.put(PriorityGame.HIGH_CARD, new HighCard());
    }

    public void play(String cards) {
        String[] arrayCards = cards.split(DELIMITER_CARDS);
        List<String> listCards = Arrays.asList(arrayCards);

        List<Card> cardsPlayerOne = Card.getCardsFromList(listCards.subList(0, 5));
        List<Card> cardsPlayerTwo = Card.getCardsFromList(listCards.subList(5, 10));

        cardsPlayerOne.sort(Comparator.reverseOrder());
        cardsPlayerTwo.sort(Comparator.reverseOrder());

        playerOne = new Player(cardsPlayerOne);
        playerTwo = new Player(cardsPlayerTwo);

        getWinner(playerOne, playerTwo);
    }

    public void getWinner(Player playerOne, Player playerTwo) {
        PriorityGame[] priorityGames = PriorityGame.values();

        for (PriorityGame priorityGame : priorityGames) {
            CheckDeckOfCard gameToPlay = mapPriorityGames.get(priorityGame);
            List<Card> cardsPlayerOne = playerOne.play(gameToPlay);
            List<Card> cardsPlayerTwo = playerTwo.play(gameToPlay);

            if (!cardsPlayerOne.isEmpty() && cardsPlayerTwo.isEmpty()) {
                counterWinsPlayerOne++;
                return;
            }

            if (cardsPlayerOne.isEmpty() && !cardsPlayerTwo.isEmpty()) {
                counterWinsPlayerTwo++;
                return;
            }

            if (priorityGame != PriorityGame.REAL_SCALE && priorityGame != PriorityGame.HIGH_CARD) {
                boolean winnerByCards = getWinnerByCards(cardsPlayerOne, cardsPlayerTwo);
                if (winnerByCards) {
                    return;
                }

                if (!cardsPlayerOne.isEmpty() && !cardsPlayerTwo.isEmpty()) {
                    getWinnerByHighCard(cardsPlayerOne, cardsPlayerTwo, true);
                    return;
                }
            }

            if (priorityGame == PriorityGame.HIGH_CARD) {
                getWinnerByHighCard(playerOne.getCards(), playerTwo.getCards(), false);
            }
        }
    }

    private boolean getWinnerByCards(List<Card> cardsPlayerOne, List<Card> cardsPlayerTwo) {
        if (!cardsPlayerOne.isEmpty() && !cardsPlayerTwo.isEmpty()) {
            for (int index = 0; index < cardsPlayerOne.size(); index++) {
                Card highCardPlayerOne = cardsPlayerOne.get(index);
                Card highCardPlayerTwo = cardsPlayerTwo.get(index);
                if (highCardPlayerOne.getValue() > highCardPlayerTwo.getValue()) {
                    counterWinsPlayerOne++;
                    return Boolean.TRUE;
                }

                if (highCardPlayerTwo.getValue() > highCardPlayerOne.getValue()) {
                    counterWinsPlayerTwo++;
                    return Boolean.TRUE;
                }
            }
        }

        return Boolean.FALSE;
    }

    private void getWinnerByHighCard(List<Card> cardsPlayerOne, List<Card> cardsPlayerTwo, boolean delete) {
        if (!cardsPlayerOne.isEmpty() && !cardsPlayerTwo.isEmpty()) {
            if (delete) {
                playerOne.getCards().removeIf(cardsPlayerOne::contains);
                playerTwo.getCards().removeIf(cardsPlayerTwo::contains);
            }

            playerOne.getCards().sort(Comparator.reverseOrder());
            playerTwo.getCards().sort(Comparator.reverseOrder());

            for (int index = 0; index < playerOne.getCards().size(); index++) {
                Card highCardPlayerOne = playerOne.getCards().get(index);
                Card highCardPlayerTwo = playerTwo.getCards().get(index);
                if (highCardPlayerOne.getValue() > highCardPlayerTwo.getValue()) {
                    counterWinsPlayerOne++;
                    return;
                }

                if (highCardPlayerTwo.getValue() > highCardPlayerOne.getValue()) {
                    counterWinsPlayerTwo++;
                    return;
                }
            }

            System.out.println("NO WINNER same deck of cards.");
        }
    }

    public int getCounterWinsPlayerOne() {
        return counterWinsPlayerOne;
    }

    public int getCounterWinsPlayerTwo() {
        return counterWinsPlayerTwo;
    }

}
