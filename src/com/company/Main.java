package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String fileName = "D:\\dara\\encinas-repo\\pokar-game\\src\\com\\company\\poker.txt";
        Game game = new Game();
        try {
            List<String> list = readDeckOfCards(fileName);
            for (String cards: list) {
                System.out.println(cards);
                game.play(cards);
            }
            System.out.println("Wins player I :" + game.getCounterWinsPlayerOne());
            System.out.println("Wins player II :" + game.getCounterWinsPlayerTwo());
            System.out.println("Total: " + (game.getCounterWinsPlayerOne() + game.getCounterWinsPlayerTwo()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readDeckOfCards(String fileName) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            result = lines.collect(Collectors.toList());
        }
        return result;
    }

}
