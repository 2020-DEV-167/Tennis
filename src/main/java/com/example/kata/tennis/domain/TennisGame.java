package com.example.kata.tennis.domain;

public class TennisGame {

    private final Player playerOne;
    private final Player playerTwo;

    public TennisGame() {
        this.playerOne = new Player();
        this.playerTwo = new Player();
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }
}
