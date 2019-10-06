package p019d.p273h.p276c.p282f;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.vungle.warren.p267ui.VungleActivity;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;
import p019d.p273h.p275b.C12733b;
import p019d.p273h.p276c.p278b.C12784h;
import p019d.p273h.p276c.p278b.C12787k;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12817i;
import p019d.p273h.p276c.p281e.C12820l;
import p019d.p273h.p276c.p284h.C12916j;

/* renamed from: d.h.c.f.Z */
/* compiled from: ListenersWrapper */
public class C12858Z implements C12879ja, C12884m, C12878j, C12869ea, C12887na, C12874h, C12872g {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C12879ja f39593a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C12874h f39594b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C12884m f39595c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C12872g f39596d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C12865ca f39597e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C12869ea f39598f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C12887na f39599g;

    /* renamed from: h */
    private C12859a f39600h = new C12859a(this, null);

    /* renamed from: i */
    private C12817i f39601i = null;

    /* renamed from: d.h.c.f.Z$a */
    /* compiled from: ListenersWrapper */
    private class C12859a extends Thread {

        /* renamed from: a */
        private Handler f39602a;

        private C12859a() {
        }

        /* synthetic */ C12859a(C12858Z x0, C12835B x1) {
            this();
        }

        public void run() {
            Looper.prepare();
            this.f39602a = new Handler();
            Looper.loop();
        }

        /* renamed from: a */
        public Handler mo41626a() {
            return this.f39602a;
        }
    }

    public C12858Z() {
        this.f39600h.start();
    }

    /* renamed from: a */
    public void mo41611a(C12817i placement) {
        this.f39601i = placement;
    }

    /* renamed from: a */
    private boolean m41771a(Object productListener) {
        return (productListener == null || this.f39600h == null) ? false : true;
    }

    /* renamed from: a */
    private void m41770a(Runnable callbackRunnable) {
        C12859a aVar = this.f39600h;
        if (aVar != null) {
            Handler callbackHandler = aVar.mo41626a();
            if (callbackHandler != null) {
                callbackHandler.post(callbackRunnable);
            }
        }
    }

    /* renamed from: a */
    public void mo41614a(C12874h demandOnlyRewardedVideoListener) {
        this.f39594b = demandOnlyRewardedVideoListener;
    }

    /* renamed from: a */
    public void mo41613a(C12872g demandOnlyInterstitialListener) {
        this.f39596d = demandOnlyInterstitialListener;
    }

    /* renamed from: a */
    public void mo41615a(String segment) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onSegmentReceived(");
        sb.append(segment);
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        if (m41771a((Object) this.f39599g)) {
            m41770a((Runnable) new C12835B(this, segment));
        }
    }

    public void onRewardedVideoAdOpened() {
        C12802d.m41613c().mo41427b(C12801a.CALLBACK, "onRewardedVideoAdOpened()", 1);
        if (m41771a((Object) this.f39593a)) {
            m41770a((Runnable) new C12846M(this));
        }
    }

    public void onRewardedVideoAdClosed() {
        C12802d.m41613c().mo41427b(C12801a.CALLBACK, "onRewardedVideoAdClosed()", 1);
        if (m41771a((Object) this.f39593a)) {
            m41770a((Runnable) new C12853U(this));
        }
    }

