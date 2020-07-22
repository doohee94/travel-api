package com.example.demo.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *
 * Error Code 정리
 * CODE NAME (errorStatus, 에러코드 관리, 관련 메세지);
 *
 * @createBy DO
 * @Date 2020.06.13
 *
 * */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // Common
    INVALID_INPUT_VALUE(400, "C001", " Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "C002", " Invalid Input Value"),
    ENTITY_NOT_FOUND(400, "C003", " Entity Not Found"),
    INTERNAL_SERVER_ERROR(500, "C004", "Server Error"),
    INVALID_TYPE_VALUE(400, "C005", " Invalid Type Value"),
    HANDLE_ACCESS_DENIED(403, "C006", "Access is Denied"),

    //user
    USER_NOT_FOUND(400,"U001","사용자를 찾을 수 없습니다."),

    //city
    NOT_FOUND_CITY(400,"CT001" ,"해당 도시를 찾을 수 없습니다." );



    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }
}
