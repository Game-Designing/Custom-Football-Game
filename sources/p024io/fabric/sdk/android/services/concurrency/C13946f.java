package p024io.fabric.sdk.android.services.concurrency;

/* renamed from: io.fabric.sdk.android.services.concurrency.f */
/* compiled from: AsyncTask */
class C13946f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Runnable f42295a;

    /* renamed from: b */
    final /* synthetic */ C13943c f42296b;

    C13946f(C13943c this$0, Runnable runnable) {
        this.f42296b = this$0;
        this.f42295a = runnable;
    }

    public void run() {
        try {
            this.f42295a.run();
        } finally {
            this.f42296b.mo43378a();
        }
    }
}
