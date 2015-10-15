package com.iktwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeTeller {
    private List<String> jokes;
    private Random random;

    public JokeTeller() {
        jokes = new ArrayList<>();
        jokes.add("I would tell you a UDP joke, but you might not get it.");
        jokes.add("What do you call 8 Hobbits? A Hobbyte ");
        jokes.add("There are 10 types of people, those who understand tertiary, those who don't, and those who thought this was a binary joke");
        jokes.add("Yo momma so fat that the recursive function to calculate her weight causes a stack overflow.");
    }

    public String getJoke() {
        return jokes.get(new Random().nextInt(jokes.size()));
    }
}
