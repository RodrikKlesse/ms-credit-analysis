package org.klesse.service.strategy.impl;

import lombok.AllArgsConstructor;
import org.klesse.contants.MessageConstant;
import org.klesse.domain.Proposal;
import org.klesse.exceptions.StrategyException;
import org.klesse.service.strategy.interfaces.Calculation;
import org.klesse.service.strategy.interfaces.ScoreProvider;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
@AllArgsConstructor
public class ScoreCalculationImpl implements Calculation {
    public static final int MINIMUM_SCORE = 200;
    public static final int LOW_SCORE = 400;
    public static final int MEDIUM_SCORE = 600;

    private final ScoreProvider scoreProvider;

    @Override
    public int calculate(Proposal proposal) {

        int score = scoreProvider.getScore();

        if (score < MINIMUM_SCORE) {
            throw new StrategyException(String.format(MessageConstant.LOW_SCORE, proposal.getUsers().getName()));
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
