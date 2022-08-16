package ${package}.adapters.rest;

import java.util.Map;

import ${package}.core.domain.exceptions.BusinessException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerAdvice {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, Object>> handleBusinessException(BusinessException exception) {
        return ResponseEntity.badRequest()
            .body(Map.of(
                "message", exception.getMessage(),
                "errorCode", exception.getClass().getSimpleName() //
            ));
    }

}
