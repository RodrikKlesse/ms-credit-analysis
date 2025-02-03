package org.klesse.service.strategy.random;

import org.klesse.service.strategy.interfaces.LoanCheckProvider;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomLoanCheckProvider implements LoanCheckProvider {

    @Override
    public boolean isInProgress() {
        return new Random().nextBoolean();
    }
}
