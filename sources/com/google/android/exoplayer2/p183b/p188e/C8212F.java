package com.google.android.exoplayer2.p183b.p188e;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.DvbSubtitleInfo;
import com.google.android.exoplayer2.p183b.C8148a.C8151c;
import com.google.android.exoplayer2.p183b.C8260g;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8263j;
import com.google.android.exoplayer2.p183b.C8267n;
import com.google.android.exoplayer2.p183b.C8268o.C8270b;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8216a;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8217b;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8218c;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.util.C8506D;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8534s;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.b.e.F */
/* compiled from: TsExtractor */
public final class C8212F implements C8260g {

    /* renamed from: a */
    public static final C8263j f17171a = C8225d.f17217a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final long f17172b = ((long) C8509F.m20464b("AC-3"));
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final long f17173c = ((long) C8509F.m20464b("EAC3"));
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final long f17174d = ((long) C8509F.m20464b("HEVC"));
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final int f17175e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final List<C8506D> f17176f;

    /* renamed from: g */
    private final C8535t f17177g;

    /* renamed from: h */
    private final SparseIntArray f17178h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final C8218c f17179i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final SparseArray<C8215G> f17180j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final SparseBooleanArray f17181k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final SparseBooleanArray f17182l;

    /* renamed from: m */
    private final C8211E f17183m;

    /* renamed from: n */
    private C8209D f17184n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C8262i f17185o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f17186p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f17187q;

    /* renamed from: r */
    private boolean f17188r;

    /* renamed from: s */
    private boolean f17189s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public C8215G f17190t;

    /* renamed from: u */
    private int f17191u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f17192v;

    /* renamed from: com.google.android.exoplayer2.b.e.F$a */
    /* compiled from: TsExtractor */
    private class C8213a implements C8253z {

        /* renamed from: a */
        private final C8534s f17193a = new C8534s(new byte[4]);

        public C8213a() {
        }

        /* renamed from: a */
        public void mo25290a(C8506D timestampAdjuster, C8262i extractorOutput, C8219d idGenerator) {
        }

