package p019d.p273h.p285d.p287b;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import com.ironsource.sdk.controller.C10839b;
import com.ironsource.sdk.controller.C10841c;
import com.ironsource.sdk.controller.C10859k;
import com.ironsource.sdk.controller.C10877y;
import com.ironsource.sdk.data.C10888a;
import com.ironsource.sdk.data.C10890c;
import com.ironsource.sdk.data.C10895h;
import com.ironsource.sdk.data.C10898k;
import com.ironsource.sdk.data.C10898k.C10899a;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p273h.p285d.C12953a;
import p019d.p273h.p285d.C12968b;
import p019d.p273h.p285d.C12978e;
import p019d.p273h.p285d.p286a.C12957d;
import p019d.p273h.p285d.p292f.C12986b;
import p019d.p273h.p285d.p292f.C12988d;
import p019d.p273h.p285d.p292f.C12989e;
import p019d.p273h.p285d.p292f.C12990f;
import p019d.p273h.p285d.p292f.p293a.C12982a;
import p019d.p273h.p285d.p292f.p293a.C12983b;
import p019d.p273h.p285d.p292f.p293a.C12984c;
import p019d.p273h.p285d.p292f.p293a.C12985d;
import p019d.p273h.p285d.p295h.C12999b;
import p019d.p273h.p285d.p295h.C13001d;
import p019d.p273h.p285d.p295h.C13003f;
import p019d.p273h.p285d.p295h.C13004g;

/* renamed from: d.h.d.b.c */
/* compiled from: IronSourceAdsPublisherAgent */
public final class C12971c implements C12978e, C12985d, C12984c, C12982a, C12983b, C12968b {

    /* renamed from: a */
    private static C12971c f39918a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static MutableContextWrapper f39919b;

    /* renamed from: c */
    private final String f39920c = "SupersonicAds";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C10841c f39921d;

    /* renamed from: e */
    private String f39922e;

    /* renamed from: f */
    private String f39923f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C10877y f39924g;

    /* renamed from: h */
    private C10898k f39925h;

    /* renamed from: i */
    private long f39926i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C10859k f39927j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C10839b f39928k;

    private C12971c(Activity activity, int debugMode) {
        m42281c(activity);
    }

    /* renamed from: c */
    private void m42281c(Activity activity) {
        this.f39921d = new C10841c();
        C13001d.m42394a((Context) activity);
        this.f39927j = new C10859k();
        C13003f.m42435a(C13004g.m42464g());
        C13003f.m42438c("IronSourceAdsPublisherAgent", "C'tor");
        f39919b = new MutableContextWrapper(activity);
        this.f39926i = 0;
        m42276b(activity);
        m42277b((Context) activity);
    }

    /* renamed from: b */
    private void m42276b(Activity activity) {
        activity.runOnUiThread(new C12969a(this, activity));
    }

    /* renamed from: a */
    public static synchronized C12971c m42271a(Activity activity) throws Exception {
        C12971c a;
        synchronized (C12971c.class) {
            a = m42272a(activity, 0);
        }
        return a;
    }

    /* renamed from: a */
    public static synchronized C12971c m42272a(Activity activity, int debugMode) throws Exception {
        C12971c cVar;
        synchronized (C12971c.class) {
            C13003f.m42438c("IronSourceAdsPublisherAgent", "getInstance()");
            if (f39918a == null) {
                f39918a = new C12971c(activity, debugMode);
            } else {
                f39919b.setBaseContext(activity);
            }
            cVar = f39918a;
        }
        return cVar;
    }

    /* renamed from: b */
    public C10877y mo41839b() {
        return this.f39924g;
    }

    /* renamed from: c */
    private C12990f m42279c(C10890c demandSource) {
        if (demandSource == null) {
            return null;
        }
        return (C12990f) demandSource.mo35656f();
    }

    /* renamed from: b */
    private C12988d m42275b(C10890c demandSource) {
        if (demandSource == null) {
            return null;
        }
        return (C12988d) demandSource.mo35656f();
    }

    /* renamed from: a */
    private C12986b m42273a(C10890c demandSource) {
        if (demandSource == null) {
            return null;
        }
        return (C12986b) demandSource.mo35656f();
    }

    /* renamed from: b */
    private void m42277b(Context context) {
        this.f39925h = new C10898k(context, C10899a.launched);
    }

