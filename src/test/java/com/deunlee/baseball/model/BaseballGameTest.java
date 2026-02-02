package com.deunlee.baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {

    @DisplayName("3스트라이크: 모든 숫자와 위치가 일치")
    @Test
    void testThreeStrikes() {
        IRandomNumberGenerator generator = () -> List.of(1, 2, 3);
        BaseballGame game = new BaseballGame(generator);
        Numbers playerNumbers = new Numbers(List.of(1, 2, 3));
        ComparisonResult result = game.checkResult(playerNumbers);

        assertThat(result.getStrikes()).isEqualTo(3);
        assertThat(result.getBalls()).isEqualTo(0);
        assertThat(result.isWin()).isTrue();
    }

    @DisplayName("3볼: 모든 숫자는 맞지만 위치가 모두 다름")
    @Test
    void testThreeBalls() {
        IRandomNumberGenerator generator = () -> List.of(1, 2, 3);
        BaseballGame game = new BaseballGame(generator);
        Numbers playerNumbers = new Numbers(List.of(3, 1, 2));
        ComparisonResult result = game.checkResult(playerNumbers);

        assertThat(result.getStrikes()).isEqualTo(0);
        assertThat(result.getBalls()).isEqualTo(3);
        assertThat(result.isWin()).isFalse();
    }

    @DisplayName("1스트라이크 1볼")
    @Test
    void testOneStrikeOneBall() {
        IRandomNumberGenerator generator = () -> List.of(1, 2, 3);
        BaseballGame game = new BaseballGame(generator);
        Numbers playerNumbers = new Numbers(List.of(1, 3, 4));
        ComparisonResult result = game.checkResult(playerNumbers);

        assertThat(result.getStrikes()).isEqualTo(1);
        assertThat(result.getBalls()).isEqualTo(1);
        assertThat(result.isWin()).isFalse();
    }

    @DisplayName("2스트라이크 0볼")
    @Test
    void testTwoStrikes() {
        IRandomNumberGenerator generator = () -> List.of(1, 2, 3);
        BaseballGame game = new BaseballGame(generator);
        Numbers playerNumbers = new Numbers(List.of(1, 2, 4));
        ComparisonResult result = game.checkResult(playerNumbers);

        assertThat(result.getStrikes()).isEqualTo(2);
        assertThat(result.getBalls()).isEqualTo(0);
        assertThat(result.isWin()).isFalse();
    }

    @DisplayName("낫싱: 일치하는 숫자가 없음")
    @Test
    void testNothing() {
        IRandomNumberGenerator generator = () -> List.of(1, 2, 3);
        BaseballGame game = new BaseballGame(generator);
        Numbers playerNumbers = new Numbers(List.of(4, 5, 6));
        ComparisonResult result = game.checkResult(playerNumbers);

        assertThat(result.getStrikes()).isEqualTo(0);
        assertThat(result.getBalls()).isEqualTo(0);
        assertThat(result.isNothing()).isTrue();
    }

    @DisplayName("1스트라이크 2볼")
    @Test
    void testOneStrikeTwoBalls() {
        IRandomNumberGenerator generator = () -> List.of(1, 2, 3);
        BaseballGame game = new BaseballGame(generator);
        Numbers playerNumbers = new Numbers(List.of(1, 3, 2));
        ComparisonResult result = game.checkResult(playerNumbers);

        assertThat(result.getStrikes()).isEqualTo(1);
        assertThat(result.getBalls()).isEqualTo(2);
    }

    @DisplayName("0스트라이크 2볼")
    @Test
    void testTwoBalls() {
        IRandomNumberGenerator generator = () -> List.of(1, 2, 3);
        BaseballGame game = new BaseballGame(generator);
        Numbers playerNumbers = new Numbers(List.of(2, 1, 4));
        ComparisonResult result = game.checkResult(playerNumbers);

        assertThat(result.getStrikes()).isEqualTo(0);
        assertThat(result.getBalls()).isEqualTo(2);
    }
}
