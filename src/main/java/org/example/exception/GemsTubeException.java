package org.example.exception;

public class GemsTubeException extends Throwable{
    public GemsTubeException(String message) {
        super(message);
    }
    public GemsTubeException(Throwable throwable) {
        super(throwable);
    }
}
