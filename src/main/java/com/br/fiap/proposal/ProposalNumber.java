package com.br.fiap.proposal;

import java.text.DecimalFormat;

public class ProposalNumber {

    public static String create(String maxNumber) {

        if (maxNumber == null) {
            return "00000001";
        }

        int proposalNumber = Integer.valueOf(maxNumber);
        proposalNumber ++;

        DecimalFormat decimalFormat = new DecimalFormat("00000000");

        return decimalFormat.format(proposalNumber);
    }
}
