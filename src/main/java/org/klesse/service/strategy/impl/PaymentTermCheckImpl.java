package org.klesse.service.strategy.impl;

import org.klesse.domain.Proposal;
import org.klesse.service.strategy.interfaces.Calculation;
import org.springframework.stereotype.Component;

@Component
public class PaymentTermCheckImpl implements Calculation {

    public static final int DEADLINE_MONTHS = 120;

    @Override
    public int calculate(Proposal proposal) {
        return proposal.getPaymentTerm() < DEADLINE_MONTHS ? 80 : 0;
    }
}
