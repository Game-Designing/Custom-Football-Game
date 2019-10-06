package com.mopub.volley.toolbox;

import com.mopub.volley.Request;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import com.mopub.volley.VolleyLog;
import java.io.UnsupportedEncodingException;

public abstract class JsonRequest<T> extends Request<T> {

    /* renamed from: q */
    private static final String f36531q = String.format("application/json; charset=%s", new Object[]{"utf-8"});

    /* renamed from: r */
    private final Object f36532r;

    /* renamed from: s */
    private Listener<T> f36533s;

    /* renamed from: t */
    private final String f36534t;

    @Deprecated
    public JsonRequest(String url, String requestBody, Listener<T> listener, ErrorListener errorListener) {
        this(-1, url, requestBody, listener, errorListener);
    }

    public JsonRequest(int method, String url, String requestBody, Listener<T> listener, ErrorListener errorListener) {
        super(method, url, errorListener);
        this.f36532r = new Object();
        this.f36533s = listener;
        this.f36534t = requestBody;
    }

    public void cancel() {
        super.cancel();
        synchronized (this.f36532r) {
            this.f36533s = null;
        }
    }

    /* access modifiers changed from: protected */
    public void deliverResponse(T response) {
        Listener<T> listener;
        synchronized (this.f36532r) {
            listener = this.f36533s;
        }
        if (listener != null) {
            listener.onResponse(response);
        }
    }

    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    @Deprecated
    public byte[] getPostBody() {
        return getBody();
    }

    public String getBodyContentType() {
        return f36531q;
    }

    public byte[] getBody() {
        String str = "utf-8";
        byte[] bArr = null;
        try {
            if (this.f36534t != null) {
                bArr = this.f36534t.getBytes(str);
            }
            return bArr;
        } catch (UnsupportedEncodingException e) {
            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", this.f36534t, str);
            return null;
        }
    }
}
