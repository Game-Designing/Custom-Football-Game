package com.google.android.exoplayer2.p183b.p188e;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.util.C8518h;
import com.google.android.exoplayer2.util.C8534s;
import com.google.android.exoplayer2.util.C8535t;
import java.util.Collections;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.b.e.r */
/* compiled from: LatmReader */
public final class C8243r implements C8233l {

    /* renamed from: a */
    private final String f17396a;

    /* renamed from: b */
    private final C8535t f17397b = new C8535t((int) Opcodes.ACC_ABSTRACT);

    /* renamed from: c */
    private final C8534s f17398c = new C8534s(this.f17397b.f18861a);

    /* renamed from: d */
    private C8272q f17399d;

    /* renamed from: e */
    private Format f17400e;

    /* renamed from: f */
    private String f17401f;

    /* renamed from: g */
    private int f17402g;

    /* renamed from: h */
    private int f17403h;

    /* renamed from: i */
    private int f17404i;

    /* renamed from: j */
    private int f17405j;

    /* renamed from: k */
    private long f17406k;

    /* renamed from: l */
    private boolean f17407l;

    /* renamed from: m */
    private int f17408m;

    /* renamed from: n */
    private int f17409n;

    /* renamed from: o */
    private int f17410o;

    /* renamed from: p */
    private boolean f17411p;

    /* renamed from: q */
    private long f17412q;

    /* renamed from: r */
    private int f17413r;

    /* renamed from: s */
    private long f17414s;

    /* renamed from: t */
    private int f17415t;

    public C8243r(String language) {
        this.f17396a = language;
    }

    /* renamed from: a */
    public void mo25303a() {
        this.f17402g = 0;
        this.f17407l = false;
    }

    /* renamed from: a */
    public void mo25305a(C8262i extractorOutput, C8219d idGenerator) {
        idGenerator.mo25298a();
        this.f17399d = extractorOutput.mo25351a(idGenerator.mo25300c(), 1);
        this.f17401f = idGenerator.mo25299b();
    }

    /* renamed from: a */
    public void mo25304a(long pesTimeUs, int flags) {
        this.f17406k = pesTimeUs;
    }

    /* renamed from: a */
    public void mo25306a(C8535t data) throws ParserException {
        while (data.mo26104a() > 0) {
            int i = this.f17402g;
            if (i != 0) {
                if (i == 1) {
                    int secondByte = data.mo26131q();
                    if ((secondByte & 224) == 224) {
                        this.f17405j = secondByte;
                        this.f17402g = 2;
                    } else if (secondByte != 86) {
                        this.f17402g = 0;
                    }
                } else if (i == 2) {
                    this.f17404i = ((this.f17405j & -225) << 8) | data.mo26131q();
                    int i2 = this.f17404i;
                    if (i2 > this.f17397b.f18861a.length) {
                        m19080a(i2);
                    }
                    this.f17403h = 0;
                    this.f17402g = 3;
                } else if (i == 3) {
                    int bytesToRead = Math.min(data.mo26104a(), this.f17404i - this.f17403h);
                    data.mo26110a(this.f17398c.f18857a, this.f17403h, bytesToRead);
                    this.f17403h += bytesToRead;
                    if (this.f17403h == this.f17404i) {
                        this.f17398c.mo26099b(0);
                        m19082b(this.f17398c);
                        this.f17402g = 0;
                    }
                } else {
                    throw new IllegalStateException();
                }
            } else if (data.mo26131q() == 86) {
                this.f17402g = 1;
            }
        }
    }

    /* renamed from: b */
    public void mo25307b() {
    }

    /* renamed from: b */
    private void m19082b(C8534s data) throws ParserException {
        if (!data.mo26102d()) {
            this.f17407l = true;
            m19086f(data);
        } else if (!this.f17407l) {
            return;
        }
        if (this.f17408m != 0) {
            throw new ParserException();
        } else if (this.f17409n == 0) {
            m19081a(data, m19085e(data));
            if (this.f17411p) {
                data.mo26101c((int) this.f17412q);
            }
        } else {
            throw new ParserException();
        }
    }

