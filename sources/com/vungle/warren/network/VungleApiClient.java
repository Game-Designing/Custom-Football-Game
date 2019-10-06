package com.vungle.warren.network;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.gson.C10185p;
import com.google.gson.C10188s;
import com.google.gson.C10191u;
import com.moat.analytics.mobile.vng.MoatAnalytics;
import com.moat.analytics.mobile.vng.MoatOptions;
import com.mopub.mobileads.vungle.BuildConfig;
import com.vungle.warren.Storage;
import com.vungle.warren.error.VungleError;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.JsonUtil;
import com.vungle.warren.p267ui.VungleActivity;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import p005cm.aptoide.p006pt.reviews.RateAndReviewsFragment.BundleCons;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VungleApiClient {
    private static String BASE_URL = "https://ads.api.vungle.com/";
    private static String HEADER_UA = (MANUFACTURER_AMAZON.equals(Build.MANUFACTURER) ? "VungleAmazon/6.3.24" : "VungleDroid/6.3.24");
    public static final String MANUFACTURER_AMAZON = "Amazon";
    private static final String TAG = "VungleApiClient";
    /* access modifiers changed from: private */
    public static VungleApiClient _instance;
    private static VungleApi api;
    /* access modifiers changed from: private */
    public static OkHttpClient client;
    private C10191u appBody;
    private String cacheDir;
    /* access modifiers changed from: private */
    public WeakReference<Context> context;
    /* access modifiers changed from: private */
    public C10191u deviceBody;
    /* access modifiers changed from: private */
    public boolean enableMoat;
    /* access modifiers changed from: private */
    public boolean limitAdTracking;
    private C10191u location;
    /* access modifiers changed from: private */
    public String newEndpoint;
    /* access modifiers changed from: private */
    public String reportAdEndpoint;
    /* access modifiers changed from: private */
    public String requestAdEndpoint;
    /* access modifiers changed from: private */
    public Map<String, Long> retryAfterDataMap = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public String riEndpoint;
    private boolean shouldTransmitIMEI;
    private Storage storage;
    /* access modifiers changed from: private */
    public VungleApi timeoutApi;
    private String uaString;
    private C10191u userBody;
    private String userImei;
    /* access modifiers changed from: private */
    public boolean willPlayAdEnabled;
    /* access modifiers changed from: private */
    public String willPlayAdEndpoint;
    /* access modifiers changed from: private */
    public int willPlayAdTimeout;

    private static class AdvertisingIDTask extends AsyncTask<Void, Void, String> {
        private AdvertisingIDTask() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(Void... voids) {
            String str = VungleApiClient.TAG;
            String advertId = null;
            try {
                String str2 = "advertising_id";
                if (VungleApiClient.MANUFACTURER_AMAZON.equals(Build.MANUFACTURER)) {
                    try {
                        ContentResolver cr = ((Context) VungleApiClient._instance.context.get()).getContentResolver();
                        VungleApiClient access$100 = VungleApiClient._instance;
                        boolean z = true;
                        if (Secure.getInt(cr, "limit_ad_tracking") != 1) {
                            z = false;
                        }
                        access$100.limitAdTracking = z;
                        String advertId2 = Secure.getString(cr, str2);
                        VungleApiClient._instance.addAdvertIdInCookie(advertId2);
                        return advertId2;
                    } catch (SettingNotFoundException ex) {
                        Log.w(str, "Error getting Amazon advertising info", ex);
                        return null;
                    }
                } else {
                    try {
                        Info idInfo = AdvertisingIdClient.getAdvertisingIdInfo((Context) VungleApiClient._instance.context.get());
                        if (idInfo == null) {
                            return null;
                        }
                        String advertId3 = idInfo.getId();
                        VungleApiClient._instance.limitAdTracking = idInfo.isLimitAdTrackingEnabled();
                        VungleApiClient._instance.deviceBody.mo33470a("ifa", advertId3);
                        VungleApiClient._instance.addAdvertIdInCookie(advertId3);
                        return advertId3;
                    } catch (NoClassDefFoundError ex2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Play services Not available: ");
                        sb.append(ex2.getLocalizedMessage());
                        Log.e(str, sb.toString());
                        advertId = Secure.getString(((Context) VungleApiClient._instance.context.get()).getContentResolver(), str2);
                        VungleApiClient._instance.addAdvertIdInCookie(advertId);
                        return advertId;
                    }
                }
            } catch (Exception e) {
                Log.e(str, "Cannot load Advertising ID");
                return advertId;
            }
        }
    }

    public enum WrapperFramework {
        admob,
        air,
        cocos2dx,
        corona,
        dfp,
        heyzap,
        marmalade,
        mopub,
        unity,
        fyber,
        ironsource,
        upsight,
        appodeal,
        aerserv,
        adtoapp,
        tapdaq,
        none
    }

    private VungleApiClient() {
        client = new Builder().addInterceptor(new Interceptor() {
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                String urlPath = request.url().encodedPath();
                Long retryExpireTime = (Long) VungleApiClient.this.retryAfterDataMap.get(urlPath);
                String str = "Retry-After";
                if (retryExpireTime != null) {
                    long newRetryAfter = TimeUnit.MILLISECONDS.toSeconds(retryExpireTime.longValue() - System.currentTimeMillis());
                    if (newRetryAfter > 0) {
                        Response.Builder request2 = new Response.Builder().request(request);
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        sb.append(newRetryAfter);
                        return request2.addHeader(str, sb.toString()).code(500).protocol(Protocol.HTTP_1_1).message("Server is busy").body(ResponseBody.create(MediaType.parse("application/json; charset=utf-8"), "{\"Error\":\"Retry-After\"}")).build();
                    }
                    VungleApiClient.this.retryAfterDataMap.remove(urlPath);
                }
                Response response = chain.proceed(request);
                if (response != null) {
                    int responseCode = response.code();
                    if (responseCode == 429 || responseCode == 500 || responseCode == 502 || responseCode == 503) {
                        String retryAfterTimeStr = response.headers().get(str);
                        if (!TextUtils.isEmpty(retryAfterTimeStr)) {
                            try {
                                long retryAfterTimeValue = Long.parseLong(retryAfterTimeStr);
                                if (retryAfterTimeValue > 0) {
                                    VungleApiClient.this.retryAfterDataMap.put(urlPath, Long.valueOf((1000 * retryAfterTimeValue) + System.currentTimeMillis()));
                                }
                            } catch (NumberFormatException e) {
                                Log.d(VungleApiClient.TAG, "Retry-After value is not an valid value");
                            }
                        }
                    }
                }
                return response;
            }
        }).build();
        api = (VungleApi) new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(client).build().create(VungleApi.class);
    }

    public static void updateIMEI(String imei, boolean shouldTransmit) {
        VungleApiClient vungleApiClient = _instance;
        vungleApiClient.userImei = imei;
        vungleApiClient.shouldTransmitIMEI = shouldTransmit;
    }

    public static void addWrapperInfo(WrapperFramework wrapperFramework, String wrapperFrameworkVersion) {
        if (wrapperFramework != null && wrapperFramework != WrapperFramework.none) {
            StringBuilder sb = new StringBuilder();
            sb.append(HEADER_UA);
            sb.append(";");
            sb.append(wrapperFramework);
            HEADER_UA = sb.toString();
            if (wrapperFrameworkVersion != null && !wrapperFrameworkVersion.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(HEADER_UA);
                sb2.append("/");
                sb2.append(wrapperFrameworkVersion);
                HEADER_UA = sb2.toString();
            }
        }
    }

    public static synchronized void init(Context context2, String appID, String cacheDir2, Storage storage2) {
        final Context context3 = context2;
        synchronized (VungleApiClient.class) {
            if (_instance == null) {
                _instance = new VungleApiClient();
                _instance.storage = storage2;
                _instance.context = new WeakReference<>(context3);
                _instance.shouldTransmitIMEI = false;
                _instance.cacheDir = cacheDir2;
                C10191u app = new C10191u();
                app.mo33470a("id", appID);
                app.mo33470a("bundle", context2.getPackageName());
                try {
                    app.mo33470a("ver", context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName);
                } catch (NameNotFoundException e) {
                    app.mo33470a("ver", "1.0");
                }
                C10191u device = new C10191u();
                device.mo33470a("make", Build.MANUFACTURER);
                device.mo33470a("model", Build.MODEL);
                device.mo33470a("osv", VERSION.RELEASE);
                device.mo33470a("carrier", ((TelephonyManager) context3.getSystemService("phone")).getNetworkOperatorName());
                device.mo33470a("os", MANUFACTURER_AMAZON.equals(Build.MANUFACTURER) ? "amazon" : "android");
                DisplayMetrics dm = new DisplayMetrics();
                ((WindowManager) context3.getSystemService("window")).getDefaultDisplay().getMetrics(dm);
                device.mo33469a("w", (Number) Integer.valueOf(dm.widthPixels));
                device.mo33469a("h", (Number) Integer.valueOf(dm.heightPixels));
                C10191u ext = new C10191u();
                ext.mo33467a(BuildConfig.NETWORK_NAME, (C10188s) new C10191u());
                device.mo33467a("ext", (C10188s) ext);
                if (VERSION.SDK_INT >= 17) {
                    _instance.uaString = WebSettings.getDefaultUserAgent(context2);
                    device.mo33470a("ua", _instance.uaString);
                    _instance.deviceBody = device;
                } else if (Looper.getMainLooper() == Looper.myLooper()) {
                    _instance.uaString = new WebView(context2.getApplicationContext()).getSettings().getUserAgentString();
                    device.mo33470a("ua", _instance.uaString);
                    _instance.deviceBody = device;
                } else {
                    _instance.deviceBody = device;
                    try {
                        _instance.uaString = System.getProperty("http.agent");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    final CountDownLatch latch = new CountDownLatch(1);
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            VungleApiClient._instance.deviceBody.mo33470a("ua", new WebView(context3.getApplicationContext()).getSettings().getUserAgentString());
                            latch.countDown();
                        }
                    });
                    try {
                        latch.await();
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                }
                if (context3.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
                    if (context3.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                        Log.d(TAG, "Location permission was not granted, location information will not be included");
                        new AdvertisingIDTask().execute(new Void[0]);
                        _instance.appBody = app;
                    }
                }
                Location location2 = null;
                LocationManager locationManager = (LocationManager) context3.getSystemService("location");
                List<String> providers = locationManager.getProviders(true);
                if (providers != null) {
                    for (String lastKnownLocation : providers) {
                        Location locationFromProvider = locationManager.getLastKnownLocation(lastKnownLocation);
                        if (locationFromProvider != null && (location2 == null || locationFromProvider.getAccuracy() < location2.getAccuracy())) {
                            location2 = locationFromProvider;
                        }
                    }
                    if (location2 != null) {
                        C10191u locationJsonObj = new C10191u();
                        locationJsonObj.mo33470a("accuracy", String.valueOf(location2.getAccuracy()));
                        locationJsonObj.mo33470a("latitude", String.valueOf(location2.getLatitude()));
                        locationJsonObj.mo33470a("longitude", String.valueOf(location2.getLongitude()));
                        locationJsonObj.mo33470a("speed", String.valueOf(location2.getSpeed()));
                        locationJsonObj.mo33469a("timestamp", (Number) Long.valueOf(location2.getTime()));
                        _instance.location = locationJsonObj;
                    }
                }
                new AdvertisingIDTask().execute(new Void[0]);
                _instance.appBody = app;
            }
        }
    }

    public static void config(final Callback<C10191u> callback) {
        try {
            C10191u body = new C10191u();
            body.mo33467a("device", (C10188s) _instance.getDeviceBody());
            body.mo33467a("app", (C10188s) _instance.appBody);
            body.mo33467a("user", (C10188s) _instance.getUserBody());
            C10191u request = new C10191u();
            request.mo33468a("is_auto_cached_enforced", Boolean.valueOf(false));
            body.mo33467a("request", (C10188s) request);
            VungleApiClient vungleApiClient = _instance;
            api.config(HEADER_UA, body).enqueue(new Callback<C10191u>() {
                public void onResponse(Call<C10191u> call, retrofit2.Response<C10191u> response) {
                    if (!response.isSuccessful()) {
                        callback.onResponse(call, response);
                        return;
                    }
                    C10191u jsonObject = (C10191u) response.body();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Config Response: ");
                    sb.append(jsonObject);
                    String sb2 = sb.toString();
                    String str = VungleApiClient.TAG;
                    Log.d(str, sb2);
                    String str2 = "Error Initializing Vungle. Please try again. ";
                    if (JsonUtil.hasNonNull(jsonObject, "sleep")) {
                        String str3 = "info";
                        String errorMessage = JsonUtil.hasNonNull(jsonObject, str3) ? jsonObject.mo33466a(str3).mo33439h() : "";
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str2);
                        sb3.append(errorMessage);
                        Log.e(str, sb3.toString());
                        callback.onFailure(call, new VungleException(3));
                        return;
                    }
                    String errorMessage2 = "endpoints";
                    if (!JsonUtil.hasNonNull(jsonObject, errorMessage2)) {
                        Log.e(str, str2);
                        callback.onFailure(call, new VungleException(3));
                        return;
                    }
                    C10191u endpoints = jsonObject.mo33472c(errorMessage2);
                    HttpUrl newUrl = HttpUrl.parse(endpoints.mo33466a("new").mo33439h());
                    HttpUrl adsUrl = HttpUrl.parse(endpoints.mo33466a("ads").mo33439h());
                    String str4 = "will_play_ad";
                    HttpUrl willPlayAdUrl = HttpUrl.parse(endpoints.mo33466a(str4).mo33439h());
                    HttpUrl reportAdUrl = HttpUrl.parse(endpoints.mo33466a("report_ad").mo33439h());
                    HttpUrl reportIncentivized = HttpUrl.parse(endpoints.mo33466a("ri").mo33439h());
                    VungleApiClient._instance.newEndpoint = newUrl.toString();
                    VungleApiClient._instance.requestAdEndpoint = adsUrl.toString();
                    VungleApiClient._instance.willPlayAdEndpoint = willPlayAdUrl.toString();
                    VungleApiClient._instance.reportAdEndpoint = reportAdUrl.toString();
                    VungleApiClient._instance.riEndpoint = reportIncentivized.toString();
                    C10191u willPlayAd = jsonObject.mo33472c(str4);
                    VungleApiClient._instance.willPlayAdTimeout = willPlayAd.mo33466a("request_timeout").mo33435c();
                    VungleApiClient._instance.willPlayAdEnabled = willPlayAd.mo33466a("enabled").mo33433a();
                    VungleApiClient._instance.enableMoat = jsonObject.mo33472c("viewability").mo33466a("moat").mo33433a();
                    callback.onResponse(call, response);
                    if (VungleApiClient._instance.willPlayAdEnabled) {
                        Log.v(str, "willPlayAd is enabled, generating a timeout client.");
                        VungleApiClient._instance;
                        VungleApiClient._instance.timeoutApi = (VungleApi) new Retrofit.Builder().client(VungleApiClient.client.newBuilder().readTimeout((long) VungleApiClient._instance.willPlayAdTimeout, TimeUnit.MILLISECONDS).build()).addConverterFactory(GsonConverterFactory.create()).baseUrl("https://api.vungle.com/").build().create(VungleApi.class);
                    }
                    if (VungleApiClient.getMoatEnabled()) {
                        MoatOptions options = new MoatOptions();
                        options.disableAdIdCollection = true;
                        options.disableLocationServices = true;
                        options.loggingEnabled = true;
                        MoatAnalytics.getInstance().start(options, (Application) ((Context) VungleApiClient._instance.context.get()).getApplicationContext());
                    }
                }

                public void onFailure(Call<C10191u> call, Throwable throwable) {
                    Log.e(VungleApiClient.TAG, "Failed to configure.", throwable);
                    callback.onFailure(call, throwable);
                }
            });
        } catch (IllegalStateException notInitialized) {
            callback.onFailure(null, notInitialized);
        }
    }

    public static Call<C10191u> reportNew() throws IllegalStateException {
        if (_instance.newEndpoint != null) {
            HashMap<String, String> query = new HashMap<>(2);
            query.put(BundleCons.APP_ID, _instance.appBody.mo33466a("id").mo33439h());
            query.put("ifa", _instance.getAdvertIdFromCookie());
            return api.reportNew(HEADER_UA, _instance.newEndpoint, query);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public static Call<C10191u> requestAd(String placement, boolean isHeaderBiddingEnable) throws IllegalStateException {
        if (_instance.requestAdEndpoint != null) {
            C10191u body = new C10191u();
            body.mo33467a("device", (C10188s) _instance.getDeviceBody());
            body.mo33467a("app", (C10188s) _instance.appBody);
            body.mo33467a("user", (C10188s) _instance.getUserBody());
            C10191u request = new C10191u();
            C10185p placementsArray = new C10185p();
            placementsArray.mo33432a(placement);
            request.mo33467a("placements", (C10188s) placementsArray);
            request.mo33468a("header_bidding", Boolean.valueOf(isHeaderBiddingEnable));
            body.mo33467a("request", (C10188s) request);
            return api.ads(HEADER_UA, _instance.requestAdEndpoint, body);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public static Call<C10191u> willPlayAd(String placementID, boolean autoCached, String adToken) throws IllegalStateException, VungleError {
        VungleApiClient vungleApiClient = _instance;
        if (vungleApiClient.willPlayAdEndpoint == null) {
            throw new IllegalStateException("API Client not configured yet! Must call /config first.");
        } else if (vungleApiClient.willPlayAdEnabled) {
            C10191u body = new C10191u();
            body.mo33467a("device", (C10188s) _instance.getDeviceBody());
            body.mo33467a("app", (C10188s) _instance.appBody);
            body.mo33467a("user", (C10188s) _instance.getUserBody());
            C10191u request = new C10191u();
            C10191u placement = new C10191u();
            placement.mo33470a("reference_id", placementID);
            placement.mo33468a("is_auto_cached", Boolean.valueOf(autoCached));
            request.mo33467a(VungleActivity.PLACEMENT_EXTRA, (C10188s) placement);
            request.mo33470a("ad_token", adToken);
            body.mo33467a("request", (C10188s) request);
            VungleApiClient vungleApiClient2 = _instance;
            return vungleApiClient2.timeoutApi.willPlayAd(HEADER_UA, vungleApiClient2.willPlayAdEndpoint, body);
        } else {
            throw new VungleError(6);
        }
    }

    public static Call<C10191u> reportAd(C10191u request) {
        if (_instance.reportAdEndpoint != null) {
            C10191u body = new C10191u();
            body.mo33467a("device", (C10188s) _instance.getDeviceBody());
            body.mo33467a("app", (C10188s) _instance.appBody);
            body.mo33467a("request", (C10188s) request);
            body.mo33467a("user", (C10188s) _instance.getUserBody());
            return api.reportAd(HEADER_UA, _instance.reportAdEndpoint, body);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    /* renamed from: ri */
    public static Call<C10191u> m41060ri(C10191u request) {
        if (_instance.riEndpoint != null) {
            C10191u body = new C10191u();
            body.mo33467a("device", (C10188s) _instance.getDeviceBody());
            body.mo33467a("app", (C10188s) _instance.appBody);
            body.mo33467a("request", (C10188s) request);
            return api.mo41012ri(HEADER_UA, _instance.riEndpoint, body);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public static void pingTPAT(final String url) {
        String finalUrl;
        Callback callback = new Callback<ResponseBody>() {
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
            }

            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to ping TPAT Url : ");
                sb.append(url);
                Log.e(VungleApiClient.TAG, sb.toString());
            }
        };
        if (TextUtils.isEmpty(url) || HttpUrl.parse(url) == null) {
            callback.onFailure(null, new IllegalArgumentException("Malformed Url"));
            return;
        }
        if (!TextUtils.isEmpty(_instance.userImei)) {
            VungleApiClient vungleApiClient = _instance;
            if (vungleApiClient.shouldTransmitIMEI) {
                finalUrl = url.replace("%imei%", vungleApiClient.userImei);
                api.pingTPAT(_instance.uaString, finalUrl).enqueue(callback);
            }
        }
        finalUrl = url;
        api.pingTPAT(_instance.uaString, finalUrl).enqueue(callback);
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x030f  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0319  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0333  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x03aa A[Catch:{ SettingNotFoundException -> 0x03f0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x03d0 A[Catch:{ SettingNotFoundException -> 0x03f0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01fd  */
    @android.annotation.SuppressLint({"HardwareIds"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.gson.C10191u getDeviceBody() throws java.lang.IllegalStateException {
        /*
            r28 = this;
            r1 = r28
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.context
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L_0x0462
            com.google.gson.u r0 = new com.google.gson.u
            r0.<init>()
            r2 = r0
            com.vungle.warren.network.VungleApiClient r0 = _instance
            java.lang.String r3 = r0.getAdvertIdFromCookie()
            java.lang.String r0 = "lmt"
            java.lang.String r4 = "ifa"
            java.lang.String r5 = "Amazon"
            r6 = 0
            if (r3 == 0) goto L_0x0040
            java.lang.String r7 = android.os.Build.MANUFACTURER
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x002a
            java.lang.String r7 = "amazon_advertising_id"
            goto L_0x002c
        L_0x002a:
            java.lang.String r7 = "gaid"
        L_0x002c:
            r2.mo33470a(r7, r3)
            com.google.gson.u r7 = r1.deviceBody
            r7.mo33470a(r4, r3)
            com.google.gson.u r4 = r1.deviceBody
            boolean r7 = r1.limitAdTracking
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r4.mo33469a(r0, r7)
            goto L_0x0060
        L_0x0040:
            java.lang.ref.WeakReference<android.content.Context> r7 = r1.context
            java.lang.Object r7 = r7.get()
            android.content.Context r7 = (android.content.Context) r7
            android.content.ContentResolver r7 = r7.getContentResolver()
            java.lang.String r8 = "android_id"
            java.lang.String r7 = android.provider.Settings.Secure.getString(r7, r8)
            com.google.gson.u r8 = r1.deviceBody
            r8.mo33470a(r4, r7)
            com.google.gson.u r4 = r1.deviceBody
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            r4.mo33469a(r0, r8)
        L_0x0060:
            com.vungle.warren.network.VungleApiClient$AdvertisingIDTask r0 = new com.vungle.warren.network.VungleApiClient$AdvertisingIDTask
            r4 = 0
            r0.<init>()
            java.lang.Void[] r7 = new java.lang.Void[r6]
            r0.execute(r7)
            r0 = 0
            com.vungle.warren.network.VungleApiClient r7 = _instance
            java.lang.ref.WeakReference<android.content.Context> r7 = r7.context
            java.lang.Object r7 = r7.get()
            android.content.Context r7 = (android.content.Context) r7
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            r8 = 128(0x80, float:1.794E-43)
            java.util.List r8 = r7.getInstalledPackages(r8)
            java.util.Iterator r9 = r8.iterator()
            r10 = r0
        L_0x0085:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x009d
            java.lang.Object r0 = r9.next()
            android.content.pm.PackageInfo r0 = (android.content.pm.PackageInfo) r0
            java.lang.String r11 = r0.packageName
            java.lang.String r12 = "com.google.android.gms"
            boolean r12 = r11.equalsIgnoreCase(r12)
            if (r12 == 0) goto L_0x009c
            r10 = 1
        L_0x009c:
            goto L_0x0085
        L_0x009d:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r10)
            java.lang.String r9 = "is_google_play_services_available"
            r2.mo33468a(r9, r0)
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.context
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            android.content.IntentFilter r9 = new android.content.IntentFilter
            java.lang.String r11 = "android.intent.action.BATTERY_CHANGED"
            r9.<init>(r11)
            android.content.Intent r4 = r0.registerReceiver(r4, r9)
            r0 = -1
            java.lang.String r9 = "level"
            int r9 = r4.getIntExtra(r9, r0)
            java.lang.String r11 = "scale"
            int r11 = r4.getIntExtra(r11, r0)
            if (r9 <= 0) goto L_0x00d6
            if (r11 <= 0) goto L_0x00d6
            float r12 = (float) r9
            float r13 = (float) r11
            float r12 = r12 / r13
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            java.lang.String r13 = "battery_level"
            r2.mo33469a(r13, r12)
        L_0x00d6:
            java.lang.String r12 = "status"
            int r12 = r4.getIntExtra(r12, r0)
            r13 = 4
            r14 = 2
            r15 = 1
            if (r12 != r0) goto L_0x00e5
            java.lang.String r0 = "UNKNOWN"
            r6 = r0
            goto L_0x010a
        L_0x00e5:
            if (r12 == r14) goto L_0x00ef
            r6 = 5
            if (r12 != r6) goto L_0x00eb
            goto L_0x00ef
        L_0x00eb:
            java.lang.String r0 = "NOT_CHARGING"
            r6 = r0
            goto L_0x010a
        L_0x00ef:
            java.lang.String r6 = "plugged"
            int r0 = r4.getIntExtra(r6, r0)
            if (r0 == r15) goto L_0x0107
            if (r0 == r14) goto L_0x0103
            if (r0 == r13) goto L_0x00ff
            java.lang.String r0 = "BATTERY_PLUGGED_OTHERS"
            r6 = r0
            goto L_0x010a
        L_0x00ff:
            java.lang.String r0 = "BATTERY_PLUGGED_WIRELESS"
            r6 = r0
            goto L_0x010a
        L_0x0103:
            java.lang.String r0 = "BATTERY_PLUGGED_USB"
            r6 = r0
            goto L_0x010a
        L_0x0107:
            java.lang.String r0 = "BATTERY_PLUGGED_AC"
            r6 = r0
        L_0x010a:
            java.lang.String r0 = "battery_state"
            r2.mo33470a(r0, r6)
            int r0 = android.os.Build.VERSION.SDK_INT
            r13 = 21
            if (r0 < r13) goto L_0x0139
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.context
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r13 = "power"
            java.lang.Object r0 = r0.getSystemService(r13)
            android.os.PowerManager r0 = (android.os.PowerManager) r0
            if (r0 == 0) goto L_0x012f
            boolean r13 = r0.isPowerSaveMode()
            if (r13 == 0) goto L_0x012f
            r13 = 1
            goto L_0x0130
        L_0x012f:
            r13 = 0
        L_0x0130:
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.String r14 = "battery_saver_enabled"
            r2.mo33469a(r14, r13)
        L_0x0139:
            com.vungle.warren.network.VungleApiClient r0 = _instance
            java.lang.ref.WeakReference<android.content.Context> r0 = r0.context
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r13 = "android.permission.ACCESS_NETWORK_STATE"
            int r0 = android.support.p000v4.content.C0527k.m2618a(r0, r13)
            if (r0 != 0) goto L_0x0202
            java.lang.String r0 = "NONE"
            java.lang.String r14 = "NONE"
            java.lang.ref.WeakReference<android.content.Context> r13 = r1.context
            java.lang.Object r13 = r13.get()
            android.content.Context r13 = (android.content.Context) r13
            java.lang.String r15 = "connectivity"
            java.lang.Object r13 = r13.getSystemService(r15)
            android.net.ConnectivityManager r13 = (android.net.ConnectivityManager) r13
            if (r13 == 0) goto L_0x01a4
            android.net.NetworkInfo r15 = r13.getActiveNetworkInfo()
            if (r15 == 0) goto L_0x019f
            r19 = r0
            int r0 = r15.getType()
            if (r0 == 0) goto L_0x0192
            r20 = r3
            r3 = 1
            if (r0 == r3) goto L_0x018d
            r3 = 6
            if (r0 == r3) goto L_0x018d
            r3 = 7
            if (r0 == r3) goto L_0x0188
            r3 = 9
            if (r0 == r3) goto L_0x0183
            java.lang.String r0 = "UNKNOWN"
            java.lang.String r14 = "UNKNOWN"
            goto L_0x01aa
        L_0x0183:
            java.lang.String r0 = "ETHERNET"
            java.lang.String r14 = "ETHERNET"
            goto L_0x01aa
        L_0x0188:
            java.lang.String r0 = "BLUETOOTH"
            java.lang.String r14 = "BLUETOOTH"
            goto L_0x01aa
        L_0x018d:
            java.lang.String r0 = "WIFI"
            java.lang.String r14 = "WIFI"
            goto L_0x01aa
        L_0x0192:
            r20 = r3
            java.lang.String r0 = "MOBILE"
            int r3 = r15.getSubtype()
            java.lang.String r14 = r1.getConnectionTypeDetail(r3)
            goto L_0x01aa
        L_0x019f:
            r19 = r0
            r20 = r3
            goto L_0x01a8
        L_0x01a4:
            r19 = r0
            r20 = r3
        L_0x01a8:
            r0 = r19
        L_0x01aa:
            java.lang.String r3 = "connection_type"
            r2.mo33470a(r3, r0)
            java.lang.String r3 = "connection_type_detail"
            r2.mo33470a(r3, r14)
            int r3 = android.os.Build.VERSION.SDK_INT
            r15 = 24
            if (r3 < r15) goto L_0x01fd
            boolean r3 = r13.isActiveNetworkMetered()
            java.lang.String r15 = "network_metered"
            r19 = r0
            java.lang.String r0 = "data_saver_status"
            if (r3 == 0) goto L_0x01ed
            int r3 = r13.getRestrictBackgroundStatus()
            r21 = r4
            r4 = 1
            if (r3 == r4) goto L_0x01de
            r4 = 2
            if (r3 == r4) goto L_0x01db
            r4 = 3
            if (r3 == r4) goto L_0x01d8
            java.lang.String r3 = "UNKNOWN"
            goto L_0x01e1
        L_0x01d8:
            java.lang.String r3 = "ENABLED"
            goto L_0x01e1
        L_0x01db:
            java.lang.String r3 = "WHITELISTED"
            goto L_0x01e1
        L_0x01de:
            java.lang.String r3 = "DISABLED"
        L_0x01e1:
            r2.mo33470a(r0, r3)
            r4 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            r2.mo33469a(r15, r0)
            goto L_0x0206
        L_0x01ed:
            r21 = r4
            java.lang.String r3 = "NOT_APPLICABLE"
            r2.mo33470a(r0, r3)
            r3 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            r2.mo33469a(r15, r0)
            goto L_0x0206
        L_0x01fd:
            r19 = r0
            r21 = r4
            goto L_0x0206
        L_0x0202:
            r20 = r3
            r21 = r4
        L_0x0206:
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "locale"
            r2.mo33470a(r3, r0)
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r0 = r0.getLanguage()
            java.lang.String r3 = "language"
            r2.mo33470a(r3, r0)
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()
            java.lang.String r0 = r0.getID()
            java.lang.String r3 = "time_zone"
            r2.mo33470a(r3, r0)
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.context
            java.lang.Object r0 = r0.get()
            java.lang.String r3 = "sound_enabled"
            java.lang.String r4 = "volume_level"
            if (r0 == 0) goto L_0x0404
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.context
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r13 = "audio"
            java.lang.Object r0 = r0.getSystemService(r13)
            r13 = r0
            android.media.AudioManager r13 = (android.media.AudioManager) r13
            if (r13 == 0) goto L_0x026e
            r0 = 3
            int r14 = r13.getStreamMaxVolume(r0)
            int r0 = r13.getStreamVolume(r0)
            float r15 = (float) r0
            r18 = r6
            float r6 = (float) r14
            float r15 = r15 / r6
            java.lang.Float r6 = java.lang.Float.valueOf(r15)
            r2.mo33469a(r4, r6)
            if (r0 <= 0) goto L_0x0265
            r4 = 1
            goto L_0x0266
        L_0x0265:
            r4 = 0
        L_0x0266:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2.mo33469a(r3, r4)
            goto L_0x0270
        L_0x026e:
            r18 = r6
        L_0x0270:
            java.io.File r0 = new java.io.File
            java.lang.String r3 = r1.cacheDir
            r0.<init>(r3)
            r3 = r0
            boolean r0 = r3.exists()
            if (r0 == 0) goto L_0x0286
            boolean r0 = r3.isDirectory()
            if (r0 == 0) goto L_0x0286
            r0 = 1
            goto L_0x0287
        L_0x0286:
            r0 = 0
        L_0x0287:
            if (r0 != 0) goto L_0x02a7
            boolean r4 = r3.exists()
            if (r4 != 0) goto L_0x0295
            boolean r0 = r3.mkdir()
            r4 = r0
            goto L_0x02a8
        L_0x0295:
            boolean r4 = r3.isDirectory()
            if (r4 != 0) goto L_0x02a7
            boolean r4 = r3.delete()
            if (r4 == 0) goto L_0x02a7
            boolean r0 = r3.mkdir()
            r4 = r0
            goto L_0x02a8
        L_0x02a7:
            r4 = r0
        L_0x02a8:
            r6 = 26
            if (r4 == 0) goto L_0x030f
            android.os.StatFs r0 = new android.os.StatFs
            java.lang.String r14 = r1.cacheDir
            r0.<init>(r14)
            r14 = r0
            r22 = -1
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r6) goto L_0x02e5
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.context
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.Class<android.os.storage.StorageManager> r15 = android.os.storage.StorageManager.class
            java.lang.Object r0 = r0.getSystemService(r15)
            r15 = r0
            android.os.storage.StorageManager r15 = (android.os.storage.StorageManager) r15
            if (r15 == 0) goto L_0x02e2
            java.util.UUID r0 = r15.getUuidForPath(r3)     // Catch:{ IOException -> 0x02d8 }
            long r24 = r15.getCacheQuotaBytes(r0)     // Catch:{ IOException -> 0x02d8 }
            r22 = r24
            goto L_0x02e2
        L_0x02d8:
            r0 = move-exception
            java.lang.String r6 = "VungleApiClient"
            r19 = r0
            java.lang.String r0 = "Unable to check available bytes"
            android.util.Log.e(r6, r0)
        L_0x02e2:
            r6 = r3
            r15 = r4
            goto L_0x0305
        L_0x02e5:
            r6 = 18
            if (r0 < r6) goto L_0x02f6
            long r24 = r14.getBlockSizeLong()
            long r26 = r14.getAvailableBlocksLong()
            long r22 = r24 * r26
            r6 = r3
            r15 = r4
            goto L_0x0305
        L_0x02f6:
            int r0 = r14.getBlockSize()
            int r6 = r14.getAvailableBlocks()
            int r0 = r0 * r6
            r6 = r3
            r15 = r4
            long r3 = (long) r0
            r22 = r3
        L_0x0305:
            java.lang.Long r0 = java.lang.Long.valueOf(r22)
            java.lang.String r3 = "storage_bytes_available"
            r2.mo33469a(r3, r0)
            goto L_0x0311
        L_0x030f:
            r6 = r3
            r15 = r4
        L_0x0311:
            java.lang.String r0 = android.os.Build.MANUFACTURER
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0333
            java.lang.String r0 = "amazon.hardware.fire_tv"
            java.lang.ref.WeakReference<android.content.Context> r3 = r1.context
            java.lang.Object r3 = r3.get()
            android.content.Context r3 = (android.content.Context) r3
            android.content.Context r3 = r3.getApplicationContext()
            android.content.pm.PackageManager r3 = r3.getPackageManager()
            java.lang.String r4 = "amazon.hardware.fire_tv"
            boolean r0 = r3.hasSystemFeature(r4)
            r3 = r0
            goto L_0x038f
        L_0x0333:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r0 < r3) goto L_0x0355
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.context
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r3 = "uimode"
            java.lang.Object r0 = r0.getSystemService(r3)
            android.app.UiModeManager r0 = (android.app.UiModeManager) r0
            int r3 = r0.getCurrentModeType()
            r4 = 4
            if (r3 != r4) goto L_0x0352
            r3 = 1
            goto L_0x0353
        L_0x0352:
            r3 = 0
        L_0x0353:
            r0 = r3
            goto L_0x038f
        L_0x0355:
            java.lang.String r0 = "com.google.android.tv"
            java.lang.String r3 = "android.hardware.touchscreen"
            java.lang.ref.WeakReference<android.content.Context> r4 = r1.context
            java.lang.Object r4 = r4.get()
            android.content.Context r4 = (android.content.Context) r4
            android.content.Context r4 = r4.getApplicationContext()
            android.content.pm.PackageManager r4 = r4.getPackageManager()
            java.lang.String r14 = "com.google.android.tv"
            boolean r4 = r4.hasSystemFeature(r14)
            if (r4 != 0) goto L_0x038c
            java.lang.ref.WeakReference<android.content.Context> r4 = r1.context
            java.lang.Object r4 = r4.get()
            android.content.Context r4 = (android.content.Context) r4
            android.content.Context r4 = r4.getApplicationContext()
            android.content.pm.PackageManager r4 = r4.getPackageManager()
            java.lang.String r14 = "android.hardware.touchscreen"
            boolean r4 = r4.hasSystemFeature(r14)
            if (r4 != 0) goto L_0x038a
            goto L_0x038c
        L_0x038a:
            r4 = 0
            goto L_0x038d
        L_0x038c:
            r4 = 1
        L_0x038d:
            r0 = r4
            r3 = r0
        L_0x038f:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            java.lang.String r4 = "is_tv"
            r2.mo33468a(r4, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r4 = "os_api_level"
            r2.mo33469a(r4, r0)
            r4 = 0
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ SettingNotFoundException -> 0x03f0 }
            r14 = 26
            if (r0 < r14) goto L_0x03d0
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.context     // Catch:{ SettingNotFoundException -> 0x03f0 }
            java.lang.Object r0 = r0.get()     // Catch:{ SettingNotFoundException -> 0x03f0 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ SettingNotFoundException -> 0x03f0 }
            java.lang.String r14 = "android.permission.REQUEST_INSTALL_PACKAGES"
            int r0 = r0.checkCallingOrSelfPermission(r14)     // Catch:{ SettingNotFoundException -> 0x03f0 }
            if (r0 != 0) goto L_0x03ed
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.context     // Catch:{ SettingNotFoundException -> 0x03f0 }
            java.lang.Object r0 = r0.get()     // Catch:{ SettingNotFoundException -> 0x03f0 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ SettingNotFoundException -> 0x03f0 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ SettingNotFoundException -> 0x03f0 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ SettingNotFoundException -> 0x03f0 }
            boolean r0 = r0.canRequestPackageInstalls()     // Catch:{ SettingNotFoundException -> 0x03f0 }
            r4 = r0
            goto L_0x03ed
        L_0x03d0:
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.context     // Catch:{ SettingNotFoundException -> 0x03f0 }
            java.lang.Object r0 = r0.get()     // Catch:{ SettingNotFoundException -> 0x03f0 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ SettingNotFoundException -> 0x03f0 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x03f0 }
            java.lang.String r14 = "install_non_market_apps"
            int r0 = android.provider.Settings.Secure.getInt(r0, r14)     // Catch:{ SettingNotFoundException -> 0x03f0 }
            r14 = 1
            if (r0 != r14) goto L_0x03e8
            r16 = 1
            goto L_0x03ea
        L_0x03e8:
            r16 = 0
        L_0x03ea:
            r0 = r16
            r4 = r0
        L_0x03ed:
            r17 = r3
            goto L_0x03fa
        L_0x03f0:
            r0 = move-exception
            java.lang.String r14 = "VungleApiClient"
            r17 = r3
            java.lang.String r3 = "isInstallNonMarketAppsEnabled Settings not found"
            android.util.Log.e(r14, r3, r0)
        L_0x03fa:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)
            java.lang.String r3 = "is_sideload_enabled"
            r2.mo33468a(r3, r0)
            goto L_0x0415
        L_0x0404:
            r18 = r6
            r6 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            r2.mo33469a(r4, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            r2.mo33469a(r3, r0)
        L_0x0415:
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r3 = "mounted"
            boolean r0 = r0.equals(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            java.lang.String r4 = "sd_card_available"
            r2.mo33469a(r4, r3)
            java.lang.String r3 = android.os.Build.FINGERPRINT
            java.lang.String r4 = "os_name"
            r2.mo33470a(r4, r3)
            java.lang.String r3 = "vduid"
            java.lang.String r4 = ""
            r2.mo33470a(r3, r4)
            com.vungle.warren.network.VungleApiClient r3 = _instance
            com.google.gson.u r3 = r3.location
            if (r3 == 0) goto L_0x0441
            java.lang.String r4 = "location"
            r2.mo33467a(r4, r3)
        L_0x0441:
            com.google.gson.u r3 = r1.deviceBody
            java.lang.String r4 = "ext"
            com.google.gson.u r3 = r3.mo33472c(r4)
            java.lang.String r4 = "vungle"
            com.google.gson.u r3 = r3.mo33472c(r4)
            java.lang.String r4 = android.os.Build.MANUFACTURER
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x045a
            java.lang.String r4 = "amazon"
            goto L_0x045c
        L_0x045a:
            java.lang.String r4 = "android"
        L_0x045c:
            r3.mo33467a(r4, r2)
            com.google.gson.u r3 = r1.deviceBody
            return r3
        L_0x0462:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "Context is null, SDK not initialized"
            r0.<init>(r2)
            goto L_0x046b
        L_0x046a:
            throw r0
        L_0x046b:
            goto L_0x046a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.network.VungleApiClient.getDeviceBody():com.google.gson.u");
    }

    private String getConnectionTypeDetail(int type) {
        switch (type) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHPRD";
            case 15:
                return "HSPAP";
            case 16:
                return "GSM";
            case 17:
                return "TD_SCDMA";
            case 18:
                return "IWLAN";
            default:
                return "UNKNOWN";
        }
    }

    private C10191u getUserBody() {
        String messageVersion;
        long timestamp;
        String source;
        String status;
        if (this.userBody == null) {
            this.userBody = new C10191u();
        }
        Cookie consentCookie = (Cookie) this.storage.load(Cookie.CONSENT_COOKIE, Cookie.class);
        String str = "consent_message_version";
        String str2 = "consent_source";
        String str3 = "consent_status";
        if (consentCookie != null) {
            status = consentCookie.getString(str3);
            source = consentCookie.getString(str2);
            timestamp = consentCookie.getLong("timestamp").longValue();
            messageVersion = consentCookie.getString(str);
        } else {
            status = "unknown";
            source = "no_interaction";
            timestamp = 0;
            messageVersion = "";
        }
        C10191u gdpr = new C10191u();
        gdpr.mo33470a(str3, status);
        gdpr.mo33470a(str2, source);
        gdpr.mo33469a("consent_timestamp", (Number) Long.valueOf(timestamp));
        gdpr.mo33470a(str, TextUtils.isEmpty(messageVersion) ? "" : messageVersion);
        this.userBody.mo33467a("gdpr", (C10188s) gdpr);
        return this.userBody;
    }

    public static boolean getMoatEnabled() {
        return _instance.enableMoat && VERSION.SDK_INT >= 16;
    }

    private String getAdvertIdFromCookie() {
        Cookie cookie = (Cookie) this.storage.load(Cookie.GOOGLE_AD_ID_COOKIE, Cookie.class);
        if (cookie == null) {
            return null;
        }
        return cookie.getString("advertId");
    }

    /* access modifiers changed from: private */
    public void addAdvertIdInCookie(String advertId) {
        Cookie advertIdCookie = new Cookie(Cookie.GOOGLE_AD_ID_COOKIE);
        advertIdCookie.putValue("advertId", advertId);
        this.storage.save(advertIdCookie);
    }

    public static long getRetryAfterHeaderValue(retrofit2.Response<C10191u> response) {
        try {
            return Long.parseLong(response.headers().get("Retry-After")) * 1000;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
