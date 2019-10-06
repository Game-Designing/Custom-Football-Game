package p019d.p143b.p144a.p147c;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.wb */
class C7224wb extends C7184mb {
    C7224wb(C7142c cVar) {
        super("SubmitData", cVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15613a(JSONObject jSONObject) {
        String str = "adserver_parameters";
        try {
            JSONObject a = C7202r.m15402a(jSONObject);
            C7208sb A = this.f13625b.mo23026A();
            A.mo23251a(C7196pb.f13822h, (Object) a.getString("device_id"));
            A.mo23251a(C7196pb.f13832j, (Object) a.getString("device_token"));
            A.mo23251a(C7196pb.f13827i, (Object) a.getString("publisher_id"));
            A.mo23250a();
            C7202r.m15404a(a, this.f13625b);
            this.f13625b.mo23031G();
            C7202r.m15410b(a, this.f13625b);
            if (a.has(str)) {
                A.mo23251a(C7196pb.f13679D, (Object) a.getJSONObject(str).toString());
            }
            String a2 = C7167ia.m15258a(a, "latest_version", "", (C7267q) this.f13625b);
            if (m15614a(a2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Please integrate the latest version of the AppLovin SDK (");
                sb.append(a2);
                sb.append("). Not doing so can negatively impact your eCPMs!");
                this.f13625b.mo23049b().mo22921e("ALSdk", sb.toString());
            }
        } catch (Throwable th) {
            this.f13626c.mo22917b(this.f13624a, "Unable to parse API response", th);
        }
    }

    /* renamed from: a */
    private boolean m15614a(String str) {
        String str2 = "\\.";
        String str3 = BuildConfig.APPLOVIN_SDK_VERSION;
        try {
            if (C7269s.m15819a(str) && !str3.equals(str)) {
                List a = C7178l.m15310a(str, str2);
                List a2 = C7178l.m15310a(str3, str2);
                if (a.size() == 3 && a2.size() == 3) {
                    for (int i = 0; i < 3; i++) {
                        int parseInt = Integer.parseInt((String) a2.get(i));
                        int parseInt2 = Integer.parseInt((String) a.get(i));
                        if (parseInt < parseInt2) {
                            return true;
                        }
                        if (parseInt > parseInt2) {
                            return false;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            this.f13625b.mo23049b().mo22917b(this.f13624a, "Encountered exception while checking if current version is outdated", th);
        }
        return false;
    }

    /* renamed from: b */
    private void m15615b(JSONObject jSONObject) throws JSONException {
        C7206s o = this.f13625b.mo23070o();
        C7222w c = o.mo23244c();
        C7230y a = o.mo23240a();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("model", a.f14024a);
        jSONObject2.put("os", a.f14025b);
        jSONObject2.put("brand", a.f14027d);
        jSONObject2.put("brand_name", a.f14028e);
        jSONObject2.put("hardware", a.f14029f);
        jSONObject2.put("sdk_version", a.f14031h);
        jSONObject2.put("revision", a.f14030g);
        jSONObject2.put("adns", (double) a.f14036m);
        jSONObject2.put("adnsd", a.f14037n);
        jSONObject2.put("gy", a.f14045v);
        jSONObject2.put("country_code", a.f14032i);
        jSONObject2.put("carrier", a.f14033j);
        jSONObject2.put("orientation_lock", a.f14035l);
        jSONObject2.put("tz_offset", a.f14038o);
        boolean z = a.f14040q;
        String str = "1";
        String str2 = BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;
        jSONObject2.put("adr", z ? str : str2);
        jSONObject2.put("wvvc", a.f14039p);
        jSONObject2.put("volume", a.f14042s);
        jSONObject2.put("type", "android");
        if (!a.f14044u) {
            str = str2;
        }
        jSONObject2.put("sim", str);
        m15618e(jSONObject2);
        Boolean bool = a.f14046w;
        if (bool != null) {
            jSONObject2.put("huc", bool.toString());
        }
        Boolean bool2 = a.f14047x;
        if (bool2 != null) {
            jSONObject2.put("aru", bool2.toString());
        }
        C7226x xVar = a.f14041r;
        if (xVar != null) {
            jSONObject2.put("act", xVar.f14017a);
            jSONObject2.put("acm", xVar.f14018b);
        }
        String str3 = a.f14043t;
        if (C7269s.m15819a(str3)) {
            jSONObject2.put("ua", C7209sc.m15487d(str3));
        }
        Locale locale = a.f14034k;
        if (locale != null) {
            jSONObject2.put("locale", C7209sc.m15487d(locale.toString()));
        }
        jSONObject.put("device_info", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("package_name", c.f14009c);
        jSONObject3.put("installer_name", c.f14010d);
        jSONObject3.put("app_name", c.f14007a);
        jSONObject3.put("app_version", c.f14008b);
        jSONObject3.put("installed_at", c.f14011e);
        jSONObject3.put("applovin_sdk_version", BuildConfig.APPLOVIN_SDK_VERSION);
        jSONObject3.put("ic", this.f13625b.mo23034J());
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f13627d);
        String str4 = (String) this.f13625b.mo23042a(C7216ub.f13974a, null, defaultSharedPreferences);
        if (C7269s.m15819a(str4)) {
            jSONObject3.put("first_install", str4);
            if (str4.equalsIgnoreCase(Boolean.toString(true))) {
                this.f13625b.mo23053b(C7216ub.f13974a, Boolean.toString(false), defaultSharedPreferences);
            }
        }
        String str5 = (String) this.f13625b.mo23039a(C7196pb.f13714K);
        if (str5 != null && str5.length() > 0) {
            jSONObject3.put("plugin_version", str5);
        }
        jSONObject.put("app_info", jSONObject3);
    }

    /* renamed from: c */
    private void m15616c(JSONObject jSONObject) throws JSONException {
        if (((Boolean) this.f13625b.mo23039a(C7196pb.f13756T)).booleanValue()) {
            jSONObject.put("stats", this.f13625b.mo23061f().mo22865b());
        }
    }

    /* renamed from: d */
    private void m15617d(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        StringBuilder sb = new StringBuilder();
        sb.append("Repeat");
        sb.append(this.f13624a);
        C7228xb xbVar = new C7228xb(this, "POST", jSONObject2, sb.toString(), this.f13625b);
        String str = "device";
        xbVar.mo23150a(C7202r.m15401a(str, null, this.f13625b));
        xbVar.mo23155b(C7202r.m15411c(str, null, this.f13625b));
        xbVar.mo23151a(jSONObject);
        xbVar.mo23156c(((Integer) this.f13625b.mo23039a(C7196pb.f13837k)).intValue());
        xbVar.mo23149a(C7196pb.f13857o);
        xbVar.mo23154b(C7196pb.f13877s);
        xbVar.run();
    }

    /* renamed from: e */
    private void m15618e(JSONObject jSONObject) {
        try {
            C7218v d = this.f13625b.mo23070o().mo23245d();
            String str = d.f13994b;
            if (C7269s.m15819a(str)) {
                jSONObject.put("idfa", str);
            }
            jSONObject.put("dnt", Boolean.toString(d.f13993a));
        } catch (Throwable th) {
            this.f13626c.mo22917b(mo23203a(), "Failed to populate advertising info", th);
        }
    }

    public void run() {
        try {
            this.f13626c.mo22920d(this.f13624a, "Submitting user data...");
            JSONObject jSONObject = new JSONObject();
            m15615b(jSONObject);
            m15616c(jSONObject);
            jSONObject.put("sc", this.f13625b.mo23039a(C7196pb.f13674C));
            m15617d(jSONObject);
        } catch (JSONException e) {
            this.f13626c.mo22917b(this.f13624a, "Unable to build JSON message with collected data", e);
        }
    }
}
