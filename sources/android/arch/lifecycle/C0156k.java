package android.arch.lifecycle;

/* renamed from: android.arch.lifecycle.k */
/* compiled from: LiveData */
class C0156k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ LiveData f224a;

    C0156k(LiveData this$0) {
        this.f224a = this$0;
    }

    public void run() {
        synchronized (this.f224a.f179b) {
            try {
                Object newValue = this.f224a.f183f;
                try {
                    this.f224a.f183f = LiveData.f178a;
                    this.f224a.mo3735b(newValue);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }
}
