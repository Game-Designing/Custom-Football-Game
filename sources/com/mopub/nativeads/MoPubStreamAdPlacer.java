package com.mopub.nativeads;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubServerPositioning;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

public class MoPubStreamAdPlacer {
    public static final int CONTENT_VIEW_TYPE = 0;

    /* renamed from: a */
    private static final MoPubNativeAdLoadedListener f35892a = new C11597ea();

    /* renamed from: b */
    private final Activity f35893b;

    /* renamed from: c */
    private final Handler f35894c;

    /* renamed from: d */
    private final Runnable f35895d;

    /* renamed from: e */
    private final PositioningSource f35896e;

    /* renamed from: f */
    private final C11618la f35897f;

    /* renamed from: g */
    private final HashMap<NativeAd, WeakReference<View>> f35898g;

    /* renamed from: h */
    private final WeakHashMap<View, NativeAd> f35899h;

    /* renamed from: i */
    private boolean f35900i;

    /* renamed from: j */
    private C11523Ea f35901j;

    /* renamed from: k */
    private boolean f35902k;

    /* renamed from: l */
    private boolean f35903l;

    /* renamed from: m */
    private C11523Ea f35904m;

    /* renamed from: n */
    private String f35905n;

    /* renamed from: o */
    private MoPubNativeAdLoadedListener f35906o;

    /* renamed from: p */
    private int f35907p;

    /* renamed from: q */
    private int f35908q;

    /* renamed from: r */
    private int f35909r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f35910s;

    public MoPubStreamAdPlacer(Activity activity) {
        this(activity, MoPubNativeAdPositioning.serverPositioning());
    }

    public MoPubStreamAdPlacer(Activity activity, MoPubServerPositioning adPositioning) {
        this(activity, new C11618la(), new C11540Ka(activity));
    }

    public MoPubStreamAdPlacer(Activity activity, MoPubClientPositioning adPositioning) {
        this(activity, new C11618la(), new C11596e(adPositioning));
    }

    @VisibleForTesting
    MoPubStreamAdPlacer(Activity activity, C11618la adSource, PositioningSource positioningSource) {
        this.f35906o = f35892a;
        Preconditions.checkNotNull(activity, "activity is not allowed to be null");
        Preconditions.checkNotNull(adSource, "adSource is not allowed to be null");
        Preconditions.checkNotNull(positioningSource, "positioningSource is not allowed to be null");
        this.f35893b = activity;
        this.f35896e = positioningSource;
        this.f35897f = adSource;
        this.f35904m = C11523Ea.m38115b();
        this.f35899h = new WeakHashMap<>();
        this.f35898g = new HashMap<>();
        this.f35894c = new Handler();
        this.f35895d = new C11600fa(this);
        this.f35907p = 0;
        this.f35908q = 0;
    }

    public void registerAdRenderer(MoPubAdRenderer adRenderer) {
        if (NoThrow.checkNotNull(adRenderer, "Cannot register a null adRenderer")) {
            this.f35897f.mo38169a(adRenderer);
        }
    }

    public MoPubAdRenderer getAdRendererForViewType(int viewType) {
        return this.f35897f.getAdRendererForViewType(viewType);
    }

    public void setAdLoadedListener(MoPubNativeAdLoadedListener listener) {
        this.f35906o = listener == null ? f35892a : listener;
    }

    public void loadAds(String adUnitId) {
        loadAds(adUnitId, null);
    }

