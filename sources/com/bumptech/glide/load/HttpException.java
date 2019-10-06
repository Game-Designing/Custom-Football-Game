package com.bumptech.glide.load;

import java.io.IOException;

public final class HttpException extends IOException {

    /* renamed from: a */
    private final int f10689a;

    public HttpException(int statusCode) {
        StringBuilder sb = new StringBuilder();
        sb.append("Http request failed with status code: ");
        sb.append(statusCode);
        this(sb.toString(), statusCode);
    }

    public HttpException(String message) {
        this(message, -1);
    }

    public HttpException(String message, int statusCode) {
        this(message, statusCode, null);
    }

    public HttpException(String message, int statusCode, Throwable cause) {
        super(message, cause);
        this.f10689a = statusCode;
    }
}