    /* renamed from: a */
    public void mo41823a(Context context) {
        this.f39925h = new C10898k(context, C10899a.backFromBG);
    }

    /* renamed from: c */
    private void m42280c() {
        C10898k kVar = this.f39925h;
        if (kVar != null) {
            kVar.mo35676a();
            C13001d.m42395g().mo41894a(this.f39925h);
            this.f39925h = null;
        }
    }

    /* renamed from: a */
    public void mo41835a(String applicationKey, String userId, String demandSourceName, Map<String, String> extraParameters, C12990f listener) {
        this.f39922e = applicationKey;
        this.f39923f = userId;
        this.f39924g.mo35466a(applicationKey, userId, this.f39927j.mo35438a(C10895h.RewardedVideo, demandSourceName, extraParameters, listener), (C12985d) this);
    }

    /* renamed from: e */
    public void mo41851e(JSONObject showParams) {
        this.f39924g.mo35481c(showParams);
    }

    /* renamed from: a */
    public void mo41836a(String applicationKey, String userId, Map<String, String> extraParameters, C12989e listener) {
        this.f39922e = applicationKey;
        this.f39923f = userId;
        this.f39924g.mo35469a(applicationKey, userId, extraParameters, listener);
    }

    /* renamed from: a */
    public void mo41837a(Map<String, String> extraParameters) {
        this.f39924g.mo35470a(extraParameters);
    }

    /* renamed from: a */
    public void mo41832a(String applicationKey, String userId, C12989e listener) {
        this.f39922e = applicationKey;
        this.f39923f = userId;
        this.f39924g.mo35467a(applicationKey, userId, listener);
    }

    /* renamed from: a */
    public void mo41834a(String applicationKey, String userId, String demandSourceName, Map<String, String> extraParameters, C12988d listener) {
        this.f39922e = applicationKey;
        this.f39923f = userId;
        this.f39924g.mo35465a(applicationKey, userId, this.f39927j.mo35438a(C10895h.Interstitial, demandSourceName, extraParameters, listener), (C12984c) this);
    }

    /* renamed from: d */
    public void mo41850d(JSONObject loadParams) {
        if (loadParams != null) {
            String demandSourceName = loadParams.optString("demandSourceName");
            if (!TextUtils.isEmpty(demandSourceName)) {
                this.f39924g.mo35489e(demandSourceName);
            }
        }
    }

    /* renamed from: e */
    public boolean mo41852e(String demandSourceName) {
        return this.f39924g.mo35486d(demandSourceName);
    }

    /* renamed from: a */
    public void mo41838a(JSONObject showParams) {
        this.f39924g.mo35477b(showParams);
    }

    /* renamed from: a */
    public void mo41833a(String applicationKey, String userId, String demandSourceName, Map<String, String> extraParameters, C12986b listener) {
        this.f39922e = applicationKey;
        this.f39923f = userId;
        this.f39924g.mo35464a(applicationKey, userId, this.f39927j.mo35438a(C10895h.Banner, demandSourceName, extraParameters, listener), (C12983b) this);
    }

    /* renamed from: b */
    public void mo41843b(JSONObject loadParams) {
        if (loadParams != null) {
            this.f39924g.mo35471a(loadParams);
        }
    }

    public void onResume(Activity activity) {
        f39919b.setBaseContext(activity);
        this.f39924g.mo35490f();
        this.f39924g.mo35479c((Context) activity);
        if (this.f39925h == null) {
            mo41823a((Context) activity);
        }
    }

    public void onPause(Activity activity) {
        try {
            this.f39924g.mo35488e();
            this.f39924g.mo35484d((Context) activity);
            m42280c();
        } catch (Exception e) {
            e.printStackTrace();
            C12999b bVar = new C12999b();
            StringBuilder sb = new StringBuilder();
            sb.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
            sb.append(e.getStackTrace()[0].getMethodName());
            bVar.execute(new String[]{sb.toString()});
        }
    }

