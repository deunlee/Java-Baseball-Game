package com.deunlee.baseball.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextInputView {
    private static final int REQUIRED_LENGTH  = 3;
    private static final int RESTART_DECISION = 1;

    public List<Integer> readPlayerGuess() {
        final String input = readLine();
        validateLength(input, REQUIRED_LENGTH);
        return convertToDigits(input);
    }

    public boolean readRestartDecision() {
        final String input = readLine();
        validateLength(input, 1);
        int decision = convertToDigit(input.charAt(0));
        validateRestartDecision(decision);
        return decision == RESTART_DECISION;
    }

    private String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int convertToDigit(char c) {
        validateDigit(c);
        return c - '0';
    }

    private List<Integer> convertToDigits(final String input) {
        List<Integer> digits = new ArrayList<>();
        for (char c : input.toCharArray()) {
            digits.add(convertToDigit(c));
        }
        return digits;
    }

    private void validateLength(final String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException(length + "자리 숫자를 입력해야 합니다.");
        }
    }

    private void validateDigit(final char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    private void validateRestartDecision(int decision) {
        if (decision != 1 && decision != 2) {
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
    }
}
