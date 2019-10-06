package p024io.fabric.sdk.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import p005cm.aptoide.p006pt.BuildConfig;
import p024io.fabric.sdk.android.p348a.p350b.C13849i;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;
import p024io.fabric.sdk.android.p348a.p350b.C13858o;
import p024io.fabric.sdk.android.p348a.p350b.C13859p;
import p024io.fabric.sdk.android.p348a.p353e.C13886A;
import p024io.fabric.sdk.android.p348a.p353e.C13890d;
import p024io.fabric.sdk.android.p348a.p353e.C13891e;
import p024io.fabric.sdk.android.p348a.p353e.C13895i;
import p024io.fabric.sdk.android.p348a.p353e.C13901o;
import p024io.fabric.sdk.android.p348a.p353e.C13905s;
import p024io.fabric.sdk.android.p348a.p353e.C13909v;
import p024io.fabric.sdk.android.services.network.C13967c;
import p024io.fabric.sdk.android.services.network.C13971g;

/* renamed from: io.fabric.sdk.android.p */
/* compiled from: Onboarding */
class C13930p extends C0102l<Boolean> {

    /* renamed from: g */
    private final C13971g f42251g = new C13967c();

    /* renamed from: h */
    private PackageManager f42252h;

    /* renamed from: i */
    private String f42253i;

    /* renamed from: j */
    private PackageInfo f42254j;

    /* renamed from: k */
    private String f42255k;

    /* renamed from: l */
    private String f42256l;

    /* renamed from: m */
    private String f42257m;

    /* renamed from: n */
    private String f42258n;

    /* renamed from: o */
    private String f42259o;

    /* renamed from: p */
    private final Future<Map<String, C13928n>> f42260p;

    /* renamed from: q */
    private final Collection<C0102l> f42261q;

    public C13930p(Future<Map<String, C13928n>> kitsFinder, Collection<C0102l> providedKits) {
        this.f42260p = kitsFinder;
        this.f42261q = providedKits;
    }

    /* renamed from: w */
    public String mo2536w() {
        return "1.4.8.32";
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public boolean mo3314z() {
        try {
            this.f42257m = mo3310t().mo43264f();
            this.f42252h = mo3307i().getPackageManager();
            this.f42253i = mo3307i().getPackageName();
            this.f42254j = this.f42252h.getPackageInfo(this.f42253i, 0);
            this.f42255k = Integer.toString(this.f42254j.versionCode);
            this.f42256l = this.f42254j.versionName == null ? "0.0" : this.f42254j.versionName;
            this.f42258n = this.f42252h.getApplicationLabel(mo3307i().getApplicationInfo()).toString();
            this.f42259o = Integer.toString(mo3307i().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (NameNotFoundException e) {
            C13920f.m44245e().mo43325b("Fabric", "Failed init", e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public Boolean m44297g() {
        Map<String, KitInfo> scannedKits;
        String iconHash = C13852l.m44047c(mo3307i());
        boolean appConfigured = false;
        C13909v settingsData = m44288B();
        if (settingsData != null) {
            try {
                if (this.f42260p != null) {
                    scannedKits = (Map) this.f42260p.get();
                } else {
                    scannedKits = new HashMap<>();
                }
                mo43365a(scannedKits, this.f42261q);
                appConfigured = m44291a(iconHash, settingsData.f42191a, scannedKits.values());
            } catch (Exception e) {
                C13920f.m44245e().mo43325b("Fabric", "Error performing auto configuration.", e);
            }
        }
        return Boolean.valueOf(appConfigured);
    }

    /* renamed from: B */
    private C13909v m44288B() {
        try {
            C13905s b = C13905s.m44193b();
            b.mo43312a(this, this.f147e, this.f42251g, this.f42255k, this.f42256l, mo43364A(), C13858o.m44068a(mo3307i()));
            b.mo43314c();
            return C13905s.m44193b().mo43313a();
        } catch (Exception e) {
            C13920f.m44245e().mo43325b("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Map<String, C13928n> mo43365a(Map<String, C13928n> scannedKits, Collection<C0102l> providedKits) {
        for (C0102l kit : providedKits) {
            if (!scannedKits.containsKey(kit.mo2535u())) {
                scannedKits.put(kit.mo2535u(), new C13928n(kit.mo2535u(), kit.mo2536w(), "binary"));
            }
        }
        return scannedKits;
    }

    /* renamed from: u */
    public String mo2535u() {
        return "io.fabric.sdk.android:fabric";
    }

    /* renamed from: a */
    private boolean m44291a(String iconHash, C13891e appSettings, Collection<C13928n> sdkKits) {
        String str = "Fabric";
        if (!"new".equals(appSettings.f42142b)) {
            if ("configured".equals(appSettings.f42142b)) {
                return C13905s.m44193b().mo43315d();
            }
            if (!appSettings.f42146f) {
                return true;
            }
            C13920f.m44245e().mo43326c(str, "Server says an update is required - forcing a full App update.");
            m44293c(iconHash, appSettings, sdkKits);
            return true;
        } else if (m44292b(iconHash, appSettings, sdkKits)) {
            return C13905s.m44193b().mo43315d();
        } else {
            C13920f.m44245e().mo43325b(str, "Failed to create app with Crashlytics service.", null);
            return false;
        }
    }

    /* renamed from: b */
    private boolean m44292b(String iconHash, C13891e appSettings, Collection<C13928n> sdkKits) {
        return new C13895i(this, mo43364A(), appSettings.f42143c, this.f42251g).mo43297a(m44289a(C13901o.m44191a(mo3307i(), iconHash), sdkKits));
    }

    /* renamed from: c */
    private boolean m44293c(String iconHash, C13891e appSettings, Collection<C13928n> sdkKits) {
        return m44290a(appSettings, C13901o.m44191a(mo3307i(), iconHash), sdkKits);
    }

    /* renamed from: a */
    private boolean m44290a(C13891e appSettings, C13901o iconRequest, Collection<C13928n> sdkKits) {
        return new C13886A(this, mo43364A(), appSettings.f42143c, this.f42251g).mo43297a(m44289a(iconRequest, sdkKits));
    }

    /* renamed from: a */
    private C13890d m44289a(C13901o iconRequest, Collection<C13928n> sdkKits) {
        Context context = mo3307i();
        String apiKey = new C13849i().mo43240d(context);
        String instanceId = C13852l.m44032a(C13852l.m44062n(context));
        int source = C13859p.m44071a(this.f42257m).getId();
        C13890d dVar = new C13890d(apiKey, mo3310t().mo43261c(), this.f42256l, this.f42255k, instanceId, this.f42258n, source, this.f42259o, BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID, iconRequest, sdkKits);
        return dVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: A */
    public String mo43364A() {
        return C13852l.m44043b(mo3307i(), "com.crashlytics.ApiEndpoint");
    }
}
