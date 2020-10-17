package com.example.kata.tennis.domain;

import com.example.kata.tennis.domain.exception.PlayerNameCannotBeBlankException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TennisGameTest {

    private TennisGame game;

    @BeforeEach
    void setUp() throws PlayerNameCannotBeBlankException {
        game = new TennisGame("BNP", "PF");
    }

    @DisplayName("Given a game is created, 2 players are available")
    @Test
    void playersAreCreated() {
        assertThat(game.getPlayerOne()).isNotNull();
        assertThat(game.getPlayerTwo()).isNotNull();
    }

    @DisplayName("Given a game is created, the players can be identified")
    @Test
    void playersHaveNames() {
        assertThat(game.getPlayerOne().getName()).isEqualTo("BNP");
        assertThat(game.getPlayerTwo().getName()).isEqualTo("PF");
    }
}