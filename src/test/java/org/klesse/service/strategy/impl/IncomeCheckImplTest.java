package org.klesse.service.strategy.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.klesse.domain.Proposal;
import org.klesse.domain.Users;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("IncomeCheckImpl Unit Tests")
class IncomeCheckImplTest {

    private IncomeCheckImpl incomeCheckImpl;
    private Proposal proposal;
    private Users users;

    @BeforeEach
    void setUp() {
        incomeCheckImpl = new IncomeCheckImpl();
        users = new Users();
        proposal = new Proposal();
        proposal.setUsers(users);
    }

    @Test
    @DisplayName("Should return 100 points when wage is greater than loan amount")
    void shouldReturn100PointsWhenWageGreaterThanLoan() {
        // Given
        users.setWage(15000.0);
        proposal.setLoanAmount(10000.0);

        // When
        int result = incomeCheckImpl.calculate(proposal);

        // Then
        assertEquals(100, result);
    }

    @Test
    @DisplayName("Should return 0 points when wage is less than loan amount")
    void shouldReturn0PointsWhenWageLessThanLoan() {
        // Given
        users.setWage(5000.0);
        proposal.setLoanAmount(10000.0);

        // When
        int result = incomeCheckImpl.calculate(proposal);

        // Then
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should return 0 points when wage equals loan amount")
    void shouldReturn0PointsWhenWageEqualsLoan() {
        // Given
        users.setWage(10000.0);
        proposal.setLoanAmount(10000.0);

        // When
        int result = incomeCheckImpl.calculate(proposal);

        // Then
        assertEquals(0, result);
    }
}

