package ${package}.core.application.accounts;

import java.math.BigDecimal;

import ${package}.core.application.common.VoidResponse;

import an.awesome.pipelinr.Command;
import lombok.Builder;
import lombok.Value;

public sealed interface Deposit {

    @Value
    @Builder
    public static class DepositRequest implements Command<VoidResponse>, Deposit {

        private String accountNumber;

        private BigDecimal amount;

    }

}
