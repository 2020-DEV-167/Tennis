package com.example.kata.tennis.domain;

import com.example.kata.tennis.domain.exception.PlayerNameCannotBeBlankException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    @DisplayName("Player name cannot be blank")
    @Test
    void playerNameIsNotBlank() {
        assertThrows(PlayerNameCannotBeBlankException.class, () -> new Player(""));
    }
}
