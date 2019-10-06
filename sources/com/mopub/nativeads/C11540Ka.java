package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.Constants;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.nativeads.PositioningSource.PositioningListener;
import com.mopub.network.Networking;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;

/* renamed from: com.mopub.nativeads.Ka */
/* compiled from: ServerPositioningSource */
class C11540Ka implements PositioningSource {

    /* renamed from: a */
    private int f35760a = 300000;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f35761b;

    /* renamed from: c */
    private final Handler f35762c;

    /* renamed from: d */
    private final Runnable f35763d;

    /* renamed from: e */
    private final Listener<MoPubClientPositioning> f35764e;

    /* renamed from: f */
    private final ErrorListener f35765f;

    /* renamed from: g */
    private PositioningListener f35766g;

    /* renamed from: h */
    private int f35767h;

    /* renamed from: i */
    private String f35768i;

    /* renamed from: j */
    private PositioningRequest f35769j;

    C11540Ka(Context context) {
        this.f35761b = context.getApplicationContext();
        this.f35762c = new Handler();
        this.f35763d = new C11531Ha(this);
        this.f35764e = new C11533Ia(this);
        this.f35765f = new C11538Ja(this);
    }

    public void loadPositions(String adUnitId, PositioningListener listener) {
        PositioningRequest positioningRequest = this.f35769j;
        if (positioningRequest != null) {
            positioningRequest.cancel();
            this.f35769j = null;
        }
        if (this.f35767h > 0) {
            this.f35762c.removeCallbacks(this.f35763d);
            this.f35767h = 0;
        }
        this.f35766g = listener;
        this.f35768i = new C11525Fa(this.f35761b).withAdUnitId(adUnitId).generateUrlString(Constants.HOST);
        m38195b();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m38195b() {
        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("Loading positioning from: ");
        sb.append(this.f35768i);
        MoPubLog.log(sdkLogEvent, sb.toString());
        this.f35769j = new PositioningRequest(this.f35761b, this.f35768i, this.f35764e, this.f35765f);
        Networking.getRequestQueue(this.f35761b).add(this.f35769j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38193a(MoPubClientPositioning positioning) {
        PositioningListener positioningListener = this.f35766g;
        if (positioningListener != null) {
            positioningListener.onLoad(positioning);
        }
        this.f35766g = null;
        this.f35767h = 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38190a() {
        int delay = (int) (1000.0d * Math.pow(2.0d, (double) (this.f35767h + 1)));
        if (delay >= this.f35760a) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Error downloading positioning information");
            PositioningListener positioningListener = this.f35766g;
            if (positioningListener != null) {
                positioningListener.onFailed();
            }
            this.f35766g = null;
            return;
        }
        this.f35767h++;
        this.f35762c.postDelayed(this.f35763d, (long) delay);
    }
}
