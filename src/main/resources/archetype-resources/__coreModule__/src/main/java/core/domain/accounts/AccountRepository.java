package ${package}.core.domain.accounts;

import java.util.Optional;

public interface AccountRepository {

    Optional<Account> getAccount(AccountNumber accountNumber);

    Account save(Account account);

}
