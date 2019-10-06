package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.ads.hp */
final class C9478hp implements C9456gp {
    C9478hp() {
    }

    /* renamed from: g */
    public final Map<?, ?> mo28973g(Object obj) {
        return (zzdpe) obj;
    }

    /* renamed from: c */
    public final C9434fp<?, ?> mo28969c(Object obj) {
        throw new NoSuchMethodError();
    }

    /* renamed from: d */
    public final Map<?, ?> mo28970d(Object obj) {
        return (zzdpe) obj;
    }

    /* renamed from: f */
    public final boolean mo28972f(Object obj) {
        return !((zzdpe) obj).mo31635a();
    }

    /* renamed from: e */
    public final Object mo28971e(Object obj) {
        ((zzdpe) obj).mo31636b();
        return obj;
    }

    /* renamed from: b */
    public final Object mo28968b(Object obj) {
        return zzdpe.m29955c().mo31638d();
    }

    /* renamed from: a */
    public final Object mo28967a(Object obj, Object obj2) {
        zzdpe zzdpe = (zzdpe) obj;
        zzdpe zzdpe2 = (zzdpe) obj2;
        if (!zzdpe2.isEmpty()) {
            if (!zzdpe.mo31635a()) {
                zzdpe = zzdpe.mo31638d();
            }
            zzdpe.mo31634a(zzdpe2);
        }
        return zzdpe;
    }

    /* renamed from: a */
    public final int mo28966a(int i, Object obj, Object obj2) {
        zzdpe zzdpe = (zzdpe) obj;
        if (zzdpe.isEmpty()) {
            return 0;
        }
        Iterator it = zzdpe.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Entry entry = (Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
