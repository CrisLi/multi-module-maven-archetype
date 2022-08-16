package ${package}.core.application.accounts;

import ${package}.core.application.accounts.Deposit.DepositRequest;
import ${package}.core.application.common.VoidResponse;
import ${package}.core.domain.accounts.Account;
import ${package}.core.domain.accounts.AccountNumber;
import ${package}.core.domain.accounts.AccountRepository;
import ${package}.core.domain.exceptions.AccountNotException;

import org.springframework.stereotype.Service;

import an.awesome.pipelinr.Command;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class DepositUseCase implements Command.Handler<DepositRequest, VoidResponse> {

    private final AccountRepository accountRepository;

    @Override
    public VoidResponse handle(DepositRequest request) {

        // TODO do some validation on the request

        String accountNumber = request.getAccountNumber();

        Account account = accountRepository.getAccount(AccountNumber.of(accountNumber))
            .orElseThrow(() -> new AccountNotException("Account %s not found".formatted(accountNumber)));

        account.deposit(request.getAmount());

        accountRepository.save(account);

        return VoidResponse.EMPTY;
    }

}
