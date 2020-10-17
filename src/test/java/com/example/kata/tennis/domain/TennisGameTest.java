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

    @DisplayName("Given a player scores and its score was zero, then his score is fitfeen")
    @Test
    void playersCanScoreFromZeroToFifteen() {
        final Player scoringPlayer = game.getPlayerOne();

        game.scores(scoringPlayer);

        assertThat(scoringPlayer.getScore()).isEqualTo(Score.FIFTEEN);
    }

    @DisplayName("Given a player scores and its score was fifteen, then his score is thirty")
    @Test
    void playersCanScoreFromFifteenToThirty() {
        final Player scoringPlayer = game.getPlayerOne();
        scoringPlayer.setScores(Score.FIFTEEN);

        game.playerOneScores();

        assertThat(scoringPlayer.getScore()).isEqualTo(Score.THIRTY);
    }

    @DisplayName("Given a player scores and its score was thirty, then his score is forty")
    @Test
    void playersCanScoreFromThirtyToForty() {
        final Player scoringPlayer = game.getPlayerTwo();
        scoringPlayer.setScores(Score.THIRTY);

        game.playerTwoScores();

        assertThat(scoringPlayer.getScore()).isEqualTo(Score.FORTY);
    }
}