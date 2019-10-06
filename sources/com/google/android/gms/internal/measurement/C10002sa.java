package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.measurement.sa */
final class C10002sa implements C10000ra {
    C10002sa() {
    }

    /* renamed from: e */
    public final C9998qa<?, ?> mo32754e(Object obj) {
        throw new NoSuchMethodError();
    }

    /* renamed from: a */
    public final Map<?, ?> mo32752a(Object obj) {
        return (zzvp) obj;
    }

    /* renamed from: d */
    public final Object mo32753d(Object obj) {
        ((zzvp) obj).mo32925b();
        return obj;
    }

    /* renamed from: a */
    public final Object mo32751a(Object obj, Object obj2) {
        zzvp zzvp = (zzvp) obj;
        zzvp zzvp2 = (zzvp) obj2;
        if (!zzvp2.isEmpty()) {
            if (!zzvp.mo32924a()) {
                zzvp = zzvp.mo32926c();
            }
            zzvp.mo32923a(zzvp2);
        }
        return zzvp;
    }

    /* renamed from: a */
    public final int mo32750a(int i, Object obj, Object obj2) {
        zzvp zzvp = (zzvp) obj;
        if (zzvp.isEmpty()) {
            return 0;
        }
        Iterator it = zzvp.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Entry entry = (Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
