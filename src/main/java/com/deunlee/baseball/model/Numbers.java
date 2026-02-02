package com.deunlee.baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Numbers {
    private static final int REQUIRED_SIZE = 3;
    private static final int MIN_DIGIT     = 1;
    private static final int MAX_DIGIT     = 9;

    private final List<Integer> digits;

    public Numbers(List<Integer> digits) {
        validateSize(digits);
        validateRange(digits);
        validateUnique(digits);
        this.digits = new ArrayList<>(digits);
    }

    private void validateSize(final List<Integer> digits) {
        if (digits.size() != REQUIRED_SIZE) {
            throw new IllegalArgumentException("숫자는 " + REQUIRED_SIZE + "개여야 합니다.");
        }
    }

    private void validateRange(final List<Integer> digits) {
        for (int digit : digits) {
            if (digit < MIN_DIGIT || digit > MAX_DIGIT) {
                throw new IllegalArgumentException("숫자는 " + MIN_DIGIT + "부터 " + MAX_DIGIT + " 사이여야 합니다.");
            }
        }
    }

    private void validateUnique(final List<Integer> digits) {
        if (new HashSet<>(digits).size() != digits.size()) {
            throw new IllegalArgumentException("숫자는 중복될 수 없습니다.");
        }
    }

    public int getDigitAt(int position) {
        return digits.get(position);
    }

    public boolean contains(int digit) {
        return digits.contains(digit);
    }

    public int size() {
        return digits.size();
    }
}
