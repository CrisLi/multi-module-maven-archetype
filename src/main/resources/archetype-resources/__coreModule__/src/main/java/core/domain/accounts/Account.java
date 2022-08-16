package ${package}.core.domain.accounts;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class Account {

    private final AccountNumber accountNumber;

    private BigDecimal balance = BigDecimal.ZERO;

    private long version = 0L;

    public static Account open(AccountNumber accountNumber) {
        return new Account(accountNumber, BigDecimal.ZERO, 0);
    }

    public void deposit(BigDecimal amount) {
        this.balance = balance.add(amount);
    }

}
