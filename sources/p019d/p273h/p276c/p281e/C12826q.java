package p019d.p273h.p276c.p281e;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: d.h.c.e.q */
/* compiled from: ProviderSettings */
public class C12826q {

    /* renamed from: a */
    private String f39503a;

    /* renamed from: b */
    private String f39504b;

    /* renamed from: c */
    private JSONObject f39505c;

    /* renamed from: d */
    private JSONObject f39506d;

    /* renamed from: e */
    private JSONObject f39507e;

    /* renamed from: f */
    private JSONObject f39508f;

    /* renamed from: g */
    private String f39509g;

    /* renamed from: h */
    private String f39510h;

    /* renamed from: i */
    private boolean f39511i;

    /* renamed from: j */
    private String f39512j;

    /* renamed from: k */
    private int f39513k;

    /* renamed from: l */
    private int f39514l;

    /* renamed from: m */
    private int f39515m;

    public C12826q(String providerName) {
        this.f39503a = providerName;
        this.f39512j = providerName;
        this.f39504b = providerName;
        this.f39506d = new JSONObject();
        this.f39507e = new JSONObject();
        this.f39508f = new JSONObject();
        this.f39505c = new JSONObject();
        this.f39513k = -1;
        this.f39514l = -1;
        this.f39515m = -1;
    }

    public C12826q(String providerName, String providerType, JSONObject applicationSettings, JSONObject rewardedVideoSettings, JSONObject interstitialSettings, JSONObject bannerSettings) {
        this.f39503a = providerName;
        this.f39512j = providerName;
        this.f39504b = providerType;
        this.f39506d = rewardedVideoSettings;
        this.f39507e = interstitialSettings;
        this.f39508f = bannerSettings;
        this.f39505c = applicationSettings;
        this.f39513k = -1;
        this.f39514l = -1;
        this.f39515m = -1;
    }

    public C12826q(C12826q other) {
        this.f39503a = other.mo41551h();
        this.f39512j = other.mo41551h();
        this.f39504b = other.mo41552i();
        this.f39506d = other.mo41554k();
        this.f39507e = other.mo41549f();
        this.f39508f = other.mo41547d();
        this.f39505c = other.mo41538b();
        this.f39513k = other.mo41553j();
        this.f39514l = other.mo41548e();
        this.f39515m = other.mo41543c();
    }

    /* renamed from: h */
    public String mo41551h() {
        return this.f39503a;
    }

    /* renamed from: k */
    public JSONObject mo41554k() {
        return this.f39506d;
    }

    /* renamed from: i */
    public String mo41552i() {
        return this.f39504b;
    }

    /* renamed from: c */
    public void mo41546c(JSONObject rewardedVideoSettings) {
        this.f39506d = rewardedVideoSettings;
    }

    /* renamed from: c */
    public void mo41545c(String key, Object value) {
        try {
            this.f39506d.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    public JSONObject mo41549f() {
        return this.f39507e;
    }

    /* renamed from: b */
    public void mo41542b(JSONObject interstitialSettings) {
        this.f39507e = interstitialSettings;
    }

    /* renamed from: b */
    public void mo41541b(String key, Object value) {
        try {
            this.f39507e.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    public JSONObject mo41547d() {
        return this.f39508f;
    }

    /* renamed from: a */
    public void mo41536a(JSONObject bannerSettings) {
        this.f39508f = bannerSettings;
    }

    /* renamed from: a */
    public void mo41535a(String key, Object value) {
        try {
            this.f39508f.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo41534a(String adSourceName) {
        this.f39510h = adSourceName;
    }

    /* renamed from: a */
    public String mo41532a() {
        return this.f39510h;
    }

    /* renamed from: b */
    public void mo41540b(String subProviderId) {
        this.f39509g = subProviderId;
    }

    /* renamed from: l */
    public String mo41555l() {
        return this.f39509g;
    }

    /* renamed from: a */
    public void mo41537a(boolean isMultipleInstances) {
        this.f39511i = isMultipleInstances;
    }

    /* renamed from: m */
    public boolean mo41556m() {
        return this.f39511i;
    }

    /* renamed from: g */
    public String mo41550g() {
        return this.f39512j;
    }

    /* renamed from: b */
    public JSONObject mo41538b() {
        return this.f39505c;
    }

    /* renamed from: a */
    public void mo41533a(int priority) {
        this.f39515m = priority;
    }

    /* renamed from: b */
    public void mo41539b(int priority) {
        this.f39514l = priority;
    }

    /* renamed from: c */
    public void mo41544c(int priority) {
        this.f39513k = priority;
    }

    /* renamed from: c */
    public int mo41543c() {
        return this.f39515m;
    }

    /* renamed from: e */
    public int mo41548e() {
        return this.f39514l;
    }

    /* renamed from: j */
    public int mo41553j() {
        return this.f39513k;
    }
}
