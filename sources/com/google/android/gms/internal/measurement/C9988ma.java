package com.google.android.gms.internal.measurement;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.ma */
final class C9988ma extends C9903E<Long> implements zzuu<Long>, C9900Ca, RandomAccess {

    /* renamed from: b */
    private static final C9988ma f30134b;

    /* renamed from: c */
    private long[] f30135c;

    /* renamed from: d */
    private int f30136d;

    C9988ma() {
        this(new long[10], 0);
    }

    private C9988ma(long[] jArr, int i) {
        this.f30135c = jArr;
        this.f30136d = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        mo32535a();
        if (i2 >= i) {
            long[] jArr = this.f30135c;
            System.arraycopy(jArr, i2, jArr, i, this.f30136d - i2);
            this.f30136d -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9988ma)) {
            return super.equals(obj);
        }
        C9988ma maVar = (C9988ma) obj;
        if (this.f30136d != maVar.f30136d) {
            return false;
        }
        long[] jArr = maVar.f30135c;
        for (int i = 0; i < this.f30136d; i++) {
            if (this.f30135c[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f30136d; i2++) {
            i = (i * 31) + zzuq.m32537a(this.f30135c[i2]);
        }
        return i;
    }

    /* renamed from: a */
    public final long mo32736a(int i) {
        m32163h(i);
        return this.f30135c[i];
    }

    public final int size() {
        return this.f30136d;
    }

    /* renamed from: a */
    private final void m32162a(int i, long j) {
        mo32535a();
        if (i >= 0) {
            int i2 = this.f30136d;
            if (i <= i2) {
                long[] jArr = this.f30135c;
                if (i2 < jArr.length) {
                    System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
                } else {
                    long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(jArr, 0, jArr2, 0, i);
                    System.arraycopy(this.f30135c, i, jArr2, i + 1, this.f30136d - i);
                    this.f30135c = jArr2;
                }
                this.f30135c[i] = j;
                this.f30136d++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(m32164i(i));
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        mo32535a();
        zzuq.m32540a(collection);
        if (!(collection instanceof C9988ma)) {
            return super.addAll(collection);
        }
        C9988ma maVar = (C9988ma) collection;
        int i = maVar.f30136d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f30136d;
        if (MoPubClientPositioning.NO_REPEAT - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.f30135c;
            if (i3 > jArr.length) {
                this.f30135c = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(maVar.f30135c, 0, this.f30135c, this.f30136d, maVar.f30136d);
            this.f30136d = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        mo32535a();
        for (int i = 0; i < this.f30136d; i++) {
            if (obj.equals(Long.valueOf(this.f30135c[i]))) {
                long[] jArr = this.f30135c;
                System.arraycopy(jArr, i + 1, jArr, i, (this.f30136d - i) - 1);
                this.f30136d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    private final void m32163h(int i) {
        if (i < 0 || i >= this.f30136d) {
            throw new IndexOutOfBoundsException(m32164i(i));
        }
    }

    /* renamed from: i */
    private final String m32164i(int i) {
        int i2 = this.f30136d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        mo32535a();
        m32163h(i);
        long[] jArr = this.f30135c;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i) {
        mo32535a();
        m32163h(i);
        long[] jArr = this.f30135c;
        long j = jArr[i];
        int i2 = this.f30136d;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.f30136d--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        m32162a(i, ((Long) obj).longValue());
    }

    /* renamed from: e */
    public final /* synthetic */ zzuu mo32721e(int i) {
        if (i >= this.f30136d) {
            return new C9988ma(Arrays.copyOf(this.f30135c, i), this.f30136d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(mo32736a(i));
    }

    static {
        C9988ma maVar = new C9988ma();
        f30134b = maVar;
        maVar.mo32545s();
    }
}
