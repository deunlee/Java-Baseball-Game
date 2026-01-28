package com.deunlee.baseball.model;

public class ComparisonResult {
    private static final int WIN_STRIKES = 3;
    private static final int NOTHING     = 0;

    private final int strikes;
    private final int balls;

    public ComparisonResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls   = balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public boolean isWin() {
        return strikes == WIN_STRIKES;
    }

    public boolean isNothing() {
        return strikes == NOTHING && balls == NOTHING;
    }
}
