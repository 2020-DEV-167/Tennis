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

        game.playerOneScores();

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

    @DisplayName("Given a player scores and the game was deuce, then he has advantage")
    @Test
    void playerHasAdvantageIfScoreOnDeuce() {
        final Player playerOne = game.getPlayerOne();
        final Player playerTwo = game.getPlayerTwo();
        playerOne.setScores(Score.FORTY);
        playerTwo.setScores(Score.FORTY);

        game.playerTwoScores();

        assertThat(playerOne.getScore()).isEqualTo(Score.FORTY);
        assertThat(playerTwo.getScore()).isEqualTo(Score.ADVANTAGE);
    }

    @DisplayName("Given a player has advantage and the other player scores, then we are back to deuce")
    @Test
    void gameIsDeuceIfPlayerScoresAgainstAdvantage() {
        final Player playerOne = game.getPlayerOne();
        final Player playerTwo = game.getPlayerTwo();
        playerOne.setScores(Score.ADVANTAGE);
        playerTwo.setScores(Score.FORTY);

        game.playerTwoScores();

        assertThat(playerOne.getScore()).isEqualTo(Score.FORTY);
        assertThat(playerTwo.getScore()).isEqualTo(Score.FORTY);
    }

    @DisplayName("Given player scores on forty (no deuce), the game is done")
    @Test
    void gameIsDoneIfPlayerOneHasWon() {
        final Player playerOne = game.getPlayerOne();
        playerOne.setScores(Score.FORTY);

        game.playerOneScores();

        assertThat(game.isWon()).isTrue();
    }

    @DisplayName("Given player scores with advantage, the game is done")
    @Test
    void gameIsDoneIfPlayerTwoHasWon() {
        final Player playerTwo = game.getPlayerTwo();
        playerTwo.setScores(Score.ADVANTAGE);

        game.playerTwoScores();

        assertThat(game.isWon()).isTrue();
    }

    @DisplayName("Given players didn't win yet, game is not done")
    @Test
    void gameIsNotDoneIfNoOneHasWonYet() {
        assertThat(game.isWon()).isFalse();
    }
}