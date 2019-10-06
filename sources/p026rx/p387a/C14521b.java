package p026rx.p387a;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import p026rx.C0137ja;
import p026rx.p387a.p389b.C14522a;

/* renamed from: rx.a.b */
/* compiled from: MainThreadSubscription */
public abstract class C14521b implements C0137ja {
    private final AtomicBoolean unsubscribed = new AtomicBoolean();

    /* access modifiers changed from: protected */
    public abstract void onUnsubscribe();

    public static void verifyMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected to be called on the main thread but was ");
            sb.append(Thread.currentThread().getName());
            throw new IllegalStateException(sb.toString());
        }
    }

    public final boolean isUnsubscribed() {
        return this.unsubscribed.get();
    }

    public final void unsubscribe() {
        if (!this.unsubscribed.compareAndSet(false, true)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            onUnsubscribe();
        } else {
            C14522a.m46170a().createWorker().mo3707a(new C14518a(this));
        }
    }
}
