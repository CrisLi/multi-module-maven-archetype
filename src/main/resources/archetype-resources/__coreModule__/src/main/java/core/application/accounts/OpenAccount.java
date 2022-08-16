package ${package}.core.application.accounts;

import an.awesome.pipelinr.Command;
import lombok.Builder;
import lombok.Value;

public sealed interface OpenAccount {

    @Value
    @Builder
    public static class OpenAccountRequest implements Command<OpenAccountResponse>, OpenAccount {

    }

    @Value
    @Builder
    public static class OpenAccountResponse implements OpenAccount {

        private String accountNumber;

    }

}
