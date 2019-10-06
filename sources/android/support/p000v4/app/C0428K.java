package android.support.p000v4.app;

import android.graphics.Rect;
import android.support.v4.util.ArrayMap;
import android.view.View;
import java.util.ArrayList;
import p002b.p003c.p053g.p061f.C1253b;

/* renamed from: android.support.v4.app.K */
/* compiled from: FragmentTransition */
class C0428K implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0441V f1438a;

    /* renamed from: b */
    final /* synthetic */ C1253b f1439b;

    /* renamed from: c */
    final /* synthetic */ Object f1440c;

    /* renamed from: d */
    final /* synthetic */ C0430a f1441d;

    /* renamed from: e */
    final /* synthetic */ ArrayList f1442e;

    /* renamed from: f */
    final /* synthetic */ View f1443f;

    /* renamed from: g */
    final /* synthetic */ Fragment f1444g;

    /* renamed from: h */
    final /* synthetic */ Fragment f1445h;

    /* renamed from: i */
    final /* synthetic */ boolean f1446i;

    /* renamed from: j */
    final /* synthetic */ ArrayList f1447j;

    /* renamed from: k */
    final /* synthetic */ Object f1448k;

    /* renamed from: l */
    final /* synthetic */ Rect f1449l;

    C0428K(C0441V v, C1253b bVar, Object obj, C0430a aVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.f1438a = v;
        this.f1439b = bVar;
        this.f1440c = obj;
        this.f1441d = aVar;
        this.f1442e = arrayList;
        this.f1443f = view;
        this.f1444g = fragment;
        this.f1445h = fragment2;
        this.f1446i = z;
        this.f1447j = arrayList2;
        this.f1448k = obj2;
        this.f1449l = rect;
    }

    public void run() {
        ArrayMap<String, View> inSharedElements = C0429L.m2210b(this.f1438a, this.f1439b, this.f1440c, this.f1441d);
        if (inSharedElements != null) {
            this.f1442e.addAll(inSharedElements.values());
            this.f1442e.add(this.f1443f);
        }
        C0429L.m2215b(this.f1444g, this.f1445h, this.f1446i, (C1253b<String, View>) inSharedElements, false);
        Object obj = this.f1440c;
        if (obj != null) {
            this.f1438a.mo4739b(obj, this.f1447j, this.f1442e);
            View inEpicenterView = C0429L.m2209b((C1253b<String, View>) inSharedElements, this.f1441d, this.f1448k, this.f1446i);
            if (inEpicenterView != null) {
                this.f1438a.mo5085a(inEpicenterView, this.f1449l);
            }
        }
    }
}
