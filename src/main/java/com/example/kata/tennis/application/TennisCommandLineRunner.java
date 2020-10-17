package com.example.kata.tennis.application;

import com.example.kata.tennis.domain.TennisGame;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TennisCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(final String... args) throws Exception {
        final TennisGame game = new TennisGame("BNP", "PF");

        game.playerOneScores();
        game.playerTwoScores();

        System.out.println(game.getPlayerOne().getScore());
    }
}
