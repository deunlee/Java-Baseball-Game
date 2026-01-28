package com.deunlee.baseball.controller;

import com.deunlee.baseball.model.BaseballGame;
import com.deunlee.baseball.model.BaseballNumberGenerator;
import com.deunlee.baseball.model.ComparisonResult;
import com.deunlee.baseball.model.Numbers;
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
            return inputView.readRestartDecision();
        } catch (IllegalArgumentException e) {
            handleError(e);
            return shouldRestart(); // 잘못된 값을 입력하면 다시 물어봄
        }
    }

    private ComparisonResult processGuess(BaseballGame game) {
        try {
            outputView.printGuessPrompt();
            final Numbers playerNumbers = new Numbers(inputView.readPlayerGuess());
            final ComparisonResult result = game.checkResult(playerNumbers);
            outputView.printResult(result);
            return result;
        } catch (IllegalArgumentException e) {
            handleError(e);
            return null;
        }
    }

    private void handleError(IllegalArgumentException e) {
        outputView.printError(e.getMessage());
    }
}
