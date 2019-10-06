package com.google.android.exoplayer2.p183b.p188e;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.util.C8506D;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8534s;
import com.google.android.exoplayer2.util.C8535t;

/* renamed from: com.google.android.exoplayer2.b.e.u */
/* compiled from: PesReader */
public final class C8246u implements C8215G {

    /* renamed from: a */
    private final C8233l f17433a;

    /* renamed from: b */
    private final C8534s f17434b = new C8534s(new byte[10]);

    /* renamed from: c */
    private int f17435c = 0;

    /* renamed from: d */
    private int f17436d;

    /* renamed from: e */
    private C8506D f17437e;

    /* renamed from: f */
    private boolean f17438f;

    /* renamed from: g */
    private boolean f17439g;

    /* renamed from: h */
    private boolean f17440h;

    /* renamed from: i */
    private int f17441i;

    /* renamed from: j */
    private int f17442j;

    /* renamed from: k */
    private boolean f17443k;

    /* renamed from: l */
    private long f17444l;

    public C8246u(C8233l reader) {
        this.f17433a = reader;
    }

    /* renamed from: a */
    public void mo25286a(C8506D timestampAdjuster, C8262i extractorOutput, C8219d idGenerator) {
        this.f17437e = timestampAdjuster;
        this.f17433a.mo25305a(extractorOutput, idGenerator);
    }

    /* renamed from: a */
    public final void mo25285a() {
        this.f17435c = 0;
        this.f17436d = 0;
        this.f17440h = false;
        this.f17433a.mo25303a();
    }

    /* renamed from: a */
    public final void mo25287a(C8535t data, int flags) throws ParserException {
        if ((flags & 1) != 0) {
            int i = this.f17435c;
            if (!(i == 0 || i == 1)) {
                String str = "PesReader";
                if (i == 2) {
                    C8526n.m20534d(str, "Unexpected start indicator reading extended header");
                } else if (i == 3) {
                    if (this.f17442j != -1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unexpected start indicator: expected ");
                        sb.append(this.f17442j);
                        sb.append(" more bytes");
                        C8526n.m20534d(str, sb.toString());
                    }
                    this.f17433a.mo25307b();
                } else {
                    throw new IllegalStateException();
                }
            }
            m19105a(1);
        }
        while (data.mo26104a() > 0) {
            int i2 = this.f17435c;
            if (i2 != 0) {
                int padding = 0;
                if (i2 != 1) {
                    if (i2 == 2) {
                        if (m19106a(data, this.f17434b.f18857a, Math.min(10, this.f17441i)) && m19106a(data, (byte[]) null, this.f17441i)) {
                            m19108c();
                            if (this.f17443k) {
                                padding = 4;
                            }
                            flags |= padding;
                            this.f17433a.mo25304a(this.f17444l, flags);
                            m19105a(3);
                        }
                    } else if (i2 == 3) {
                        int readLength = data.mo26104a();
                        int i3 = this.f17442j;
                        if (i3 != -1) {
                            padding = readLength - i3;
                        }
                        if (padding > 0) {
                            readLength -= padding;
                            data.mo26116d(data.mo26113c() + readLength);
                        }
                        this.f17433a.mo25306a(data);
                        int i4 = this.f17442j;
                        if (i4 != -1) {
                            this.f17442j = i4 - readLength;
                            if (this.f17442j == 0) {
                                this.f17433a.mo25307b();
                                m19105a(1);
                            }
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (m19106a(data, this.f17434b.f18857a, 9)) {
                    if (m19107b()) {
                        padding = 2;
                    }
                    m19105a(padding);
                }
            } else {
                data.mo26120f(data.mo26104a());
            }
        }
    }

    /* renamed from: a */
    private void m19105a(int state) {
        this.f17435c = state;
        this.f17436d = 0;
    }

    /* renamed from: a */
    private boolean m19106a(C8535t source, byte[] target, int targetLength) {
        int bytesToRead = Math.min(source.mo26104a(), targetLength - this.f17436d);
        boolean z = true;
        if (bytesToRead <= 0) {
            return true;
        }
        if (target == null) {
            source.mo26120f(bytesToRead);
        } else {
            source.mo26110a(target, this.f17436d, bytesToRead);
        }
        this.f17436d += bytesToRead;
        if (this.f17436d != targetLength) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    private boolean m19107b() {
        this.f17434b.mo26099b(0);
        int startCodePrefix = this.f17434b.mo26092a(24);
        if (startCodePrefix != 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected start code prefix: ");
            sb.append(startCodePrefix);
            C8526n.m20534d("PesReader", sb.toString());
            this.f17442j = -1;
            return false;
        }
        this.f17434b.mo26101c(8);
        int packetLength = this.f17434b.mo26092a(16);
        this.f17434b.mo26101c(5);
        this.f17443k = this.f17434b.mo26102d();
        this.f17434b.mo26101c(2);
        this.f17438f = this.f17434b.mo26102d();
        this.f17439g = this.f17434b.mo26102d();
        this.f17434b.mo26101c(6);
        this.f17441i = this.f17434b.mo26092a(8);
        if (packetLength == 0) {
            this.f17442j = -1;
        } else {
            this.f17442j = ((packetLength + 6) - 9) - this.f17441i;
        }
        return true;
    }

    /* renamed from: c */
    private void m19108c() {
        this.f17434b.mo26099b(0);
        this.f17444l = -9223372036854775807L;
        if (this.f17438f) {
            this.f17434b.mo26101c(4);
            long pts = ((long) this.f17434b.mo26092a(3)) << 30;
            this.f17434b.mo26101c(1);
            long pts2 = pts | ((long) (this.f17434b.mo26092a(15) << 15));
            this.f17434b.mo26101c(1);
            long pts3 = pts2 | ((long) this.f17434b.mo26092a(15));
            this.f17434b.mo26101c(1);
            if (!this.f17440h && this.f17439g) {
                this.f17434b.mo26101c(4);
                long dts = ((long) this.f17434b.mo26092a(3)) << 30;
                this.f17434b.mo26101c(1);
                long dts2 = dts | ((long) (this.f17434b.mo26092a(15) << 15));
                this.f17434b.mo26101c(1);
                long dts3 = dts2 | ((long) this.f17434b.mo26092a(15));
                this.f17434b.mo26101c(1);
                this.f17437e.mo26052b(dts3);
                this.f17440h = true;
            }
            this.f17444l = this.f17437e.mo26052b(pts3);
        }
    }
}
