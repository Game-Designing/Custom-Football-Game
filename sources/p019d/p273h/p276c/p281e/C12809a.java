package p019d.p273h.p276c.p281e;

import org.json.JSONObject;

/* renamed from: d.h.c.e.a */
/* compiled from: AdapterConfig */
public class C12809a {

    /* renamed from: a */
    private C12826q f39428a;

    /* renamed from: b */
    private JSONObject f39429b;

    /* renamed from: c */
    private boolean f39430c;

    /* renamed from: d */
    private int f39431d;

    public C12809a(C12826q settings, JSONObject adUnitSettings) {
        this.f39428a = settings;
        this.f39429b = adUnitSettings;
        this.f39430c = adUnitSettings.optInt("instanceType") == 2;
        this.f39431d = adUnitSettings.optInt("maxAdsPerSession", 99);
    }

    /* renamed from: b */
    public JSONObject mo41453b() {
        return this.f39429b;
    }

    /* renamed from: g */
    public boolean mo41458g() {
        return this.f39430c;
    }

    /* renamed from: c */
    public int mo41454c() {
        return this.f39431d;
    }

    /* renamed from: d */
    public String mo41455d() {
        return this.f39428a.mo41551h();
    }

    /* renamed from: f */
    public String mo41457f() {
        return this.f39428a.mo41555l();
    }

    /* renamed from: a */
    public String mo41452a() {
        return this.f39428a.mo41532a();
    }

    /* renamed from: e */
    public String mo41456e() {
        return this.f39428a.mo41552i();
    }
}
