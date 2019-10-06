package com.google.android.gms.internal.ads;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@zzard
public final class zzalh implements zzajq, zzalg {

    /* renamed from: a */
    private final zzalf f24404a;

    /* renamed from: b */
    private final HashSet<SimpleEntry<String, zzaho<? super zzalf>>> f24405b = new HashSet<>();

    public zzalh(zzalf zzalf) {
        this.f24404a = zzalf;
    }

    /* renamed from: a */
    public final void mo29037a(String str, String str2) {
        zzajr.m25122a((zzajq) this, str, str2);
    }

    /* renamed from: a */
    public final void mo28729a(String str, Map map) {
        zzajr.m25123a((zzajq) this, str, map);
    }

    /* renamed from: a */
    public final void mo28730a(String str, JSONObject jSONObject) {
        zzajr.m25125b(this, str, jSONObject);
    }

    /* renamed from: b */
    public final void mo28740b(String str, JSONObject jSONObject) {
        zzajr.m25124a((zzajq) this, str, jSONObject);
    }

    /* renamed from: a */
    public final void mo28724a(String str) {
        this.f24404a.mo28724a(str);
    }

    /* renamed from: a */
    public final void mo29790a(String str, zzaho<? super zzalf> zzaho) {
        this.f24404a.mo29790a(str, zzaho);
        this.f24405b.add(new SimpleEntry(str, zzaho));
    }

    /* renamed from: b */
    public final void mo29792b(String str, zzaho<? super zzalf> zzaho) {
        this.f24404a.mo29792b(str, zzaho);
        this.f24405b.remove(new SimpleEntry(str, zzaho));
    }

    /* renamed from: K */
    public final void mo29804K() {
        Iterator it = this.f24405b.iterator();
        while (it.hasNext()) {
            SimpleEntry simpleEntry = (SimpleEntry) it.next();
            String str = "Unregistering eventhandler: ";
            String valueOf = String.valueOf(((zzaho) simpleEntry.getValue()).toString());
            zzawz.m26003f(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            this.f24404a.mo29792b((String) simpleEntry.getKey(), (zzaho) simpleEntry.getValue());
        }
        this.f24405b.clear();
    }
}
