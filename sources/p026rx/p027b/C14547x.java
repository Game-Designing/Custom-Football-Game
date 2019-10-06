package p026rx.p027b;

/* renamed from: rx.b.x */
/* compiled from: Functions */
class C14547x implements C14545u<R> {

    /* renamed from: a */
    final /* synthetic */ C14542r f43354a;

    C14547x(C14542r rVar) {
        this.f43354a = rVar;
    }

    public R call(Object... args) {
        if (args.length == 3) {
            return this.f43354a.call(args[0], args[1], args[2]);
        }
        throw new IllegalArgumentException("Func3 expecting 3 arguments.");
    }
}
