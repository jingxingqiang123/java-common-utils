package com.core.common.exception;

/**
 * LegoException
 *
 * @author: admin
 * @create: 2022/03/09 22:04
 */
public class BaseException extends RuntimeException {
    private long errorCode;
    private String message;
    private String[] errorDetails;

    public BaseException(long errorCode, String message, String[] errorDetails) {
        this.errorCode = errorCode;
        this.message = message;
        this.errorDetails = errorDetails;
    }

    public BaseException(String message, long errorCode, String message1, String[] errorDetails) {
        super(message);
        this.errorCode = errorCode;
        this.message = message1;
        this.errorDetails = errorDetails;
    }

    public BaseException(String message, Throwable cause, long errorCode, String message1, String[] errorDetails) {
        super(message, cause);
        this.errorCode = errorCode;
        this.message = message1;
        this.errorDetails = errorDetails;
    }

    public BaseException(Throwable cause, long errorCode, String message, String[] errorDetails) {
        super(cause);
        this.errorCode = errorCode;
        this.message = message;
        this.errorDetails = errorDetails;
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, long errorCode, String message1, String[] errorDetails) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
        this.message = message1;
        this.errorDetails = errorDetails;
    }

    public long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(long errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String[] errorDetails) {
        this.errorDetails = errorDetails;
    }
}
