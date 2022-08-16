package ${package}.adapters.persistence;

import ${package}.core.domain.exceptions.EntityOptimisticLockingException;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DbActionExecutionExceptionHandler {

    public void handle(DbActionExecutionException exception, String message) {

        Throwable error = exception.getCause();

        if (error instanceof OptimisticLockingFailureException) {

            log.warn(message);

            throw new EntityOptimisticLockingException(exception.getMessage());
        }

    }

}
