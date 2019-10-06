package p019d.p143b.p144a.p147c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p143b.p150d.C7258h;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7268r;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.sb */
class C7208sb {

    /* renamed from: a */
    private final C7142c f13952a;

    /* renamed from: b */
    private final C7262l f13953b;

    /* renamed from: c */
    private final Context f13954c;

    /* renamed from: d */
    private final SharedPreferences f13955d;

    /* renamed from: e */
    private final Object[] f13956e = new Object[C7196pb.m15386b()];

    C7208sb(C7142c cVar) {
        this.f13952a = cVar;
        this.f13953b = cVar.mo23049b();
        this.f13954c = cVar.mo23068m();
        this.f13955d = this.f13954c.getSharedPreferences("com.applovin.sdk.1", 0);
    }

    /* renamed from: a */
    private static Object m15448a(String str, JSONObject jSONObject, Object obj) throws JSONException {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf((float) jSONObject.getDouble(str));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        if (obj instanceof String) {
            return jSONObject.getString(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SDK Error: unknown value type: ");
        sb.append(obj.getClass());
        throw new RuntimeException(sb.toString());
    }

    /* renamed from: d */
    private String m15449d() {
        StringBuilder sb = new StringBuilder();
        sb.append("com.applovin.sdk.");
        sb.append(C7209sc.m15483b(this.f13952a.mo23079x()));
        sb.append(".");
        return sb.toString();
    }

    /* renamed from: a */
    public C7204rb<?> mo23248a(String str, C7204rb<?> rbVar) {
        for (C7204rb<?> rbVar2 : C7196pb.m15385a()) {
            if (rbVar2.mo23236b().equals(str)) {
                return rbVar2;
            }
        }
        return rbVar;
    }

    /* renamed from: a */
    public <T> T mo23249a(C7204rb<T> rbVar) {
        if (rbVar != null) {
            synchronized (this.f13956e) {
                try {
                    Object obj = this.f13956e[rbVar.mo23234a()];
                    if (obj != null) {
                        T a = rbVar.mo23235a(obj);
                        return a;
                    }
                    T c = rbVar.mo23237c();
                    return c;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            throw new IllegalArgumentException("No setting type specified");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23250a() {
        if (this.f13954c != null) {
            this.f13953b.mo22920d("SettingsManager", "Saving settings with the application...");
            String d = m15449d();
            synchronized (this.f13956e) {
                boolean booleanValue = ((Boolean) this.f13952a.mo23039a(C7196pb.f13886td)).booleanValue();
                Editor edit = this.f13955d.edit();
                for (C7204rb rbVar : C7196pb.m15385a()) {
                    Object obj = this.f13956e[rbVar.mo23234a()];
                    if (obj != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(d);
                        sb.append(rbVar.mo23236b());
                        String sb2 = sb.toString();
                        if (booleanValue) {
                            this.f13952a.mo23046a(sb2, obj, edit);
                        } else {
                            this.f13952a.mo23047a(sb2, obj, this.f13955d);
                        }
                    }
                }
                if (booleanValue) {
                    edit.apply();
                }
            }
            this.f13953b.mo22918c("SettingsManager", "Settings saved with the application.");
            return;
        }
        throw new IllegalArgumentException("No context specified");
    }

    /* renamed from: a */
    public <T> void mo23251a(C7204rb<?> rbVar, Object obj) {
        if (rbVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        } else if (obj != null) {
            synchronized (this.f13956e) {
                this.f13956e[rbVar.mo23234a()] = obj;
            }
            C7262l lVar = this.f13953b;
            StringBuilder sb = new StringBuilder();
            sb.append("Setting update: ");
            sb.append(rbVar.mo23236b());
            sb.append(" set to \"");
            sb.append(obj);
            sb.append("\"");
            lVar.mo22918c("SettingsManager", sb.toString());
        } else {
            throw new IllegalArgumentException("No new value specified");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23252a(C7268r rVar) {
        boolean z;
        boolean z2;
        this.f13953b.mo22920d("SettingsManager", "Loading user-defined settings...");
        if (rVar != null) {
            synchronized (this.f13956e) {
                if (((Boolean) this.f13952a.mo23039a(C7196pb.f13852n)).booleanValue()) {
                    this.f13956e[C7196pb.f13852n.mo23234a()] = Boolean.valueOf(rVar.mo23487f());
                }
                long c = rVar.mo23484c();
                long j = 0;
                boolean z3 = false;
                if (c >= 0) {
                    if (c > 0) {
                        j = Math.max(30, c);
                    }
                    this.f13956e[C7196pb.f13689F.mo23234a()] = Long.valueOf(j);
                    this.f13956e[C7196pb.f13684E.mo23234a()] = Boolean.valueOf(true);
                } else if (c == -1) {
                    this.f13956e[C7196pb.f13684E.mo23234a()] = Boolean.valueOf(false);
                }
                if (((Boolean) this.f13952a.mo23039a(C7196pb.f13812f)).booleanValue()) {
                    String a = rVar.mo23480a();
                    if (!C7269s.m15819a(a)) {
                        a = "NONE";
                    }
                    if (a.equals("NONE")) {
                        this.f13956e[C7196pb.f13739P.mo23234a()] = "";
                        this.f13956e[C7196pb.f13744Q.mo23234a()] = "";
                    } else {
                        this.f13956e[C7196pb.f13739P.mo23234a()] = a;
                        this.f13956e[C7196pb.f13744Q.mo23234a()] = a;
                    }
                }
                if (((Boolean) this.f13952a.mo23039a(C7196pb.f13817g)).booleanValue()) {
                    String b = rVar.mo23482b();
                    if (!C7269s.m15819a(b)) {
                        b = "NONE";
                    }
                    if (!"NONE".equals(b)) {
                        z2 = false;
                        z = false;
                        for (String str : C7178l.m15309a(b)) {
                            if (str.equals(C7258h.f14102a.mo23476a())) {
                                z3 = true;
                            } else {
                                if (!str.equals(C7258h.f14103b.mo23476a()) && !str.contains("INCENT")) {
                                    if (!str.contains("REWARD")) {
                                        if (str.equals(C7258h.f14104c.mo23476a())) {
                                            z = true;
                                        }
                                    }
                                }
                                z2 = true;
                            }
                        }
                    } else {
                        z2 = false;
                        z = false;
                    }
                    if (!z3) {
                        this.f13956e[C7196pb.f13739P.mo23234a()] = "";
                        this.f13956e[C7196pb.f13744Q.mo23234a()] = "";
                    }
                    this.f13956e[C7196pb.f13748R.mo23234a()] = Boolean.valueOf(z2);
                    this.f13956e[C7196pb.f13752S.mo23234a()] = Boolean.valueOf(z2);
                    this.f13956e[C7196pb.f13889ub.mo23234a()] = Boolean.valueOf(z);
                }
                if (rVar instanceof C7163ha) {
                    for (Entry entry : ((C7163ha) rVar).mo23160h().entrySet()) {
                        this.f13956e[((C7204rb) entry.getKey()).mo23234a()] = entry.getValue();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23253a(JSONObject jSONObject) {
        C7262l lVar;
        String str;
        String str2;
        this.f13953b.mo22918c("SettingsManager", "Loading settings from JSON array...");
        synchronized (this.f13956e) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                if (str3 != null && str3.length() > 0) {
                    try {
                        C7204rb a = mo23248a(str3, null);
                        if (a != null) {
                            Object a2 = m15448a(str3, jSONObject, a.mo23237c());
                            this.f13956e[a.mo23234a()] = a2;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Setting update: ");
                            sb.append(a.mo23236b());
                            sb.append(" set to \"");
                            sb.append(a2);
                            sb.append("\"");
                            this.f13953b.mo22918c("SettingsManager", sb.toString());
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Unknown setting recieved: ");
                            sb2.append(str3);
                            this.f13953b.mo22913a("SettingsManager", sb2.toString());
                        }
                    } catch (JSONException e) {
                        th = e;
                        lVar = this.f13953b;
                        str = "SettingsManager";
                        str2 = "Unable to parse JSON settings array";
                        lVar.mo22917b(str, str2, th);
                    } catch (Throwable th) {
                        th = th;
                        lVar = this.f13953b;
                        str = "SettingsManager";
                        str2 = "Unable to convert setting object ";
                        lVar.mo22917b(str, str2, th);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public List<String> mo23254b(C7204rb<String> rbVar) {
        return C7178l.m15309a((String) mo23249a(rbVar));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo23255b() {
        if (this.f13954c != null) {
            this.f13953b.mo22920d("SettingsManager", "Loading settings saved with the application...");
            String d = m15449d();
            synchronized (this.f13956e) {
                for (C7204rb rbVar : C7196pb.m15385a()) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append(d);
                        sb.append(rbVar.mo23236b());
                        String sb2 = sb.toString();
                        Object c = rbVar.mo23237c();
                        Object a = this.f13952a.mo23043a(sb2, c, c.getClass(), this.f13955d);
                        if (a != null) {
                            this.f13956e[rbVar.mo23234a()] = a;
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Unable to find value for setting: ");
                            sb3.append(sb2);
                            this.f13953b.mo22916b("SettingsManager", sb3.toString());
                        }
                    } catch (Exception e) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Unable to load \"");
                        sb4.append(rbVar.mo23236b());
                        sb4.append("\"");
                        this.f13953b.mo22917b("SettingsManager", sb4.toString(), e);
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException("No context specified");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo23256c() {
        synchronized (this.f13956e) {
            Arrays.fill(this.f13956e, null);
        }
        this.f13952a.mo23044a(this.f13955d);
    }
}
