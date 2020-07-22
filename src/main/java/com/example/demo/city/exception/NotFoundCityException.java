package com.example.demo.city.exception;

import com.example.demo.error.exception.BusinessException;
import com.example.demo.error.exception.ErrorCode;

public class NotFoundCityException extends BusinessException {
    public NotFoundCityException() {
        super(ErrorCode.NOT_FOUND_CITY);
    }
}