    /* renamed from: a */
    public void mo41616a(boolean available) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onRewardedVideoAvailabilityChanged(available:");
        sb.append(available);
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        JSONObject data = C12916j.m41965a(false);
        try {
            data.put("status", String.valueOf(available));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C12787k.m41517g().mo41369d(new C12733b(7, data));
        if (m41771a((Object) this.f39593a)) {
            m41770a((Runnable) new C12854V(this, available));
        }
    }

    /* renamed from: a */
    public void mo41612a(C12820l placement) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onRewardedVideoAdRewarded(");
        sb.append(placement.toString());
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        if (m41771a((Object) this.f39593a)) {
            m41770a((Runnable) new C12855W(this, placement));
        }
    }

    /* renamed from: b */
    public void mo41619b(C12820l placement) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onRewardedVideoAdClicked(");
        sb.append(placement.mo41504c());
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        if (m41771a((Object) this.f39593a)) {
            m41770a((Runnable) new C12856X(this, placement));
        }
    }

    /* renamed from: c */
    public void mo41621c(C12799b error) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onRewardedVideoAdShowFailed(");
        sb.append(error.toString());
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        JSONObject data = C12916j.m41965a(false);
        try {
            data.put("status", AdultContentAnalytics.UNLOCK);
            if (error.mo41428a() == 524) {
                data.put("reason", 1);
            }
            data.put("errorCode", error.mo41428a());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C12787k.m41517g().mo41369d(new C12733b(17, data));
        if (m41771a((Object) this.f39593a)) {
            m41770a((Runnable) new C12857Y(this, error));
        }
    }

    /* renamed from: a */
    public void mo41609a() {
        C12802d.m41613c().mo41427b(C12801a.CALLBACK, "onInterstitialAdReady()", 1);
        if (m41771a((Object) this.f39595c)) {
            m41770a((Runnable) new C12891r(this));
        }
    }

    /* renamed from: a */
    public void mo41610a(C12799b error) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onInterstitialAdLoadFailed(");
        sb.append(error);
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        if (m41771a((Object) this.f39595c)) {
            m41770a((Runnable) new C12892s(this, error));
        }
    }

    /* renamed from: d */
    public void mo41622d() {
        C12802d.m41613c().mo41427b(C12801a.CALLBACK, "onInterstitialAdOpened()", 1);
        if (m41771a((Object) this.f39595c)) {
            m41770a((Runnable) new C12893t(this));
        }
    }

    /* renamed from: e */
    public void mo41623e() {
        C12802d.m41613c().mo41427b(C12801a.CALLBACK, "onInterstitialAdShowSucceeded()", 1);
        if (m41771a((Object) this.f39595c)) {
            m41770a((Runnable) new C12894u(this));
        }
    }

    /* renamed from: b */
    public void mo41618b(C12799b error) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onInterstitialAdShowFailed(");
        sb.append(error);
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        JSONObject data = C12916j.m41965a(false);
        try {
            data.put("errorCode", error.mo41428a());
            if (this.f39601i != null && !TextUtils.isEmpty(this.f39601i.mo41496c())) {
                data.put(VungleActivity.PLACEMENT_EXTRA, this.f39601i.mo41496c());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C12784h.m41502g().mo41369d(new C12733b(2111, data));
        if (m41771a((Object) this.f39595c)) {
            m41770a((Runnable) new C12895v(this, error));
        }
    }

    /* renamed from: c */
    public void mo41620c() {
        C12802d.m41613c().mo41427b(C12801a.CALLBACK, "onInterstitialAdClicked()", 1);
        if (m41771a((Object) this.f39595c)) {
            m41770a((Runnable) new C12896w(this));
        }
    }

    /* renamed from: b */
    public void mo41617b() {
        C12802d.m41613c().mo41427b(C12801a.CALLBACK, "onInterstitialAdClosed()", 1);
        if (m41771a((Object) this.f39595c)) {
            m41770a((Runnable) new C12897x(this));
        }
    }

    /* renamed from: j */
    public void mo41183j() {
        C12802d.m41613c().mo41427b(C12801a.CALLBACK, "onInterstitialAdRewarded()", 1);
        if (m41771a((Object) this.f39598f)) {
            m41770a((Runnable) new C12898y(this));
        }
    }

    /* renamed from: f */
    public void mo41259f() {
        C12802d.m41613c().mo41427b(C12801a.CALLBACK, "onOfferwallOpened()", 1);
        if (m41771a((Object) this.f39597e)) {
            m41770a((Runnable) new C12899z(this));
        }
    }

    /* renamed from: e */
    public void mo41258e(C12799b error) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onOfferwallShowFailed(");
        sb.append(error);
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        if (m41771a((Object) this.f39597e)) {
            m41770a((Runnable) new C12834A(this, error));
        }
    }

    /* renamed from: a */
    public boolean mo41255a(int credits, int totalCredits, boolean totalCreditsFlag) {
        boolean result = false;
        C12865ca caVar = this.f39597e;
        if (caVar != null) {
            result = caVar.mo41255a(credits, totalCredits, totalCreditsFlag);
        }
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onOfferwallAdCredited(credits:");
        sb.append(credits);
        String str = ", ";
        sb.append(str);
        sb.append("totalCredits:");
        sb.append(totalCredits);
        sb.append(str);
        sb.append("totalCreditsFlag:");
        sb.append(totalCreditsFlag);
        sb.append("):");
        sb.append(result);
        c.mo41427b(aVar, sb.toString(), 1);
        return result;
    }

    /* renamed from: d */
    public void mo41257d(C12799b error) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onGetOfferwallCreditsFailed(");
        sb.append(error);
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        if (m41771a((Object) this.f39597e)) {
            m41770a((Runnable) new C12836C(this, error));
        }
    }

    /* renamed from: g */
    public void mo41260g() {
        C12802d.m41613c().mo41427b(C12801a.CALLBACK, "onOfferwallClosed()", 1);
        if (m41771a((Object) this.f39597e)) {
            m41770a((Runnable) new C12837D(this));
        }
    }

    /* renamed from: b */
    public void mo41256b(boolean isAvailable) {
        mo41254a(isAvailable, null);
    }

    /* renamed from: a */
    public void mo41254a(boolean isAvailable, C12799b error) {
        StringBuilder sb = new StringBuilder();
        sb.append("onOfferwallAvailable(isAvailable: ");
        sb.append(isAvailable);
        sb.append(")");
        String logString = sb.toString();
        if (error != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(logString);
            sb2.append(", error: ");
            sb2.append(error.mo41429b());
            logString = sb2.toString();
        }
        C12802d.m41613c().mo41427b(C12801a.CALLBACK, logString, 1);
        JSONObject data = C12916j.m41965a(false);
        try {
            data.put("status", String.valueOf(isAvailable));
            if (error != null) {
                data.put("errorCode", error.mo41428a());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C12787k.m41517g().mo41369d(new C12733b(302, data));
        if (m41771a((Object) this.f39597e)) {
            m41770a((Runnable) new C12838E(this, isAvailable));
        }
    }

    public void onRewardedVideoAdOpened(String instanceId) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onRewardedVideoAdOpened(");
        sb.append(instanceId);
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        if (m41771a((Object) this.f39594b)) {
            m41770a((Runnable) new C12839F(this, instanceId));
        }
    }

    public void onRewardedVideoAdClosed(String instanceId) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onRewardedVideoAdClosed(");
        sb.append(instanceId);
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        if (m41771a((Object) this.f39594b)) {
            m41770a((Runnable) new C12840G(this, instanceId));
        }
    }

    public void onRewardedVideoAvailabilityChanged(String instanceId, boolean available) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onRewardedVideoAvailabilityChanged(");
        sb.append(instanceId);
        sb.append(", ");
        sb.append(available);
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        if (m41771a((Object) this.f39594b)) {
            m41770a((Runnable) new C12841H(this, instanceId, available));
        }
    }

    public void onRewardedVideoAdRewarded(String instanceId, C12820l placement) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onRewardedVideoAdRewarded(");
        sb.append(instanceId);
        sb.append(", ");
        sb.append(placement.toString());
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        if (m41771a((Object) this.f39594b)) {
            m41770a((Runnable) new C12842I(this, instanceId, placement));
        }
    }

    public void onRewardedVideoAdShowFailed(String instanceId, C12799b error) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onRewardedVideoAdShowFailed(");
        sb.append(instanceId);
        sb.append(", ");
        sb.append(error.toString());
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        JSONObject data = C12916j.m41965a(true);
        try {
            data.put("status", AdultContentAnalytics.UNLOCK);
            if (error.mo41428a() == 524) {
                data.put("reason", 1);
            }
            data.put("errorCode", error.mo41428a());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C12787k.m41517g().mo41369d(new C12733b(17, data));
        if (m41771a((Object) this.f39594b)) {
            m41770a((Runnable) new C12843J(this, instanceId, error));
        }
    }

    public void onRewardedVideoAdClicked(String instanceId, C12820l placement) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onRewardedVideoAdClicked(");
        sb.append(instanceId);
        sb.append(", ");
        sb.append(placement.mo41504c());
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        if (m41771a((Object) this.f39594b)) {
            m41770a((Runnable) new C12844K(this, instanceId, placement));
        }
    }

    public void onInterstitialAdReady(String instanceId) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onInterstitialAdReady(");
        sb.append(instanceId);
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        if (m41771a((Object) this.f39596d)) {
            m41770a((Runnable) new C12845L(this, instanceId));
        }
    }

    public void onInterstitialAdLoadFailed(String instanceId, C12799b error) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onInterstitialAdLoadFailed(");
        sb.append(instanceId);
        sb.append(", ");
        sb.append(error);
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        if (m41771a((Object) this.f39596d)) {
            m41770a((Runnable) new C12847N(this, instanceId, error));
        }
    }

    public void onInterstitialAdOpened(String instanceId) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onInterstitialAdOpened(");
        sb.append(instanceId);
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        if (m41771a((Object) this.f39596d)) {
            m41770a((Runnable) new C12848O(this, instanceId));
        }
    }

    public void onInterstitialAdClosed(String instanceId) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onInterstitialAdClosed(");
        sb.append(instanceId);
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        if (m41771a((Object) this.f39596d)) {
            m41770a((Runnable) new C12849P(this, instanceId));
        }
    }

    public void onInterstitialAdShowSucceeded(String instanceId) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onInterstitialAdShowSucceeded(");
        sb.append(instanceId);
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        if (m41771a((Object) this.f39596d)) {
            m41770a((Runnable) new C12850Q(this, instanceId));
        }
    }

    public void onInterstitialAdShowFailed(String instanceId, C12799b error) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onInterstitialAdShowFailed(");
        sb.append(instanceId);
        sb.append(", ");
        sb.append(error);
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        JSONObject data = C12916j.m41965a(true);
        try {
            data.put("errorCode", error.mo41428a());
            if (this.f39601i != null && !TextUtils.isEmpty(this.f39601i.mo41496c())) {
                data.put(VungleActivity.PLACEMENT_EXTRA, this.f39601i.mo41496c());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C12784h.m41502g().mo41369d(new C12733b(2111, data));
        if (m41771a((Object) this.f39596d)) {
            m41770a((Runnable) new C12851S(this, instanceId, error));
        }
    }

    public void onInterstitialAdClicked(String instanceId) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onInterstitialAdClicked(");
        sb.append(instanceId);
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 1);
        if (m41771a((Object) this.f39596d)) {
            m41770a((Runnable) new C12852T(this, instanceId));
        }
    }
}
