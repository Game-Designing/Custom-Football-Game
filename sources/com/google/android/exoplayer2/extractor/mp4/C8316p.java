package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.extractor.mp4.p */
/* compiled from: TrackFragment */
final class C8316p {

    /* renamed from: a */
    public C8300e f17878a;

    /* renamed from: b */
    public long f17879b;

    /* renamed from: c */
    public long f17880c;

    /* renamed from: d */
    public long f17881d;

    /* renamed from: e */
    public int f17882e;

    /* renamed from: f */
    public int f17883f;

    /* renamed from: g */
    public long[] f17884g;

    /* renamed from: h */
    public int[] f17885h;

    /* renamed from: i */
    public int[] f17886i;

    /* renamed from: j */
    public int[] f17887j;

    /* renamed from: k */
    public long[] f17888k;

    /* renamed from: l */
    public boolean[] f17889l;

    /* renamed from: m */
    public boolean f17890m;

    /* renamed from: n */
    public boolean[] f17891n;

    /* renamed from: o */
    public C8315o f17892o;

    /* renamed from: p */
    public int f17893p;

    /* renamed from: q */
    public C8535t f17894q;

    /* renamed from: r */
    public boolean f17895r;

    /* renamed from: s */
    public long f17896s;

    C8316p() {
    }

    /* renamed from: a */
    public void mo25451a() {
        this.f17882e = 0;
        this.f17896s = 0;
        this.f17890m = false;
        this.f17895r = false;
        this.f17892o = null;
    }

    /* renamed from: a */
    public void mo25452a(int trunCount, int sampleCount) {
        this.f17882e = trunCount;
        this.f17883f = sampleCount;
        int[] iArr = this.f17885h;
        if (iArr == null || iArr.length < trunCount) {
            this.f17884g = new long[trunCount];
            this.f17885h = new int[trunCount];
        }
        int[] iArr2 = this.f17886i;
        if (iArr2 == null || iArr2.length < sampleCount) {
            int tableSize = (sampleCount * Opcodes.LUSHR) / 100;
            this.f17886i = new int[tableSize];
            this.f17887j = new int[tableSize];
            this.f17888k = new long[tableSize];
            this.f17889l = new boolean[tableSize];
            this.f17891n = new boolean[tableSize];
        }
    }

    /* renamed from: b */
    public void mo25455b(int length) {
        C8535t tVar = this.f17894q;
        if (tVar == null || tVar.mo26115d() < length) {
            this.f17894q = new C8535t(length);
        }
        this.f17893p = length;
        this.f17890m = true;
        this.f17895r = true;
    }

    /* renamed from: a */
    public void mo25453a(C8261h input) throws IOException, InterruptedException {
        input.readFully(this.f17894q.f18861a, 0, this.f17893p);
        this.f17894q.mo26118e(0);
        this.f17895r = false;
    }

    /* renamed from: a */
    public void mo25454a(C8535t source) {
        source.mo26110a(this.f17894q.f18861a, 0, this.f17893p);
        this.f17894q.mo26118e(0);
        this.f17895r = false;
    }

    /* renamed from: a */
    public long mo25450a(int index) {
        return this.f17888k[index] + ((long) this.f17887j[index]);
    }

    /* renamed from: c */
    public boolean mo25456c(int index) {
        return this.f17890m && this.f17891n[index];
    }
}
