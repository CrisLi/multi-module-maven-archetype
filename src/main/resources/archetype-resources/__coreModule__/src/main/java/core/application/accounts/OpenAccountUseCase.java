package ${package}.core.application.accounts;

import ${package}.core.application.accounts.OpenAccount.OpenAccountRequest;
import ${package}.core.application.accounts.OpenAccount.OpenAccountResponse;
import ${package}.core.domain.accounts.Account;
import ${package}.core.domain.accounts.AccountNumber;
import ${package}.core.domain.accounts.AccountRepository;
import ${package}.core.domain.common.IdGenertator;

import org.springframework.stereotype.Service;

import an.awesome.pipelinr.Command;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class OpenAccountUseCase implements Command.Handler<OpenAccountRequest, OpenAccountResponse> {

    private final AccountRepository accountRepository;

    private final IdGenertator<String> idGenertator;

    @Override
    public OpenAccountResponse handle(OpenAccountRequest request) {

        // TODO do some validation on the request

        String accountNumber = idGenertator.next();

        Account account = Account.open(AccountNumber.of(accountNumber));

        accountRepository.save(account);

        return OpenAccountResponse.builder()
            .accountNumber(account.getAccountNumber().getValue())
            .build();
    }

}
