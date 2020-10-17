package com.example.kata.tennis.domain;

import com.example.kata.tennis.domain.exception.PlayerNameCannotBeBlankException;

public class Player {

    private final String name;
    private Score score;

    public Player(final String name) throws PlayerNameCannotBeBlankException {
        if (name.isBlank()) {
            throw new PlayerNameCannotBeBlankException();
        }

        this.name = name;
        this.score = Score.ZERO;
    }

    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }

    protected void setScores(final Score score) {
        this.score = score;
    }
}
