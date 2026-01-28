package com.deunlee.baseball.model;

public class BaseballGame {
    private final Numbers answer;

    public BaseballGame(IRandomNumberGenerator generator) {
        this.answer = new Numbers(generator.generateUniqueNumbers());
    }

    public ComparisonResult checkResult(Numbers playerNumbers) {
        int strikes = countStrikes(answer, playerNumbers);
        int balls   = countBalls(answer, playerNumbers);
        return new ComparisonResult(strikes, balls);
    }

    private int countStrikes(Numbers answer, Numbers guess) {
    }


    private int countBalls(Numbers answer, Numbers guess) {
    }

}
