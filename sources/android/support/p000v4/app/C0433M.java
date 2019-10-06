package android.support.p000v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

/* renamed from: android.support.v4.app.M */
/* compiled from: FragmentTransitionCompat21 */
class C0433M extends EpicenterCallback {

    /* renamed from: a */
    final /* synthetic */ Rect f1474a;

    /* renamed from: b */
    final /* synthetic */ C0437Q f1475b;

    C0433M(C0437Q this$0, Rect rect) {
        this.f1475b = this$0;
        this.f1474a = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        return this.f1474a;
    }
}
