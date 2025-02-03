package org.klesse.service.strategy.random;

import org.klesse.service.strategy.interfaces.CreditCheckProvider;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomCreditCheckProvider implements CreditCheckProvider {

    @Override
    public boolean isCreditDenied() {
        return new Random().nextBoolean();
    }
}
