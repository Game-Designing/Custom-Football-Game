package com.google.android.exoplayer2.p183b.p188e;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p183b.C8172c;
import com.google.android.exoplayer2.p183b.C8260g;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8263j;
import com.google.android.exoplayer2.p183b.C8267n;
import com.google.android.exoplayer2.p183b.C8268o;
import com.google.android.exoplayer2.p183b.C8268o.C8270b;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8534s;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.b.e.g */
/* compiled from: AdtsExtractor */
public final class C8228g implements C8260g {

    /* renamed from: a */
    public static final C8263j f17236a = C8223b.f17215a;

    /* renamed from: b */
    private static final int f17237b = C8509F.m20464b("ID3");

    /* renamed from: c */
    private final int f17238c;

    /* renamed from: d */
    private final C8229h f17239d;

    /* renamed from: e */
    private final C8535t f17240e;

    /* renamed from: f */
    private final C8535t f17241f;

    /* renamed from: g */
    private final C8534s f17242g;

    /* renamed from: h */
    private final long f17243h;

    /* renamed from: i */
    private C8262i f17244i;

    /* renamed from: j */
    private long f17245j;

    /* renamed from: k */
    private long f17246k;

    /* renamed from: l */
    private int f17247l;

    /* renamed from: m */
    private boolean f17248m;

    /* renamed from: n */
    private boolean f17249n;

    /* renamed from: o */
    private boolean f17250o;

    /* renamed from: b */
    static /* synthetic */ C8260g[] m18973b() {
        return new C8260g[]{new C8228g()};
    }

    public C8228g() {
        this(0);
    }

    public C8228g(long firstStreamSampleTimestampUs) {
        this(firstStreamSampleTimestampUs, 0);
    }

    public C8228g(long firstStreamSampleTimestampUs, int flags) {
        this.f17243h = firstStreamSampleTimestampUs;
        this.f17245j = firstStreamSampleTimestampUs;
        this.f17238c = flags;
        this.f17239d = new C8229h(true);
        this.f17240e = new C8535t((int) Opcodes.ACC_STRICT);
        this.f17247l = -1;
        this.f17246k = -1;
        this.f17241f = new C8535t(10);
        this.f17242g = new C8534s(this.f17241f.f18861a);
    }

    /* renamed from: a */
    public boolean mo25204a(C8261h input) throws IOException, InterruptedException {
        int startPosition = m18974c(input);
        int headerPosition = startPosition;
        int totalValidFramesSize = 0;
        int validFramesCount = 0;
        while (true) {
            input.mo25241a(this.f17241f.f18861a, 0, 2);
            this.f17241f.mo26118e(0);
            if (!C8229h.m18982a(this.f17241f.mo26137w())) {
                validFramesCount = 0;
                totalValidFramesSize = 0;
                input.mo25239a();
                headerPosition++;
                if (headerPosition - startPosition >= 8192) {
                    return false;
                }
                input.mo25240a(headerPosition);
            } else {
                validFramesCount++;
                if (validFramesCount >= 4 && totalValidFramesSize > 188) {
                    return true;
                }
                input.mo25241a(this.f17241f.f18861a, 0, 4);
                this.f17242g.mo26099b(14);
                int frameSize = this.f17242g.mo26092a(13);
                if (frameSize <= 6) {
                    return false;
                }
                input.mo25240a(frameSize - 6);
                totalValidFramesSize += frameSize;
            }
        }
    }

    /* renamed from: a */
    public void mo25203a(C8262i output) {
        this.f17244i = output;
        this.f17239d.mo25305a(output, new C8219d(0, 1));
        output.mo25353g();
    }

    /* renamed from: a */
    public void mo25202a(long position, long timeUs) {
        this.f17249n = false;
        this.f17239d.mo25303a();
        this.f17245j = this.f17243h + timeUs;
    }

    /* renamed from: a */
    public void mo25201a() {
    }

