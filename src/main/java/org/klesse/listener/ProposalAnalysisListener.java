package org.klesse.listener;

import lombok.AllArgsConstructor;
import org.klesse.domain.Proposal;
import org.klesse.service.CreditAnalysisService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class ProposalAnalysisListener {

    private final CreditAnalysisService creditAnalysisService;

    @RabbitListener(queues = "${rabbitmq.queue.pending.proposal}")
    public void analysisProposal(Proposal proposal) {
        creditAnalysisService.analyze(proposal);
    }
}
