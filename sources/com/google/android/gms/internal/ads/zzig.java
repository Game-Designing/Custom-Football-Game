package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.SystemClock;
import android.util.SparseArray;
import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class zzig implements zzhn, zzif, zzka {

    /* renamed from: A */
    private IOException f28584A;

    /* renamed from: B */
    private boolean f28585B;

    /* renamed from: C */
    private int f28586C;

    /* renamed from: D */
    private long f28587D;

    /* renamed from: E */
    private boolean f28588E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public int f28589F;

    /* renamed from: G */
    private int f28590G;

    /* renamed from: a */
    private final zzid f28591a;

    /* renamed from: b */
    private final zzjr f28592b;

    /* renamed from: c */
    private final int f28593c;

    /* renamed from: d */
    private final SparseArray<C9326ar> f28594d;

    /* renamed from: e */
    private final int f28595e;

    /* renamed from: f */
    private final boolean f28596f;

    /* renamed from: g */
    private final Uri f28597g;

    /* renamed from: h */
    private final zzjp f28598h;

    /* renamed from: i */
    private volatile boolean f28599i;

    /* renamed from: j */
    private volatile zzio f28600j;

    /* renamed from: k */
    private volatile zzhw f28601k;

    /* renamed from: l */
    private boolean f28602l;

    /* renamed from: m */
    private int f28603m;

    /* renamed from: n */
    private zzho[] f28604n;

    /* renamed from: o */
    private long f28605o;

    /* renamed from: p */
    private boolean[] f28606p;

    /* renamed from: q */
    private boolean[] f28607q;

    /* renamed from: r */
    private boolean[] f28608r;

    /* renamed from: s */
    private int f28609s;

    /* renamed from: t */
    private long f28610t;

    /* renamed from: u */
    private long f28611u;

    /* renamed from: v */
    private long f28612v;

    /* renamed from: w */
    private boolean f28613w;

    /* renamed from: x */
    private long f28614x;

    /* renamed from: y */
    private zzjz f28615y;

    /* renamed from: z */
    private C9304_q f28616z;

    public zzig(Uri uri, zzjp zzjp, zzid zzid, int i, int i2) {
        this(uri, zzjp, zzid, 2, i2, -1);
    }

    private zzig(Uri uri, zzjp zzjp, zzid zzid, int i, int i2, int i3) {
        this.f28597g = uri;
        this.f28598h = zzjp;
        this.f28591a = zzid;
        this.f28609s = 2;
        this.f28593c = i2;
        this.f28595e = -1;
        this.f28594d = new SparseArray<>();
        this.f28592b = new zzjr(Opcodes.ASM4);
        this.f28612v = -1;
        this.f28596f = true;
        zzid.mo31857a(this);
    }

    /* renamed from: b */
    public final boolean mo31774b(long j) throws IOException {
        boolean z;
        if (this.f28602l) {
            return true;
        }
        if (this.f28615y == null) {
            this.f28615y = new zzjz("Loader:ExtractorSampleSource");
        }
        m30449d();
        if (this.f28600j != null && this.f28599i) {
            int i = 0;
            while (true) {
                if (i >= this.f28594d.size()) {
                    z = true;
                    break;
                } else if (!((C9326ar) this.f28594d.valueAt(i)).mo31852c()) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                int size = this.f28594d.size();
                this.f28608r = new boolean[size];
                this.f28607q = new boolean[size];
                this.f28606p = new boolean[size];
                this.f28604n = new zzho[size];
                this.f28605o = -1;
                for (int i2 = 0; i2 < size; i2++) {
                    zzhj d = ((C9326ar) this.f28594d.valueAt(i2)).mo31853d();
                    this.f28604n[i2] = new zzho(d.f28509a, d.f28511c);
                    long j2 = d.f28511c;
                    if (j2 != -1 && j2 > this.f28605o) {
                        this.f28605o = j2;
                    }
                }
                this.f28602l = true;
                return true;
            }
        }
        m30451g();
        return false;
    }

    /* renamed from: c */
    public final int mo31775c() {
        return this.f28594d.size();
    }

    /* renamed from: a */
    public final zzho mo31769a(int i) {
        zzkh.m30537b(this.f28602l);
        return this.f28604n[i];
    }

    /* renamed from: c */
    public final void mo31776c(int i, long j) {
        zzkh.m30537b(this.f28602l);
        zzkh.m30537b(!this.f28608r[i]);
        this.f28603m++;
        this.f28608r[i] = true;
        this.f28606p[i] = true;
        if (this.f28603m == 1) {
            mo31771a(j);
        }
    }

    /* renamed from: b */
    public final void mo31773b(int i) {
        zzkh.m30537b(this.f28602l);
        zzkh.m30537b(this.f28608r[i]);
        this.f28603m--;
        this.f28608r[i] = false;
        this.f28607q[i] = false;
        if (this.f28603m == 0) {
            if (this.f28615y.mo31880a()) {
                this.f28615y.mo31882c();
            } else {
                m30453i();
                this.f28592b.mo31878b(0);
            }
        }
    }

    /* renamed from: c */
    public final boolean mo31777c(long j) throws IOException {
        zzkh.m30537b(this.f28602l);
        zzkh.m30537b(this.f28603m > 0);
        this.f28610t = j;
        long j2 = this.f28610t;
        int i = 0;
        while (true) {
            boolean[] zArr = this.f28608r;
            if (i >= zArr.length) {
                break;
            }
            if (!zArr[i]) {
                ((C9326ar) this.f28594d.valueAt(i)).mo31846a(j2);
            }
            i++;
        }
        return this.f28588E || m30449d();
    }

    /* renamed from: a */
    public final int mo31768a(int i, long j, zzhk zzhk, zzhm zzhm, boolean z) throws IOException {
        this.f28610t = j;
        boolean[] zArr = this.f28607q;
        int i2 = 0;
        if (zArr[i]) {
            zArr[i] = false;
            return -5;
        } else if (z || m30454j()) {
            m30451g();
            return -2;
        } else {
            C9326ar arVar = (C9326ar) this.f28594d.valueAt(i);
            if (this.f28606p[i]) {
                zzhk.f28522a = arVar.mo31853d();
                zzhk.f28523b = this.f28601k;
                this.f28606p[i] = false;
                return -4;
            } else if (arVar.mo31849a(zzhm)) {
                boolean z2 = this.f28596f && zzhm.f28528e < this.f28611u;
                int i3 = zzhm.f28527d;
                if (z2) {
                    i2 = 134217728;
                }
                zzhm.f28527d = i3 | i2;
                zzhm.f28528e += this.f28614x;
                return -3;
            } else if (this.f28588E) {
                return -1;
            } else {
                m30451g();
                return -2;
            }
        }
    }

    /* renamed from: a */
    public final void mo31771a(long j) {
        zzkh.m30537b(this.f28602l);
        int i = 0;
        zzkh.m30537b(this.f28603m > 0);
        this.f28600j.mo31839c();
        this.f28611u = j;
        if ((m30454j() ? this.f28612v : this.f28610t) != j) {
            this.f28610t = j;
            boolean z = !m30454j();
            int i2 = 0;
            while (z && i2 < this.f28594d.size()) {
                z &= ((C9326ar) this.f28594d.valueAt(i2)).mo31851b(j);
                i2++;
            }
            if (!z) {
                m30448d(j);
            }
            while (true) {
                boolean[] zArr = this.f28607q;
                if (i < zArr.length) {
                    zArr[i] = true;
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    public final long mo31772b() {
        if (this.f28588E) {
            return -3;
        }
        if (m30454j()) {
            return this.f28612v;
        }
        long j = Long.MIN_VALUE;
        for (int i = 0; i < this.f28594d.size(); i++) {
            j = Math.max(j, ((C9326ar) this.f28594d.valueAt(i)).mo31854e());
        }
        if (j == Long.MIN_VALUE) {
            return this.f28610t;
        }
        return j;
    }

    /* renamed from: a */
    public final void mo31770a() {
        zzkh.m30537b(this.f28609s > 0);
        int i = this.f28609s - 1;
        this.f28609s = i;
        if (i == 0) {
            zzjz zzjz = this.f28615y;
            if (zzjz != null) {
                zzjz.mo31881b();
                this.f28615y = null;
            }
        }
    }

    /* renamed from: a */
    public final void mo31862a(zzkc zzkc) {
        this.f28588E = true;
    }

    /* renamed from: b */
    public final void mo31864b(zzkc zzkc) {
        if (this.f28603m > 0) {
            m30448d(this.f28612v);
            return;
        }
        m30453i();
        this.f28592b.mo31878b(0);
    }

    /* renamed from: a */
    public final void mo31863a(zzkc zzkc, IOException iOException) {
        this.f28584A = iOException;
        int i = 1;
        if (this.f28589F <= this.f28590G) {
            i = 1 + this.f28586C;
        }
        this.f28586C = i;
        this.f28587D = SystemClock.elapsedRealtime();
        m30450e();
    }

    /* renamed from: c */
    public final zzip mo31860c(int i) {
        C9326ar arVar = (C9326ar) this.f28594d.get(i);
        if (arVar != null) {
            return arVar;
        }
        C9326ar arVar2 = new C9326ar(this, this.f28592b);
        this.f28594d.put(i, arVar2);
        return arVar2;
    }

    /* renamed from: f */
    public final void mo31861f() {
        this.f28599i = true;
    }

    /* renamed from: a */
    public final void mo31859a(zzio zzio) {
        this.f28600j = zzio;
    }

    /* renamed from: a */
    public final void mo31858a(zzhw zzhw) {
        this.f28601k = zzhw;
    }

    /* renamed from: d */
    private final boolean m30449d() throws IOException {
        boolean z;
        m30450e();
        boolean z2 = false;
        if (m30454j()) {
            return false;
        }
        if (this.f28602l) {
            int i = 0;
            while (true) {
                boolean[] zArr = this.f28608r;
                if (i < zArr.length) {
                    if (zArr[i] && !((C9326ar) this.f28594d.valueAt(i)).mo31850b()) {
                        z = true;
                        break;
                    }
                    i++;
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                z2 = true;
            }
        }
        if (!z2) {
            m30451g();
        }
        return z2;
    }

    /* renamed from: d */
    private final void m30448d(long j) {
        this.f28612v = j;
        this.f28588E = false;
        if (this.f28615y.mo31880a()) {
            this.f28615y.mo31882c();
            return;
        }
        m30453i();
        m30450e();
    }

    /* renamed from: e */
    private final void m30450e() {
        if (!this.f28588E && !this.f28615y.mo31880a()) {
            boolean z = true;
            if (this.f28584A != null) {
                if (this.f28616z == null) {
                    z = false;
                }
                zzkh.m30537b(z);
                if (SystemClock.elapsedRealtime() - this.f28587D >= Math.min((((long) this.f28586C) - 1) * 1000, 5000)) {
                    this.f28584A = null;
                    if (!this.f28602l) {
                        for (int i = 0; i < this.f28594d.size(); i++) {
                            ((C9326ar) this.f28594d.valueAt(i)).mo31845a();
                        }
                        this.f28616z = m30452h();
                    } else {
                        this.f28600j.mo31839c();
                    }
                    this.f28590G = this.f28589F;
                    this.f28615y.mo31879a((zzkc) this.f28616z, (zzka) this);
                }
                return;
            }
            this.f28614x = 0;
            this.f28613w = false;
            if (!this.f28602l) {
                this.f28616z = m30452h();
            } else {
                zzkh.m30537b(m30454j());
                long j = this.f28605o;
                if (j == -1 || this.f28612v < j) {
                    C9304_q _qVar = new C9304_q(this.f28597g, this.f28598h, this.f28591a, this.f28592b, this.f28593c, this.f28600j.mo31838a(this.f28612v));
                    this.f28616z = _qVar;
                    this.f28612v = -1;
                } else {
                    this.f28588E = true;
                    this.f28612v = -1;
                    return;
                }
            }
            this.f28590G = this.f28589F;
            this.f28615y.mo31879a((zzkc) this.f28616z, (zzka) this);
        }
    }

    /* renamed from: g */
    private final void m30451g() throws IOException {
        if (this.f28584A != null) {
            int i = this.f28595e;
            if (i == -1) {
                if (this.f28600j != null) {
                    this.f28600j.mo31839c();
                }
                i = 3;
            }
            if (this.f28586C > i) {
                throw this.f28584A;
            }
        }
    }

    /* renamed from: h */
    private final C9304_q m30452h() {
        C9304_q _qVar = new C9304_q(this.f28597g, this.f28598h, this.f28591a, this.f28592b, this.f28593c, 0);
        return _qVar;
    }

    /* renamed from: i */
    private final void m30453i() {
        for (int i = 0; i < this.f28594d.size(); i++) {
            ((C9326ar) this.f28594d.valueAt(i)).mo31845a();
        }
        this.f28616z = null;
        this.f28584A = null;
        this.f28586C = 0;
        this.f28585B = false;
    }

    /* renamed from: j */
    private final boolean m30454j() {
        return this.f28612v != -1;
    }
}