    /* renamed from: a */
    public int mo25200a(C8261h input, C8267n seekPosition) throws IOException, InterruptedException {
        long inputLength = input.getLength();
        boolean canUseConstantBitrateSeeking = ((this.f17238c & 1) == 0 || inputLength == -1) ? false : true;
        if (canUseConstantBitrateSeeking) {
            m18972b(input);
        }
        int bytesRead = input.read(this.f17240e.f18861a, 0, Opcodes.ACC_STRICT);
        boolean readEndOfStream = bytesRead == -1;
        m18971a(inputLength, canUseConstantBitrateSeeking, readEndOfStream);
        if (readEndOfStream) {
            return -1;
        }
        this.f17240e.mo26118e(0);
        this.f17240e.mo26116d(bytesRead);
        if (!this.f17249n) {
            this.f17239d.mo25304a(this.f17245j, 4);
            this.f17249n = true;
        }
        this.f17239d.mo25306a(this.f17240e);
        return 0;
    }

    /* renamed from: c */
    private int m18974c(C8261h input) throws IOException, InterruptedException {
        int firstFramePosition = 0;
        while (true) {
            input.mo25241a(this.f17241f.f18861a, 0, 10);
            this.f17241f.mo26118e(0);
            if (this.f17241f.mo26134t() != f17237b) {
                break;
            }
            this.f17241f.mo26120f(3);
            int length = this.f17241f.mo26130p();
            firstFramePosition += length + 10;
            input.mo25240a(length);
        }
        input.mo25239a();
        input.mo25240a(firstFramePosition);
        if (this.f17246k == -1) {
            this.f17246k = (long) firstFramePosition;
        }
        return firstFramePosition;
    }

    /* renamed from: a */
    private void m18971a(long inputLength, boolean canUseConstantBitrateSeeking, boolean readEndOfStream) {
        if (!this.f17250o) {
            boolean useConstantBitrateSeeking = canUseConstantBitrateSeeking && this.f17247l > 0;
            if (!useConstantBitrateSeeking || this.f17239d.mo25308c() != -9223372036854775807L || readEndOfStream) {
                C8262i iVar = this.f17244i;
                C8514e.m20486a(iVar);
                C8262i extractorOutput = iVar;
                if (!useConstantBitrateSeeking || this.f17239d.mo25308c() == -9223372036854775807L) {
                    extractorOutput.mo25352a(new C8270b(-9223372036854775807L));
                } else {
                    extractorOutput.mo25352a(m18970a(inputLength));
                }
                this.f17250o = true;
            }
        }
    }

    /* renamed from: b */
    private void m18972b(C8261h input) throws IOException, InterruptedException {
        if (!this.f17248m) {
            this.f17247l = -1;
            input.mo25239a();
            if (input.getPosition() == 0) {
                m18974c(input);
            }
            int numValidFrames = 0;
            long totalValidFramesSize = 0;
            while (true) {
                if (!input.mo25243a(this.f17241f.f18861a, 0, 2, true)) {
                    break;
                }
                this.f17241f.mo26118e(0);
                if (!C8229h.m18982a(this.f17241f.mo26137w())) {
                    numValidFrames = 0;
                    break;
                } else if (!input.mo25243a(this.f17241f.f18861a, 0, 4, true)) {
                    break;
                } else {
                    this.f17242g.mo26099b(14);
                    int currentFrameSize = this.f17242g.mo26092a(13);
                    if (currentFrameSize > 6) {
                        totalValidFramesSize += (long) currentFrameSize;
                        numValidFrames++;
                        if (numValidFrames != 1000) {
                            if (!input.mo25242a(currentFrameSize - 6, true)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        this.f17248m = true;
                        throw new ParserException("Malformed ADTS stream");
                    }
                }
            }
            input.mo25239a();
            if (numValidFrames > 0) {
                this.f17247l = (int) (totalValidFramesSize / ((long) numValidFrames));
            } else {
                this.f17247l = -1;
            }
            this.f17248m = true;
        }
    }

    /* renamed from: a */
    private C8268o m18970a(long inputLength) {
        C8172c cVar = new C8172c(inputLength, this.f17246k, m18969a(this.f17247l, this.f17239d.mo25308c()), this.f17247l);
        return cVar;
    }

    /* renamed from: a */
    private static int m18969a(int frameSize, long durationUsPerFrame) {
        return (int) ((((long) (frameSize * 8)) * 1000000) / durationUsPerFrame);
    }
}
