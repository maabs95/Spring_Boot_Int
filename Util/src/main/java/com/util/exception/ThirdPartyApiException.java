package com.util.exception;

public class ThirdPartyApiException extends RuntimeException {
    public ThirdPartyApiException(String message) {
        super(message);
    }

    public ThirdPartyApiException(String message, Throwable cause) {
        super(message, cause); // Retains the root cause (e.g., SSLException or RestClientResponseException)
    }
}
