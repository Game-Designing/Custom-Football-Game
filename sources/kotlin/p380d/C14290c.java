package kotlin.p380d;

import java.util.NoSuchElementException;
import kotlin.p374a.C14267n;

/* renamed from: kotlin.d.c */
/* compiled from: ProgressionIterators.kt */
public final class C14290c extends C14267n {

    /* renamed from: a */
    private final int f43223a;

    /* renamed from: b */
    private boolean f43224b;

    /* renamed from: c */
    private int f43225c;

    /* renamed from: d */
    private final int f43226d;

    public C14290c(int first, int last, int step) {
        this.f43226d = step;
        this.f43223a = last;
        boolean z = true;
        if (this.f43226d <= 0 ? first < last : first > last) {
            z = false;
        }
        this.f43224b = z;
        this.f43225c = this.f43224b ? first : this.f43223a;
    }

    public boolean hasNext() {
        return this.f43224b;
    }

    public int nextInt() {
        int value = this.f43225c;
        if (value != this.f43223a) {
            this.f43225c += this.f43226d;
        } else if (this.f43224b) {
            this.f43224b = false;
        } else {
            throw new NoSuchElementException();
        }
        return value;
    }
}
