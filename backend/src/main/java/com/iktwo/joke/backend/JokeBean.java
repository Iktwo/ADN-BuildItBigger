package com.iktwo.joke.backend;

import com.iktwo.JokeTeller;

public class JokeBean {
    private JokeTeller jokeTeller = new JokeTeller();

    public String getJoke() {
        return jokeTeller.getJoke();
    }
}