    /* renamed from: a */
    public void mo41825a(C10895h type, String demandSourceName, C10888a adUnitsReady) {
        C10890c demandSource = m42283d(type, demandSourceName);
        if (demandSource != null) {
            demandSource.mo35651b(2);
            if (type == C10895h.RewardedVideo) {
                C12990f listener = m42279c(demandSource);
                if (listener != null) {
                    listener.onRVInitSuccess(adUnitsReady);
                }
            } else if (type == C10895h.Interstitial) {
                C12988d listener2 = m42275b(demandSource);
                if (listener2 != null) {
                    listener2.onInterstitialInitSuccess();
                }
            } else if (type == C10895h.Banner) {
                C12986b listener3 = m42273a(demandSource);
                if (listener3 != null) {
                    listener3.onBannerInitSuccess();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo41826a(C10895h type, String demandSourceName, String description) {
        C10890c demandSource = m42283d(type, demandSourceName);
        if (demandSource != null) {
            demandSource.mo35651b(3);
            if (type == C10895h.RewardedVideo) {
                C12990f listener = m42279c(demandSource);
                if (listener != null) {
                    listener.onRVInitFail(description);
                }
            } else if (type == C10895h.Interstitial) {
                C12988d listener2 = m42275b(demandSource);
                if (listener2 != null) {
                    listener2.onInterstitialInitFailed(description);
                }
            } else if (type == C10895h.Banner) {
                C12986b listener3 = m42273a(demandSource);
                if (listener3 != null) {
                    listener3.onBannerInitFailed(description);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo41841b(String demandSourceName) {
        C10890c demandSource = m42283d(C10895h.RewardedVideo, demandSourceName);
        if (demandSource != null) {
            C12990f listener = m42279c(demandSource);
            if (listener != null) {
                listener.onRVNoMoreOffers();
            }
        }
    }

    /* renamed from: a */
    public void mo41829a(String demandSourceName, int credits) {
        C10890c demandSource = m42283d(C10895h.RewardedVideo, demandSourceName);
        if (demandSource != null) {
            C12990f listener = m42279c(demandSource);
            if (listener != null) {
                listener.onRVAdCredited(credits);
            }
        }
    }

    /* renamed from: b */
    public void mo41840b(C10895h type, String demandSourceName) {
        C10890c demandSource = m42283d(type, demandSourceName);
        if (demandSource == null) {
            return;
        }
        if (type == C10895h.RewardedVideo) {
            C12990f listener = m42279c(demandSource);
            if (listener != null) {
                listener.onRVAdClosed();
            }
        } else if (type == C10895h.Interstitial) {
            C12988d listener2 = m42275b(demandSource);
            if (listener2 != null) {
                listener2.onInterstitialClose();
            }
        }
    }

    /* renamed from: d */
    public void mo41849d(String demandSourceName, String description) {
        C10890c demandSource = m42283d(C10895h.RewardedVideo, demandSourceName);
        if (demandSource != null) {
            C12990f listener = m42279c(demandSource);
            if (listener != null) {
                listener.onRVShowFail(description);
            }
        }
    }

    /* renamed from: c */
    public void mo41844c(C10895h type, String demandSourceName) {
        C10890c demandSource = m42283d(type, demandSourceName);
        if (demandSource == null) {
            return;
        }
        if (type == C10895h.RewardedVideo) {
            C12990f listener = m42279c(demandSource);
            if (listener != null) {
                listener.onRVAdClicked();
            }
        } else if (type == C10895h.Interstitial) {
            C12988d listener2 = m42275b(demandSource);
            if (listener2 != null) {
                listener2.onInterstitialClick();
            }
        } else if (type == C10895h.Banner) {
            C12986b listener3 = m42273a(demandSource);
            if (listener3 != null) {
                listener3.onBannerClick();
            }
        }
    }

    /* renamed from: a */
    public void mo41827a(C10895h type, String demandSourceName, String eventName, JSONObject extData) {
        C10890c demandSource = m42283d(type, demandSourceName);
        if (demandSource != null) {
            try {
                String str = "demandSourceName";
                if (type == C10895h.Interstitial) {
                    C12988d listener = m42275b(demandSource);
                    if (listener != null) {
                        extData.put(str, demandSourceName);
                        listener.onInterstitialEventNotificationReceived(eventName, extData);
                    }
                } else if (type == C10895h.RewardedVideo) {
                    C12990f listener2 = m42279c(demandSource);
                    if (listener2 != null) {
                        extData.put(str, demandSourceName);
                        listener2.onRVEventNotificationReceived(eventName, extData);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo41824a(C10895h type, String demandSourceName) {
        C10890c demandSource = m42283d(type, demandSourceName);
        if (demandSource == null) {
            return;
        }
        if (type == C10895h.Interstitial) {
            C12988d listener = m42275b(demandSource);
            if (listener != null) {
                listener.onInterstitialOpen();
            }
        } else if (type == C10895h.RewardedVideo) {
            C12990f listener2 = m42279c(demandSource);
            if (listener2 != null) {
                listener2.onRVAdOpened();
            }
        }
    }

    /* renamed from: c */
    public void mo41845c(String demandSourceName) {
        C10890c demandSource = m42283d(C10895h.Interstitial, demandSourceName);
        if (demandSource != null) {
            C12988d listener = m42275b(demandSource);
            if (listener != null) {
                listener.onInterstitialLoadSuccess();
            }
        }
    }

    /* renamed from: b */
    public void mo41842b(String demandSourceName, String description) {
        C10890c demandSource = m42283d(C10895h.Interstitial, demandSourceName);
        if (demandSource != null) {
            C12988d listener = m42275b(demandSource);
            if (listener != null) {
                listener.onInterstitialLoadFailed(description);
            }
        }
    }

    /* renamed from: d */
    public void mo41848d(String demandSourceName) {
        C10890c demandSource = m42283d(C10895h.Interstitial, demandSourceName);
        if (demandSource != null) {
            C12988d listener = m42275b(demandSource);
            if (listener != null) {
                listener.onInterstitialShowSuccess();
            }
        }
    }

    /* renamed from: a */
    public void mo41830a(String demandSourceName, String description) {
        C10890c demandSource = m42283d(C10895h.Interstitial, demandSourceName);
        if (demandSource != null) {
            C12988d listener = m42275b(demandSource);
            if (listener != null) {
                listener.onInterstitialShowFailed(description);
            }
        }
    }

    public void onInterstitialAdRewarded(String demandSourceId, int amount) {
        C10890c demandSource = m42283d(C10895h.Interstitial, demandSourceId);
        C12988d listener = m42275b(demandSource);
        if (demandSource != null && listener != null) {
            listener.onInterstitialAdRewarded(demandSourceId, amount);
        }
    }

    /* renamed from: d */
    private C10890c m42283d(C10895h type, String demandSourceName) {
        if (TextUtils.isEmpty(demandSourceName)) {
            return null;
        }
        return this.f39927j.mo35437a(type, demandSourceName);
    }

    /* renamed from: a */
    public void mo41831a(String productType, String demandSourceName, int state) {
        if (!TextUtils.isEmpty(productType) && !TextUtils.isEmpty(demandSourceName)) {
            C10895h product = C13004g.m42458d(productType);
            if (product != null) {
                C10890c demandSource = this.f39927j.mo35437a(product, demandSourceName);
                if (demandSource != null) {
                    demandSource.mo35653c(state);
                }
            }
        }
    }

    /* renamed from: c */
    public void mo41847c(JSONObject consentParams) {
        this.f39921d.mo35416a(new C12970b(this, consentParams));
    }

    /* renamed from: a */
    public C12957d mo41822a(Activity activity, C12953a bannerSize) {
        StringBuilder sb = new StringBuilder();
        sb.append("SupersonicAds_");
        sb.append(this.f39926i);
        String containerIdentifier = sb.toString();
        this.f39926i++;
        C12957d isnAdView = new C12957d(activity, containerIdentifier, bannerSize);
        this.f39928k.mo35410a(isnAdView);
        return isnAdView;
    }

    /* renamed from: a */
    public void mo41828a(String demandSourceName) {
        C10890c demandSource = m42283d(C10895h.Banner, demandSourceName);
        if (demandSource != null) {
            C12986b listener = m42273a(demandSource);
            if (listener != null) {
                listener.onBannerLoadSuccess();
            }
        }
    }

    /* renamed from: c */
    public void mo41846c(String demandSourceName, String description) {
        C10890c demandSource = m42283d(C10895h.Banner, demandSourceName);
        if (demandSource != null) {
            C12986b listener = m42273a(demandSource);
            if (listener != null) {
                listener.onBannerLoadFail(description);
            }
        }
    }
}
