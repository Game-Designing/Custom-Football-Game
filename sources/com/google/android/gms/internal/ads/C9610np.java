package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzc;
import com.google.android.gms.internal.ads.zzdob.zzd;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.ads.np */
final class C9610np<T> implements C9822xp<T> {

    /* renamed from: a */
    private final zzdpk f22812a;

    /* renamed from: b */
    private final C9049Op<?, ?> f22813b;

    /* renamed from: c */
    private final boolean f22814c;

    /* renamed from: d */
    private final C8922Io<?> f22815d;

    private C9610np(C9049Op<?, ?> op, C8922Io<?> io, zzdpk zzdpk) {
        this.f22813b = op;
        this.f22814c = io.mo28363a(zzdpk);
        this.f22815d = io;
        this.f22812a = zzdpk;
    }

    /* renamed from: a */
    static <T> C9610np<T> m23971a(C9049Op<?, ?> op, C8922Io<?> io, zzdpk zzdpk) {
        return new C9610np<>(op, io, zzdpk);
    }

    /* renamed from: a */
    public final T mo29080a() {
        return this.f22812a.mo31605e().mo31613i();
    }

    /* renamed from: b */
    public final boolean mo29086b(T t, T t2) {
        if (!this.f22813b.mo28496d(t).equals(this.f22813b.mo28496d(t2))) {
            return false;
        }
        if (this.f22814c) {
            return this.f22815d.mo28364b(t).equals(this.f22815d.mo28364b(t2));
        }
        return true;
    }

    /* renamed from: a */
    public final int mo29078a(T t) {
        int hashCode = this.f22813b.mo28496d(t).hashCode();
        if (this.f22814c) {
            return (hashCode * 53) + this.f22815d.mo28364b(t).hashCode();
        }
        return hashCode;
    }

    /* renamed from: a */
    public final void mo29083a(T t, T t2) {
        C9864zp.m24397a(this.f22813b, t, t2);
        if (this.f22814c) {
            C9864zp.m24396a(this.f22815d, t, t2);
        }
    }

    /* renamed from: a */
    public final void mo29081a(T t, C9435fq fqVar) throws IOException {
        Iterator e = this.f22815d.mo28364b(t).mo28430e();
        while (e.hasNext()) {
            Entry entry = (Entry) e.next();
            zzdnu zzdnu = (zzdnu) entry.getKey();
            if (zzdnu.mo31597l() != zzdrn.MESSAGE || zzdnu.mo31598m() || zzdnu.mo31599n()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof C9198Vo) {
                fqVar.mo28207a(zzdnu.mo31595d(), (Object) ((C9198Vo) entry).mo28662a().mo31622a());
            } else {
                fqVar.mo28207a(zzdnu.mo31595d(), entry.getValue());
            }
        }
        C9049Op<?, ?> op = this.f22813b;
        op.mo28492b(op.mo28496d(t), fqVar);
    }

