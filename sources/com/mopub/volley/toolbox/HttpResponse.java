package com.mopub.volley.toolbox;

import com.mopub.volley.Header;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class HttpResponse {

    /* renamed from: a */
    private final int f36501a;

    /* renamed from: b */
    private final List<Header> f36502b;

    /* renamed from: c */
    private final int f36503c;

    /* renamed from: d */
    private final InputStream f36504d;

    public HttpResponse(int statusCode, List<Header> headers) {
        this(statusCode, headers, -1, null);
    }

    public HttpResponse(int statusCode, List<Header> headers, int contentLength, InputStream content) {
        this.f36501a = statusCode;
        this.f36502b = headers;
        this.f36503c = contentLength;
        this.f36504d = content;
    }

    public final int getStatusCode() {
        return this.f36501a;
    }

    public final List<Header> getHeaders() {
        return Collections.unmodifiableList(this.f36502b);
    }

    public final int getContentLength() {
        return this.f36503c;
    }

    public final InputStream getContent() {
        return this.f36504d;
    }
}
