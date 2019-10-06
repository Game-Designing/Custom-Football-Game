package com.tonyodev.fetch.exception;

public class DownloadInterruptedException extends RuntimeException {

    /* renamed from: a */
    private int f38987a;

    public DownloadInterruptedException(String message, int errorCode) {
        super(message);
        this.f38987a = errorCode;
    }
}
