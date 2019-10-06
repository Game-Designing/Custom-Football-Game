package p024io.fabric.sdk.android.services.concurrency;

import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import p024io.fabric.sdk.android.services.concurrency.C13940e.C13944d;

/* renamed from: io.fabric.sdk.android.services.concurrency.m */
/* compiled from: PriorityAsyncTask */
public abstract class C13952m<Params, Progress, Result> extends C13940e<Params, Progress, Result> implements C13948h<C13960s>, C13956p, C13960s, C13947g {

    /* renamed from: o */
    private final C13957q f42305o = new C13957q();

    /* renamed from: io.fabric.sdk.android.services.concurrency.m$a */
    /* compiled from: PriorityAsyncTask */
    private static class C13953a<Result> implements Executor {

        /* renamed from: a */
        private final Executor f42306a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final C13952m f42307b;

        public C13953a(Executor ex, C13952m task) {
            this.f42306a = ex;
            this.f42307b = task;
        }

        public void execute(Runnable command) {
            this.f42306a.execute(new C13951l(this, command, null));
        }
    }

    /* renamed from: a */
    public final void mo43406a(ExecutorService exec, Params... params) {
        super.mo43372a(new C13953a(exec, this), params);
    }

    public int compareTo(Object another) {
        return C13950k.m44332a(this, another);
    }

    /* renamed from: a */
    public void mo43381a(C13960s task) {
        if (mo43375d() == C13944d.PENDING) {
            ((C13948h) ((C13956p) mo43410g())).mo43381a(task);
            return;
        }
        throw new IllegalStateException("Must not add Dependency after task is running");
    }

    /* renamed from: c */
    public Collection<C13960s> mo43383c() {
        return ((C13948h) ((C13956p) mo43410g())).mo43383c();
    }

    /* renamed from: b */
    public boolean mo43382b() {
        return ((C13948h) ((C13956p) mo43410g())).mo43382b();
    }

    /* renamed from: a */
    public void mo43407a(boolean finished) {
        ((C13960s) ((C13956p) mo43410g())).mo43407a(finished);
    }

    /* renamed from: a */
    public boolean mo43408a() {
        return ((C13960s) ((C13956p) mo43410g())).mo43408a();
    }

    /* renamed from: a */
    public void mo43405a(Throwable throwable) {
        ((C13960s) ((C13956p) mo43410g())).mo43405a(throwable);
    }

    /* renamed from: g */
    public <T extends C13948h<C13960s> & C13956p & C13960s> T mo43410g() {
        return this.f42305o;
    }
}
