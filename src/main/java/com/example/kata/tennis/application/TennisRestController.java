package com.example.kata.tennis.application;

import com.example.kata.tennis.application.dto.TennisGameInfo;
import com.example.kata.tennis.domain.TennisGame;
import com.example.kata.tennis.domain.exception.PlayerNameCannotBeBlankException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tennis")
public class TennisRestController {

    private TennisGame game;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<TennisGame> newGame(@RequestBody TennisGameInfo gameInfo)
            throws PlayerNameCannotBeBlankException {

        game = new TennisGame(gameInfo.getPlayerOneName(), gameInfo.getPlayerTwoName());

        return ResponseEntity.ok(game);
    }

    @GetMapping(value = "/score", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<TennisGame> getScore() {
        return ResponseEntity.ok(game);
    }

    @PostMapping(value = "/score/{playerName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<TennisGame> setScore(@PathVariable final String playerName) {
        if (playerName.isBlank()) {
            throw new IllegalArgumentException("Unknown player name.");
        }

        if (game.getPlayerOne().getName().equals(playerName)) {
            game.playerOneScores();
        }
        else if (game.getPlayerTwo().getName().equals(playerName)) {
            game.playerTwoScores();
        }

        return ResponseEntity.ok(game);
    }
}
