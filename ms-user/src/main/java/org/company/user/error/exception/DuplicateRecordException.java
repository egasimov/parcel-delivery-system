package org.company.user.error.exception;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public class DuplicateRecordException extends CommonException{
    private List<Object> messageArguments;

    public DuplicateRecordException(String message, List<Object> messageArguments) {
        super(HttpStatus.BAD_REQUEST.value(), message);
        this.messageArguments = messageArguments;
    }

    public static DuplicateRecordException of(String message, List<Object> messageArguments) {
        return new DuplicateRecordException(message, messageArguments);
    }

    public static DuplicateRecordException of(String message) {
        return new DuplicateRecordException(message, Collections.emptyList());
    }

    public Object[] messageArguments() {
        return messageArguments != null ? messageArguments.toArray() : new Object[0];
    }

}
