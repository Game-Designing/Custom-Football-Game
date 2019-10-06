package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.ads.Po */
final class C9069Po extends C9565lo<Float> implements zzdoj<Float>, C9696rp, RandomAccess {

    /* renamed from: b */
    private static final C9069Po f21592b;

    /* renamed from: c */
    private float[] f21593c;

    /* renamed from: d */
    private int f21594d;

    C9069Po() {
        this(new float[10], 0);
    }

    private C9069Po(float[] fArr, int i) {
        this.f21593c = fArr;
        this.f21594d = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        mo29061a();
        if (i2 >= i) {
            float[] fArr = this.f21593c;
            System.arraycopy(fArr, i2, fArr, i, this.f21594d - i2);
            this.f21594d -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9069Po)) {
            return super.equals(obj);
        }
        C9069Po po = (C9069Po) obj;
        if (this.f21594d != po.f21594d) {
            return false;
        }
        float[] fArr = po.f21593c;
        for (int i = 0; i < this.f21594d; i++) {
            if (Float.floatToIntBits(this.f21593c[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f21594d; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f21593c[i2]);
        }
        return i;
    }

    public final int size() {
        return this.f21594d;
    }

    /* renamed from: a */
    public final void mo28520a(float f) {
        m22894a(this.f21594d, f);
    }

    /* renamed from: a */
    private final void m22894a(int i, float f) {
        mo29061a();
        if (i >= 0) {
            int i2 = this.f21594d;
            if (i <= i2) {
                float[] fArr = this.f21593c;
                if (i2 < fArr.length) {
                    System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
                } else {
                    float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(fArr, 0, fArr2, 0, i);
                    System.arraycopy(this.f21593c, i, fArr2, i + 1, this.f21594d - i);
                    this.f21593c = fArr2;
                }
                this.f21593c[i] = f;
                this.f21594d++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(m22895h(i));
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        mo29061a();
        zzdod.m29915a(collection);
        if (!(collection instanceof C9069Po)) {
            return super.addAll(collection);
        }
        C9069Po po = (C9069Po) collection;
        int i = po.f21594d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f21594d;
        if (MoPubClientPositioning.NO_REPEAT - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.f21593c;
            if (i3 > fArr.length) {
                this.f21593c = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(po.f21593c, 0, this.f21593c, this.f21594d, po.f21594d);
            this.f21594d = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        mo29061a();
        for (int i = 0; i < this.f21594d; i++) {
            if (obj.equals(Float.valueOf(this.f21593c[i]))) {
                float[] fArr = this.f21593c;
                System.arraycopy(fArr, i + 1, fArr, i, (this.f21594d - i) - 1);
                this.f21594d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private final void m22893a(int i) {
        if (i < 0 || i >= this.f21594d) {
            throw new IndexOutOfBoundsException(m22895h(i));
        }
    }

    /* renamed from: h */
    private final String m22895h(int i) {
        int i2 = this.f21594d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        mo29061a();
        m22893a(i);
        float[] fArr = this.f21593c;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    public final /* synthetic */ Object remove(int i) {
        mo29061a();
        m22893a(i);
        float[] fArr = this.f21593c;
        float f = fArr[i];
        int i2 = this.f21594d;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.f21594d--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        m22894a(i, ((Float) obj).floatValue());
    }

    /* renamed from: b */
    public final /* synthetic */ zzdoj mo28270b(int i) {
        if (i >= this.f21594d) {
            return new C9069Po(Arrays.copyOf(this.f21593c, i), this.f21594d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        m22893a(i);
        return Float.valueOf(this.f21593c[i]);
    }

    static {
        C9069Po po = new C9069Po(new float[0], 0);
        f21592b = po;
        po.mo29068u();
    }
}
