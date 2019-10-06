package android.support.p000v4.app;

import android.view.View;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.I */
/* compiled from: FragmentTransition */
class C0426I implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Object f1423a;

    /* renamed from: b */
    final /* synthetic */ C0441V f1424b;

    /* renamed from: c */
    final /* synthetic */ View f1425c;

    /* renamed from: d */
    final /* synthetic */ Fragment f1426d;

    /* renamed from: e */
    final /* synthetic */ ArrayList f1427e;

    /* renamed from: f */
    final /* synthetic */ ArrayList f1428f;

    /* renamed from: g */
    final /* synthetic */ ArrayList f1429g;

    /* renamed from: h */
    final /* synthetic */ Object f1430h;

    C0426I(Object obj, C0441V v, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.f1423a = obj;
        this.f1424b = v;
        this.f1425c = view;
        this.f1426d = fragment;
        this.f1427e = arrayList;
        this.f1428f = arrayList2;
        this.f1429g = arrayList3;
        this.f1430h = obj2;
    }

    public void run() {
        Object obj = this.f1423a;
        if (obj != null) {
            this.f1424b.mo4737b(obj, this.f1425c);
            this.f1428f.addAll(C0429L.m2213b(this.f1424b, this.f1423a, this.f1426d, this.f1427e, this.f1425c));
        }
        if (this.f1429g != null) {
            if (this.f1430h != null) {
                ArrayList<View> tempExiting = new ArrayList<>();
                tempExiting.add(this.f1425c);
                this.f1424b.mo4733a(this.f1430h, this.f1429g, tempExiting);
            }
            this.f1429g.clear();
            this.f1429g.add(this.f1425c);
        }
    }
}
