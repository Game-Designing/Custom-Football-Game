package com.bumptech.glide.load;

import com.bumptech.glide.p107h.C6017b;
import java.security.MessageDigest;
import p002b.p003c.p053g.p061f.C1253b;
import p002b.p003c.p053g.p061f.C1273q;

/* renamed from: com.bumptech.glide.load.k */
/* compiled from: Options */
public final class C6349k implements C6344g {

    /* renamed from: a */
    private final C1253b<C6347j<?>, Object> f11325a = new C6017b();

    /* renamed from: a */
    public void mo19311a(C6349k other) {
        this.f11325a.mo9155a((C1273q<? extends K, ? extends V>) other.f11325a);
    }

    /* renamed from: a */
    public <T> C6349k mo19309a(C6347j<T> option, T value) {
        this.f11325a.put(option, value);
        return this;
    }

    /* renamed from: a */
    public <T> T mo19310a(C6347j<T> option) {
        return this.f11325a.containsKey(option) ? this.f11325a.get(option) : option.mo19304a();
    }

    public boolean equals(Object o) {
        if (!(o instanceof C6349k)) {
            return false;
        }
        return this.f11325a.equals(((C6349k) o).f11325a);
    }

    public int hashCode() {
        return this.f11325a.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        for (int i = 0; i < this.f11325a.size(); i++) {
            m12252a((C6347j) this.f11325a.mo9157b(i), this.f11325a.mo9162d(i), messageDigest);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Options{values=");
        sb.append(this.f11325a);
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: a */
    private static <T> void m12252a(C6347j<T> option, Object value, MessageDigest md) {
        option.mo19305a(value, md);
    }
}
