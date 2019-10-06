package com.google.android.gms.internal.measurement;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.ea */
final class C9964ea extends C9903E<Integer> implements zzuu<Integer>, C9900Ca, RandomAccess {

    /* renamed from: b */
    private static final C9964ea f30106b;

    /* renamed from: c */
    private int[] f30107c;

    /* renamed from: d */
    private int f30108d;

    C9964ea() {
        this(new int[10], 0);
    }

    private C9964ea(int[] iArr, int i) {
        this.f30107c = iArr;
        this.f30108d = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        mo32535a();
        if (i2 >= i) {
            int[] iArr = this.f30107c;
            System.arraycopy(iArr, i2, iArr, i, this.f30108d - i2);
            this.f30108d -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9964ea)) {
            return super.equals(obj);
        }
        C9964ea eaVar = (C9964ea) obj;
        if (this.f30108d != eaVar.f30108d) {
            return false;
        }
        int[] iArr = eaVar.f30107c;
        for (int i = 0; i < this.f30108d; i++) {
            if (this.f30107c[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f30108d; i2++) {
            i = (i * 31) + this.f30107c[i2];
        }
        return i;
    }

    /* renamed from: a */
    public final int mo32719a(int i) {
        m32089h(i);
        return this.f30107c[i];
    }

    public final int size() {
        return this.f30108d;
    }

    /* renamed from: a */
    private final void m32088a(int i, int i2) {
        mo32535a();
        if (i >= 0) {
            int i3 = this.f30108d;
            if (i <= i3) {
                int[] iArr = this.f30107c;
                if (i3 < iArr.length) {
                    System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
                } else {
                    int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
                    System.arraycopy(iArr, 0, iArr2, 0, i);
                    System.arraycopy(this.f30107c, i, iArr2, i + 1, this.f30108d - i);
                    this.f30107c = iArr2;
                }
                this.f30107c[i] = i2;
                this.f30108d++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(m32090i(i));
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        mo32535a();
        zzuq.m32540a(collection);
        if (!(collection instanceof C9964ea)) {
            return super.addAll(collection);
        }
        C9964ea eaVar = (C9964ea) collection;
        int i = eaVar.f30108d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f30108d;
        if (MoPubClientPositioning.NO_REPEAT - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f30107c;
            if (i3 > iArr.length) {
                this.f30107c = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(eaVar.f30107c, 0, this.f30107c, this.f30108d, eaVar.f30108d);
            this.f30108d = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        mo32535a();
        for (int i = 0; i < this.f30108d; i++) {
            if (obj.equals(Integer.valueOf(this.f30107c[i]))) {
                int[] iArr = this.f30107c;
                System.arraycopy(iArr, i + 1, iArr, i, (this.f30108d - i) - 1);
                this.f30108d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    private final void m32089h(int i) {
        if (i < 0 || i >= this.f30108d) {
            throw new IndexOutOfBoundsException(m32090i(i));
        }
    }

    /* renamed from: i */
    private final String m32090i(int i) {
        int i2 = this.f30108d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        mo32535a();
        m32089h(i);
        int[] iArr = this.f30107c;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        mo32535a();
        m32089h(i);
        int[] iArr = this.f30107c;
        int i2 = iArr[i];
        int i3 = this.f30108d;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.f30108d--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        m32088a(i, ((Integer) obj).intValue());
    }

    /* renamed from: e */
    public final /* synthetic */ zzuu mo32721e(int i) {
        if (i >= this.f30108d) {
            return new C9964ea(Arrays.copyOf(this.f30107c, i), this.f30108d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(mo32719a(i));
    }

    static {
        C9964ea eaVar = new C9964ea();
        f30106b = eaVar;
        eaVar.mo32545s();
    }
}
