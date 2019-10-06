package com.trello.rxlifecycle;

import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14541q;

/* renamed from: com.trello.rxlifecycle.j */
/* compiled from: TakeUntilGenerator */
final class C12555j {
    /* renamed from: a */
    static <T> C0120S<T> m41055a(C0120S<T> lifecycle, T event) {
        return lifecycle.mo3679o(new C12553h(event));
    }

    /* renamed from: a */
    static <T> C0120S<Boolean> m41056a(C0120S<T> lifecycle, C0132p<T, T> correspondingEvents) {
        return C0120S.m641a(lifecycle.mo3629b(1).mo3669j(correspondingEvents), lifecycle.mo3606a(1), (C14541q<? super T1, ? super T2, ? extends R>) new C12554i<Object,Object,Object>()).mo3674l(C12552d.f39012a).mo3679o(C12552d.f39013b);
    }
}
