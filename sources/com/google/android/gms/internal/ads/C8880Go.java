package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.ads.Go */
final class C8880Go extends C9565lo<Double> implements zzdoj<Double>, C9696rp, RandomAccess {

    /* renamed from: b */
    private static final C8880Go f21077b;

    /* renamed from: c */
    private double[] f21078c;

    /* renamed from: d */
    private int f21079d;

    C8880Go() {
        this(new double[10], 0);
    }

    private C8880Go(double[] dArr, int i) {
        this.f21078c = dArr;
        this.f21079d = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        mo29061a();
        if (i2 >= i) {
            double[] dArr = this.f21078c;
            System.arraycopy(dArr, i2, dArr, i, this.f21079d - i2);
            this.f21079d -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8880Go)) {
            return super.equals(obj);
        }
        C8880Go go = (C8880Go) obj;
        if (this.f21079d != go.f21079d) {
            return false;
        }
        double[] dArr = go.f21078c;
        for (int i = 0; i < this.f21079d; i++) {
            if (Double.doubleToLongBits(this.f21078c[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f21079d; i2++) {
            i = (i * 31) + zzdod.m29912a(Double.doubleToLongBits(this.f21078c[i2]));
        }
        return i;
    }

    public final int size() {
        return this.f21079d;
    }

    /* renamed from: a */
    public final void mo28267a(double d) {
        m22602a(this.f21079d, d);
    }

    /* renamed from: a */
    private final void m22602a(int i, double d) {
        mo29061a();
        if (i >= 0) {
            int i2 = this.f21079d;
            if (i <= i2) {
                double[] dArr = this.f21078c;
                if (i2 < dArr.length) {
                    System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
                } else {
                    double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(dArr, 0, dArr2, 0, i);
                    System.arraycopy(this.f21078c, i, dArr2, i + 1, this.f21079d - i);
                    this.f21078c = dArr2;
                }
                this.f21078c[i] = d;
                this.f21079d++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(m22603h(i));
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        mo29061a();
        zzdod.m29915a(collection);
        if (!(collection instanceof C8880Go)) {
            return super.addAll(collection);
        }
        C8880Go go = (C8880Go) collection;
        int i = go.f21079d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f21079d;
        if (MoPubClientPositioning.NO_REPEAT - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.f21078c;
            if (i3 > dArr.length) {
                this.f21078c = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(go.f21078c, 0, this.f21078c, this.f21079d, go.f21079d);
            this.f21079d = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        mo29061a();
        for (int i = 0; i < this.f21079d; i++) {
            if (obj.equals(Double.valueOf(this.f21078c[i]))) {
                double[] dArr = this.f21078c;
                System.arraycopy(dArr, i + 1, dArr, i, (this.f21079d - i) - 1);
                this.f21079d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private final void m22601a(int i) {
        if (i < 0 || i >= this.f21079d) {
            throw new IndexOutOfBoundsException(m22603h(i));
        }
    }

    /* renamed from: h */
    private final String m22603h(int i) {
        int i2 = this.f21079d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        mo29061a();
        m22601a(i);
        double[] dArr = this.f21078c;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final /* synthetic */ Object remove(int i) {
        mo29061a();
        m22601a(i);
        double[] dArr = this.f21078c;
        double d = dArr[i];
        int i2 = this.f21079d;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.f21079d--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        m22602a(i, ((Double) obj).doubleValue());
    }

    /* renamed from: b */
    public final /* synthetic */ zzdoj mo28270b(int i) {
        if (i >= this.f21079d) {
            return new C8880Go(Arrays.copyOf(this.f21078c, i), this.f21079d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        m22601a(i);
        return Double.valueOf(this.f21078c[i]);
    }

    static {
        C8880Go go = new C8880Go(new double[0], 0);
        f21077b = go;
        go.mo29068u();
    }
}
