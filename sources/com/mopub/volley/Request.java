package com.mopub.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mopub.volley.Cache.Entry;
import com.mopub.volley.Response.ErrorListener;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

public abstract class Request<T> implements Comparable<Request<T>> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C11684a f36432a;

    /* renamed from: b */
    private final int f36433b;

    /* renamed from: c */
    private final String f36434c;

    /* renamed from: d */
    private final int f36435d;

    /* renamed from: e */
    private final Object f36436e;

    /* renamed from: f */
    private ErrorListener f36437f;

    /* renamed from: g */
    private Integer f36438g;

    /* renamed from: h */
    private RequestQueue f36439h;

    /* renamed from: i */
    private boolean f36440i;

    /* renamed from: j */
    private boolean f36441j;

    /* renamed from: k */
    private boolean f36442k;

    /* renamed from: l */
    private boolean f36443l;

    /* renamed from: m */
    private RetryPolicy f36444m;

    /* renamed from: n */
    private Entry f36445n;

    /* renamed from: o */
    private Object f36446o;

    /* renamed from: p */
    private C11683a f36447p;

    public interface Method {
        public static final int DELETE = 3;
        public static final int DEPRECATED_GET_OR_POST = -1;
        public static final int GET = 0;
        public static final int HEAD = 4;
        public static final int OPTIONS = 5;
        public static final int PATCH = 7;
        public static final int POST = 1;
        public static final int PUT = 2;
        public static final int TRACE = 6;
    }

    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    /* renamed from: com.mopub.volley.Request$a */
    interface C11683a {
        void onNoUsableResponseReceived(Request<?> request);

        void onResponseReceived(Request<?> request, Response<?> response);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Response<T> mo36680a(NetworkResponse networkResponse);

    /* access modifiers changed from: protected */
    public abstract void deliverResponse(T t);

    @Deprecated
    public Request(String url, ErrorListener listener) {
        this(-1, url, listener);
    }

    public Request(int method, String url, ErrorListener listener) {
        this.f36432a = C11684a.ENABLED ? new C11684a() : null;
        this.f36436e = new Object();
        this.f36440i = true;
        this.f36441j = false;
        this.f36442k = false;
        this.f36443l = false;
        this.f36445n = null;
        this.f36433b = method;
        this.f36434c = url;
        this.f36437f = listener;
        setRetryPolicy(new DefaultRetryPolicy());
        this.f36435d = mo38065b(url);
    }

    public int getMethod() {
        return this.f36433b;
    }

    public Request<?> setTag(Object tag) {
        this.f36446o = tag;
        return this;
    }

    public Object getTag() {
        return this.f36446o;
    }

    public ErrorListener getErrorListener() {
        ErrorListener errorListener;
        synchronized (this.f36436e) {
            errorListener = this.f36437f;
        }
        return errorListener;
    }

    public int getTrafficStatsTag() {
        return this.f36435d;
    }

    /* renamed from: b */
    private static int mo38065b(String url) {
        if (!TextUtils.isEmpty(url)) {
            Uri uri = Uri.parse(url);
            if (uri != null) {
                String host = uri.getHost();
                if (host != null) {
                    return host.hashCode();
                }
            }
        }
        return 0;
    }

    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        this.f36444m = retryPolicy;
        return this;
    }

    public void addMarker(String tag) {
        if (C11684a.ENABLED) {
            this.f36432a.add(tag, Thread.currentThread().getId());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38379a(String tag) {
        RequestQueue requestQueue = this.f36439h;
        if (requestQueue != null) {
            requestQueue.mo38414a(this);
        }
        if (C11684a.ENABLED) {
            long threadId = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new C11688c(this, tag, threadId));
            } else {
                this.f36432a.add(tag, threadId);
                this.f36432a.finish(toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38376a(int event) {
        RequestQueue requestQueue = this.f36439h;
        if (requestQueue != null) {
            requestQueue.mo38415a(this, event);
        }
    }

    public Request<?> setRequestQueue(RequestQueue requestQueue) {
        this.f36439h = requestQueue;
        return this;
    }

    public final Request<?> setSequence(int sequence) {
        this.f36438g = Integer.valueOf(sequence);
        return this;
    }

    public final int getSequence() {
        Integer num = this.f36438g;
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public String getUrl() {
        return this.f36434c;
    }

    public String getCacheKey() {
        String url = getUrl();
        int method = getMethod();
        if (method == 0 || method == -1) {
            return url;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(method));
        sb.append('-');
        sb.append(url);
        return sb.toString();
    }

    public Request<?> setCacheEntry(Entry entry) {
        this.f36445n = entry;
        return this;
    }

    public Entry getCacheEntry() {
        return this.f36445n;
    }

    public void cancel() {
        synchronized (this.f36436e) {
            this.f36441j = true;
            this.f36437f = null;
        }
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.f36436e) {
            z = this.f36441j;
        }
        return z;
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        return Collections.emptyMap();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    /* renamed from: g */
    public Map<String, String> mo38385g() throws AuthFailureError {
        return mo38066e();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    /* renamed from: i */
    public String mo38400i() {
        return mo38384f();
    }

    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    @Deprecated
    public byte[] getPostBody() throws AuthFailureError {
        Map<String, String> postParams = mo38385g();
        if (postParams == null || postParams.size() <= 0) {
            return null;
        }
        return m38586a(postParams, mo38400i());
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Map<String, String> mo38066e() throws AuthFailureError {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public String mo38384f() {
        return "UTF-8";
    }

    public String getBodyContentType() {
        StringBuilder sb = new StringBuilder();
        sb.append("application/x-www-form-urlencoded; charset=");
        sb.append(mo38384f());
        return sb.toString();
    }

    public byte[] getBody() throws AuthFailureError {
        Map<String, String> params = mo38066e();
        if (params == null || params.size() <= 0) {
            return null;
        }
        return m38586a(params, mo38384f());
    }

    /* renamed from: a */
    private byte[] m38586a(Map<String, String> params, String paramsEncoding) {
        StringBuilder encodedParams = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", new Object[]{entry.getKey(), entry.getValue()}));
                }
                encodedParams.append(URLEncoder.encode((String) entry.getKey(), paramsEncoding));
                encodedParams.append('=');
                encodedParams.append(URLEncoder.encode((String) entry.getValue(), paramsEncoding));
                encodedParams.append('&');
            }
            return encodedParams.toString().getBytes(paramsEncoding);
        } catch (UnsupportedEncodingException uee) {
            StringBuilder sb = new StringBuilder();
            sb.append("Encoding not supported: ");
            sb.append(paramsEncoding);
            throw new RuntimeException(sb.toString(), uee);
        }
    }

    public final Request<?> setShouldCache(boolean shouldCache) {
        this.f36440i = shouldCache;
        return this;
    }

    public final boolean shouldCache() {
        return this.f36440i;
    }

    public final Request<?> setShouldRetryServerErrors(boolean shouldRetryServerErrors) {
        this.f36443l = shouldRetryServerErrors;
        return this;
    }

    public final boolean shouldRetryServerErrors() {
        return this.f36443l;
    }

    public Priority getPriority() {
        return Priority.NORMAL;
    }

    public final int getTimeoutMs() {
        return getRetryPolicy().getCurrentTimeout();
    }

    public RetryPolicy getRetryPolicy() {
        return this.f36444m;
    }

    public void markDelivered() {
        synchronized (this.f36436e) {
            this.f36442k = true;
        }
    }

    public boolean hasHadResponseDelivered() {
        boolean z;
        synchronized (this.f36436e) {
            z = this.f36442k;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public VolleyError mo38375a(VolleyError volleyError) {
        return volleyError;
    }

    public void deliverError(VolleyError error) {
        ErrorListener listener;
        synchronized (this.f36436e) {
            listener = this.f36437f;
        }
        if (listener != null) {
            listener.onErrorResponse(error);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38377a(C11683a requestCompleteListener) {
        synchronized (this.f36436e) {
            this.f36447p = requestCompleteListener;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38378a(Response<?> response) {
        C11683a listener;
        synchronized (this.f36436e) {
            listener = this.f36447p;
        }
        if (listener != null) {
            listener.onResponseReceived(this, response);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo38402j() {
        C11683a listener;
        synchronized (this.f36436e) {
            listener = this.f36447p;
        }
        if (listener != null) {
            listener.onNoUsableResponseReceived(this);
        }
    }

    public int compareTo(Request<T> other) {
        int i;
        int i2;
        Priority left = getPriority();
        Priority right = other.getPriority();
        if (left == right) {
            i2 = this.f36438g.intValue();
            i = other.f36438g.intValue();
        } else {
            i2 = right.ordinal();
            i = left.ordinal();
        }
        return i2 - i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        sb.append(Integer.toHexString(getTrafficStatsTag()));
        String trafficStatsTag = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(isCanceled() ? "[X] " : "[ ] ");
        sb2.append(getUrl());
        String str = " ";
        sb2.append(str);
        sb2.append(trafficStatsTag);
        sb2.append(str);
        sb2.append(getPriority());
        sb2.append(str);
        sb2.append(this.f36438g);
        return sb2.toString();
    }
}
