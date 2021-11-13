package org.company.user.error.exception;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public class UserAlreadyExistException extends CommonException{
    private List<Object> messageArguments;

    public UserAlreadyExistException(String message, List<Object> messageArguments) {
        super(HttpStatus.BAD_REQUEST.value(), message);
        this.messageArguments = messageArguments;
    }

    public static UserAlreadyExistException of(String message, List<Object> messageArguments) {
        return new UserAlreadyExistException(message, messageArguments);
    }

    public static UserAlreadyExistException of(String message) {
        return new UserAlreadyExistException(message, Collections.emptyList());
    }

    public Object[] messageArguments() {
        return messageArguments != null ? messageArguments.toArray() : new Object[0];
    }

}
