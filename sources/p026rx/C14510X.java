package p026rx;

/* renamed from: rx.X */
/* compiled from: Single */
class C14510X extends C14972ha<T> {

    /* renamed from: b */
    final /* synthetic */ C14511Y f43321b;

    C14510X(C14511Y y) {
        this.f43321b = y;
    }

    /* renamed from: a */
    public void mo45712a(T value) {
        try {
            this.f43321b.f43322a.mo45712a(value);
        } finally {
            this.f43321b.f43323b.unsubscribe();
        }
    }

    public void onError(Throwable error) {
        try {
            this.f43321b.f43322a.onError(error);
        } finally {
            this.f43321b.f43323b.unsubscribe();
        }
    }
}
