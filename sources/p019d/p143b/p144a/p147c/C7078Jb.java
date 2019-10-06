package p019d.p143b.p144a.p147c;

import android.os.Build.VERSION;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.Jb */
public class C7078Jb extends C7184mb {
    C7078Jb(C7142c cVar) {
        super("TaskFetchBasicSettings", cVar);
    }

    /* renamed from: a */
    private String m14780a(Map<String, String> map) {
        return C7202r.m15407b("i", map, this.f13625b);
    }

    /* renamed from: b */
    private String m14781b(Map<String, String> map) {
        return C7202r.m15412d("i", map, this.f13625b);
    }

    /* renamed from: b */
    private Map<String, String> m14782b() {
        HashMap hashMap = new HashMap(11);
        hashMap.put("sdk_key", this.f13625b.mo23079x());
        hashMap.put("sdk_version", BuildConfig.APPLOVIN_SDK_VERSION);
        hashMap.put("build", String.valueOf(103));
        Boolean a = C7186n.m15335a(this.f13627d);
        if (a != null) {
            hashMap.put("huc", a.toString());
        }
        Boolean b = C7186n.m15339b(this.f13627d);
        if (b != null) {
            hashMap.put("aru", b.toString());
        }
        String str = (String) this.f13625b.mo23039a(C7196pb.f13714K);
        if (C7269s.m15819a(str)) {
            hashMap.put("plugin_version", C7209sc.m15487d(str));
        }
        String t = this.f13625b.mo23075t();
        if (C7269s.m15819a(t)) {
            hashMap.put("mediation_provider", C7209sc.m15487d(t));
        }
        C7222w c = this.f13625b.mo23070o().mo23244c();
        hashMap.put("package_name", C7209sc.m15487d(c.f14009c));
        hashMap.put("app_version", C7209sc.m15487d(c.f14008b));
        hashMap.put("platform", C7209sc.m15487d(this.f13625b.mo23070o().mo23243b()));
        hashMap.put("os", C7209sc.m15487d(VERSION.RELEASE));
        return hashMap;
    }

    public void run() {
        Map b = m14782b();
        String a = m14780a(b);
        String b2 = m14781b(b);
        C7082Kb kb = new C7082Kb(this, "GET", new JSONObject(), "TaskRepeatFetchBasicSettings", this.f13625b);
        kb.f13628e = this.f13628e;
        kb.mo23150a(a);
        kb.mo23155b(b2);
        kb.mo23156c(((Integer) this.f13625b.mo23039a(C7196pb.f13831id)).intValue());
        kb.mo23148a((long) ((Integer) this.f13625b.mo23039a(C7196pb.f13836jd)).intValue());
        kb.mo23153b(((Integer) this.f13625b.mo23039a(C7196pb.f13826hd)).intValue());
        kb.mo23149a(C7196pb.f13862p);
        kb.mo23154b(C7196pb.f13882t);
        kb.run();
    }
}
