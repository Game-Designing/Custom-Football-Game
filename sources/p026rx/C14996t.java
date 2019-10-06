package p026rx;

import java.util.Arrays;
import java.util.Collection;
import p026rx.exceptions.C14927a;
import p026rx.exceptions.CompositeException;

/* renamed from: rx.t */
/* compiled from: Completable */
class C14996t implements C14503O {

    /* renamed from: a */
    final /* synthetic */ C14503O f44369a;

    /* renamed from: b */
    final /* synthetic */ C14997u f44370b;

    C14996t(C14997u uVar, C14503O o) {
        this.f44370b = uVar;
        this.f44369a = o;
    }

    public void onCompleted() {
        this.f44369a.onCompleted();
    }

    public void onError(Throwable e) {
        boolean b;
        try {
            b = ((Boolean) this.f44370b.f44371a.call(e)).booleanValue();
        } catch (Throwable ex) {
            C14927a.m46678c(ex);
            e = new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{e, ex}));
            b = false;
        }
        if (b) {
            this.f44369a.onCompleted();
        } else {
            this.f44369a.onError(e);
        }
    }

    /* renamed from: a */
    public void mo45688a(C0137ja d) {
        this.f44369a.mo45688a(d);
    }
}
