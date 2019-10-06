package com.google.android.gms.internal.ads;

public class zzdor {

    /* renamed from: a */
    private static final zzdno f28104a = zzdno.m29866b();

    /* renamed from: b */
    private zzdmr f28105b;

    /* renamed from: c */
    private volatile zzdpk f28106c;

    /* renamed from: d */
    private volatile zzdmr f28107d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdor)) {
            return false;
        }
        zzdor zzdor = (zzdor) obj;
        zzdpk zzdpk = this.f28106c;
        zzdpk zzdpk2 = zzdor.f28106c;
        if (zzdpk == null && zzdpk2 == null) {
            return mo31622a().equals(zzdor.mo31622a());
        }
        if (zzdpk != null && zzdpk2 != null) {
            return zzdpk.equals(zzdpk2);
        }
        if (zzdpk != null) {
            return zzdpk.equals(zzdor.m29939b(zzdpk.mo31601a()));
        }
        return m29939b(zzdpk2.mo31601a()).equals(zzdpk2);
    }

    public int hashCode() {
        return 1;
    }

    /* renamed from: b */
    private final zzdpk m29939b(zzdpk zzdpk) {
        if (this.f28106c == null) {
            synchronized (this) {
                if (this.f28106c == null) {
                    try {
                        this.f28106c = zzdpk;
                        this.f28107d = zzdmr.f27972a;
                    } catch (zzdok e) {
                        this.f28106c = zzdpk;
                        this.f28107d = zzdmr.f27972a;
                    }
                }
            }
        }
        return this.f28106c;
    }

    /* renamed from: a */
    public final zzdpk mo31623a(zzdpk zzdpk) {
        zzdpk zzdpk2 = this.f28106c;
        this.f28105b = null;
        this.f28107d = null;
        this.f28106c = zzdpk;
        return zzdpk2;
    }

    /* renamed from: b */
    public final int mo31624b() {
        if (this.f28107d != null) {
            return this.f28107d.size();
        }
        if (this.f28106c != null) {
            return this.f28106c.mo31603c();
        }
        return 0;
    }

    /* renamed from: a */
    public final zzdmr mo31622a() {
        if (this.f28107d != null) {
            return this.f28107d;
        }
        synchronized (this) {
            if (this.f28107d != null) {
                zzdmr zzdmr = this.f28107d;
                return zzdmr;
            }
            if (this.f28106c == null) {
                this.f28107d = zzdmr.f27972a;
            } else {
                this.f28107d = this.f28106c.mo31531b();
            }
            zzdmr zzdmr2 = this.f28107d;
            return zzdmr2;
        }
    }
}
