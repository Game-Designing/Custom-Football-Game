package android.arch.lifecycle;

import android.arch.lifecycle.C0148d.C0000a;

class FullLifecycleObserverAdapter implements GenericLifecycleObserver {

    /* renamed from: a */
    private final FullLifecycleObserver f177a;

    FullLifecycleObserverAdapter(FullLifecycleObserver observer) {
        this.f177a = observer;
    }

    /* renamed from: a */
    public void mo3724a(C0001f source, C0000a event) {
        switch (C0146b.f204a[event.ordinal()]) {
            case 1:
                this.f177a.mo3726b(source);
                return;
            case 2:
                this.f177a.mo3727c(source);
                return;
            case 3:
                this.f177a.mo3729e(source);
                return;
            case 4:
                this.f177a.mo3728d(source);
                return;
            case 5:
                this.f177a.mo3730f(source);
                return;
            case 6:
                this.f177a.mo3725a(source);
                return;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
