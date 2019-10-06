package android.support.p000v4.app;

import android.support.p000v4.view.C0646w;
import android.view.View;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: android.support.v4.app.U */
/* compiled from: FragmentTransitionImpl */
class C0440U implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ArrayList f1497a;

    /* renamed from: b */
    final /* synthetic */ Map f1498b;

    /* renamed from: c */
    final /* synthetic */ C0441V f1499c;

    C0440U(C0441V this$0, ArrayList arrayList, Map map) {
        this.f1499c = this$0;
        this.f1497a = arrayList;
        this.f1498b = map;
    }

    public void run() {
        int numSharedElements = this.f1497a.size();
        for (int i = 0; i < numSharedElements; i++) {
            View view = (View) this.f1497a.get(i);
            C0646w.m2960a(view, (String) this.f1498b.get(C0646w.m2979m(view)));
        }
    }
}
