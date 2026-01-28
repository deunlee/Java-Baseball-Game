package com.deunlee.baseball.controller;

import com.deunlee.baseball.model.BaseballGame;
import com.deunlee.baseball.model.BaseballNumberGenerator;
import com.deunlee.baseball.model.ComparisonResult;
import com.deunlee.baseball.view.TextInputView;
import com.deunlee.baseball.view.TextOutputView;

public class GameController {
    private final TextInputView  inputView;
    private final TextOutputView outputView;

    public GameController() {
        this.inputView  = new TextInputView();
        this.outputView = new TextOutputView();
    }

    public void run() {
        outputView.printStartMessage();
        boolean isContinue = true;
        while (isContinue) {
            playGame();
            isContinue = shouldRestart();
        }
    }

    private void playGame() {
        final BaseballGame game = new BaseballGame(new BaseballNumberGenerator());
        ComparisonResult result = null;
        while (result == null || !result.isWin()) {
            result = processGuess(game);
        }
        outputView.printWinMessage();
    }

    private boolean shouldRestart() {
        outputView.printRestartPrompt();
        try {
        } catch (IllegalArgumentException e) {
            handleError(e);
            return shouldRestart();
        }
    }

    private ComparisonResult processGuess(BaseballGame game) {
        try {
            outputView.printGuessPrompt();
        } catch (IllegalArgumentException e) {
            handleError(e);
            return null;
        }
    }

    private void handleError(IllegalArgumentException e) {
        outputView.printError(e.getMessage());
    }
}
