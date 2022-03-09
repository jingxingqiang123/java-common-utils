package com.core.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalExceptionHandler
 *
 * @author: admin
 * @create: 2022/03/09 21:42
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * errorResponseMsg
     *
     * @param baseException legoException
     * @return errorResponseMsg
     */
    @ResponseBody
    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ErrorResponseMsg> errorHandler(BaseException baseException) {
        String message = baseException.getMessage();
        ErrorResponseMsg errorResponseMsg = new ErrorResponseMsg();
        errorResponseMsg.setErrorCode(baseException.getErrorCode());
        errorResponseMsg.setMessage(message);
        return new ResponseEntity(errorResponseMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 全局异常捕捉处理
     *
     * @param exception exception
     * @return ErrorResponseMsg
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponseMsg> errorHandler(Exception exception) {
        String message = exception.getMessage();
        ErrorResponseMsg errorRes = new ErrorResponseMsg();
        errorRes.setErrorCode(10000L);
        errorRes.setMessage(message);
        errorRes.setErrorDetails(new String[]{message});
        return new ResponseEntity<>(errorRes, HttpStatus.BAD_REQUEST);
    }
}
