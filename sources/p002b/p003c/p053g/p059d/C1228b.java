package p002b.p003c.p053g.p059d;

import android.content.Context;
import java.util.concurrent.Callable;

/* renamed from: b.c.g.d.b */
/* compiled from: FontsContractCompat */
class C1228b implements Callable<C1235c> {

    /* renamed from: a */
    final /* synthetic */ Context f3965a;

    /* renamed from: b */
    final /* synthetic */ C1227a f3966b;

    /* renamed from: c */
    final /* synthetic */ int f3967c;

    /* renamed from: d */
    final /* synthetic */ String f3968d;

    C1228b(Context context, C1227a aVar, int i, String str) {
        this.f3965a = context;
        this.f3966b = aVar;
        this.f3967c = i;
        this.f3968d = str;
    }

    public C1235c call() throws Exception {
        C1235c typeface = C1232f.m5845b(this.f3965a, this.f3966b, this.f3967c);
        if (typeface.f3984a != null) {
            C1232f.f3972a.put(this.f3968d, typeface.f3984a);
        }
        return typeface;
    }
}
