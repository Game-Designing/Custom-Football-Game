package p026rx.p390c.p395e.p396a;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p026rx.p390c.p395e.p397b.C14849j;

/* renamed from: rx.c.e.a.a */
/* compiled from: AtomicReferenceArrayQueue */
abstract class C14824a<E> extends AbstractQueue<E> {

    /* renamed from: a */
    protected final AtomicReferenceArray<E> f44082a;

    /* renamed from: b */
    protected final int f44083b;

    public C14824a(int capacity) {
        int actualCapacity = C14849j.m46569b(capacity);
        this.f44083b = actualCapacity - 1;
        this.f44082a = new AtomicReferenceArray<>(actualCapacity);
    }

    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo45951a(long index, int mask) {
        return ((int) index) & mask;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo45950a(long index) {
        return ((int) index) & this.f44083b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final E mo45953a(AtomicReferenceArray<E> buffer, int offset) {
        return buffer.get(offset);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo45954a(AtomicReferenceArray<E> buffer, int offset, E value) {
        buffer.lazySet(offset, value);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final E mo45952a(int offset) {
        return mo45953a(this.f44082a, offset);
    }
}
