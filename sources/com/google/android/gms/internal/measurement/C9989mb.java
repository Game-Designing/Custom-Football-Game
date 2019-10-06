package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.mb */
final class C9989mb implements Cloneable {

    /* renamed from: a */
    private zzyd<?, ?> f30137a;

    /* renamed from: b */
    private Object f30138b;

    /* renamed from: c */
    private List<C9992nb> f30139c = new ArrayList();

    C9989mb() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo32743a() {
        Object obj = this.f30138b;
        if (obj != null) {
            zzyd<?, ?> zzyd = this.f30137a;
            if (!zzyd.f30416d) {
                return zzyd.mo32956a(obj);
            }
            int length = Array.getLength(obj);
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                Object obj2 = Array.get(obj, i2);
                if (obj2 != null) {
                    i += zzyd.mo32956a(obj2);
                }
            }
            return i;
        }
        int i3 = 0;
        for (C9992nb nbVar : this.f30139c) {
            i3 += zzya.m32601b(nbVar.f30148a) + 0 + nbVar.f30149b.length;
        }
        return i3;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32744a(zzya zzya) throws IOException {
        Object obj = this.f30138b;
        if (obj != null) {
            zzyd<?, ?> zzyd = this.f30137a;
            if (zzyd.f30416d) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        zzyd.mo32957a(obj2, zzya);
                    }
                }
                return;
            }
            zzyd.mo32957a(obj, zzya);
            return;
        }
        for (C9992nb nbVar : this.f30139c) {
            zzya.mo32951c(nbVar.f30148a);
            zzya.mo32950b(nbVar.f30149b);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C9989mb)) {
            return false;
        }
        C9989mb mbVar = (C9989mb) obj;
        if (this.f30138b == null || mbVar.f30138b == null) {
            List<C9992nb> list = this.f30139c;
            if (list != null) {
                List<C9992nb> list2 = mbVar.f30139c;
                if (list2 != null) {
                    return list.equals(list2);
                }
            }
            try {
                return Arrays.equals(m32167b(), mbVar.m32167b());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else {
            zzyd<?, ?> zzyd = this.f30137a;
            if (zzyd != mbVar.f30137a) {
                return false;
            }
            if (!zzyd.f30414b.isArray()) {
                return this.f30138b.equals(mbVar.f30138b);
            }
            Object obj2 = this.f30138b;
            if (obj2 instanceof byte[]) {
                return Arrays.equals((byte[]) obj2, (byte[]) mbVar.f30138b);
            }
            if (obj2 instanceof int[]) {
                return Arrays.equals((int[]) obj2, (int[]) mbVar.f30138b);
            }
            if (obj2 instanceof long[]) {
                return Arrays.equals((long[]) obj2, (long[]) mbVar.f30138b);
            }
            if (obj2 instanceof float[]) {
                return Arrays.equals((float[]) obj2, (float[]) mbVar.f30138b);
            }
            if (obj2 instanceof double[]) {
                return Arrays.equals((double[]) obj2, (double[]) mbVar.f30138b);
            }
            if (obj2 instanceof boolean[]) {
                return Arrays.equals((boolean[]) obj2, (boolean[]) mbVar.f30138b);
            }
            return Arrays.deepEquals((Object[]) obj2, (Object[]) mbVar.f30138b);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(m32167b()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: b */
    private final byte[] m32167b() throws IOException {
        byte[] bArr = new byte[mo32743a()];
        mo32744a(zzya.m32599a(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final C9989mb clone() {
        C9989mb mbVar = new C9989mb();
        try {
            mbVar.f30137a = this.f30137a;
            if (this.f30139c == null) {
                mbVar.f30139c = null;
            } else {
                mbVar.f30139c.addAll(this.f30139c);
            }
            if (this.f30138b != null) {
                if (this.f30138b instanceof zzyi) {
                    mbVar.f30138b = (zzyi) ((zzyi) this.f30138b).clone();
                } else if (this.f30138b instanceof byte[]) {
                    mbVar.f30138b = ((byte[]) this.f30138b).clone();
                } else {
                    int i = 0;
                    if (this.f30138b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.f30138b;
                        byte[][] bArr2 = new byte[bArr.length][];
                        mbVar.f30138b = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.f30138b instanceof boolean[]) {
                        mbVar.f30138b = ((boolean[]) this.f30138b).clone();
                    } else if (this.f30138b instanceof int[]) {
                        mbVar.f30138b = ((int[]) this.f30138b).clone();
                    } else if (this.f30138b instanceof long[]) {
                        mbVar.f30138b = ((long[]) this.f30138b).clone();
                    } else if (this.f30138b instanceof float[]) {
                        mbVar.f30138b = ((float[]) this.f30138b).clone();
                    } else if (this.f30138b instanceof double[]) {
                        mbVar.f30138b = ((double[]) this.f30138b).clone();
                    } else if (this.f30138b instanceof zzyi[]) {
                        zzyi[] zzyiArr = (zzyi[]) this.f30138b;
                        zzyi[] zzyiArr2 = new zzyi[zzyiArr.length];
                        mbVar.f30138b = zzyiArr2;
                        while (i < zzyiArr.length) {
                            zzyiArr2[i] = (zzyi) zzyiArr[i].clone();
                            i++;
                        }
                    }
                }
            }
            return mbVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
