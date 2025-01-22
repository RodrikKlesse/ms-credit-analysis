package org.klesse.service.strategy.impl;

import lombok.AllArgsConstructor;
import org.klesse.domain.Proposal;
import org.klesse.service.strategy.interfaces.Calculation;
import org.klesse.service.strategy.interfaces.ScoreProvider;

@AllArgsConstructor
public class ScoreCalculationImpl implements Calculation {
    public static final int MINIMUM_SCORE = 200;
    public static final int LOW_SCORE = 400;
    public static final int MEDIUM_SCORE = 600;

    private final ScoreProvider scoreProvider;

    @Override
    public int calculate(Proposal proposal) {

        int score = scoreProvider.getScore();

        if (score <= MINIMUM_SCORE) {
            throw new RuntimeException("Does not have the minimum score.");
        }

        return getScoreBasedOnThreshold(score);
    }

    private int getScoreBasedOnThreshold(int score) {
        if (score <= LOW_SCORE) {
            return 150;
        } else if (score <= MEDIUM_SCORE) {
            return 180;
        } else {
            return 220;
        }
    }
}
