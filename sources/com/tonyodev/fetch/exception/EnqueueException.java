package com.tonyodev.fetch.exception;

public final class EnqueueException extends RuntimeException {

    /* renamed from: a */
    private int f38988a;

    public EnqueueException(String message, int errorCode) {
        super(message);
        this.f38988a = errorCode;
    }

    /* renamed from: a */
    public int mo40286a() {
        return this.f38988a;
    }
}
