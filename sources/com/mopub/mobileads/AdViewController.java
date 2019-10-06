package com.mopub.mobileads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.mopub.common.AdReport;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mraid.MraidNativeCommandHandler;
import com.mopub.network.AdLoader;
import com.mopub.network.AdLoader.Listener;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.SingleImpression;
import com.mopub.network.TrackingRequest;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.VolleyError;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

public class AdViewController {

    /* renamed from: a */
    private static final LayoutParams f34648a = new LayoutParams(-2, -2, 17);

    /* renamed from: b */
    private static final WeakHashMap<View, Boolean> f34649b = new WeakHashMap<>();

    /* renamed from: A */
    private String f34650A;

    /* renamed from: c */
    private final long f34651c;

    /* renamed from: d */
    private Context f34652d;

    /* renamed from: e */
    private MoPubView f34653e;

    /* renamed from: f */
    private WebViewAdUrlGenerator f34654f;

    /* renamed from: g */
    private Request f34655g;

    /* renamed from: h */
    AdLoader f34656h;

    /* renamed from: i */
    private final Listener f34657i;

    /* renamed from: j */
    private AdResponse f34658j;

    /* renamed from: k */
    private String f34659k;

    /* renamed from: l */
    private final Runnable f34660l;

    /* renamed from: m */
    private boolean f34661m;

    /* renamed from: n */
    private Handler f34662n;

    /* renamed from: o */
    private boolean f34663o;
    @VisibleForTesting

    /* renamed from: p */
    int f34664p = 1;

    /* renamed from: q */
    private Map<String, Object> f34665q = new HashMap();

    /* renamed from: r */
    private boolean f34666r = true;

    /* renamed from: s */
    private boolean f34667s = true;

    /* renamed from: t */
    private String f34668t;

    /* renamed from: u */
    private String f34669u;

    /* renamed from: v */
    private Location f34670v;

    /* renamed from: w */
    private boolean f34671w;

    /* renamed from: x */
    private boolean f34672x;

    /* renamed from: y */
    private String f34673y;

    /* renamed from: z */
    private Integer f34674z;

    public static void setShouldHonorServerDimensions(View view) {
        f34649b.put(view, Boolean.valueOf(true));
    }

    /* renamed from: c */
    private static boolean m37241c(View view) {
        return f34649b.get(view) != null;
    }

