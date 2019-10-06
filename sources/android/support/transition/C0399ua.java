package android.support.transition;

import android.view.View;
import android.view.WindowId;

/* renamed from: android.support.transition.ua */
/* compiled from: WindowIdApi18 */
class C0399ua implements C0401va {

    /* renamed from: a */
    private final WindowId f1325a;

    C0399ua(View view) {
        this.f1325a = view.getWindowId();
    }

    public boolean equals(Object o) {
        return (o instanceof C0399ua) && ((C0399ua) o).f1325a.equals(this.f1325a);
    }

    public int hashCode() {
        return this.f1325a.hashCode();
    }
}
