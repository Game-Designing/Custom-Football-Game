package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzyc;
import java.io.IOException;

public final class zzyd<M extends zzyc<M>, T> {

    /* renamed from: a */
    private final int f30413a;

    /* renamed from: b */
    protected final Class<T> f30414b;

    /* renamed from: c */
    public final int f30415c;

    /* renamed from: d */
    protected final boolean f30416d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzyd)) {
            return false;
        }
        zzyd zzyd = (zzyd) obj;
        if (this.f30413a == zzyd.f30413a && this.f30414b == zzyd.f30414b && this.f30415c == zzyd.f30415c && this.f30416d == zzyd.f30416d) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f30413a + 1147) * 31) + this.f30414b.hashCode()) * 31) + this.f30415c) * 31) + (this.f30416d ? 1 : 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo32957a(Object obj, zzya zzya) {
        try {
            zzya.mo32951c(this.f30415c);
            int i = this.f30413a;
            if (i == 10) {
                int i2 = this.f30415c >>> 3;
                ((zzyi) obj).mo32953a(zzya);
                zzya.mo32948a(i2, 4);
            } else if (i == 11) {
                zzya.mo32949a((zzyi) obj);
            } else {
                int i3 = this.f30413a;
                StringBuilder sb = new StringBuilder(24);
                sb.append("Unknown type ");
                sb.append(i3);
                throw new IllegalArgumentException(sb.toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo32956a(Object obj) {
        int i = this.f30415c >>> 3;
        int i2 = this.f30413a;
        if (i2 == 10) {
            return (zzya.m32597a(i) << 1) + ((zzyi) obj).mo32965b();
        } else if (i2 == 11) {
            return zzya.m32598a(i, (zzyi) obj);
        } else {
            StringBuilder sb = new StringBuilder(24);
            sb.append("Unknown type ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
