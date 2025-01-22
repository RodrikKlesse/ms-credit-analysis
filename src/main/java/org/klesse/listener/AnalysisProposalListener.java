package org.klesse.listener;

import org.klesse.domain.Proposal;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnalysisProposalListener {

    @RabbitListener(queues = "rabbitmq.queue.pending.proposal")
    public void analysisProposal(Proposal proposal) {

    }
}
