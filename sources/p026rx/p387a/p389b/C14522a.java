package p026rx.p387a.p389b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0126V;
import p026rx.p387a.p388a.C14519a;

/* renamed from: rx.a.b.a */
/* compiled from: AndroidSchedulers */
public final class C14522a {

    /* renamed from: a */
    private static final AtomicReference<C14522a> f43338a = new AtomicReference<>();

    /* renamed from: b */
    private final C0126V f43339b;

    /* renamed from: b */
    private static C14522a m46172b() {
        C14522a current;
        do {
            C14522a current2 = (C14522a) f43338a.get();
            if (current2 != null) {
                return current2;
            }
            current = new C14522a();
        } while (!f43338a.compareAndSet(null, current));
        return current;
    }

    private C14522a() {
        C0126V main = C14519a.m46165a().mo45716b().mo45718b();
        if (main != null) {
            this.f43339b = main;
        } else {
            this.f43339b = new C14523b(Looper.getMainLooper());
        }
    }

    /* renamed from: a */
    public static C0126V m46170a() {
        return m46172b().f43339b;
    }

    /* renamed from: a */
    public static C0126V m46171a(Looper looper) {
        if (looper != null) {
            return new C14523b(looper);
        }
        throw new NullPointerException("looper == null");
    }
}
