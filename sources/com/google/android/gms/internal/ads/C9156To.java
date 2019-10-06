package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.ads.To */
final class C9156To extends C9565lo<Integer> implements zzdoh, C9696rp, RandomAccess {

    /* renamed from: b */
    private static final C9156To f21780b;

    /* renamed from: c */
    private int[] f21781c;

    /* renamed from: d */
    private int f21782d;

    /* renamed from: b */
    public static C9156To m23091b() {
        return f21780b;
    }

    C9156To() {
        this(new int[10], 0);
    }

    private C9156To(int[] iArr, int i) {
        this.f21781c = iArr;
        this.f21782d = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        mo29061a();
        if (i2 >= i) {
            int[] iArr = this.f21781c;
            System.arraycopy(iArr, i2, iArr, i, this.f21782d - i2);
            this.f21782d -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9156To)) {
            return super.equals(obj);
        }
        C9156To to = (C9156To) obj;
        if (this.f21782d != to.f21782d) {
            return false;
        }
        int[] iArr = to.f21781c;
        for (int i = 0; i < this.f21782d; i++) {
            if (this.f21781c[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f21782d; i2++) {
            i = (i * 31) + this.f21781c[i2];
        }
        return i;
    }

    /* renamed from: c */
    public final zzdoh mo28270b(int i) {
        if (i >= this.f21782d) {
            return new C9156To(Arrays.copyOf(this.f21781c, i), this.f21782d);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public final int mo28616a(int i) {
        m23092h(i);
        return this.f21781c[i];
    }

    public final int size() {
        return this.f21782d;
    }

    /* renamed from: d */
    public final void mo28619d(int i) {
        m23090a(this.f21782d, i);
    }

    /* renamed from: a */
    private final void m23090a(int i, int i2) {
        mo29061a();
        if (i >= 0) {
            int i3 = this.f21782d;
            if (i <= i3) {
                int[] iArr = this.f21781c;
                if (i3 < iArr.length) {
                    System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
                } else {
                    int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
                    System.arraycopy(iArr, 0, iArr2, 0, i);
                    System.arraycopy(this.f21781c, i, iArr2, i + 1, this.f21782d - i);
                    this.f21781c = iArr2;
                }
                this.f21781c[i] = i2;
                this.f21782d++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(m23093i(i));
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        mo29061a();
        zzdod.m29915a(collection);
        if (!(collection instanceof C9156To)) {
            return super.addAll(collection);
        }
        C9156To to = (C9156To) collection;
        int i = to.f21782d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f21782d;
        if (MoPubClientPositioning.NO_REPEAT - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f21781c;
            if (i3 > iArr.length) {
                this.f21781c = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(to.f21781c, 0, this.f21781c, this.f21782d, to.f21782d);
            this.f21782d = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        mo29061a();
        for (int i = 0; i < this.f21782d; i++) {
            if (obj.equals(Integer.valueOf(this.f21781c[i]))) {
                int[] iArr = this.f21781c;
                System.arraycopy(iArr, i + 1, iArr, i, (this.f21782d - i) - 1);
                this.f21782d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    private final void m23092h(int i) {
        if (i < 0 || i >= this.f21782d) {
            throw new IndexOutOfBoundsException(m23093i(i));
        }
    }

    /* renamed from: i */
    private final String m23093i(int i) {
        int i2 = this.f21782d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        mo29061a();
        m23092h(i);
        int[] iArr = this.f21781c;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        mo29061a();
        m23092h(i);
        int[] iArr = this.f21781c;
        int i2 = iArr[i];
        int i3 = this.f21782d;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.f21782d--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        m23090a(i, ((Integer) obj).intValue());
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(mo28616a(i));
    }

    static {
        C9156To to = new C9156To(new int[0], 0);
        f21780b = to;
        to.mo29068u();
    }
}
