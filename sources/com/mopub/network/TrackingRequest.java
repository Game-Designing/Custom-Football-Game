package com.mopub.network;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.VastErrorCode;
import com.mopub.mobileads.VastMacroHelper;
import com.mopub.mobileads.VastTracker;
import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrackingRequest extends MoPubRequest<Void> {

    /* renamed from: s */
    private final Listener f36386s;

    public interface Listener extends ErrorListener {
        void onResponse(String str);
    }

    private TrackingRequest(Context context, String url, Listener listener) {
        super(context, url, listener);
        this.f36386s = listener;
        setShouldCache(false);
        setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 0, 1.0f));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Response<Void> mo36680a(NetworkResponse networkResponse) {
        if (networkResponse.statusCode == 200) {
            return Response.success(null, HttpHeaderParser.parseCacheHeaders(networkResponse));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to log tracking request. Response code: ");
        sb.append(networkResponse.statusCode);
        sb.append(" for url: ");
        sb.append(getUrl());
        return Response.error(new MoPubNetworkError(sb.toString(), Reason.TRACKING_FAILURE));
    }

    public void deliverResponse(Void aVoid) {
        Listener listener = this.f36386s;
        if (listener != null) {
            listener.onResponse(getUrl());
        }
    }

    public static void makeVastTrackingHttpRequest(List<VastTracker> vastTrackers, VastErrorCode vastErrorCode, Integer contentPlayHead, String assetUri, Context context) {
        Preconditions.checkNotNull(vastTrackers);
        List<String> trackers = new ArrayList<>(vastTrackers.size());
        for (VastTracker vastTracker : vastTrackers) {
            if (vastTracker != null && (!vastTracker.isTracked() || vastTracker.isRepeatable())) {
                trackers.add(vastTracker.getContent());
                vastTracker.setTracked();
            }
        }
        makeTrackingHttpRequest((Iterable<String>) new VastMacroHelper(trackers).withErrorCode(vastErrorCode).withContentPlayHead(contentPlayHead).withAssetUri(assetUri).getUris(), context);
    }

    public static void makeTrackingHttpRequest(Iterable<String> urls, Context context, Listener listener) {
        if (urls != null && context != null) {
            RequestQueue requestQueue = Networking.getRequestQueue(context);
            for (String url : urls) {
                if (!TextUtils.isEmpty(url)) {
                    requestQueue.add(new TrackingRequest(context, url, new C11680m(listener, url)));
                }
            }
        }
    }

    public static void makeTrackingHttpRequest(String url, Context context) {
        makeTrackingHttpRequest(url, context, (Listener) null);
    }

    public static void makeTrackingHttpRequest(String url, Context context, Listener listener) {
        if (!TextUtils.isEmpty(url)) {
            makeTrackingHttpRequest((Iterable<String>) Arrays.asList(new String[]{url}), context, listener);
        }
    }

    public static void makeTrackingHttpRequest(Iterable<String> urls, Context context) {
        makeTrackingHttpRequest(urls, context, (Listener) null);
    }
}
