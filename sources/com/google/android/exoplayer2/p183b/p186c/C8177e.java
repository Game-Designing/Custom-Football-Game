package com.google.android.exoplayer2.p183b.p186c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.C8353h.C8354a;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.p183b.C8260g;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8263j;
import com.google.android.exoplayer2.p183b.C8264k;
import com.google.android.exoplayer2.p183b.C8265l;
import com.google.android.exoplayer2.p183b.C8266m;
import com.google.android.exoplayer2.p183b.C8267n;
import com.google.android.exoplayer2.p183b.C8268o;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8535t;
import java.io.EOFException;
import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.b.c.e */
/* compiled from: Mp3Extractor */
public final class C8177e implements C8260g {

    /* renamed from: a */
    public static final C8263j f17007a = C8173a.f17002a;

    /* renamed from: b */
    private static final C8354a f17008b = C8174b.f17003a;

    /* renamed from: c */
    private static final int f17009c = C8509F.m20464b("Xing");

    /* renamed from: d */
    private static final int f17010d = C8509F.m20464b("Info");

    /* renamed from: e */
    private static final int f17011e = C8509F.m20464b("VBRI");

    /* renamed from: f */
    private final int f17012f;

    /* renamed from: g */
    private final long f17013g;

    /* renamed from: h */
    private final C8535t f17014h;

    /* renamed from: i */
    private final C8266m f17015i;

    /* renamed from: j */
    private final C8264k f17016j;

    /* renamed from: k */
    private final C8265l f17017k;

    /* renamed from: l */
    private C8262i f17018l;

    /* renamed from: m */
    private C8272q f17019m;

    /* renamed from: n */
    private int f17020n;

    /* renamed from: o */
    private Metadata f17021o;

    /* renamed from: p */
    private C8178a f17022p;

    /* renamed from: q */
    private long f17023q;

    /* renamed from: r */
    private long f17024r;

    /* renamed from: s */
    private int f17025s;

    /* renamed from: com.google.android.exoplayer2.b.c.e$a */
    /* compiled from: Mp3Extractor */
    interface C8178a extends C8268o {
        /* renamed from: b */
        long mo25237b(long j);

        /* renamed from: c */
        long mo25238c();
    }

    /* renamed from: b */
    static /* synthetic */ C8260g[] m18751b() {
        return new C8260g[]{new C8177e()};
    }

    /* renamed from: a */
    static /* synthetic */ boolean m18747a(int majorVersion, int id0, int id1, int id2, int id3) {
        return (id0 == 67 && id1 == 79 && id2 == 77 && (id3 == 77 || majorVersion == 2)) || (id0 == 77 && id1 == 76 && id2 == 76 && (id3 == 84 || majorVersion == 2));
    }

    public C8177e() {
        this(0);
    }

    public C8177e(int flags) {
        this(flags, -9223372036854775807L);
    }

    public C8177e(int flags, long forcedFirstSampleTimestampUs) {
        this.f17012f = flags;
        this.f17013g = forcedFirstSampleTimestampUs;
        this.f17014h = new C8535t(10);
        this.f17015i = new C8266m();
        this.f17016j = new C8264k();
        this.f17023q = -9223372036854775807L;
        this.f17017k = new C8265l();
    }

    /* renamed from: a */
    public boolean mo25204a(C8261h input) throws IOException, InterruptedException {
        return m18749a(input, true);
    }

    /* renamed from: a */
    public void mo25203a(C8262i output) {
        this.f17018l = output;
        this.f17019m = this.f17018l.mo25351a(0, 1);
        this.f17018l.mo25353g();
    }

    /* renamed from: a */
    public void mo25202a(long position, long timeUs) {
        this.f17020n = 0;
        this.f17023q = -9223372036854775807L;
        this.f17024r = 0;
        this.f17025s = 0;
    }

    /* renamed from: a */
    public void mo25201a() {
    }

