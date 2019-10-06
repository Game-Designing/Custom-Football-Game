package p019d.p143b.p144a.p147c;

import java.util.Iterator;
import java.util.LinkedHashSet;
import org.json.JSONArray;
import org.json.JSONObject;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.Gc */
final class C7067Gc {

    /* renamed from: a */
    private final C7142c f13215a;

    /* renamed from: b */
    private final C7262l f13216b;

    /* renamed from: c */
    private LinkedHashSet<C7059Ec> f13217c;

    /* renamed from: d */
    private final Object f13218d = new Object();

    /* renamed from: e */
    private volatile boolean f13219e;

    C7067Gc(C7142c cVar) {
        this.f13215a = cVar;
        this.f13216b = cVar.mo23049b();
        this.f13217c = m14705c();
    }

    /* renamed from: b */
    private LinkedHashSet<C7059Ec> m14704b(JSONArray jSONArray) {
        LinkedHashSet<C7059Ec> linkedHashSet = new LinkedHashSet<>(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject a = C7167ia.m15263a(jSONArray, i, (JSONObject) null, (C7267q) this.f13215a);
            C7262l lVar = this.f13216b;
            StringBuilder sb = new StringBuilder();
            sb.append("Loading zone: ");
            sb.append(a);
            sb.append("...");
            lVar.mo22918c("AdZoneManager", sb.toString());
            linkedHashSet.add(C7059Ec.m14673a(C7167ia.m15258a(a, "id", (String) null, (C7267q) this.f13215a), a, this.f13215a));
        }
        return linkedHashSet;
    }

    /* renamed from: c */
    private LinkedHashSet<C7059Ec> m14705c() {
        String str = "Retrieved persisted zones: ";
        String str2 = "AdZoneManager";
        LinkedHashSet<C7059Ec> linkedHashSet = new LinkedHashSet<>();
        try {
            String str3 = (String) this.f13215a.mo23040a(C7216ub.f13977d);
            if (C7269s.m15819a(str3)) {
                JSONArray jSONArray = new JSONArray(str3);
                if (jSONArray.length() > 0) {
                    linkedHashSet = m14704b(jSONArray);
                } else {
                    C7262l lVar = this.f13216b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to inflate json string: ");
                    sb.append(str3);
                    lVar.mo22918c(str2, sb.toString());
                }
            }
            if (!linkedHashSet.isEmpty()) {
                C7262l lVar2 = this.f13216b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(linkedHashSet);
                lVar2.mo22918c(str2, sb2.toString());
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    ((C7059Ec) it.next()).mo22800a(this.f13215a);
                }
            }
        } catch (Throwable th) {
            if (!linkedHashSet.isEmpty()) {
                C7262l lVar3 = this.f13216b;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(linkedHashSet);
                lVar3.mo22918c(str2, sb3.toString());
                Iterator it2 = linkedHashSet.iterator();
                while (it2.hasNext()) {
                    ((C7059Ec) it2.next()).mo22800a(this.f13215a);
                }
            }
            throw th;
        }
        return linkedHashSet;
    }

    /* renamed from: c */
    private void m14706c(JSONArray jSONArray) {
        if (((Boolean) this.f13215a.mo23039a(C7196pb.f13779Yc)).booleanValue()) {
            this.f13216b.mo22918c("AdZoneManager", "Persisting zones...");
            this.f13215a.mo23052b(C7216ub.f13977d, jSONArray.toString());
        }
    }

    /* renamed from: a */
    public LinkedHashSet<C7059Ec> mo22820a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new LinkedHashSet<>();
        }
        LinkedHashSet<C7059Ec> linkedHashSet = new LinkedHashSet<>(jSONArray.length());
        LinkedHashSet<C7059Ec> linkedHashSet2 = null;
        synchronized (this.f13218d) {
            if (!this.f13219e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Found ");
                sb.append(jSONArray.length());
                sb.append(" zone(s)...");
                this.f13216b.mo22918c("AdZoneManager", sb.toString());
                linkedHashSet2 = m14704b(jSONArray);
                linkedHashSet = new LinkedHashSet<>(linkedHashSet2);
                linkedHashSet.removeAll(this.f13217c);
                this.f13217c = linkedHashSet2;
                this.f13219e = true;
            }
        }
        if (linkedHashSet2 != null) {
            m14706c(jSONArray);
            this.f13216b.mo22918c("AdZoneManager", "Finished loading zones");
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    public boolean mo22821a() {
        return this.f13219e;
    }

    /* renamed from: a */
    public boolean mo22822a(C7059Ec ec) {
        boolean contains;
        synchronized (this.f13218d) {
            contains = this.f13217c.contains(ec);
        }
        return contains;
    }

    /* renamed from: b */
    public LinkedHashSet<C7059Ec> mo22823b() {
        LinkedHashSet<C7059Ec> linkedHashSet;
        synchronized (this.f13218d) {
            linkedHashSet = this.f13217c;
        }
        return linkedHashSet;
    }
}
