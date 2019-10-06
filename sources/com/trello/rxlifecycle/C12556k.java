package com.trello.rxlifecycle;

import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: com.trello.rxlifecycle.k */
/* compiled from: UntilCorrespondingEventObservableTransformer */
final class C12556k<T, R> implements C0096f<T> {

    /* renamed from: a */
    final C0120S<R> f39016a;

    /* renamed from: b */
    final C0132p<R, R> f39017b;

    public C12556k(C0120S<R> sharedLifecycle, C0132p<R, R> correspondingEvents) {
        this.f39016a = sharedLifecycle;
        this.f39017b = correspondingEvents;
    }

    /* renamed from: a */
    public C0120S<T> call(C0120S<T> source) {
        return source.mo3665h(C12555j.m41056a(this.f39016a, this.f39017b));
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UntilCorrespondingEventObservableTransformer<?, ?> that = (C12556k) o;
        if (!this.f39016a.equals(that.f39016a)) {
            return false;
        }
        return this.f39017b.equals(that.f39017b);
    }

    public int hashCode() {
        return (this.f39016a.hashCode() * 31) + this.f39017b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UntilCorrespondingEventObservableTransformer{sharedLifecycle=");
        sb.append(this.f39016a);
        sb.append(", correspondingEvents=");
        sb.append(this.f39017b);
        sb.append('}');
        return sb.toString();
    }
}
