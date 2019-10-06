package android.support.transition;

import android.support.transition.C0334M.C0337c;
import android.view.View;
import java.util.ArrayList;

/* renamed from: android.support.transition.t */
/* compiled from: FragmentTransitionSupport */
class C0396t implements C0337c {

    /* renamed from: a */
    final /* synthetic */ View f1314a;

    /* renamed from: b */
    final /* synthetic */ ArrayList f1315b;

    /* renamed from: c */
    final /* synthetic */ FragmentTransitionSupport f1316c;

    C0396t(FragmentTransitionSupport this$0, View view, ArrayList arrayList) {
        this.f1316c = this$0;
        this.f1314a = view;
        this.f1315b = arrayList;
    }

    /* renamed from: c */
    public void mo4786c(C0334M transition) {
    }

    /* renamed from: d */
    public void mo4787d(C0334M transition) {
        transition.mo4764b((C0337c) this);
        this.f1314a.setVisibility(8);
        int numViews = this.f1315b.size();
        for (int i = 0; i < numViews; i++) {
            ((View) this.f1315b.get(i)).setVisibility(0);
        }
    }

    /* renamed from: b */
    public void mo4785b(C0334M transition) {
    }

    /* renamed from: a */
    public void mo4784a(C0334M transition) {
    }
}
