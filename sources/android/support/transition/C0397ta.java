package android.support.transition;

import android.os.IBinder;

/* renamed from: android.support.transition.ta */
/* compiled from: WindowIdApi14 */
class C0397ta implements C0401va {

    /* renamed from: a */
    private final IBinder f1317a;

    C0397ta(IBinder token) {
        this.f1317a = token;
    }

    public boolean equals(Object o) {
        return (o instanceof C0397ta) && ((C0397ta) o).f1317a.equals(this.f1317a);
    }

    public int hashCode() {
        return this.f1317a.hashCode();
    }
}
