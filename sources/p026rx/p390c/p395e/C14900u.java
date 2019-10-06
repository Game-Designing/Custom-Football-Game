package p026rx.p390c.p395e;

import p026rx.p027b.C0132p;

/* renamed from: rx.c.e.u */
/* compiled from: UtilityFunctions */
public final class C14900u {

    /* renamed from: rx.c.e.u$a */
    /* compiled from: UtilityFunctions */
    enum C14901a implements C0132p<Object, Boolean> {
        INSTANCE;

        public Boolean call(Object o) {
            return Boolean.valueOf(true);
        }
    }

    /* renamed from: rx.c.e.u$b */
    /* compiled from: UtilityFunctions */
    enum C14902b implements C0132p<Object, Object> {
        INSTANCE;

        public Object call(Object o) {
            return o;
        }
    }

    /* renamed from: a */
    public static <T> C0132p<? super T, Boolean> m46629a() {
        return C14901a.INSTANCE;
    }

    /* renamed from: b */
    public static <T> C0132p<T, T> m46630b() {
        return C14902b.INSTANCE;
    }
}
