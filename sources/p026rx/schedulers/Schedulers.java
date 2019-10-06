package p026rx.schedulers;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0126V;
import p026rx.p390c.p393c.C14775B;
import p026rx.p390c.p393c.C14793j;
import p026rx.p390c.p393c.C14795k;
import p026rx.p390c.p393c.C14797m;
import p026rx.p390c.p393c.C14809t;
import p026rx.p400f.C14948s;
import p026rx.p400f.C14953x;
import p026rx.p400f.C14954y;

/* renamed from: rx.schedulers.Schedulers */
public final class Schedulers {

    /* renamed from: a */
    private static final AtomicReference<Schedulers> f162a = new AtomicReference<>();

    /* renamed from: b */
    private final C0126V f163b;

    /* renamed from: c */
    private final C0126V f164c;

    /* renamed from: d */
    private final C0126V f165d;

    /* renamed from: c */
    private static Schedulers m775c() {
        while (true) {
            Schedulers current = (Schedulers) f162a.get();
            if (current != null) {
                return current;
            }
            Schedulers current2 = new Schedulers();
            if (f162a.compareAndSet(null, current2)) {
                return current2;
            }
            current2.mo3718a();
        }
    }

    private Schedulers() {
        C14954y hook = C14953x.m46727c().mo46164e();
        C0126V c = hook.mo46167d();
        if (c != null) {
            this.f163b = c;
        } else {
            this.f163b = C14954y.m46733a();
        }
        C0126V io = hook.mo46168f();
        if (io != null) {
            this.f164c = io;
        } else {
            this.f164c = C14954y.m46735b();
        }
        C0126V nt = hook.mo46169g();
        if (nt != null) {
            this.f165d = nt;
        } else {
            this.f165d = C14954y.m46737c();
        }
    }

    public static C0126V immediate() {
        return C14797m.f44024a;
    }

    public static C0126V trampoline() {
        return C14775B.f43959a;
    }

    public static C0126V newThread() {
        return C14948s.m46721c(m775c().f165d);
    }

    public static C0126V computation() {
        return C14948s.m46712a(m775c().f163b);
    }

    /* renamed from: io */
    public static C0126V m776io() {
        return C14948s.m46716b(m775c().f164c);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static C0126V from(Executor executor) {
        return new C14793j(executor);
    }

    public static void reset() {
        Schedulers s = (Schedulers) f162a.getAndSet(null);
        if (s != null) {
            s.mo3718a();
        }
    }

    public static void start() {
        Schedulers s = m775c();
        s.mo3719b();
        synchronized (s) {
            C14795k.f44019c.start();
        }
    }

    public static void shutdown() {
        Schedulers s = m775c();
        s.mo3718a();
        synchronized (s) {
            C14795k.f44019c.shutdown();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized void mo3719b() {
        if (this.f163b instanceof C14809t) {
            ((C14809t) this.f163b).start();
        }
        if (this.f164c instanceof C14809t) {
            ((C14809t) this.f164c).start();
        }
        if (this.f165d instanceof C14809t) {
            ((C14809t) this.f165d).start();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo3718a() {
        if (this.f163b instanceof C14809t) {
            ((C14809t) this.f163b).shutdown();
        }
        if (this.f164c instanceof C14809t) {
            ((C14809t) this.f164c).shutdown();
        }
        if (this.f165d instanceof C14809t) {
            ((C14809t) this.f165d).shutdown();
        }
    }
}
