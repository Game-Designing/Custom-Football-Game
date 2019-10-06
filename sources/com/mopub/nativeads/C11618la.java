package com.mopub.nativeads;

import android.app.Activity;
import android.os.Handler;
import android.os.SystemClock;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.mopub.nativeads.la */
/* compiled from: NativeAdSource */
class C11618la {
    @VisibleForTesting

    /* renamed from: a */
    static final int[] f36174a = {1000, 3000, 5000, 25000, 60000, 300000};
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final List<C11516Bb<NativeAd>> f36175b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Handler f36176c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Runnable f36177d;

    /* renamed from: e */
    private final MoPubNativeNetworkListener f36178e;
    @VisibleForTesting

    /* renamed from: f */
    boolean f36179f;
    @VisibleForTesting

    /* renamed from: g */
    boolean f36180g;
    @VisibleForTesting

    /* renamed from: h */
    int f36181h;
    @VisibleForTesting

    /* renamed from: i */
    int f36182i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C11619a f36183j;

    /* renamed from: k */
    private RequestParameters f36184k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public MoPubNative f36185l;

    /* renamed from: m */
    private final AdRendererRegistry f36186m;

    /* renamed from: com.mopub.nativeads.la$a */
    /* compiled from: NativeAdSource */
    interface C11619a {
        void onAdsAvailable();
    }

    C11618la() {
        this(new ArrayList(1), new Handler(), new AdRendererRegistry());
    }

    @VisibleForTesting
    C11618la(List<C11516Bb<NativeAd>> nativeAdCache, Handler replenishCacheHandler, AdRendererRegistry adRendererRegistry) {
        this.f36175b = nativeAdCache;
        this.f36176c = replenishCacheHandler;
        this.f36177d = new C11612ja(this);
        this.f36186m = adRendererRegistry;
        this.f36178e = new C11615ka(this);
        this.f36181h = 0;
        mo38176f();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo38173c() {
        return this.f36186m.getAdRendererCount();
    }

    public int getViewTypeForAd(NativeAd nativeAd) {
        return this.f36186m.getViewTypeForAd(nativeAd);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38169a(MoPubAdRenderer moPubNativeAdRenderer) {
        this.f36186m.registerAdRenderer(moPubNativeAdRenderer);
        MoPubNative moPubNative = this.f36185l;
        if (moPubNative != null) {
            moPubNative.registerAdRenderer(moPubNativeAdRenderer);
        }
    }

    public MoPubAdRenderer getAdRendererForViewType(int viewType) {
        return this.f36186m.getRendererForViewType(viewType);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38171a(C11619a adSourceListener) {
        this.f36183j = adSourceListener;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38168a(Activity activity, String adUnitId, RequestParameters requestParameters) {
        mo38170a(requestParameters, new MoPubNative(activity, adUnitId, this.f36178e));
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo38170a(RequestParameters requestParameters, MoPubNative moPubNative) {
        mo38167a();
        for (MoPubAdRenderer renderer : this.f36186m.getRendererIterable()) {
            moPubNative.registerAdRenderer(renderer);
        }
        this.f36184k = requestParameters;
        this.f36185l = moPubNative;
        mo38175e();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38167a() {
        MoPubNative moPubNative = this.f36185l;
        if (moPubNative != null) {
            moPubNative.destroy();
            this.f36185l = null;
        }
        this.f36184k = null;
        Iterator it = this.f36175b.iterator();
        while (it.hasNext()) {
            ((NativeAd) ((C11516Bb) it.next()).f35619a).destroy();
        }
        this.f36175b.clear();
        this.f36176c.removeMessages(0);
        this.f36179f = false;
        this.f36181h = 0;
        mo38176f();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public NativeAd mo38172b() {
        long now = SystemClock.uptimeMillis();
        if (!this.f36179f && !this.f36180g) {
            this.f36176c.post(this.f36177d);
        }
        while (!this.f36175b.isEmpty()) {
            TimestampWrapper<NativeAd> responseWrapper = (C11516Bb) this.f36175b.remove(0);
            if (now - responseWrapper.f35620b < 14400000) {
                return (NativeAd) responseWrapper.f35619a;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: g */
    public void mo38177g() {
        int i = this.f36182i;
        if (i < f36174a.length - 1) {
            this.f36182i = i + 1;
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: f */
    public void mo38176f() {
        this.f36182i = 0;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: d */
    public int mo38174d() {
        int i = this.f36182i;
        int[] iArr = f36174a;
        if (i >= iArr.length) {
            this.f36182i = iArr.length - 1;
        }
        return f36174a[this.f36182i];
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: e */
    public void mo38175e() {
        if (!this.f36179f && this.f36185l != null && this.f36175b.size() < 1) {
            this.f36179f = true;
            this.f36185l.makeRequest(this.f36184k, Integer.valueOf(this.f36181h));
        }
    }
}
