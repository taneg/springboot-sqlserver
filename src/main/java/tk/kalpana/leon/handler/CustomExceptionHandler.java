package tk.kalpana.leon.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;
import tk.kalpana.leon.common.Result;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handlerNotFoundException(NoHandlerFoundException e) {
        log.error("请求的资源不可用", e);
        return Result.build(Result.CODE_FAIL, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public Result handlerBadRequestException(HttpClientErrorException.BadRequest e) {
        log.error("请求的资源不可用", e);
        return Result.build(Result.CODE_FAIL, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return Result.build(Result.CODE_FAIL, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Result httpRequestMethodNotSupportedException(ConstraintViolationException e) {
        return Result.build(Result.CODE_FAIL, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result exception(Exception e) {
        return Result.build(Result.CODE_FAIL, e.getMessage());
    }
}
