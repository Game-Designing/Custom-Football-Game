package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdnu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.ads.Lo */
final class C8985Lo<FieldDescriptorType extends zzdnu<FieldDescriptorType>> {

    /* renamed from: a */
    private static final C8985Lo f21439a = new C8985Lo(true);

    /* renamed from: b */
    private final C8755Ap<FieldDescriptorType, Object> f21440b = C8755Ap.m22284a(16);

    /* renamed from: c */
    private boolean f21441c;

    /* renamed from: d */
    private boolean f21442d = false;

    private C8985Lo() {
    }

    private C8985Lo(boolean z) {
        mo28432f();
    }

    /* renamed from: g */
    public static <T extends zzdnu<T>> C8985Lo<T> m22789g() {
        return f21439a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final boolean mo28426b() {
        return this.f21440b.isEmpty();
    }

    /* renamed from: f */
    public final void mo28432f() {
        if (!this.f21441c) {
            this.f21440b.mo28030b();
            this.f21441c = true;
        }
    }

    /* renamed from: c */
    public final boolean mo28427c() {
        return this.f21441c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8985Lo)) {
            return false;
        }
        return this.f21440b.equals(((C8985Lo) obj).f21440b);
    }

    public final int hashCode() {
        return this.f21440b.hashCode();
    }

    /* renamed from: e */
    public final Iterator<Entry<FieldDescriptorType, Object>> mo28430e() {
        if (this.f21442d) {
            return new C9219Wo(this.f21440b.entrySet().iterator());
        }
        return this.f21440b.entrySet().iterator();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Iterator<Entry<FieldDescriptorType, Object>> mo28424a() {
        if (this.f21442d) {
            return new C9219Wo(this.f21440b.mo28035e().iterator());
        }
        return this.f21440b.mo28035e().iterator();
    }

    /* renamed from: a */
    private final Object m22780a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f21440b.get(fielddescriptortype);
        if (!(obj instanceof zzdon)) {
            return obj;
        }
        zzdon.m29938c();
        throw null;
    }

    /* renamed from: a */
    private final void m22782a(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.mo31598m()) {
            m22783a(fielddescriptortype.mo31596k(), obj);
            r6 = obj;
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                m22783a(fielddescriptortype.mo31596k(), obj2);
            }
            r6 = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (r6 instanceof zzdon) {
            this.f21442d = true;
        }
        this.f21440b.put(fielddescriptortype, r6);
    }

    /* renamed from: a */
    private static void m22783a(zzdri zzdri, Object obj) {
        zzdod.m29915a(obj);
        boolean z = false;
        switch (C9006Mo.f21485a[zzdri.mo31660e().ordinal()]) {
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
                if ((obj instanceof zzdmr) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzdoe)) {
                    z = true;
                    break;
                }
            case 9:
                if ((obj instanceof zzdpk) || (obj instanceof zzdon)) {
                    z = true;
                    break;
                }
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    /* renamed from: d */
    public final boolean mo28429d() {
        for (int i = 0; i < this.f21440b.mo28031c(); i++) {
            if (!m22784a(this.f21440b.mo28029b(i))) {
                return false;
            }
        }
        for (Entry a : this.f21440b.mo28034d()) {
            if (!m22784a(a)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m22784a(Entry<FieldDescriptorType, Object> entry) {
        zzdnu zzdnu = (zzdnu) entry.getKey();
        if (zzdnu.mo31597l() == zzdrn.MESSAGE) {
            if (zzdnu.mo31598m()) {
                for (zzdpk isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzdpk) {
                    if (!((zzdpk) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzdon) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public final void mo28425a(C8985Lo<FieldDescriptorType> lo) {
        for (int i = 0; i < lo.f21440b.mo28031c(); i++) {
            m22787b(lo.f21440b.mo28029b(i));
        }
        for (Entry b : lo.f21440b.mo28034d()) {
            m22787b(b);
        }
    }

    /* renamed from: a */
    private static Object m22781a(Object obj) {
        if (obj instanceof zzdpr) {
            return ((zzdpr) obj).mo31645f();
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
    private final void m22787b(Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        zzdnu zzdnu = (zzdnu) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzdon) {
            zzdon.m29938c();
            throw null;
        } else if (zzdnu.mo31598m()) {
            Object a = m22780a((FieldDescriptorType) zzdnu);
            if (a == null) {
                a = new ArrayList();
            }
            for (Object a2 : (List) value) {
                ((List) a).add(m22781a(a2));
            }
            this.f21440b.put(zzdnu, a);
        } else if (zzdnu.mo31597l() == zzdrn.MESSAGE) {
            Object a3 = m22780a((FieldDescriptorType) zzdnu);
            if (a3 == null) {
                this.f21440b.put(zzdnu, m22781a(value));
                return;
            }
            if (a3 instanceof zzdpr) {
                obj = zzdnu.mo31594a((zzdpr) a3, (zzdpr) value);
            } else {
                obj = zzdnu.mo31593a(((zzdpk) a3).mo31604d(), (zzdpk) value).mo31612g();
            }
            this.f21440b.put(zzdnu, obj);
        } else {
            this.f21440b.put(zzdnu, m22781a(value));
        }
    }

    /* renamed from: h */
    public final int mo28433h() {
        int i = 0;
        for (int i2 = 0; i2 < this.f21440b.mo28031c(); i2++) {
            Entry b = this.f21440b.mo28029b(i2);
            i += m22785b((zzdnu) b.getKey(), b.getValue());
        }
        for (Entry entry : this.f21440b.mo28034d()) {
            i += m22785b((zzdnu) entry.getKey(), entry.getValue());
        }
        return i;
    }

    /* renamed from: i */
    public final int mo28435i() {
        int i = 0;
        for (int i2 = 0; i2 < this.f21440b.mo28031c(); i2++) {
            i += m22788c(this.f21440b.mo28029b(i2));
        }
        for (Entry c : this.f21440b.mo28034d()) {
            i += m22788c(c);
        }
        return i;
    }

    /* renamed from: c */
    private static int m22788c(Entry<FieldDescriptorType, Object> entry) {
        zzdnu zzdnu = (zzdnu) entry.getKey();
        Object value = entry.getValue();
        if (zzdnu.mo31597l() != zzdrn.MESSAGE || zzdnu.mo31598m() || zzdnu.mo31599n()) {
            return m22785b(zzdnu, value);
        }
        if (value instanceof zzdon) {
            return zzdni.m29710b(((zzdnu) entry.getKey()).mo31595d(), (zzdor) (zzdon) value);
        }
        return zzdni.m29724d(((zzdnu) entry.getKey()).mo31595d(), (zzdpk) value);
    }

    /* renamed from: a */
    static int m22779a(zzdri zzdri, int i, Object obj) {
        int e = zzdni.m29727e(i);
        if (zzdri == zzdri.GROUP) {
            zzdod.m29918a((zzdpk) obj);
            e <<= 1;
        }
        return e + m22786b(zzdri, obj);
    }

    /* renamed from: b */
    private static int m22786b(zzdri zzdri, Object obj) {
        switch (C9006Mo.f21486b[zzdri.ordinal()]) {
            case 1:
                return zzdni.m29705b(((Double) obj).doubleValue());
            case 2:
                return zzdni.m29706b(((Float) obj).floatValue());
            case 3:
                return zzdni.m29725d(((Long) obj).longValue());
            case 4:
                return zzdni.m29730e(((Long) obj).longValue());
            case 5:
                return zzdni.m29731f(((Integer) obj).intValue());
            case 6:
                return zzdni.m29738g(((Long) obj).longValue());
            case 7:
                return zzdni.m29742i(((Integer) obj).intValue());
            case 8:
                return zzdni.m29715b(((Boolean) obj).booleanValue());
            case 9:
                return zzdni.m29714b((zzdpk) obj);
            case 10:
                if (obj instanceof zzdon) {
                    return zzdni.m29699a((zzdor) (zzdon) obj);
                }
                return zzdni.m29700a((zzdpk) obj);
            case 11:
                if (obj instanceof zzdmr) {
                    return zzdni.m29698a((zzdmr) obj);
                }
                return zzdni.m29702a((String) obj);
            case 12:
                if (obj instanceof zzdmr) {
                    return zzdni.m29698a((zzdmr) obj);
                }
                return zzdni.m29716b((byte[]) obj);
            case 13:
                return zzdni.m29735g(((Integer) obj).intValue());
            case 14:
                return zzdni.m29744j(((Integer) obj).intValue());
            case 15:
                return zzdni.m29741h(((Long) obj).longValue());
            case 16:
                return zzdni.m29739h(((Integer) obj).intValue());
            case 17:
                return zzdni.m29734f(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzdoe) {
                    return zzdni.m29745k(((zzdoe) obj).mo30728d());
                }
                return zzdni.m29745k(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* renamed from: b */
    private static int m22785b(zzdnu<?> zzdnu, Object obj) {
        zzdri k = zzdnu.mo31596k();
        int d = zzdnu.mo31595d();
        if (!zzdnu.mo31598m()) {
            return m22779a(k, d, obj);
        }
        int i = 0;
        if (zzdnu.mo31599n()) {
            for (Object b : (List) obj) {
                i += m22786b(k, b);
            }
            return zzdni.m29727e(d) + i + zzdni.m29746l(i);
        }
        for (Object a : (List) obj) {
            i += m22779a(k, d, a);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        C8985Lo lo = new C8985Lo();
        for (int i = 0; i < this.f21440b.mo28031c(); i++) {
            Entry b = this.f21440b.mo28029b(i);
            lo.m22782a((FieldDescriptorType) (zzdnu) b.getKey(), b.getValue());
        }
        for (Entry entry : this.f21440b.mo28034d()) {
            lo.m22782a((FieldDescriptorType) (zzdnu) entry.getKey(), entry.getValue());
        }
        lo.f21442d = this.f21442d;
        return lo;
    }
}
