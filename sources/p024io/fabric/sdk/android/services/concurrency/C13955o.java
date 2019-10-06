package p024io.fabric.sdk.android.services.concurrency;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* renamed from: io.fabric.sdk.android.services.concurrency.o */
/* compiled from: PriorityFutureTask */
public class C13955o<V> extends FutureTask<V> implements C13948h<C13960s>, C13956p, C13960s, C13947g {

    /* renamed from: a */
    final Object f42308a;

    public C13955o(Callable<V> callable) {
        super(callable);
        this.f42308a = mo43413b(callable);
    }

    public C13955o(Runnable runnable, V result) {
        super(runnable, result);
        this.f42308a = mo43413b(runnable);
    }

    public int compareTo(Object another) {
        return ((C13956p) mo43403d()).compareTo(another);
    }

    /* renamed from: a */
    public void mo43381a(C13960s task) {
        ((C13948h) ((C13956p) mo43403d())).mo43381a(task);
    }

    /* renamed from: c */
    public Collection<C13960s> mo43383c() {
        return ((C13948h) ((C13956p) mo43403d())).mo43383c();
    }

    /* renamed from: b */
    public boolean mo43382b() {
        return ((C13948h) ((C13956p) mo43403d())).mo43382b();
    }

    public C13950k getPriority() {
        return ((C13956p) mo43403d()).getPriority();
    }

    /* renamed from: a */
    public void mo43407a(boolean finished) {
        ((C13960s) ((C13956p) mo43403d())).mo43407a(finished);
    }

    /* renamed from: a */
    public boolean mo43408a() {
        return ((C13960s) ((C13956p) mo43403d())).mo43408a();
    }

    /* renamed from: a */
    public void mo43405a(Throwable throwable) {
        ((C13960s) ((C13956p) mo43403d())).mo43405a(throwable);
    }

    /* renamed from: d */
    public <T extends C13948h<C13960s> & C13956p & C13960s> T mo43403d() {
        return (C13948h) this.f42308a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public <T extends C13948h<C13960s> & C13956p & C13960s> T mo43413b(Object object) {
        if (C13957q.m44353b(object)) {
            return (C13948h) object;
        }
        return new C13957q();
    }
}
