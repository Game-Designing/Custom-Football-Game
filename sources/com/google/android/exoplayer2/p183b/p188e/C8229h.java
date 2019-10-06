package com.google.android.exoplayer2.p183b.p188e;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p183b.C8254f;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.util.C8518h;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8534s;
import com.google.android.exoplayer2.util.C8535t;
import java.util.Arrays;
import java.util.Collections;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.b.e.h */
/* compiled from: AdtsReader */
public final class C8229h implements C8233l {

    /* renamed from: a */
    private static final byte[] f17251a = {73, 68, 51};

    /* renamed from: b */
    private final boolean f17252b;

    /* renamed from: c */
    private final C8534s f17253c;

    /* renamed from: d */
    private final C8535t f17254d;

    /* renamed from: e */
    private final String f17255e;

    /* renamed from: f */
    private String f17256f;

    /* renamed from: g */
    private C8272q f17257g;

    /* renamed from: h */
    private C8272q f17258h;

    /* renamed from: i */
    private int f17259i;

    /* renamed from: j */
    private int f17260j;

    /* renamed from: k */
    private int f17261k;

    /* renamed from: l */
    private boolean f17262l;

    /* renamed from: m */
    private boolean f17263m;

    /* renamed from: n */
    private int f17264n;

    /* renamed from: o */
    private int f17265o;

    /* renamed from: p */
    private int f17266p;

    /* renamed from: q */
    private boolean f17267q;

    /* renamed from: r */
    private long f17268r;

    /* renamed from: s */
    private int f17269s;

    /* renamed from: t */
    private long f17270t;

    /* renamed from: u */
    private C8272q f17271u;

    /* renamed from: v */
    private long f17272v;

    public C8229h(boolean exposeId3) {
        this(exposeId3, null);
    }

    public C8229h(boolean exposeId3, String language) {
        this.f17253c = new C8534s(new byte[7]);
        this.f17254d = new C8535t(Arrays.copyOf(f17251a, 10));
        m18993h();
        this.f17264n = -1;
        this.f17265o = -1;
        this.f17268r = -9223372036854775807L;
        this.f17252b = exposeId3;
        this.f17255e = language;
    }

    /* renamed from: a */
    public static boolean m18982a(int candidateSyncWord) {
        return (65526 & candidateSyncWord) == 65520;
    }

    /* renamed from: a */
    public void mo25303a() {
        m18991f();
    }

    /* renamed from: a */
    public void mo25305a(C8262i extractorOutput, C8219d idGenerator) {
        idGenerator.mo25298a();
        this.f17256f = idGenerator.mo25299b();
        this.f17257g = extractorOutput.mo25351a(idGenerator.mo25300c(), 1);
        if (this.f17252b) {
            idGenerator.mo25298a();
            this.f17258h = extractorOutput.mo25351a(idGenerator.mo25300c(), 4);
            this.f17258h.mo25340a(Format.m18253a(idGenerator.mo25299b(), "application/id3", (String) null, -1, (DrmInitData) null));
            return;
        }
        this.f17258h = new C8254f();
    }

    /* renamed from: a */
    public void mo25304a(long pesTimeUs, int flags) {
        this.f17270t = pesTimeUs;
    }

    /* renamed from: a */
    public void mo25306a(C8535t data) throws ParserException {
        while (data.mo26104a() > 0) {
            int i = this.f17259i;
            if (i == 0) {
                m18987c(data);
            } else if (i == 1) {
                m18985b(data);
            } else if (i != 2) {
                if (i == 3) {
                    if (m18984a(data, this.f17253c.f18857a, this.f17262l ? 7 : 5)) {
                        m18988d();
                    }
                } else if (i == 4) {
                    m18989d(data);
                } else {
                    throw new IllegalStateException();
                }
            } else if (m18984a(data, this.f17254d.f18861a, 10)) {
                m18990e();
            }
        }
    }

    /* renamed from: b */
    public void mo25307b() {
    }

