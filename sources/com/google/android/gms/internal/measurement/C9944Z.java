package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.measurement.Z */
final class C9944Z<FieldDescriptorType extends zzuh<FieldDescriptorType>> {

    /* renamed from: a */
    private static final C9944Z f30046a = new C9944Z(true);

    /* renamed from: b */
    private final C9912Ia<FieldDescriptorType, Object> f30047b = C9912Ia.m31844a(16);

    /* renamed from: c */
    private boolean f30048c;

    /* renamed from: d */
    private boolean f30049d = false;

    private C9944Z() {
    }

    private C9944Z(boolean z) {
        mo32692f();
    }

    /* renamed from: g */
    public static <T extends zzuh<T>> C9944Z<T> m31975g() {
        return f30046a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final boolean mo32686b() {
        return this.f30047b.isEmpty();
    }

    /* renamed from: f */
    public final void mo32692f() {
        if (!this.f30048c) {
            this.f30047b.mo32568b();
            this.f30048c = true;
        }
    }

    /* renamed from: c */
    public final boolean mo32687c() {
        return this.f30048c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9944Z)) {
            return false;
        }
        return this.f30047b.equals(((C9944Z) obj).f30047b);
    }

    public final int hashCode() {
        return this.f30047b.hashCode();
    }

    /* renamed from: e */
    public final Iterator<Entry<FieldDescriptorType, Object>> mo32690e() {
        if (this.f30049d) {
            return new C9973ha(this.f30047b.entrySet().iterator());
        }
        return this.f30047b.entrySet().iterator();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Iterator<Entry<FieldDescriptorType, Object>> mo32684a() {
        if (this.f30049d) {
            return new C9973ha(this.f30047b.mo32573e().iterator());
        }
        return this.f30047b.mo32573e().iterator();
    }

    /* renamed from: a */
    private final Object m31966a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f30047b.get(fielddescriptortype);
        if (!(obj instanceof zzuy)) {
            return obj;
        }
        zzuy.m32554c();
        throw null;
    }

    /* renamed from: a */
    private final void m31968a(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.mo32889q()) {
            m31969a(fielddescriptortype.mo32887o(), obj);
            r6 = obj;
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                m31969a(fielddescriptortype.mo32887o(), obj2);
            }
            r6 = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (r6 instanceof zzuy) {
            this.f30049d = true;
        }
        this.f30047b.put(fielddescriptortype, r6);
    }

    /* renamed from: a */
    private static void m31969a(zzxs zzxs, Object obj) {
        zzuq.m32540a(obj);
        boolean z = false;
        switch (C9952aa.f30077a[zzxs.mo32947e().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if ((obj instanceof zzte) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzur)) {
                    z = true;
                    break;
                }
            case 9:
                if ((obj instanceof zzvv) || (obj instanceof zzuy)) {
                    z = true;
                    break;
                }
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    /* renamed from: d */
    public final boolean mo32689d() {
        for (int i = 0; i < this.f30047b.mo32569c(); i++) {
            if (!m31970a(this.f30047b.mo32567b(i))) {
                return false;
            }
        }
        for (Entry a : this.f30047b.mo32572d()) {
            if (!m31970a(a)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m31970a(Entry<FieldDescriptorType, Object> entry) {
        zzuh zzuh = (zzuh) entry.getKey();
        if (zzuh.mo32890r() == zzxx.MESSAGE) {
            if (zzuh.mo32889q()) {
                for (zzvv isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzvv) {
                    if (!((zzvv) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzuy) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public final void mo32685a(C9944Z<FieldDescriptorType> z) {
        for (int i = 0; i < z.f30047b.mo32569c(); i++) {
            m31973b(z.f30047b.mo32567b(i));
        }
        for (Entry b : z.f30047b.mo32572d()) {
            m31973b(b);
        }
    }

    /* renamed from: a */
    private static Object m31967a(Object obj) {
        if (obj instanceof zzwb) {
            return ((zzwb) obj).mo32934e();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* renamed from: b */
    private final void m31973b(Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        zzuh zzuh = (zzuh) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzuy) {
            zzuy.m32554c();
            throw null;
        } else if (zzuh.mo32889q()) {
            Object a = m31966a((FieldDescriptorType) zzuh);
            if (a == null) {
                a = new ArrayList();
            }
            for (Object a2 : (List) value) {
                ((List) a).add(m31967a(a2));
            }
            this.f30047b.put(zzuh, a);
        } else if (zzuh.mo32890r() == zzxx.MESSAGE) {
            Object a3 = m31966a((FieldDescriptorType) zzuh);
            if (a3 == null) {
                this.f30047b.put(zzuh, m31967a(value));
                return;
            }
            if (a3 instanceof zzwb) {
                obj = zzuh.mo32885a((zzwb) a3, (zzwb) value);
            } else {
                obj = zzuh.mo32884a(((zzvv) a3).mo32896c(), (zzvv) value).mo32905j();
            }
            this.f30047b.put(zzuh, obj);
        } else {
            this.f30047b.put(zzuh, m31967a(value));
        }
    }

    /* renamed from: h */
    public final int mo32693h() {
        int i = 0;
        for (int i2 = 0; i2 < this.f30047b.mo32569c(); i2++) {
            Entry b = this.f30047b.mo32567b(i2);
            i += m31971b((zzuh) b.getKey(), b.getValue());
        }
        for (Entry entry : this.f30047b.mo32572d()) {
            i += m31971b((zzuh) entry.getKey(), entry.getValue());
        }
        return i;
    }

    /* renamed from: i */
    public final int mo32695i() {
        int i = 0;
        for (int i2 = 0; i2 < this.f30047b.mo32569c(); i2++) {
            i += m31974c(this.f30047b.mo32567b(i2));
        }
        for (Entry c : this.f30047b.mo32572d()) {
            i += m31974c(c);
        }
        return i;
    }

    /* renamed from: c */
    private static int m31974c(Entry<FieldDescriptorType, Object> entry) {
        zzuh zzuh = (zzuh) entry.getKey();
        Object value = entry.getValue();
        if (zzuh.mo32890r() != zzxx.MESSAGE || zzuh.mo32889q() || zzuh.mo32888p()) {
            return m31971b(zzuh, value);
        }
        if (value instanceof zzuy) {
            return zztv.m32414b(((zzuh) entry.getKey()).mo32886h(), (zzvc) (zzuy) value);
        }
        return zztv.m32424c(((zzuh) entry.getKey()).mo32886h(), (zzvv) value);
    }

    /* renamed from: a */
    static int m31965a(zzxs zzxs, int i, Object obj) {
        int e = zztv.m32429e(i);
        if (zzxs == zzxs.GROUP) {
            zzuq.m32543a((zzvv) obj);
            e <<= 1;
        }
        return e + m31972b(zzxs, obj);
    }

    /* renamed from: b */
    private static int m31972b(zzxs zzxs, Object obj) {
        switch (C9952aa.f30078b[zzxs.ordinal()]) {
            case 1:
                return zztv.m32410b(((Double) obj).doubleValue());
            case 2:
                return zztv.m32411b(((Float) obj).floatValue());
            case 3:
                return zztv.m32428d(((Long) obj).longValue());
            case 4:
                return zztv.m32431e(((Long) obj).longValue());
            case 5:
                return zztv.m32432f(((Integer) obj).intValue());
            case 6:
                return zztv.m32439g(((Long) obj).longValue());
            case 7:
                return zztv.m32444i(((Integer) obj).intValue());
            case 8:
                return zztv.m32420b(((Boolean) obj).booleanValue());
            case 9:
                return zztv.m32419b((zzvv) obj);
            case 10:
                if (obj instanceof zzuy) {
                    return zztv.m32405a((zzvc) (zzuy) obj);
                }
                return zztv.m32406a((zzvv) obj);
            case 11:
                if (obj instanceof zzte) {
                    return zztv.m32404a((zzte) obj);
                }
                return zztv.m32408a((String) obj);
            case 12:
                if (obj instanceof zzte) {
                    return zztv.m32404a((zzte) obj);
                }
                return zztv.m32421b((byte[]) obj);
            case 13:
                return zztv.m32436g(((Integer) obj).intValue());
            case 14:
                return zztv.m32447j(((Integer) obj).intValue());
            case 15:
                return zztv.m32443h(((Long) obj).longValue());
            case 16:
                return zztv.m32440h(((Integer) obj).intValue());
            case 17:
                return zztv.m32435f(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzur) {
                    return zztv.m32449k(((zzur) obj).mo32907h());
                }
                return zztv.m32449k(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* renamed from: b */
    private static int m31971b(zzuh<?> zzuh, Object obj) {
        zzxs o = zzuh.mo32887o();
        int h = zzuh.mo32886h();
        if (!zzuh.mo32889q()) {
            return m31965a(o, h, obj);
        }
        int i = 0;
        if (zzuh.mo32888p()) {
            for (Object b : (List) obj) {
                i += m31972b(o, b);
            }
            return zztv.m32429e(h) + i + zztv.m32451l(i);
        }
        for (Object a : (List) obj) {
            i += m31965a(o, h, a);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        C9944Z z = new C9944Z();
        for (int i = 0; i < this.f30047b.mo32569c(); i++) {
            Entry b = this.f30047b.mo32567b(i);
            z.m31968a((FieldDescriptorType) (zzuh) b.getKey(), b.getValue());
        }
        for (Entry entry : this.f30047b.mo32572d()) {
            z.m31968a((FieldDescriptorType) (zzuh) entry.getKey(), entry.getValue());
        }
        z.f30049d = this.f30049d;
        return z;
    }
}
