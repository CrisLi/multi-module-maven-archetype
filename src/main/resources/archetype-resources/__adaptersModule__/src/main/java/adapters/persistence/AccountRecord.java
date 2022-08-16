package ${package}.adapters.persistence;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Table("accounts")
@RequiredArgsConstructor
public class AccountRecord {

    @Id
    private final String id;

    private BigDecimal balance;

    @Version
    private long version;

}
