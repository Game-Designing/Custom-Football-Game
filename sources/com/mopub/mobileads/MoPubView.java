package com.mopub.mobileads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.mopub.common.AdFormat;
import com.mopub.common.AdReport;
import com.mopub.common.MoPub;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.ManifestUtils;
import com.mopub.common.util.Reflection;
import com.mopub.common.util.Reflection.MethodBuilder;
import com.mopub.common.util.Visibility;
import com.mopub.mobileads.factories.AdViewControllerFactory;
import java.util.Map;
import java.util.TreeMap;

public class MoPubView extends FrameLayout {

    /* renamed from: a */
    protected AdViewController f34873a;

    /* renamed from: b */
    protected Object f34874b;

    /* renamed from: c */
    private Context f34875c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f34876d;

    /* renamed from: e */
    private BroadcastReceiver f34877e;

    /* renamed from: f */
    private BannerAdListener f34878f;

    public interface BannerAdListener {
        void onBannerClicked(MoPubView moPubView);

        void onBannerCollapsed(MoPubView moPubView);

        void onBannerExpanded(MoPubView moPubView);

        void onBannerFailed(MoPubView moPubView, MoPubErrorCode moPubErrorCode);

        void onBannerLoaded(MoPubView moPubView);
    }

    public MoPubView(Context context) {
        this(context, null);
    }

