package com.deunlee.baseball.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextInputView {

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
