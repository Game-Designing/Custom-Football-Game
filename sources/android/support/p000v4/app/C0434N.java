package android.support.p000v4.app;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import android.view.View;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.N */
/* compiled from: FragmentTransitionCompat21 */
class C0434N implements TransitionListener {

    /* renamed from: a */
    final /* synthetic */ View f1476a;

    /* renamed from: b */
    final /* synthetic */ ArrayList f1477b;

    /* renamed from: c */
    final /* synthetic */ C0437Q f1478c;

    C0434N(C0437Q this$0, View view, ArrayList arrayList) {
        this.f1478c = this$0;
        this.f1476a = view;
        this.f1477b = arrayList;
    }

    public void onTransitionStart(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
        this.f1476a.setVisibility(8);
        int numViews = this.f1477b.size();
        for (int i = 0; i < numViews; i++) {
            ((View) this.f1477b.get(i)).setVisibility(0);
        }
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }
}
