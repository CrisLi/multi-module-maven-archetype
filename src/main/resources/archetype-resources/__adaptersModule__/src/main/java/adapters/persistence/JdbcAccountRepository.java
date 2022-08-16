package ${package}.adapters.persistence;

import java.util.Optional;

import ${package}.core.domain.accounts.Account;
import ${package}.core.domain.accounts.AccountNumber;
import ${package}.core.domain.accounts.AccountRepository;
import ${package}.core.domain.exceptions.EntityOptimisticLockingException;

import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JdbcAccountRepository implements AccountRepository {

    private final AccountRepositoryAdapter jdbcAccountRepositoryAdapter;

    @Override
    public Optional<Account> getAccount(AccountNumber accountNumber) {
        return jdbcAccountRepositoryAdapter.findById(accountNumber.getValue())
            .map(this::toAccount);
    }

    @Override
    @Transactional
    public Account save(Account account) {

        try {

            AccountRecord saved = jdbcAccountRepositoryAdapter.save(toAccountRecord(account));

            return toAccount(saved);

        } catch (DbActionExecutionException e) {

            log.warn("Update account failed by optimistic lock".formatted(account.getAccountNumber().getValue()), e);

            throw new EntityOptimisticLockingException(e.getMessage());
        }

    }

    private Account toAccount(AccountRecord accountRecord) {

        AccountNumber accountNumber = AccountNumber.of(accountRecord.getId());

        return Account.of(accountNumber, accountRecord.getBalance(), accountRecord.getVersion());
    }

    private AccountRecord toAccountRecord(Account account) {

        AccountRecord accountRecord = new AccountRecord(account.getAccountNumber().getValue());

        accountRecord.setBalance(account.getBalance());
        accountRecord.setVersion(account.getVersion());

        return accountRecord;
    }

}