    /* renamed from: a */
    public int mo25200a(C8261h input, C8267n seekPosition) throws IOException, InterruptedException {
        if (this.f17020n == 0) {
            try {
                m18749a(input, false);
            } catch (EOFException e) {
                EOFException eOFException = e;
                return -1;
            }
        } else {
            C8261h hVar = input;
        }
        if (this.f17022p == null) {
            C8178a seekFrameSeeker = m18752c(input);
            C8178a metadataSeeker = m18746a(this.f17021o, input.getPosition());
            if (metadataSeeker != null) {
                this.f17022p = metadataSeeker;
            } else if (seekFrameSeeker != null) {
                this.f17022p = seekFrameSeeker;
            }
            C8178a aVar = this.f17022p;
            if (aVar == null || (!aVar.mo25195d() && (this.f17012f & 1) != 0)) {
                this.f17022p = m18750b(input);
            }
            this.f17018l.mo25352a(this.f17022p);
            C8272q qVar = this.f17019m;
            C8266m mVar = this.f17015i;
            String str = mVar.f17504i;
            int i = mVar.f17507l;
            int i2 = mVar.f17506k;
            C8264k kVar = this.f17016j;
            qVar.mo25340a(Format.m18248a((String) null, str, (String) null, -1, (int) Opcodes.ACC_SYNTHETIC, i, i2, -1, kVar.f17493b, kVar.f17494c, null, (DrmInitData) null, 0, (String) null, (this.f17012f & 2) != 0 ? null : this.f17021o));
        }
        return m18754e(input);
    }

    /* renamed from: e */
    private int m18754e(C8261h extractorInput) throws IOException, InterruptedException {
        if (this.f17025s == 0) {
            extractorInput.mo25239a();
            if (m18753d(extractorInput)) {
                return -1;
            }
            this.f17014h.mo26118e(0);
            int sampleHeaderData = this.f17014h.mo26119f();
            if (!m18748a(sampleHeaderData, (long) this.f17020n) || C8266m.m19191a(sampleHeaderData) == -1) {
                extractorInput.mo25248c(1);
                this.f17020n = 0;
                return 0;
            }
            C8266m.m19193a(sampleHeaderData, this.f17015i);
            if (this.f17023q == -9223372036854775807L) {
                this.f17023q = this.f17022p.mo25237b(extractorInput.getPosition());
                if (this.f17013g != -9223372036854775807L) {
                    this.f17023q += this.f17013g - this.f17022p.mo25237b(0);
                }
            }
            this.f17025s = this.f17015i.f17505j;
        }
        int bytesAppended = this.f17019m.mo25338a(extractorInput, this.f17025s, true);
        if (bytesAppended == -1) {
            return -1;
        }
        this.f17025s -= bytesAppended;
        if (this.f17025s > 0) {
            return 0;
        }
        long j = this.f17023q;
        long j2 = this.f17024r * 1000000;
        C8266m mVar = this.f17015i;
        this.f17019m.mo25339a(j + (j2 / ((long) mVar.f17506k)), 1, mVar.f17505j, 0, null);
        this.f17024r += (long) this.f17015i.f17509n;
        this.f17025s = 0;
        return 0;
    }

    /* renamed from: a */
    private boolean m18749a(C8261h input, boolean sniffing) throws IOException, InterruptedException {
        int validFrameCount = 0;
        int candidateSynchronizedHeaderData = 0;
        int peekedId3Bytes = 0;
        int searchedBytes = 0;
        int searchLimitBytes = sniffing ? Opcodes.ACC_ENUM : Opcodes.ACC_DEPRECATED;
        input.mo25239a();
        if (input.getPosition() == 0) {
            this.f17021o = this.f17017k.mo25357a(input, (this.f17012f & 2) == 0 ? null : f17008b);
            Metadata metadata = this.f17021o;
            if (metadata != null) {
                this.f17016j.mo25356a(metadata);
            }
            peekedId3Bytes = (int) input.mo25245b();
            if (!sniffing) {
                input.mo25248c(peekedId3Bytes);
            }
        }
        while (true) {
            if (!m18753d(input)) {
                this.f17014h.mo26118e(0);
                int headerData = this.f17014h.mo26119f();
                if (candidateSynchronizedHeaderData == 0 || m18748a(headerData, (long) candidateSynchronizedHeaderData)) {
                    int a = C8266m.m19191a(headerData);
                    int frameSize = a;
                    if (a != -1) {
                        validFrameCount++;
                        if (validFrameCount != 1) {
                            if (validFrameCount == 4) {
                                break;
                            }
                        } else {
                            C8266m.m19193a(headerData, this.f17015i);
                            candidateSynchronizedHeaderData = headerData;
                        }
                        input.mo25240a(frameSize - 4);
                    }
                }
                int searchedBytes2 = searchedBytes + 1;
                if (searchedBytes != searchLimitBytes) {
                    validFrameCount = 0;
                    candidateSynchronizedHeaderData = 0;
                    if (sniffing) {
                        input.mo25239a();
                        input.mo25240a(peekedId3Bytes + searchedBytes2);
                    } else {
                        input.mo25248c(1);
                    }
                    searchedBytes = searchedBytes2;
                } else if (sniffing) {
                    return false;
                } else {
                    throw new ParserException("Searched too many bytes.");
                }
            } else if (validFrameCount <= 0) {
                throw new EOFException();
            }
        }
        if (sniffing) {
            input.mo25248c(peekedId3Bytes + searchedBytes);
        } else {
            input.mo25239a();
        }
        this.f17020n = candidateSynchronizedHeaderData;
        return true;
    }

