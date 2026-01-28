package com.deunlee.baseball.model;

public class BaseballGame {
    private final Numbers answer;

    public BaseballGame(IRandomNumberGenerator generator) {
        this.answer = new Numbers(generator.generateUniqueNumbers());
    }

    public ComparisonResult checkResult(final Numbers playerNumbers) {
        int strikes = countStrikes(answer, playerNumbers);
        int balls   = countBalls(answer, playerNumbers);
        return new ComparisonResult(strikes, balls);
    }

    private int countStrikes(final Numbers answer, final Numbers guess) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.getDigitAt(i) == guess.getDigitAt(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    private int countBalls(final Numbers answer, final Numbers guess) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.getDigitAt(i) == guess.getDigitAt(i)) {
                continue; // 스트라이크는 제외
            }
            if (answer.contains(guess.getDigitAt(i))) {
                balls++;
            }
        }
        return balls;
    }
}
