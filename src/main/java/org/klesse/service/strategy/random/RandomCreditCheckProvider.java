package org.klesse.service.strategy.random;

import org.klesse.service.strategy.interfaces.CreditCheckProvider;

import java.util.Random;

public class RandomCreditCheckProvider implements CreditCheckProvider {

    @Override
    public boolean isCreditDenied() {
        return new Random().nextBoolean();
    }
}
