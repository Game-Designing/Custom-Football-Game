package p024io.fabric.sdk.android.p348a.p350b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.p348a.p352d.C13884c;
import p024io.fabric.sdk.android.p348a.p352d.C13885d;

/* renamed from: io.fabric.sdk.android.a.b.d */
/* compiled from: AdvertisingInfoProvider */
class C13842d {

    /* renamed from: a */
    private final Context f42020a;

    /* renamed from: b */
    private final C13884c f42021b;

    public C13842d(Context context) {
        this.f42020a = context.getApplicationContext();
        this.f42021b = new C13885d(context, "TwitterAdvertisingInfoPreferences");
    }

    /* renamed from: a */
    public C13840b mo43224a() {
        C13840b infoToReturn = mo43225b();
        if (m43993a(infoToReturn)) {
            C13920f.m44245e().mo43326c("Fabric", "Using AdvertisingInfo from Preference Store");
            m43994b(infoToReturn);
            return infoToReturn;
        }
        C13840b infoToReturn2 = m43996e();
        m43995c(infoToReturn2);
        return infoToReturn2;
    }

    /* renamed from: b */
    private void m43994b(C13840b advertisingInfo) {
        new Thread(new C13841c(this, advertisingInfo)).start();
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: c */
    public void m43995c(C13840b infoToReturn) {
        String str = "limit_ad_tracking_enabled";
        String str2 = "advertising_id";
        if (m43993a(infoToReturn)) {
            C13884c cVar = this.f42021b;
            cVar.mo43294a(cVar.edit().putString(str2, infoToReturn.f42016a).putBoolean(str, infoToReturn.f42017b));
            return;
        }
        C13884c cVar2 = this.f42021b;
        cVar2.mo43294a(cVar2.edit().remove(str2).remove(str));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C13840b mo43225b() {
        return new C13840b(this.f42021b.get().getString("advertising_id", ""), this.f42021b.get().getBoolean("limit_ad_tracking_enabled", false));
    }

    /* renamed from: c */
    public C13848h mo43226c() {
        return new C13843e(this.f42020a);
    }

    /* renamed from: d */
    public C13848h mo43227d() {
        return new C13845g(this.f42020a);
    }

    /* renamed from: a */
    private boolean m43993a(C13840b advertisingInfo) {
        return advertisingInfo != null && !TextUtils.isEmpty(advertisingInfo.f42016a);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public C13840b m43996e() {
        C13840b infoToReturn = mo43226c().mo43228a();
        String str = "Fabric";
        if (!m43993a(infoToReturn)) {
            infoToReturn = mo43227d().mo43228a();
            if (!m43993a(infoToReturn)) {
                C13920f.m44245e().mo43326c(str, "AdvertisingInfo not present");
            } else {
                C13920f.m44245e().mo43326c(str, "Using AdvertisingInfo from Service Provider");
            }
        } else {
            C13920f.m44245e().mo43326c(str, "Using AdvertisingInfo from Reflection Provider");
        }
        return infoToReturn;
    }
}
