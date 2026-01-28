package com.deunlee.baseball.view;

import com.deunlee.baseball.model.ComparisonResult;

public class TextOutputView {

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void printGuessPrompt() {
        System.out.print("숫자를 입력해주세요 : ");
    }
    public void printWinMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
    public void printRestartPrompt() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printResult(final ComparisonResult result) {
        if (result.isNothing()) {
            System.out.println("낫싱");
            return;
        }
        if (result.hasOnlyBalls()) {
            System.out.println(result.getBalls() + "볼");
            return;
        }
        if (result.hasOnlyStrikes()) {
            System.out.println(result.getStrikes() + "스트라이크");
            return;
        }
        System.out.println(result.getBalls() + "볼 " + result.getStrikes() + "스트라이크");
    }
}
