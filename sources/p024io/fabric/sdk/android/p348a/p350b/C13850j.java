package p024io.fabric.sdk.android.p348a.p350b;

import android.os.Process;

/* renamed from: io.fabric.sdk.android.a.b.j */
/* compiled from: BackgroundPriorityRunnable */
public abstract class C13850j implements Runnable {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo19461a();

    public final void run() {
        Process.setThreadPriority(10);
        mo19461a();
    }
}
