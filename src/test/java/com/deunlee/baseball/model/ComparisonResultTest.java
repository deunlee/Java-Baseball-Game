package com.deunlee.baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComparisonResultTest {

    @Test
    @DisplayName("3스트라이크는 승리")
    void testWin() {
        ComparisonResult result = new ComparisonResult(3, 0);

        assertThat(result.isWin()).isTrue();
        assertThat(result.getStrikes()).isEqualTo(3);
        assertThat(result.getBalls()).isEqualTo(0);
    }

    @Test
    @DisplayName("볼만 있는 경우")
    void testOnlyBalls() {
        ComparisonResult result = new ComparisonResult(0, 2);

        assertThat(result.isWin()).isFalse();
        assertThat(result.isNothing()).isFalse();
        assertThat(result.getStrikes()).isEqualTo(0);
        assertThat(result.getBalls()).isEqualTo(2);
    }

    @Test
    @DisplayName("스트라이크 하나만 있는 경우")
    void testOnlyStrikes() {
        ComparisonResult result = new ComparisonResult(1, 0);

        assertThat(result.isWin()).isFalse();
        assertThat(result.isNothing()).isFalse();
        assertThat(result.getStrikes()).isEqualTo(1);
        assertThat(result.getBalls()).isEqualTo(0);
    }

    @Test
    @DisplayName("스트라이크와 볼 혼합")
    void testMixed() {
        ComparisonResult result = new ComparisonResult(1, 2);

        assertThat(result.isWin()).isFalse();
        assertThat(result.isNothing()).isFalse();
        assertThat(result.getStrikes()).isEqualTo(1);
        assertThat(result.getBalls()).isEqualTo(2);
    }

    @Test
    @DisplayName("낫싱 (0스트라이크 0볼)")
    void testNothing() {
        ComparisonResult result = new ComparisonResult(0, 0);

        assertThat(result.isNothing()).isTrue();
        assertThat(result.isWin()).isFalse();
        assertThat(result.getStrikes()).isEqualTo(0);
        assertThat(result.getBalls()).isEqualTo(0);
    }
}
