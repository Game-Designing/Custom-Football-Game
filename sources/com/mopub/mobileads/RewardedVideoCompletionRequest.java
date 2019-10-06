package com.mopub.mobileads;

import android.content.Context;
import com.mopub.network.MoPubRequest;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.RetryPolicy;
import com.mopub.volley.toolbox.HttpHeaderParser;

public class RewardedVideoCompletionRequest extends MoPubRequest<Integer> {

    /* renamed from: s */
    final RewardedVideoCompletionRequestListener f34928s;

    public interface RewardedVideoCompletionRequestListener extends ErrorListener {
        void onResponse(Integer num);
    }

    public RewardedVideoCompletionRequest(Context context, String url, RetryPolicy retryPolicy, RewardedVideoCompletionRequestListener listener) {
        super(context, url, listener);
        setShouldCache(false);
        setRetryPolicy(retryPolicy);
        this.f34928s = listener;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Response<Integer> mo36680a(NetworkResponse networkResponse) {
        return Response.success(Integer.valueOf(networkResponse.statusCode), HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void deliverResponse(Integer response) {
        this.f34928s.onResponse(response);
    }
}
