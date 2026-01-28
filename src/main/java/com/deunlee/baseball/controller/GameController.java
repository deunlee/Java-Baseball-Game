package com.deunlee.baseball.controller;

import com.deunlee.baseball.model.BaseballGame;
import com.deunlee.baseball.model.BaseballNumberGenerator;
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
        BaseballGame game = new BaseballGame(new BaseballNumberGenerator());
    }

    private boolean shouldRestart() {
        outputView.printRestartPrompt();
        try {
        } catch (IllegalArgumentException e) {
            handleError(e);
            return shouldRestart();
        }
    }


    private void handleError(IllegalArgumentException e) {
        outputView.printError(e.getMessage());
    }
}
