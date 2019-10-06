package com.tonyodev.fetch.exception;

public final class NotUsableException extends RuntimeException {

    /* renamed from: a */
    private final int f38989a;

    public NotUsableException(String message, int errorCode) {
        super(message);
        this.f38989a = errorCode;
    }
}
