package edu.tekwill.millionaire.model;

public class InvalidInputDataException extends RuntimeException {
    public InvalidInputDataException(String message) {
        super(message);
    }
}
