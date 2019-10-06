package com.mopub.volley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.mopub.volley.Cache;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Request.Priority;
import com.mopub.volley.Response;

public class ClearCacheRequest extends Request<Object> {

    /* renamed from: q */
    private final Cache f36485q;

    /* renamed from: r */
    private final Runnable f36486r;

    public ClearCacheRequest(Cache cache, Runnable callback) {
        super(0, null, null);
        this.f36485q = cache;
        this.f36486r = callback;
    }

    public boolean isCanceled() {
        this.f36485q.clear();
        if (this.f36486r != null) {
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(this.f36486r);
        }
        return true;
    }

    public Priority getPriority() {
        return Priority.IMMEDIATE;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Response<Object> mo36680a(NetworkResponse response) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void deliverResponse(Object response) {
    }
}
