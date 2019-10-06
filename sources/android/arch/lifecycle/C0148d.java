package android.arch.lifecycle;

/* renamed from: android.arch.lifecycle.d */
/* compiled from: Lifecycle */
public abstract class C0148d {

    /* renamed from: android.arch.lifecycle.d$a */
    /* compiled from: Lifecycle */
    public enum C0000a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    /* renamed from: android.arch.lifecycle.d$b */
    /* compiled from: Lifecycle */
    public enum C0149b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        /* renamed from: a */
        public boolean mo3753a(C0149b state) {
            return compareTo(state) >= 0;
        }
    }

    /* renamed from: a */
    public abstract C0149b mo3750a();

    /* renamed from: a */
    public abstract void mo3751a(C0150e eVar);

    /* renamed from: b */
    public abstract void mo3752b(C0150e eVar);
}
