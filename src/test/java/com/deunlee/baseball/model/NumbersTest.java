package com.deunlee.baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {

    @DisplayName("3개의 서로 다른 1~9 숫자로 생성")
    @Test
    void createValidNumbers() {
        Numbers numbers = new Numbers(List.of(1, 2, 3));

        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers.getDigitAt(0)).isEqualTo(1);
        assertThat(numbers.getDigitAt(1)).isEqualTo(2);
        assertThat(numbers.getDigitAt(2)).isEqualTo(3);
    }

    @DisplayName("contains 메서드로 숫자 포함 여부 확인")
    @Test
    void testContains() {
        Numbers numbers = new Numbers(List.of(1, 2, 3));

        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
        assertThat(numbers.contains(4)).isFalse();
    }

    @DisplayName("2개의 숫자는 예외 발생")
    @Test
    void throwExceptionWhenSizeIsTwo() {
        assertThatThrownBy(() -> new Numbers(List.of(1, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 3개여야 합니다.");
    }

    @DisplayName("4개의 숫자는 예외 발생")
    @Test
    void throwExceptionWhenSizeIsFour() {
        assertThatThrownBy(() -> new Numbers(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 3개여야 합니다.");
    }

    @DisplayName("중복된 숫자는 예외 발생")
    @Test
    void throwExceptionWhenDuplicate() {
        assertThatThrownBy(() -> new Numbers(List.of(1, 1, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 중복될 수 없습니다.");
    }

    @DisplayName("0은 예외 발생")
    @Test
    void throwExceptionWhenZero() {
        assertThatThrownBy(() -> new Numbers(List.of(0, 1, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 1부터 9 사이여야 합니다.");
    }

    @DisplayName("10 이상은 예외 발생")
    @Test
    void throwExceptionWhenTenOrMore() {
        assertThatThrownBy(() -> new Numbers(List.of(1, 2, 10)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 1부터 9 사이여야 합니다.");
    }

    @DisplayName("음수는 예외 발생")
    @Test
    void throwExceptionWhenNegative() {
        assertThatThrownBy(() -> new Numbers(List.of(-1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 1부터 9 사이여야 합니다.");
    }
}
