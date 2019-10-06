package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.VisibleForTesting;
import com.mopub.network.AdResponse;
import com.mopub.network.ImpressionData;
import com.mopub.network.SingleImpression;
import com.mopub.network.TrackingRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NativeAd {

    /* renamed from: a */
    private final Context f35916a;

    /* renamed from: b */
    private final BaseNativeAd f35917b;

    /* renamed from: c */
    private final MoPubAdRenderer f35918c;

    /* renamed from: d */
    private final Set<String> f35919d;

    /* renamed from: e */
    private final Set<String> f35920e;

    /* renamed from: f */
    private final String f35921f;

    /* renamed from: g */
    private ImpressionData f35922g;

    /* renamed from: h */
    private MoPubNativeEventListener f35923h;

    /* renamed from: i */
    private boolean f35924i;

    /* renamed from: j */
    private boolean f35925j;

    /* renamed from: k */
    private boolean f35926k;

    public interface MoPubNativeEventListener {
        void onClick(View view);

        void onImpression(View view);
    }

    public NativeAd(Context context, List<String> moPubImpressionTrackerUrls, String moPubClickTrackerUrl, String adUnitId, BaseNativeAd baseNativeAd, MoPubAdRenderer moPubAdRenderer) {
        this.f35916a = context.getApplicationContext();
        this.f35921f = adUnitId;
        this.f35922g = null;
        this.f35919d = new HashSet();
        this.f35919d.addAll(moPubImpressionTrackerUrls);
        this.f35919d.addAll(baseNativeAd.mo37747b());
        this.f35920e = new HashSet();
        this.f35920e.add(moPubClickTrackerUrl);
        this.f35920e.addAll(baseNativeAd.mo37743a());
        this.f35917b = baseNativeAd;
        this.f35917b.setNativeEventListener(new C11609ia(this));
        this.f35918c = moPubAdRenderer;
    }

    NativeAd(Context context, AdResponse adResponse, String adUnitId, BaseNativeAd baseNativeAd, MoPubAdRenderer moPubAdRenderer) {
        this(context, adResponse.getImpressionTrackingUrls(), adResponse.getClickTrackingUrl(), adUnitId, baseNativeAd, moPubAdRenderer);
        this.f35922g = adResponse.getImpressionData();
    }

    public String toString() {
        String str = "\n";
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append("impressionTrackers");
        String str2 = ":";
        stringBuilder.append(str2);
        stringBuilder.append(this.f35919d);
        stringBuilder.append(str);
        stringBuilder.append("clickTrackers");
        stringBuilder.append(str2);
        stringBuilder.append(this.f35920e);
        stringBuilder.append(str);
        stringBuilder.append("recordedImpression");
        stringBuilder.append(str2);
        stringBuilder.append(this.f35924i);
        stringBuilder.append(str);
        stringBuilder.append("isClicked");
        stringBuilder.append(str2);
        stringBuilder.append(this.f35925j);
        stringBuilder.append(str);
        stringBuilder.append("isDestroyed");
        stringBuilder.append(str2);
        stringBuilder.append(this.f35926k);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public void setMoPubNativeEventListener(MoPubNativeEventListener moPubNativeEventListener) {
        this.f35923h = moPubNativeEventListener;
    }

    public String getAdUnitId() {
        return this.f35921f;
    }

    public boolean isDestroyed() {
        return this.f35926k;
    }

    public BaseNativeAd getBaseNativeAd() {
        return this.f35917b;
    }

    public View createAdView(Context context, ViewGroup parent) {
        return this.f35918c.createAdView(context, parent);
    }

    public void renderAdView(View view) {
        this.f35918c.renderAdView(view, this.f35917b);
    }

    public MoPubAdRenderer getMoPubAdRenderer() {
        return this.f35918c;
    }

    public void prepare(View view) {
        if (!this.f35926k) {
            this.f35917b.prepare(view);
        }
    }

    public void clear(View view) {
        if (!this.f35926k) {
            this.f35917b.clear(view);
        }
    }

    public void destroy() {
        if (!this.f35926k) {
            this.f35917b.destroy();
            this.f35926k = true;
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: b */
    public void mo37990b(View view) {
        if (!this.f35924i && !this.f35926k) {
            this.f35924i = true;
            TrackingRequest.makeTrackingHttpRequest((Iterable<String>) this.f35919d, this.f35916a);
            MoPubNativeEventListener moPubNativeEventListener = this.f35923h;
            if (moPubNativeEventListener != null) {
                moPubNativeEventListener.onImpression(view);
            }
            new SingleImpression(this.f35921f, this.f35922g).sendImpression();
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo37989a(View view) {
        if (!this.f35925j && !this.f35926k) {
            TrackingRequest.makeTrackingHttpRequest((Iterable<String>) this.f35920e, this.f35916a);
            MoPubNativeEventListener moPubNativeEventListener = this.f35923h;
            if (moPubNativeEventListener != null) {
                moPubNativeEventListener.onClick(view);
            }
            this.f35925j = true;
        }
    }
}
