package com.example.kata.tennis.domain;

import com.example.kata.tennis.domain.exception.PlayerNameCannotBeBlankException;

public class TennisGame {

    private final Player playerOne;
    private final Player playerTwo;

    public TennisGame(final String playerOneName, final String playerTwoName) throws PlayerNameCannotBeBlankException {
        this.playerOne = new Player(playerOneName);
        this.playerTwo = new Player(playerTwoName);
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }
}
