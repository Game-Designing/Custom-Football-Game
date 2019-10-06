package com.google.android.exoplayer2.p183b.p188e;

import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p183b.C8148a.C8151c;
import com.google.android.exoplayer2.p183b.C8260g;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8263j;
import com.google.android.exoplayer2.p183b.C8267n;
import com.google.android.exoplayer2.p183b.C8268o.C8270b;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.util.C8506D;
import com.google.android.exoplayer2.util.C8534s;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;

/* renamed from: com.google.android.exoplayer2.b.e.y */
/* compiled from: PsExtractor */
public final class C8251y implements C8260g {

    /* renamed from: a */
    public static final C8263j f17455a = C8224c.f17216a;

    /* renamed from: b */
    private final C8506D f17456b;

    /* renamed from: c */
    private final SparseArray<C8252a> f17457c;

    /* renamed from: d */
    private final C8535t f17458d;

    /* renamed from: e */
    private final C8250x f17459e;

    /* renamed from: f */
    private boolean f17460f;

    /* renamed from: g */
    private boolean f17461g;

    /* renamed from: h */
    private boolean f17462h;

    /* renamed from: i */
    private long f17463i;

    /* renamed from: j */
    private C8248w f17464j;

    /* renamed from: k */
    private C8262i f17465k;

    /* renamed from: l */
    private boolean f17466l;

    /* renamed from: com.google.android.exoplayer2.b.e.y$a */
    /* compiled from: PsExtractor */
    private static final class C8252a {

        /* renamed from: a */
        private final C8233l f17467a;

        /* renamed from: b */
        private final C8506D f17468b;

        /* renamed from: c */
        private final C8534s f17469c = new C8534s(new byte[64]);

        /* renamed from: d */
        private boolean f17470d;

        /* renamed from: e */
        private boolean f17471e;

        /* renamed from: f */
        private boolean f17472f;

        /* renamed from: g */
        private int f17473g;

        /* renamed from: h */
        private long f17474h;

        public C8252a(C8233l pesPayloadReader, C8506D timestampAdjuster) {
            this.f17467a = pesPayloadReader;
            this.f17468b = timestampAdjuster;
        }

        /* renamed from: a */
        public void mo25336a() {
            this.f17472f = false;
            this.f17467a.mo25303a();
        }

        /* renamed from: a */
        public void mo25337a(C8535t data) throws ParserException {
            data.mo26110a(this.f17469c.f18857a, 0, 3);
            this.f17469c.mo26099b(0);
            m19138b();
            data.mo26110a(this.f17469c.f18857a, 0, this.f17473g);
            this.f17469c.mo26099b(0);
            m19139c();
            this.f17467a.mo25304a(this.f17474h, 4);
            this.f17467a.mo25306a(data);
            this.f17467a.mo25307b();
        }

        /* renamed from: b */
        private void m19138b() {
            this.f17469c.mo26101c(8);
            this.f17470d = this.f17469c.mo26102d();
            this.f17471e = this.f17469c.mo26102d();
            this.f17469c.mo26101c(6);
            this.f17473g = this.f17469c.mo26092a(8);
        }

