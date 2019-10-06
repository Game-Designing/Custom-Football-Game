package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ads.gq */
final class C9457gq implements Cloneable {

    /* renamed from: a */
    private zzdrs<?, ?> f22383a;

    /* renamed from: b */
    private Object f22384b;

    /* renamed from: c */
    private List<Object> f22385c = new ArrayList();

    C9457gq() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo28974a() {
        if (this.f22384b == null) {
            Iterator it = this.f22385c.iterator();
            if (!it.hasNext()) {
                return 0;
            }
            it.next();
            throw new NoSuchMethodError();
        }
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28975a(zzdrp zzdrp) throws IOException {
        if (this.f22384b == null) {
            Iterator it = this.f22385c.iterator();
            if (it.hasNext()) {
                it.next();
                throw new NoSuchMethodError();
            }
            return;
        }
        throw new NoSuchMethodError();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C9457gq)) {
            return false;
        }
        C9457gq gqVar = (C9457gq) obj;
        if (this.f22384b == null || gqVar.f22384b == null) {
            List<Object> list = this.f22385c;
            if (list != null) {
                List<Object> list2 = gqVar.f22385c;
                if (list2 != null) {
                    return list.equals(list2);
                }
            }
            try {
                return Arrays.equals(m23649b(), gqVar.m23649b());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else {
            zzdrs<?, ?> zzdrs = this.f22383a;
            if (zzdrs != gqVar.f22383a) {
                return false;
            }
            if (!zzdrs.f28157a.isArray()) {
                return this.f22384b.equals(gqVar.f22384b);
            }
            Object obj2 = this.f22384b;
            if (obj2 instanceof byte[]) {
                return Arrays.equals((byte[]) obj2, (byte[]) gqVar.f22384b);
            }
            if (obj2 instanceof int[]) {
                return Arrays.equals((int[]) obj2, (int[]) gqVar.f22384b);
            }
            if (obj2 instanceof long[]) {
                return Arrays.equals((long[]) obj2, (long[]) gqVar.f22384b);
            }
            if (obj2 instanceof float[]) {
                return Arrays.equals((float[]) obj2, (float[]) gqVar.f22384b);
            }
            if (obj2 instanceof double[]) {
                return Arrays.equals((double[]) obj2, (double[]) gqVar.f22384b);
            }
            if (obj2 instanceof boolean[]) {
                return Arrays.equals((boolean[]) obj2, (boolean[]) gqVar.f22384b);
            }
            return Arrays.deepEquals((Object[]) obj2, (Object[]) gqVar.f22384b);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(m23649b()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: b */
    private final byte[] m23649b() throws IOException {
        byte[] bArr = new byte[mo28974a()];
        mo28975a(zzdrp.m29993a(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final C9457gq clone() {
        C9457gq gqVar = new C9457gq();
        try {
            gqVar.f22383a = this.f22383a;
            if (this.f22385c == null) {
                gqVar.f22385c = null;
            } else {
                gqVar.f22385c.addAll(this.f22385c);
            }
            if (this.f22384b != null) {
                if (this.f22384b instanceof zzdrw) {
                    gqVar.f22384b = (zzdrw) ((zzdrw) this.f22384b).clone();
                } else if (this.f22384b instanceof byte[]) {
                    gqVar.f22384b = ((byte[]) this.f22384b).clone();
                } else {
                    int i = 0;
                    if (this.f22384b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.f22384b;
                        byte[][] bArr2 = new byte[bArr.length][];
                        gqVar.f22384b = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.f22384b instanceof boolean[]) {
                        gqVar.f22384b = ((boolean[]) this.f22384b).clone();
                    } else if (this.f22384b instanceof int[]) {
                        gqVar.f22384b = ((int[]) this.f22384b).clone();
                    } else if (this.f22384b instanceof long[]) {
                        gqVar.f22384b = ((long[]) this.f22384b).clone();
                    } else if (this.f22384b instanceof float[]) {
                        gqVar.f22384b = ((float[]) this.f22384b).clone();
                    } else if (this.f22384b instanceof double[]) {
                        gqVar.f22384b = ((double[]) this.f22384b).clone();
                    } else if (this.f22384b instanceof zzdrw[]) {
                        zzdrw[] zzdrwArr = (zzdrw[]) this.f22384b;
                        zzdrw[] zzdrwArr2 = new zzdrw[zzdrwArr.length];
                        gqVar.f22384b = zzdrwArr2;
                        while (i < zzdrwArr.length) {
                            zzdrwArr2[i] = (zzdrw) zzdrwArr[i].clone();
                            i++;
                        }
                    }
                }
            }
            return gqVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
