package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;

/* renamed from: com.google.android.gms.internal.ads.Os */
final class C9052Os implements zzqj, zzqk {

    /* renamed from: a */
    public final zzqj[] f21566a;

    /* renamed from: b */
    private final IdentityHashMap<zzqw, Integer> f21567b = new IdentityHashMap<>();

    /* renamed from: c */
    private zzqk f21568c;

    /* renamed from: d */
    private int f21569d;

    /* renamed from: e */
    private zzrb f21570e;

    /* renamed from: f */
    private zzqj[] f21571f;

    /* renamed from: g */
    private zzqx f21572g;

    public C9052Os(zzqj... zzqjArr) {
        this.f21566a = zzqjArr;
    }

    /* renamed from: a */
    public final void mo28290a(zzqk zzqk, long j) {
        this.f21568c = zzqk;
        zzqj[] zzqjArr = this.f21566a;
        this.f21569d = zzqjArr.length;
        for (zzqj a : zzqjArr) {
            a.mo28290a(this, j);
        }
    }

    /* renamed from: d */
    public final void mo28299d() throws IOException {
        for (zzqj d : this.f21566a) {
            d.mo28299d();
        }
    }

    /* renamed from: e */
    public final zzrb mo28300e() {
        return this.f21570e;
    }

    /* renamed from: a */
    public final long mo28286a(zzrm[] zzrmArr, boolean[] zArr, zzqw[] zzqwArr, boolean[] zArr2, long j) {
        int i;
        zzrm[] zzrmArr2 = zzrmArr;
        zzqw[] zzqwArr2 = zzqwArr;
        int[] iArr = new int[zzrmArr2.length];
        int[] iArr2 = new int[zzrmArr2.length];
        for (int i2 = 0; i2 < zzrmArr2.length; i2++) {
            if (zzqwArr2[i2] == null) {
                i = -1;
            } else {
                i = ((Integer) this.f21567b.get(zzqwArr2[i2])).intValue();
            }
            iArr[i2] = i;
            iArr2[i2] = -1;
            if (zzrmArr2[i2] != null) {
                zzra a = zzrmArr2[i2].mo32151a();
                int i3 = 0;
                while (true) {
                    zzqj[] zzqjArr = this.f21566a;
                    if (i3 >= zzqjArr.length) {
                        break;
                    } else if (zzqjArr[i3].mo28300e().mo32146a(a) != -1) {
                        iArr2[i2] = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        this.f21567b.clear();
        zzqw[] zzqwArr3 = new zzqw[zzrmArr2.length];
        zzqw[] zzqwArr4 = new zzqw[zzrmArr2.length];
        zzrm[] zzrmArr3 = new zzrm[zzrmArr2.length];
        ArrayList arrayList = new ArrayList(this.f21566a.length);
        long j2 = j;
        int i4 = 0;
        while (i4 < this.f21566a.length) {
            int i5 = 0;
            while (i5 < zzrmArr2.length) {
                zzrm zzrm = null;
                zzqwArr4[i5] = iArr[i5] == i4 ? zzqwArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    zzrm = zzrmArr2[i5];
                }
                zzrmArr3[i5] = zzrm;
                i5++;
            }
            ArrayList arrayList2 = arrayList;
            zzrm[] zzrmArr4 = zzrmArr3;
            int i6 = i4;
            long a2 = this.f21566a[i4].mo28286a(zzrmArr3, zArr, zzqwArr4, zArr2, j2);
            if (i6 == 0) {
                j2 = a2;
            } else if (a2 != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i7 = 0; i7 < zzrmArr2.length; i7++) {
                boolean z2 = true;
                if (iArr2[i7] == i6) {
                    zzsk.m31082b(zzqwArr4[i7] != null);
                    zzqwArr3[i7] = zzqwArr4[i7];
                    this.f21567b.put(zzqwArr4[i7], Integer.valueOf(i6));
                    z = true;
                } else if (iArr[i7] == i6) {
                    if (zzqwArr4[i7] != null) {
                        z2 = false;
                    }
                    zzsk.m31082b(z2);
                }
            }
            if (z) {
                arrayList2.add(this.f21566a[i6]);
            }
            i4 = i6 + 1;
            arrayList = arrayList2;
            zzrmArr3 = zzrmArr4;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zzqwArr3, 0, zzqwArr2, 0, zzqwArr3.length);
        this.f21571f = new zzqj[arrayList3.size()];
        arrayList3.toArray(this.f21571f);
        this.f21572g = new zzpy(this.f21571f);
        return j2;
    }

    /* renamed from: c */
    public final void mo28298c(long j) {
        for (zzqj c : this.f21571f) {
            c.mo28298c(j);
        }
    }

    /* renamed from: b */
    public final boolean mo28296b(long j) {
        return this.f21572g.mo28296b(j);
    }

    /* renamed from: c */
    public final long mo28297c() {
        return this.f21572g.mo28297c();
    }

    /* renamed from: a */
    public final long mo28284a() {
        long a = this.f21566a[0].mo28284a();
        int i = 1;
        while (true) {
            zzqj[] zzqjArr = this.f21566a;
            if (i >= zzqjArr.length) {
                if (a != -9223372036854775807L) {
                    zzqj[] zzqjArr2 = this.f21571f;
                    int length = zzqjArr2.length;
                    int i2 = 0;
                    while (i2 < length) {
                        zzqj zzqj = zzqjArr2[i2];
                        if (zzqj == this.f21566a[0] || zzqj.mo28285a(a) == a) {
                            i2++;
                        } else {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return a;
            } else if (zzqjArr[i].mo28284a() == -9223372036854775807L) {
                i++;
            } else {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
    }

    /* renamed from: b */
    public final long mo28294b() {
        long j = Long.MAX_VALUE;
        for (zzqj b : this.f21571f) {
            long b2 = b.mo28294b();
            if (b2 != Long.MIN_VALUE) {
                j = Math.min(j, b2);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    /* renamed from: a */
    public final long mo28285a(long j) {
        long a = this.f21571f[0].mo28285a(j);
        int i = 1;
        while (true) {
            zzqj[] zzqjArr = this.f21571f;
            if (i >= zzqjArr.length) {
                return a;
            }
            if (zzqjArr[i].mo28285a(a) == a) {
                i++;
            } else {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
    }

    /* renamed from: a */
    public final void mo28511a(zzqj zzqj) {
        int i = this.f21569d - 1;
        this.f21569d = i;
        if (i <= 0) {
            int i2 = 0;
            for (zzqj e : this.f21566a) {
                i2 += e.mo28300e().f29216b;
            }
            zzra[] zzraArr = new zzra[i2];
            zzqj[] zzqjArr = this.f21566a;
            int length = zzqjArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                zzrb e2 = zzqjArr[i3].mo28300e();
                int i5 = e2.f29216b;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    int i8 = i6 + 1;
                    zzraArr[i6] = e2.mo32147a(i7);
                    i7++;
                    i6 = i8;
                }
                i3++;
                i4 = i6;
            }
            this.f21570e = new zzrb(zzraArr);
            this.f21568c.mo28511a(this);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28512a(zzqx zzqx) {
        if (this.f21570e != null) {
            this.f21568c.mo28512a(this);
        }
    }
}
