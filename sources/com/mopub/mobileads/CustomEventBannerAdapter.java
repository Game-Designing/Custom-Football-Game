package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.support.p001v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.ReflectionTarget;
import com.mopub.mobileads.factories.CustomEventBannerFactory;
import java.util.Map;
import java.util.TreeMap;

public class CustomEventBannerAdapter implements InternalCustomEventBannerListener {
    public static final int DEFAULT_BANNER_TIMEOUT_DELAY = 10000;

    /* renamed from: a */
    private boolean f34717a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MoPubView f34718b;

    /* renamed from: c */
    private Context f34719c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CustomEventBanner f34720d;

    /* renamed from: e */
    private Map<String, Object> f34721e;

    /* renamed from: f */
    private Map<String, String> f34722f;

    /* renamed from: g */
    private final Handler f34723g;

    /* renamed from: h */
    private final Runnable f34724h;

    /* renamed from: i */
    private int f34725i = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: j */
    private int f34726j = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: k */
    private boolean f34727k = false;

    /* renamed from: l */
    private C11446s f34728l;

    public CustomEventBannerAdapter(MoPubView moPubView, String className, Map<String, String> serverExtras, long broadcastIdentifier, AdReport adReport) {
        Preconditions.checkNotNull(serverExtras);
        this.f34723g = new Handler();
        this.f34718b = moPubView;
        this.f34719c = moPubView.getContext();
        this.f34724h = new C11465x(this);
        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("Attempting to invoke custom event: ");
        sb.append(className);
        MoPubLog.log(sdkLogEvent, sb.toString());
        try {
            this.f34720d = CustomEventBannerFactory.create(className);
            this.f34722f = new TreeMap(serverExtras);
            m37327d();
            this.f34721e = this.f34718b.getLocalExtras();
            if (this.f34718b.getLocation() != null) {
                this.f34721e.put("location", this.f34718b.getLocation());
            }
            this.f34721e.put(DataKeys.BROADCAST_IDENTIFIER_KEY, Long.valueOf(broadcastIdentifier));
            this.f34721e.put(DataKeys.AD_REPORT_KEY, adReport);
            this.f34721e.put(DataKeys.AD_WIDTH, Integer.valueOf(this.f34718b.getAdWidth()));
            this.f34721e.put(DataKeys.AD_HEIGHT, Integer.valueOf(this.f34718b.getAdHeight()));
            this.f34721e.put(DataKeys.BANNER_IMPRESSION_PIXEL_COUNT_ENABLED, Boolean.valueOf(this.f34727k));
        } catch (Exception e) {
            SdkLogEvent sdkLogEvent2 = SdkLogEvent.CUSTOM;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Couldn't locate or instantiate custom event: ");
            sb2.append(className);
            sb2.append(".");
            MoPubLog.log(sdkLogEvent2, sb2.toString());
            this.f34718b.mo37104b(MoPubErrorCode.ADAPTER_NOT_FOUND);
        }
    }

