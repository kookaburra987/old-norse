package me.kookaburra987.oldnorse.utils.exceptions;

public class FailedToReadResource extends RuntimeException {
    public FailedToReadResource(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedToReadResource(String message) {
        super(message);
    }
}
