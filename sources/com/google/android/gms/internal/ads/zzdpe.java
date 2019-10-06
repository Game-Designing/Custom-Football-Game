package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzdpe<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: a */
    private static final zzdpe f28111a;

    /* renamed from: b */
    private boolean f28112b = true;

    private zzdpe() {
    }

    private zzdpe(Map<K, V> map) {
        super(map);
    }

    /* renamed from: c */
    public static <K, V> zzdpe<K, V> m29955c() {
        return f28111a;
    }

    /* renamed from: a */
    public final void mo31634a(zzdpe<K, V> zzdpe) {
        m29956h();
        if (!zzdpe.isEmpty()) {
            putAll(zzdpe);
        }
    }

    public final Set<Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final void clear() {
        m29956h();
        super.clear();
    }

    public final V put(K k, V v) {
        m29956h();
        zzdod.m29915a(k);
        zzdod.m29915a(v);
        return super.put(k, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        m29956h();
        for (Object next : map.keySet()) {
            zzdod.m29915a(next);
            zzdod.m29915a(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        m29956h();
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpe.equals(java.lang.Object):boolean");
    }

    /* renamed from: a */
    private static int m29954a(Object obj) {
        if (obj instanceof byte[]) {
            return zzdod.m29914a((byte[]) obj);
        }
        if (!(obj instanceof zzdoe)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        int i = 0;
        for (Entry entry : entrySet()) {
            i += m29954a(entry.getValue()) ^ m29954a(entry.getKey());
        }
        return i;
    }

    /* renamed from: d */
    public final zzdpe<K, V> mo31638d() {
        return isEmpty() ? new zzdpe<>() : new zzdpe<>(this);
    }

    /* renamed from: b */
    public final void mo31636b() {
        this.f28112b = false;
    }

    /* renamed from: a */
    public final boolean mo31635a() {
        return this.f28112b;
    }

    /* renamed from: h */
    private final void m29956h() {
        if (!this.f28112b) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        zzdpe zzdpe = new zzdpe();
        f28111a = zzdpe;
        zzdpe.f28112b = false;
    }
}
