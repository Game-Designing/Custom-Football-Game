package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.p183b.C8260g;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8263j;
import com.google.android.exoplayer2.p183b.C8267n;
import com.google.android.exoplayer2.p183b.C8268o.C8270b;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.extractor.flv.c */
/* compiled from: FlvExtractor */
public final class C8285c implements C8260g {

    /* renamed from: a */
    public static final C8263j f17577a = C8283a.f17572a;

    /* renamed from: b */
    private static final int f17578b = C8509F.m20464b("FLV");

    /* renamed from: c */
    private final C8535t f17579c = new C8535t(4);

    /* renamed from: d */
    private final C8535t f17580d = new C8535t(9);

    /* renamed from: e */
    private final C8535t f17581e = new C8535t(11);

    /* renamed from: f */
    private final C8535t f17582f = new C8535t();

    /* renamed from: g */
    private final C8286d f17583g = new C8286d();

    /* renamed from: h */
    private C8262i f17584h;

    /* renamed from: i */
    private int f17585i = 1;

    /* renamed from: j */
    private long f17586j = -9223372036854775807L;

    /* renamed from: k */
    private int f17587k;

    /* renamed from: l */
    private int f17588l;

    /* renamed from: m */
    private int f17589m;

    /* renamed from: n */
    private long f17590n;

    /* renamed from: o */
    private boolean f17591o;

    /* renamed from: p */
    private C8284b f17592p;

    /* renamed from: q */
    private C8287e f17593q;

    /* renamed from: b */
    static /* synthetic */ C8260g[] m19262b() {
        return new C8260g[]{new C8285c()};
    }

    /* renamed from: a */
    public boolean mo25204a(C8261h input) throws IOException, InterruptedException {
        boolean z = false;
        input.mo25241a(this.f17579c.f18861a, 0, 3);
        this.f17579c.mo26118e(0);
        if (this.f17579c.mo26134t() != f17578b) {
            return false;
        }
        input.mo25241a(this.f17579c.f18861a, 0, 2);
        this.f17579c.mo26118e(0);
        if ((this.f17579c.mo26137w() & 250) != 0) {
            return false;
        }
        input.mo25241a(this.f17579c.f18861a, 0, 4);
        this.f17579c.mo26118e(0);
        int dataOffset = this.f17579c.mo26119f();
        input.mo25239a();
        input.mo25240a(dataOffset);
        input.mo25241a(this.f17579c.f18861a, 0, 4);
        this.f17579c.mo26118e(0);
        if (this.f17579c.mo26119f() == 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public void mo25203a(C8262i output) {
        this.f17584h = output;
    }

    /* renamed from: a */
    public void mo25202a(long position, long timeUs) {
        this.f17585i = 1;
        this.f17586j = -9223372036854775807L;
        this.f17587k = 0;
    }

    /* renamed from: a */
    public void mo25201a() {
    }

    /* renamed from: a */
    public int mo25200a(C8261h input, C8267n seekPosition) throws IOException, InterruptedException {
        while (true) {
            int i = this.f17585i;
            if (i != 1) {
                if (i == 2) {
                    m19267f(input);
                } else if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException();
                    } else if (m19265d(input)) {
                        return 0;
                    }
                } else if (!m19266e(input)) {
                    return -1;
                }
            } else if (!m19264c(input)) {
                return -1;
            }
        }
    }

    /* renamed from: c */
    private boolean m19264c(C8261h input) throws IOException, InterruptedException {
        boolean hasVideo = false;
        if (!input.mo25247b(this.f17580d.f18861a, 0, 9, true)) {
            return false;
        }
        this.f17580d.mo26118e(0);
        this.f17580d.mo26120f(4);
        int flags = this.f17580d.mo26131q();
        boolean hasAudio = (flags & 4) != 0;
        if ((flags & 1) != 0) {
            hasVideo = true;
        }
        if (hasAudio && this.f17592p == null) {
            this.f17592p = new C8284b(this.f17584h.mo25351a(8, 1));
        }
        if (hasVideo && this.f17593q == null) {
            this.f17593q = new C8287e(this.f17584h.mo25351a(9, 2));
        }
        this.f17584h.mo25353g();
        this.f17587k = (this.f17580d.mo26119f() - 9) + 4;
        this.f17585i = 2;
        return true;
    }

    /* renamed from: f */
    private void m19267f(C8261h input) throws IOException, InterruptedException {
        input.mo25248c(this.f17587k);
        this.f17587k = 0;
        this.f17585i = 3;
    }

    /* renamed from: e */
    private boolean m19266e(C8261h input) throws IOException, InterruptedException {
        if (!input.mo25247b(this.f17581e.f18861a, 0, 11, true)) {
            return false;
        }
        this.f17581e.mo26118e(0);
        this.f17588l = this.f17581e.mo26131q();
        this.f17589m = this.f17581e.mo26134t();
        this.f17590n = (long) this.f17581e.mo26134t();
        this.f17590n = (((long) (this.f17581e.mo26131q() << 24)) | this.f17590n) * 1000;
        this.f17581e.mo26120f(3);
        this.f17585i = 4;
        return true;
    }

    /* renamed from: d */
    private boolean m19265d(C8261h input) throws IOException, InterruptedException {
        boolean wasConsumed = true;
        if (this.f17588l == 8 && this.f17592p != null) {
            m19263c();
            this.f17592p.mo25423a(m19261b(input), this.f17586j + this.f17590n);
        } else if (this.f17588l == 9 && this.f17593q != null) {
            m19263c();
            this.f17593q.mo25423a(m19261b(input), this.f17586j + this.f17590n);
        } else if (this.f17588l != 18 || this.f17591o) {
            input.mo25248c(this.f17589m);
            wasConsumed = false;
        } else {
            this.f17583g.mo25423a(m19261b(input), this.f17590n);
            long durationUs = this.f17583g.mo25426a();
            if (durationUs != -9223372036854775807L) {
                this.f17584h.mo25352a(new C8270b(durationUs));
                this.f17591o = true;
            }
        }
        this.f17587k = 4;
        this.f17585i = 2;
        return wasConsumed;
    }

    /* renamed from: b */
    private C8535t m19261b(C8261h input) throws IOException, InterruptedException {
        if (this.f17589m > this.f17582f.mo26111b()) {
            C8535t tVar = this.f17582f;
            tVar.mo26109a(new byte[Math.max(tVar.mo26111b() * 2, this.f17589m)], 0);
        } else {
            this.f17582f.mo26118e(0);
        }
        this.f17582f.mo26116d(this.f17589m);
        input.readFully(this.f17582f.f18861a, 0, this.f17589m);
        return this.f17582f;
    }

    /* renamed from: c */
    private void m19263c() {
        if (!this.f17591o) {
            this.f17584h.mo25352a(new C8270b(-9223372036854775807L));
            this.f17591o = true;
        }
        if (this.f17586j == -9223372036854775807L) {
            this.f17586j = this.f17583g.mo25426a() == -9223372036854775807L ? -this.f17590n : 0;
        }
    }
}
