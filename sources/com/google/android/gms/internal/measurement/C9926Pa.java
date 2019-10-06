package com.google.android.gms.internal.measurement;

import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.measurement.Pa */
final class C9926Pa implements Comparable<C9926Pa>, Entry<K, V> {

    /* renamed from: a */
    private final K f30023a;

    /* renamed from: b */
    private V f30024b;

    /* renamed from: c */
    private final /* synthetic */ C9912Ia f30025c;

    C9926Pa(C9912Ia ia, Entry<K, V> entry) {
        this(ia, (Comparable) entry.getKey(), entry.getValue());
    }

    C9926Pa(C9912Ia ia, K k, V v) {
        this.f30025c = ia;
        this.f30023a = k;
        this.f30024b = v;
    }

    public final V getValue() {
        return this.f30024b;
    }

    public final V setValue(V v) {
        this.f30025c.m31851f();
        V v2 = this.f30024b;
        this.f30024b = v;
        return v2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        if (!m31878a(this.f30023a, entry.getKey()) || !m31878a(this.f30024b, entry.getValue())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        K k = this.f30023a;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.f30024b;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f30023a);
        String valueOf2 = String.valueOf(this.f30024b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    /* renamed from: a */
    private static boolean m31878a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final /* synthetic */ Object getKey() {
        return this.f30023a;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((C9926Pa) obj).getKey());
    }
}
