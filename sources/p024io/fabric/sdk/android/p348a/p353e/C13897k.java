package p024io.fabric.sdk.android.p348a.p353e;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import org.json.JSONException;
import org.json.JSONObject;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;
import p024io.fabric.sdk.android.p348a.p350b.C13857n;
import p024io.fabric.sdk.android.p348a.p350b.C13858o;
import p024io.fabric.sdk.android.p348a.p352d.C13884c;
import p024io.fabric.sdk.android.p348a.p352d.C13885d;

/* renamed from: io.fabric.sdk.android.a.e.k */
/* compiled from: DefaultSettingsController */
class C13897k implements C13908u {

    /* renamed from: a */
    private final C13912y f42151a;

    /* renamed from: b */
    private final C13911x f42152b;

    /* renamed from: c */
    private final C13857n f42153c;

    /* renamed from: d */
    private final C13894h f42154d;

    /* renamed from: e */
    private final C13913z f42155e;

    /* renamed from: f */
    private final C0102l f42156f;

    /* renamed from: g */
    private final C13884c f42157g = new C13885d(this.f42156f);

    /* renamed from: h */
    private final C13858o f42158h;

    public C13897k(C0102l kit, C13912y settingsRequest, C13857n currentTimeProvider, C13911x settingsJsonTransform, C13894h cachedSettingsIo, C13913z settingsSpiCall, C13858o dataCollectionArbiter) {
        this.f42156f = kit;
        this.f42151a = settingsRequest;
        this.f42153c = currentTimeProvider;
        this.f42152b = settingsJsonTransform;
        this.f42154d = cachedSettingsIo;
        this.f42155e = settingsSpiCall;
        this.f42158h = dataCollectionArbiter;
    }

    /* renamed from: a */
    public C13909v mo43302a() {
        return mo43303a(C13907t.USE_CACHE);
    }

    /* renamed from: a */
    public C13909v mo43303a(C13907t cacheBehavior) {
        String str = "Fabric";
        if (!this.f42158h.mo43247a()) {
            C13920f.m44245e().mo43326c(str, "Not fetching settings, because data collection is disabled by Firebase.");
            return null;
        }
        C13909v toReturn = null;
        try {
            if (!C13920f.m44246g() && !mo43305b()) {
                toReturn = m44168b(cacheBehavior);
            }
            if (toReturn == null) {
                JSONObject settingsJson = this.f42155e.mo43309a(this.f42151a);
                if (settingsJson != null) {
                    toReturn = this.f42152b.mo43308a(this.f42153c, settingsJson);
                    this.f42154d.mo43301a(toReturn.f42197g, settingsJson);
                    m44167a(settingsJson, "Loaded settings: ");
                    mo43304a(mo43306c());
                }
            }
            if (toReturn == null) {
                toReturn = m44168b(C13907t.IGNORE_CACHE_EXPIRATION);
            }
        } catch (Exception e) {
            C13920f.m44245e().mo43325b(str, "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", e);
        }
        return toReturn;
    }

    /* renamed from: b */
    private C13909v m44168b(C13907t cacheBehavior) {
        String str = "Fabric";
        C13909v toReturn = null;
        try {
            if (!C13907t.SKIP_CACHE_LOOKUP.equals(cacheBehavior)) {
                JSONObject settingsJson = this.f42154d.mo43300a();
                if (settingsJson != null) {
                    C13909v settingsData = this.f42152b.mo43308a(this.f42153c, settingsJson);
                    if (settingsData != null) {
                        m44167a(settingsJson, "Loaded cached settings: ");
                        long currentTimeMillis = this.f42153c.mo43216a();
                        if (!C13907t.IGNORE_CACHE_EXPIRATION.equals(cacheBehavior)) {
                            if (settingsData.mo43316a(currentTimeMillis)) {
                                C13920f.m44245e().mo43326c(str, "Cached settings have expired.");
                            }
                        }
                        toReturn = settingsData;
                        C13920f.m44245e().mo43326c(str, "Returning cached settings.");
                    } else {
                        C13920f.m44245e().mo43325b(str, "Failed to transform cached settings data.", null);
                    }
                } else {
                    C13920f.m44245e().mo43326c(str, "No cached settings data found.");
                }
            }
        } catch (Exception e) {
            C13920f.m44245e().mo43325b(str, "Failed to get cached settings", e);
        }
        return toReturn;
    }

    /* renamed from: a */
    private void m44167a(JSONObject json, String message) throws JSONException {
        C13929o e = C13920f.m44245e();
        StringBuilder sb = new StringBuilder();
        sb.append(message);
        sb.append(json.toString());
        e.mo43326c("Fabric", sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo43306c() {
        return C13852l.m44032a(C13852l.m44062n(this.f42156f.mo3307i()));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public String mo43307d() {
        return this.f42157g.get().getString("existing_instance_identifier", "");
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: a */
    public boolean mo43304a(String buildInstanceIdentifier) {
        Editor editor = this.f42157g.edit();
        editor.putString("existing_instance_identifier", buildInstanceIdentifier);
        return this.f42157g.mo43294a(editor);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo43305b() {
        return !mo43307d().equals(mo43306c());
    }
}
