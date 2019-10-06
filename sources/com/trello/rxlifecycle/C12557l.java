package com.trello.rxlifecycle;

import p026rx.C0120S;

/* renamed from: com.trello.rxlifecycle.l */
/* compiled from: UntilEventObservableTransformer */
final class C12557l<T, R> implements C0096f<T> {

    /* renamed from: a */
    final C0120S<R> f39018a;

    /* renamed from: b */
    final R f39019b;

    public C12557l(C0120S<R> lifecycle, R event) {
        this.f39018a = lifecycle;
        this.f39019b = event;
    }

    /* renamed from: a */
    public C0120S<T> call(C0120S<T> source) {
        return source.mo3665h(C12555j.m41055a(this.f39018a, this.f39019b));
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UntilEventObservableTransformer<?, ?> that = (C12557l) o;
        if (!this.f39018a.equals(that.f39018a)) {
            return false;
        }
        return this.f39019b.equals(that.f39019b);
    }

    public int hashCode() {
        return (this.f39018a.hashCode() * 31) + this.f39019b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UntilEventObservableTransformer{lifecycle=");
        sb.append(this.f39018a);
        sb.append(", event=");
        sb.append(this.f39019b);
        sb.append('}');
        return sb.toString();
    }
}
