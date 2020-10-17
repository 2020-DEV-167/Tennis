package com.example.kata.tennis.domain;

import com.example.kata.tennis.domain.exception.PlayerNameCannotBeBlankException;

import static com.example.kata.tennis.domain.Score.*;

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

    public void playerOneScores() {
        scores(getPlayerOne());
    }

    public void playerTwoScores() {
        scores(getPlayerTwo());
    }

    public void scores(final Player scoringPlayer) {
        switch (scoringPlayer.getScore()) {
            case ZERO:
                scoringPlayer.setScores(FIFTEEN);
                break;
            case FIFTEEN:
                scoringPlayer.setScores(THIRTY);
                break;
            case THIRTY:
                scoringPlayer.setScores(FORTY);
                break;
        }
    }
}
