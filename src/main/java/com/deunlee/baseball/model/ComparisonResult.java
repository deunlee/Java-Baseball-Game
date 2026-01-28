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

    public int     getStrikes()     { return strikes;      }
    public int     getBalls()       { return balls;        }
    public boolean isWin()          { return strikes == 3; }
    public boolean isNothing()      { return strikes == 0 && balls  == 0; }
    public boolean hasOnlyBalls()   { return strikes == 0 && balls   > 0; }
    public boolean hasOnlyStrikes() { return balls   == 0 && strikes > 0; }
}
