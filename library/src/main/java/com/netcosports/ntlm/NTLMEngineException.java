package com.netcosports.ntlm;

public class NTLMEngineException extends Exception {

    public NTLMEngineException() {
        super();
    }

    /**
     * Creates a new NTLMEngineException with the specified message.
     *
     * @param message the exception detail message
     */
    public NTLMEngineException(final String message) {
        super(message);
    }

    /**
     * Creates a new NTLMEngineException with the specified detail message and cause.
     *
     * @param message the exception detail message
     * @param cause   the {@code Throwable} that caused this exception, or {@code null}
     *                if the cause is unavailable, unknown, or not a {@code Throwable}
     */
    public NTLMEngineException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
