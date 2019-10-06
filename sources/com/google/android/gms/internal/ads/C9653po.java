package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.ads.po */
final class C9653po extends C9565lo<Boolean> implements zzdoj<Boolean>, C9696rp, RandomAccess {

    /* renamed from: b */
    private static final C9653po f22876b;

    /* renamed from: c */
    private boolean[] f22877c;

    /* renamed from: d */
    private int f22878d;

    C9653po() {
        this(new boolean[10], 0);
    }

    private C9653po(boolean[] zArr, int i) {
        this.f22877c = zArr;
        this.f22878d = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        mo29061a();
        if (i2 >= i) {
            boolean[] zArr = this.f22877c;
            System.arraycopy(zArr, i2, zArr, i, this.f22878d - i2);
            this.f22878d -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9653po)) {
            return super.equals(obj);
        }
        C9653po poVar = (C9653po) obj;
        if (this.f22878d != poVar.f22878d) {
            return false;
        }
        boolean[] zArr = poVar.f22877c;
        for (int i = 0; i < this.f22878d; i++) {
            if (this.f22877c[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f22878d; i2++) {
            i = (i * 31) + zzdod.m29913a(this.f22877c[i2]);
        }
        return i;
    }

    public final int size() {
        return this.f22878d;
    }

    /* renamed from: a */
    public final void mo29122a(boolean z) {
        m24023a(this.f22878d, z);
    }

    /* renamed from: a */
    private final void m24023a(int i, boolean z) {
        mo29061a();
        if (i >= 0) {
            int i2 = this.f22878d;
            if (i <= i2) {
                boolean[] zArr = this.f22877c;
                if (i2 < zArr.length) {
                    System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
                } else {
                    boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(zArr, 0, zArr2, 0, i);
                    System.arraycopy(this.f22877c, i, zArr2, i + 1, this.f22878d - i);
                    this.f22877c = zArr2;
                }
                this.f22877c[i] = z;
                this.f22878d++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(m24024h(i));
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        mo29061a();
        zzdod.m29915a(collection);
        if (!(collection instanceof C9653po)) {
            return super.addAll(collection);
        }
        C9653po poVar = (C9653po) collection;
        int i = poVar.f22878d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f22878d;
        if (MoPubClientPositioning.NO_REPEAT - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.f22877c;
            if (i3 > zArr.length) {
                this.f22877c = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(poVar.f22877c, 0, this.f22877c, this.f22878d, poVar.f22878d);
            this.f22878d = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        mo29061a();
        for (int i = 0; i < this.f22878d; i++) {
            if (obj.equals(Boolean.valueOf(this.f22877c[i]))) {
                boolean[] zArr = this.f22877c;
                System.arraycopy(zArr, i + 1, zArr, i, (this.f22878d - i) - 1);
                this.f22878d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private final void m24022a(int i) {
        if (i < 0 || i >= this.f22878d) {
            throw new IndexOutOfBoundsException(m24024h(i));
        }
    }

    /* renamed from: h */
    private final String m24024h(int i) {
        int i2 = this.f22878d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        mo29061a();
        m24022a(i);
        boolean[] zArr = this.f22877c;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ Object remove(int i) {
        mo29061a();
        m24022a(i);
        boolean[] zArr = this.f22877c;
        boolean z = zArr[i];
        int i2 = this.f22878d;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.f22878d--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        m24023a(i, ((Boolean) obj).booleanValue());
    }

    /* renamed from: b */
    public final /* synthetic */ zzdoj mo28270b(int i) {
        if (i >= this.f22878d) {
            return new C9653po(Arrays.copyOf(this.f22877c, i), this.f22878d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        m24022a(i);
        return Boolean.valueOf(this.f22877c[i]);
    }

    static {
        C9653po poVar = new C9653po(new boolean[0], 0);
        f22876b = poVar;
        poVar.mo29068u();
    }
}
