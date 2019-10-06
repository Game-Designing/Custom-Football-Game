package com.google.android.gms.internal.ads;

import android.support.p001v7.widget.LinearLayoutManager;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzqt implements zznw {

    /* renamed from: a */
    private final zzrt f29176a;

    /* renamed from: b */
    private final int f29177b;

    /* renamed from: c */
    private final C9094Qs f29178c = new C9094Qs();

    /* renamed from: d */
    private final zzqs f29179d = new zzqs();

    /* renamed from: e */
    private final zzst f29180e = new zzst(32);

    /* renamed from: f */
    private final AtomicInteger f29181f = new AtomicInteger();

    /* renamed from: g */
    private C9114Rs f29182g;

    /* renamed from: h */
    private C9114Rs f29183h;

    /* renamed from: i */
    private zzlh f29184i;

    /* renamed from: j */
    private boolean f29185j;

    /* renamed from: k */
    private zzlh f29186k;

    /* renamed from: l */
    private long f29187l;

    /* renamed from: m */
    private int f29188m;

    /* renamed from: n */
    private zzqv f29189n;

    public zzqt(zzrt zzrt) {
        this.f29176a = zzrt;
        this.f29177b = zzrt.mo32170a();
        int i = this.f29177b;
        this.f29188m = i;
        this.f29182g = new C9114Rs(0, i);
        this.f29183h = this.f29182g;
    }

    /* renamed from: a */
    public final void mo32112a(boolean z) {
        int andSet = this.f29181f.getAndSet(z ? 0 : 2);
        m30954g();
        this.f29178c.mo28557c();
        if (andSet == 2) {
            this.f29184i = null;
        }
    }

    /* renamed from: c */
    public final int mo32115c() {
        return this.f29178c.mo28558d();
    }

    /* renamed from: a */
    public final void mo32110a() {
        if (this.f29181f.getAndSet(2) == 0) {
            m30954g();
        }
    }

    /* renamed from: d */
    public final boolean mo32116d() {
        return this.f29178c.mo28559e();
    }

    /* renamed from: e */
    public final zzlh mo32117e() {
        return this.f29178c.mo28560f();
    }

    /* renamed from: b */
    public final long mo32114b() {
        return this.f29178c.mo28551a();
    }

    /* renamed from: f */
    public final void mo32118f() {
        long g = this.f29178c.mo28561g();
        if (g != -1) {
            m30952a(g);
        }
    }

    /* renamed from: a */
    public final boolean mo32113a(long j, boolean z) {
        long a = this.f29178c.mo28552a(j, z);
        if (a == -1) {
            return false;
        }
        m30952a(a);
        return true;
    }

    /* renamed from: a */
    public final int mo32109a(zzlj zzlj, zznd zznd, boolean z, boolean z2, long j) {
        int i;
        int[] iArr;
        int[] iArr2;
        zznd zznd2 = zznd;
        int a = this.f29178c.mo28550a(zzlj, zznd, z, z2, this.f29184i, this.f29179d);
        if (a == -5) {
            this.f29184i = zzlj.f28805a;
            return -5;
        } else if (a == -4) {
            if (!zznd.mo32016c()) {
                if (zznd2.f28952d < j) {
                    zznd2.mo32014b(LinearLayoutManager.INVALID_OFFSET);
                }
                if (zznd.mo32025e()) {
                    zzqs zzqs = this.f29179d;
                    long j2 = zzqs.f29173b;
                    this.f29180e.mo32195a(1);
                    m30953a(j2, this.f29180e.f29334a, 1);
                    long j3 = j2 + 1;
                    byte b = this.f29180e.f29334a[0];
                    boolean z3 = (b & 128) != 0;
                    byte b2 = b & Byte.MAX_VALUE;
                    zzmz zzmz = zznd2.f28950b;
                    if (zzmz.f28928a == null) {
                        zzmz.f28928a = new byte[16];
                    }
                    m30953a(j3, zznd2.f28950b.f28928a, (int) b2);
                    long j4 = j3 + ((long) b2);
                    if (z3) {
                        this.f29180e.mo32195a(2);
                        m30953a(j4, this.f29180e.f29334a, 2);
                        j4 += 2;
                        i = this.f29180e.mo32208h();
                    } else {
                        i = 1;
                    }
                    int[] iArr3 = zznd2.f28950b.f28931d;
                    if (iArr3 == null || iArr3.length < i) {
                        iArr = new int[i];
                    } else {
                        iArr = iArr3;
                    }
                    int[] iArr4 = zznd2.f28950b.f28932e;
                    if (iArr4 == null || iArr4.length < i) {
                        iArr2 = new int[i];
                    } else {
                        iArr2 = iArr4;
                    }
                    if (z3) {
                        int i2 = i * 6;
                        this.f29180e.mo32195a(i2);
                        m30953a(j4, this.f29180e.f29334a, i2);
                        j4 += (long) i2;
                        this.f29180e.mo32199b(0);
                        for (int i3 = 0; i3 < i; i3++) {
                            iArr[i3] = this.f29180e.mo32208h();
                            iArr2[i3] = this.f29180e.mo32212l();
                        }
                    } else {
                        iArr[0] = 0;
                        iArr2[0] = zzqs.f29172a - ((int) (j4 - zzqs.f29173b));
                    }
                    zznx zznx = zzqs.f29175d;
                    zzmz zzmz2 = zznd2.f28950b;
                    zzmz2.mo32020a(i, iArr, iArr2, zznx.f28982b, zzmz2.f28928a, zznx.f28981a);
                    long j5 = zzqs.f29173b;
                    int i4 = (int) (j4 - j5);
                    zzqs.f29173b = j5 + ((long) i4);
                    zzqs.f29172a -= i4;
                }
                zznd2.mo32024d(this.f29179d.f29172a);
                zzqs zzqs2 = this.f29179d;
                long j6 = zzqs2.f29173b;
                ByteBuffer byteBuffer = zznd2.f28951c;
                int i5 = zzqs2.f29172a;
                m30952a(j6);
                while (i5 > 0) {
                    int i6 = (int) (j6 - this.f29182g.f21680a);
                    int min = Math.min(i5, this.f29177b - i6);
                    zzrs zzrs = this.f29182g.f21683d;
                    byteBuffer.put(zzrs.f29261a, zzrs.mo32169a(i6), min);
                    j6 += (long) min;
                    i5 -= min;
                    if (j6 == this.f29182g.f21681b) {
                        this.f29176a.mo32171a(zzrs);
                        this.f29182g = this.f29182g.mo28578a();
                    }
                }
                m30952a(this.f29179d.f29174c);
            }
            return -4;
        } else if (a == -3) {
            return -3;
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    private final void m30953a(long j, byte[] bArr, int i) {
        m30952a(j);
        int i2 = 0;
        while (i2 < i) {
            int i3 = (int) (j - this.f29182g.f21680a);
            int min = Math.min(i - i2, this.f29177b - i3);
            zzrs zzrs = this.f29182g.f21683d;
            System.arraycopy(zzrs.f29261a, zzrs.mo32169a(i3), bArr, i2, min);
            j += (long) min;
            i2 += min;
            if (j == this.f29182g.f21681b) {
                this.f29176a.mo32171a(zzrs);
                this.f29182g = this.f29182g.mo28578a();
            }
        }
    }

    /* renamed from: a */
    private final void m30952a(long j) {
        while (true) {
            C9114Rs rs = this.f29182g;
            if (j >= rs.f21681b) {
                this.f29176a.mo32171a(rs.f21683d);
                this.f29182g = this.f29182g.mo28578a();
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public final void mo32111a(zzqv zzqv) {
        this.f29189n = zzqv;
    }

    /* renamed from: a */
    public final void mo32063a(zzlh zzlh) {
        zzlh zzlh2;
        if (zzlh == null) {
            zzlh2 = null;
        } else {
            zzlh2 = zzlh;
        }
        boolean a = this.f29178c.mo28555a(zzlh2);
        this.f29186k = zzlh;
        this.f29185j = false;
        zzqv zzqv = this.f29189n;
        if (zzqv != null && a) {
            zzqv.mo28288a(zzlh2);
        }
    }

    /* renamed from: a */
    public final int mo32061a(zzno zzno, int i, boolean z) throws IOException, InterruptedException {
        if (!m30955h()) {
            int b = zzno.mo32048b(i);
            if (b != -1) {
                return b;
            }
            throw new EOFException();
        }
        try {
            int a = m30951a(i);
            zzrs zzrs = this.f29183h.f21683d;
            int read = zzno.read(zzrs.f29261a, zzrs.mo32169a(this.f29188m), a);
            if (read != -1) {
                this.f29188m += read;
                this.f29187l += (long) read;
                return read;
            }
            throw new EOFException();
        } finally {
            m30956i();
        }
    }

    /* renamed from: a */
    public final void mo32064a(zzst zzst, int i) {
        if (!m30955h()) {
            zzst.mo32201c(i);
            return;
        }
        while (i > 0) {
            int a = m30951a(i);
            zzrs zzrs = this.f29183h.f21683d;
            zzst.mo32197a(zzrs.f29261a, zzrs.mo32169a(this.f29188m), a);
            this.f29188m += a;
            this.f29187l += (long) a;
            i -= a;
        }
        m30956i();
    }

    /* renamed from: a */
    public final void mo32062a(long j, int i, int i2, int i3, zznx zznx) {
        if (!m30955h()) {
            long j2 = j;
            this.f29178c.mo28553a(j);
            return;
        }
        long j3 = j;
        try {
            this.f29178c.mo28554a(j, i, this.f29187l - ((long) i2), i2, zznx);
        } finally {
            m30956i();
        }
    }

    /* renamed from: h */
    private final boolean m30955h() {
        return this.f29181f.compareAndSet(0, 1);
    }

    /* renamed from: i */
    private final void m30956i() {
        if (!this.f29181f.compareAndSet(1, 0)) {
            m30954g();
        }
    }

    /* renamed from: g */
    private final void m30954g() {
        this.f29178c.mo28556b();
        C9114Rs rs = this.f29182g;
        if (rs.f21682c) {
            C9114Rs rs2 = this.f29183h;
            boolean z = rs2.f21682c;
            zzrs[] zzrsArr = new zzrs[((z ? 1 : 0) + (((int) (rs2.f21680a - rs.f21680a)) / this.f29177b))];
            for (int i = 0; i < zzrsArr.length; i++) {
                zzrsArr[i] = rs.f21683d;
                rs = rs.mo28578a();
            }
            this.f29176a.mo32172a(zzrsArr);
        }
        this.f29182g = new C9114Rs(0, this.f29177b);
        this.f29183h = this.f29182g;
        this.f29187l = 0;
        this.f29188m = this.f29177b;
        this.f29176a.mo32174c();
    }

    /* renamed from: a */
    private final int m30951a(int i) {
        if (this.f29188m == this.f29177b) {
            this.f29188m = 0;
            C9114Rs rs = this.f29183h;
            if (rs.f21682c) {
                this.f29183h = rs.f21684e;
            }
            C9114Rs rs2 = this.f29183h;
            zzrs b = this.f29176a.mo32173b();
            C9114Rs rs3 = new C9114Rs(this.f29183h.f21681b, this.f29177b);
            rs2.f21683d = b;
            rs2.f21684e = rs3;
            rs2.f21682c = true;
        }
        return Math.min(i, this.f29177b - this.f29188m);
    }
}
