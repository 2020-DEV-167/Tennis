package com.example.kata.tennis.domain;

import com.example.kata.tennis.domain.exception.PlayerNameCannotBeBlankException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() throws PlayerNameCannotBeBlankException {
        player = new Player("BNP");
    }

    @DisplayName("Player name cannot be blank")
    @Test
    void playerNameIsNotBlank() {
        assertThrows(PlayerNameCannotBeBlankException.class, () -> new Player(""));
    }

    @DisplayName("Player score is initialized at zero")
    @Test
    void playerScoreIsZero() {
        assertThat(player.getScore()).isEqualTo(Score.ZERO);
    }

    @DisplayName("Player has advantage if his score is ADVANTAGE")
    @Test
    void playerHasAdvantage() {
        player.setScores(Score.ADVANTAGE);

        assertThat(player.hasAdvantage()).isTrue();
    }

    @DisplayName("Player has not advantage if his score is not ADVANTAGE")
    @Test
    void playerHasNotAdvantage() {
        player.setScores(Score.FORTY);

        assertThat(player.hasAdvantage()).isFalse();
    }
}
