package com.smaato.soma.exception;

public class BannerHttpRequestFailed extends Exception {
    public BannerHttpRequestFailed(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
