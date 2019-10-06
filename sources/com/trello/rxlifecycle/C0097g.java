package com.trello.rxlifecycle;

import com.trello.rxlifecycle.p264c.C12551a;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: com.trello.rxlifecycle.g */
/* compiled from: RxLifecycle */
public class C0097g {
    /* renamed from: a */
    public static <T, R> C0096f<T> m559a(C0120S<R> lifecycle, R event) {
        C12551a.m41054a(lifecycle, "lifecycle == null");
        C12551a.m41054a(event, "event == null");
        return new C12557l(lifecycle, event);
    }

    /* renamed from: a */
    public static <T, R> C0096f<T> m560a(C0120S<R> lifecycle, C0132p<R, R> correspondingEvents) {
        C12551a.m41054a(lifecycle, "lifecycle == null");
        C12551a.m41054a(correspondingEvents, "correspondingEvents == null");
        return new C12556k(lifecycle.mo3664h(), correspondingEvents);
    }
}