    /* renamed from: a */
    public final void mo29084a(T t, byte[] bArr, int i, int i2, C9631oo ooVar) throws IOException {
        zzdob zzdob = (zzdob) t;
        zzdqu zzdqu = zzdob.zzhhd;
        if (zzdqu == zzdqu.m29974c()) {
            zzdqu = zzdqu.m29975d();
            zzdob.zzhhd = zzdqu;
        }
        zzc zzc = (zzc) t;
        if (zzc.zzhhj.mo28427c()) {
            zzc.zzhhj = (C8985Lo) zzc.zzhhj.clone();
        }
        C8985Lo<Object> lo = zzc.zzhhj;
        zzd zzd = null;
        while (i < i2) {
            int a = C9609no.m23962a(bArr, i, ooVar);
            int i3 = ooVar.f22846a;
            if (i3 == 11) {
                int i4 = 0;
                Object obj = null;
                while (a < i2) {
                    a = C9609no.m23962a(bArr, a, ooVar);
                    int i5 = ooVar.f22846a;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zzd != null) {
                                C9717sp.m24069a();
                                throw new NoSuchMethodError();
                            } else if (i7 == 2) {
                                a = C9609no.m23970e(bArr, a, ooVar);
                                obj = (zzdmr) ooVar.f22848c;
                            }
                        }
                    } else if (i7 == 0) {
                        a = C9609no.m23962a(bArr, a, ooVar);
                        i4 = ooVar.f22846a;
                        zzd = (zzd) this.f22815d.mo28358a(ooVar.f22849d, this.f22812a, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    a = C9609no.m23954a(i5, bArr, a, i2, ooVar);
                }
                if (obj != null) {
                    zzdqu.mo31648a((i4 << 3) | 2, obj);
                }
                i = a;
            } else if ((i3 & 7) == 2) {
                zzd = (zzd) this.f22815d.mo28358a(ooVar.f22849d, this.f22812a, i3 >>> 3);
                if (zzd == null) {
                    i = C9609no.m23956a(i3, bArr, a, i2, zzdqu, ooVar);
                } else {
                    C9717sp.m24069a();
                    throw new NoSuchMethodError();
                }
            } else {
                i = C9609no.m23954a(i3, bArr, a, i2, ooVar);
            }
        }
        if (i != i2) {
            throw zzdok.m29934g();
        }
    }

    /* renamed from: a */
    public final void mo29082a(T t, C9801wp wpVar, zzdno zzdno) throws IOException {
        boolean z;
        C9049Op<?, ?> op = this.f22813b;
        C8922Io<?> io = this.f22815d;
        Object e = op.mo28497e(t);
        C8985Lo c = io.mo28365c(t);
        do {
            try {
                if (wpVar.mo28157n() == Integer.MAX_VALUE) {
                    op.mo28493b((Object) t, e);
                    return;
                }
                int tag = wpVar.getTag();
                if (tag == 11) {
                    Object obj = null;
                    zzdmr zzdmr = null;
                    int i = 0;
                    while (wpVar.mo28157n() != Integer.MAX_VALUE) {
                        int tag2 = wpVar.getTag();
                        if (tag2 == 16) {
                            i = wpVar.mo28145h();
                            obj = io.mo28358a(zzdno, this.f22812a, i);
                        } else if (tag2 == 26) {
                            if (obj == null) {
                                zzdmr = wpVar.mo28161p();
                            } else {
                                io.mo28360a(wpVar, obj, zzdno, c);
                                throw null;
                            }
                        } else if (!wpVar.mo28160o()) {
                            break;
                        }
                    }
                    if (wpVar.getTag() == 12) {
                        if (zzdmr != null) {
                            if (obj == null) {
                                op.mo28484a(e, i, zzdmr);
                            } else {
                                io.mo28361a(zzdmr, obj, zzdno, c);
                                throw null;
                            }
                        }
                        z = true;
                        continue;
                    } else {
                        throw zzdok.m29932e();
                    }
                } else if ((tag & 7) == 2) {
                    Object a = io.mo28358a(zzdno, this.f22812a, tag >>> 3);
                    if (a == null) {
                        z = op.mo28489a(e, wpVar);
                        continue;
                    } else {
                        io.mo28360a(wpVar, a, zzdno, c);
                        throw null;
                    }
                } else {
                    z = wpVar.mo28160o();
                    continue;
                }
            } finally {
                op.mo28493b((Object) t, e);
            }
        } while (z);
    }

    /* renamed from: d */
    public final void mo29088d(T t) {
        this.f22813b.mo28481a((Object) t);
        this.f22815d.mo28362a((Object) t);
    }

    /* renamed from: c */
    public final boolean mo29087c(T t) {
        return this.f22815d.mo28364b(t).mo28429d();
    }

    /* renamed from: b */
    public final int mo29085b(T t) {
        C9049Op<?, ?> op = this.f22813b;
        int f = op.mo28498f(op.mo28496d(t)) + 0;
        if (this.f22814c) {
            return f + this.f22815d.mo28364b(t).mo28435i();
        }
        return f;
    }
}
