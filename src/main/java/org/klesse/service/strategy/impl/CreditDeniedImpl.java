package org.klesse.service.strategy.impl;

import lombok.AllArgsConstructor;
import org.klesse.domain.Proposal;
import org.klesse.service.strategy.interfaces.Calculation;
import org.klesse.service.strategy.interfaces.CreditCheckProvider;

import java.util.Random;

@AllArgsConstructor
public class CreditDeniedImpl implements Calculation {

    private final CreditCheckProvider creditCheckProvider;

    @Override
    public int calculate(Proposal proposal) {
        if(creditCheckProvider.isCreditDenied()) {
            throw new RuntimeException("You do note have credit release");
        }
        return 100;
    }
}
