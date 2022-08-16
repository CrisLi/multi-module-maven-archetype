package ${package}.core.application.accounts;

import ${package}.core.application.accounts.GetAccount.GetAccountRequest;
import ${package}.core.application.accounts.GetAccount.GetAccountResponse;
import ${package}.core.domain.accounts.Account;
import ${package}.core.domain.accounts.AccountNumber;
import ${package}.core.domain.accounts.AccountRepository;
import ${package}.core.domain.exceptions.AccountNotException;

import org.springframework.stereotype.Service;

import an.awesome.pipelinr.Command;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class GetAccountUseCase implements Command.Handler<GetAccountRequest, GetAccountResponse> {

    private final AccountRepository accountRepository;

    @Override
    public GetAccountResponse handle(GetAccountRequest request) {

        // TODO do some validation on the request
        String accountNumber = request.getAccountNumber();

        return accountRepository.getAccount(AccountNumber.of(accountNumber))
            .map(this::toResponse)
            .orElseThrow(() -> new AccountNotException("Account %s not found".formatted(accountNumber)));
    }

    private GetAccountResponse toResponse(Account account) {
        return GetAccountResponse.builder()
            .accountNumber(account.getAccountNumber().getValue())
            .balance(account.getBalance())
            .build();
    }

}
