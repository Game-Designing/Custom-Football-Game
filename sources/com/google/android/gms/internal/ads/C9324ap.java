package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.ads.ap */
final class C9324ap extends C9565lo<Long> implements zzdoj<Long>, C9696rp, RandomAccess {

    /* renamed from: b */
    private static final C9324ap f22098b;

    /* renamed from: c */
    private long[] f22099c;

    /* renamed from: d */
    private int f22100d;

    C9324ap() {
        this(new long[10], 0);
    }

    private C9324ap(long[] jArr, int i) {
        this.f22099c = jArr;
        this.f22100d = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        mo29061a();
        if (i2 >= i) {
            long[] jArr = this.f22099c;
            System.arraycopy(jArr, i2, jArr, i, this.f22100d - i2);
            this.f22100d -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9324ap)) {
            return super.equals(obj);
        }
        C9324ap apVar = (C9324ap) obj;
        if (this.f22100d != apVar.f22100d) {
            return false;
        }
        long[] jArr = apVar.f22099c;
        for (int i = 0; i < this.f22100d; i++) {
            if (this.f22099c[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f22100d; i2++) {
            i = (i * 31) + zzdod.m29912a(this.f22099c[i2]);
        }
        return i;
    }

    /* renamed from: a */
    public final long mo28855a(int i) {
        m23449h(i);
        return this.f22099c[i];
    }

    public final int size() {
        return this.f22100d;
    }

    /* renamed from: a */
    public final void mo28856a(long j) {
        m23448a(this.f22100d, j);
    }

    /* renamed from: a */
    private final void m23448a(int i, long j) {
        mo29061a();
        if (i >= 0) {
            int i2 = this.f22100d;
            if (i <= i2) {
                long[] jArr = this.f22099c;
                if (i2 < jArr.length) {
                    System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
                } else {
                    long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(jArr, 0, jArr2, 0, i);
                    System.arraycopy(this.f22099c, i, jArr2, i + 1, this.f22100d - i);
                    this.f22099c = jArr2;
                }
                this.f22099c[i] = j;
                this.f22100d++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(m23450i(i));
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        mo29061a();
        zzdod.m29915a(collection);
        if (!(collection instanceof C9324ap)) {
            return super.addAll(collection);
        }
        C9324ap apVar = (C9324ap) collection;
        int i = apVar.f22100d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f22100d;
        if (MoPubClientPositioning.NO_REPEAT - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.f22099c;
            if (i3 > jArr.length) {
                this.f22099c = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(apVar.f22099c, 0, this.f22099c, this.f22100d, apVar.f22100d);
            this.f22100d = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        mo29061a();
        for (int i = 0; i < this.f22100d; i++) {
            if (obj.equals(Long.valueOf(this.f22099c[i]))) {
                long[] jArr = this.f22099c;
                System.arraycopy(jArr, i + 1, jArr, i, (this.f22100d - i) - 1);
                this.f22100d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    private final void m23449h(int i) {
        if (i < 0 || i >= this.f22100d) {
            throw new IndexOutOfBoundsException(m23450i(i));
        }
    }

    /* renamed from: i */
    private final String m23450i(int i) {
        int i2 = this.f22100d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        mo29061a();
        m23449h(i);
        long[] jArr = this.f22099c;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i) {
        mo29061a();
        m23449h(i);
        long[] jArr = this.f22099c;
        long j = jArr[i];
        int i2 = this.f22100d;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.f22100d--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        m23448a(i, ((Long) obj).longValue());
    }

    /* renamed from: b */
    public final /* synthetic */ zzdoj mo28270b(int i) {
        if (i >= this.f22100d) {
            return new C9324ap(Arrays.copyOf(this.f22099c, i), this.f22100d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(mo28855a(i));
    }

    static {
        C9324ap apVar = new C9324ap(new long[0], 0);
        f22098b = apVar;
        apVar.mo29068u();
    }
}
