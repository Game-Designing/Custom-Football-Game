package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* renamed from: com.google.android.exoplayer2.util.y */
/* compiled from: SlidingPercentile */
public class C8540y {

    /* renamed from: a */
    private static final Comparator<C8541a> f18869a = C8511b.f18805a;

    /* renamed from: b */
    private static final Comparator<C8541a> f18870b = C8512c.f18806a;

    /* renamed from: c */
    private final int f18871c;

    /* renamed from: d */
    private final ArrayList<C8541a> f18872d = new ArrayList<>();

    /* renamed from: e */
    private final C8541a[] f18873e = new C8541a[5];

    /* renamed from: f */
    private int f18874f = -1;

    /* renamed from: g */
    private int f18875g;

    /* renamed from: h */
    private int f18876h;

    /* renamed from: i */
    private int f18877i;

    /* renamed from: com.google.android.exoplayer2.util.y$a */
    /* compiled from: SlidingPercentile */
    private static class C8541a {

        /* renamed from: a */
        public int f18878a;

        /* renamed from: b */
        public int f18879b;

        /* renamed from: c */
        public float f18880c;

        private C8541a() {
        }
    }

    /* renamed from: a */
    static /* synthetic */ int m20627a(C8541a a, C8541a b) {
        return a.f18878a - b.f18878a;
    }

    public C8540y(int maxWeight) {
        this.f18871c = maxWeight;
    }

    /* renamed from: a */
    public void mo26152a(int weight, float value) {
        C8541a newSample;
        m20628a();
        int i = this.f18877i;
        if (i > 0) {
            C8541a[] aVarArr = this.f18873e;
            int i2 = i - 1;
            this.f18877i = i2;
            newSample = aVarArr[i2];
        } else {
            newSample = new C8541a();
        }
        int i3 = this.f18875g;
        this.f18875g = i3 + 1;
        newSample.f18878a = i3;
        newSample.f18879b = weight;
        newSample.f18880c = value;
        this.f18872d.add(newSample);
        this.f18876h += weight;
        while (true) {
            int i4 = this.f18876h;
            int i5 = this.f18871c;
            if (i4 > i5) {
                int excessWeight = i4 - i5;
                C8541a oldestSample = (C8541a) this.f18872d.get(0);
                int i6 = oldestSample.f18879b;
                if (i6 <= excessWeight) {
                    this.f18876h -= i6;
                    this.f18872d.remove(0);
                    int i7 = this.f18877i;
                    if (i7 < 5) {
                        C8541a[] aVarArr2 = this.f18873e;
                        this.f18877i = i7 + 1;
                        aVarArr2[i7] = oldestSample;
                    }
                } else {
                    oldestSample.f18879b = i6 - excessWeight;
                    this.f18876h -= excessWeight;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public float mo26151a(float percentile) {
        float f;
        m20630b();
        float desiredWeight = ((float) this.f18876h) * percentile;
        int accumulatedWeight = 0;
        for (int i = 0; i < this.f18872d.size(); i++) {
            C8541a currentSample = (C8541a) this.f18872d.get(i);
            accumulatedWeight += currentSample.f18879b;
            if (((float) accumulatedWeight) >= desiredWeight) {
                return currentSample.f18880c;
            }
        }
        if (this.f18872d.isEmpty()) {
            f = Float.NaN;
        } else {
            ArrayList<C8541a> arrayList = this.f18872d;
            f = ((C8541a) arrayList.get(arrayList.size() - 1)).f18880c;
        }
        return f;
    }

    /* renamed from: a */
    private void m20628a() {
        if (this.f18874f != 1) {
            Collections.sort(this.f18872d, f18869a);
            this.f18874f = 1;
        }
    }

    /* renamed from: b */
    private void m20630b() {
        if (this.f18874f != 0) {
            Collections.sort(this.f18872d, f18870b);
            this.f18874f = 0;
        }
    }
}
