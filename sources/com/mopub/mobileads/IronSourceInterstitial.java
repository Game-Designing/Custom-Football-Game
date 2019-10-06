package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubLifecycleManager;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import java.util.Map;
import p005cm.aptoide.p006pt.BuildConfig;
import p019d.p273h.p276c.C12741D;
import p019d.p273h.p276c.C12741D.C12742a;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p282f.C12872g;

public class IronSourceInterstitial extends CustomEventInterstitial implements C12872g {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f34796b = IronSourceInterstitial.class.getSimpleName();

    /* renamed from: c */
    private static boolean f34797c;

    /* renamed from: d */
    private static Handler f34798d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static CustomEventInterstitialListener f34799e;

    /* renamed from: f */
    private static LifecycleListener f34800f = new C11328M();

    /* renamed from: g */
    private String f34801g = BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;

    /* renamed from: h */
    private String f34802h = null;

    /* renamed from: i */
    private String f34803i = "";

    /* renamed from: j */
    private IronSourceAdapterConfiguration f34804j = new IronSourceAdapterConfiguration();

    /* access modifiers changed from: protected */
    public void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> serverExtras) {
        String str = "placementName";
        String str2 = "applicationKey";
        String str3 = "instanceId";
        MoPubLifecycleManager.getInstance((Activity) context).addLifecycleListener(f34800f);
        C12741D.m41157a(MoPub.canCollectPersonalInformation());
        try {
            f34799e = customEventInterstitialListener;
            f34798d = new Handler(Looper.getMainLooper());
            if (!(context instanceof Activity)) {
                MoPubLog.log(AdapterLogEvent.CUSTOM, f34796b, "IronSource load interstitial must be called from an Activity context");
                m37408a(MoPubErrorCode.INTERNAL_ERROR);
                return;
            }
            if (serverExtras != null) {
                if (serverExtras.get(str2) != null) {
                    this.f34803i = (String) serverExtras.get(str2);
                }
                if (serverExtras.get(str) != null) {
                    this.f34802h = (String) serverExtras.get(str);
                }
                if (serverExtras.get(str3) != null && !TextUtils.isEmpty((CharSequence) serverExtras.get(str3))) {
                    this.f34801g = (String) serverExtras.get(str3);
                }
            } else {
                MoPubLog.log(AdapterLogEvent.CUSTOM, f34796b, "serverExtras is null. Make sure you have entered ironSource's application and instance keys on the MoPub dashboard");
                m37408a(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            }
            if (!TextUtils.isEmpty(this.f34803i)) {
                m37407a((Activity) context, this.f34803i);
                m37411h();
                this.f34804j.setCachedInitializationParameters(context, serverExtras);
            } else {
                MoPubLog.log(AdapterLogEvent.CUSTOM, f34796b, "IronSource initialization failed, make sure that 'applicationKey' server parameter is added");
                m37408a(MoPubErrorCode.INTERNAL_ERROR);
            }
        } catch (Exception e) {
            MoPubLog.log(AdapterLogEvent.CUSTOM, f34796b, e);
            m37408a(MoPubErrorCode.INTERNAL_ERROR);
        }
    }

    /* access modifiers changed from: protected */
    public void showInterstitial() {
        MoPubLog.log(AdapterLogEvent.SHOW_ATTEMPTED, f34796b);
        try {
            if (!C12741D.m41158a(this.f34801g)) {
                m37408a(MoPubErrorCode.NETWORK_NO_FILL);
                MoPubLog.log(AdapterLogEvent.SHOW_FAILED, f34796b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
            } else if (TextUtils.isEmpty(this.f34802h)) {
                C12741D.m41165e(this.f34801g);
            } else {
                C12741D.m41156a(this.f34801g, this.f34802h);
            }
        } catch (Exception e) {
            m37408a(MoPubErrorCode.NETWORK_NO_FILL);
            MoPubLog.log(AdapterLogEvent.SHOW_FAILED, f34796b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
            MoPubLog.log(AdapterLogEvent.CUSTOM, f34796b, e);
        }
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        f34799e = null;
    }

    /* renamed from: a */
    private void m37407a(Activity activity, String appKey) {
        C12741D.m41154a((C12872g) this);
        if (!f34797c) {
            MoPubLog.log(AdapterLogEvent.CUSTOM, f34796b, "IronSource initialization succeeded for Interstitial");
            C12741D.m41164d("mopub300");
            C12741D.m41160b(activity, appKey, C12742a.INTERSTITIAL);
            f34797c = true;
        }
    }

    /* renamed from: h */
    private void m37411h() {
        if (C12741D.m41158a(this.f34801g)) {
            onInterstitialAdReady(this.f34801g);
            return;
        }
        C12741D.m41163c(this.f34801g);
        MoPubLog.log(this.f34803i, AdapterLogEvent.LOAD_ATTEMPTED, f34796b);
    }

    /* renamed from: a */
    private void m37408a(MoPubErrorCode errorCode) {
        f34798d.post(new C11314H(this, errorCode));
    }

    /* renamed from: a */
    private MoPubErrorCode m37406a(C12799b ironSourceError) {
        if (ironSourceError == null) {
            return MoPubErrorCode.INTERNAL_ERROR;
        }
        int a = ironSourceError.mo41428a();
        if (a != 501) {
            if (a == 502) {
                return MoPubErrorCode.VIDEO_CACHE_ERROR;
            }
            if (!(a == 505 || a == 506)) {
                if (a == 520) {
                    return MoPubErrorCode.NO_CONNECTION;
                }
                switch (a) {
                    case 508:
                        break;
                    case 509:
                        return MoPubErrorCode.NETWORK_NO_FILL;
                    case 510:
                        return MoPubErrorCode.INTERNAL_ERROR;
                    default:
                        return MoPubErrorCode.UNSPECIFIED;
                }
            }
        }
        return MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
    }

    public void onInterstitialAdReady(String instanceId) {
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("IronSource Interstitial loaded successfully for instance ");
        sb.append(this.f34801g);
        MoPubLog.log(adapterLogEvent, f34796b, sb.toString());
        if (this.f34801g.equals(instanceId)) {
            f34798d.post(new C11318I(this));
        }
    }

    public void onInterstitialAdLoadFailed(String instanceId, C12799b ironSourceError) {
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("IronSource Interstitial failed to load for instance ");
        sb.append(this.f34801g);
        sb.append(" Error: ");
        sb.append(ironSourceError.mo41429b());
        MoPubLog.log(adapterLogEvent, f34796b, sb.toString());
        if (this.f34801g.equals(instanceId)) {
            m37408a(m37406a(ironSourceError));
        }
    }

    public void onInterstitialAdOpened(String instanceId) {
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("IronSource Interstitial opened ad for instance ");
        sb.append(instanceId);
        MoPubLog.log(adapterLogEvent, f34796b, sb.toString());
        f34798d.post(new C11320J(this));
    }

    public void onInterstitialAdClosed(String instanceId) {
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("IronSource Interstitial closed ad for instance ");
        sb.append(instanceId);
        MoPubLog.log(adapterLogEvent, f34796b, sb.toString());
        f34798d.post(new C11324K(this));
    }

    public void onInterstitialAdShowSucceeded(String instanceId) {
    }

    public void onInterstitialAdShowFailed(String instanceId, C12799b ironSourceError) {
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("IronSource Interstitial failed to show for instance ");
        sb.append(instanceId);
        MoPubLog.log(adapterLogEvent, f34796b, sb.toString());
        m37408a(MoPubErrorCode.INTERNAL_ERROR);
    }

    public void onInterstitialAdClicked(String instanceId) {
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("IronSource Interstitial clicked ad for instance ");
        sb.append(instanceId);
        MoPubLog.log(adapterLogEvent, f34796b, sb.toString());
        f34798d.post(new C11326L(this));
    }
}
