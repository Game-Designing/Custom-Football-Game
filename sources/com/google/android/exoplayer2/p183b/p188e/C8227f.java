package com.google.android.exoplayer2.p183b.p188e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.C8122h;
import com.google.android.exoplayer2.audio.C8122h.C8123a;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.util.C8534s;
import com.google.android.exoplayer2.util.C8535t;

/* renamed from: com.google.android.exoplayer2.b.e.f */
/* compiled from: Ac3Reader */
public final class C8227f implements C8233l {

    /* renamed from: a */
    private final C8534s f17224a;

    /* renamed from: b */
    private final C8535t f17225b;

    /* renamed from: c */
    private final String f17226c;

    /* renamed from: d */
    private String f17227d;

    /* renamed from: e */
    private C8272q f17228e;

    /* renamed from: f */
    private int f17229f;

    /* renamed from: g */
    private int f17230g;

    /* renamed from: h */
    private boolean f17231h;

    /* renamed from: i */
    private long f17232i;

    /* renamed from: j */
    private Format f17233j;

    /* renamed from: k */
    private int f17234k;

    /* renamed from: l */
    private long f17235l;

    public C8227f() {
        this(null);
    }

    public C8227f(String language) {
        this.f17224a = new C8534s(new byte[128]);
        this.f17225b = new C8535t(this.f17224a.f18857a);
        this.f17229f = 0;
        this.f17226c = language;
    }

    /* renamed from: a */
    public void mo25303a() {
        this.f17229f = 0;
        this.f17230g = 0;
        this.f17231h = false;
    }

    /* renamed from: a */
    public void mo25305a(C8262i extractorOutput, C8219d generator) {
        generator.mo25298a();
        this.f17227d = generator.mo25299b();
        this.f17228e = extractorOutput.mo25351a(generator.mo25300c(), 1);
    }

    /* renamed from: a */
    public void mo25304a(long pesTimeUs, int flags) {
        this.f17235l = pesTimeUs;
    }

    /* renamed from: a */
    public void mo25306a(C8535t data) {
        while (data.mo26104a() > 0) {
            int i = this.f17229f;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int bytesToRead = Math.min(data.mo26104a(), this.f17234k - this.f17230g);
                        this.f17228e.mo25341a(data, bytesToRead);
                        this.f17230g += bytesToRead;
                        int i2 = this.f17230g;
                        int i3 = this.f17234k;
                        if (i2 == i3) {
                            this.f17228e.mo25339a(this.f17235l, 1, i3, 0, null);
                            this.f17235l += this.f17232i;
                            this.f17229f = 0;
                        }
                    }
                } else if (m18961a(data, this.f17225b.f18861a, 128)) {
                    m18963c();
                    this.f17225b.mo26118e(0);
                    this.f17228e.mo25341a(this.f17225b, 128);
                    this.f17229f = 2;
                }
            } else if (m18962b(data)) {
                this.f17229f = 1;
                byte[] bArr = this.f17225b.f18861a;
                bArr[0] = 11;
                bArr[1] = 119;
                this.f17230g = 2;
            }
        }
    }

    /* renamed from: b */
    public void mo25307b() {
    }

    /* renamed from: a */
    private boolean m18961a(C8535t source, byte[] target, int targetLength) {
        int bytesToRead = Math.min(source.mo26104a(), targetLength - this.f17230g);
        source.mo26110a(target, this.f17230g, bytesToRead);
        this.f17230g += bytesToRead;
        return this.f17230g == targetLength;
    }

    /* renamed from: b */
    private boolean m18962b(C8535t pesBuffer) {
        while (true) {
            boolean z = false;
            if (pesBuffer.mo26104a() <= 0) {
                return false;
            }
            if (!this.f17231h) {
                if (pesBuffer.mo26131q() == 11) {
                    z = true;
                }
                this.f17231h = z;
            } else {
                int secondByte = pesBuffer.mo26131q();
                if (secondByte == 119) {
                    this.f17231h = false;
                    return true;
                }
                if (secondByte == 11) {
                    z = true;
                }
                this.f17231h = z;
            }
        }
    }

    /* renamed from: c */
    private void m18963c() {
        this.f17224a.mo26099b(0);
        C8123a frameInfo = C8122h.m18396a(this.f17224a);
        Format format = this.f17233j;
        if (!(format != null && frameInfo.f16665d == format.f16520t && frameInfo.f16664c == format.f16521u && frameInfo.f16662a == format.f16507g)) {
            this.f17233j = Format.m18250a(this.f17227d, frameInfo.f16662a, null, -1, -1, frameInfo.f16665d, frameInfo.f16664c, null, null, 0, this.f17226c);
            this.f17228e.mo25340a(this.f17233j);
        }
        this.f17234k = frameInfo.f16666e;
        this.f17232i = (((long) frameInfo.f16667f) * 1000000) / ((long) this.f17233j.f16521u);
    }
}
