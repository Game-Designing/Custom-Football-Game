package p019d.p143b.p144a.p146b;

/* renamed from: d.b.a.b.Ba */
class C6947Ba implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6988a f12833a;

    private C6947Ba(C6988a aVar) {
        this.f12833a = aVar;
    }

    /* synthetic */ C6947Ba(C6988a aVar, C6994d dVar) {
        this(aVar);
    }

    public void run() {
        if (this.f12833a.f12968l != null) {
            try {
                this.f12833a.f12968l.loadDataWithBaseURL("/", "<html></html>", "text/html", null, "");
            } catch (Exception e) {
            }
        }
    }
}
