package com.mopub.network;

import android.content.Context;
import com.mopub.common.AdFormat;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.common.privacy.PersonalInfoManager;
import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.toolbox.HttpHeaderParser;

public class MultiAdRequest extends MoPubRequest<MultiAdResponse> {
    public final Listener mListener;

    /* renamed from: s */
    final AdFormat f36363s;

    /* renamed from: t */
    final String f36364t;

    /* renamed from: u */
    private final Context f36365u;

    /* renamed from: v */
    private int f36366v = 0;

    public interface Listener extends ErrorListener {
        void onSuccessResponse(MultiAdResponse multiAdResponse);
    }

    MultiAdRequest(String url, AdFormat adFormat, String adUnitId, Context context, Listener listener) {
        super(context, m38543c(url), listener);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(adFormat);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(listener);
        this.f36364t = adUnitId;
        this.mListener = listener;
        this.f36363s = adFormat;
        this.f36365u = context.getApplicationContext();
        setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 1, 1.0f));
        setShouldCache(false);
        PersonalInfoManager personalInfoManager = MoPub.getPersonalInformationManager();
        if (personalInfoManager != null) {
            personalInfoManager.requestSync(false);
        }
    }

    /* renamed from: c */
    private static String m38543c(String url) {
        if (MoPub.getPersonalInformationManager() != null && MoPub.isSdkInitialized()) {
            return url;
        }
        MoPubLog.log(AdLogEvent.CUSTOM, "Make sure to call MoPub#initializeSdk before loading an ad.");
        return "";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Response<MultiAdResponse> mo36680a(NetworkResponse networkResponse) {
        try {
            return Response.success(new MultiAdResponse(this.f36365u, networkResponse, this.f36363s, this.f36364t), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Exception ex) {
            if (ex instanceof MoPubNetworkError) {
                return Response.error((MoPubNetworkError) ex);
            }
            return Response.error(new MoPubNetworkError((Throwable) ex, Reason.UNSPECIFIED));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void deliverResponse(MultiAdResponse multiAdResponse) {
        if (!isCanceled()) {
            this.mListener.onSuccessResponse(multiAdResponse);
        }
    }

    public void cancel() {
        super.cancel();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MultiAdRequest)) {
            return false;
        }
        MultiAdRequest other = (MultiAdRequest) obj;
        int res = 0;
        String str = this.f36364t;
        if (str != null) {
            String str2 = other.f36364t;
            res = str2 == null ? 1 : str.compareTo(str2);
        } else if (other.f36364t != null) {
            res = -1;
        }
        if (!(res == 0 && this.f36363s == other.f36363s && getUrl().compareTo(other.getUrl()) == 0)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        if (this.f36366v == 0) {
            String str = this.f36364t;
            this.f36366v = ((((str == null ? 29 : str.hashCode()) * 31) + this.f36363s.hashCode()) * 31) + getOriginalUrl().hashCode();
        }
        return this.f36366v;
    }
}