    public MoPubView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ManifestUtils.checkWebViewActivitiesDeclared(context);
        this.f34875c = context;
        this.f34876d = getVisibility();
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.f34873a = AdViewControllerFactory.create(context, this);
        m37487m();
    }

    /* renamed from: m */
    private void m37487m() {
        this.f34877e = new C11422la(this);
        IntentFilter filter = new IntentFilter("android.intent.action.SCREEN_OFF");
        filter.addAction("android.intent.action.USER_PRESENT");
        this.f34875c.registerReceiver(this.f34877e, filter);
    }

    /* renamed from: n */
    private void m37488n() {
        try {
            this.f34875c.unregisterReceiver(this.f34877e);
        } catch (Exception e) {
            MoPubLog.log(AdLogEvent.CUSTOM, "Failed to unregister screen state broadcast receiver (never registered).");
        }
    }

    public void loadAd() {
        if (this.f34873a != null) {
            MoPubLog.log(AdLogEvent.LOAD_ATTEMPTED, new Object[0]);
            this.f34873a.loadAd();
        }
    }

    public void destroy() {
        MoPubLog.log(AdLogEvent.CUSTOM, "Destroy() called");
        m37488n();
        removeAllViews();
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            adViewController.mo36856a();
            this.f34873a = null;
        }
        if (this.f34874b != null) {
            mo37085l();
            this.f34874b = null;
        }
    }

    /* renamed from: l */
    private void mo37085l() {
        Object obj = this.f34874b;
        if (obj != null) {
            try {
                new MethodBuilder(obj, "invalidate").setAccessible().execute();
            } catch (Exception e) {
                MoPubLog.log(SdkLogEvent.ERROR, "Error invalidating adapter", e);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Integer mo37101a(int defaultValue) {
        AdViewController adViewController = this.f34873a;
        if (adViewController == null) {
            return Integer.valueOf(defaultValue);
        }
        return adViewController.mo36855a(defaultValue);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo37104b(MoPubErrorCode errorCode) {
        AdViewController adViewController = this.f34873a;
        if (adViewController == null) {
            return false;
        }
        return adViewController.mo36867b(errorCode);
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
            if (this.f34874b != null) {
                mo37085l();
            }
            MoPubLog.log(AdLogEvent.CUSTOM, "Loading custom event adapter.");
            if (Reflection.classFound("com.mopub.mobileads.factories.CustomEventBannerAdapterFactory")) {
                try {
                    this.f34874b = new MethodBuilder(null, "create").setStatic(Class.forName("com.mopub.mobileads.factories.CustomEventBannerAdapterFactory")).addParam(MoPubView.class, this).addParam(String.class, customEventClassName).addParam(Map.class, serverExtras).addParam(Long.TYPE, Long.valueOf(this.f34873a.getBroadcastIdentifier())).addParam(AdReport.class, this.f34873a.getAdReport()).execute();
                    new MethodBuilder(this.f34874b, "loadAd").setAccessible().execute();
                } catch (Exception e) {
                    MoPubLog.log(SdkLogEvent.ERROR, "Error loading custom event", e);
                }
            } else {
                MoPubLog.log(AdLogEvent.CUSTOM, "Could not load custom event -- missing banner module");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo37127i() {
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            adViewController.mo36887i();
            mo37102a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo37129k() {
        MoPubLog.log(AdLogEvent.CUSTOM, "Tracking impression. MoPubView internal.");
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            adViewController.mo36892m();
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int visibility) {
        if (Visibility.hasScreenVisibilityChanged(this.f34876d, visibility)) {
            this.f34876d = visibility;
            setAdVisibility(this.f34876d);
        }
    }

    /* access modifiers changed from: private */
    public void setAdVisibility(int visibility) {
        if (this.f34873a != null) {
            if (Visibility.isScreenVisible(visibility)) {
                this.f34873a.mo36888j();
            } else {
                this.f34873a.mo36886h();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo37105c() {
        MoPubLog.log(AdLogEvent.LOAD_SUCCESS, new Object[0]);
        BannerAdListener bannerAdListener = this.f34878f;
        if (bannerAdListener != null) {
            bannerAdListener.onBannerLoaded(this);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37081a(MoPubErrorCode errorCode) {
        MoPubLog.log(AdLogEvent.LOAD_FAILED, Integer.valueOf(errorCode.getIntCode()), errorCode);
        BannerAdListener bannerAdListener = this.f34878f;
        if (bannerAdListener != null) {
            bannerAdListener.onBannerFailed(this, errorCode);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo37106d() {
        BannerAdListener bannerAdListener = this.f34878f;
        if (bannerAdListener != null) {
            bannerAdListener.onBannerExpanded(this);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo37103b() {
        MoPubLog.log(AdLogEvent.DID_DISAPPEAR, new Object[0]);
        BannerAdListener bannerAdListener = this.f34878f;
        if (bannerAdListener != null) {
            bannerAdListener.onBannerCollapsed(this);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37102a() {
        MoPubLog.log(AdLogEvent.CLICKED, new Object[0]);
        BannerAdListener bannerAdListener = this.f34878f;
        if (bannerAdListener != null) {
            bannerAdListener.onBannerClicked(this);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo37108e() {
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            adViewController.mo36865b();
        }
        mo37105c();
    }

    public void setAdUnitId(String adUnitId) {
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            adViewController.setAdUnitId(adUnitId);
        }
    }

    public String getAdUnitId() {
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            return adViewController.getAdUnitId();
        }
        return null;
    }

    public void setKeywords(String keywords) {
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            adViewController.setKeywords(keywords);
        }
    }

    public String getKeywords() {
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            return adViewController.getKeywords();
        }
        return null;
    }

    public void setUserDataKeywords(String userDataKeywords) {
        if (this.f34873a != null && MoPub.canCollectPersonalInformation()) {
            this.f34873a.setUserDataKeywords(userDataKeywords);
        }
    }

    public String getUserDataKeywords() {
        if (this.f34873a == null || !MoPub.canCollectPersonalInformation()) {
            return null;
        }
        return this.f34873a.getUserDataKeywords();
    }

    public void setLocation(Location location) {
        if (this.f34873a != null && MoPub.canCollectPersonalInformation()) {
            this.f34873a.setLocation(location);
        }
    }

    public Location getLocation() {
        if (this.f34873a == null || !MoPub.canCollectPersonalInformation()) {
            return null;
        }
        return this.f34873a.getLocation();
    }

    public int getAdWidth() {
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            return adViewController.getAdWidth();
        }
        return 0;
    }

    public int getAdHeight() {
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            return adViewController.getAdHeight();
        }
        return 0;
    }

    public Activity getActivity() {
        return (Activity) this.f34875c;
    }

    public void setBannerAdListener(BannerAdListener listener) {
        this.f34878f = listener;
    }

    public BannerAdListener getBannerAdListener() {
        return this.f34878f;
    }

    public void setLocalExtras(Map<String, Object> localExtras) {
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            adViewController.mo36863a(localExtras);
        }
    }

    public Map<String, Object> getLocalExtras() {
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            return adViewController.mo36872g();
        }
        return new TreeMap();
    }

    public void setAutorefreshEnabled(boolean enabled) {
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            adViewController.mo36864a(enabled);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo37126h() {
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            adViewController.mo36886h();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo37128j() {
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            adViewController.mo36888j();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo37111g() {
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            adViewController.mo36869d();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo37109f() {
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            adViewController.mo36868c();
        }
    }

    public boolean getAutorefreshEnabled() {
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            return adViewController.getCurrentAutoRefreshStatus();
        }
        MoPubLog.log(AdLogEvent.CUSTOM, "Can't get autorefresh status for destroyed MoPubView. Returning false.");
        return false;
    }

    public void setAdContentView(View view) {
        MoPubLog.log(AdLogEvent.SHOW_ATTEMPTED, new Object[0]);
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            adViewController.mo36857a(view);
            MoPubLog.log(AdLogEvent.SHOW_SUCCESS, new Object[0]);
            return;
        }
        MoPubLog.log(AdLogEvent.SHOW_FAILED, new Object[0]);
    }

    public void setTesting(boolean testing) {
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            adViewController.setTesting(testing);
        }
    }

    public boolean getTesting() {
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            return adViewController.getTesting();
        }
        MoPubLog.log(AdLogEvent.CUSTOM, "Can't get testing status for destroyed MoPubView. Returning false.");
        return false;
    }

    public void forceRefresh() {
        if (this.f34874b != null) {
            mo37085l();
            this.f34874b = null;
        }
        AdViewController adViewController = this.f34873a;
        if (adViewController != null) {
            adViewController.mo36870e();
        }
    }

    /* access modifiers changed from: 0000 */
    public AdViewController getAdViewController() {
        return this.f34873a;
    }

    public AdFormat getAdFormat() {
        return AdFormat.BANNER;
    }

    @Deprecated
    public void setTimeout(int milliseconds) {
    }

    @Deprecated
    public String getResponseString() {
        return null;
    }

    @Deprecated
    public String getClickTrackingUrl() {
        return null;
    }
}
