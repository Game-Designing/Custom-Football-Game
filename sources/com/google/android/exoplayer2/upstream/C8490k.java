package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.upstream.k */
/* compiled from: DefaultAllocator */
public final class C8490k implements C8481d {

    /* renamed from: a */
    private final boolean f18723a;

    /* renamed from: b */
    private final int f18724b;

    /* renamed from: c */
    private final byte[] f18725c;

    /* renamed from: d */
    private final C8462c[] f18726d;

    /* renamed from: e */
    private int f18727e;

    /* renamed from: f */
    private int f18728f;

    /* renamed from: g */
    private int f18729g;

    /* renamed from: h */
    private C8462c[] f18730h;

    public C8490k(boolean trimOnReset, int individualAllocationSize) {
        this(trimOnReset, individualAllocationSize, 0);
    }

    public C8490k(boolean trimOnReset, int individualAllocationSize, int initialAllocationCount) {
        boolean z = false;
        C8514e.m20488a(individualAllocationSize > 0);
        if (initialAllocationCount >= 0) {
            z = true;
        }
        C8514e.m20488a(z);
        this.f18723a = trimOnReset;
        this.f18724b = individualAllocationSize;
        this.f18729g = initialAllocationCount;
        this.f18730h = new C8462c[(initialAllocationCount + 100)];
        if (initialAllocationCount > 0) {
            this.f18725c = new byte[(initialAllocationCount * individualAllocationSize)];
            for (int i = 0; i < initialAllocationCount; i++) {
                this.f18730h[i] = new C8462c(this.f18725c, i * individualAllocationSize);
            }
        } else {
            this.f18725c = null;
        }
        this.f18726d = new C8462c[1];
    }

    /* renamed from: e */
    public synchronized void mo26023e() {
        if (this.f18723a) {
            mo26021a(0);
        }
    }

    /* renamed from: a */
    public synchronized void mo26021a(int targetBufferSize) {
        boolean targetBufferSizeReduced = targetBufferSize < this.f18727e;
        this.f18727e = targetBufferSize;
        if (targetBufferSizeReduced) {
            mo26007b();
        }
    }

    /* renamed from: a */
    public synchronized C8462c mo26004a() {
        C8462c allocation;
        this.f18728f++;
        if (this.f18729g > 0) {
            C8462c[] cVarArr = this.f18730h;
            int i = this.f18729g - 1;
            this.f18729g = i;
            allocation = cVarArr[i];
            this.f18730h[this.f18729g] = null;
        } else {
            allocation = new C8462c(new byte[this.f18724b], 0);
        }
        return allocation;
    }

    /* renamed from: a */
    public synchronized void mo26005a(C8462c allocation) {
        this.f18726d[0] = allocation;
        mo26006a(this.f18726d);
    }

    /* renamed from: a */
    public synchronized void mo26006a(C8462c[] allocations) {
        if (this.f18729g + allocations.length >= this.f18730h.length) {
            this.f18730h = (C8462c[]) Arrays.copyOf(this.f18730h, Math.max(this.f18730h.length * 2, this.f18729g + allocations.length));
        }
        for (C8462c allocation : allocations) {
            C8462c[] cVarArr = this.f18730h;
            int i = this.f18729g;
            this.f18729g = i + 1;
            cVarArr[i] = allocation;
        }
        this.f18728f -= allocations.length;
        notifyAll();
    }

    /* renamed from: b */
    public synchronized void mo26007b() {
        int targetAvailableCount = Math.max(0, C8509F.m20432a(this.f18727e, this.f18724b) - this.f18728f);
        if (targetAvailableCount < this.f18729g) {
            if (this.f18725c != null) {
                int lowIndex = 0;
                int highIndex = this.f18729g - 1;
                while (lowIndex <= highIndex) {
                    C8462c lowAllocation = this.f18730h[lowIndex];
                    if (lowAllocation.f18631a == this.f18725c) {
                        lowIndex++;
                    } else {
                        C8462c highAllocation = this.f18730h[highIndex];
                        if (highAllocation.f18631a != this.f18725c) {
                            highIndex--;
                        } else {
                            int lowIndex2 = lowIndex + 1;
                            this.f18730h[lowIndex] = highAllocation;
                            int highIndex2 = highIndex - 1;
                            this.f18730h[highIndex] = lowAllocation;
                            highIndex = highIndex2;
                            lowIndex = lowIndex2;
                        }
                    }
                }
                targetAvailableCount = Math.max(targetAvailableCount, lowIndex);
                if (targetAvailableCount >= this.f18729g) {
                    return;
                }
            }
            Arrays.fill(this.f18730h, targetAvailableCount, this.f18729g, null);
            this.f18729g = targetAvailableCount;
        }
    }

    /* renamed from: d */
    public synchronized int mo26022d() {
        return this.f18728f * this.f18724b;
    }

    /* renamed from: c */
    public int mo26008c() {
        return this.f18724b;
    }
}
