package p026rx.p390c.p393c;

import java.util.concurrent.TimeUnit;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C0137ja;
import p026rx.p027b.C0128a;
import p026rx.p029i.C14975b;
import p026rx.p029i.C14978f;

/* renamed from: rx.c.c.m */
/* compiled from: ImmediateScheduler */
public final class C14797m extends C0126V {

    /* renamed from: a */
    public static final C14797m f44024a = new C14797m();

    /* renamed from: rx.c.c.m$a */
    /* compiled from: ImmediateScheduler */
    final class C14798a extends C0127a implements C0137ja {

        /* renamed from: a */
        final C14975b f44025a = new C14975b();

        C14798a() {
        }

        /* renamed from: a */
        public C0137ja mo3709a(C0128a action, long delayTime, TimeUnit unit) {
            return mo3707a(new C14819z(action, this, C14797m.this.now() + unit.toMillis(delayTime)));
        }

        /* renamed from: a */
        public C0137ja mo3707a(C0128a action) {
            action.call();
            return C14978f.m46782b();
        }

        public void unsubscribe() {
            this.f44025a.unsubscribe();
        }

        public boolean isUnsubscribed() {
            return this.f44025a.isUnsubscribed();
        }
    }

    private C14797m() {
    }

    public C0127a createWorker() {
        return new C14798a();
    }
}
