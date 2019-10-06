package p026rx.p390c.p395e.p396a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: rx.c.e.a.e */
/* compiled from: SpscAtomicArrayQueue */
public final class C14828e<E> extends C14824a<E> {

    /* renamed from: c */
    private static final Integer f44087c = Integer.getInteger("jctools.spsc.max.lookahead.step", Opcodes.ACC_SYNTHETIC);

    /* renamed from: d */
    final AtomicLong f44088d = new AtomicLong();

    /* renamed from: e */
    long f44089e;

    /* renamed from: f */
    final AtomicLong f44090f = new AtomicLong();

    /* renamed from: g */
    final int f44091g;

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ Iterator iterator() {
        super.iterator();
        throw null;
    }

    public C14828e(int capacity) {
        super(capacity);
        this.f44091g = Math.min(capacity / 4, f44087c.intValue());
    }

    public boolean offer(E e) {
        if (e != null) {
            AtomicReferenceArray<E> buffer = this.f44082a;
            int mask = this.f44083b;
            long index = this.f44088d.get();
            int offset = mo45951a(index, mask);
            if (index >= this.f44089e) {
                int step = this.f44091g;
                if (mo45953a(buffer, mo45951a(((long) step) + index, mask)) == null) {
                    this.f44089e = ((long) step) + index;
                } else if (mo45953a(buffer, offset) != null) {
                    return false;
                }
            }
            mo45954a(buffer, offset, e);
            m46503c(1 + index);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public E poll() {
        long index = this.f44090f.get();
        int offset = mo45950a(index);
        AtomicReferenceArray<E> lElementBuffer = this.f44082a;
        E e = mo45953a(lElementBuffer, offset);
        if (e == null) {
            return null;
        }
        mo45954a(lElementBuffer, offset, null);
        m46502b(1 + index);
        return e;
    }

    public E peek() {
        return mo45952a(mo45950a(this.f44090f.get()));
    }

    public int size() {
        long before;
        long currentProducerIndex;
        long after = m46500a();
        do {
            before = after;
            currentProducerIndex = m46501b();
            after = m46500a();
        } while (before != after);
        return (int) (currentProducerIndex - after);
    }

    public boolean isEmpty() {
        return m46501b() == m46500a();
    }

    /* renamed from: c */
    private void m46503c(long newIndex) {
        this.f44088d.lazySet(newIndex);
    }

    /* renamed from: b */
    private void m46502b(long newIndex) {
        this.f44090f.lazySet(newIndex);
    }

    /* renamed from: a */
    private long m46500a() {
        return this.f44090f.get();
    }

    /* renamed from: b */
    private long m46501b() {
        return this.f44088d.get();
    }
}
