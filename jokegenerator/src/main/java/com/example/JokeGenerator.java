package com.example;

import java.util.Random;

public class JokeGenerator {

    /**
     * @return a random joke
     */
    public static String getJoke(){
        int randNumber = new Random().nextInt(10000);
        return "Joke " + randNumber;
    }
}
