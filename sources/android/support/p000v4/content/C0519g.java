package android.support.p000v4.content;

import android.os.Binder;
import android.os.Process;

/* renamed from: android.support.v4.content.g */
/* compiled from: ModernAsyncTask */
class C0519g extends C0526d<Params, Result> {

    /* renamed from: b */
    final /* synthetic */ C0522j f1686b;

    C0519g(C0522j this$0) {
        this.f1686b = this$0;
    }

    public Result call() throws Exception {
        this.f1686b.f1698j.set(true);
        Result result = null;
        try {
            Process.setThreadPriority(10);
            result = this.f1686b.mo5271a(this.f1705a);
            Binder.flushPendingCommands();
            this.f1686b.mo5326d(result);
            return result;
        } catch (Throwable th) {
            this.f1686b.mo5326d(result);
            throw th;
        }
    }
}
