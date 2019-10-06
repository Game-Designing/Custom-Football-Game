package com.google.android.exoplayer2.p183b.p188e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8266m;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.util.C8535t;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.b.e.s */
/* compiled from: MpegAudioReader */
public final class C8244s implements C8233l {

    /* renamed from: a */
    private final C8535t f17416a;

    /* renamed from: b */
    private final C8266m f17417b;

    /* renamed from: c */
    private final String f17418c;

    /* renamed from: d */
    private String f17419d;

    /* renamed from: e */
    private C8272q f17420e;

    /* renamed from: f */
    private int f17421f;

    /* renamed from: g */
    private int f17422g;

    /* renamed from: h */
    private boolean f17423h;

    /* renamed from: i */
    private boolean f17424i;

    /* renamed from: j */
    private long f17425j;

    /* renamed from: k */
    private int f17426k;

    /* renamed from: l */
    private long f17427l;

    public C8244s() {
        this(null);
    }

    public C8244s(String language) {
        this.f17421f = 0;
        this.f17416a = new C8535t(4);
        this.f17416a.f18861a[0] = -1;
        this.f17417b = new C8266m();
        this.f17418c = language;
    }

    /* renamed from: a */
    public void mo25303a() {
        this.f17421f = 0;
        this.f17422g = 0;
        this.f17424i = false;
    }

    /* renamed from: a */
    public void mo25305a(C8262i extractorOutput, C8219d idGenerator) {
        idGenerator.mo25298a();
        this.f17419d = idGenerator.mo25299b();
        this.f17420e = extractorOutput.mo25351a(idGenerator.mo25300c(), 1);
    }

    /* renamed from: a */
    public void mo25304a(long pesTimeUs, int flags) {
        this.f17427l = pesTimeUs;
    }

    /* renamed from: a */
    public void mo25306a(C8535t data) {
        while (data.mo26104a() > 0) {
            int i = this.f17421f;
            if (i == 0) {
                m19092b(data);
            } else if (i == 1) {
                m19094d(data);
            } else if (i == 2) {
                m19093c(data);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* renamed from: b */
    public void mo25307b() {
    }

    /* renamed from: b */
    private void m19092b(C8535t source) {
        byte[] data = source.f18861a;
        int startOffset = source.mo26113c();
        int endOffset = source.mo26115d();
        for (int i = startOffset; i < endOffset; i++) {
            boolean byteIsFF = (data[i] & 255) == 255;
            boolean found = this.f17424i && (data[i] & 224) == 224;
            this.f17424i = byteIsFF;
            if (found) {
                source.mo26118e(i + 1);
                this.f17424i = false;
                this.f17416a.f18861a[1] = data[i];
                this.f17422g = 2;
                this.f17421f = 1;
                return;
            }
        }
        source.mo26118e(endOffset);
    }

    /* renamed from: d */
    private void m19094d(C8535t source) {
        int bytesToRead = Math.min(source.mo26104a(), 4 - this.f17422g);
        source.mo26110a(this.f17416a.f18861a, this.f17422g, bytesToRead);
        this.f17422g += bytesToRead;
        if (this.f17422g >= 4) {
            this.f17416a.mo26118e(0);
            if (!C8266m.m19193a(this.f17416a.mo26119f(), this.f17417b)) {
                this.f17422g = 0;
                this.f17421f = 1;
                return;
            }
            C8266m mVar = this.f17417b;
            this.f17426k = mVar.f17505j;
            if (!this.f17423h) {
                long j = ((long) mVar.f17509n) * 1000000;
                int i = mVar.f17506k;
                this.f17425j = j / ((long) i);
                this.f17420e.mo25340a(Format.m18250a(this.f17419d, mVar.f17504i, null, -1, Opcodes.ACC_SYNTHETIC, mVar.f17507l, i, null, null, 0, this.f17418c));
                this.f17423h = true;
            }
            this.f17416a.mo26118e(0);
            this.f17420e.mo25341a(this.f17416a, 4);
            this.f17421f = 2;
        }
    }

    /* renamed from: c */
    private void m19093c(C8535t source) {
        int bytesToRead = Math.min(source.mo26104a(), this.f17426k - this.f17422g);
        this.f17420e.mo25341a(source, bytesToRead);
        this.f17422g += bytesToRead;
        int i = this.f17422g;
        int i2 = this.f17426k;
        if (i >= i2) {
            this.f17420e.mo25339a(this.f17427l, 1, i2, 0, null);
            this.f17427l += this.f17425j;
            this.f17422g = 0;
            this.f17421f = 0;
        }
    }
}
