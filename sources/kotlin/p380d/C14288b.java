package kotlin.p380d;

import kotlin.p374a.C14267n;
import kotlin.p375b.C14269a;
import kotlin.p376c.p378b.p379a.C14276a;

/* renamed from: kotlin.d.b */
/* compiled from: Progressions.kt */
public class C14288b implements Iterable<Integer>, C14276a {

    /* renamed from: a */
    public static final C14289a f43219a = new C14289a(null);

    /* renamed from: b */
    private final int f43220b;

    /* renamed from: c */
    private final int f43221c;

    /* renamed from: d */
    private final int f43222d;

    /* renamed from: kotlin.d.b$a */
    /* compiled from: Progressions.kt */
    public static final class C14289a {
        private C14289a() {
        }

        public /* synthetic */ C14289a(C14280e $constructor_marker) {
            this();
        }

        /* renamed from: a */
        public final C14288b mo44468a(int rangeStart, int rangeEnd, int step) {
            return new C14288b(rangeStart, rangeEnd, step);
        }
    }

    public C14288b(int start, int endInclusive, int step) {
        if (step == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (step != Integer.MIN_VALUE) {
            this.f43220b = start;
            this.f43221c = C14269a.m45903a(start, endInclusive, step);
            this.f43222d = step;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final int getFirst() {
        return this.f43220b;
    }

    public final int getLast() {
        return this.f43221c;
    }

    /* renamed from: a */
    public final int mo44460a() {
        return this.f43222d;
    }

    public C14267n iterator() {
        return new C14290c(this.f43220b, this.f43221c, this.f43222d);
    }

    public boolean isEmpty() {
        if (this.f43222d > 0) {
            if (this.f43220b > this.f43221c) {
                return true;
            }
        } else if (this.f43220b < this.f43221c) {
            return true;
        }
        return false;
    }

    public boolean equals(Object other) {
        return (other instanceof C14288b) && ((isEmpty() && ((C14288b) other).isEmpty()) || (this.f43220b == ((C14288b) other).f43220b && this.f43221c == ((C14288b) other).f43221c && this.f43222d == ((C14288b) other).f43222d));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f43220b * 31) + this.f43221c) * 31) + this.f43222d;
    }

    public String toString() {
        int i;
        StringBuilder sb;
        String str = " step ";
        if (this.f43222d > 0) {
            sb = new StringBuilder();
            sb.append(this.f43220b);
            sb.append("..");
            sb.append(this.f43221c);
            sb.append(str);
            i = this.f43222d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f43220b);
            sb.append(" downTo ");
            sb.append(this.f43221c);
            sb.append(str);
            i = -this.f43222d;
        }
        sb.append(i);
        return sb.toString();
    }
}
