package com.trello.rxlifecycle;

import p026rx.p027b.C0132p;

/* renamed from: com.trello.rxlifecycle.h */
/* compiled from: TakeUntilGenerator */
class C12553h implements C0132p<T, Boolean> {

    /* renamed from: a */
    final /* synthetic */ Object f39015a;

    C12553h(Object obj) {
        this.f39015a = obj;
    }

    public Boolean call(T lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent.equals(this.f39015a));
    }
}
