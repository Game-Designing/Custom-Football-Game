package android.support.p000v4.app;

import android.support.p000v4.view.C0646w;
import android.view.View;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.S */
/* compiled from: FragmentTransitionImpl */
class C0438S implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f1488a;

    /* renamed from: b */
    final /* synthetic */ ArrayList f1489b;

    /* renamed from: c */
    final /* synthetic */ ArrayList f1490c;

    /* renamed from: d */
    final /* synthetic */ ArrayList f1491d;

    /* renamed from: e */
    final /* synthetic */ ArrayList f1492e;

    /* renamed from: f */
    final /* synthetic */ C0441V f1493f;

    C0438S(C0441V this$0, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f1493f = this$0;
        this.f1488a = i;
        this.f1489b = arrayList;
        this.f1490c = arrayList2;
        this.f1491d = arrayList3;
        this.f1492e = arrayList4;
    }

    public void run() {
        for (int i = 0; i < this.f1488a; i++) {
            C0646w.m2960a((View) this.f1489b.get(i), (String) this.f1490c.get(i));
            C0646w.m2960a((View) this.f1491d.get(i), (String) this.f1492e.get(i));
        }
    }
}
