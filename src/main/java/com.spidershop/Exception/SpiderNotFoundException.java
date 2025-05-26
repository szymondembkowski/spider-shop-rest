package com.spidershop.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SpiderNotFoundException extends RuntimeException {

    public SpiderNotFoundException(String message) {
        super(message);
    }
}
