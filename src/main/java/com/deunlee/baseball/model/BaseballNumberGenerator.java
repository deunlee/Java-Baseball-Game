package com.deunlee.baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballNumberGenerator implements IRandomNumberGenerator {
    private static final int REQUIRED_SIZE = 3;

    private final Random random = new Random();

    @Override
    public List<Integer> generateUniqueNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < REQUIRED_SIZE) {
            int number = random.nextInt(10); // 0~9
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }
}