    /* renamed from: d */
    private boolean m18753d(C8261h extractorInput) throws IOException, InterruptedException {
        if ((this.f17022p == null || extractorInput.mo25245b() != this.f17022p.mo25238c()) && extractorInput.mo25243a(this.f17014h.f18861a, 0, 4, true)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private C8178a m18752c(C8261h input) throws IOException, InterruptedException {
        C8178a seeker;
        C8535t frame = new C8535t(this.f17015i.f17505j);
        input.mo25241a(frame.f18861a, 0, this.f17015i.f17505j);
        C8266m mVar = this.f17015i;
        int i = 21;
        if ((mVar.f17503h & 1) != 0) {
            if (mVar.f17507l != 1) {
                i = 36;
            }
        } else if (mVar.f17507l == 1) {
            i = 13;
        }
        int xingBase = i;
        int seekHeader = m18745a(frame, xingBase);
        if (seekHeader == f17009c || seekHeader == f17010d) {
            seeker = C8180g.m18769a(input.getLength(), input.getPosition(), this.f17015i, frame);
            if (seeker != null && !this.f17016j.mo25354a()) {
                input.mo25239a();
                input.mo25240a(xingBase + Opcodes.F2D);
                input.mo25241a(this.f17014h.f18861a, 0, 3);
                this.f17014h.mo26118e(0);
                this.f17016j.mo25355a(this.f17014h.mo26134t());
            }
            input.mo25248c(this.f17015i.f17505j);
            if (seeker != null && !seeker.mo25195d() && seekHeader == f17010d) {
                return m18750b(input);
            }
        } else if (seekHeader == f17011e) {
            seeker = C8179f.m18762a(input.getLength(), input.getPosition(), this.f17015i, frame);
            input.mo25248c(this.f17015i.f17505j);
        } else {
            seeker = null;
            input.mo25239a();
        }
        return seeker;
    }

    /* renamed from: b */
    private C8178a m18750b(C8261h input) throws IOException, InterruptedException {
        input.mo25241a(this.f17014h.f18861a, 0, 4);
        this.f17014h.mo26118e(0);
        C8266m.m19193a(this.f17014h.mo26119f(), this.f17015i);
        C8175c cVar = new C8175c(input.getLength(), input.getPosition(), this.f17015i);
        return cVar;
    }

    /* renamed from: a */
    private static boolean m18748a(int headerA, long headerB) {
        return ((long) (-128000 & headerA)) == (-128000 & headerB);
    }

    /* renamed from: a */
    private static int m18745a(C8535t frame, int xingBase) {
        if (frame.mo26115d() >= xingBase + 4) {
            frame.mo26118e(xingBase);
            int headerData = frame.mo26119f();
            if (headerData == f17009c || headerData == f17010d) {
                return headerData;
            }
        }
        if (frame.mo26115d() >= 40) {
            frame.mo26118e(36);
            int f = frame.mo26119f();
            int i = f17011e;
            if (f == i) {
                return i;
            }
        }
        return 0;
    }

    /* renamed from: a */
    private static C8176d m18746a(Metadata metadata, long firstFramePosition) {
        if (metadata != null) {
            int length = metadata.mo25541a();
            for (int i = 0; i < length; i++) {
                Entry entry = metadata.mo25542a(i);
                if (entry instanceof MlltFrame) {
                    return C8176d.m18739a(firstFramePosition, (MlltFrame) entry);
                }
            }
        }
        return null;
    }
}
