package ${package}.core.application.accounts;

import java.math.BigDecimal;

import an.awesome.pipelinr.Command;
import lombok.Builder;
import lombok.Value;

public sealed interface GetAccount {

    @Value
    @Builder
    public static class GetAccountRequest implements Command<GetAccountResponse>, GetAccount {

        private String accountNumber;

    }

    @Value
    @Builder
    public static class GetAccountResponse implements GetAccount {

        private String accountNumber;

        private BigDecimal balance;

    }

}
