package com.example.kata.tennis.application;

import com.example.kata.tennis.domain.TennisGame;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class TennisCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(final String... args) throws Exception {
        final String playerOneName = "BNP";
        final String playerTwoName = "PF";

        final TennisGame game = new TennisGame(playerOneName, playerTwoName);

        printGameState(game);

        while (!game.isWon()) {
            play(game);
            printGameState(game);
        }
    }

    private void play(final TennisGame game) {
        String scoringPlayer = readScoringPlayer();

        if (scoringPlayer.equals(game.getPlayerOne().getName())) {
            game.playerOneScores();
        }
        else if (scoringPlayer.equals(game.getPlayerTwo().getName())) {
            game.playerTwoScores();
        }
        else {
            System.out.println("This player name is unknown to our system. Please try again.");
        }
    }

    private void printGameState(final TennisGame game) {
        System.out.println(game);
    }

    private String readScoringPlayer() {
        String name;
        System.out.println("Please provide the name of the scoring player.");
        System.out.print("> ");
        name = readInput();
        while (name.isBlank()) {
            System.out.println("Invalid name. The name must contain characters. Please try again.");
            System.out.print("> ");
            name = readInput();
        }
        return name;
    }

    private String readInput() {
        final Scanner inScanner = new Scanner(System.in);
        return inScanner.nextLine();
    }
}
