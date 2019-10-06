package p019d.p273h.p276c;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12809a;

/* renamed from: d.h.c.da */
/* compiled from: ProgSmash */
public abstract class C12807da {

    /* renamed from: a */
    protected C12775b f39422a;

    /* renamed from: b */
    protected C12809a f39423b;

    /* renamed from: c */
    private boolean f39424c;

    /* renamed from: d */
    protected JSONObject f39425d;

    C12807da(C12809a adapterConfig, C12775b adapter) {
        this.f39423b = adapterConfig;
        this.f39422a = adapter;
        this.f39425d = adapterConfig.mo41453b();
    }

    /* renamed from: o */
    public boolean mo41449o() {
        return this.f39423b.mo41458g();
    }

    /* renamed from: l */
    public int mo41446l() {
        return this.f39423b.mo41454c();
    }

    /* renamed from: j */
    public String mo41444j() {
        return this.f39423b.mo41455d();
    }

    /* renamed from: m */
    public String mo41447m() {
        return this.f39423b.mo41456e();
    }

    /* renamed from: c */
    public void mo41443c(boolean isLoadCandidate) {
        this.f39424c = isLoadCandidate;
    }

    /* renamed from: k */
    public boolean mo41445k() {
        return this.f39424c;
    }

    /* renamed from: b */
    public void mo41441b(Activity activity) {
        this.f39422a.onResume(activity);
    }

    /* renamed from: a */
    public void mo41440a(Activity activity) {
        this.f39422a.onPause(activity);
    }

    /* renamed from: b */
    public void mo41442b(boolean consent) {
        this.f39422a.setConsent(consent);
    }

    /* renamed from: n */
    public Map<String, Object> mo41448n() {
        Map<String, Object> data = new HashMap<>();
        try {
            String str = "";
            data.put("providerAdapterVersion", this.f39422a != null ? this.f39422a.getVersion() : str);
            String str2 = "providerSDKVersion";
            if (this.f39422a != null) {
                str = this.f39422a.getCoreSDKVersion();
            }
            data.put(str2, str);
            data.put("spId", this.f39423b.mo41457f());
            data.put("provider", this.f39423b.mo41452a());
            data.put("instanceType", Integer.valueOf(mo41449o() ? 2 : 1));
            data.put("programmatic", Integer.valueOf(1));
        } catch (Exception e) {
            C12802d c = C12802d.m41613c();
            C12801a aVar = C12801a.NATIVE;
            StringBuilder sb = new StringBuilder();
            sb.append("getProviderEventData ");
            sb.append(mo41444j());
            sb.append(")");
            c.mo41426a(aVar, sb.toString(), (Throwable) e);
        }
        return data;
    }
}
