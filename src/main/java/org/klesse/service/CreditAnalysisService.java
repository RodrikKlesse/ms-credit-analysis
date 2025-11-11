package org.klesse.service;

import lombok.AllArgsConstructor;
import org.klesse.domain.Proposal;
import org.klesse.exceptions.StrategyException;
import org.klesse.service.strategy.interfaces.Calculation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.klesse.contants.MessageConstant.CREDIT_APPROVED;

@Service
public class CreditAnalysisService {

    private final List<Calculation> calculationList;
    private final RabbitNotificationService rabbitNotificationService;
    private final String exchangeCompletedProposal;

    public CreditAnalysisService(List<Calculation> calculationList,
                                 RabbitNotificationService rabbitNotificationService,
                                 @Value("${rabbitmq.completedproposal.exchange}") String exchangeCompletedProposal) {
        this.calculationList = calculationList;
        this.rabbitNotificationService = rabbitNotificationService;
        this.exchangeCompletedProposal = exchangeCompletedProposal;
    }

    public void analyze(Proposal proposal) {
        try {
            int points = calculationList.stream()
                    .mapToInt(impl -> impl.calculate(proposal)).sum();

            proposal.setStatus(points > 350);
            proposal.setDescription(CREDIT_APPROVED);
        } catch (StrategyException ex) {
            proposal.setStatus(false);
            proposal.setDescription(ex.getMessage());
        }

        rabbitNotificationService.notify(exchangeCompletedProposal, proposal);

    }
}
