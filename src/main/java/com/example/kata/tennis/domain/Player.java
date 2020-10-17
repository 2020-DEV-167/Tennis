package com.example.kata.tennis.domain;

import com.example.kata.tennis.domain.exception.PlayerNameCannotBeBlankException;

public class Player {

    private final String name;

    public Player(final String name) throws PlayerNameCannotBeBlankException {
        if (name.isBlank()) {
            throw new PlayerNameCannotBeBlankException();
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
