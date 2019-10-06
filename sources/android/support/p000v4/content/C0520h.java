package android.support.p000v4.content;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* renamed from: android.support.v4.content.h */
/* compiled from: ModernAsyncTask */
class C0520h extends FutureTask<Result> {

    /* renamed from: a */
    final /* synthetic */ C0522j f1687a;

    C0520h(C0522j this$0, Callable x0) {
        this.f1687a = this$0;
        super(x0);
    }

    /* access modifiers changed from: protected */
    public void done() {
        String str = "An error occurred while executing doInBackground()";
        try {
            this.f1687a.mo5327e(get());
        } catch (InterruptedException e) {
            Log.w("AsyncTask", e);
        } catch (ExecutionException e2) {
            throw new RuntimeException(str, e2.getCause());
        } catch (CancellationException e3) {
            this.f1687a.mo5327e(null);
        } catch (Throwable t) {
            throw new RuntimeException(str, t);
        }
    }
}
