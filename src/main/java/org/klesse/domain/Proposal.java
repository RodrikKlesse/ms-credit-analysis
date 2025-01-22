package org.klesse.domain;

import lombok.Data;

@Data
public class Proposal {

    private Long id;
    private Double loanAmount;
    private int paymentTerm;
    private Boolean status;
    private boolean integrate;
    private String description;
    private Users users;
}
