package p026rx.p027b;

/* renamed from: rx.b.w */
/* compiled from: Functions */
class C14546w implements C14545u<R> {

    /* renamed from: a */
    final /* synthetic */ C14541q f43353a;

    C14546w(C14541q qVar) {
        this.f43353a = qVar;
    }

    public R call(Object... args) {
        if (args.length == 2) {
            return this.f43353a.call(args[0], args[1]);
        }
        throw new IllegalArgumentException("Func2 expecting 2 arguments.");
    }
}
