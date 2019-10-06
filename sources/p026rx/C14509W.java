package p026rx;

import p026rx.p027b.C0129b;

/* renamed from: rx.W */
/* compiled from: Single */
class C14509W extends C14972ha<T> {

    /* renamed from: b */
    final /* synthetic */ C0129b f43318b;

    /* renamed from: c */
    final /* synthetic */ C0129b f43319c;

    /* renamed from: d */
    final /* synthetic */ Single f43320d;

    C14509W(Single single, C0129b bVar, C0129b bVar2) {
        this.f43320d = single;
        this.f43318b = bVar;
        this.f43319c = bVar2;
    }

    public final void onError(Throwable e) {
        try {
            this.f43318b.call(e);
        } finally {
            unsubscribe();
        }
    }

    /* renamed from: a */
    public final void mo45712a(T args) {
        try {
            this.f43319c.call(args);
        } finally {
            unsubscribe();
        }
    }
}
