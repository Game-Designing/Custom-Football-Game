package com.google.android.exoplayer2.p183b.p188e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.C8138s;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.util.C8535t;

/* renamed from: com.google.android.exoplayer2.b.e.j */
/* compiled from: DtsReader */
public final class C8231j implements C8233l {

    /* renamed from: a */
    private final C8535t f17275a = new C8535t(new byte[18]);

    /* renamed from: b */
    private final String f17276b;

    /* renamed from: c */
    private String f17277c;

    /* renamed from: d */
    private C8272q f17278d;

    /* renamed from: e */
    private int f17279e = 0;

    /* renamed from: f */
    private int f17280f;

    /* renamed from: g */
    private int f17281g;

    /* renamed from: h */
    private long f17282h;

    /* renamed from: i */
    private Format f17283i;

    /* renamed from: j */
    private int f17284j;

    /* renamed from: k */
    private long f17285k;

    public C8231j(String language) {
        this.f17276b = language;
    }

    /* renamed from: a */
    public void mo25303a() {
        this.f17279e = 0;
        this.f17280f = 0;
        this.f17281g = 0;
    }

    /* renamed from: a */
    public void mo25305a(C8262i extractorOutput, C8219d idGenerator) {
        idGenerator.mo25298a();
        this.f17277c = idGenerator.mo25299b();
        this.f17278d = extractorOutput.mo25351a(idGenerator.mo25300c(), 1);
    }

    /* renamed from: a */
    public void mo25304a(long pesTimeUs, int flags) {
        this.f17285k = pesTimeUs;
    }

    /* renamed from: a */
    public void mo25306a(C8535t data) {
        while (data.mo26104a() > 0) {
            int i = this.f17279e;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int bytesToRead = Math.min(data.mo26104a(), this.f17284j - this.f17280f);
                        this.f17278d.mo25341a(data, bytesToRead);
                        this.f17280f += bytesToRead;
                        int i2 = this.f17280f;
                        int i3 = this.f17284j;
                        if (i2 == i3) {
                            this.f17278d.mo25339a(this.f17285k, 1, i3, 0, null);
                            this.f17285k += this.f17282h;
                            this.f17279e = 0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (m19008a(data, this.f17275a.f18861a, 18)) {
                    m19010c();
                    this.f17275a.mo26118e(0);
                    this.f17278d.mo25341a(this.f17275a, 18);
                    this.f17279e = 2;
                }
            } else if (m19009b(data)) {
                this.f17279e = 1;
            }
        }
    }

    /* renamed from: b */
    public void mo25307b() {
    }

    /* renamed from: a */
    private boolean m19008a(C8535t source, byte[] target, int targetLength) {
        int bytesToRead = Math.min(source.mo26104a(), targetLength - this.f17280f);
        source.mo26110a(target, this.f17280f, bytesToRead);
        this.f17280f += bytesToRead;
        return this.f17280f == targetLength;
    }

    /* renamed from: b */
    private boolean m19009b(C8535t pesBuffer) {
        while (pesBuffer.mo26104a() > 0) {
            this.f17281g <<= 8;
            this.f17281g |= pesBuffer.mo26131q();
            if (C8138s.m18471a(this.f17281g)) {
                byte[] bArr = this.f17275a.f18861a;
                int i = this.f17281g;
                bArr[0] = (byte) ((i >> 24) & 255);
                bArr[1] = (byte) ((i >> 16) & 255);
                bArr[2] = (byte) ((i >> 8) & 255);
                bArr[3] = (byte) (i & 255);
                this.f17280f = 4;
                this.f17281g = 0;
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private void m19010c() {
        byte[] frameData = this.f17275a.f18861a;
        if (this.f17283i == null) {
            this.f17283i = C8138s.m18470a(frameData, this.f17277c, this.f17276b, null);
            this.f17278d.mo25340a(this.f17283i);
        }
        this.f17284j = C8138s.m18469a(frameData);
        this.f17282h = (long) ((int) ((((long) C8138s.m18472b(frameData)) * 1000000) / ((long) this.f17283i.f16521u)));
    }
}