        /* renamed from: c */
        private void m19139c() {
            this.f17474h = 0;
            if (this.f17470d) {
                this.f17469c.mo26101c(4);
                long pts = ((long) this.f17469c.mo26092a(3)) << 30;
                this.f17469c.mo26101c(1);
                long pts2 = pts | ((long) (this.f17469c.mo26092a(15) << 15));
                this.f17469c.mo26101c(1);
                long pts3 = pts2 | ((long) this.f17469c.mo26092a(15));
                this.f17469c.mo26101c(1);
                if (!this.f17472f && this.f17471e) {
                    this.f17469c.mo26101c(4);
                    long dts = ((long) this.f17469c.mo26092a(3)) << 30;
                    this.f17469c.mo26101c(1);
                    long dts2 = dts | ((long) (this.f17469c.mo26092a(15) << 15));
                    this.f17469c.mo26101c(1);
                    long dts3 = dts2 | ((long) this.f17469c.mo26092a(15));
                    this.f17469c.mo26101c(1);
                    this.f17468b.mo26052b(dts3);
                    this.f17472f = true;
                }
                this.f17474h = this.f17468b.mo26052b(pts3);
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ C8260g[] m19132b() {
        return new C8260g[]{new C8251y()};
    }

    public C8251y() {
        this(new C8506D(0));
    }

    public C8251y(C8506D timestampAdjuster) {
        this.f17456b = timestampAdjuster;
        this.f17458d = new C8535t((int) Opcodes.ACC_SYNTHETIC);
        this.f17457c = new SparseArray<>();
        this.f17459e = new C8250x();
    }

    /* renamed from: a */
    public boolean mo25204a(C8261h input) throws IOException, InterruptedException {
        byte[] scratch = new byte[14];
        boolean z = false;
        input.mo25241a(scratch, 0, 14);
        if (442 != (((scratch[0] & 255) << 24) | ((scratch[1] & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO) | ((scratch[2] & 255) << 8) | (scratch[3] & 255)) || (scratch[4] & 196) != 68 || (scratch[6] & 4) != 4 || (scratch[8] & 4) != 4 || (scratch[9] & 1) != 1 || (scratch[12] & 3) != 3) {
            return false;
        }
        input.mo25240a(scratch[13] & 7);
        input.mo25241a(scratch, 0, 3);
        if (1 == ((scratch[2] & 255) | ((scratch[0] & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO) | ((scratch[1] & 255) << 8))) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public void mo25203a(C8262i output) {
        this.f17465k = output;
    }

    /* renamed from: a */
    public void mo25202a(long position, long timeUs) {
        if ((this.f17456b.mo26053c() == -9223372036854775807L) || !(this.f17456b.mo26049a() == 0 || this.f17456b.mo26049a() == timeUs)) {
            this.f17456b.mo26054d();
            this.f17456b.mo26055d(timeUs);
        }
        C8248w wVar = this.f17464j;
        if (wVar != null) {
            wVar.mo25189b(timeUs);
        }
        for (int i = 0; i < this.f17457c.size(); i++) {
            ((C8252a) this.f17457c.valueAt(i)).mo25336a();
        }
    }

    /* renamed from: a */
    public void mo25201a() {
    }

    /* renamed from: a */
    public int mo25200a(C8261h input, C8267n seekPosition) throws IOException, InterruptedException {
        C8261h hVar = input;
        C8267n nVar = seekPosition;
        long inputLength = input.getLength();
        boolean canReadDuration = inputLength != -1;
        if (canReadDuration && !this.f17459e.mo25335c()) {
            return this.f17459e.mo25332a(hVar, nVar);
        }
        m19131a(inputLength);
        C8248w wVar = this.f17464j;
        if (wVar != null && wVar.mo25191b()) {
            return this.f17464j.mo25184a(hVar, nVar, (C8151c) null);
        }
        input.mo25239a();
        long peekBytesLeft = inputLength != -1 ? inputLength - input.mo25245b() : -1;
        if ((peekBytesLeft != -1 && peekBytesLeft < 4) || !hVar.mo25243a(this.f17458d.f18861a, 0, 4, true)) {
            return -1;
        }
        this.f17458d.mo26118e(0);
        int nextStartCode = this.f17458d.mo26119f();
        if (nextStartCode == 441) {
            return -1;
        }
        if (nextStartCode == 442) {
            hVar.mo25241a(this.f17458d.f18861a, 0, 10);
            this.f17458d.mo26118e(9);
            hVar.mo25248c((this.f17458d.mo26131q() & 7) + 14);
            return 0;
        } else if (nextStartCode == 443) {
            hVar.mo25241a(this.f17458d.f18861a, 0, 2);
            this.f17458d.mo26118e(0);
            hVar.mo25248c(this.f17458d.mo26137w() + 6);
            return 0;
        } else if (((nextStartCode & -256) >> 8) != 1) {
            hVar.mo25248c(1);
            return 0;
        } else {
            int streamId = nextStartCode & 255;
            C8252a payloadReader = (C8252a) this.f17457c.get(streamId);
            if (!this.f17460f) {
                if (payloadReader == null) {
                    C8233l elementaryStreamReader = null;
                    if (streamId == 189) {
                        elementaryStreamReader = new C8227f();
                        this.f17461g = true;
                        boolean z = canReadDuration;
                        this.f17463i = input.getPosition();
                    } else {
                        if ((streamId & 224) == 192) {
                            elementaryStreamReader = new C8244s();
                            this.f17461g = true;
                            this.f17463i = input.getPosition();
                        } else if ((streamId & 240) == 224) {
                            elementaryStreamReader = new C8234m();
                            this.f17462h = true;
                            this.f17463i = input.getPosition();
                        }
                    }
                    if (elementaryStreamReader != null) {
                        elementaryStreamReader.mo25305a(this.f17465k, new C8219d(streamId, Opcodes.ACC_NATIVE));
                        C8252a payloadReader2 = new C8252a(elementaryStreamReader, this.f17456b);
                        this.f17457c.put(streamId, payloadReader2);
                        payloadReader = payloadReader2;
                    }
                }
                if (input.getPosition() > ((!this.f17461g || !this.f17462h) ? 1048576 : this.f17463i + 8192)) {
                    this.f17460f = true;
                    this.f17465k.mo25353g();
                }
            }
            hVar.mo25241a(this.f17458d.f18861a, 0, 2);
            this.f17458d.mo26118e(0);
            int pesLength = this.f17458d.mo26137w() + 6;
            if (payloadReader == null) {
                hVar.mo25248c(pesLength);
            } else {
                this.f17458d.mo26114c(pesLength);
                hVar.readFully(this.f17458d.f18861a, 0, pesLength);
                this.f17458d.mo26118e(6);
                payloadReader.mo25337a(this.f17458d);
                C8535t tVar = this.f17458d;
                tVar.mo26116d(tVar.mo26111b());
            }
            return 0;
        }
    }

    /* renamed from: a */
    private void m19131a(long inputLength) {
        if (!this.f17466l) {
            this.f17466l = true;
            if (this.f17459e.mo25333a() != -9223372036854775807L) {
                C8248w wVar = new C8248w(this.f17459e.mo25334b(), this.f17459e.mo25333a(), inputLength);
                this.f17464j = wVar;
                this.f17465k.mo25352a(this.f17464j.mo25186a());
                return;
            }
            this.f17465k.mo25352a(new C8270b(this.f17459e.mo25333a()));
        }
    }
}
