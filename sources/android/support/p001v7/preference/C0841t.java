package android.support.p001v7.preference;

/* renamed from: android.support.v7.preference.t */
/* compiled from: PreferenceGroup */
class C0841t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PreferenceGroup f2527a;

    C0841t(PreferenceGroup this$0) {
        this.f2527a = this$0;
    }

    public void run() {
        synchronized (this) {
            this.f2527a.f2464T.clear();
        }
    }
}
