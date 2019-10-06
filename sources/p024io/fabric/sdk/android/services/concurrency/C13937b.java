package p024io.fabric.sdk.android.services.concurrency;

import android.os.Process;

/* renamed from: io.fabric.sdk.android.services.concurrency.b */
/* compiled from: AsyncTask */
class C13937b extends C13945e<Params, Result> {

    /* renamed from: b */
    final /* synthetic */ C13940e f42269b;

    C13937b(C13940e this$0) {
        this.f42269b = this$0;
        super(null);
    }

    public Result call() throws Exception {
        this.f42269b.f42285n.set(true);
        Process.setThreadPriority(10);
        C13940e eVar = this.f42269b;
        Result a = eVar.mo43356a(this.f42294a);
        eVar.m44311e(a);
        return a;
    }
}
