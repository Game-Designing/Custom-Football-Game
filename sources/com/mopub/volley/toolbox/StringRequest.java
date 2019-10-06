package com.mopub.volley.toolbox;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import java.io.UnsupportedEncodingException;

public class StringRequest extends Request<String> {

    /* renamed from: q */
    private final Object f36547q;

    /* renamed from: r */
    private Listener<String> f36548r;

    public StringRequest(int method, String url, Listener<String> listener, ErrorListener errorListener) {
        super(method, url, errorListener);
        this.f36547q = new Object();
        this.f36548r = listener;
    }

    public StringRequest(String url, Listener<String> listener, ErrorListener errorListener) {
        this(0, url, listener, errorListener);
    }

    public void cancel() {
        super.cancel();
        synchronized (this.f36547q) {
            this.f36548r = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void deliverResponse(String response) {
        Listener<String> listener;
        synchronized (this.f36547q) {
            listener = this.f36548r;
        }
        if (listener != null) {
            listener.onResponse(response);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Response<String> mo36680a(NetworkResponse response) {
        String parsed;
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }
        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
    }
}
