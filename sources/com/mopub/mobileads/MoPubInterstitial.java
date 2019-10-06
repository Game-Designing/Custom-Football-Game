package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.mobileads.factories.CustomEventInterstitialAdapterFactory;
import java.util.Map;

public class MoPubInterstitial implements C11303a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MoPubInterstitialView f34838a = new MoPubInterstitialView(this.f34841d);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CustomEventInterstitialAdapter f34839b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public InterstitialAdListener f34840c;

    /* renamed from: d */
    private Activity f34841d;

    /* renamed from: e */
    private Handler f34842e;

    /* renamed from: f */
    private final Runnable f34843f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile C11331a f34844g;

    public interface InterstitialAdListener {
        void onInterstitialClicked(MoPubInterstitial moPubInterstitial);

        void onInterstitialDismissed(MoPubInterstitial moPubInterstitial);

        void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode);

        void onInterstitialLoaded(MoPubInterstitial moPubInterstitial);

        void onInterstitialShown(MoPubInterstitial moPubInterstitial);
    }

    public class MoPubInterstitialView extends MoPubView {
        public MoPubInterstitialView(Context context) {
            super(context);
            setAutorefreshEnabled(false);
        }

        /* access modifiers changed from: 0000 */
        public String getCustomEventClassName() {
            return this.f34873a.getCustomEventClassName();
        }

        public AdFormat getAdFormat() {
            return AdFormat.INTERSTITIAL;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo37082a(String customEventClassName, Map<String, String> serverExtras) {
            if (this.f34873a != null) {
                if (TextUtils.isEmpty(customEventClassName)) {
                    MoPubLog.log(AdLogEvent.CUSTOM, "Couldn't invoke custom event because the server did not specify one.");
                    mo37104b(MoPubErrorCode.ADAPTER_NOT_FOUND);
                    return;
                }
                if (MoPubInterstitial.this.f34839b != null) {
                    MoPubInterstitial.this.f34839b.mo36980a();
                }
                MoPubLog.log(AdLogEvent.CUSTOM, "Loading custom event interstitial adapter.");
                MoPubInterstitial moPubInterstitial = MoPubInterstitial.this;
                moPubInterstitial.f34839b = CustomEventInterstitialAdapterFactory.create(moPubInterstitial, customEventClassName, serverExtras, this.f34873a.getBroadcastIdentifier(), this.f34873a.getAdReport());
                MoPubInterstitial.this.f34839b.mo36981a(MoPubInterstitial.this);
                MoPubInterstitial.this.f34839b.mo36984d();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: l */
        public void mo37085l() {
            MoPubLog.log(AdLogEvent.CUSTOM, "Tracking impression for interstitial.");
            AdViewController adViewController = this.f34873a;
            if (adViewController != null) {
                adViewController.mo36892m();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo37081a(MoPubErrorCode errorCode) {
            MoPubInterstitial.this.m37429a(C11331a.IDLE);
            if (MoPubInterstitial.this.f34840c != null) {
                MoPubInterstitial.this.f34840c.onInterstitialFailed(MoPubInterstitial.this, errorCode);
            }
        }
    }

    @VisibleForTesting
    /* renamed from: com.mopub.mobileads.MoPubInterstitial$a */
    enum C11331a {
        IDLE,
        LOADING,
        READY,
        SHOWING,
        DESTROYED
    }

    public MoPubInterstitial(Activity activity, String adUnitId) {
        this.f34841d = activity;
        this.f34838a.setAdUnitId(adUnitId);
        this.f34844g = C11331a.IDLE;
        this.f34842e = new Handler();
        this.f34843f = new C11347S(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m37429a(C11331a endState) {
        return mo37063a(endState, false);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0108, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0170, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x017f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0066, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00be, code lost:
        return false;
     */
    @com.mopub.common.VisibleForTesting
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo37063a(com.mopub.mobileads.MoPubInterstitial.C11331a r10, boolean r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.mopub.common.Preconditions.checkNotNull(r10)     // Catch:{ all -> 0x0180 }
            com.mopub.mobileads.MoPubInterstitial$a r0 = r9.f34844g     // Catch:{ all -> 0x0180 }
            int[] r1 = com.mopub.mobileads.C11349T.f34940a     // Catch:{ all -> 0x0180 }
            int r2 = r0.ordinal()     // Catch:{ all -> 0x0180 }
            r1 = r1[r2]     // Catch:{ all -> 0x0180 }
            r2 = 2
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 1
            r7 = 0
            if (r1 == r6) goto L_0x0109
            if (r1 == r2) goto L_0x00bf
            if (r1 == r5) goto L_0x0074
            if (r1 == r4) goto L_0x0067
            if (r1 == r3) goto L_0x0020
            monitor-exit(r9)
            return r7
        L_0x0020:
            int[] r1 = com.mopub.mobileads.C11349T.f34940a     // Catch:{ all -> 0x0180 }
            int r3 = r10.ordinal()     // Catch:{ all -> 0x0180 }
            r1 = r1[r3]     // Catch:{ all -> 0x0180 }
            if (r1 == r6) goto L_0x0051
            if (r1 == r2) goto L_0x0044
            if (r1 == r5) goto L_0x0037
            if (r1 == r4) goto L_0x0032
            monitor-exit(r9)
            return r7
        L_0x0032:
            r9.m37434c()     // Catch:{ all -> 0x0180 }
            monitor-exit(r9)
            return r6
        L_0x0037:
            com.mopub.common.logging.MoPubLog$AdLogEvent r1 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM     // Catch:{ all -> 0x0180 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x0180 }
            java.lang.String r3 = "No interstitial loading or loaded."
            r2[r7] = r3     // Catch:{ all -> 0x0180 }
            com.mopub.common.logging.MoPubLog.log(r1, r2)     // Catch:{ all -> 0x0180 }
            monitor-exit(r9)
            return r7
        L_0x0044:
            com.mopub.common.logging.MoPubLog$AdLogEvent r1 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM     // Catch:{ all -> 0x0180 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x0180 }
            java.lang.String r3 = "Attempted transition from IDLE to READY failed due to no known load call."
            r2[r7] = r3     // Catch:{ all -> 0x0180 }
            com.mopub.common.logging.MoPubLog.log(r1, r2)     // Catch:{ all -> 0x0180 }
            monitor-exit(r9)
            return r7
        L_0x0051:
            r9.m37432b()     // Catch:{ all -> 0x0180 }
            com.mopub.mobileads.MoPubInterstitial$a r1 = com.mopub.mobileads.MoPubInterstitial.C11331a.LOADING     // Catch:{ all -> 0x0180 }
            r9.f34844g = r1     // Catch:{ all -> 0x0180 }
            if (r11 == 0) goto L_0x0060
            com.mopub.mobileads.MoPubInterstitial$MoPubInterstitialView r1 = r9.f34838a     // Catch:{ all -> 0x0180 }
            r1.forceRefresh()     // Catch:{ all -> 0x0180 }
            goto L_0x0065
        L_0x0060:
            com.mopub.mobileads.MoPubInterstitial$MoPubInterstitialView r1 = r9.f34838a     // Catch:{ all -> 0x0180 }
            r1.loadAd()     // Catch:{ all -> 0x0180 }
        L_0x0065:
            monitor-exit(r9)
            return r6
        L_0x0067:
            com.mopub.common.logging.MoPubLog$AdLogEvent r1 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM     // Catch:{ all -> 0x0180 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x0180 }
            java.lang.String r3 = "MoPubInterstitial destroyed. Ignoring all requests."
            r2[r7] = r3     // Catch:{ all -> 0x0180 }
            com.mopub.common.logging.MoPubLog.log(r1, r2)     // Catch:{ all -> 0x0180 }
            monitor-exit(r9)
            return r7
        L_0x0074:
            int[] r1 = com.mopub.mobileads.C11349T.f34940a     // Catch:{ all -> 0x0180 }
            int r2 = r10.ordinal()     // Catch:{ all -> 0x0180 }
            r1 = r1[r2]     // Catch:{ all -> 0x0180 }
            if (r1 == r6) goto L_0x00b0
            if (r1 == r5) goto L_0x00a3
            if (r1 == r4) goto L_0x009e
            if (r1 == r3) goto L_0x0086
            monitor-exit(r9)
            return r7
        L_0x0086:
            if (r11 == 0) goto L_0x0095
            com.mopub.common.logging.MoPubLog$AdLogEvent r1 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM     // Catch:{ all -> 0x0180 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x0180 }
            java.lang.String r3 = "Cannot force refresh while showing an interstitial."
            r2[r7] = r3     // Catch:{ all -> 0x0180 }
            com.mopub.common.logging.MoPubLog.log(r1, r2)     // Catch:{ all -> 0x0180 }
            monitor-exit(r9)
            return r7
        L_0x0095:
            r9.m37432b()     // Catch:{ all -> 0x0180 }
            com.mopub.mobileads.MoPubInterstitial$a r1 = com.mopub.mobileads.MoPubInterstitial.C11331a.IDLE     // Catch:{ all -> 0x0180 }
            r9.f34844g = r1     // Catch:{ all -> 0x0180 }
            monitor-exit(r9)
            return r6
        L_0x009e:
            r9.m37434c()     // Catch:{ all -> 0x0180 }
            monitor-exit(r9)
            return r6
        L_0x00a3:
            com.mopub.common.logging.MoPubLog$AdLogEvent r1 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM     // Catch:{ all -> 0x0180 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x0180 }
            java.lang.String r3 = "Already showing an interstitial. Cannot show it again."
            r2[r7] = r3     // Catch:{ all -> 0x0180 }
            com.mopub.common.logging.MoPubLog.log(r1, r2)     // Catch:{ all -> 0x0180 }
            monitor-exit(r9)
            return r7
        L_0x00b0:
            if (r11 != 0) goto L_0x00bd
            com.mopub.common.logging.MoPubLog$AdLogEvent r1 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM     // Catch:{ all -> 0x0180 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x0180 }
            java.lang.String r3 = "Interstitial already showing. Not loading another."
            r2[r7] = r3     // Catch:{ all -> 0x0180 }
            com.mopub.common.logging.MoPubLog.log(r1, r2)     // Catch:{ all -> 0x0180 }
        L_0x00bd:
            monitor-exit(r9)
            return r7
        L_0x00bf:
            int[] r1 = com.mopub.mobileads.C11349T.f34940a     // Catch:{ all -> 0x0180 }
            int r2 = r10.ordinal()     // Catch:{ all -> 0x0180 }
            r1 = r1[r2]     // Catch:{ all -> 0x0180 }
            if (r1 == r6) goto L_0x00f3
            if (r1 == r5) goto L_0x00e3
            if (r1 == r4) goto L_0x00de
            if (r1 == r3) goto L_0x00d1
            monitor-exit(r9)
            return r7
        L_0x00d1:
            if (r11 == 0) goto L_0x00dc
            r9.m37432b()     // Catch:{ all -> 0x0180 }
            com.mopub.mobileads.MoPubInterstitial$a r1 = com.mopub.mobileads.MoPubInterstitial.C11331a.IDLE     // Catch:{ all -> 0x0180 }
            r9.f34844g = r1     // Catch:{ all -> 0x0180 }
            monitor-exit(r9)
            return r6
        L_0x00dc:
            monitor-exit(r9)
            return r7
        L_0x00de:
            r9.m37434c()     // Catch:{ all -> 0x0180 }
            monitor-exit(r9)
            return r6
        L_0x00e3:
            r9.m37436d()     // Catch:{ all -> 0x0180 }
            com.mopub.mobileads.MoPubInterstitial$a r1 = com.mopub.mobileads.MoPubInterstitial.C11331a.SHOWING     // Catch:{ all -> 0x0180 }
            r9.f34844g = r1     // Catch:{ all -> 0x0180 }
            android.os.Handler r1 = r9.f34842e     // Catch:{ all -> 0x0180 }
            java.lang.Runnable r2 = r9.f34843f     // Catch:{ all -> 0x0180 }
            r1.removeCallbacks(r2)     // Catch:{ all -> 0x0180 }
            monitor-exit(r9)
            return r6
        L_0x00f3:
            com.mopub.common.logging.MoPubLog$AdLogEvent r1 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM     // Catch:{ all -> 0x0180 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x0180 }
            java.lang.String r3 = "Interstitial already loaded. Not loading another."
            r2[r7] = r3     // Catch:{ all -> 0x0180 }
            com.mopub.common.logging.MoPubLog.log(r1, r2)     // Catch:{ all -> 0x0180 }
            com.mopub.mobileads.MoPubInterstitial$InterstitialAdListener r1 = r9.f34840c     // Catch:{ all -> 0x0180 }
            if (r1 == 0) goto L_0x0107
            com.mopub.mobileads.MoPubInterstitial$InterstitialAdListener r1 = r9.f34840c     // Catch:{ all -> 0x0180 }
            r1.onInterstitialLoaded(r9)     // Catch:{ all -> 0x0180 }
        L_0x0107:
            monitor-exit(r9)
            return r7
        L_0x0109:
            int[] r1 = com.mopub.mobileads.C11349T.f34940a     // Catch:{ all -> 0x0180 }
            int r8 = r10.ordinal()     // Catch:{ all -> 0x0180 }
            r1 = r1[r8]     // Catch:{ all -> 0x0180 }
            if (r1 == r6) goto L_0x0171
            if (r1 == r2) goto L_0x0138
            if (r1 == r5) goto L_0x012b
            if (r1 == r4) goto L_0x0126
            if (r1 == r3) goto L_0x011d
            monitor-exit(r9)
            return r7
        L_0x011d:
            r9.m37432b()     // Catch:{ all -> 0x0180 }
            com.mopub.mobileads.MoPubInterstitial$a r1 = com.mopub.mobileads.MoPubInterstitial.C11331a.IDLE     // Catch:{ all -> 0x0180 }
            r9.f34844g = r1     // Catch:{ all -> 0x0180 }
            monitor-exit(r9)
            return r6
        L_0x0126:
            r9.m37434c()     // Catch:{ all -> 0x0180 }
            monitor-exit(r9)
            return r6
        L_0x012b:
            com.mopub.common.logging.MoPubLog$AdLogEvent r1 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM     // Catch:{ all -> 0x0180 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x0180 }
            java.lang.String r3 = "Interstitial is not ready to be shown yet."
            r2[r7] = r3     // Catch:{ all -> 0x0180 }
            com.mopub.common.logging.MoPubLog.log(r1, r2)     // Catch:{ all -> 0x0180 }
            monitor-exit(r9)
            return r7
        L_0x0138:
            com.mopub.common.logging.MoPubLog$AdLogEvent r1 = com.mopub.common.logging.MoPubLog.AdLogEvent.LOAD_SUCCESS     // Catch:{ all -> 0x0180 }
            java.lang.Object[] r2 = new java.lang.Object[r7]     // Catch:{ all -> 0x0180 }
            com.mopub.common.logging.MoPubLog.log(r1, r2)     // Catch:{ all -> 0x0180 }
            com.mopub.mobileads.MoPubInterstitial$a r1 = com.mopub.mobileads.MoPubInterstitial.C11331a.READY     // Catch:{ all -> 0x0180 }
            r9.f34844g = r1     // Catch:{ all -> 0x0180 }
            com.mopub.mobileads.MoPubInterstitial$MoPubInterstitialView r1 = r9.f34838a     // Catch:{ all -> 0x0180 }
            java.lang.String r1 = r1.getCustomEventClassName()     // Catch:{ all -> 0x0180 }
            boolean r1 = com.mopub.mobileads.AdTypeTranslator.CustomEventType.isMoPubSpecific(r1)     // Catch:{ all -> 0x0180 }
            if (r1 == 0) goto L_0x0159
            android.os.Handler r1 = r9.f34842e     // Catch:{ all -> 0x0180 }
            java.lang.Runnable r2 = r9.f34843f     // Catch:{ all -> 0x0180 }
            r3 = 14400000(0xdbba00, double:7.1145453E-317)
            r1.postDelayed(r2, r3)     // Catch:{ all -> 0x0180 }
        L_0x0159:
            com.mopub.mobileads.MoPubInterstitial$MoPubInterstitialView r1 = r9.f34838a     // Catch:{ all -> 0x0180 }
            com.mopub.mobileads.AdViewController r1 = r1.f34873a     // Catch:{ all -> 0x0180 }
            if (r1 == 0) goto L_0x0166
            com.mopub.mobileads.MoPubInterstitial$MoPubInterstitialView r1 = r9.f34838a     // Catch:{ all -> 0x0180 }
            com.mopub.mobileads.AdViewController r1 = r1.f34873a     // Catch:{ all -> 0x0180 }
            r1.mo36865b()     // Catch:{ all -> 0x0180 }
        L_0x0166:
            com.mopub.mobileads.MoPubInterstitial$InterstitialAdListener r1 = r9.f34840c     // Catch:{ all -> 0x0180 }
            if (r1 == 0) goto L_0x016f
            com.mopub.mobileads.MoPubInterstitial$InterstitialAdListener r1 = r9.f34840c     // Catch:{ all -> 0x0180 }
            r1.onInterstitialLoaded(r9)     // Catch:{ all -> 0x0180 }
        L_0x016f:
            monitor-exit(r9)
            return r6
        L_0x0171:
            if (r11 != 0) goto L_0x017e
            com.mopub.common.logging.MoPubLog$AdLogEvent r1 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM     // Catch:{ all -> 0x0180 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x0180 }
            java.lang.String r3 = "Already loading an interstitial."
            r2[r7] = r3     // Catch:{ all -> 0x0180 }
            com.mopub.common.logging.MoPubLog.log(r1, r2)     // Catch:{ all -> 0x0180 }
        L_0x017e:
            monitor-exit(r9)
            return r7
        L_0x0180:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.MoPubInterstitial.mo37063a(com.mopub.mobileads.MoPubInterstitial$a, boolean):boolean");
    }

    /* renamed from: c */
    private void m37434c() {
        m37432b();
        this.f34840c = null;
        this.f34838a.setBannerAdListener(null);
        this.f34838a.destroy();
        this.f34842e.removeCallbacks(this.f34843f);
        this.f34844g = C11331a.DESTROYED;
    }

    public void load() {
        MoPubLog.log(AdLogEvent.LOAD_ATTEMPTED, new Object[0]);
        m37429a(C11331a.LOADING);
    }

    public boolean show() {
        MoPubLog.log(AdLogEvent.SHOW_ATTEMPTED, new Object[0]);
        return m37429a(C11331a.SHOWING);
    }

    public void forceRefresh() {
        mo37063a(C11331a.IDLE, true);
        mo37063a(C11331a.LOADING, true);
    }

    public boolean isReady() {
        return this.f34844g == C11331a.READY;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo37062a() {
        return this.f34844g == C11331a.DESTROYED;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Integer mo37061a(int defaultValue) {
        return this.f34838a.mo37101a(defaultValue);
    }

    /* renamed from: d */
    private void m37436d() {
        CustomEventInterstitialAdapter customEventInterstitialAdapter = this.f34839b;
        if (customEventInterstitialAdapter != null) {
            customEventInterstitialAdapter.mo36985e();
        }
    }

    /* renamed from: b */
    private void m37432b() {
        CustomEventInterstitialAdapter customEventInterstitialAdapter = this.f34839b;
        if (customEventInterstitialAdapter != null) {
            customEventInterstitialAdapter.mo36980a();
            this.f34839b = null;
        }
    }

    public void setKeywords(String keywords) {
        this.f34838a.setKeywords(keywords);
    }

    public String getKeywords() {
        return this.f34838a.getKeywords();
    }

    public void setUserDataKeywords(String userDataKeywords) {
        this.f34838a.setUserDataKeywords(userDataKeywords);
    }

    public String getUserDataKeywords() {
        return this.f34838a.getUserDataKeywords();
    }

    public Activity getActivity() {
        return this.f34841d;
    }

    public Location getLocation() {
        return this.f34838a.getLocation();
    }

    public void destroy() {
        m37429a(C11331a.DESTROYED);
    }

    public void setInterstitialAdListener(InterstitialAdListener listener) {
        this.f34840c = listener;
    }

    public InterstitialAdListener getInterstitialAdListener() {
        return this.f34840c;
    }

    public void setTesting(boolean testing) {
        this.f34838a.setTesting(testing);
    }

    public boolean getTesting() {
        return this.f34838a.getTesting();
    }

    public void setLocalExtras(Map<String, Object> extras) {
        this.f34838a.setLocalExtras(extras);
    }

    public Map<String, Object> getLocalExtras() {
        return this.f34838a.getLocalExtras();
    }

    public void onCustomEventInterstitialLoaded() {
        if (!mo37062a()) {
            m37429a(C11331a.READY);
        }
    }

    public void onCustomEventInterstitialFailed(MoPubErrorCode errorCode) {
        if (!mo37062a()) {
            if (this.f34844g == C11331a.LOADING) {
                MoPubLog.log(AdLogEvent.LOAD_FAILED, Integer.valueOf(errorCode.getIntCode()), errorCode);
            } else if (this.f34844g == C11331a.SHOWING) {
                MoPubLog.log(AdLogEvent.SHOW_FAILED, Integer.valueOf(errorCode.getIntCode()), errorCode);
            }
            if (!this.f34838a.mo37104b(errorCode)) {
                m37429a(C11331a.IDLE);
            }
        }
    }

    public void onCustomEventInterstitialShown() {
        if (!mo37062a()) {
            MoPubLog.log(AdLogEvent.SHOW_SUCCESS, new Object[0]);
            CustomEventInterstitialAdapter customEventInterstitialAdapter = this.f34839b;
            if (customEventInterstitialAdapter == null || customEventInterstitialAdapter.mo36982b()) {
                this.f34838a.mo37085l();
            }
            InterstitialAdListener interstitialAdListener = this.f34840c;
            if (interstitialAdListener != null) {
                interstitialAdListener.onInterstitialShown(this);
            }
        }
    }

    public void onCustomEventInterstitialClicked() {
        if (!mo37062a()) {
            MoPubLog.log(AdLogEvent.CLICKED, new Object[0]);
            this.f34838a.mo37127i();
            InterstitialAdListener interstitialAdListener = this.f34840c;
            if (interstitialAdListener != null) {
                interstitialAdListener.onInterstitialClicked(this);
            }
        }
    }

    public void onCustomEventInterstitialImpression() {
        if (!mo37062a()) {
            CustomEventInterstitialAdapter customEventInterstitialAdapter = this.f34839b;
            if (customEventInterstitialAdapter != null && !customEventInterstitialAdapter.mo36982b()) {
                this.f34838a.mo37085l();
            }
        }
    }

    public void onCustomEventInterstitialDismissed() {
        if (!mo37062a()) {
            MoPubLog.log(AdLogEvent.WILL_DISAPPEAR, new Object[0]);
            m37429a(C11331a.IDLE);
            InterstitialAdListener interstitialAdListener = this.f34840c;
            if (interstitialAdListener != null) {
                interstitialAdListener.onInterstitialDismissed(this);
            }
        }
    }
}