    public void loadAds(String adUnitId, RequestParameters requestParameters) {
        if (NoThrow.checkNotNull(adUnitId, "Cannot load ads with a null ad unit ID")) {
            if (this.f35897f.mo38173c() == 0) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "You must register at least 1 ad renderer by calling registerAdRenderer before loading ads");
                return;
            }
            this.f35905n = adUnitId;
            this.f35903l = false;
            this.f35900i = false;
            this.f35902k = false;
            this.f35896e.loadPositions(adUnitId, new C11603ga(this));
            this.f35897f.mo38171a((C11619a) new C11606ha(this));
            this.f35897f.mo38168a(this.f35893b, adUnitId, requestParameters);
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo37962a(MoPubClientPositioning positioning) {
        C11523Ea placementData = C11523Ea.m38113a(positioning);
        if (this.f35902k) {
            m38293a(placementData);
        } else {
            this.f35901j = placementData;
        }
        this.f35900i = true;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo37961a() {
        if (this.f35903l) {
            m38299b();
            return;
        }
        if (this.f35900i) {
            m38293a(this.f35901j);
        }
        this.f35902k = true;
    }

    /* renamed from: a */
    private void m38293a(C11523Ea placementData) {
        removeAdsInRange(0, this.f35909r);
        this.f35904m = placementData;
        m38301c();
        this.f35903l = true;
    }

    public void placeAdsInRange(int startPosition, int endPosition) {
        this.f35907p = startPosition;
        this.f35908q = Math.min(endPosition, startPosition + 100);
        m38299b();
    }

    public boolean isAd(int position) {
        return this.f35904m.mo37772g(position);
    }

    public void clearAds() {
        removeAdsInRange(0, this.f35909r);
        this.f35897f.mo38167a();
    }

    public void destroy() {
        this.f35894c.removeMessages(0);
        this.f35897f.mo38167a();
        this.f35904m.mo37763a();
    }

    public Object getAdData(int position) {
        return this.f35904m.mo37770e(position);
    }

    public View getAdView(int position, View convertView, ViewGroup parent) {
        View view;
        NativeAd nativeAd = this.f35904m.mo37770e(position);
        if (nativeAd == null) {
            return null;
        }
        if (convertView != null) {
            view = convertView;
        } else {
            view = nativeAd.createAdView(this.f35893b, parent);
        }
        bindAdView(nativeAd, view);
        return view;
    }

    public void bindAdView(NativeAd nativeAd, View adView) {
        WeakReference<View> mappedViewRef = (WeakReference) this.f35898g.get(nativeAd);
        View mappedView = null;
        if (mappedViewRef != null) {
            mappedView = (View) mappedViewRef.get();
        }
        if (!adView.equals(mappedView)) {
            m38292a(mappedView);
            m38292a(adView);
            m38294a(nativeAd, adView);
            nativeAd.renderAdView(adView);
        }
    }

    public int removeAdsInRange(int originalStartPosition, int originalEndPosition) {
        int[] positions = this.f35904m.mo37768c();
        int adjustedStartRange = this.f35904m.mo37765b(originalStartPosition);
        int adjustedEndRange = this.f35904m.mo37765b(originalEndPosition);
        ArrayList<Integer> removedPositions = new ArrayList<>();
        for (int i = positions.length - 1; i >= 0; i--) {
            int position = positions[i];
            if (position >= adjustedStartRange && position < adjustedEndRange) {
                removedPositions.add(Integer.valueOf(position));
                int i2 = this.f35907p;
                if (position < i2) {
                    this.f35907p = i2 - 1;
                }
                this.f35909r--;
            }
        }
        int clearedAdsCount = this.f35904m.mo37762a(adjustedStartRange, adjustedEndRange);
        Iterator it = removedPositions.iterator();
        while (it.hasNext()) {
            this.f35906o.onAdRemoved(((Integer) it.next()).intValue());
        }
        return clearedAdsCount;
    }

    public int getAdViewTypeCount() {
        return this.f35897f.mo38173c();
    }

    public int getAdViewType(int position) {
        NativeAd nativeAd = this.f35904m.mo37770e(position);
        if (nativeAd == null) {
            return 0;
        }
        return this.f35897f.getViewTypeForAd(nativeAd);
    }

    public int getOriginalPosition(int position) {
        return this.f35904m.mo37769d(position);
    }

    public int getAdjustedPosition(int originalPosition) {
        return this.f35904m.mo37765b(originalPosition);
    }

    public int getOriginalCount(int count) {
        return this.f35904m.mo37767c(count);
    }

    public int getAdjustedCount(int originalCount) {
        return this.f35904m.mo37761a(originalCount);
    }

    public void setItemCount(int originalCount) {
        this.f35909r = this.f35904m.mo37761a(originalCount);
        if (this.f35903l) {
            m38299b();
        }
    }

    public void insertItem(int originalPosition) {
        this.f35904m.mo37771f(originalPosition);
    }

    public void removeItem(int originalPosition) {
        this.f35904m.mo37774i(originalPosition);
    }

    public void moveItem(int originalPosition, int newPosition) {
        this.f35904m.mo37766b(originalPosition, newPosition);
    }

    /* renamed from: b */
    private void m38299b() {
        if (!this.f35910s) {
            this.f35910s = true;
            this.f35894c.post(this.f35895d);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m38301c() {
        if (m38296a(this.f35907p, this.f35908q)) {
            int i = this.f35908q;
            m38296a(i, i + 6);
        }
    }

    /* renamed from: a */
    private boolean m38296a(int start, int end) {
        int position = start;
        int lastPosition = end - 1;
        while (position <= lastPosition && position != -1 && position < this.f35909r) {
            if (this.f35904m.mo37775j(position)) {
                if (!m38295a(position)) {
                    return false;
                }
                lastPosition++;
            }
            position = this.f35904m.mo37773h(position);
        }
        return true;
    }

    /* renamed from: a */
    private boolean m38295a(int position) {
        NativeAd nativeAd = this.f35897f.mo38172b();
        if (nativeAd == null) {
            return false;
        }
        this.f35904m.mo37764a(position, nativeAd);
        this.f35909r++;
        this.f35906o.onAdLoaded(position);
        return true;
    }

    /* renamed from: a */
    private void m38292a(View view) {
        if (view != null) {
            NativeAd lastNativeAd = (NativeAd) this.f35899h.get(view);
            if (lastNativeAd != null) {
                lastNativeAd.clear(view);
                this.f35899h.remove(view);
                this.f35898g.remove(lastNativeAd);
            }
        }
    }

    /* renamed from: a */
    private void m38294a(NativeAd nativeAd, View view) {
        this.f35898g.put(nativeAd, new WeakReference(view));
        this.f35899h.put(view, nativeAd);
        nativeAd.prepare(view);
    }
}
