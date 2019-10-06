package com.mopub.network;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.mobileads.MoPubError;
import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.VolleyError;
import java.lang.ref.WeakReference;

public class AdLoader {

    /* renamed from: a */
    private final com.mopub.network.MultiAdRequest.Listener f36275a;

    /* renamed from: b */
    private final WeakReference<Context> f36276b;

    /* renamed from: c */
    private final Listener f36277c;

    /* renamed from: d */
    private MultiAdRequest f36278d;

    /* renamed from: e */
    protected MultiAdResponse f36279e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Object f36280f = new Object();

    /* renamed from: g */
    protected AdResponse f36281g = null;

    /* renamed from: h */
    private C11673g f36282h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile boolean f36283i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public volatile boolean f36284j;

    /* renamed from: k */
    private boolean f36285k;

    /* renamed from: l */
    private Handler f36286l;

    public interface Listener extends ErrorListener {
        void onSuccess(AdResponse adResponse);
    }

    public AdLoader(String url, AdFormat adFormat, String adUnitId, Context context, Listener listener) {
        Preconditions.checkArgument(!TextUtils.isEmpty(url));
        Preconditions.checkNotNull(adFormat);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(listener);
        this.f36276b = new WeakReference<>(context);
        this.f36277c = listener;
        this.f36286l = new Handler();
        this.f36275a = new C11667a(this);
        this.f36283i = false;
        this.f36284j = false;
        MultiAdRequest multiAdRequest = new MultiAdRequest(url, adFormat, adUnitId, context, this.f36275a);
        this.f36278d = multiAdRequest;
    }

    public boolean hasMoreAds() {
        boolean z = false;
        if (this.f36284j || this.f36285k) {
            return false;
        }
        MultiAdResponse response = this.f36279e;
        if (response == null || response.hasNext() || !response.mo38311a()) {
            z = true;
        }
        return z;
    }

    public Request<?> loadNextAd(MoPubError errorCode) {
        if (this.f36283i) {
            return this.f36278d;
        }
        if (this.f36284j) {
            this.f36286l.post(new C11668b(this));
            return null;
        }
        synchronized (this.f36280f) {
            if (this.f36279e != null) {
                if (errorCode != null) {
                    m38489a(errorCode);
                }
                if (this.f36279e.hasNext()) {
                    this.f36286l.post(new C11670d(this, this.f36279e.next()));
                    MultiAdRequest multiAdRequest = this.f36278d;
                    return multiAdRequest;
                } else if (!this.f36279e.mo38311a()) {
                    MultiAdRequest multiAdRequest2 = new MultiAdRequest(this.f36279e.getFailURL(), this.f36278d.f36363s, this.f36278d.f36364t, (Context) this.f36276b.get(), this.f36275a);
                    this.f36278d = multiAdRequest2;
                    Request<?> a = m38487a(this.f36278d, (Context) this.f36276b.get());
                    return a;
                } else {
                    this.f36286l.post(new C11671e(this));
                    return null;
                }
            } else if (RequestRateTracker.getInstance().mo38324a(this.f36278d.f36364t)) {
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f36278d.f36364t);
                sb.append(" is blocked by request rate limiting.");
                MoPubLog.log(sdkLogEvent, sb.toString());
                this.f36286l.post(new C11669c(this));
                return null;
            } else {
                Request<?> a2 = m38487a(this.f36278d, (Context) this.f36276b.get());
                return a2;
            }
        }
    }

    public void creativeDownloadSuccess() {
        this.f36285k = true;
        if (this.f36282h == null) {
            MoPubLog.log(AdLogEvent.CUSTOM, "Response analytics should not be null here");
            return;
        }
        Context context = (Context) this.f36276b.get();
        if (context == null || this.f36281g == null) {
            MoPubLog.log(AdLogEvent.CUSTOM, "Cannot send 'x-after-load-url' analytics.");
            return;
        }
        this.f36282h.mo38334a(context, (MoPubError) null);
        this.f36282h.mo38333a(context);
    }

    /* renamed from: a */
    private void m38489a(MoPubError errorCode) {
        if (errorCode == null) {
            MoPubLog.log(AdLogEvent.CUSTOM, "Must provide error code to report creative download error");
            return;
        }
        Context context = (Context) this.f36276b.get();
        if (context == null || this.f36281g == null) {
            MoPubLog.log(AdLogEvent.CUSTOM, "Cannot send creative mFailed analytics.");
            return;
        }
        C11673g gVar = this.f36282h;
        if (gVar != null) {
            gVar.mo38334a(context, errorCode);
            this.f36282h.mo38336b(context, errorCode);
        }
    }

    /* renamed from: a */
    private Request<?> m38487a(MultiAdRequest request, Context context) {
        Preconditions.checkNotNull(request);
        if (context == null) {
            return null;
        }
        String bodyString = "<no body>";
        if (request.getBody() != null) {
            bodyString = new String(request.getBody());
        }
        MoPubLog.log(AdLogEvent.REQUESTED, request.getUrl(), bodyString);
        this.f36283i = true;
        RequestQueue requestQueue = Networking.getRequestQueue(context);
        this.f36278d = request;
        requestQueue.add(request);
        return request;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38493a(VolleyError volleyError) {
        Preconditions.checkNotNull(volleyError);
        this.f36281g = null;
        Listener listener = this.f36277c;
        if (listener == null) {
            return;
        }
        if (volleyError instanceof MoPubNetworkError) {
            listener.onErrorResponse(volleyError);
        } else {
            listener.onErrorResponse(new MoPubNetworkError(volleyError.getMessage(), volleyError.getCause(), Reason.UNSPECIFIED));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38492a(AdResponse adResponse) {
        Preconditions.checkNotNull(adResponse);
        Context context = (Context) this.f36276b.get();
        this.f36282h = new C11673g(adResponse);
        this.f36282h.mo38335b(context);
        Listener listener = this.f36277c;
        if (listener != null) {
            this.f36281g = adResponse;
            listener.onSuccess(adResponse);
        }
    }

    public boolean isRunning() {
        return this.f36283i;
    }

    public boolean isFailed() {
        return this.f36284j;
    }
}
