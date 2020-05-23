package com.fev.app.WebApplication.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * We have implemented our own exception, so the
     * application can be easier to understand.
     *
     * Instead a 404 - Not Found, we will have:
     * 404 and a message.
     * @param message what we want to detail.
     */
    public UserNotFoundException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }
}
