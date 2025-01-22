package org.klesse.service.strategy.impl;

import lombok.AllArgsConstructor;
import org.klesse.domain.Proposal;
import org.klesse.service.strategy.interfaces.Calculation;
import org.klesse.service.strategy.interfaces.LoanCheckProvider;

@AllArgsConstructor
public class LoanInProgressImpl implements Calculation {

    private final LoanCheckProvider loanCheckProvider;

    @Override
    public int calculate(Proposal proposal) {
        return loanCheckProvider.isInProgress() ? 0 : 80;
    }
}
