package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class zzjr implements zzjl {

    /* renamed from: a */
    private final int f28696a = Opcodes.ASM4;

    /* renamed from: b */
    private int f28697b;

    /* renamed from: c */
    private int f28698c;

    /* renamed from: d */
    private zzjk[] f28699d = new zzjk[100];

    public zzjr(int i) {
        zzkh.m30535a(true);
    }

    /* renamed from: b */
    public final synchronized zzjk mo31875b() {
        this.f28697b++;
        if (this.f28698c > 0) {
            zzjk[] zzjkArr = this.f28699d;
            int i = this.f28698c - 1;
            this.f28698c = i;
            return zzjkArr[i];
        }
        return new zzjk(new byte[this.f28696a], 0);
    }

    /* renamed from: a */
    public final synchronized void mo31874a(zzjk zzjk) {
        zzkh.m30535a(zzjk.f28679a.length == this.f28696a);
        this.f28697b--;
        if (this.f28698c == this.f28699d.length) {
            this.f28699d = (zzjk[]) Arrays.copyOf(this.f28699d, this.f28699d.length << 1);
        }
        zzjk[] zzjkArr = this.f28699d;
        int i = this.f28698c;
        this.f28698c = i + 1;
        zzjkArr[i] = zzjk;
        notifyAll();
    }

    /* renamed from: b */
    public final synchronized void mo31878b(int i) {
        int max = Math.max(0, zzkq.m30563a(0, this.f28696a) - this.f28697b);
        if (max < this.f28698c) {
            Arrays.fill(this.f28699d, max, this.f28698c, null);
            this.f28698c = max;
        }
    }

    /* renamed from: c */
    private final synchronized int m30504c() {
        return this.f28697b * this.f28696a;
    }

    /* renamed from: a */
    public final int mo31873a() {
        return this.f28696a;
    }

    /* renamed from: a */
    public final synchronized void mo31877a(int i) throws InterruptedException {
        while (m30504c() > i) {
            wait();
        }
    }
}
