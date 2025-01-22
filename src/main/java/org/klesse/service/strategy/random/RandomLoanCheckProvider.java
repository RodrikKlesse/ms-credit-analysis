package org.klesse.service.strategy.random;

import org.klesse.service.strategy.interfaces.LoanCheckProvider;

import java.util.Random;

public class RandomLoanCheckProvider implements LoanCheckProvider {

    @Override
    public boolean isInProgress() {
        return new Random().nextBoolean();
    }
}
