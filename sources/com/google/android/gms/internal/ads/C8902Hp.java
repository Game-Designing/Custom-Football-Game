package com.google.android.gms.internal.ads;

import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.ads.Hp */
final class C8902Hp implements Comparable<C8902Hp>, Entry<K, V> {

    /* renamed from: a */
    private final K f21220a;

    /* renamed from: b */
    private V f21221b;

    /* renamed from: c */
    private final /* synthetic */ C8755Ap f21222c;

    C8902Hp(C8755Ap ap, Entry<K, V> entry) {
        this(ap, (Comparable) entry.getKey(), entry.getValue());
    }

    C8902Hp(C8755Ap ap, K k, V v) {
        this.f21222c = ap;
        this.f21220a = k;
        this.f21221b = v;
    }

    public final V getValue() {
        return this.f21221b;
    }

    public final V setValue(V v) {
        this.f21222c.m22291f();
        V v2 = this.f21221b;
        this.f21221b = v;
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
        if (!m22673a(this.f21220a, entry.getKey()) || !m22673a(this.f21221b, entry.getValue())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        K k = this.f21220a;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.f21221b;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f21220a);
        String valueOf2 = String.valueOf(this.f21221b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    /* renamed from: a */
    private static boolean m22673a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final /* synthetic */ Object getKey() {
        return this.f21220a;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((C8902Hp) obj).getKey());
    }
}
