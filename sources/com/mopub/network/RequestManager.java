package com.mopub.network;

import android.os.Handler;
import android.os.Looper;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.network.RequestManager.RequestFactory;
import com.mopub.volley.Request;

public abstract class RequestManager<T extends RequestFactory> {

    /* renamed from: a */
    protected Request<?> f36376a;

    /* renamed from: b */
    protected T f36377b;

    /* renamed from: c */
    protected BackoffPolicy f36378c;

    /* renamed from: d */
    protected Handler f36379d;

    public interface RequestFactory {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public abstract Request<?> mo38317b();

    public RequestManager(Looper looper) {
        this.f36379d = new Handler(looper);
    }

    public boolean isAtCapacity() {
        return this.f36376a != null;
    }

    public void makeRequest(T requestFactory, BackoffPolicy backoffPolicy) {
        Preconditions.checkNotNull(requestFactory);
        Preconditions.checkNotNull(backoffPolicy);
        cancelRequest();
        this.f36377b = requestFactory;
        this.f36378c = backoffPolicy;
        mo38318c();
    }

    public void cancelRequest() {
        MoPubRequestQueue requestQueue = Networking.getRequestQueue();
        if (requestQueue != null) {
            Request<?> request = this.f36376a;
            if (request != null) {
                requestQueue.cancel(request);
            }
        }
        mo38316a();
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: c */
    public void mo38318c() {
        this.f36376a = mo38317b();
        MoPubRequestQueue requestQueue = Networking.getRequestQueue();
        if (requestQueue == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "MoPubRequest queue is null. Clearing request.");
            mo38316a();
            return;
        }
        if (this.f36378c.getRetryCount() == 0) {
            requestQueue.add(this.f36376a);
        } else {
            requestQueue.addDelayedRequest(this.f36376a, this.f36378c.getBackoffMs());
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo38316a() {
        this.f36376a = null;
        this.f36377b = null;
        this.f36378c = null;
    }
}
