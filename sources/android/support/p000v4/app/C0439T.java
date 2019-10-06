package android.support.p000v4.app;

import android.support.p000v4.view.C0646w;
import android.view.View;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: android.support.v4.app.T */
/* compiled from: FragmentTransitionImpl */
class C0439T implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ArrayList f1494a;

    /* renamed from: b */
    final /* synthetic */ Map f1495b;

    /* renamed from: c */
    final /* synthetic */ C0441V f1496c;

    C0439T(C0441V this$0, ArrayList arrayList, Map map) {
        this.f1496c = this$0;
        this.f1494a = arrayList;
        this.f1495b = map;
    }

    public void run() {
        int numSharedElements = this.f1494a.size();
        for (int i = 0; i < numSharedElements; i++) {
            View view = (View) this.f1494a.get(i);
            String name = C0646w.m2979m(view);
            if (name != null) {
                C0646w.m2960a(view, C0441V.m2260a(this.f1495b, name));
            }
        }
    }
}