    /* renamed from: f */
    private void m19086f(C8534s data) throws ParserException {
        boolean otherDataLenEsc;
        C8534s sVar = data;
        int audioMuxVersion = sVar.mo26092a(1);
        this.f17408m = audioMuxVersion == 1 ? sVar.mo26092a(1) : 0;
        if (this.f17408m == 0) {
            if (audioMuxVersion == 1) {
                m19079a(data);
            }
            if (data.mo26102d()) {
                this.f17409n = sVar.mo26092a(6);
                int numProgram = sVar.mo26092a(4);
                int numLayer = sVar.mo26092a(3);
                if (numProgram == 0 && numLayer == 0) {
                    if (audioMuxVersion == 0) {
                        int startPosition = data.mo26100c();
                        int readBits = m19083c(data);
                        sVar.mo26099b(startPosition);
                        byte[] initData = new byte[((readBits + 7) / 8)];
                        sVar.mo26097a(initData, 0, readBits);
                        Format format = Format.m18250a(this.f17401f, "audio/mp4a-latm", null, -1, -1, this.f17415t, this.f17413r, Collections.singletonList(initData), null, 0, this.f17396a);
                        if (!format.equals(this.f17400e)) {
                            this.f17400e = format;
                            this.f17414s = 1024000000 / ((long) format.f16521u);
                            this.f17399d.mo25340a(format);
                        }
                    } else {
                        sVar.mo26101c(((int) m19079a(data)) - m19083c(data));
                    }
                    m19084d(data);
                    this.f17411p = data.mo26102d();
                    this.f17412q = 0;
                    if (this.f17411p) {
                        if (audioMuxVersion == 1) {
                            this.f17412q = m19079a(data);
                        } else {
                            do {
                                otherDataLenEsc = data.mo26102d();
                                this.f17412q = (this.f17412q << 8) + ((long) sVar.mo26092a(8));
                            } while (otherDataLenEsc);
                        }
                    }
                    if (data.mo26102d()) {
                        sVar.mo26101c(8);
                        return;
                    }
                    return;
                }
                throw new ParserException();
            }
            throw new ParserException();
        }
        throw new ParserException();
    }

    /* renamed from: d */
    private void m19084d(C8534s data) {
        this.f17410o = data.mo26092a(3);
        int i = this.f17410o;
        if (i == 0) {
            data.mo26101c(8);
        } else if (i == 1) {
            data.mo26101c(9);
        } else if (i == 3 || i == 4 || i == 5) {
            data.mo26101c(6);
        } else if (i == 6 || i == 7) {
            data.mo26101c(1);
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: c */
    private int m19083c(C8534s data) throws ParserException {
        int bitsLeft = data.mo26091a();
        Pair<Integer, Integer> config = C8518h.m20501a(data, true);
        this.f17413r = ((Integer) config.first).intValue();
        this.f17415t = ((Integer) config.second).intValue();
        return bitsLeft - data.mo26091a();
    }

    /* renamed from: e */
    private int m19085e(C8534s data) throws ParserException {
        int tmp;
        int muxSlotLengthBytes = 0;
        if (this.f17410o == 0) {
            do {
                tmp = data.mo26092a(8);
                muxSlotLengthBytes += tmp;
            } while (tmp == 255);
            return muxSlotLengthBytes;
        }
        throw new ParserException();
    }

    /* renamed from: a */
    private void m19081a(C8534s data, int muxLengthBytes) {
        int bitPosition = data.mo26100c();
        if ((bitPosition & 7) == 0) {
            this.f17397b.mo26118e(bitPosition >> 3);
        } else {
            data.mo26097a(this.f17397b.f18861a, 0, muxLengthBytes * 8);
            this.f17397b.mo26118e(0);
        }
        this.f17399d.mo25341a(this.f17397b, muxLengthBytes);
        this.f17399d.mo25339a(this.f17406k, 1, muxLengthBytes, 0, null);
        this.f17406k += this.f17414s;
    }

    /* renamed from: a */
    private void m19080a(int newSize) {
        this.f17397b.mo26114c(newSize);
        this.f17398c.mo26095a(this.f17397b.f18861a);
    }

    /* renamed from: a */
    private static long m19079a(C8534s data) {
        return (long) data.mo26092a((data.mo26092a(2) + 1) * 8);
    }
}
