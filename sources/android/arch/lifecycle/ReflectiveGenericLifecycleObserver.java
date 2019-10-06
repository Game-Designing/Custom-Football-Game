package android.arch.lifecycle;

import android.arch.lifecycle.C0148d.C0000a;

class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {

    /* renamed from: a */
    private final Object f194a;

    /* renamed from: b */
    private final C0144a f195b = C0143a.f197a.mo3743a(this.f194a.getClass());

    ReflectiveGenericLifecycleObserver(Object wrapped) {
        this.f194a = wrapped;
    }

    /* renamed from: a */
    public void mo3724a(C0001f source, C0000a event) {
        this.f195b.mo3745a(source, event, this.f194a);
    }
}
