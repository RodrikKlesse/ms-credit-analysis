package org.klesse.service.strategy.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.klesse.domain.Proposal;
import org.klesse.domain.Users;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PaymentTermCheckImpl Unit Tests")
class PaymentTermCheckImplTest {

    private PaymentTermCheckImpl paymentTermCheckImpl;
    private Proposal proposal;
    private Users users;

    @BeforeEach
    void setUp() {
        paymentTermCheckImpl = new PaymentTermCheckImpl();
        users = new Users();
        proposal = new Proposal();
        proposal.setUsers(users);
    }

    @Test
    @DisplayName("Should return 80 points when payment term is less than 120 months")
    void shouldReturn80PointsWhenPaymentTermLessThan120() {
        // Given
        proposal.setPaymentTerm(60);

        // When
        int result = paymentTermCheckImpl.calculate(proposal);

        // Then
        assertEquals(80, result);
    }

    @Test
    @DisplayName("Should return 0 points when payment term equals 120 months")
    void shouldReturn0PointsWhenPaymentTermEquals120() {
        // Given
        proposal.setPaymentTerm(120);

        // When
        int result = paymentTermCheckImpl.calculate(proposal);

        // Then
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should return 0 points when payment term is greater than 120 months")
    void shouldReturn0PointsWhenPaymentTermGreaterThan120() {
        // Given
        proposal.setPaymentTerm(150);

        // When
        int result = paymentTermCheckImpl.calculate(proposal);

        // Then
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should return 80 points when payment term is 1 month")
    void shouldReturn80PointsWhenPaymentTermIs1() {
        // Given
        proposal.setPaymentTerm(1);

        // When
        int result = paymentTermCheckImpl.calculate(proposal);

        // Then
        assertEquals(80, result);
    }
}



