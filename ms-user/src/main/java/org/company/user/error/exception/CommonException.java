package org.company.user.error.exception;

public class CommonException extends RuntimeException {

    private final Integer code;
    private final String message;

    public CommonException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}
