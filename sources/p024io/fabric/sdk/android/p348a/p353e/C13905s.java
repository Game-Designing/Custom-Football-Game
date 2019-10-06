package p024io.fabric.sdk.android.p348a.p353e;

import android.content.Context;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.p348a.p350b.C13837E;
import p024io.fabric.sdk.android.p348a.p350b.C13849i;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;
import p024io.fabric.sdk.android.p348a.p350b.C13857n;
import p024io.fabric.sdk.android.p348a.p350b.C13858o;
import p024io.fabric.sdk.android.p348a.p350b.C13859p;
import p024io.fabric.sdk.android.p348a.p350b.C13868y;
import p024io.fabric.sdk.android.services.network.C13971g;

/* renamed from: io.fabric.sdk.android.a.e.s */
/* compiled from: Settings */
public class C13905s {

    /* renamed from: a */
    private final AtomicReference<C13909v> f42182a;

    /* renamed from: b */
    private final CountDownLatch f42183b;

    /* renamed from: c */
    private C13908u f42184c;

    /* renamed from: d */
    private boolean f42185d;

    /* renamed from: io.fabric.sdk.android.a.e.s$a */
    /* compiled from: Settings */
    static class C13906a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C13905s f42186a = new C13905s();
    }

    /* renamed from: b */
    public static C13905s m44193b() {
        return C13906a.f42186a;
    }

    private C13905s() {
        this.f42182a = new AtomicReference<>();
        this.f42183b = new CountDownLatch(1);
        this.f42185d = false;
    }

    /* renamed from: a */
    public synchronized C13905s mo43312a(C0102l kit, C13868y idManager, C13971g httpRequestFactory, String versionCode, String versionName, String urlEndpoint, C13858o dataCollectionArbiter) {
        C0102l lVar = kit;
        synchronized (this) {
            if (this.f42185d) {
                return this;
            }
            if (this.f42184c == null) {
                Context context = kit.mo3307i();
                String appIdentifier = idManager.mo43261c();
                String apiKey = new C13849i().mo43240d(context);
                String installerPackageName = idManager.mo43264f();
                C13857n currentTimeProvider = new C13837E();
                C13911x settingsJsonTransform = new C13898l();
                C13894h cachedSettingsIo = new C13896j(lVar);
                String iconHash = C13852l.m44047c(context);
                String settingsUrl = String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[]{appIdentifier});
                C13913z settingsSpiCall = new C13899m(lVar, urlEndpoint, settingsUrl, httpRequestFactory);
                String str = versionName;
                String str2 = versionCode;
                C13912y yVar = new C13912y(apiKey, idManager.mo43265g(), idManager.mo43266h(), idManager.mo43267i(), idManager.mo43262d(), C13852l.m44032a(C13852l.m44062n(context)), str, str2, C13859p.m44071a(installerPackageName).getId(), iconHash);
                String str3 = settingsUrl;
                C13897k kVar = new C13897k(kit, yVar, currentTimeProvider, settingsJsonTransform, cachedSettingsIo, settingsSpiCall, dataCollectionArbiter);
                this.f42184c = kVar;
            }
            this.f42185d = true;
            return this;
        }
    }

    /* renamed from: a */
    public C13909v mo43313a() {
        try {
            this.f42183b.await();
            return (C13909v) this.f42182a.get();
        } catch (InterruptedException e) {
            C13920f.m44245e().mo43324b("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    /* renamed from: c */
    public synchronized boolean mo43314c() {
        C13909v settingsData;
        settingsData = this.f42184c.mo43302a();
        m44192a(settingsData);
        return settingsData != null;
    }

    /* renamed from: d */
    public synchronized boolean mo43315d() {
        C13909v settingsData;
        settingsData = this.f42184c.mo43303a(C13907t.SKIP_CACHE_LOOKUP);
        m44192a(settingsData);
        if (settingsData == null) {
            C13920f.m44245e().mo43325b("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return settingsData != null;
    }

    /* renamed from: a */
    private void m44192a(C13909v settingsData) {
        this.f42182a.set(settingsData);
        this.f42183b.countDown();
    }
}
