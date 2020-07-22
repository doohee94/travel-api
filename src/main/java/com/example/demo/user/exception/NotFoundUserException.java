package com.example.demo.user.exception;

import com.example.demo.error.exception.BusinessException;
import com.example.demo.error.exception.ErrorCode;

public class NotFoundUserException extends BusinessException {
    public NotFoundUserException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
