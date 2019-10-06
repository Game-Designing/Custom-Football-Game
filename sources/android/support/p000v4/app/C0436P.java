package android.support.p000v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

/* renamed from: android.support.v4.app.P */
/* compiled from: FragmentTransitionCompat21 */
class C0436P extends EpicenterCallback {

    /* renamed from: a */
    final /* synthetic */ Rect f1486a;

    /* renamed from: b */
    final /* synthetic */ C0437Q f1487b;

    C0436P(C0437Q this$0, Rect rect) {
        this.f1487b = this$0;
        this.f1486a = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        Rect rect = this.f1486a;
        if (rect == null || rect.isEmpty()) {
            return null;
        }
        return this.f1486a;
    }
}
