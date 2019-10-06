package com.google.android.exoplayer2.p183b.p189f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p183b.C8260g;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8263j;
import com.google.android.exoplayer2.p183b.C8267n;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.util.C8514e;
import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.b.f.b */
/* compiled from: WavExtractor */
public final class C8256b implements C8260g {

    /* renamed from: a */
    public static final C8263j f17476a = C8255a.f17475a;

    /* renamed from: b */
    private C8262i f17477b;

    /* renamed from: c */
    private C8272q f17478c;

    /* renamed from: d */
    private C8257c f17479d;

    /* renamed from: e */
    private int f17480e;

    /* renamed from: f */
    private int f17481f;

    /* renamed from: b */
    static /* synthetic */ C8260g[] m19148b() {
        return new C8260g[]{new C8256b()};
    }

    /* renamed from: a */
    public boolean mo25204a(C8261h input) throws IOException, InterruptedException {
        return C8258d.m19166a(input) != null;
    }

    /* renamed from: a */
    public void mo25203a(C8262i output) {
        this.f17477b = output;
        this.f17478c = output.mo25351a(0, 1);
        this.f17479d = null;
        output.mo25353g();
    }

    /* renamed from: a */
    public void mo25202a(long position, long timeUs) {
        this.f17481f = 0;
    }

    /* renamed from: a */
    public void mo25201a() {
    }

    /* renamed from: a */
    public int mo25200a(C8261h input, C8267n seekPosition) throws IOException, InterruptedException {
        C8261h hVar = input;
        if (this.f17479d == null) {
            this.f17479d = C8258d.m19166a(input);
            C8257c cVar = this.f17479d;
            if (cVar != null) {
                this.f17478c.mo25340a(Format.m18249a((String) null, "audio/raw", (String) null, cVar.mo25342a(), (int) Opcodes.ACC_MANDATED, this.f17479d.mo25348h(), this.f17479d.mo25349i(), this.f17479d.mo25347g(), null, (DrmInitData) null, 0, (String) null));
                this.f17480e = this.f17479d.mo25345e();
            } else {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
        }
        if (!this.f17479d.mo25350j()) {
            C8258d.m19167a(hVar, this.f17479d);
            this.f17477b.mo25352a(this.f17479d);
        }
        long dataLimit = this.f17479d.mo25346f();
        int i = 0;
        C8514e.m20490b(dataLimit != -1);
        long bytesLeft = dataLimit - input.getPosition();
        if (bytesLeft <= 0) {
            return -1;
        }
        int bytesAppended = this.f17478c.mo25338a(hVar, (int) Math.min((long) (Opcodes.ACC_MANDATED - this.f17481f), bytesLeft), true);
        if (bytesAppended != -1) {
            this.f17481f += bytesAppended;
        }
        int pendingFrames = this.f17481f / this.f17480e;
        if (pendingFrames > 0) {
            long timeUs = this.f17479d.mo25344b(input.getPosition() - ((long) this.f17481f));
            int size = this.f17480e * pendingFrames;
            this.f17481f -= size;
            this.f17478c.mo25339a(timeUs, 1, size, this.f17481f, null);
        }
        if (bytesAppended == -1) {
            i = -1;
        }
        return i;
    }
}