    /* access modifiers changed from: 0000 */
    @ReflectionTarget
    public void loadAd() {
        if (!mo36966a() && this.f34720d != null) {
            this.f34723g.postDelayed(this.f34724h, (long) m37326c());
            try {
                this.f34720d.loadBanner(this.f34719c, this, this.f34721e, this.f34722f);
            } catch (Exception e) {
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("loadAd() failed with code ");
                sb.append(MoPubErrorCode.INTERNAL_ERROR.getIntCode());
                sb.append(" and message ");
                sb.append(MoPubErrorCode.INTERNAL_ERROR);
                MoPubLog.log(sdkLogEvent, sb.toString());
                onBannerFailed(MoPubErrorCode.INTERNAL_ERROR);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @ReflectionTarget
    public void invalidate() {
        CustomEventBanner customEventBanner = this.f34720d;
        if (customEventBanner != null) {
            try {
                customEventBanner.onInvalidate();
            } catch (Exception e) {
                MoPubLog.log(SdkLogEvent.CUSTOM_WITH_THROWABLE, "Invalidating a custom event banner threw an exception", e);
            }
        }
        C11446s sVar = this.f34728l;
        if (sVar != null) {
            try {
                sVar.mo37546a();
            } catch (Exception e2) {
                MoPubLog.log(SdkLogEvent.CUSTOM_WITH_THROWABLE, "Destroying a banner visibility tracker threw an exception", e2);
            }
            this.f34728l = null;
        }
        this.f34719c = null;
        this.f34720d = null;
        this.f34721e = null;
        this.f34722f = null;
        this.f34717a = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo36966a() {
        return this.f34717a;
    }

    /* renamed from: b */
    private void m37325b() {
        this.f34723g.removeCallbacks(this.f34724h);
    }

    /* renamed from: c */
    private int m37326c() {
        MoPubView moPubView = this.f34718b;
        if (moPubView == null) {
            return 10000;
        }
        return moPubView.mo37101a(10000).intValue();
    }

    /* renamed from: d */
    private void m37327d() {
        String impressionMinVisibleDipsString = (String) this.f34722f.get(DataKeys.BANNER_IMPRESSION_MIN_VISIBLE_DIPS);
        String impressionMinVisibleMsString = (String) this.f34722f.get(DataKeys.BANNER_IMPRESSION_MIN_VISIBLE_MS);
        if (!TextUtils.isEmpty(impressionMinVisibleDipsString) && !TextUtils.isEmpty(impressionMinVisibleMsString)) {
            try {
                this.f34725i = Integer.parseInt(impressionMinVisibleDipsString);
            } catch (NumberFormatException e) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Cannot parse integer from header banner-impression-min-pixels");
            }
            try {
                this.f34726j = Integer.parseInt(impressionMinVisibleMsString);
            } catch (NumberFormatException e2) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Cannot parse integer from header banner-impression-min-ms");
            }
            if (this.f34725i > 0 && this.f34726j >= 0) {
                this.f34727k = true;
            }
        }
    }

    public void onBannerLoaded(View bannerView) {
        if (!mo36966a()) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "onBannerLoaded() success. Attempting to show.");
            m37325b();
            MoPubView moPubView = this.f34718b;
            if (moPubView != null) {
                moPubView.mo37108e();
                if (this.f34727k) {
                    CustomEventBanner customEventBanner = this.f34720d;
                    if (customEventBanner != null && customEventBanner.mo36957a()) {
                        this.f34718b.mo37126h();
                        C11446s sVar = new C11446s(this.f34719c, this.f34718b, bannerView, this.f34725i, this.f34726j);
                        this.f34728l = sVar;
                        this.f34728l.mo37547a((C11449c) new C11467y(this));
                    }
                }
                this.f34718b.setAdContentView(bannerView);
                if (!this.f34727k) {
                    CustomEventBanner customEventBanner2 = this.f34720d;
                    if (customEventBanner2 != null && customEventBanner2.mo36957a() && !(bannerView instanceof HtmlBannerWebView)) {
                        this.f34718b.mo37129k();
                    }
                }
                MoPubLog.log(SdkLogEvent.CUSTOM, "onBannerLoaded() - Show successful.");
            } else {
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("onBannerLoaded() - Show failed with code ");
                sb.append(MoPubErrorCode.INTERNAL_ERROR.getIntCode());
                sb.append(" and message ");
                sb.append(MoPubErrorCode.INTERNAL_ERROR);
                MoPubLog.log(sdkLogEvent, sb.toString());
            }
        }
    }

    public void onBannerFailed(MoPubErrorCode errorCode) {
        if (!mo36966a()) {
            m37325b();
            if (this.f34718b != null) {
                if (errorCode == null) {
                    errorCode = MoPubErrorCode.UNSPECIFIED;
                }
                this.f34718b.mo37104b(errorCode);
            }
        }
    }

    public void onBannerExpanded() {
        if (!mo36966a()) {
            this.f34718b.mo37111g();
            this.f34718b.mo37106d();
        }
    }

    public void onBannerCollapsed() {
        if (!mo36966a()) {
            this.f34718b.mo37109f();
            this.f34718b.mo37103b();
        }
    }

    public void onBannerClicked() {
        if (!mo36966a()) {
            MoPubView moPubView = this.f34718b;
            if (moPubView != null) {
                moPubView.mo37127i();
            }
        }
    }

    public void onBannerImpression() {
        if (!mo36966a() && this.f34718b != null) {
            CustomEventBanner customEventBanner = this.f34720d;
            if (customEventBanner != null && !customEventBanner.mo36957a()) {
                this.f34718b.mo37129k();
                if (this.f34727k) {
                    this.f34720d.mo36958b();
                }
            }
        }
    }

    public void onLeaveApplication() {
        onBannerClicked();
    }

    public void onPauseAutoRefresh() {
        MoPubView moPubView = this.f34718b;
        if (moPubView != null) {
            moPubView.mo37111g();
        }
    }

    public void onResumeAutoRefresh() {
        MoPubView moPubView = this.f34718b;
        if (moPubView != null) {
            moPubView.mo37109f();
        }
    }
}
