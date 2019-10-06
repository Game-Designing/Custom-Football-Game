package p320f.p321a.p327d.p336f;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p320f.p321a.p327d.p330c.C13273h;
import p320f.p321a.p327d.p340j.C13758q;

/* renamed from: f.a.d.f.b */
/* compiled from: SpscArrayQueue */
public final class C13705b<E> extends AtomicReferenceArray<E> implements C13273h<E> {

    /* renamed from: a */
    private static final Integer f41741a = Integer.getInteger("jctools.spsc.max.lookahead.step", Opcodes.ACC_SYNTHETIC);

    /* renamed from: b */
    final int f41742b = (length() - 1);

    /* renamed from: c */
    final AtomicLong f41743c = new AtomicLong();

    /* renamed from: d */
    long f41744d;

    /* renamed from: e */
    final AtomicLong f41745e = new AtomicLong();

    /* renamed from: f */
    final int f41746f;

    public C13705b(int capacity) {
        super(C13758q.m43796a(capacity));
        this.f41746f = Math.min(capacity / 4, f41741a.intValue());
    }

    public boolean offer(E e) {
        if (e != null) {
            int mask = this.f41742b;
            long index = this.f41743c.get();
            int offset = mo42683a(index, mask);
            if (index >= this.f41744d) {
                int step = this.f41746f;
                if (mo42684a(mo42683a(((long) step) + index, mask)) == null) {
                    this.f41744d = ((long) step) + index;
                } else if (mo42684a(offset) != null) {
                    return false;
                }
            }
            mo42685a(offset, e);
            mo42687c(1 + index);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public E poll() {
        long index = this.f41745e.get();
        int offset = mo42682a(index);
        E e = mo42684a(offset);
        if (e == null) {
            return null;
        }
        mo42686b(1 + index);
        mo42685a(offset, (E) null);
        return e;
    }

    public boolean isEmpty() {
        return this.f41743c.get() == this.f41745e.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo42687c(long newIndex) {
        this.f41743c.lazySet(newIndex);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo42686b(long newIndex) {
        this.f41745e.lazySet(newIndex);
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo42683a(long index, int mask) {
        return ((int) index) & mask;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo42682a(long index) {
        return ((int) index) & this.f41742b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo42685a(int offset, E value) {
        lazySet(offset, value);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public E mo42684a(int offset) {
        return get(offset);
    }
}
