package ${package}.core.domain.exceptions;

public class AccountNotException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public AccountNotException(String message) {
        super(message);
    }

}
