package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.observers.BlockingObserver;
import io.reactivex.internal.observers.LambdaObserver;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p326c.C13199a;
import p320f.p321a.p326c.C13204f;
import p320f.p321a.p327d.p329b.C13226a;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p331d.C13282h;
import p320f.p321a.p327d.p331d.C13290p;
import p320f.p321a.p327d.p340j.C13743e;
import p320f.p321a.p327d.p340j.C13744f;
import p320f.p321a.p327d.p340j.C13748j;
import p320f.p321a.p327d.p340j.C13753n;

/* renamed from: f.a.d.e.b.k */
/* compiled from: ObservableBlockingSubscribe */
public final class C13548k {
    /* renamed from: a */
    public static <T> void m43507a(C13802r<? extends T> o, C13804t<? super T> observer) {
        BlockingQueue<Object> queue = new LinkedBlockingQueue<>();
        BlockingObserver<T> bs = new C13282h<>(queue);
        observer.onSubscribe(bs);
        o.subscribe(bs);
        while (!bs.mo42326a()) {
            Object v = queue.poll();
            if (v == null) {
                try {
                    v = queue.take();
                } catch (InterruptedException ex) {
                    bs.dispose();
                    observer.onError(ex);
                    return;
                }
            }
            if (!bs.mo42326a() && o != C13282h.f40367a) {
                if (C13753n.m43779b(v, observer)) {
                    break;
                }
            } else {
                break;
            }
        }
    }

    /* renamed from: a */
    public static <T> void m43505a(C13802r<? extends T> o) {
        C13744f callback = new C13744f();
        LambdaObserver<T> ls = new C13290p<>(C13226a.m43200d(), callback, callback, C13226a.m43200d());
        o.subscribe(ls);
        C13743e.m43753a(callback, ls);
        Throwable e = callback.f41850a;
        if (e != null) {
            throw C13748j.m43761a(e);
        }
    }

    /* renamed from: a */
    public static <T> void m43506a(C13802r<? extends T> o, C13204f<? super T> onNext, C13204f<? super Throwable> onError, C13199a onComplete) {
        C13264b.m43226a(onNext, "onNext is null");
        C13264b.m43226a(onError, "onError is null");
        C13264b.m43226a(onComplete, "onComplete is null");
        m43507a(o, new C13290p(onNext, onError, onComplete, C13226a.m43200d()));
    }
}
