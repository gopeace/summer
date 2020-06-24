package com.season.common;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/24 11:34
 */
public enum ScoreEnum {
    ONE_HALF(0.5),
    ONE(1),
    ONE_AND_A_HALF(1.5),
    TWO(2),
    TWO_AND_A_HALF(2.5),
    THREE(3);

    private final double score;

    ScoreEnum(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }
}