    /* renamed from: c */
    public long mo25308c() {
        return this.f17268r;
    }

    /* renamed from: f */
    private void m18991f() {
        this.f17263m = false;
        m18993h();
    }

    /* renamed from: a */
    private boolean m18984a(C8535t source, byte[] target, int targetLength) {
        int bytesToRead = Math.min(source.mo26104a(), targetLength - this.f17260j);
        source.mo26110a(target, this.f17260j, bytesToRead);
        this.f17260j += bytesToRead;
        return this.f17260j == targetLength;
    }

    /* renamed from: h */
    private void m18993h() {
        this.f17259i = 0;
        this.f17260j = 0;
        this.f17261k = Opcodes.ACC_NATIVE;
    }

    /* renamed from: j */
    private void m18995j() {
        this.f17259i = 2;
        this.f17260j = f17251a.length;
        this.f17269s = 0;
        this.f17254d.mo26118e(0);
    }

    /* renamed from: a */
    private void m18980a(C8272q outputToUse, long currentSampleDuration, int priorReadBytes, int sampleSize) {
        this.f17259i = 4;
        this.f17260j = priorReadBytes;
        this.f17271u = outputToUse;
        this.f17272v = currentSampleDuration;
        this.f17269s = sampleSize;
    }

    /* renamed from: i */
    private void m18994i() {
        this.f17259i = 3;
        this.f17260j = 0;
    }

    /* renamed from: g */
    private void m18992g() {
        this.f17259i = 1;
        this.f17260j = 0;
    }

    /* renamed from: c */
    private void m18987c(C8535t pesBuffer) {
        byte[] adtsData = pesBuffer.f18861a;
        int data = pesBuffer.mo26113c();
        int endOffset = pesBuffer.mo26115d();
        while (data < endOffset) {
            int position = data + 1;
            int data2 = adtsData[data] & 255;
            if (this.f17261k != 512 || !m18981a(-1, (byte) data2) || (!this.f17263m && !m18983a(pesBuffer, position - 2))) {
                int i = this.f17261k;
                int i2 = i | data2;
                if (i2 == 329) {
                    this.f17261k = 768;
                } else if (i2 == 511) {
                    this.f17261k = 512;
                } else if (i2 == 836) {
                    this.f17261k = Opcodes.ACC_ABSTRACT;
                } else if (i2 == 1075) {
                    m18995j();
                    pesBuffer.mo26118e(position);
                    return;
                } else if (i != 256) {
                    this.f17261k = Opcodes.ACC_NATIVE;
                    data = position - 1;
                }
                data = position;
            } else {
                this.f17266p = (data2 & 8) >> 3;
                this.f17262l = (data2 & 1) == 0;
                if (!this.f17263m) {
                    m18992g();
                } else {
                    m18994i();
                }
                pesBuffer.mo26118e(position);
                return;
            }
        }
        pesBuffer.mo26118e(data);
    }

    /* renamed from: b */
    private void m18985b(C8535t buffer) {
        if (buffer.mo26104a() != 0) {
            this.f17253c.f18857a[0] = buffer.f18861a[buffer.mo26113c()];
            this.f17253c.mo26099b(2);
            int currentFrameSampleRateIndex = this.f17253c.mo26092a(4);
            int i = this.f17265o;
            if (i == -1 || currentFrameSampleRateIndex == i) {
                if (!this.f17263m) {
                    this.f17263m = true;
                    this.f17264n = this.f17266p;
                    this.f17265o = currentFrameSampleRateIndex;
                }
                m18994i();
                return;
            }
            m18991f();
        }
    }

