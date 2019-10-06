package com.google.android.gms.internal.measurement;

public class zzvc {

    /* renamed from: a */
    private static final zzub f30362a = zzub.m32507a();

    /* renamed from: b */
    private zzte f30363b;

    /* renamed from: c */
    private volatile zzvv f30364c;

    /* renamed from: d */
    private volatile zzte f30365d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzvc)) {
            return false;
        }
        zzvc zzvc = (zzvc) obj;
        zzvv zzvv = this.f30364c;
        zzvv zzvv2 = zzvc.f30364c;
        if (zzvv == null && zzvv2 == null) {
            return mo32912a().equals(zzvc.mo32912a());
        }
        if (zzvv != null && zzvv2 != null) {
            return zzvv.equals(zzvv2);
        }
        if (zzvv != null) {
            return zzvv.equals(zzvc.m32555b(zzvv.mo32895b()));
        }
        return m32555b(zzvv2.mo32895b()).equals(zzvv2);
    }

    public int hashCode() {
        return 1;
    }

    /* renamed from: b */
    private final zzvv m32555b(zzvv zzvv) {
        if (this.f30364c == null) {
            synchronized (this) {
                if (this.f30364c == null) {
                    try {
                        this.f30364c = zzvv;
                        this.f30365d = zzte.f30248a;
                    } catch (zzuv e) {
                        this.f30364c = zzvv;
                        this.f30365d = zzte.f30248a;
                    }
                }
            }
        }
        return this.f30364c;
    }

    /* renamed from: a */
    public final zzvv mo32913a(zzvv zzvv) {
        zzvv zzvv2 = this.f30364c;
        this.f30363b = null;
        this.f30365d = null;
        this.f30364c = zzvv;
        return zzvv2;
    }

    /* renamed from: b */
    public final int mo32914b() {
        if (this.f30365d != null) {
            return this.f30365d.size();
        }
        if (this.f30364c != null) {
            return this.f30364c.mo32892a();
        }
        return 0;
    }

    /* renamed from: a */
    public final zzte mo32912a() {
        if (this.f30365d != null) {
            return this.f30365d;
        }
        synchronized (this) {
            if (this.f30365d != null) {
                zzte zzte = this.f30365d;
                return zzte;
            }
            if (this.f30364c == null) {
                this.f30365d = zzte.f30248a;
            } else {
                this.f30365d = this.f30364c.mo32838d();
            }
            zzte zzte2 = this.f30365d;
            return zzte2;
        }
    }
}
