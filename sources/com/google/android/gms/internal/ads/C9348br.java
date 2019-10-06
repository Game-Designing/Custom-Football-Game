package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;

/* renamed from: com.google.android.gms.internal.ads.br */
final class C9348br {

    /* renamed from: a */
    private final zzjl f22133a;

    /* renamed from: b */
    private final int f22134b;

    /* renamed from: c */
    private final C9392dr f22135c = new C9392dr();

    /* renamed from: d */
    private final LinkedBlockingDeque<zzjk> f22136d = new LinkedBlockingDeque<>();

    /* renamed from: e */
    private final C9414er f22137e = new C9414er();

    /* renamed from: f */
    private final zzkm f22138f = new zzkm(32);

    /* renamed from: g */
    private long f22139g;

    /* renamed from: h */
    private long f22140h;

    /* renamed from: i */
    private zzjk f22141i;

    /* renamed from: j */
    private int f22142j = this.f22134b;

    public C9348br(zzjl zzjl) {
        this.f22133a = zzjl;
        this.f22134b = zzjl.mo31873a();
    }

    /* renamed from: a */
    public final void mo28877a() {
        this.f22135c.mo28915a();
        while (!this.f22136d.isEmpty()) {
            this.f22133a.mo31874a((zzjk) this.f22136d.remove());
        }
        this.f22139g = 0;
        this.f22140h = 0;
        this.f22141i = null;
        this.f22142j = this.f22134b;
    }

    /* renamed from: a */
    public final boolean mo28881a(zzhm zzhm) {
        return this.f22135c.mo28917a(zzhm, this.f22137e);
    }

    /* renamed from: b */
    public final void mo28882b() {
        m23474b(this.f22135c.mo28918b());
    }

    /* renamed from: a */
    public final boolean mo28880a(long j) {
        long a = this.f22135c.mo28914a(j);
        if (a == -1) {
            return false;
        }
        m23474b(a);
        return true;
    }

    /* renamed from: b */
    public final boolean mo28883b(zzhm zzhm) {
        int i;
        int[] iArr;
        int[] iArr2;
        if (!this.f22135c.mo28917a(zzhm, this.f22137e)) {
            return false;
        }
        if (zzhm.mo31810a()) {
            C9414er erVar = this.f22137e;
            long j = erVar.f22225a;
            m23473a(j, this.f22138f.f28743a, 1);
            long j2 = j + 1;
            byte b = this.f22138f.f28743a[0];
            boolean z = (b & 128) != 0;
            byte b2 = b & Byte.MAX_VALUE;
            zzgb zzgb = zzhm.f28524a;
            if (zzgb.f28425a == null) {
                zzgb.f28425a = new byte[16];
            }
            m23473a(j2, zzhm.f28524a.f28425a, b2);
            long j3 = j2 + ((long) b2);
            if (z) {
                m23473a(j3, this.f22138f.f28743a, 2);
                j3 += 2;
                this.f22138f.mo31890a(0);
                i = this.f22138f.mo31898f();
            } else {
                i = 1;
            }
            int[] iArr3 = zzhm.f28524a.f28428d;
            if (iArr3 == null || iArr3.length < i) {
                iArr = new int[i];
            } else {
                iArr = iArr3;
            }
            int[] iArr4 = zzhm.f28524a.f28429e;
            if (iArr4 == null || iArr4.length < i) {
                iArr2 = new int[i];
            } else {
                iArr2 = iArr4;
            }
            if (z) {
                int i2 = i * 6;
                zzkm zzkm = this.f22138f;
                if (zzkm.mo31893b() < i2) {
                    zzkm.mo31891a(new byte[i2], i2);
                }
                m23473a(j3, this.f22138f.f28743a, i2);
                j3 += (long) i2;
                this.f22138f.mo31890a(0);
                for (int i3 = 0; i3 < i; i3++) {
                    iArr[i3] = this.f22138f.mo31898f();
                    iArr2[i3] = this.f22138f.mo31901i();
                }
            } else {
                iArr[0] = 0;
                iArr2[0] = zzhm.f28526c - ((int) (j3 - erVar.f22225a));
            }
            zzgb zzgb2 = zzhm.f28524a;
            zzgb2.mo31765a(i, iArr, iArr2, erVar.f22226b, zzgb2.f28425a, 1);
            long j4 = erVar.f22225a;
            int i4 = (int) (j3 - j4);
            erVar.f22225a = j4 + ((long) i4);
            zzhm.f28526c -= i4;
        }
        ByteBuffer byteBuffer = zzhm.f28525b;
        if (byteBuffer == null || byteBuffer.capacity() < zzhm.f28526c) {
            int i5 = zzhm.f28526c;
        }
        ByteBuffer byteBuffer2 = zzhm.f28525b;
        if (byteBuffer2 != null) {
            long j5 = this.f22137e.f22225a;
            int i6 = zzhm.f28526c;
            while (i6 > 0) {
                m23474b(j5);
                int i7 = (int) (j5 - this.f22139g);
                int min = Math.min(i6, this.f22134b - i7);
                byteBuffer2.put(((zzjk) this.f22136d.peek()).f28679a, i7 + 0, min);
                j5 += (long) min;
                i6 -= min;
            }
        }
        m23474b(this.f22135c.mo28918b());
        return true;
    }

    /* renamed from: a */
    private final void m23473a(long j, byte[] bArr, int i) {
        long j2 = j;
        int i2 = 0;
        while (i2 < i) {
            m23474b(j2);
            int i3 = (int) (j2 - this.f22139g);
            int min = Math.min(i - i2, this.f22134b - i3);
            System.arraycopy(((zzjk) this.f22136d.peek()).f28679a, i3 + 0, bArr, i2, min);
            j2 += (long) min;
            i2 += min;
        }
    }

    /* renamed from: b */
    private final void m23474b(long j) {
        int i = ((int) (j - this.f22139g)) / this.f22134b;
        for (int i2 = 0; i2 < i; i2++) {
            this.f22133a.mo31874a((zzjk) this.f22136d.remove());
            this.f22139g += (long) this.f22134b;
        }
    }

    /* renamed from: c */
    public final long mo28884c() {
        return this.f22140h;
    }

    /* renamed from: a */
    public final int mo28876a(zzie zzie, int i) throws IOException, InterruptedException {
        m23475d();
        int min = Math.min(i, this.f22134b - this.f22142j);
        zzie.readFully(this.f22141i.f28679a, this.f22142j + 0, min);
        this.f22142j += min;
        this.f22140h += (long) min;
        return min;
    }

    /* renamed from: a */
    public final void mo28879a(zzkm zzkm, int i) {
        int i2 = i;
        while (i2 > 0) {
            m23475d();
            int min = Math.min(i2, this.f22134b - this.f22142j);
            zzkm.mo31892a(this.f22141i.f28679a, this.f22142j + 0, min);
            this.f22142j += min;
            i2 -= min;
        }
        this.f22140h += (long) i;
    }

    /* renamed from: a */
    public final void mo28878a(long j, int i, long j2, int i2, byte[] bArr) {
        this.f22135c.mo28916a(j, i, j2, i2, bArr);
    }

    /* renamed from: d */
    private final void m23475d() {
        if (this.f22142j == this.f22134b) {
            this.f22142j = 0;
            this.f22141i = this.f22133a.mo31875b();
            this.f22136d.add(this.f22141i);
        }
    }
}
