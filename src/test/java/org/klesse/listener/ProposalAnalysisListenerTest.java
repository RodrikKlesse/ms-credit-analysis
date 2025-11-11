package org.klesse.listener;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.klesse.domain.Proposal;
import org.klesse.domain.Users;
import org.klesse.service.CreditAnalysisService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("ProposalAnalysisListener Unit Tests")
class ProposalAnalysisListenerTest {

    @Mock
    private CreditAnalysisService creditAnalysisService;

    @InjectMocks
    private ProposalAnalysisListener proposalAnalysisListener;

    private Proposal proposal;
    private Users users;

    @BeforeEach
    void setUp() {
        users = new Users();
        users.setId(1L);
        users.setName("John");
        users.setWage(5000.0);

        proposal = new Proposal();
        proposal.setId(1L);
        proposal.setLoanAmount(10000.0);
        proposal.setPaymentTerm(24);
        proposal.setUsers(users);
    }

    @Test
    @DisplayName("Should call credit analysis service when proposal is received")
    void shouldCallCreditAnalysisService() {
        // When
        proposalAnalysisListener.analysisProposal(proposal);

        // Then
        verify(creditAnalysisService, times(1)).analyze(proposal);
    }

    @Test
    @DisplayName("Should handle proposal analysis successfully")
    void shouldHandleProposalAnalysisSuccessfully() {
        // Given
        doNothing().when(creditAnalysisService).analyze(any(Proposal.class));

        // When
        proposalAnalysisListener.analysisProposal(proposal);

        // Then
        verify(creditAnalysisService, times(1)).analyze(proposal);
    }
}



