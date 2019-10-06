package com.google.android.exoplayer2.p183b.p184a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p183b.C8172c;
import com.google.android.exoplayer2.p183b.C8260g;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8263j;
import com.google.android.exoplayer2.p183b.C8267n;
import com.google.android.exoplayer2.p183b.C8268o;
import com.google.android.exoplayer2.p183b.C8268o.C8270b;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.util.C8509F;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.b.a.b */
/* compiled from: AmrExtractor */
public final class C8157b implements C8260g {

    /* renamed from: a */
    public static final C8263j f16840a = C8156a.f16839a;

    /* renamed from: b */
    private static final int[] f16841b = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: c */
    private static final int[] f16842c = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};

    /* renamed from: d */
    private static final byte[] f16843d = C8509F.m20472c("#!AMR\n");

    /* renamed from: e */
    private static final byte[] f16844e = C8509F.m20472c("#!AMR-WB\n");

    /* renamed from: f */
    private static final int f16845f = f16842c[8];

    /* renamed from: g */
    private final byte[] f16846g;

    /* renamed from: h */
    private final int f16847h;

    /* renamed from: i */
    private boolean f16848i;

    /* renamed from: j */
    private long f16849j;

    /* renamed from: k */
    private int f16850k;

    /* renamed from: l */
    private int f16851l;

    /* renamed from: m */
    private boolean f16852m;

    /* renamed from: n */
    private long f16853n;

    /* renamed from: o */
    private int f16854o;

    /* renamed from: p */
    private int f16855p;

    /* renamed from: q */
    private long f16856q;

    /* renamed from: r */
    private C8262i f16857r;

    /* renamed from: s */
    private C8272q f16858s;

    /* renamed from: t */
    private C8268o f16859t;

    /* renamed from: u */
    private boolean f16860u;

    /* renamed from: b */
    static /* synthetic */ C8260g[] m18641b() {
        return new C8260g[]{new C8157b()};
    }

    public C8157b() {
        this(0);
    }

    public C8157b(int flags) {
        this.f16847h = flags;
        this.f16846g = new byte[1];
        this.f16854o = -1;
    }

    /* renamed from: a */
    public boolean mo25204a(C8261h input) throws IOException, InterruptedException {
        return m18644c(input);
    }

    /* renamed from: a */
    public void mo25203a(C8262i extractorOutput) {
        this.f16857r = extractorOutput;
        this.f16858s = extractorOutput.mo25351a(0, 1);
        extractorOutput.mo25353g();
    }

    /* renamed from: a */
    public int mo25200a(C8261h input, C8267n seekPosition) throws IOException, InterruptedException {
        if (input.getPosition() != 0 || m18644c(input)) {
            m18642c();
            int sampleReadResult = m18645d(input);
            m18637a(input.getLength(), sampleReadResult);
            return sampleReadResult;
        }
        throw new ParserException("Could not find AMR header.");
    }

    /* renamed from: a */
    public void mo25202a(long position, long timeUs) {
        this.f16849j = 0;
        this.f16850k = 0;
        this.f16851l = 0;
        if (position != 0) {
            C8268o oVar = this.f16859t;
            if (oVar instanceof C8172c) {
                this.f16856q = ((C8172c) oVar).mo25235c(position);
                return;
            }
        }
        this.f16856q = 0;
    }

    /* renamed from: a */
    public void mo25201a() {
    }

    /* renamed from: c */
    private boolean m18644c(C8261h input) throws IOException, InterruptedException {
        if (m18638a(input, f16843d)) {
            this.f16848i = false;
            input.mo25248c(f16843d.length);
            return true;
        } else if (!m18638a(input, f16844e)) {
            return false;
        } else {
            this.f16848i = true;
            input.mo25248c(f16844e.length);
            return true;
        }
    }

    /* renamed from: a */
    private boolean m18638a(C8261h input, byte[] amrSignature) throws IOException, InterruptedException {
        input.mo25239a();
        byte[] header = new byte[amrSignature.length];
        input.mo25241a(header, 0, amrSignature.length);
        return Arrays.equals(header, amrSignature);
    }

    /* renamed from: c */
    private void m18642c() {
        if (!this.f16860u) {
            this.f16860u = true;
            this.f16858s.mo25340a(Format.m18249a((String) null, this.f16848i ? "audio/amr-wb" : "audio/3gpp", (String) null, -1, f16845f, 1, this.f16848i ? 16000 : 8000, -1, null, (DrmInitData) null, 0, (String) null));
        }
    }

    /* renamed from: d */
    private int m18645d(C8261h extractorInput) throws IOException, InterruptedException {
        if (this.f16851l == 0) {
            try {
                this.f16850k = m18639b(extractorInput);
                this.f16851l = this.f16850k;
                if (this.f16854o == -1) {
                    this.f16853n = extractorInput.getPosition();
                    this.f16854o = this.f16850k;
                }
                if (this.f16854o == this.f16850k) {
                    this.f16855p++;
                }
            } catch (EOFException e) {
                return -1;
            }
        }
        int bytesAppended = this.f16858s.mo25338a(extractorInput, this.f16851l, true);
        if (bytesAppended == -1) {
            return -1;
        }
        this.f16851l -= bytesAppended;
        if (this.f16851l > 0) {
            return 0;
        }
        this.f16858s.mo25339a(this.f16856q + this.f16849j, 1, this.f16850k, 0, null);
        this.f16849j += 20000;
        return 0;
    }

    /* renamed from: b */
    private int m18639b(C8261h extractorInput) throws IOException, InterruptedException {
        extractorInput.mo25239a();
        extractorInput.mo25241a(this.f16846g, 0, 1);
        byte frameHeader = this.f16846g[0];
        if ((frameHeader & 131) <= 0) {
            return m18634a((frameHeader >> 3) & 15);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid padding bits for frame header ");
        sb.append(frameHeader);
        throw new ParserException(sb.toString());
    }

    /* renamed from: a */
    private int m18634a(int frameType) throws ParserException {
        if (m18643c(frameType)) {
            return this.f16848i ? f16842c[frameType] : f16841b[frameType];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        sb.append(this.f16848i ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(frameType);
        throw new ParserException(sb.toString());
    }

    /* renamed from: c */
    private boolean m18643c(int frameType) {
        return frameType >= 0 && frameType <= 15 && (m18646d(frameType) || m18640b(frameType));
    }

    /* renamed from: d */
    private boolean m18646d(int frameType) {
        return this.f16848i && (frameType < 10 || frameType > 13);
    }

    /* renamed from: b */
    private boolean m18640b(int frameType) {
        return !this.f16848i && (frameType < 12 || frameType > 14);
    }

    /* renamed from: a */
    private void m18637a(long inputLength, int sampleReadResult) {
        if (!this.f16852m) {
            if (!((this.f16847h & 1) == 0 || inputLength == -1)) {
                int i = this.f16854o;
                if (i == -1 || i == this.f16850k) {
                    if (this.f16855p >= 20 || sampleReadResult == -1) {
                        this.f16859t = m18636a(inputLength);
                        this.f16857r.mo25352a(this.f16859t);
                        this.f16852m = true;
                    }
                }
            }
            this.f16859t = new C8270b(-9223372036854775807L);
            this.f16857r.mo25352a(this.f16859t);
            this.f16852m = true;
        }
    }

    /* renamed from: a */
    private C8268o m18636a(long inputLength) {
        C8172c cVar = new C8172c(inputLength, this.f16853n, m18635a(this.f16854o, 20000), this.f16854o);
        return cVar;
    }

    /* renamed from: a */
    private static int m18635a(int frameSize, long durationUsPerFrame) {
        return (int) ((((long) (frameSize * 8)) * 1000000) / durationUsPerFrame);
    }
}