    /* renamed from: a */
    private boolean m18983a(C8535t pesBuffer, int syncPositionCandidate) {
        pesBuffer.mo26118e(syncPositionCandidate + 1);
        boolean z = true;
        if (!m18986b(pesBuffer, this.f17253c.f18857a, 1)) {
            return false;
        }
        this.f17253c.mo26099b(4);
        int currentFrameVersion = this.f17253c.mo26092a(1);
        int i = this.f17264n;
        if (i != -1 && currentFrameVersion != i) {
            return false;
        }
        if (this.f17265o != -1) {
            if (!m18986b(pesBuffer, this.f17253c.f18857a, 1)) {
                return true;
            }
            this.f17253c.mo26099b(2);
            if (this.f17253c.mo26092a(4) != this.f17265o) {
                return false;
            }
            pesBuffer.mo26118e(syncPositionCandidate + 2);
        }
        if (!m18986b(pesBuffer, this.f17253c.f18857a, 4)) {
            return true;
        }
        this.f17253c.mo26099b(14);
        int frameSize = this.f17253c.mo26092a(13);
        if (frameSize <= 6) {
            return false;
        }
        int nextSyncPosition = syncPositionCandidate + frameSize;
        if (nextSyncPosition + 1 >= pesBuffer.mo26115d()) {
            return true;
        }
        byte[] bArr = pesBuffer.f18861a;
        if (!m18981a(bArr[nextSyncPosition], bArr[nextSyncPosition + 1]) || !(this.f17264n == -1 || ((pesBuffer.f18861a[nextSyncPosition + 1] & 8) >> 3) == currentFrameVersion)) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    private boolean m18981a(byte firstByte, byte secondByte) {
        return m18982a(((firstByte & 255) << 8) | (secondByte & 255));
    }

    /* renamed from: b */
    private boolean m18986b(C8535t source, byte[] target, int targetLength) {
        if (source.mo26104a() < targetLength) {
            return false;
        }
        source.mo26110a(target, 0, targetLength);
        return true;
    }

    /* renamed from: e */
    private void m18990e() {
        this.f17258h.mo25341a(this.f17254d, 10);
        this.f17254d.mo26118e(6);
        m18980a(this.f17258h, 0, 10, this.f17254d.mo26130p() + 10);
    }

    /* renamed from: d */
    private void m18988d() throws ParserException {
        int sampleSize;
        this.f17253c.mo26099b(0);
        if (!this.f17267q) {
            int audioObjectType = this.f17253c.mo26092a(2) + 1;
            if (audioObjectType != 2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Detected audio object type: ");
                sb.append(audioObjectType);
                sb.append(", but assuming AAC LC.");
                C8526n.m20534d("AdtsReader", sb.toString());
                audioObjectType = 2;
            }
            this.f17253c.mo26101c(5);
            byte[] audioSpecificConfig = C8518h.m20504a(audioObjectType, this.f17265o, this.f17253c.mo26092a(3));
            Pair<Integer, Integer> audioParams = C8518h.m20502a(audioSpecificConfig);
            Format format = Format.m18250a(this.f17256f, "audio/mp4a-latm", null, -1, -1, ((Integer) audioParams.second).intValue(), ((Integer) audioParams.first).intValue(), Collections.singletonList(audioSpecificConfig), null, 0, this.f17255e);
            this.f17268r = 1024000000 / ((long) format.f16521u);
            this.f17257g.mo25340a(format);
            this.f17267q = true;
        } else {
            this.f17253c.mo26101c(10);
        }
        this.f17253c.mo26101c(4);
        int sampleSize2 = (this.f17253c.mo26092a(13) - 2) - 5;
        if (this.f17262l) {
            sampleSize = sampleSize2 - 2;
        } else {
            sampleSize = sampleSize2;
        }
        m18980a(this.f17257g, this.f17268r, 0, sampleSize);
    }

    /* renamed from: d */
    private void m18989d(C8535t data) {
        int bytesToRead = Math.min(data.mo26104a(), this.f17269s - this.f17260j);
        this.f17271u.mo25341a(data, bytesToRead);
        this.f17260j += bytesToRead;
        int i = this.f17260j;
        int i2 = this.f17269s;
        if (i == i2) {
            this.f17271u.mo25339a(this.f17270t, 1, i2, 0, null);
            this.f17270t += this.f17272v;
            m18993h();
        }
    }
}
