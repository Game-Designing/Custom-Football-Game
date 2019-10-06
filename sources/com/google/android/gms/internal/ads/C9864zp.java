package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.ads.zp */
final class C9864zp {

    /* renamed from: a */
    private static final Class<?> f23751a = m24415d();

    /* renamed from: b */
    private static final C9049Op<?, ?> f23752b = m24390a(false);

    /* renamed from: c */
    private static final C9049Op<?, ?> f23753c = m24390a(true);

    /* renamed from: d */
    private static final C9049Op<?, ?> f23754d = new C9070Pp();

    /* renamed from: a */
    public static void m24399a(Class<?> cls) {
        if (!zzdob.class.isAssignableFrom(cls)) {
            Class<?> cls2 = f23751a;
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
        }
    }

    /* renamed from: a */
    public static void m24395a(int i, List<Double> list, C9435fq fqVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fqVar.mo28239m(i, list, z);
        }
    }

    /* renamed from: b */
    public static void m24408b(int i, List<Float> list, C9435fq fqVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fqVar.mo28240n(i, list, z);
        }
    }

    /* renamed from: c */
    public static void m24412c(int i, List<Long> list, C9435fq fqVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fqVar.mo28219b(i, list, z);
        }
    }

    /* renamed from: d */
    public static void m24416d(int i, List<Long> list, C9435fq fqVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fqVar.mo28238l(i, list, z);
        }
    }

    /* renamed from: e */
    public static void m24420e(int i, List<Long> list, C9435fq fqVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fqVar.mo28224d(i, list, z);
        }
    }

    /* renamed from: f */
    public static void m24423f(int i, List<Long> list, C9435fq fqVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fqVar.mo28237k(i, list, z);
        }
    }

    /* renamed from: g */
    public static void m24426g(int i, List<Long> list, C9435fq fqVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fqVar.mo28234h(i, list, z);
        }
    }

    /* renamed from: h */
    public static void m24429h(int i, List<Integer> list, C9435fq fqVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fqVar.mo28212a(i, list, z);
        }
    }

    /* renamed from: i */
    public static void m24432i(int i, List<Integer> list, C9435fq fqVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fqVar.mo28235i(i, list, z);
        }
    }

    /* renamed from: j */
    public static void m24435j(int i, List<Integer> list, C9435fq fqVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fqVar.mo28227e(i, list, z);
        }
    }

    /* renamed from: k */
    public static void m24436k(int i, List<Integer> list, C9435fq fqVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fqVar.mo28221c(i, list, z);
        }
    }

    /* renamed from: l */
    public static void m24437l(int i, List<Integer> list, C9435fq fqVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fqVar.mo28236j(i, list, z);
        }
    }

    /* renamed from: m */
    public static void m24438m(int i, List<Integer> list, C9435fq fqVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fqVar.mo28232g(i, list, z);
        }
    }

    /* renamed from: n */
    public static void m24439n(int i, List<Boolean> list, C9435fq fqVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fqVar.mo28230f(i, list, z);
        }
    }

    /* renamed from: a */
    public static void m24393a(int i, List<String> list, C9435fq fqVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            fqVar.mo28217b(i, list);
        }
    }

    /* renamed from: b */
    public static void m24406b(int i, List<zzdmr> list, C9435fq fqVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            fqVar.mo28210a(i, list);
        }
    }

    /* renamed from: a */
    public static void m24394a(int i, List<?> list, C9435fq fqVar, C9822xp xpVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            fqVar.mo28218b(i, list, xpVar);
        }
    }

    /* renamed from: b */
    public static void m24407b(int i, List<?> list, C9435fq fqVar, C9822xp xpVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            fqVar.mo28211a(i, list, xpVar);
        }
    }

    /* renamed from: i */
    static int m24431i(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C9324ap) {
            C9324ap apVar = (C9324ap) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.m29725d(apVar.mo28855a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdni.m29725d(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: a */
    static int m24387a(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return m24431i(list) + (list.size() * zzdni.m29727e(i));
    }

    /* renamed from: j */
    static int m24434j(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C9324ap) {
            C9324ap apVar = (C9324ap) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.m29730e(apVar.mo28855a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdni.m29730e(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: b */
    static int m24403b(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m24434j(list) + (size * zzdni.m29727e(i));
    }

    /* renamed from: a */
    static int m24388a(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C9324ap) {
            C9324ap apVar = (C9324ap) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.m29734f(apVar.mo28855a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdni.m29734f(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: c */
    static int m24409c(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m24388a(list) + (size * zzdni.m29727e(i));
    }

    /* renamed from: b */
    static int m24404b(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C9156To) {
            C9156To to = (C9156To) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.m29745k(to.mo28616a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdni.m29745k(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: d */
    static int m24413d(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m24404b(list) + (size * zzdni.m29727e(i));
    }

    /* renamed from: c */
    static int m24410c(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C9156To) {
            C9156To to = (C9156To) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.m29731f(to.mo28616a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdni.m29731f(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: e */
    static int m24417e(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m24410c(list) + (size * zzdni.m29727e(i));
    }

    /* renamed from: d */
    static int m24414d(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C9156To) {
            C9156To to = (C9156To) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.m29735g(to.mo28616a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdni.m29735g(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: f */
    static int m24421f(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m24414d(list) + (size * zzdni.m29727e(i));
    }

    /* renamed from: e */
    static int m24418e(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C9156To) {
            C9156To to = (C9156To) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.m29739h(to.mo28616a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdni.m29739h(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: g */
    static int m24424g(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m24418e(list) + (size * zzdni.m29727e(i));
    }

    /* renamed from: f */
    static int m24422f(List<?> list) {
        return list.size() << 2;
    }

    /* renamed from: h */
    static int m24427h(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdni.m29728e(i, 0);
    }

    /* renamed from: g */
    static int m24425g(List<?> list) {
        return list.size() << 3;
    }

    /* renamed from: i */
    static int m24430i(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdni.m29737g(i, 0);
    }

    /* renamed from: h */
    static int m24428h(List<?> list) {
        return list.size();
    }

    /* renamed from: j */
    static int m24433j(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdni.m29713b(i, true);
    }

    /* renamed from: a */
    static int m24385a(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int e = zzdni.m29727e(i) * size;
        if (list instanceof zzdot) {
            zzdot zzdot = (zzdot) list;
            while (i4 < size) {
                Object g = zzdot.mo31627g(i4);
                if (g instanceof zzdmr) {
                    i3 = zzdni.m29698a((zzdmr) g);
                } else {
                    i3 = zzdni.m29702a((String) g);
                }
                e += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzdmr) {
                    i2 = zzdni.m29698a((zzdmr) obj);
                } else {
                    i2 = zzdni.m29702a((String) obj);
                }
                e += i2;
                i4++;
            }
        }
        return e;
    }

    /* renamed from: a */
    static int m24384a(int i, Object obj, C9822xp xpVar) {
        if (obj instanceof zzdor) {
            return zzdni.m29697a(i, (zzdor) obj);
        }
        return zzdni.m29711b(i, (zzdpk) obj, xpVar);
    }

    /* renamed from: a */
    static int m24386a(int i, List<?> list, C9822xp xpVar) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e = zzdni.m29727e(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzdor) {
                i2 = zzdni.m29699a((zzdor) obj);
            } else {
                i2 = zzdni.m29701a((zzdpk) obj, xpVar);
            }
            e += i2;
        }
        return e;
    }

    /* renamed from: b */
    static int m24401b(int i, List<zzdmr> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e = size * zzdni.m29727e(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            e += zzdni.m29698a((zzdmr) list.get(i2));
        }
        return e;
    }

    /* renamed from: b */
    static int m24402b(int i, List<zzdpk> list, C9822xp xpVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzdni.m29720c(i, (zzdpk) list.get(i3), xpVar);
        }
        return i2;
    }

    /* renamed from: a */
    public static C9049Op<?, ?> m24389a() {
        return f23752b;
    }

    /* renamed from: b */
    public static C9049Op<?, ?> m24405b() {
        return f23753c;
    }

    /* renamed from: c */
    public static C9049Op<?, ?> m24411c() {
        return f23754d;
    }

    /* renamed from: a */
    private static C9049Op<?, ?> m24390a(boolean z) {
        try {
            Class e = m24419e();
            if (e == null) {
                return null;
            }
            return (C9049Op) e.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: d */
    private static Class<?> m24415d() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: e */
    private static Class<?> m24419e() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: a */
    static boolean m24400a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    static <T> void m24398a(C9456gp gpVar, T t, T t2, long j) {
        C9132Sp.m22986a((Object) t, j, gpVar.mo28967a(C9132Sp.m23009f(t, j), C9132Sp.m23009f(t2, j)));
    }

    /* renamed from: a */
    static <T, FT extends zzdnu<FT>> void m24396a(C8922Io<FT> io, T t, T t2) {
        C8985Lo b = io.mo28364b(t2);
        if (!b.mo28426b()) {
            io.mo28365c(t).mo28425a(b);
        }
    }

    /* renamed from: a */
    static <T, UT, UB> void m24397a(C9049Op<UT, UB> op, T t, T t2) {
        op.mo28487a((Object) t, op.mo28495c(op.mo28496d(t), op.mo28496d(t2)));
    }

    /* renamed from: a */
    static <UT, UB> UB m24392a(int i, List<Integer> list, zzdog zzdog, UB ub, C9049Op<UT, UB> op) {
        UB ub2;
        if (zzdog == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zzdog.mo28423a(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub2 = m24391a(i, intValue, ub2, op);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            ub2 = ub;
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzdog.mo28423a(intValue2)) {
                    UB a = m24391a(i, intValue2, ub2, op);
                    it.remove();
                    ub2 = a;
                }
            }
        }
        return ub2;
    }

    /* renamed from: a */
    static <UT, UB> UB m24391a(int i, int i2, UB ub, C9049Op<UT, UB> op) {
        if (ub == null) {
            ub = op.mo28480a();
        }
        op.mo28483a(ub, i, (long) i2);
        return ub;
    }
}
