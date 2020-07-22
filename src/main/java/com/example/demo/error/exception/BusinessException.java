package com.example.demo.error.exception;

/**
 *
 * Error 발생 시 동일한 응답 반환을 위한 Error Response class
 * businessException 관련 에러
 *
 * @createBy DO
 * @Date 2020.06.13
 *
 * */
public class BusinessException extends RuntimeException{

    private ErrorCode errorCode;

    public BusinessException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
