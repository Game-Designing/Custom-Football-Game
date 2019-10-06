package com.trello.rxlifecycle;

import p026rx.p027b.C14541q;

/* renamed from: com.trello.rxlifecycle.i */
/* compiled from: TakeUntilGenerator */
class C12554i implements C14541q<T, T, Boolean> {
    C12554i() {
    }

    public Boolean call(T bindUntilEvent, T lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent.equals(bindUntilEvent));
    }
}
