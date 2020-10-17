package com.example.kata.tennis.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TennisGameTest {

    private TennisGame game;

    @BeforeEach
    void setUp() {
        game = new TennisGame();
    }

    @DisplayName("Given a game is created, 2 players are available")
    @Test
    void playersAreCreated() {
        assertThat(game.getPlayerOne()).isNotNull();
        assertThat(game.getPlayerTwo()).isNotNull();
    }
}