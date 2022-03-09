package com.core.common.exception;

import lombok.Data;

/**
 * ErrorResponseMsg
 *
 * @author: admin
 * @create: 2022/03/09 21:41
 */
@Data
public class ErrorResponseMsg {
    private long errorCode;
    private String message;
    private String[] errorDetails;

    public ErrorResponseMsg() {
    }

    public ErrorResponseMsg(long errorCode, String message, String[] errorDetails) {
        this.errorCode = errorCode;
        this.message = message;
        this.errorDetails = errorDetails;
    }


    public long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(long errorCode) {
        this.errorCode = errorCode;
    }

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
