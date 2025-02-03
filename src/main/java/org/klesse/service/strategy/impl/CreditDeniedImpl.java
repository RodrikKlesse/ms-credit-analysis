package org.klesse.service.strategy.impl;

import lombok.AllArgsConstructor;
import org.klesse.contants.MessageConstant;
import org.klesse.domain.Proposal;
import org.klesse.exceptions.StrategyException;
import org.klesse.service.strategy.interfaces.Calculation;
import org.klesse.service.strategy.interfaces.CreditCheckProvider;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@AllArgsConstructor
public class CreditDeniedImpl implements Calculation {

    private final CreditCheckProvider creditCheckProvider;

    @Override
    public int calculate(Proposal proposal) {
        if(creditCheckProvider.isCreditDenied()) {
            throw new StrategyException(String.format(MessageConstant.CREDIT_DENIED, proposal.getUsers().getName()));
        }
        return 100;
    }
}
