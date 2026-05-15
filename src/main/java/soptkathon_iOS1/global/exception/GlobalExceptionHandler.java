package soptkathon_iOS1.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import soptkathon_iOS1.global.common.dto.BaseResponse;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<BaseResponse<?>> handleCustomException(CustomException e) {
        BaseErrorCode errorCode = e.getErrorCode();
        log.warn("CustomException: {}", e.getMessage());
        return ResponseEntity
                .status(errorCode.getStatus())
                .body(BaseResponse.fail(errorCode));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<?>> handleValidException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .findFirst()
                .orElse("입력값이 올바르지 않습니다.");
        log.warn("ValidationException: {}", message);
        return ResponseEntity
                .status(400)
                .body(BaseResponse.fail(ErrorCode.INVALID_INPUT));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<?>> handleException(Exception e) {
        log.error("UnhandledException: ", e);
        return ResponseEntity
                .status(500)
                .body(BaseResponse.fail(ErrorCode.INTERNAL_SERVER_ERROR));
    }
}
