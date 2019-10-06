package p024io.fabric.sdk.android.services.concurrency;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* renamed from: io.fabric.sdk.android.services.concurrency.c */
/* compiled from: AsyncTask */
class C13938c extends FutureTask<Result> {

    /* renamed from: a */
    final /* synthetic */ C13940e f42270a;

    C13938c(C13940e this$0, Callable x0) {
        this.f42270a = this$0;
        super(x0);
    }

    /* access modifiers changed from: protected */
    public void done() {
        try {
            this.f42270a.m44312f(get());
        } catch (InterruptedException e) {
            Log.w("AsyncTask", e);
        } catch (ExecutionException e2) {
            throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
        } catch (CancellationException e3) {
            this.f42270a.m44312f(null);
        }
    }
}
