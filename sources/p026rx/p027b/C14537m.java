package p026rx.p027b;

/* renamed from: rx.b.m */
/* compiled from: Actions */
public final class C14537m {

    /* renamed from: a */
    private static final C14539b f43351a = new C14539b();

    /* renamed from: rx.b.m$a */
    /* compiled from: Actions */
    static final class C14538a<T> implements C0129b<T> {

        /* renamed from: a */
        final C0128a f43352a;

        public C14538a(C0128a action) {
            this.f43352a = action;
        }

        public void call(T t) {
            this.f43352a.call();
        }
    }

    /* renamed from: rx.b.m$b */
    /* compiled from: Actions */
    static final class C14539b<T0, T1, T2, T3, T4, T5, T6, T7, T8> implements C0128a, C0129b<T0>, C14528c<T0, T1>, C14529d<T0, T1, T2>, C14530e<T0, T1, T2, T3>, C14531f<T0, T1, T2, T3, T4>, C14532g<T0, T1, T2, T3, T4, T5>, C14533h<T0, T1, T2, T3, T4, T5, T6>, C14534i<T0, T1, T2, T3, T4, T5, T6, T7>, C14535j<T0, T1, T2, T3, T4, T5, T6, T7, T8>, C14536l {
        C14539b() {
        }

        public void call() {
        }

        public void call(T0 t0) {
        }
    }

    /* renamed from: a */
    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> C14539b<T0, T1, T2, T3, T4, T5, T6, T7, T8> m46177a() {
        return f43351a;
    }

    /* renamed from: a */
    public static <T> C0129b<T> m46176a(C0128a action) {
        return new C14538a(action);
    }
}
