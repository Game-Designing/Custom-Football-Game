package android.support.p000v4.app;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.O */
/* compiled from: FragmentTransitionCompat21 */
class C0435O implements TransitionListener {

    /* renamed from: a */
    final /* synthetic */ Object f1479a;

    /* renamed from: b */
    final /* synthetic */ ArrayList f1480b;

    /* renamed from: c */
    final /* synthetic */ Object f1481c;

    /* renamed from: d */
    final /* synthetic */ ArrayList f1482d;

    /* renamed from: e */
    final /* synthetic */ Object f1483e;

    /* renamed from: f */
    final /* synthetic */ ArrayList f1484f;

    /* renamed from: g */
    final /* synthetic */ C0437Q f1485g;

    C0435O(C0437Q this$0, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.f1485g = this$0;
        this.f1479a = obj;
        this.f1480b = arrayList;
        this.f1481c = obj2;
        this.f1482d = arrayList2;
        this.f1483e = obj3;
        this.f1484f = arrayList3;
    }

    public void onTransitionStart(Transition transition) {
        Object obj = this.f1479a;
        if (obj != null) {
            this.f1485g.mo4733a(obj, this.f1480b, null);
        }
        Object obj2 = this.f1481c;
        if (obj2 != null) {
            this.f1485g.mo4733a(obj2, this.f1482d, null);
        }
        Object obj3 = this.f1483e;
        if (obj3 != null) {
            this.f1485g.mo4733a(obj3, this.f1484f, null);
        }
    }

    public void onTransitionEnd(Transition transition) {
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }
}
