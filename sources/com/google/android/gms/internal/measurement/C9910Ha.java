package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.Ha */
final class C9910Ha {

    /* renamed from: a */
    private static final Class<?> f30001a = m31818d();

    /* renamed from: b */
    private static final C9939Wa<?, ?> f30002b = m31795a(false);

    /* renamed from: c */
    private static final C9939Wa<?, ?> f30003c = m31795a(true);

    /* renamed from: d */
    private static final C9939Wa<?, ?> f30004d = new C9941Xa();

    /* renamed from: a */
    public static void m31802a(Class<?> cls) {
        if (!zzuo.class.isAssignableFrom(cls)) {
            Class<?> cls2 = f30001a;
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
        }
    }

    /* renamed from: a */
    public static void m31798a(int i, List<Double> list, C9986lb lbVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            lbVar.mo32657m(i, list, z);
        }
    }

    /* renamed from: b */
    public static void m31811b(int i, List<Float> list, C9986lb lbVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            lbVar.mo32658n(i, list, z);
        }
    }

    /* renamed from: c */
    public static void m31815c(int i, List<Long> list, C9986lb lbVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            lbVar.mo32639b(i, list, z);
        }
    }

    /* renamed from: d */
    public static void m31819d(int i, List<Long> list, C9986lb lbVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            lbVar.mo32656l(i, list, z);
        }
    }

    /* renamed from: e */
    public static void m31823e(int i, List<Long> list, C9986lb lbVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            lbVar.mo32645d(i, list, z);
        }
    }

    /* renamed from: f */
    public static void m31826f(int i, List<Long> list, C9986lb lbVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            lbVar.mo32655k(i, list, z);
        }
    }

    /* renamed from: g */
    public static void m31829g(int i, List<Long> list, C9986lb lbVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            lbVar.mo32652h(i, list, z);
        }
    }

    /* renamed from: h */
    public static void m31832h(int i, List<Integer> list, C9986lb lbVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            lbVar.mo32630a(i, list, z);
        }
    }

    /* renamed from: i */
    public static void m31835i(int i, List<Integer> list, C9986lb lbVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            lbVar.mo32653i(i, list, z);
        }
    }

    /* renamed from: j */
    public static void m31838j(int i, List<Integer> list, C9986lb lbVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            lbVar.mo32648e(i, list, z);
        }
    }

    /* renamed from: k */
    public static void m31839k(int i, List<Integer> list, C9986lb lbVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            lbVar.mo32642c(i, list, z);
        }
    }

    /* renamed from: l */
    public static void m31840l(int i, List<Integer> list, C9986lb lbVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            lbVar.mo32654j(i, list, z);
        }
    }

    /* renamed from: m */
    public static void m31841m(int i, List<Integer> list, C9986lb lbVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            lbVar.mo32651g(i, list, z);
        }
    }

    /* renamed from: n */
    public static void m31842n(int i, List<Boolean> list, C9986lb lbVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            lbVar.mo32650f(i, list, z);
        }
    }

    /* renamed from: a */
    public static void m31796a(int i, List<String> list, C9986lb lbVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            lbVar.mo32637b(i, list);
        }
    }

    /* renamed from: b */
    public static void m31809b(int i, List<zzte> list, C9986lb lbVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            lbVar.mo32628a(i, list);
        }
    }

    /* renamed from: a */
    public static void m31797a(int i, List<?> list, C9986lb lbVar, C9906Fa fa) throws IOException {
        if (list != null && !list.isEmpty()) {
            lbVar.mo32638b(i, list, fa);
        }
    }

    /* renamed from: b */
    public static void m31810b(int i, List<?> list, C9986lb lbVar, C9906Fa fa) throws IOException {
        if (list != null && !list.isEmpty()) {
            lbVar.mo32629a(i, list, fa);
        }
    }

    /* renamed from: i */
    static int m31834i(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C9988ma) {
            C9988ma maVar = (C9988ma) list;
            i = 0;
            while (i2 < size) {
                i += zztv.m32428d(maVar.mo32736a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zztv.m32428d(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: a */
    static int m31792a(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return m31834i(list) + (list.size() * zztv.m32429e(i));
    }

    /* renamed from: j */
    static int m31837j(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C9988ma) {
            C9988ma maVar = (C9988ma) list;
            i = 0;
            while (i2 < size) {
                i += zztv.m32431e(maVar.mo32736a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zztv.m32431e(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: b */
    static int m31806b(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m31837j(list) + (size * zztv.m32429e(i));
    }

    /* renamed from: a */
    static int m31793a(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C9988ma) {
            C9988ma maVar = (C9988ma) list;
            i = 0;
            while (i2 < size) {
                i += zztv.m32435f(maVar.mo32736a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zztv.m32435f(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: c */
    static int m31812c(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m31793a(list) + (size * zztv.m32429e(i));
    }

    /* renamed from: b */
    static int m31807b(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C9964ea) {
            C9964ea eaVar = (C9964ea) list;
            i = 0;
            while (i2 < size) {
                i += zztv.m32449k(eaVar.mo32719a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zztv.m32449k(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: d */
    static int m31816d(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m31807b(list) + (size * zztv.m32429e(i));
    }

    /* renamed from: c */
    static int m31813c(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C9964ea) {
            C9964ea eaVar = (C9964ea) list;
            i = 0;
            while (i2 < size) {
                i += zztv.m32432f(eaVar.mo32719a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zztv.m32432f(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: e */
    static int m31820e(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m31813c(list) + (size * zztv.m32429e(i));
    }

    /* renamed from: d */
    static int m31817d(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C9964ea) {
            C9964ea eaVar = (C9964ea) list;
            i = 0;
            while (i2 < size) {
                i += zztv.m32436g(eaVar.mo32719a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zztv.m32436g(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: f */
    static int m31824f(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m31817d(list) + (size * zztv.m32429e(i));
    }

    /* renamed from: e */
    static int m31821e(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C9964ea) {
            C9964ea eaVar = (C9964ea) list;
            i = 0;
            while (i2 < size) {
                i += zztv.m32440h(eaVar.mo32719a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zztv.m32440h(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: g */
    static int m31827g(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m31821e(list) + (size * zztv.m32429e(i));
    }

    /* renamed from: f */
    static int m31825f(List<?> list) {
        return list.size() << 2;
    }

    /* renamed from: h */
    static int m31830h(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zztv.m32445i(i, 0);
    }

    /* renamed from: g */
    static int m31828g(List<?> list) {
        return list.size() << 3;
    }

    /* renamed from: i */
    static int m31833i(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zztv.m32438g(i, 0);
    }

    /* renamed from: h */
    static int m31831h(List<?> list) {
        return list.size();
    }

    /* renamed from: j */
    static int m31836j(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zztv.m32418b(i, true);
    }

    /* renamed from: a */
    static int m31790a(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int e = zztv.m32429e(i) * size;
        if (list instanceof zzve) {
            zzve zzve = (zzve) list;
            while (i4 < size) {
                Object f = zzve.mo32917f(i4);
                if (f instanceof zzte) {
                    i3 = zztv.m32404a((zzte) f);
                } else {
                    i3 = zztv.m32408a((String) f);
                }
                e += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzte) {
                    i2 = zztv.m32404a((zzte) obj);
                } else {
                    i2 = zztv.m32408a((String) obj);
                }
                e += i2;
                i4++;
            }
        }
        return e;
    }

    /* renamed from: a */
    static int m31789a(int i, Object obj, C9906Fa fa) {
        if (obj instanceof zzvc) {
            return zztv.m32403a(i, (zzvc) obj);
        }
        return zztv.m32416b(i, (zzvv) obj, fa);
    }

    /* renamed from: a */
    static int m31791a(int i, List<?> list, C9906Fa fa) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e = zztv.m32429e(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzvc) {
                i2 = zztv.m32405a((zzvc) obj);
            } else {
                i2 = zztv.m32407a((zzvv) obj, fa);
            }
            e += i2;
        }
        return e;
    }

    /* renamed from: b */
    static int m31804b(int i, List<zzte> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e = size * zztv.m32429e(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            e += zztv.m32404a((zzte) list.get(i2));
        }
        return e;
    }

    /* renamed from: b */
    static int m31805b(int i, List<zzvv> list, C9906Fa fa) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zztv.m32425c(i, (zzvv) list.get(i3), fa);
        }
        return i2;
    }

    /* renamed from: a */
    public static C9939Wa<?, ?> m31794a() {
        return f30002b;
    }

    /* renamed from: b */
    public static C9939Wa<?, ?> m31808b() {
        return f30003c;
    }

    /* renamed from: c */
    public static C9939Wa<?, ?> m31814c() {
        return f30004d;
    }

    /* renamed from: a */
    private static C9939Wa<?, ?> m31795a(boolean z) {
        try {
            Class e = m31822e();
            if (e == null) {
                return null;
            }
            return (C9939Wa) e.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: d */
    private static Class<?> m31818d() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: e */
    private static Class<?> m31822e() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: a */
    static boolean m31803a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    static <T> void m31801a(C10000ra raVar, T t, T t2, long j) {
        C9946_a.m31994a((Object) t, j, raVar.mo32751a(C9946_a.m32016f(t, j), C9946_a.m32016f(t2, j)));
    }

    /* renamed from: a */
    static <T, FT extends zzuh<FT>> void m31799a(C9938W<FT> w, T t, T t2) {
        C9944Z a = w.mo32662a((Object) t2);
        if (!a.mo32686b()) {
            w.mo32665b(t).mo32685a(a);
        }
    }

    /* renamed from: a */
    static <T, UT, UB> void m31800a(C9939Wa<UT, UB> wa, T t, T t2) {
        wa.mo32669a((Object) t, wa.mo32671b(wa.mo32670b(t), wa.mo32670b(t2)));
    }
}