        /* renamed from: a */
        public void mo25291a(C8535t sectionData) {
            if (sectionData.mo26131q() == 0) {
                sectionData.mo26120f(7);
                int programCount = sectionData.mo26104a() / 4;
                for (int i = 0; i < programCount; i++) {
                    sectionData.mo26107a(this.f17193a, 4);
                    int programNumber = this.f17193a.mo26092a(16);
                    this.f17193a.mo26101c(3);
                    if (programNumber == 0) {
                        this.f17193a.mo26101c(13);
                    } else {
                        int pid = this.f17193a.mo26092a(13);
                        C8212F.this.f17180j.put(pid, new C8206A(new C8214b(pid)));
                        C8212F.this.f17186p = C8212F.this.f17186p + 1;
                    }
                }
                if (C8212F.this.f17175e != 2) {
                    C8212F.this.f17180j.remove(0);
                }
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.b.e.F$b */
    /* compiled from: TsExtractor */
    private class C8214b implements C8253z {

        /* renamed from: a */
        private final C8534s f17195a = new C8534s(new byte[5]);

        /* renamed from: b */
        private final SparseArray<C8215G> f17196b = new SparseArray<>();

        /* renamed from: c */
        private final SparseIntArray f17197c = new SparseIntArray();

        /* renamed from: d */
        private final int f17198d;

        public C8214b(int pid) {
            this.f17198d = pid;
        }

        /* renamed from: a */
        public void mo25290a(C8506D timestampAdjuster, C8262i extractorOutput, C8219d idGenerator) {
        }

        /* renamed from: a */
        public void mo25291a(C8535t sectionData) {
            C8506D timestampAdjuster;
            C8215G reader;
            C8535t tVar = sectionData;
            if (sectionData.mo26131q() == 2) {
                if (C8212F.this.f17175e == 1 || C8212F.this.f17175e == 2 || C8212F.this.f17186p == 1) {
                    timestampAdjuster = (C8506D) C8212F.this.f17176f.get(0);
                } else {
                    timestampAdjuster = new C8506D(((C8506D) C8212F.this.f17176f.get(0)).mo26049a());
                    C8212F.this.f17176f.add(timestampAdjuster);
                }
                tVar.mo26120f(2);
                int programNumber = sectionData.mo26137w();
                int i = 3;
                tVar.mo26120f(3);
                tVar.mo26107a(this.f17195a, 2);
                this.f17195a.mo26101c(3);
                int i2 = 13;
                C8212F.this.f17192v = this.f17195a.mo26092a(13);
                tVar.mo26107a(this.f17195a, 2);
                int i3 = 4;
                this.f17195a.mo26101c(4);
                int i4 = 12;
                tVar.mo26120f(this.f17195a.mo26092a(12));
                int i5 = 21;
                if (C8212F.this.f17175e == 2 && C8212F.this.f17190t == null) {
                    C8217b dummyEsInfo = new C8217b(21, null, null, C8509F.f18798f);
                    C8212F f = C8212F.this;
                    f.f17190t = f.f17179i.mo25297a(21, dummyEsInfo);
                    C8212F.this.f17190t.mo25286a(timestampAdjuster, C8212F.this.f17185o, new C8219d(programNumber, 21, Opcodes.ACC_ANNOTATION));
                }
                this.f17196b.clear();
                this.f17197c.clear();
                int remainingEntriesLength = sectionData.mo26104a();
                while (remainingEntriesLength > 0) {
                    tVar.mo26107a(this.f17195a, 5);
                    int streamType = this.f17195a.mo26092a(8);
                    this.f17195a.mo26101c(i);
                    int elementaryPid = this.f17195a.mo26092a(i2);
                    this.f17195a.mo26101c(i3);
                    int esInfoLength = this.f17195a.mo26092a(i4);
                    C8217b esInfo = m18938a(tVar, esInfoLength);
                    if (streamType == 6) {
                        streamType = esInfo.f17203a;
                    }
                    remainingEntriesLength -= esInfoLength + 5;
                    int trackId = C8212F.this.f17175e == 2 ? streamType : elementaryPid;
                    if (!C8212F.this.f17181k.get(trackId)) {
                        if (C8212F.this.f17175e == 2 && streamType == i5) {
                            reader = C8212F.this.f17190t;
                        } else {
                            reader = C8212F.this.f17179i.mo25297a(streamType, esInfo);
                        }
                        if (C8212F.this.f17175e != 2 || elementaryPid < this.f17197c.get(trackId, Opcodes.ACC_ANNOTATION)) {
                            this.f17197c.put(trackId, elementaryPid);
                            this.f17196b.put(trackId, reader);
                        }
                    }
                    i = 3;
                    i3 = 4;
                    i2 = 13;
                    i4 = 12;
                    i5 = 21;
                }
                int trackIdCount = this.f17197c.size();
                for (int i6 = 0; i6 < trackIdCount; i6++) {
                    int trackId2 = this.f17197c.keyAt(i6);
                    int trackPid = this.f17197c.valueAt(i6);
                    C8212F.this.f17181k.put(trackId2, true);
                    C8212F.this.f17182l.put(trackPid, true);
                    C8215G reader2 = (C8215G) this.f17196b.valueAt(i6);
                    if (reader2 != null) {
                        if (reader2 != C8212F.this.f17190t) {
                            reader2.mo25286a(timestampAdjuster, C8212F.this.f17185o, new C8219d(programNumber, trackId2, Opcodes.ACC_ANNOTATION));
                        }
                        C8212F.this.f17180j.put(trackPid, reader2);
                    }
                }
                if (C8212F.this.f17175e != 2) {
                    int i7 = 0;
                    C8212F.this.f17180j.remove(this.f17198d);
                    C8212F f2 = C8212F.this;
                    if (f2.f17175e != 1) {
                        i7 = C8212F.this.f17186p - 1;
                    }
                    f2.f17186p = i7;
                    if (C8212F.this.f17186p == 0) {
                        C8212F.this.f17185o.mo25353g();
                        C8212F.this.f17187q = true;
                    }
                } else if (!C8212F.this.f17187q) {
                    C8212F.this.f17185o.mo25353g();
                    C8212F.this.f17186p = 0;
                    C8212F.this.f17187q = true;
                }
            }
        }

        /* renamed from: a */
        private C8217b m18938a(C8535t data, int length) {
            C8535t tVar = data;
            int descriptorsStartPosition = data.mo26113c();
            int descriptorsEndPosition = descriptorsStartPosition + length;
            int streamType = -1;
            String language = null;
            List<DvbSubtitleInfo> dvbSubtitleInfos = null;
            while (data.mo26113c() < descriptorsEndPosition) {
                int descriptorTag = data.mo26131q();
                int positionOfNextDescriptor = data.mo26113c() + data.mo26131q();
                if (descriptorTag == 5) {
                    long formatIdentifier = data.mo26133s();
                    if (formatIdentifier == C8212F.f17172b) {
                        streamType = Opcodes.LOR;
                    } else if (formatIdentifier == C8212F.f17173c) {
                        streamType = Opcodes.I2D;
                    } else if (formatIdentifier == C8212F.f17174d) {
                        streamType = 36;
                    }
                } else if (descriptorTag == 106) {
                    streamType = Opcodes.LOR;
                } else if (descriptorTag == 122) {
                    streamType = Opcodes.I2D;
                } else if (descriptorTag == 123) {
                    streamType = Opcodes.L2D;
                } else if (descriptorTag == 10) {
                    language = tVar.mo26112b(3).trim();
                } else if (descriptorTag == 89) {
                    streamType = 89;
                    dvbSubtitleInfos = new ArrayList<>();
                    while (data.mo26113c() < positionOfNextDescriptor) {
                        String dvbLanguage = tVar.mo26112b(3).trim();
                        int dvbSubtitlingType = data.mo26131q();
                        byte[] initializationData = new byte[4];
                        tVar.mo26110a(initializationData, 0, 4);
                        dvbSubtitleInfos.add(new C8216a(dvbLanguage, dvbSubtitlingType, initializationData));
                    }
                }
                tVar.mo26120f(positionOfNextDescriptor - data.mo26113c());
            }
            tVar.mo26118e(descriptorsEndPosition);
            return new C8217b(streamType, language, dvbSubtitleInfos, Arrays.copyOfRange(tVar.f18861a, descriptorsStartPosition, descriptorsEndPosition));
        }
    }

    /* renamed from: e */
    static /* synthetic */ C8260g[] m18922e() {
        return new C8260g[]{new C8212F()};
    }

    public C8212F() {
        this(0);
    }

    public C8212F(int defaultTsPayloadReaderFlags) {
        this(1, defaultTsPayloadReaderFlags);
    }

    public C8212F(int mode, int defaultTsPayloadReaderFlags) {
        this(mode, new C8506D(0), new C8230i(defaultTsPayloadReaderFlags));
    }

    public C8212F(int mode, C8506D timestampAdjuster, C8218c payloadReaderFactory) {
        C8514e.m20486a(payloadReaderFactory);
        this.f17179i = payloadReaderFactory;
        this.f17175e = mode;
        if (mode == 1 || mode == 2) {
            this.f17176f = Collections.singletonList(timestampAdjuster);
        } else {
            this.f17176f = new ArrayList();
            this.f17176f.add(timestampAdjuster);
        }
        this.f17177g = new C8535t(new byte[9400], 0);
        this.f17181k = new SparseBooleanArray();
        this.f17182l = new SparseBooleanArray();
        this.f17180j = new SparseArray<>();
        this.f17178h = new SparseIntArray();
        this.f17183m = new C8211E();
        this.f17192v = -1;
        m18926g();
    }

    /* renamed from: a */
    public boolean mo25204a(C8261h input) throws IOException, InterruptedException {
        byte[] buffer = this.f17177g.f18861a;
        input.mo25241a(buffer, 0, 940);
        for (int startPosCandidate = 0; startPosCandidate < 188; startPosCandidate++) {
            boolean isSyncBytePatternCorrect = true;
            int i = 0;
            while (true) {
                if (i >= 5) {
                    break;
                } else if (buffer[(i * Opcodes.NEWARRAY) + startPosCandidate] != 71) {
                    isSyncBytePatternCorrect = false;
                    break;
                } else {
                    i++;
                }
            }
            if (isSyncBytePatternCorrect) {
                input.mo25248c(startPosCandidate);
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo25203a(C8262i output) {
        this.f17185o = output;
    }

    /* renamed from: a */
    public void mo25202a(long position, long timeUs) {
        long j = timeUs;
        C8514e.m20490b(this.f17175e != 2);
        int timestampAdjustersCount = this.f17176f.size();
        for (int i = 0; i < timestampAdjustersCount; i++) {
            C8506D timestampAdjuster = (C8506D) this.f17176f.get(i);
            if ((timestampAdjuster.mo26053c() == -9223372036854775807L) || !(timestampAdjuster.mo26053c() == 0 || timestampAdjuster.mo26049a() == j)) {
                timestampAdjuster.mo26054d();
                timestampAdjuster.mo26055d(j);
            }
        }
        if (j != 0) {
            C8209D d = this.f17184n;
            if (d != null) {
                d.mo25189b(j);
            }
        }
        this.f17177g.mo26139y();
        this.f17178h.clear();
        for (int i2 = 0; i2 < this.f17180j.size(); i2++) {
            ((C8215G) this.f17180j.valueAt(i2)).mo25285a();
        }
        this.f17191u = 0;
    }

    /* renamed from: a */
    public void mo25201a() {
    }

    /* renamed from: a */
    public int mo25200a(C8261h input, C8267n seekPosition) throws IOException, InterruptedException {
        C8261h hVar = input;
        C8267n nVar = seekPosition;
        long inputLength = input.getLength();
        C8215G payloadReader = null;
        if (this.f17187q) {
            if (((inputLength == -1 || this.f17175e == 2) ? false : true) && !this.f17183m.mo25295c()) {
                return this.f17183m.mo25292a(hVar, nVar, this.f17192v);
            }
            m18910a(inputLength);
            if (this.f17189s) {
                this.f17189s = false;
                mo25202a(0, 0);
                if (input.getPosition() != 0) {
                    nVar.f17510a = 0;
                    return 1;
                }
            }
            C8209D d = this.f17184n;
            if (d != null && d.mo25191b()) {
                return this.f17184n.mo25184a(hVar, nVar, (C8151c) null);
            }
        }
        if (!m18916b(input)) {
            return -1;
        }
        int endOfPacket = m18923f();
        int limit = this.f17177g.mo26115d();
        if (endOfPacket > limit) {
            return 0;
        }
        int tsPacketHeader = this.f17177g.mo26119f();
        if ((8388608 & tsPacketHeader) != 0) {
            this.f17177g.mo26118e(endOfPacket);
            return 0;
        }
        int packetHeaderFlags = 0 | ((4194304 & tsPacketHeader) != 0 ? 1 : 0);
        int pid = (2096896 & tsPacketHeader) >> 8;
        boolean adaptationFieldExists = (tsPacketHeader & 32) != 0;
        if ((tsPacketHeader & 16) != 0) {
            payloadReader = (C8215G) this.f17180j.get(pid);
        }
        if (payloadReader == null) {
            this.f17177g.mo26118e(endOfPacket);
            return 0;
        }
        if (this.f17175e != 2) {
            int continuityCounter = tsPacketHeader & 15;
            int previousCounter = this.f17178h.get(pid, continuityCounter - 1);
            this.f17178h.put(pid, continuityCounter);
            if (previousCounter == continuityCounter) {
                this.f17177g.mo26118e(endOfPacket);
                return 0;
            } else if (continuityCounter != ((previousCounter + 1) & 15)) {
                payloadReader.mo25285a();
            }
        }
        if (adaptationFieldExists) {
            packetHeaderFlags |= (this.f17177g.mo26131q() & 64) != 0 ? 2 : 0;
            this.f17177g.mo26120f(this.f17177g.mo26131q() - 1);
        }
        int adaptationFieldLength = this.f17187q;
        if (m18911a(pid)) {
            this.f17177g.mo26116d(endOfPacket);
            payloadReader.mo25287a(this.f17177g, packetHeaderFlags);
            this.f17177g.mo26116d(limit);
        }
        if (this.f17175e != 2 && adaptationFieldLength == 0 && this.f17187q && inputLength != -1) {
            this.f17189s = true;
        }
        this.f17177g.mo26118e(endOfPacket);
        return 0;
    }

    /* renamed from: a */
    private void m18910a(long inputLength) {
        if (!this.f17188r) {
            this.f17188r = true;
            if (this.f17183m.mo25293a() != -9223372036854775807L) {
                C8209D d = new C8209D(this.f17183m.mo25294b(), this.f17183m.mo25293a(), inputLength, this.f17192v);
                this.f17184n = d;
                this.f17185o.mo25352a(this.f17184n.mo25186a());
                return;
            }
            this.f17185o.mo25352a(new C8270b(this.f17183m.mo25293a()));
        }
    }

    /* renamed from: b */
    private boolean m18916b(C8261h input) throws IOException, InterruptedException {
        C8535t tVar = this.f17177g;
        byte[] data = tVar.f18861a;
        if (9400 - tVar.mo26113c() < 188) {
            int bytesLeft = this.f17177g.mo26104a();
            if (bytesLeft > 0) {
                System.arraycopy(data, this.f17177g.mo26113c(), data, 0, bytesLeft);
            }
            this.f17177g.mo26109a(data, bytesLeft);
        }
        while (this.f17177g.mo26104a() < 188) {
            int limit = this.f17177g.mo26115d();
            int read = input.read(data, limit, 9400 - limit);
            if (read == -1) {
                return false;
            }
            this.f17177g.mo26116d(limit + read);
        }
        return true;
    }

    /* renamed from: f */
    private int m18923f() throws ParserException {
        int searchStart = this.f17177g.mo26113c();
        int limit = this.f17177g.mo26115d();
        int syncBytePosition = C8220H.m18950a(this.f17177g.f18861a, searchStart, limit);
        this.f17177g.mo26118e(syncBytePosition);
        int endOfPacket = syncBytePosition + Opcodes.NEWARRAY;
        if (endOfPacket > limit) {
            this.f17191u += syncBytePosition - searchStart;
            if (this.f17175e == 2 && this.f17191u > 376) {
                throw new ParserException("Cannot find sync byte. Most likely not a Transport Stream.");
            }
        } else {
            this.f17191u = 0;
        }
        return endOfPacket;
    }

    /* renamed from: a */
    private boolean m18911a(int packetPid) {
        if (this.f17175e == 2 || this.f17187q || !this.f17182l.get(packetPid, false)) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    private void m18926g() {
        this.f17181k.clear();
        this.f17180j.clear();
        SparseArray<TsPayloadReader> initialPayloadReaders = this.f17179i.mo25296a();
        int initialPayloadReadersSize = initialPayloadReaders.size();
        for (int i = 0; i < initialPayloadReadersSize; i++) {
            this.f17180j.put(initialPayloadReaders.keyAt(i), initialPayloadReaders.valueAt(i));
        }
        this.f17180j.put(0, new C8206A(new C8213a()));
        this.f17190t = null;
    }
}
