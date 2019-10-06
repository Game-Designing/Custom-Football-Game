package com.google.android.exoplayer2.util;

import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.util.C */
/* compiled from: TimedValueQueue */
public final class C8505C<V> {

    /* renamed from: a */
    private long[] f18778a;

    /* renamed from: b */
    private V[] f18779b;

    /* renamed from: c */
    private int f18780c;

    /* renamed from: d */
    private int f18781d;

    public C8505C() {
        this(10);
    }

    public C8505C(int initialBufferSize) {
        this.f18778a = new long[initialBufferSize];
        this.f18779b = m20400a(initialBufferSize);
    }

    /* renamed from: a */
    public synchronized void mo26048a(long timestamp, V value) {
        m20402b(timestamp);
        m20401b();
        m20403b(timestamp, value);
    }

    /* renamed from: a */
    public synchronized void mo26047a() {
        this.f18780c = 0;
        this.f18781d = 0;
        Arrays.fill(this.f18779b, null);
    }

    /* renamed from: a */
    public synchronized V mo26046a(long timestamp) {
        return m20399a(timestamp, true);
    }

    /* renamed from: a */
    private V m20399a(long timestamp, boolean onlyOlder) {
        V value = null;
        long previousTimeDiff = Long.MAX_VALUE;
        while (this.f18781d > 0) {
            long timeDiff = timestamp - this.f18778a[this.f18780c];
            if (timeDiff < 0 && (onlyOlder || (-timeDiff) >= previousTimeDiff)) {
                break;
            }
            previousTimeDiff = timeDiff;
            V[] vArr = this.f18779b;
            int i = this.f18780c;
            value = vArr[i];
            vArr[i] = null;
            this.f18780c = (i + 1) % vArr.length;
            this.f18781d--;
        }
        return value;
    }

    /* renamed from: b */
    private void m20402b(long timestamp) {
        int i = this.f18781d;
        if (i > 0) {
            if (timestamp <= this.f18778a[((this.f18780c + i) - 1) % this.f18779b.length]) {
                mo26047a();
            }
        }
    }

    /* renamed from: b */
    private void m20401b() {
        int capacity = this.f18779b.length;
        if (this.f18781d >= capacity) {
            int newCapacity = capacity * 2;
            long[] newTimestamps = new long[newCapacity];
            V[] newValues = m20400a(newCapacity);
            int i = this.f18780c;
            int length = capacity - i;
            System.arraycopy(this.f18778a, i, newTimestamps, 0, length);
            System.arraycopy(this.f18779b, this.f18780c, newValues, 0, length);
            int i2 = this.f18780c;
            if (i2 > 0) {
                System.arraycopy(this.f18778a, 0, newTimestamps, length, i2);
                System.arraycopy(this.f18779b, 0, newValues, length, this.f18780c);
            }
            this.f18778a = newTimestamps;
            this.f18779b = newValues;
            this.f18780c = 0;
        }
    }

    /* renamed from: b */
    private void m20403b(long timestamp, V value) {
        int i = this.f18780c;
        int i2 = this.f18781d;
        int i3 = i + i2;
        V[] vArr = this.f18779b;
        int next = i3 % vArr.length;
        this.f18778a[next] = timestamp;
        vArr[next] = value;
        this.f18781d = i2 + 1;
    }

    /* renamed from: a */
    private static <V> V[] m20400a(int length) {
        return new Object[length];
    }
}
