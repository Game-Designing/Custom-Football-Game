package p019d.p143b.p144a.p147c;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.cb */
public class C7144cb {

    /* renamed from: a */
    private final C7142c f13482a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C7262l f13483b;

    /* renamed from: c */
    private ArrayList<C7152eb> f13484c;

    /* renamed from: d */
    private ArrayList<C7152eb> f13485d;

    /* renamed from: e */
    private final Object f13486e;

    /* renamed from: f */
    private final SharedPreferences f13487f;

    C7144cb(C7142c cVar) {
        if (cVar != null) {
            this.f13482a = cVar;
            this.f13483b = cVar.mo23049b();
            this.f13487f = cVar.mo23068m().getSharedPreferences("com.applovin.sdk.impl.postbackQueue.domain", 0);
            this.f13486e = new Object();
            this.f13484c = m15108c();
            this.f13485d = new ArrayList<>();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: a */
    private C7152eb m15102a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("attemptNumber");
            return new C7152eb(jSONObject.getString("targetUrl"), C7167ia.m15260a(jSONObject.getJSONObject("requestBody")), i, jSONObject.getString("backupUrl"));
        } catch (Exception e) {
            this.f13483b.mo22914a("PersistentPostbackManager", "Unable to inflate postback request from JSON.", e);
            return null;
        }
    }

    /* renamed from: a */
    private void m15105a(C7152eb ebVar) {
        synchronized (this.f13486e) {
            m15107b(ebVar);
            m15109c(ebVar);
        }
    }

