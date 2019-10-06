package com.mopub.mobileads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.mobileads.RewardedVideoCompletionRequest.RewardedVideoCompletionRequestListener;
import com.mopub.network.Networking;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.VolleyError;

public class RewardedVideoCompletionRequestHandler implements RewardedVideoCompletionRequestListener {

    /* renamed from: a */
    static final int[] f34929a = {5000, 10000, 20000, 40000, 60000};

    /* renamed from: b */
    private final String f34930b;

    /* renamed from: c */
    private final Handler f34931c;

    /* renamed from: d */
    private final RequestQueue f34932d;

    /* renamed from: e */
    private final Context f34933e;

    /* renamed from: f */
    private int f34934f;

    /* renamed from: g */
    private volatile boolean f34935g;

    RewardedVideoCompletionRequestHandler(Context context, String url, String customerId, String rewardName, String rewardAmount, String className, String customData) {
        this(context, url, customerId, rewardName, rewardAmount, className, customData, new Handler());
    }

    @VisibleForTesting
    RewardedVideoCompletionRequestHandler(Context context, String url, String customerId, String rewardName, String rewardAmount, String className, String customData, Handler handler) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(rewardName);
        Preconditions.checkNotNull(rewardAmount);
        Preconditions.checkNotNull(handler);
        this.f34930b = m37539a(url, customerId, rewardName, rewardAmount, className, customData);
        this.f34934f = 0;
        this.f34931c = handler;
        this.f34932d = Networking.getRequestQueue(context);
        this.f34933e = context.getApplicationContext();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37179a() {
        if (this.f34935g) {
            this.f34932d.cancelAll((Object) this.f34930b);
            return;
        }
        RewardedVideoCompletionRequest rewardedVideoCompletionRequest = new RewardedVideoCompletionRequest(this.f34933e, this.f34930b, new DefaultRetryPolicy(m37538a(this.f34934f) - 1000, 0, 0.0f), this);
        rewardedVideoCompletionRequest.setTag(this.f34930b);
        this.f34932d.add(rewardedVideoCompletionRequest);
        if (this.f34934f >= 17) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Exceeded number of retries for rewarded video completion request.");
            return;
        }
        this.f34931c.postDelayed(new C11454ua(this), (long) m37538a(this.f34934f));
        this.f34934f++;
    }

    public void onResponse(Integer response) {
        if (response == null) {
            return;
        }
        if (response.intValue() < 500 || response.intValue() >= 600) {
            this.f34935g = true;
        }
    }

    public void onErrorResponse(VolleyError volleyError) {
        if (volleyError != null) {
            NetworkResponse networkResponse = volleyError.networkResponse;
            if (networkResponse != null) {
                int i = networkResponse.statusCode;
                if (i < 500 || i >= 600) {
                    this.f34935g = true;
                }
            }
        }
    }

    public static void makeRewardedVideoCompletionRequest(Context context, String url, String customerId, String rewardName, String rewardAmount, String rewardedAd, String customData) {
        if (context != null && !TextUtils.isEmpty(url) && rewardName != null && rewardAmount != null) {
            RewardedVideoCompletionRequestHandler rewardedVideoCompletionRequestHandler = new RewardedVideoCompletionRequestHandler(context, url, customerId, rewardName, rewardAmount, rewardedAd, customData);
            rewardedVideoCompletionRequestHandler.mo37179a();
        }
    }

    /* renamed from: a */
    static int m37538a(int retryCount) {
        if (retryCount >= 0) {
            int[] iArr = f34929a;
            if (retryCount < iArr.length) {
                return iArr[retryCount];
            }
        }
        int[] iArr2 = f34929a;
        return iArr2[iArr2.length - 1];
    }

    /* renamed from: a */
    private static String m37539a(String url, String customerId, String rewardName, String rewardAmount, String className, String customData) {
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(rewardName);
        Preconditions.checkNotNull(rewardAmount);
        StringBuilder stringBuilder = new StringBuilder(url);
        stringBuilder.append("&customer_id=");
        String str = "";
        stringBuilder.append(customerId == null ? str : Uri.encode(customerId));
        stringBuilder.append("&rcn=");
        stringBuilder.append(Uri.encode(rewardName));
        stringBuilder.append("&rca=");
        stringBuilder.append(Uri.encode(rewardAmount));
        stringBuilder.append("&nv=");
        stringBuilder.append(Uri.encode("5.7.1"));
        stringBuilder.append("&v=");
        stringBuilder.append(1);
        stringBuilder.append("&cec=");
        if (className != null) {
            str = Uri.encode(className);
        }
        stringBuilder.append(str);
        if (!TextUtils.isEmpty(customData)) {
            stringBuilder.append("&rcd=");
            stringBuilder.append(Uri.encode(customData));
        }
        return stringBuilder.toString();
    }
}
