package com.trello.rxlifecycle;

import p026rx.exceptions.C14927a;
import p026rx.p027b.C0132p;

/* renamed from: com.trello.rxlifecycle.a */
/* compiled from: Functions */
class C12541a implements C0132p<Throwable, Boolean> {
    C12541a() {
    }

    /* renamed from: a */
    public Boolean call(Throwable throwable) {
        if (throwable instanceof OutsideLifecycleException) {
            return Boolean.valueOf(true);
        }
        C14927a.m46677b(throwable);
        throw null;
    }
}
