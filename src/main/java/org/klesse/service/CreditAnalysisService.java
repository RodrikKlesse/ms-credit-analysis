package org.klesse.service;

import lombok.AllArgsConstructor;
import org.klesse.domain.Proposal;
import org.klesse.exceptions.StrategyException;
import org.klesse.service.strategy.interfaces.Calculation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditAnalysisService {

    private List<Calculation> calculationList;

    public CreditAnalysisService(List<Calculation> calculationList) {
        this.calculationList = calculationList;
    }

    public void analyze(Proposal proposal) {
        try {
            boolean approved = calculationList.stream()
                    .mapToInt(impl -> impl.calculate(proposal)).sum() > 350;

            proposal.setStatus(approved);
        } catch (StrategyException ex) {
            proposal.setStatus(false);
        }



    }
}
