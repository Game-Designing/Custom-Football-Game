package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzvp<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: a */
    private static final zzvp f30369a;

    /* renamed from: b */
    private boolean f30370b = true;

    private zzvp() {
    }

    private zzvp(Map<K, V> map) {
        super(map);
    }

    /* renamed from: a */
    public final void mo32923a(zzvp<K, V> zzvp) {
        m32569d();
        if (!zzvp.isEmpty()) {
            putAll(zzvp);
        }
    }

    public final Set<Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final void clear() {
        m32569d();
        super.clear();
    }

    public final V put(K k, V v) {
        m32569d();
        zzuq.m32540a(k);
        zzuq.m32540a(v);
        return super.put(k, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        m32569d();
        for (Object next : map.keySet()) {
            zzuq.m32540a(next);
            zzuq.m32540a(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        m32569d();
        return super.remove(obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L_0x0060
            java.util.Map r7 = (java.util.Map) r7
            r0 = 1
            if (r6 == r7) goto L_0x005c
            int r2 = r6.size()
            int r3 = r7.size()
            if (r2 == r3) goto L_0x0016
            r7 = 0
            goto L_0x005d
        L_0x0016:
            java.util.Set r2 = r6.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x001e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x005c
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L_0x0036
            r7 = 0
            goto L_0x005d
        L_0x0036:
            java.lang.Object r4 = r3.getValue()
            java.lang.Object r3 = r3.getKey()
            java.lang.Object r3 = r7.get(r3)
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L_0x0053
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L_0x0053
            byte[] r4 = (byte[]) r4
            byte[] r3 = (byte[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L_0x0057
        L_0x0053:
            boolean r3 = r4.equals(r3)
        L_0x0057:
            if (r3 != 0) goto L_0x005b
            r7 = 0
            goto L_0x005d
        L_0x005b:
            goto L_0x001e
        L_0x005c:
            r7 = 1
        L_0x005d:
            if (r7 == 0) goto L_0x0060
            return r0
        L_0x0060:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzvp.equals(java.lang.Object):boolean");
    }

    /* renamed from: a */
    private static int m32568a(Object obj) {
        if (obj instanceof byte[]) {
            return zzuq.m32539a((byte[]) obj);
        }
        if (!(obj instanceof zzur)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        int i = 0;
        for (Entry entry : entrySet()) {
            i += m32568a(entry.getValue()) ^ m32568a(entry.getKey());
        }
        return i;
    }

    /* renamed from: c */
    public final zzvp<K, V> mo32926c() {
        return isEmpty() ? new zzvp<>() : new zzvp<>(this);
    }

    /* renamed from: b */
    public final void mo32925b() {
        this.f30370b = false;
    }

    /* renamed from: a */
    public final boolean mo32924a() {
        return this.f30370b;
    }

    /* renamed from: d */
    private final void m32569d() {
        if (!this.f30370b) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        zzvp zzvp = new zzvp();
        f30369a = zzvp;
        zzvp.f30370b = false;
    }
}
