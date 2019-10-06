package com.google.android.exoplayer2.extractor.mp4;

import android.support.p001v7.widget.LinearLayoutManager;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.C8275d;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.p183b.C8158b;
import com.google.android.exoplayer2.p183b.C8260g;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8263j;
import com.google.android.exoplayer2.p183b.C8267n;
import com.google.android.exoplayer2.p183b.C8268o;
import com.google.android.exoplayer2.p183b.C8268o.C8270b;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.p183b.C8272q.C8273a;
import com.google.android.exoplayer2.text.p190a.C8417b;
import com.google.android.exoplayer2.util.C8506D;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8531r;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.extractor.mp4.h */
/* compiled from: FragmentedMp4Extractor */
public final class C8304h implements C8260g {

    /* renamed from: a */
    public static final C8263j f17754a = C8288a.f17604a;

    /* renamed from: b */
    private static final int f17755b = C8509F.m20464b("seig");

    /* renamed from: c */
    private static final byte[] f17756c = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};

    /* renamed from: d */
    private static final Format f17757d = Format.m18245a(null, "application/x-emsg", Long.MAX_VALUE);

    /* renamed from: A */
    private long f17758A;

    /* renamed from: B */
    private long f17759B;

    /* renamed from: C */
    private C8306b f17760C;

    /* renamed from: D */
    private int f17761D;

    /* renamed from: E */
    private int f17762E;

    /* renamed from: F */
    private int f17763F;

    /* renamed from: G */
    private boolean f17764G;

    /* renamed from: H */
    private C8262i f17765H;

    /* renamed from: I */
    private C8272q[] f17766I;

    /* renamed from: J */
    private C8272q[] f17767J;

    /* renamed from: K */
    private boolean f17768K;

    /* renamed from: e */
    private final int f17769e;

    /* renamed from: f */
    private final C8314n f17770f;

    /* renamed from: g */
    private final List<Format> f17771g;

    /* renamed from: h */
    private final DrmInitData f17772h;

    /* renamed from: i */
    private final SparseArray<C8306b> f17773i;

    /* renamed from: j */
    private final C8535t f17774j;

    /* renamed from: k */
    private final C8535t f17775k;

    /* renamed from: l */
    private final C8535t f17776l;

    /* renamed from: m */
    private final C8506D f17777m;

    /* renamed from: n */
    private final C8535t f17778n;

    /* renamed from: o */
    private final byte[] f17779o;

    /* renamed from: p */
    private final ArrayDeque<C8291a> f17780p;

    /* renamed from: q */
    private final ArrayDeque<C8305a> f17781q;

    /* renamed from: r */
    private final C8272q f17782r;

    /* renamed from: s */
    private int f17783s;

    /* renamed from: t */
    private int f17784t;

    /* renamed from: u */
    private long f17785u;

    /* renamed from: v */
    private int f17786v;

    /* renamed from: w */
    private C8535t f17787w;

    /* renamed from: x */
    private long f17788x;

    /* renamed from: y */
    private int f17789y;

    /* renamed from: z */
    private long f17790z;

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.h$a */
    /* compiled from: FragmentedMp4Extractor */
    private static final class C8305a {

        /* renamed from: a */
        public final long f17791a;

        /* renamed from: b */
        public final int f17792b;

        public C8305a(long presentationTimeDeltaUs, int size) {
            this.f17791a = presentationTimeDeltaUs;
            this.f17792b = size;
        }
    }

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.h$b */
    /* compiled from: FragmentedMp4Extractor */
    private static final class C8306b {

        /* renamed from: a */
        public final C8272q f17793a;

        /* renamed from: b */
        public final C8316p f17794b = new C8316p();

        /* renamed from: c */
        public C8314n f17795c;

        /* renamed from: d */
        public C8300e f17796d;

        /* renamed from: e */
        public int f17797e;

        /* renamed from: f */
        public int f17798f;

        /* renamed from: g */
        public int f17799g;

        /* renamed from: h */
        public int f17800h;

        /* renamed from: i */
        private final C8535t f17801i = new C8535t(1);

        /* renamed from: j */
        private final C8535t f17802j = new C8535t();

        public C8306b(C8272q output) {
            this.f17793a = output;
        }

        /* renamed from: a */
        public void mo25443a(C8314n track, C8300e defaultSampleValues) {
            C8514e.m20486a(track);
            this.f17795c = track;
            C8514e.m20486a(defaultSampleValues);
            this.f17796d = defaultSampleValues;
            this.f17793a.mo25340a(track.f17867f);
            mo25446c();
        }

        /* renamed from: a */
        public void mo25442a(DrmInitData drmInitData) {
            C8315o encryptionBox = this.f17795c.mo25449a(this.f17794b.f17878a.f17744a);
            this.f17793a.mo25340a(this.f17795c.f17867f.mo25011a(drmInitData.mo25389a(encryptionBox != null ? encryptionBox.f17874b : null)));
        }

        /* renamed from: c */
        public void mo25446c() {
            this.f17794b.mo25451a();
            this.f17797e = 0;
            this.f17799g = 0;
            this.f17798f = 0;
            this.f17800h = 0;
        }

        /* renamed from: a */
        public void mo25441a(long timeUs) {
            long timeMs = C8275d.m19231b(timeUs);
            int searchIndex = this.f17797e;
            while (true) {
                C8316p pVar = this.f17794b;
                if (searchIndex < pVar.f17883f && pVar.mo25450a(searchIndex) < timeMs) {
                    if (this.f17794b.f17889l[searchIndex]) {
                        this.f17800h = searchIndex;
                    }
                    searchIndex++;
                } else {
                    return;
                }
            }
        }

        /* renamed from: a */
        public boolean mo25444a() {
            this.f17797e++;
            this.f17798f++;
            int i = this.f17798f;
            int[] iArr = this.f17794b.f17885h;
            int i2 = this.f17799g;
            if (i != iArr[i2]) {
                return true;
            }
            this.f17799g = i2 + 1;
            this.f17798f = 0;
            return false;
        }

        /* renamed from: b */
        public int mo25445b() {
            C8535t initializationVectorData;
            int vectorSize;
            C8315o encryptionBox = m19375d();
            if (encryptionBox == null) {
                return 0;
            }
            if (encryptionBox.f17876d != 0) {
                initializationVectorData = this.f17794b.f17894q;
                vectorSize = encryptionBox.f17876d;
            } else {
                byte[] initVectorData = encryptionBox.f17877e;
                this.f17802j.mo26109a(initVectorData, initVectorData.length);
                initializationVectorData = this.f17802j;
                vectorSize = initVectorData.length;
            }
            boolean subsampleEncryption = this.f17794b.mo25456c(this.f17797e);
            this.f17801i.f18861a[0] = (byte) ((subsampleEncryption ? 128 : 0) | vectorSize);
            this.f17801i.mo26118e(0);
            this.f17793a.mo25341a(this.f17801i, 1);
            this.f17793a.mo25341a(initializationVectorData, vectorSize);
            if (!subsampleEncryption) {
                return vectorSize + 1;
            }
            C8535t subsampleEncryptionData = this.f17794b.f17894q;
            int subsampleCount = subsampleEncryptionData.mo26137w();
            subsampleEncryptionData.mo26120f(-2);
            int subsampleDataLength = (subsampleCount * 6) + 2;
            this.f17793a.mo25341a(subsampleEncryptionData, subsampleDataLength);
            return vectorSize + 1 + subsampleDataLength;
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public void m19376e() {
            C8315o encryptionBox = m19375d();
            if (encryptionBox != null) {
                C8535t sampleEncryptionData = this.f17794b.f17894q;
                int i = encryptionBox.f17876d;
                if (i != 0) {
                    sampleEncryptionData.mo26120f(i);
                }
                if (this.f17794b.mo25456c(this.f17797e)) {
                    sampleEncryptionData.mo26120f(sampleEncryptionData.mo26137w() * 6);
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public C8315o m19375d() {
            C8316p pVar = this.f17794b;
            int sampleDescriptionIndex = pVar.f17878a.f17744a;
            C8315o encryptionBox = pVar.f17892o;
            if (encryptionBox == null) {
                encryptionBox = this.f17795c.mo25449a(sampleDescriptionIndex);
            }
            if (encryptionBox == null || !encryptionBox.f17873a) {
                return null;
            }
            return encryptionBox;
        }
    }

    /* renamed from: b */
    static /* synthetic */ C8260g[] m19359b() {
        return new C8260g[]{new C8304h()};
    }

    public C8304h() {
        this(0);
    }

    public C8304h(int flags) {
        this(flags, null);
    }

    public C8304h(int flags, C8506D timestampAdjuster) {
        this(flags, timestampAdjuster, null, null);
    }

    public C8304h(int flags, C8506D timestampAdjuster, C8314n sideloadedTrack, DrmInitData sideloadedDrmInitData) {
        this(flags, timestampAdjuster, sideloadedTrack, sideloadedDrmInitData, Collections.emptyList());
    }

    public C8304h(int flags, C8506D timestampAdjuster, C8314n sideloadedTrack, DrmInitData sideloadedDrmInitData, List<Format> closedCaptionFormats) {
        this(flags, timestampAdjuster, sideloadedTrack, sideloadedDrmInitData, closedCaptionFormats, null);
    }

    public C8304h(int flags, C8506D timestampAdjuster, C8314n sideloadedTrack, DrmInitData sideloadedDrmInitData, List<Format> closedCaptionFormats, C8272q additionalEmsgTrackOutput) {
        this.f17769e = (sideloadedTrack != null ? 8 : 0) | flags;
        this.f17777m = timestampAdjuster;
        this.f17770f = sideloadedTrack;
        this.f17772h = sideloadedDrmInitData;
        this.f17771g = Collections.unmodifiableList(closedCaptionFormats);
        this.f17782r = additionalEmsgTrackOutput;
        this.f17778n = new C8535t(16);
        this.f17774j = new C8535t(C8531r.f18837a);
        this.f17775k = new C8535t(5);
        this.f17776l = new C8535t();
        this.f17779o = new byte[16];
        this.f17780p = new ArrayDeque<>();
        this.f17781q = new ArrayDeque<>();
        this.f17773i = new SparseArray<>();
        this.f17758A = -9223372036854775807L;
        this.f17790z = -9223372036854775807L;
        this.f17759B = -9223372036854775807L;
        m19361c();
    }

    /* renamed from: a */
    public boolean mo25204a(C8261h input) throws IOException, InterruptedException {
        return C8313m.m19422a(input);
    }

    /* renamed from: a */
    public void mo25203a(C8262i output) {
        this.f17765H = output;
        C8314n nVar = this.f17770f;
        if (nVar != null) {
            C8306b bundle = new C8306b(output.mo25351a(0, nVar.f17863b));
            bundle.mo25443a(this.f17770f, new C8300e(0, 0, 0, 0));
            this.f17773i.put(0, bundle);
            m19365d();
            this.f17765H.mo25353g();
        }
    }

    /* renamed from: a */
    public void mo25202a(long position, long timeUs) {
        int trackCount = this.f17773i.size();
        for (int i = 0; i < trackCount; i++) {
            ((C8306b) this.f17773i.valueAt(i)).mo25446c();
        }
        this.f17781q.clear();
        this.f17789y = 0;
        this.f17790z = timeUs;
        this.f17780p.clear();
        m19361c();
    }

    /* renamed from: a */
    public void mo25201a() {
    }

    /* renamed from: a */
    public int mo25200a(C8261h input, C8267n seekPosition) throws IOException, InterruptedException {
        while (true) {
            int i = this.f17783s;
            if (i != 0) {
                if (i == 1) {
                    m19362c(input);
                } else if (i == 2) {
                    m19366d(input);
                } else if (m19367e(input)) {
                    return 0;
                }
            } else if (!m19358b(input)) {
                return -1;
            }
        }
    }

    /* renamed from: c */
    private void m19361c() {
        this.f17783s = 0;
        this.f17786v = 0;
    }

    /* renamed from: b */
    private boolean m19358b(C8261h input) throws IOException, InterruptedException {
        if (this.f17786v == 0) {
            if (!input.mo25247b(this.f17778n.f18861a, 0, 8, true)) {
                return false;
            }
            this.f17786v = 8;
            this.f17778n.mo26118e(0);
            this.f17785u = this.f17778n.mo26133s();
            this.f17784t = this.f17778n.mo26119f();
        }
        long j = this.f17785u;
        if (j == 1) {
            input.readFully(this.f17778n.f18861a, 8, 8);
            this.f17786v += 8;
            this.f17785u = this.f17778n.mo26136v();
        } else if (j == 0) {
            long endPosition = input.getLength();
            if (endPosition == -1 && !this.f17780p.isEmpty()) {
                endPosition = ((C8291a) this.f17780p.peek()).f17707Xa;
            }
            if (endPosition != -1) {
                this.f17785u = (endPosition - input.getPosition()) + ((long) this.f17786v);
            }
        }
        if (this.f17785u >= ((long) this.f17786v)) {
            long atomPosition = input.getPosition() - ((long) this.f17786v);
            if (this.f17784t == C8290c.f17626K) {
                int trackCount = this.f17773i.size();
                for (int i = 0; i < trackCount; i++) {
                    C8316p fragment = ((C8306b) this.f17773i.valueAt(i)).f17794b;
                    fragment.f17879b = atomPosition;
                    fragment.f17881d = atomPosition;
                    fragment.f17880c = atomPosition;
                }
            }
            int trackCount2 = this.f17784t;
            if (trackCount2 == C8290c.f17668h) {
                this.f17760C = null;
                this.f17788x = this.f17785u + atomPosition;
                if (!this.f17768K) {
                    this.f17765H.mo25352a(new C8270b(this.f17758A, atomPosition));
                    this.f17768K = true;
                }
                this.f17783s = 2;
                return true;
            }
            if (m19350a(trackCount2)) {
                long endPosition2 = (input.getPosition() + this.f17785u) - 8;
                this.f17780p.push(new C8291a(this.f17784t, endPosition2));
                if (this.f17785u == ((long) this.f17786v)) {
                    m19353b(endPosition2);
                } else {
                    m19361c();
                }
            } else if (m19357b(this.f17784t)) {
                if (this.f17786v == 8) {
                    long j2 = this.f17785u;
                    if (j2 <= 2147483647L) {
                        this.f17787w = new C8535t((int) j2);
                        System.arraycopy(this.f17778n.f18861a, 0, this.f17787w.f18861a, 0, 8);
                        this.f17783s = 1;
                    } else {
                        throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw new ParserException("Leaf atom defines extended atom size (unsupported).");
                }
            } else if (this.f17785u <= 2147483647L) {
                this.f17787w = null;
                this.f17783s = 1;
            } else {
                throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
            }
            return true;
        }
        throw new ParserException("Atom size less than header length (unsupported).");
    }

    /* renamed from: c */
    private void m19362c(C8261h input) throws IOException, InterruptedException {
        int atomPayloadSize = ((int) this.f17785u) - this.f17786v;
        C8535t tVar = this.f17787w;
        if (tVar != null) {
            input.readFully(tVar.f18861a, 8, atomPayloadSize);
            m19343a(new C8292b(this.f17784t, this.f17787w), input.getPosition());
        } else {
            input.mo25248c(atomPayloadSize);
        }
        m19353b(input.getPosition());
    }

    /* renamed from: b */
    private void m19353b(long atomEndPosition) throws ParserException {
        while (!this.f17780p.isEmpty() && ((C8291a) this.f17780p.peek()).f17707Xa == atomEndPosition) {
            m19340a((C8291a) this.f17780p.pop());
        }
        m19361c();
    }

    /* renamed from: a */
    private void m19343a(C8292b leaf, long inputPosition) throws ParserException {
        if (!this.f17780p.isEmpty()) {
            ((C8291a) this.f17780p.peek()).mo25434a(leaf);
            return;
        }
        int i = leaf.f17706Wa;
        if (i == C8290c.f17606A) {
            Pair<Long, ChunkIndex> result = m19334a(leaf.f17710Xa, inputPosition);
            this.f17759B = ((Long) result.first).longValue();
            this.f17765H.mo25352a((C8268o) result.second);
            this.f17768K = true;
        } else if (i == C8290c.f17621Ha) {
            m19345a(leaf.f17710Xa);
        }
    }

    /* renamed from: a */
    private void m19340a(C8291a container) throws ParserException {
        int i = container.f17706Wa;
        if (i == C8290c.f17608B) {
            m19363c(container);
        } else if (i == C8290c.f17626K) {
            m19354b(container);
        } else if (!this.f17780p.isEmpty()) {
            ((C8291a) this.f17780p.peek()).mo25433a(container);
        }
    }

    /* renamed from: c */
    private void m19363c(C8291a moov) throws ParserException {
        DrmInitData drmInitData;
        int moovContainerChildrenSize;
        int i;
        SparseArray sparseArray;
        C8291a aVar = moov;
        C8514e.m20491b(this.f17770f == null, "Unexpected moov box.");
        DrmInitData drmInitData2 = this.f17772h;
        if (drmInitData2 != null) {
            drmInitData = drmInitData2;
        } else {
            drmInitData = m19335a(aVar.f17708Ya);
        }
        C8291a mvex = aVar.mo25435d(C8290c.f17630M);
        SparseArray sparseArray2 = new SparseArray();
        int mvexChildrenSize = mvex.f17708Ya.size();
        long duration = -9223372036854775807L;
        for (int i2 = 0; i2 < mvexChildrenSize; i2++) {
            C8292b atom = (C8292b) mvex.f17708Ya.get(i2);
            int i3 = atom.f17706Wa;
            if (i3 == C8290c.f17702y) {
                Pair<Integer, DefaultSampleValues> trexData = m19364d(atom.f17710Xa);
                sparseArray2.put(((Integer) trexData.first).intValue(), trexData.second);
            } else if (i3 == C8290c.f17632N) {
                duration = m19351b(atom.f17710Xa);
            }
        }
        SparseArray sparseArray3 = new SparseArray();
        int moovContainerChildrenSize2 = aVar.f17709Za.size();
        int i4 = 0;
        while (i4 < moovContainerChildrenSize2) {
            C8291a atom2 = (C8291a) aVar.f17709Za.get(i4);
            if (atom2.f17706Wa == C8290c.f17612D) {
                i = i4;
                C8291a aVar2 = atom2;
                moovContainerChildrenSize = moovContainerChildrenSize2;
                sparseArray = sparseArray3;
                C8314n track = C8293d.m19299a(atom2, aVar.mo25436e(C8290c.f17610C), duration, drmInitData, (this.f17769e & 16) != 0, false);
                if (track != null) {
                    sparseArray.put(track.f17862a, track);
                }
            } else {
                i = i4;
                C8291a aVar3 = atom2;
                moovContainerChildrenSize = moovContainerChildrenSize2;
                sparseArray = sparseArray3;
            }
            i4 = i + 1;
            sparseArray3 = sparseArray;
            moovContainerChildrenSize2 = moovContainerChildrenSize;
        }
        int i5 = i4;
        int i6 = moovContainerChildrenSize2;
        SparseArray sparseArray4 = sparseArray3;
        int trackCount = sparseArray4.size();
        if (this.f17773i.size() == 0) {
            int i7 = 0;
            while (i7 < trackCount) {
                C8314n track2 = (C8314n) sparseArray4.valueAt(i7);
                C8306b trackBundle = new C8306b(this.f17765H.mo25351a(i7, track2.f17863b));
                trackBundle.mo25443a(track2, m19336a(sparseArray2, track2.f17862a));
                this.f17773i.put(track2.f17862a, trackBundle);
                C8291a mvex2 = mvex;
                this.f17758A = Math.max(this.f17758A, track2.f17866e);
                i7++;
                C8291a aVar4 = moov;
                mvex = mvex2;
            }
            m19365d();
            this.f17765H.mo25353g();
            return;
        }
        C8514e.m20490b(this.f17773i.size() == trackCount);
        for (int i8 = 0; i8 < trackCount; i8++) {
            C8314n track3 = (C8314n) sparseArray4.valueAt(i8);
            ((C8306b) this.f17773i.get(track3.f17862a)).mo25443a(track3, m19336a(sparseArray2, track3.f17862a));
        }
    }

    /* renamed from: a */
    private C8300e m19336a(SparseArray<C8300e> defaultSampleValuesArray, int trackId) {
        if (defaultSampleValuesArray.size() == 1) {
            return (C8300e) defaultSampleValuesArray.valueAt(0);
        }
        Object obj = defaultSampleValuesArray.get(trackId);
        C8514e.m20486a(obj);
        return (C8300e) obj;
    }

    /* renamed from: b */
    private void m19354b(C8291a moof) throws ParserException {
        DrmInitData drmInitData;
        m19341a(moof, this.f17773i, this.f17769e, this.f17779o);
        if (this.f17772h != null) {
            drmInitData = null;
        } else {
            drmInitData = m19335a(moof.f17708Ya);
        }
        if (drmInitData != null) {
            int trackCount = this.f17773i.size();
            for (int i = 0; i < trackCount; i++) {
                ((C8306b) this.f17773i.valueAt(i)).mo25442a(drmInitData);
            }
        }
        if (this.f17790z != -9223372036854775807L) {
            int trackCount2 = this.f17773i.size();
            for (int i2 = 0; i2 < trackCount2; i2++) {
                ((C8306b) this.f17773i.valueAt(i2)).mo25441a(this.f17790z);
            }
            this.f17790z = -9223372036854775807L;
        }
    }

    /* renamed from: d */
    private void m19365d() {
        if (this.f17766I == null) {
            this.f17766I = new C8272q[2];
            int emsgTrackOutputCount = 0;
            C8272q qVar = this.f17782r;
            if (qVar != null) {
                int emsgTrackOutputCount2 = 0 + 1;
                this.f17766I[0] = qVar;
                emsgTrackOutputCount = emsgTrackOutputCount2;
            }
            if ((this.f17769e & 4) != 0) {
                int emsgTrackOutputCount3 = emsgTrackOutputCount + 1;
                this.f17766I[emsgTrackOutputCount] = this.f17765H.mo25351a(this.f17773i.size(), 4);
                emsgTrackOutputCount = emsgTrackOutputCount3;
            }
            this.f17766I = (C8272q[]) Arrays.copyOf(this.f17766I, emsgTrackOutputCount);
            for (C8272q eventMessageTrackOutput : this.f17766I) {
                eventMessageTrackOutput.mo25340a(f17757d);
            }
        }
        if (this.f17767J == null) {
            this.f17767J = new C8272q[this.f17771g.size()];
            for (int i = 0; i < this.f17767J.length; i++) {
                C8272q output = this.f17765H.mo25351a(this.f17773i.size() + 1 + i, 3);
                output.mo25340a((Format) this.f17771g.get(i));
                this.f17767J[i] = output;
            }
        }
    }

    /* renamed from: a */
    private void m19345a(C8535t atom) {
        C8272q[] qVarArr;
        long sampleTimeUs;
        C8535t tVar = atom;
        C8272q[] qVarArr2 = this.f17766I;
        if (qVarArr2 != null && qVarArr2.length != 0) {
            tVar.mo26118e(12);
            int sampleSize = atom.mo26104a();
            atom.mo26128n();
            atom.mo26128n();
            long presentationTimeDeltaUs = C8509F.m20471c(atom.mo26133s(), 1000000, atom.mo26133s());
            for (C8272q emsgTrackOutput : this.f17766I) {
                tVar.mo26118e(12);
                emsgTrackOutput.mo25341a(tVar, sampleSize);
            }
            long j = this.f17759B;
            if (j != -9223372036854775807L) {
                long sampleTimeUs2 = j + presentationTimeDeltaUs;
                C8506D d = this.f17777m;
                if (d != null) {
                    sampleTimeUs = d.mo26050a(sampleTimeUs2);
                } else {
                    sampleTimeUs = sampleTimeUs2;
                }
                C8272q[] qVarArr3 = this.f17766I;
                int length = qVarArr3.length;
                int i = 0;
                while (i < length) {
                    int i2 = i;
                    int i3 = length;
                    qVarArr3[i].mo25339a(sampleTimeUs, 1, sampleSize, 0, null);
                    i = i2 + 1;
                    length = i3;
                }
            } else {
                this.f17781q.addLast(new C8305a(presentationTimeDeltaUs, sampleSize));
                this.f17789y += sampleSize;
            }
        }
    }

    /* renamed from: d */
    private static Pair<Integer, C8300e> m19364d(C8535t trex) {
        trex.mo26118e(12);
        return Pair.create(Integer.valueOf(trex.mo26119f()), new C8300e(trex.mo26135u() - 1, trex.mo26135u(), trex.mo26135u(), trex.mo26119f()));
    }

    /* renamed from: b */
    private static long m19351b(C8535t mehd) {
        mehd.mo26118e(8);
        return C8290c.m19289c(mehd.mo26119f()) == 0 ? mehd.mo26133s() : mehd.mo26136v();
    }

    /* renamed from: a */
    private static void m19341a(C8291a moof, SparseArray<C8306b> trackBundleArray, int flags, byte[] extendedTypeScratch) throws ParserException {
        int moofContainerChildrenSize = moof.f17709Za.size();
        for (int i = 0; i < moofContainerChildrenSize; i++) {
            C8291a child = (C8291a) moof.f17709Za.get(i);
            if (child.f17706Wa == C8290c.f17628L) {
                m19355b(child, trackBundleArray, flags, extendedTypeScratch);
            }
        }
    }

    /* renamed from: b */
    private static void m19355b(C8291a traf, SparseArray<C8306b> trackBundleArray, int flags, byte[] extendedTypeScratch) throws ParserException {
        String str;
        C8291a aVar = traf;
        int i = flags;
        C8292b tfhd = aVar.mo25436e(C8290c.f17700x);
        C8306b trackBundle = m19338a(tfhd.f17710Xa, trackBundleArray);
        if (trackBundle != null) {
            C8316p fragment = trackBundle.f17794b;
            long decodeTime = fragment.f17896s;
            trackBundle.mo25446c();
            if (aVar.mo25436e(C8290c.f17698w) != null && (i & 2) == 0) {
                decodeTime = m19360c(aVar.mo25436e(C8290c.f17698w).f17710Xa);
            }
            m19342a(aVar, trackBundle, decodeTime, i);
            C8315o encryptionBox = trackBundle.f17795c.mo25449a(fragment.f17878a.f17744a);
            C8292b saiz = aVar.mo25436e(C8290c.f17659ca);
            if (saiz != null) {
                m19344a(encryptionBox, saiz.f17710Xa, fragment);
            }
            C8292b saio = aVar.mo25436e(C8290c.f17661da);
            if (saio != null) {
                m19347a(saio.f17710Xa, fragment);
            }
            C8292b senc = aVar.mo25436e(C8290c.f17669ha);
            if (senc != null) {
                m19356b(senc.f17710Xa, fragment);
            }
            C8292b sbgp = aVar.mo25436e(C8290c.f17663ea);
            C8292b sgpd = aVar.mo25436e(C8290c.f17665fa);
            if (sbgp == null || sgpd == null) {
            } else {
                C8535t tVar = sbgp.f17710Xa;
                C8535t tVar2 = sgpd.f17710Xa;
                if (encryptionBox != null) {
                    C8292b bVar = tfhd;
                    str = encryptionBox.f17874b;
                } else {
                    str = null;
                }
                m19349a(tVar, tVar2, str, fragment);
            }
            int leafChildrenSize = aVar.f17708Ya.size();
            int i2 = 0;
            while (i2 < leafChildrenSize) {
                C8292b atom = (C8292b) aVar.f17708Ya.get(i2);
                int leafChildrenSize2 = leafChildrenSize;
                if (atom.f17706Wa == C8290c.f17667ga) {
                    m19348a(atom.f17710Xa, fragment, extendedTypeScratch);
                } else {
                    byte[] bArr = extendedTypeScratch;
                }
                i2++;
                aVar = traf;
                leafChildrenSize = leafChildrenSize2;
            }
            byte[] bArr2 = extendedTypeScratch;
        }
    }

    /* renamed from: a */
    private static void m19342a(C8291a traf, C8306b trackBundle, long decodeTime, int flags) {
        C8306b bVar = trackBundle;
        List<C8292b> list = traf.f17708Ya;
        int leafChildrenSize = list.size();
        int trunCount = 0;
        int totalSampleCount = 0;
        for (int i = 0; i < leafChildrenSize; i++) {
            C8292b atom = (C8292b) list.get(i);
            if (atom.f17706Wa == C8290c.f17704z) {
                C8535t trunData = atom.f17710Xa;
                trunData.mo26118e(12);
                int trunSampleCount = trunData.mo26135u();
                if (trunSampleCount > 0) {
                    totalSampleCount += trunSampleCount;
                    trunCount++;
                }
            }
        }
        bVar.f17799g = 0;
        bVar.f17798f = 0;
        bVar.f17797e = 0;
        bVar.f17794b.mo25452a(trunCount, totalSampleCount);
        int trunStartPosition = 0;
        int trunIndex = 0;
        for (int i2 = 0; i2 < leafChildrenSize; i2++) {
            C8292b trun = (C8292b) list.get(i2);
            if (trun.f17706Wa == C8290c.f17704z) {
                int trunIndex2 = trunIndex + 1;
                trunStartPosition = m19333a(trackBundle, trunIndex, decodeTime, flags, trun.f17710Xa, trunStartPosition);
                trunIndex = trunIndex2;
            }
        }
    }

    /* renamed from: a */
    private static void m19344a(C8315o encryptionBox, C8535t saiz, C8316p out) throws ParserException {
        int vectorSize = encryptionBox.f17876d;
        saiz.mo26118e(8);
        boolean subsampleEncryption = true;
        if ((C8290c.m19288b(saiz.mo26119f()) & 1) == 1) {
            saiz.mo26120f(8);
        }
        int defaultSampleInfoSize = saiz.mo26131q();
        int sampleCount = saiz.mo26135u();
        if (sampleCount == out.f17883f) {
            int totalSize = 0;
            if (defaultSampleInfoSize == 0) {
                boolean[] sampleHasSubsampleEncryptionTable = out.f17891n;
                for (int i = 0; i < sampleCount; i++) {
                    int sampleInfoSize = saiz.mo26131q();
                    totalSize += sampleInfoSize;
                    sampleHasSubsampleEncryptionTable[i] = sampleInfoSize > vectorSize;
                }
            } else {
                if (defaultSampleInfoSize <= vectorSize) {
                    subsampleEncryption = false;
                }
                totalSize = 0 + (defaultSampleInfoSize * sampleCount);
                Arrays.fill(out.f17891n, 0, sampleCount, subsampleEncryption);
            }
            out.mo25455b(totalSize);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Length mismatch: ");
        sb.append(sampleCount);
        sb.append(", ");
        sb.append(out.f17883f);
        throw new ParserException(sb.toString());
    }

    /* renamed from: a */
    private static void m19347a(C8535t saio, C8316p out) throws ParserException {
        saio.mo26118e(8);
        int fullAtom = saio.mo26119f();
        if ((C8290c.m19288b(fullAtom) & 1) == 1) {
            saio.mo26120f(8);
        }
        int entryCount = saio.mo26135u();
        if (entryCount == 1) {
            out.f17881d += C8290c.m19289c(fullAtom) == 0 ? saio.mo26133s() : saio.mo26136v();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected saio entry count: ");
        sb.append(entryCount);
        throw new ParserException(sb.toString());
    }

    /* renamed from: a */
    private static C8306b m19338a(C8535t tfhd, SparseArray<C8306b> trackBundles) {
        tfhd.mo26118e(8);
        int atomFlags = C8290c.m19288b(tfhd.mo26119f());
        C8306b trackBundle = m19352b(trackBundles, tfhd.mo26119f());
        if (trackBundle == null) {
            return null;
        }
        if ((atomFlags & 1) != 0) {
            long baseDataPosition = tfhd.mo26136v();
            C8316p pVar = trackBundle.f17794b;
            pVar.f17880c = baseDataPosition;
            pVar.f17881d = baseDataPosition;
        }
        C8300e defaultSampleValues = trackBundle.f17796d;
        trackBundle.f17794b.f17878a = new C8300e((atomFlags & 2) != 0 ? tfhd.mo26135u() - 1 : defaultSampleValues.f17744a, (atomFlags & 8) != 0 ? tfhd.mo26135u() : defaultSampleValues.f17745b, (atomFlags & 16) != 0 ? tfhd.mo26135u() : defaultSampleValues.f17746c, (atomFlags & 32) != 0 ? tfhd.mo26135u() : defaultSampleValues.f17747d);
        return trackBundle;
    }

    /* renamed from: b */
    private static C8306b m19352b(SparseArray<C8306b> trackBundles, int trackId) {
        if (trackBundles.size() == 1) {
            return (C8306b) trackBundles.valueAt(0);
        }
        return (C8306b) trackBundles.get(trackId);
    }

    /* renamed from: c */
    private static long m19360c(C8535t tfdt) {
        tfdt.mo26118e(8);
        return C8290c.m19289c(tfdt.mo26119f()) == 1 ? tfdt.mo26136v() : tfdt.mo26133s();
    }

    /* renamed from: a */
    private static int m19333a(C8306b trackBundle, int index, long decodeTime, int flags, C8535t trun, int trackRunStart) {
        int firstSampleFlags;
        int[] sampleSizeTable;
        int firstSampleFlags2;
        long cumulativeTime;
        C8314n track;
        int sampleSize;
        boolean firstSampleFlagsPresent;
        int i;
        boolean sampleSizesPresent;
        boolean sampleDurationsPresent;
        C8300e defaultSampleValues;
        C8306b bVar = trackBundle;
        trun.mo26118e(8);
        int fullAtom = trun.mo26119f();
        int atomFlags = C8290c.m19288b(fullAtom);
        C8314n track2 = bVar.f17795c;
        C8316p fragment = bVar.f17794b;
        C8300e defaultSampleValues2 = fragment.f17878a;
        fragment.f17885h[index] = trun.mo26135u();
        long[] jArr = fragment.f17884g;
        jArr[index] = fragment.f17880c;
        if ((atomFlags & 1) != 0) {
            jArr[index] = jArr[index] + ((long) trun.mo26119f());
        }
        boolean firstSampleFlagsPresent2 = (atomFlags & 4) != 0;
        int firstSampleFlags3 = defaultSampleValues2.f17747d;
        if (firstSampleFlagsPresent2) {
            firstSampleFlags3 = trun.mo26135u();
        }
        boolean sampleDurationsPresent2 = (atomFlags & Opcodes.ACC_NATIVE) != 0;
        boolean sampleSizesPresent2 = (atomFlags & 512) != 0;
        boolean sampleFlagsPresent = (atomFlags & Opcodes.ACC_ABSTRACT) != 0;
        boolean sampleCompositionTimeOffsetsPresent = (atomFlags & Opcodes.ACC_STRICT) != 0;
        long edtsOffset = 0;
        long[] jArr2 = track2.f17869h;
        if (jArr2 != null && jArr2.length == 1 && jArr2[0] == 0) {
            firstSampleFlags = firstSampleFlags3;
            edtsOffset = C8509F.m20471c(track2.f17870i[0], 1000, track2.f17864c);
        } else {
            firstSampleFlags = firstSampleFlags3;
        }
        int[] sampleSizeTable2 = fragment.f17886i;
        int[] sampleCompositionTimeOffsetTable = fragment.f17887j;
        long[] sampleDecodingTimeTable = fragment.f17888k;
        int i2 = fullAtom;
        int i3 = atomFlags;
        int trackRunEnd = trackRunStart + fragment.f17885h[index];
        boolean[] sampleIsSyncFrameTable = fragment.f17889l;
        boolean workaroundEveryVideoFrameIsSyncFrame = track2.f17863b == 2 && (flags & 1) != 0;
        long timescale = track2.f17864c;
        if (index > 0) {
            firstSampleFlags2 = firstSampleFlags;
            sampleSizeTable = sampleSizeTable2;
            cumulativeTime = fragment.f17896s;
        } else {
            firstSampleFlags2 = firstSampleFlags;
            sampleSizeTable = sampleSizeTable2;
            cumulativeTime = decodeTime;
        }
        long cumulativeTime2 = cumulativeTime;
        int i4 = trackRunStart;
        while (i4 < trackRunEnd) {
            int sampleDuration = sampleDurationsPresent2 ? trun.mo26135u() : defaultSampleValues2.f17745b;
            if (sampleSizesPresent2) {
                track = track2;
                sampleSize = trun.mo26135u();
            } else {
                track = track2;
                sampleSize = defaultSampleValues2.f17746c;
            }
            if (i4 == 0 && firstSampleFlagsPresent2) {
                firstSampleFlagsPresent = firstSampleFlagsPresent2;
                i = firstSampleFlags2;
            } else if (sampleFlagsPresent) {
                i = trun.mo26119f();
                firstSampleFlagsPresent = firstSampleFlagsPresent2;
            } else {
                firstSampleFlagsPresent = firstSampleFlagsPresent2;
                i = defaultSampleValues2.f17747d;
            }
            int sampleFlags = i;
            if (sampleCompositionTimeOffsetsPresent) {
                defaultSampleValues = defaultSampleValues2;
                sampleDurationsPresent = sampleDurationsPresent2;
                sampleSizesPresent = sampleSizesPresent2;
                sampleCompositionTimeOffsetTable[i4] = (int) ((((long) trun.mo26119f()) * 1000) / timescale);
            } else {
                defaultSampleValues = defaultSampleValues2;
                sampleDurationsPresent = sampleDurationsPresent2;
                sampleSizesPresent = sampleSizesPresent2;
                sampleCompositionTimeOffsetTable[i4] = 0;
            }
            sampleDecodingTimeTable[i4] = C8509F.m20471c(cumulativeTime2, 1000, timescale) - edtsOffset;
            sampleSizeTable[i4] = sampleSize;
            sampleIsSyncFrameTable[i4] = ((sampleFlags >> 16) & 1) == 0 && (!workaroundEveryVideoFrameIsSyncFrame || i4 == 0);
            int i5 = sampleFlags;
            cumulativeTime2 += (long) sampleDuration;
            i4++;
            track2 = track;
            firstSampleFlagsPresent2 = firstSampleFlagsPresent;
            defaultSampleValues2 = defaultSampleValues;
            sampleDurationsPresent2 = sampleDurationsPresent;
            sampleSizesPresent2 = sampleSizesPresent;
        }
        C8300e eVar = defaultSampleValues2;
        boolean z = firstSampleFlagsPresent2;
        boolean z2 = sampleDurationsPresent2;
        boolean z3 = sampleSizesPresent2;
        fragment.f17896s = cumulativeTime2;
        return trackRunEnd;
    }

    /* renamed from: a */
    private static void m19348a(C8535t uuid, C8316p out, byte[] extendedTypeScratch) throws ParserException {
        uuid.mo26118e(8);
        uuid.mo26110a(extendedTypeScratch, 0, 16);
        if (Arrays.equals(extendedTypeScratch, f17756c)) {
            m19346a(uuid, 16, out);
        }
    }

    /* renamed from: b */
    private static void m19356b(C8535t senc, C8316p out) throws ParserException {
        m19346a(senc, 0, out);
    }

    /* renamed from: a */
    private static void m19346a(C8535t senc, int offset, C8316p out) throws ParserException {
        senc.mo26118e(offset + 8);
        int flags = C8290c.m19288b(senc.mo26119f());
        if ((flags & 1) == 0) {
            boolean subsampleEncryption = (flags & 2) != 0;
            int sampleCount = senc.mo26135u();
            if (sampleCount == out.f17883f) {
                Arrays.fill(out.f17891n, 0, sampleCount, subsampleEncryption);
                out.mo25455b(senc.mo26104a());
                out.mo25454a(senc);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Length mismatch: ");
            sb.append(sampleCount);
            sb.append(", ");
            sb.append(out.f17883f);
            throw new ParserException(sb.toString());
        }
        throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* renamed from: a */
    private static void m19349a(C8535t sbgp, C8535t sgpd, String schemeType, C8316p out) throws ParserException {
        byte[] constantIv;
        C8535t tVar = sbgp;
        C8535t tVar2 = sgpd;
        C8316p pVar = out;
        tVar.mo26118e(8);
        int sbgpFullAtom = sbgp.mo26119f();
        if (sbgp.mo26119f() == f17755b) {
            if (C8290c.m19289c(sbgpFullAtom) == 1) {
                tVar.mo26120f(4);
            }
            if (sbgp.mo26119f() == 1) {
                tVar2.mo26118e(8);
                int sgpdFullAtom = sgpd.mo26119f();
                if (sgpd.mo26119f() == f17755b) {
                    int sgpdVersion = C8290c.m19289c(sgpdFullAtom);
                    if (sgpdVersion == 1) {
                        if (sgpd.mo26133s() == 0) {
                            throw new ParserException("Variable length description in sgpd found (unsupported)");
                        }
                    } else if (sgpdVersion >= 2) {
                        tVar2.mo26120f(4);
                    }
                    if (sgpd.mo26133s() == 1) {
                        tVar2.mo26120f(1);
                        int patternByte = sgpd.mo26131q();
                        int cryptByteBlock = (patternByte & 240) >> 4;
                        int skipByteBlock = patternByte & 15;
                        boolean isProtected = sgpd.mo26131q() == 1;
                        if (isProtected) {
                            int perSampleIvSize = sgpd.mo26131q();
                            byte[] keyId = new byte[16];
                            tVar2.mo26110a(keyId, 0, keyId.length);
                            if (!isProtected || perSampleIvSize != 0) {
                                constantIv = null;
                            } else {
                                int constantIvSize = sgpd.mo26131q();
                                byte[] constantIv2 = new byte[constantIvSize];
                                tVar2.mo26110a(constantIv2, 0, constantIvSize);
                                constantIv = constantIv2;
                            }
                            pVar.f17890m = true;
                            byte[] bArr = keyId;
                            C8315o oVar = new C8315o(isProtected, schemeType, perSampleIvSize, keyId, cryptByteBlock, skipByteBlock, constantIv);
                            pVar.f17892o = oVar;
                            return;
                        }
                        return;
                    }
                    throw new ParserException("Entry count in sgpd != 1 (unsupported).");
                }
                return;
            }
            throw new ParserException("Entry count in sbgp != 1 (unsupported).");
        }
    }

    /* renamed from: a */
    private static Pair<Long, C8158b> m19334a(C8535t atom, long inputPosition) throws ParserException {
        long offset;
        long earliestPresentationTime;
        C8535t tVar = atom;
        tVar.mo26118e(8);
        int fullAtom = atom.mo26119f();
        int version = C8290c.m19289c(fullAtom);
        tVar.mo26120f(4);
        long timescale = atom.mo26133s();
        long offset2 = inputPosition;
        if (version == 0) {
            offset = offset2 + atom.mo26133s();
            earliestPresentationTime = atom.mo26133s();
        } else {
            offset = offset2 + atom.mo26136v();
            earliestPresentationTime = atom.mo26136v();
        }
        long earliestPresentationTimeUs = C8509F.m20471c(earliestPresentationTime, 1000000, timescale);
        tVar.mo26120f(2);
        int referenceCount = atom.mo26137w();
        int[] sizes = new int[referenceCount];
        long[] offsets = new long[referenceCount];
        long[] durationsUs = new long[referenceCount];
        long[] timesUs = new long[referenceCount];
        long timeUs = earliestPresentationTimeUs;
        long time = earliestPresentationTime;
        long offset3 = offset;
        int i = 0;
        while (i < referenceCount) {
            int firstInt = atom.mo26119f();
            if ((firstInt & LinearLayoutManager.INVALID_OFFSET) == 0) {
                long referenceDuration = atom.mo26133s();
                sizes[i] = Integer.MAX_VALUE & firstInt;
                offsets[i] = offset3;
                timesUs[i] = timeUs;
                time += referenceDuration;
                long[] timesUs2 = timesUs;
                int fullAtom2 = fullAtom;
                int version2 = version;
                long[] offsets2 = offsets;
                long[] durationsUs2 = durationsUs;
                int referenceCount2 = referenceCount;
                long earliestPresentationTime2 = earliestPresentationTime;
                int[] sizes2 = sizes;
                timeUs = C8509F.m20471c(time, 1000000, timescale);
                durationsUs2[i] = timeUs - timesUs2[i];
                tVar.mo26120f(4);
                offset3 += (long) sizes2[i];
                i++;
                offsets = offsets2;
                durationsUs = durationsUs2;
                timesUs = timesUs2;
                sizes = sizes2;
                referenceCount = referenceCount2;
                fullAtom = fullAtom2;
                version = version2;
                earliestPresentationTime = earliestPresentationTime2;
            } else {
                int i2 = version;
                long[] jArr = timesUs;
                long[] jArr2 = offsets;
                long[] jArr3 = durationsUs;
                int i3 = referenceCount;
                long j = earliestPresentationTime;
                int[] iArr = sizes;
                throw new ParserException("Unhandled indirect reference");
            }
        }
        int i4 = version;
        int i5 = referenceCount;
        long j2 = earliestPresentationTime;
        return Pair.create(Long.valueOf(earliestPresentationTimeUs), new C8158b(sizes, offsets, durationsUs, timesUs));
    }

    /* renamed from: d */
    private void m19366d(C8261h input) throws IOException, InterruptedException {
        C8306b nextTrackBundle = null;
        long nextDataOffset = Long.MAX_VALUE;
        int trackBundlesSize = this.f17773i.size();
        for (int i = 0; i < trackBundlesSize; i++) {
            C8316p trackFragment = ((C8306b) this.f17773i.valueAt(i)).f17794b;
            if (trackFragment.f17895r && trackFragment.f17881d < nextDataOffset) {
                nextDataOffset = trackFragment.f17881d;
                nextTrackBundle = (C8306b) this.f17773i.valueAt(i);
            }
        }
        if (nextTrackBundle == null) {
            this.f17783s = 3;
            return;
        }
        int bytesToSkip = (int) (nextDataOffset - input.getPosition());
        if (bytesToSkip >= 0) {
            input.mo25248c(bytesToSkip);
            nextTrackBundle.f17794b.mo25453a(input);
            return;
        }
        throw new ParserException("Offset to encryption data was negative.");
    }

    /* renamed from: e */
    private boolean m19367e(C8261h input) throws IOException, InterruptedException {
        long sampleTimeUs;
        int writtenBytes;
        C8261h hVar = input;
        int i = 4;
        int i2 = 1;
        int i3 = 0;
        if (this.f17783s == 3) {
            if (this.f17760C == null) {
                C8306b currentTrackBundle = m19337a(this.f17773i);
                if (currentTrackBundle == null) {
                    int bytesToSkip = (int) (this.f17788x - input.getPosition());
                    if (bytesToSkip >= 0) {
                        hVar.mo25248c(bytesToSkip);
                        m19361c();
                        return false;
                    }
                    throw new ParserException("Offset to end of mdat was negative.");
                }
                int bytesToSkip2 = (int) (currentTrackBundle.f17794b.f17884g[currentTrackBundle.f17799g] - input.getPosition());
                if (bytesToSkip2 < 0) {
                    C8526n.m20534d("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    bytesToSkip2 = 0;
                }
                hVar.mo25248c(bytesToSkip2);
                this.f17760C = currentTrackBundle;
            }
            C8306b currentTrackBundle2 = this.f17760C;
            int[] iArr = currentTrackBundle2.f17794b.f17886i;
            int i4 = currentTrackBundle2.f17797e;
            this.f17761D = iArr[i4];
            if (i4 < currentTrackBundle2.f17800h) {
                hVar.mo25248c(this.f17761D);
                this.f17760C.m19376e();
                if (!this.f17760C.mo25444a()) {
                    this.f17760C = null;
                }
                this.f17783s = 3;
                return true;
            }
            if (currentTrackBundle2.f17795c.f17868g == 1) {
                this.f17761D -= 8;
                hVar.mo25248c(8);
            }
            this.f17762E = this.f17760C.mo25445b();
            this.f17761D += this.f17762E;
            this.f17783s = 4;
            this.f17763F = 0;
        }
        C8306b bVar = this.f17760C;
        C8316p fragment = bVar.f17794b;
        C8314n track = bVar.f17795c;
        C8272q output = bVar.f17793a;
        int sampleIndex = bVar.f17797e;
        long sampleTimeUs2 = fragment.mo25450a(sampleIndex) * 1000;
        C8506D d = this.f17777m;
        if (d != null) {
            sampleTimeUs = d.mo26050a(sampleTimeUs2);
        } else {
            sampleTimeUs = sampleTimeUs2;
        }
        int i5 = track.f17871j;
        if (i5 == 0) {
            while (true) {
                int i6 = this.f17762E;
                int i7 = this.f17761D;
                if (i6 >= i7) {
                    break;
                }
                this.f17762E += output.mo25338a(hVar, i7 - i6, false);
            }
        } else {
            byte[] nalPrefixData = this.f17775k.f18861a;
            nalPrefixData[0] = 0;
            nalPrefixData[1] = 0;
            nalPrefixData[2] = 0;
            int nalUnitPrefixLength = i5 + 1;
            int nalUnitLengthFieldLengthDiff = 4 - i5;
            while (this.f17762E < this.f17761D) {
                int i8 = this.f17763F;
                if (i8 == 0) {
                    hVar.readFully(nalPrefixData, nalUnitLengthFieldLengthDiff, nalUnitPrefixLength);
                    this.f17775k.mo26118e(i3);
                    this.f17763F = this.f17775k.mo26135u() - i2;
                    this.f17774j.mo26118e(i3);
                    output.mo25341a(this.f17774j, i);
                    output.mo25341a(this.f17775k, i2);
                    this.f17764G = this.f17767J.length > 0 && C8531r.m20559a(track.f17867f.f16507g, nalPrefixData[i]);
                    this.f17762E += 5;
                    this.f17761D += nalUnitLengthFieldLengthDiff;
                } else {
                    if (this.f17764G) {
                        this.f17776l.mo26114c(i8);
                        hVar.readFully(this.f17776l.f18861a, i3, this.f17763F);
                        output.mo25341a(this.f17776l, this.f17763F);
                        writtenBytes = this.f17763F;
                        C8535t tVar = this.f17776l;
                        int unescapedLength = C8531r.m20562c(tVar.f18861a, tVar.mo26115d());
                        this.f17776l.mo26118e("video/hevc".equals(track.f17867f.f16507g) ? 1 : 0);
                        this.f17776l.mo26116d(unescapedLength);
                        C8417b.m20012a(sampleTimeUs, this.f17776l, this.f17767J);
                    } else {
                        writtenBytes = output.mo25338a(hVar, i8, false);
                    }
                    this.f17762E += writtenBytes;
                    this.f17763F -= writtenBytes;
                    i = 4;
                    i2 = 1;
                    i3 = 0;
                }
            }
        }
        boolean sampleFlags = fragment.f17889l[sampleIndex];
        C8273a cryptoData = null;
        C8315o encryptionBox = this.f17760C.m19375d();
        if (encryptionBox != null) {
            sampleFlags |= true;
            cryptoData = encryptionBox.f17875c;
        }
        long sampleTimeUs3 = sampleTimeUs;
        C8272q qVar = output;
        output.mo25339a(sampleTimeUs, sampleFlags ? 1 : 0, this.f17761D, 0, cryptoData);
        m19339a(sampleTimeUs3);
        if (!this.f17760C.mo25444a()) {
            this.f17760C = null;
        }
        this.f17783s = 3;
        return true;
    }

    /* renamed from: a */
    private void m19339a(long sampleTimeUs) {
        while (!this.f17781q.isEmpty()) {
            C8305a sampleInfo = (C8305a) this.f17781q.removeFirst();
            this.f17789y -= sampleInfo.f17792b;
            long metadataTimeUs = sampleTimeUs + sampleInfo.f17791a;
            C8506D d = this.f17777m;
            if (d != null) {
                metadataTimeUs = d.mo26050a(metadataTimeUs);
            }
            C8272q[] qVarArr = this.f17766I;
            int length = qVarArr.length;
            for (int i = 0; i < length; i++) {
                qVarArr[i].mo25339a(metadataTimeUs, 1, sampleInfo.f17792b, this.f17789y, null);
            }
        }
    }

    /* renamed from: a */
    private static C8306b m19337a(SparseArray<C8306b> trackBundles) {
        C8306b nextTrackBundle = null;
        long nextTrackRunOffset = Long.MAX_VALUE;
        int trackBundlesSize = trackBundles.size();
        for (int i = 0; i < trackBundlesSize; i++) {
            C8306b trackBundle = (C8306b) trackBundles.valueAt(i);
            int i2 = trackBundle.f17799g;
            C8316p pVar = trackBundle.f17794b;
            if (i2 != pVar.f17882e) {
                long trunOffset = pVar.f17884g[i2];
                if (trunOffset < nextTrackRunOffset) {
                    nextTrackBundle = trackBundle;
                    nextTrackRunOffset = trunOffset;
                }
            }
        }
        return nextTrackBundle;
    }

    /* renamed from: a */
    private static DrmInitData m19335a(List<C8292b> leafChildren) {
        ArrayList arrayList = null;
        int leafChildrenSize = leafChildren.size();
        for (int i = 0; i < leafChildrenSize; i++) {
            C8292b child = (C8292b) leafChildren.get(i);
            if (child.f17706Wa == C8290c.f17646U) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] psshData = child.f17710Xa.f18861a;
                UUID uuid = C8311l.m19418a(psshData);
                if (uuid == null) {
                    C8526n.m20534d("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new SchemeData(uuid, "video/mp4", psshData));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData((List<SchemeData>) arrayList);
    }

    /* renamed from: b */
    private static boolean m19357b(int atom) {
        return atom == C8290c.f17642S || atom == C8290c.f17640R || atom == C8290c.f17610C || atom == C8290c.f17606A || atom == C8290c.f17644T || atom == C8290c.f17698w || atom == C8290c.f17700x || atom == C8290c.f17634O || atom == C8290c.f17702y || atom == C8290c.f17704z || atom == C8290c.f17646U || atom == C8290c.f17659ca || atom == C8290c.f17661da || atom == C8290c.f17669ha || atom == C8290c.f17667ga || atom == C8290c.f17663ea || atom == C8290c.f17665fa || atom == C8290c.f17638Q || atom == C8290c.f17632N || atom == C8290c.f17621Ha;
    }

    /* renamed from: a */
    private static boolean m19350a(int atom) {
        return atom == C8290c.f17608B || atom == C8290c.f17612D || atom == C8290c.f17614E || atom == C8290c.f17616F || atom == C8290c.f17618G || atom == C8290c.f17626K || atom == C8290c.f17628L || atom == C8290c.f17630M || atom == C8290c.f17636P;
    }
}
