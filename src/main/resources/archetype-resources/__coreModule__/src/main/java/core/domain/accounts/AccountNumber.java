package ${package}.core.domain.accounts;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor(staticName = "of")
public class AccountNumber {

    private final String value;

}
