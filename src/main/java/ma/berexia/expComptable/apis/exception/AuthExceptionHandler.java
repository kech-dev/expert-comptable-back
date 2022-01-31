package ma.berexia.expComptable.apis.exception;

import ma.berexia.expComptable.service.exception.UserAlreadyExistException;
import ma.berexia.expComptable.service.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AuthExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyExistException.class)
    protected ResponseEntity<ApiError> handleUserAlreadyExist(UserAlreadyExistException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(exception.getClass().getSimpleName(),exception.getMessage()));
    }
    @ExceptionHandler(UserNotFoundException.class)
    protected  ResponseEntity<ApiError> handleUserNotFound(UserNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(exception.getClass().getSimpleName(),exception.getMessage()));
    }
}
