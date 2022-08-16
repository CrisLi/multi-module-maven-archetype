package ${package}.core.domain.exceptions;

public class EntityOptimisticLockingException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EntityOptimisticLockingException(String message) {
        super(message);
    }

}