    public AdViewController(Context context, MoPubView view) {
        this.f34652d = context;
        this.f34653e = view;
        this.f34651c = Utils.generateUniqueId();
        this.f34654f = new WebViewAdUrlGenerator(this.f34652d.getApplicationContext(), MraidNativeCommandHandler.isStorePictureSupported(this.f34652d));
        this.f34657i = new C11390c(this);
        this.f34660l = new C11393d(this);
        this.f34674z = Integer.valueOf(60000);
        this.f34662n = new Handler();
        this.f34650A = "";
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo36860a(AdResponse adResponse) {
        this.f34664p = 1;
        this.f34658j = adResponse;
        this.f34659k = adResponse.getCustomEventClassName();
        this.f34674z = this.f34658j.getRefreshTimeMillis();
        this.f34655g = null;
        mo36859a(this.f34653e, adResponse.getCustomEventClassName(), adResponse.getServerExtras());
        mo36889k();
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo36861a(VolleyError error) {
        if (error instanceof MoPubNetworkError) {
            MoPubNetworkError moPubNetworkError = (MoPubNetworkError) error;
            if (moPubNetworkError.getRefreshTimeMillis() != null) {
                this.f34674z = moPubNetworkError.getRefreshTimeMillis();
            }
        }
        MoPubErrorCode errorCode = m37237a(error, this.f34652d);
        if (errorCode == MoPubErrorCode.SERVER_ERROR) {
            this.f34664p++;
        }
        mo36858a(errorCode);
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo36859a(MoPubView moPubView, String customEventClassName, Map<String, String> serverExtras) {
        Preconditions.checkNotNull(serverExtras);
        if (moPubView == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Can't load an ad in this ad view because it was destroyed.");
            return;
        }
        moPubView.mo37082a(customEventClassName, serverExtras);
    }

    @VisibleForTesting
    /* renamed from: a */
    static MoPubErrorCode m37237a(VolleyError error, Context context) {
        NetworkResponse networkResponse = error.networkResponse;
        if (error instanceof MoPubNetworkError) {
            int i = C11399f.f35256a[((MoPubNetworkError) error).getReason().ordinal()];
            if (i == 1) {
                return MoPubErrorCode.WARMUP;
            }
            if (i != 2) {
                return MoPubErrorCode.UNSPECIFIED;
            }
            return MoPubErrorCode.NO_FILL;
        } else if (networkResponse == null) {
            if (!DeviceUtils.isNetworkAvailable(context)) {
                return MoPubErrorCode.NO_CONNECTION;
            }
            return MoPubErrorCode.UNSPECIFIED;
        } else if (error.networkResponse.statusCode >= 400) {
            return MoPubErrorCode.SERVER_ERROR;
        } else {
            return MoPubErrorCode.UNSPECIFIED;
        }
    }

    public MoPubView getMoPubView() {
        return this.f34653e;
    }

    public void loadAd() {
        this.f34664p = 1;
        m37243o();
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m37243o() {
        this.f34672x = true;
        if (TextUtils.isEmpty(this.f34673y)) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Can't load an ad in this ad view because the ad unit ID is not set. Did you forget to call setAdUnitId()?");
            mo36858a(MoPubErrorCode.MISSING_AD_UNIT_ID);
        } else if (!m37244p()) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Can't load an ad because there is no network connectivity.");
            mo36858a(MoPubErrorCode.NO_CONNECTION);
        } else {
            mo36866b(mo36871f(), null);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo36866b(String url, MoPubError moPubError) {
        if (url == null) {
            mo36858a(MoPubErrorCode.NO_FILL);
            return;
        }
        if (!url.startsWith("javascript:")) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Loading url: ");
            sb.append(url);
            MoPubLog.log(sdkLogEvent, sb.toString());
        }
        if (this.f34655g != null) {
            if (!TextUtils.isEmpty(this.f34673y)) {
                SdkLogEvent sdkLogEvent2 = SdkLogEvent.CUSTOM;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Already loading an ad for ");
                sb2.append(this.f34673y);
                sb2.append(", wait to finish.");
                MoPubLog.log(sdkLogEvent2, sb2.toString());
            }
            return;
        }
        mo36862a(url, moPubError);
    }

    @Deprecated
    public void reload() {
        loadAd();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo36867b(MoPubErrorCode errorCode) {
        if (errorCode == null) {
            MoPubLog.log(AdLogEvent.LOAD_FAILED, Integer.valueOf(MoPubErrorCode.UNSPECIFIED.getIntCode()), MoPubErrorCode.UNSPECIFIED);
        } else {
            MoPubLog.log(AdLogEvent.LOAD_FAILED, Integer.valueOf(errorCode.getIntCode()), errorCode);
        }
        AdLoader adLoader = this.f34656h;
        if (adLoader == null || !adLoader.hasMoreAds()) {
            mo36858a(MoPubErrorCode.NO_FILL);
            return false;
        }
        mo36866b("", errorCode);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public void mo36890l() {
        Request request = this.f34655g;
        if (request != null) {
            if (!request.isCanceled()) {
                this.f34655g.cancel();
            }
            this.f34655g = null;
        }
        this.f34656h = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo36865b() {
        mo36889k();
        AdLoader adLoader = this.f34656h;
        if (adLoader == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "mAdLoader is not supposed to be null");
            return;
        }
        adLoader.creativeDownloadSuccess();
        this.f34656h = null;
    }

    public String getKeywords() {
        return this.f34668t;
    }

    public void setKeywords(String keywords) {
        this.f34668t = keywords;
    }

    public String getUserDataKeywords() {
        if (!MoPub.canCollectPersonalInformation()) {
            return null;
        }
        return this.f34669u;
    }

    public void setUserDataKeywords(String userDataKeywords) {
        if (!MoPub.canCollectPersonalInformation()) {
            this.f34669u = null;
        } else {
            this.f34669u = userDataKeywords;
        }
    }

    public Location getLocation() {
        if (!MoPub.canCollectPersonalInformation()) {
            return null;
        }
        return this.f34670v;
    }

    public void setLocation(Location location) {
        if (!MoPub.canCollectPersonalInformation()) {
            this.f34670v = null;
        } else {
            this.f34670v = location;
        }
    }

    public String getAdUnitId() {
        return this.f34673y;
    }

    public String getCustomEventClassName() {
        return this.f34659k;
    }

    public void setAdUnitId(String adUnitId) {
        this.f34673y = adUnitId;
    }

    public long getBroadcastIdentifier() {
        return this.f34651c;
    }

    public int getAdWidth() {
        AdResponse adResponse = this.f34658j;
        if (adResponse == null || adResponse.getWidth() == null) {
            return 0;
        }
        return this.f34658j.getWidth().intValue();
    }

    public int getAdHeight() {
        AdResponse adResponse = this.f34658j;
        if (adResponse == null || adResponse.getHeight() == null) {
            return 0;
        }
        return this.f34658j.getHeight().intValue();
    }

    @Deprecated
    public boolean getAutorefreshEnabled() {
        return getCurrentAutoRefreshStatus();
    }

    public boolean getCurrentAutoRefreshStatus() {
        return this.f34666r;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo36886h() {
        m37240b(false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo36888j() {
        if (this.f34667s && !this.f34663o) {
            m37240b(true);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36864a(boolean shouldAllowAutoRefresh) {
        this.f34667s = shouldAllowAutoRefresh;
        m37240b(shouldAllowAutoRefresh);
    }

    /* renamed from: b */
    private void m37240b(boolean newAutoRefreshStatus) {
        if (this.f34672x && this.f34666r != newAutoRefreshStatus) {
            String enabledString = newAutoRefreshStatus ? "enabled" : "disabled";
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Refresh ");
            sb.append(enabledString);
            sb.append(" for ad unit (");
            sb.append(this.f34673y);
            sb.append(").");
            MoPubLog.log(sdkLogEvent, sb.toString());
        }
        this.f34666r = newAutoRefreshStatus;
        if (this.f34672x && this.f34666r) {
            mo36889k();
        } else if (!this.f34666r) {
            m37242n();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo36869d() {
        this.f34663o = true;
        mo36886h();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo36868c() {
        this.f34663o = false;
        mo36888j();
    }

    public AdReport getAdReport() {
        String str = this.f34673y;
        if (str == null || this.f34658j == null) {
            return null;
        }
        return new AdReport(str, ClientMetadata.getInstance(this.f34652d), this.f34658j);
    }

    public boolean getTesting() {
        return this.f34671w;
    }

    public void setTesting(boolean enabled) {
        this.f34671w = enabled;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36856a() {
        if (!this.f34661m) {
            mo36890l();
            m37240b(false);
            m37242n();
            this.f34653e = null;
            this.f34652d = null;
            this.f34654f = null;
            this.f34650A = "";
            this.f34661m = true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Integer mo36855a(int defaultValue) {
        AdResponse adResponse = this.f34658j;
        if (adResponse == null) {
            return Integer.valueOf(defaultValue);
        }
        return adResponse.getAdTimeoutMillis(defaultValue);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public void mo36892m() {
        AdResponse adResponse = this.f34658j;
        if (adResponse != null) {
            String requestId = adResponse.getRequestId();
            if (this.f34650A.equals(requestId)) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Ignoring duplicate impression.");
                return;
            }
            if (requestId != null) {
                this.f34650A = requestId;
            }
            TrackingRequest.makeTrackingHttpRequest((Iterable<String>) this.f34658j.getImpressionTrackingUrls(), this.f34652d);
            new SingleImpression(this.f34658j.getAdUnitId(), this.f34658j.getImpressionData()).sendImpression();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo36887i() {
        AdResponse adResponse = this.f34658j;
        if (adResponse != null) {
            TrackingRequest.makeTrackingHttpRequest(adResponse.getClickTrackingUrl(), this.f34652d);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36862a(String url, MoPubError moPubError) {
        MoPubView moPubView = getMoPubView();
        if (moPubView == null || this.f34652d == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Can't load an ad in this ad view because it was destroyed.");
            mo36890l();
            return;
        }
        synchronized (this) {
            if (this.f34656h == null || !this.f34656h.hasMoreAds()) {
                AdLoader adLoader = new AdLoader(url, moPubView.getAdFormat(), this.f34673y, this.f34652d, this.f34657i);
                this.f34656h = adLoader;
            }
        }
        this.f34655g = this.f34656h.loadNextAd(moPubError);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo36870e() {
        mo36890l();
        loadAd();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo36871f() {
        Location location = null;
        if (this.f34654f == null) {
            return null;
        }
        boolean canCollectPersonalInformation = MoPub.canCollectPersonalInformation();
        AdUrlGenerator withUserDataKeywords = this.f34654f.withAdUnitId(this.f34673y).withKeywords(this.f34668t).withUserDataKeywords(canCollectPersonalInformation ? this.f34669u : null);
        if (canCollectPersonalInformation) {
            location = this.f34670v;
        }
        withUserDataKeywords.withLocation(location);
        return this.f34654f.generateUrlString(Constants.HOST);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36858a(MoPubErrorCode errorCode) {
        MoPubLog.log(SdkLogEvent.CUSTOM, "Ad failed to load.");
        mo36890l();
        MoPubView moPubView = getMoPubView();
        if (moPubView != null) {
            if (!TextUtils.isEmpty(this.f34673y)) {
                mo36889k();
            }
            moPubView.mo37081a(errorCode);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public void mo36889k() {
        m37242n();
        if (this.f34666r) {
            Integer num = this.f34674z;
            if (num != null && num.intValue() > 0) {
                this.f34662n.postDelayed(this.f34660l, Math.min(600000, ((long) this.f34674z.intValue()) * ((long) Math.pow(1.5d, (double) this.f34664p))));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36863a(Map<String, Object> localExtras) {
        this.f34665q = localExtras != null ? new TreeMap(localExtras) : new TreeMap();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public Map<String, Object> mo36872g() {
        Map<String, Object> map = this.f34665q;
        return map != null ? new TreeMap(map) : new TreeMap();
    }

    /* renamed from: n */
    private void m37242n() {
        this.f34662n.removeCallbacks(this.f34660l);
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: p */
    private boolean m37244p() {
        Context context = this.f34652d;
        boolean z = false;
        if (context == null) {
            return false;
        }
        if (!DeviceUtils.isPermissionGranted(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        ConnectivityManager cm = (ConnectivityManager) this.f34652d.getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (cm != null) {
            networkInfo = cm.getActiveNetworkInfo();
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36857a(View view) {
        this.f34662n.post(new C11396e(this, view));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public LayoutParams m37239b(View view) {
        Integer width = null;
        Integer height = null;
        AdResponse adResponse = this.f34658j;
        if (adResponse != null) {
            width = adResponse.getWidth();
            height = this.f34658j.getHeight();
        }
        if (width == null || height == null || !m37241c(view) || width.intValue() <= 0 || height.intValue() <= 0) {
            return f34648a;
        }
        return new LayoutParams(Dips.asIntPixels((float) width.intValue(), this.f34652d), Dips.asIntPixels((float) height.intValue(), this.f34652d), 17);
    }
}
