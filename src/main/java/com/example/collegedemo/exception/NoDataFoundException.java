package com.example.collegedemo.exception;

public class NoDataFoundException extends Throwable {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NoDataFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return "NoDataFoundException [message=" + message + "]";
    }


}
