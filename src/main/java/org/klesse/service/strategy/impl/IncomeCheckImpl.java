package org.klesse.service.strategy.impl;

import org.klesse.domain.Proposal;
import org.klesse.service.strategy.interfaces.Calculation;
import org.springframework.stereotype.Component;

@Component
public class IncomeCheckImpl implements Calculation {

    @Override
    public int calculate(Proposal proposal) {
        return isWageBiggerThanLoanRequest(proposal) ? 100 : 0;
    }

    private boolean isWageBiggerThanLoanRequest(Proposal proposal) {
        return proposal.getUsers().getWage() > proposal.getLoanAmount();
    }
}
