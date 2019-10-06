package com.google.android.exoplayer2.p183b.p187d;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8535t;
import java.io.EOFException;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.b.d.g */
/* compiled from: OggPageHeader */
final class C8190g {

    /* renamed from: a */
    private static final int f17073a = C8509F.m20464b("OggS");

    /* renamed from: b */
    public int f17074b;

    /* renamed from: c */
    public int f17075c;

    /* renamed from: d */
    public long f17076d;

    /* renamed from: e */
    public long f17077e;

    /* renamed from: f */
    public long f17078f;

    /* renamed from: g */
    public long f17079g;

    /* renamed from: h */
    public int f17080h;

    /* renamed from: i */
    public int f17081i;

    /* renamed from: j */
    public int f17082j;

    /* renamed from: k */
    public final int[] f17083k = new int[255];

    /* renamed from: l */
    private final C8535t f17084l = new C8535t(255);

    C8190g() {
    }

    /* renamed from: a */
    public void mo25272a() {
        this.f17074b = 0;
        this.f17075c = 0;
        this.f17076d = 0;
        this.f17077e = 0;
        this.f17078f = 0;
        this.f17079g = 0;
        this.f17080h = 0;
        this.f17081i = 0;
        this.f17082j = 0;
    }

    /* renamed from: a */
    public boolean mo25273a(C8261h input, boolean quiet) throws IOException, InterruptedException {
        this.f17084l.mo26139y();
        mo25272a();
        if (!(input.getLength() == -1 || input.getLength() - input.mo25245b() >= 27) || !input.mo25243a(this.f17084l.f18861a, 0, 27, true)) {
            if (quiet) {
                return false;
            }
            throw new EOFException();
        } else if (this.f17084l.mo26133s() == ((long) f17073a)) {
            this.f17074b = this.f17084l.mo26131q();
            if (this.f17074b == 0) {
                this.f17075c = this.f17084l.mo26131q();
                this.f17076d = this.f17084l.mo26123i();
                this.f17077e = this.f17084l.mo26124j();
                this.f17078f = this.f17084l.mo26124j();
                this.f17079g = this.f17084l.mo26124j();
                this.f17080h = this.f17084l.mo26131q();
                this.f17081i = this.f17080h + 27;
                this.f17084l.mo26139y();
                input.mo25241a(this.f17084l.f18861a, 0, this.f17080h);
                for (int i = 0; i < this.f17080h; i++) {
                    this.f17083k[i] = this.f17084l.mo26131q();
                    this.f17082j += this.f17083k[i];
                }
                return true;
            } else if (quiet) {
                return false;
            } else {
                throw new ParserException("unsupported bit stream revision");
            }
        } else if (quiet) {
            return false;
        } else {
            throw new ParserException("expected OggS capture pattern at begin of page");
        }
    }
}