    /* renamed from: b */
    private void m15107b(C7152eb ebVar) {
        synchronized (this.f13486e) {
            if (this.f13484c.size() < ((Integer) this.f13482a.mo23039a(C7196pb.f13762Ub)).intValue()) {
                this.f13484c.add(ebVar);
                m15110d();
                StringBuilder sb = new StringBuilder();
                sb.append("Enqueued postback: ");
                sb.append(ebVar);
                this.f13483b.mo22918c("PersistentPostbackManager", sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Persistent queue has reached maximum size; postback retried in memory only.");
                sb2.append(ebVar);
                this.f13483b.mo22913a("PersistentPostbackManager", sb2.toString());
            }
        }
    }

    /* renamed from: c */
    private ArrayList<C7152eb> m15108c() {
        String str = "PersistentPostbackManager";
        if (C7182m.m15322b()) {
            Set<String> set = (Set) this.f13482a.mo23042a(C7216ub.f13975b, new LinkedHashSet(0), this.f13487f);
            ArrayList<C7152eb> arrayList = new ArrayList<>(Math.max(1, set.size()));
            int intValue = ((Integer) this.f13482a.mo23039a(C7196pb.f13766Vb)).intValue();
            C7262l lVar = this.f13483b;
            StringBuilder sb = new StringBuilder();
            sb.append("Deserializing ");
            sb.append(set.size());
            String str2 = " postback(s).";
            sb.append(str2);
            lVar.mo22918c(str, sb.toString());
            for (String str3 : set) {
                C7152eb a = m15102a(str3);
                if (a == null) {
                    C7262l lVar2 = this.f13483b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unable to deserialize postback json: ");
                    sb2.append(str3);
                    lVar2.mo22916b(str, sb2.toString());
                } else if (a.mo23101a() > intValue) {
                    arrayList.add(a);
                } else {
                    C7262l lVar3 = this.f13483b;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Skipping deserialization because maximum attempt count exceeded for postback: ");
                    sb3.append(a);
                    lVar3.mo22918c(str, sb3.toString());
                }
            }
            C7262l lVar4 = this.f13483b;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Successfully loaded postback queue with ");
            sb4.append(arrayList.size());
            sb4.append(str2);
            lVar4.mo22918c(str, sb4.toString());
            return arrayList;
        }
        this.f13483b.mo22918c(str, "Loading new postback queue due to old Android version...");
        return new ArrayList<>();
    }

    /* renamed from: c */
    private void m15109c(C7152eb ebVar) {
        C7262l lVar = this.f13483b;
        StringBuilder sb = new StringBuilder();
        sb.append("Preparing to submit postback...");
        sb.append(ebVar);
        lVar.mo22918c("PersistentPostbackManager", sb.toString());
        if (this.f13482a.mo23065j()) {
            this.f13483b.mo22918c("PersistentPostbackManager", "Skipping postback dispatch because SDK is still initializing - postback will be dispatched afterwards");
            return;
        }
        synchronized (this.f13486e) {
            ebVar.mo23102a(ebVar.mo23101a() + 1);
            m15110d();
        }
        int intValue = ((Integer) this.f13482a.mo23039a(C7196pb.f13766Vb)).intValue();
        if (ebVar.mo23101a() > intValue) {
            C7262l lVar2 = this.f13483b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Exceeded maximum persisted attempt count of ");
            sb2.append(intValue);
            sb2.append(". Dequeuing postback: ");
            sb2.append(ebVar);
            lVar2.mo22913a("PersistentPostbackManager", sb2.toString());
            m15111d(ebVar);
        } else {
            this.f13482a.mo23078w().mo23138a(ebVar.mo23103b(), ebVar.mo23105d(), ebVar.mo23104c(), new C7148db(this, ebVar));
        }
    }

    /* renamed from: d */
    private void m15110d() {
        String str;
        C7262l lVar;
        String str2 = "PersistentPostbackManager";
        if (C7182m.m15325c()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.f13484c.size());
            Iterator it = this.f13484c.iterator();
            while (it.hasNext()) {
                String f = m15113f((C7152eb) it.next());
                if (f != null) {
                    linkedHashSet.add(f);
                }
            }
            this.f13482a.mo23052b(C7216ub.f13975b, linkedHashSet);
            lVar = this.f13483b;
            str = "Wrote updated postback queue to disk.";
        } else {
            lVar = this.f13483b;
            str = "Skipping writing postback queue to disk due to old Android version...";
        }
        lVar.mo22918c(str2, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m15111d(C7152eb ebVar) {
        synchronized (this.f13486e) {
            this.f13484c.remove(ebVar);
            m15110d();
        }
        C7262l lVar = this.f13483b;
        StringBuilder sb = new StringBuilder();
        sb.append("Dequeued successfully transmitted postback: ");
        sb.append(ebVar);
        lVar.mo22918c("PersistentPostbackManager", sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m15112e(C7152eb ebVar) {
        synchronized (this.f13486e) {
            this.f13485d.add(ebVar);
        }
    }

    /* renamed from: f */
    private String m15113f(C7152eb ebVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("attemptNumber", ebVar.mo23101a());
            jSONObject.put("targetUrl", ebVar.mo23103b());
            String c = ebVar.mo23104c();
            if (C7269s.m15819a(c)) {
                jSONObject.put("backupUrl", c);
            }
            Map d = ebVar.mo23105d();
            if (d != null) {
                jSONObject.put("requestBody", new JSONObject(d));
            }
            return jSONObject.toString();
        } catch (Exception e) {
            this.f13483b.mo22914a("PersistentPostbackManager", "Unable to serialize postback request to JSON.", e);
            return null;
        }
    }

    /* renamed from: a */
    public void mo23083a() {
        synchronized (this.f13486e) {
            if (this.f13484c != null) {
                for (C7152eb c : new ArrayList(this.f13484c)) {
                    m15109c(c);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo23084a(String str, Map<String, String> map) {
        mo23085a(str, map, true);
    }

    /* renamed from: a */
    public void mo23085a(String str, Map<String, String> map, boolean z) {
        mo23086a(str, map, z, null);
    }

    /* renamed from: a */
    public void mo23086a(String str, Map<String, String> map, boolean z, String str2) {
        if (C7269s.m15819a(str)) {
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append("&postback_ts=");
                sb.append(System.currentTimeMillis());
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(sb2);
                str = sb3.toString();
                if (C7269s.m15819a(str2)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str2);
                    sb4.append(sb2);
                    str2 = sb4.toString();
                }
            }
            m15105a(new C7152eb(str, map, 0, str2));
        }
    }

    /* renamed from: b */
    public void mo23087b() {
        synchronized (this.f13486e) {
            Iterator it = this.f13485d.iterator();
            while (it.hasNext()) {
                m15109c((C7152eb) it.next());
            }
            this.f13485d.clear();
        }
    }
}
