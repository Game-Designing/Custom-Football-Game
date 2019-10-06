package p024io.fabric.sdk.android.services.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: io.fabric.sdk.android.services.concurrency.q */
/* compiled from: PriorityTask */
public class C13957q implements C13948h<C13960s>, C13956p, C13960s {

    /* renamed from: a */
    private final List<C13960s> f42309a = new ArrayList();

    /* renamed from: b */
    private final AtomicBoolean f42310b = new AtomicBoolean(false);

    /* renamed from: c */
    private final AtomicReference<Throwable> f42311c = new AtomicReference<>(null);

    /* renamed from: c */
    public synchronized Collection<C13960s> mo43383c() {
        return Collections.unmodifiableCollection(this.f42309a);
    }

    /* renamed from: a */
    public synchronized void mo43381a(C13960s task) {
        this.f42309a.add(task);
    }

    /* renamed from: b */
    public boolean mo43382b() {
        for (C13960s task : mo43383c()) {
            if (!task.mo43408a()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public synchronized void mo43407a(boolean finished) {
        this.f42310b.set(finished);
    }

    /* renamed from: a */
    public boolean mo43408a() {
        return this.f42310b.get();
    }

    public C13950k getPriority() {
        return C13950k.NORMAL;
    }

    /* renamed from: a */
    public void mo43405a(Throwable throwable) {
        this.f42311c.set(throwable);
    }

    public int compareTo(Object other) {
        return C13950k.m44332a(this, other);
    }

    /* renamed from: b */
    public static boolean m44353b(Object object) {
        boolean z = false;
        try {
            C13960s task = (C13960s) object;
            C13956p provider = (C13956p) object;
            if (!(((C13948h) object) == null || task == null || provider == null)) {
                z = true;
            }
            return z;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
