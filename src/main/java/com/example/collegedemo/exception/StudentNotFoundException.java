package com.example.collegedemo.exception;

public class StudentNotFoundException extends Throwable {

    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public StudentNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return "NoDataFoundException [message=" + message + "]";
    }


}
