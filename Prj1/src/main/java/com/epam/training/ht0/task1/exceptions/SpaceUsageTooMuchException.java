package com.epam.training.ht0.task1.exceptions;

public class SpaceUsageTooMuchException extends Exception {
    public SpaceUsageTooMuchException() {
    }

    public SpaceUsageTooMuchException(String message) {
        super(message);
    }
}
