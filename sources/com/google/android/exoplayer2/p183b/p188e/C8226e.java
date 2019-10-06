package com.google.android.exoplayer2.p183b.p188e;

import com.google.android.exoplayer2.audio.C8122h;
import com.google.android.exoplayer2.p183b.C8260g;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8263j;
import com.google.android.exoplayer2.p183b.C8267n;
import com.google.android.exoplayer2.p183b.C8268o.C8270b;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.b.e.e */
/* compiled from: Ac3Extractor */
public final class C8226e implements C8260g {

    /* renamed from: a */
    public static final C8263j f17218a = C8222a.f17214a;

    /* renamed from: b */
    private static final int f17219b = C8509F.m20464b("ID3");

    /* renamed from: c */
    private final long f17220c;

    /* renamed from: d */
    private final C8227f f17221d;

    /* renamed from: e */
    private final C8535t f17222e;

    /* renamed from: f */
    private boolean f17223f;

    /* renamed from: b */
    static /* synthetic */ C8260g[] m18955b() {
        return new C8260g[]{new C8226e()};
    }

    public C8226e() {
        this(0);
    }

    public C8226e(long firstSampleTimestampUs) {
        this.f17220c = firstSampleTimestampUs;
        this.f17221d = new C8227f();
        this.f17222e = new C8535t(2786);
    }

    /* renamed from: a */
    public boolean mo25204a(C8261h input) throws IOException, InterruptedException {
        C8535t scratch = new C8535t(10);
        int startPosition = 0;
        while (true) {
            input.mo25241a(scratch.f18861a, 0, 10);
            scratch.mo26118e(0);
            if (scratch.mo26134t() != f17219b) {
                break;
            }
            scratch.mo26120f(3);
            int length = scratch.mo26130p();
            startPosition += length + 10;
            input.mo25240a(length);
        }
        input.mo25239a();
        input.mo25240a(startPosition);
        int headerPosition = startPosition;
        int validFramesCount = 0;
        while (true) {
            input.mo25241a(scratch.f18861a, 0, 6);
            scratch.mo26118e(0);
            if (scratch.mo26137w() != 2935) {
                validFramesCount = 0;
                input.mo25239a();
                headerPosition++;
                if (headerPosition - startPosition >= 8192) {
                    return false;
                }
                input.mo25240a(headerPosition);
            } else {
                validFramesCount++;
                if (validFramesCount >= 4) {
                    return true;
                }
                int frameSize = C8122h.m18394a(scratch.f18861a);
                if (frameSize == -1) {
                    return false;
                }
                input.mo25240a(frameSize - 6);
            }
        }
    }

    /* renamed from: a */
    public void mo25203a(C8262i output) {
        this.f17221d.mo25305a(output, new C8219d(0, 1));
        output.mo25353g();
        output.mo25352a(new C8270b(-9223372036854775807L));
    }

    /* renamed from: a */
    public void mo25202a(long position, long timeUs) {
        this.f17223f = false;
        this.f17221d.mo25303a();
    }

    /* renamed from: a */
    public void mo25201a() {
    }

    /* renamed from: a */
    public int mo25200a(C8261h input, C8267n seekPosition) throws IOException, InterruptedException {
        int bytesRead = input.read(this.f17222e.f18861a, 0, 2786);
        if (bytesRead == -1) {
            return -1;
        }
        this.f17222e.mo26118e(0);
        this.f17222e.mo26116d(bytesRead);
        if (!this.f17223f) {
            this.f17221d.mo25304a(this.f17220c, 4);
            this.f17223f = true;
        }
        this.f17221d.mo25306a(this.f17222e);
        return 0;
    }
}
