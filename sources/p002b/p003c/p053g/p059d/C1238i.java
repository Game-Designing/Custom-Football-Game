package p002b.p003c.p053g.p059d;

import android.os.Handler;
import java.util.concurrent.Callable;
import p002b.p003c.p053g.p059d.C1240k.C1241a;

/* renamed from: b.c.g.d.i */
/* compiled from: SelfDestructiveThread */
class C1238i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Callable f3989a;

    /* renamed from: b */
    final /* synthetic */ Handler f3990b;

    /* renamed from: c */
    final /* synthetic */ C1241a f3991c;

    /* renamed from: d */
    final /* synthetic */ C1240k f3992d;

    C1238i(C1240k this$0, Callable callable, Handler handler, C1241a aVar) {
        this.f3992d = this$0;
        this.f3989a = callable;
        this.f3990b = handler;
        this.f3991c = aVar;
    }

    public void run() {
        T t;
        try {
            t = this.f3989a.call();
        } catch (Exception e) {
            t = null;
        }
        this.f3990b.post(new C1237h(this, t));
    }
}
