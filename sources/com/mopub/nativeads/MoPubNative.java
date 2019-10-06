package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.ManifestUtils;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import com.mopub.network.AdLoader;
import com.mopub.network.AdLoader.Listener;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.VolleyError;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.TreeMap;

public class MoPubNative {

    /* renamed from: a */
    static final MoPubNativeNetworkListener f35869a = new C11577X();

    /* renamed from: b */
    private final WeakReference<Context> f35870b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f35871c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MoPubNativeNetworkListener f35872d;

    /* renamed from: e */
    private Map<String, Object> f35873e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public AdLoader f35874f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C11605h f35875g;

    /* renamed from: h */
    private final Listener f35876h;

    /* renamed from: i */
    private Request f35877i;

    /* renamed from: j */
    AdRendererRegistry f35878j;

    public interface MoPubNativeNetworkListener {
        void onNativeFail(NativeErrorCode nativeErrorCode);

        void onNativeLoad(NativeAd nativeAd);
    }

    public MoPubNative(Context context, String adUnitId, MoPubNativeNetworkListener moPubNativeNetworkListener) {
        this(context, adUnitId, new AdRendererRegistry(), moPubNativeNetworkListener);
    }

    @VisibleForTesting
    public MoPubNative(Context context, String adUnitId, AdRendererRegistry adRendererRegistry, MoPubNativeNetworkListener moPubNativeNetworkListener) {
        this.f35873e = new TreeMap();
        Preconditions.checkNotNull(context, "context may not be null.");
        Preconditions.checkNotNull(adUnitId, "AdUnitId may not be null.");
        Preconditions.checkNotNull(adRendererRegistry, "AdRendererRegistry may not be null.");
        Preconditions.checkNotNull(moPubNativeNetworkListener, "MoPubNativeNetworkListener may not be null.");
        ManifestUtils.checkNativeActivitiesDeclared(context);
        this.f35870b = new WeakReference<>(context);
        this.f35871c = adUnitId;
        this.f35872d = moPubNativeNetworkListener;
        this.f35878j = adRendererRegistry;
        this.f35876h = new C11579Y(this);
    }

    public void registerAdRenderer(MoPubAdRenderer moPubAdRenderer) {
        this.f35878j.registerAdRenderer(moPubAdRenderer);
    }

    public void destroy() {
        this.f35870b.clear();
        Request request = this.f35877i;
        if (request != null) {
            request.cancel();
            this.f35877i = null;
        }
        this.f35874f = null;
        this.f35872d = f35869a;
    }

    public void setLocalExtras(Map<String, Object> localExtras) {
        if (localExtras == null) {
            this.f35873e = new TreeMap();
        } else {
            this.f35873e = new TreeMap(localExtras);
        }
    }

    public void makeRequest() {
        makeRequest(null);
    }

    public void makeRequest(RequestParameters requestParameters) {
        makeRequest(requestParameters, null);
    }

    public void makeRequest(RequestParameters requestParameters, Integer sequenceNumber) {
        Context context = mo37931a();
        if (context != null) {
            if (!DeviceUtils.isNetworkAvailable(context)) {
                this.f35872d.onNativeFail(NativeErrorCode.CONNECTION_ERROR);
            } else {
                m38269a(requestParameters, sequenceNumber);
            }
        }
    }

    /* renamed from: a */
    private void m38269a(RequestParameters requestParameters, Integer sequenceNumber) {
        Context context = mo37931a();
        if (context != null) {
            MoPubLog.log(AdLogEvent.LOAD_ATTEMPTED, new Object[0]);
            C11650va generator = new C11650va(context).withAdUnitId(this.f35871c).mo38191a(requestParameters);
            if (sequenceNumber != null) {
                generator.mo38190a(sequenceNumber.intValue());
            }
            String endpointUrl = generator.generateUrlString(Constants.HOST);
            if (endpointUrl != null) {
                AdLogEvent adLogEvent = AdLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("MoPubNative Loading ad from: ");
                sb.append(endpointUrl);
                MoPubLog.log(adLogEvent, sb.toString());
            }
            mo37933a(endpointUrl, (NativeErrorCode) null);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37933a(String endpointUrl, NativeErrorCode errorCode) {
        Context context = mo37931a();
        if (context != null) {
            AdLoader adLoader = this.f35874f;
            if (adLoader == null || !adLoader.hasMoreAds()) {
                if (TextUtils.isEmpty(endpointUrl)) {
                    this.f35872d.onNativeFail(errorCode == null ? NativeErrorCode.INVALID_REQUEST_URL : errorCode);
                    return;
                } else {
                    AdLoader adLoader2 = new AdLoader(endpointUrl, AdFormat.NATIVE, this.f35871c, context, this.f35876h);
                    this.f35874f = adLoader2;
                }
            }
            this.f35877i = this.f35874f.loadNextAd(errorCode);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38270a(AdResponse response) {
        Context context = mo37931a();
        if (context != null) {
            CustomEventNativeListener customEventNativeListener = new C11581Z(this, response);
            if (this.f35875g != null) {
                MoPubLog.log(AdLogEvent.CUSTOM, "Native adapter is not null.");
                this.f35875g.mo38163a();
            }
            this.f35875g = new C11605h(customEventNativeListener);
            this.f35875g.loadNativeAd(context, this.f35873e, response);
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo37932a(VolleyError volleyError) {
        MoPubLog.log(AdLogEvent.CUSTOM, "Native ad request failed.", volleyError);
        if (volleyError instanceof MoPubNetworkError) {
            int i = C11585aa.f36114a[((MoPubNetworkError) volleyError).getReason().ordinal()];
            if (i == 1) {
                this.f35872d.onNativeFail(NativeErrorCode.INVALID_RESPONSE);
            } else if (i == 2) {
                this.f35872d.onNativeFail(NativeErrorCode.INVALID_RESPONSE);
            } else if (i == 3) {
                MoPubLog.log(AdLogEvent.CUSTOM, MoPubErrorCode.WARMUP);
                this.f35872d.onNativeFail(NativeErrorCode.EMPTY_AD_RESPONSE);
            } else if (i != 4) {
                this.f35872d.onNativeFail(NativeErrorCode.UNSPECIFIED);
            } else {
                this.f35872d.onNativeFail(NativeErrorCode.EMPTY_AD_RESPONSE);
            }
        } else {
            NetworkResponse response = volleyError.networkResponse;
            if (response != null) {
                int i2 = response.statusCode;
                if (i2 >= 500 && i2 < 600) {
                    this.f35872d.onNativeFail(NativeErrorCode.SERVER_ERROR_RESPONSE_CODE);
                }
            }
            if (response != null || DeviceUtils.isNetworkAvailable((Context) this.f35870b.get())) {
                this.f35872d.onNativeFail(NativeErrorCode.UNSPECIFIED);
            } else {
                MoPubLog.log(AdLogEvent.CUSTOM, MoPubErrorCode.NO_CONNECTION);
                this.f35872d.onNativeFail(NativeErrorCode.CONNECTION_ERROR);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public Context mo37931a() {
        Context context = (Context) this.f35870b.get();
        if (context == null) {
            destroy();
            MoPubLog.log(AdLogEvent.CUSTOM, "Weak reference to Context in MoPubNative became null. This instance of MoPubNative is destroyed and No more requests will be processed.");
        }
        return context;
    }
}
