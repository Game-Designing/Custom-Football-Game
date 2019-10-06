package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p183b.C8260g;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8263j;
import com.google.android.exoplayer2.p183b.C8264k;
import com.google.android.exoplayer2.p183b.C8267n;
import com.google.android.exoplayer2.p183b.C8268o;
import com.google.android.exoplayer2.p183b.C8268o.C8269a;
import com.google.android.exoplayer2.p183b.C8271p;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8531r;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.extractor.mp4.k */
/* compiled from: Mp4Extractor */
public final class C8309k implements C8260g, C8268o {

    /* renamed from: a */
    public static final C8263j f17833a = C8289b.f17605a;

    /* renamed from: b */
    private static final int f17834b = C8509F.m20464b("qt  ");

    /* renamed from: c */
    private final int f17835c;

    /* renamed from: d */
    private final C8535t f17836d;

    /* renamed from: e */
    private final C8535t f17837e;

    /* renamed from: f */
    private final C8535t f17838f;

    /* renamed from: g */
    private final ArrayDeque<C8291a> f17839g;

    /* renamed from: h */
    private int f17840h;

    /* renamed from: i */
    private int f17841i;

    /* renamed from: j */
    private long f17842j;

    /* renamed from: k */
    private int f17843k;

    /* renamed from: l */
    private C8535t f17844l;

    /* renamed from: m */
    private int f17845m;

    /* renamed from: n */
    private int f17846n;

    /* renamed from: o */
    private int f17847o;

    /* renamed from: p */
    private C8262i f17848p;

    /* renamed from: q */
    private C8310a[] f17849q;

    /* renamed from: r */
    private long[][] f17850r;

    /* renamed from: s */
    private int f17851s;

    /* renamed from: t */
    private long f17852t;

    /* renamed from: u */
    private boolean f17853u;

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.k$a */
    /* compiled from: Mp4Extractor */
    private static final class C8310a {

        /* renamed from: a */
        public final C8314n f17854a;

        /* renamed from: b */
        public final C8317q f17855b;

        /* renamed from: c */
        public final C8272q f17856c;

        /* renamed from: d */
        public int f17857d;

        public C8310a(C8314n track, C8317q sampleTable, C8272q trackOutput) {
            this.f17854a = track;
            this.f17855b = sampleTable;
            this.f17856c = trackOutput;
        }
    }

    /* renamed from: e */
    static /* synthetic */ C8260g[] m19408e() {
        return new C8260g[]{new C8309k()};
    }

    public C8309k() {
        this(0);
    }

    public C8309k(int flags) {
        this.f17835c = flags;
        this.f17838f = new C8535t(16);
        this.f17839g = new ArrayDeque<>();
        this.f17836d = new C8535t(C8531r.f18837a);
        this.f17837e = new C8535t(4);
        this.f17845m = -1;
    }

    /* renamed from: a */
    public boolean mo25204a(C8261h input) throws IOException, InterruptedException {
        return C8313m.m19424b(input);
    }

    /* renamed from: a */
    public void mo25203a(C8262i output) {
        this.f17848p = output;
    }

    /* renamed from: a */
    public void mo25202a(long position, long timeUs) {
        this.f17839g.clear();
        this.f17843k = 0;
        this.f17845m = -1;
        this.f17846n = 0;
        this.f17847o = 0;
        if (position == 0) {
            m19409f();
        } else if (this.f17849q != null) {
            m19407e(timeUs);
        }
    }

    /* renamed from: a */
    public void mo25201a() {
    }

    /* renamed from: a */
    public int mo25200a(C8261h input, C8267n seekPosition) throws IOException, InterruptedException {
        while (true) {
            int i = this.f17840h;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return m19405c(input, seekPosition);
                    }
                    throw new IllegalStateException();
                } else if (m19403b(input, seekPosition)) {
                    return 1;
                }
            } else if (!m19402b(input)) {
                return -1;
            }
        }
    }

    /* renamed from: d */
    public boolean mo25195d() {
        return true;
    }

    /* renamed from: b */
    public long mo25193b() {
        return this.f17852t;
    }

    /* renamed from: a */
    public C8269a mo25192a(long timeUs) {
        long firstOffset;
        long firstTimeUs;
        long j = timeUs;
        C8310a[] aVarArr = this.f17849q;
        if (aVarArr.length == 0) {
            return new C8269a(C8271p.f17515a);
        }
        long secondTimeUs = -9223372036854775807L;
        long secondOffset = -1;
        int i = this.f17851s;
        if (i != -1) {
            C8317q sampleTable = aVarArr[i].f17855b;
            int sampleIndex = m19394a(sampleTable, j);
            if (sampleIndex == -1) {
                return new C8269a(C8271p.f17515a);
            }
            long sampleTimeUs = sampleTable.f17902f[sampleIndex];
            firstTimeUs = sampleTimeUs;
            firstOffset = sampleTable.f17899c[sampleIndex];
            if (sampleTimeUs < j && sampleIndex < sampleTable.f17898b - 1) {
                int secondSampleIndex = sampleTable.mo25458b(j);
                if (!(secondSampleIndex == -1 || secondSampleIndex == sampleIndex)) {
                    secondTimeUs = sampleTable.f17902f[secondSampleIndex];
                    secondOffset = sampleTable.f17899c[secondSampleIndex];
                }
            }
        } else {
            firstTimeUs = timeUs;
            firstOffset = Long.MAX_VALUE;
        }
        int i2 = 0;
        long secondOffset2 = secondOffset;
        long firstOffset2 = firstOffset;
        while (true) {
            C8310a[] aVarArr2 = this.f17849q;
            if (i2 >= aVarArr2.length) {
                break;
            }
            if (i2 != this.f17851s) {
                C8317q sampleTable2 = aVarArr2[i2].f17855b;
                firstOffset2 = m19395a(sampleTable2, firstTimeUs, firstOffset2);
                if (secondTimeUs != -9223372036854775807L) {
                    secondOffset2 = m19395a(sampleTable2, secondTimeUs, secondOffset2);
                }
            }
            i2++;
        }
        C8271p firstSeekPoint = new C8271p(firstTimeUs, firstOffset2);
        if (secondTimeUs == -9223372036854775807L) {
            return new C8269a(firstSeekPoint);
        }
        return new C8269a(firstSeekPoint, new C8271p(secondTimeUs, secondOffset2));
    }

    /* renamed from: f */
    private void m19409f() {
        this.f17840h = 0;
        this.f17843k = 0;
    }

    /* renamed from: b */
    private boolean m19402b(C8261h input) throws IOException, InterruptedException {
        if (this.f17843k == 0) {
            if (!input.mo25247b(this.f17838f.f18861a, 0, 8, true)) {
                return false;
            }
            this.f17843k = 8;
            this.f17838f.mo26118e(0);
            this.f17842j = this.f17838f.mo26133s();
            this.f17841i = this.f17838f.mo26119f();
        }
        long j = this.f17842j;
        if (j == 1) {
            input.readFully(this.f17838f.f18861a, 8, 8);
            this.f17843k += 8;
            this.f17842j = this.f17838f.mo26136v();
        } else if (j == 0) {
            long endPosition = input.getLength();
            if (endPosition == -1 && !this.f17839g.isEmpty()) {
                endPosition = ((C8291a) this.f17839g.peek()).f17707Xa;
            }
            if (endPosition != -1) {
                this.f17842j = (endPosition - input.getPosition()) + ((long) this.f17843k);
            }
        }
        if (this.f17842j >= ((long) this.f17843k)) {
            if (m19398a(this.f17841i)) {
                long endPosition2 = (input.getPosition() + this.f17842j) - ((long) this.f17843k);
                this.f17839g.push(new C8291a(this.f17841i, endPosition2));
                if (this.f17842j == ((long) this.f17843k)) {
                    m19406d(endPosition2);
                } else {
                    m19409f();
                }
            } else if (m19401b(this.f17841i)) {
                C8514e.m20490b(this.f17843k == 8);
                C8514e.m20490b(this.f17842j <= 2147483647L);
                this.f17844l = new C8535t((int) this.f17842j);
                System.arraycopy(this.f17838f.f18861a, 0, this.f17844l.f18861a, 0, 8);
                this.f17840h = 1;
            } else {
                this.f17844l = null;
                this.f17840h = 1;
            }
            return true;
        }
        throw new ParserException("Atom size less than header length (unsupported).");
    }

    /* renamed from: b */
    private boolean m19403b(C8261h input, C8267n positionHolder) throws IOException, InterruptedException {
        long atomPayloadSize = this.f17842j - ((long) this.f17843k);
        long atomEndPosition = input.getPosition() + atomPayloadSize;
        boolean seekRequired = false;
        C8535t tVar = this.f17844l;
        if (tVar != null) {
            input.readFully(tVar.f18861a, this.f17843k, (int) atomPayloadSize);
            if (this.f17841i == C8290c.f17654a) {
                this.f17853u = m19399a(this.f17844l);
            } else if (!this.f17839g.isEmpty()) {
                ((C8291a) this.f17839g.peek()).mo25434a(new C8292b(this.f17841i, this.f17844l));
            }
        } else if (atomPayloadSize < 262144) {
            input.mo25248c((int) atomPayloadSize);
        } else {
            positionHolder.f17510a = input.getPosition() + atomPayloadSize;
            seekRequired = true;
        }
        m19406d(atomEndPosition);
        return seekRequired && this.f17840h != 2;
    }

    /* renamed from: d */
    private void m19406d(long atomEndPosition) throws ParserException {
        while (!this.f17839g.isEmpty() && ((C8291a) this.f17839g.peek()).f17707Xa == atomEndPosition) {
            C8291a containerAtom = (C8291a) this.f17839g.pop();
            if (containerAtom.f17706Wa == C8290c.f17608B) {
                m19397a(containerAtom);
                this.f17839g.clear();
                this.f17840h = 2;
            } else if (!this.f17839g.isEmpty()) {
                ((C8291a) this.f17839g.peek()).mo25433a(containerAtom);
            }
        }
        if (this.f17840h != 2) {
            m19409f();
        }
    }

    /* renamed from: a */
    private void m19397a(C8291a moov) throws ParserException {
        C8291a aVar = moov;
        int firstVideoTrackIndex = -1;
        long durationUs = -9223372036854775807L;
        List<Mp4Track> tracks = new ArrayList<>();
        Metadata udtaMetadata = null;
        C8264k gaplessInfoHolder = new C8264k();
        C8292b udta = aVar.mo25436e(C8290c.f17607Aa);
        if (udta != null) {
            udtaMetadata = C8293d.m19303a(udta, this.f17853u);
            if (udtaMetadata != null) {
                gaplessInfoHolder.mo25356a(udtaMetadata);
            }
        }
        Metadata mdtaMetadata = null;
        C8291a meta = aVar.mo25435d(C8290c.f17609Ba);
        if (meta != null) {
            mdtaMetadata = C8293d.m19302a(meta);
        }
        boolean z = true;
        if ((this.f17835c & 1) == 0) {
            z = false;
        }
        boolean ignoreEditLists = z;
        ArrayList<TrackSampleTable> trackSampleTables = m19396a(aVar, gaplessInfoHolder, ignoreEditLists);
        int trackCount = trackSampleTables.size();
        int i = 0;
        while (i < trackCount) {
            C8317q trackSampleTable = (C8317q) trackSampleTables.get(i);
            C8314n track = trackSampleTable.f17897a;
            C8292b udta2 = udta;
            C8291a meta2 = meta;
            boolean ignoreEditLists2 = ignoreEditLists;
            C8310a mp4Track = new C8310a(track, trackSampleTable, this.f17848p.mo25351a(i, track.f17863b));
            int maxInputSize = trackSampleTable.f17901e + 30;
            int i2 = maxInputSize;
            mp4Track.f17856c.mo25340a(C8308j.m19383a(track.f17863b, track.f17867f.mo25008a(maxInputSize), udtaMetadata, mdtaMetadata, gaplessInfoHolder));
            Metadata udtaMetadata2 = udtaMetadata;
            C8264k gaplessInfoHolder2 = gaplessInfoHolder;
            long j = track.f17866e;
            if (j == -9223372036854775807L) {
                j = trackSampleTable.f17904h;
            }
            durationUs = Math.max(durationUs, j);
            if (track.f17863b == 2 && firstVideoTrackIndex == -1) {
                firstVideoTrackIndex = tracks.size();
            }
            tracks.add(mp4Track);
            i++;
            C8291a aVar2 = moov;
            gaplessInfoHolder = gaplessInfoHolder2;
            udta = udta2;
            meta = meta2;
            ignoreEditLists = ignoreEditLists2;
            udtaMetadata = udtaMetadata2;
        }
        C8292b bVar = udta;
        C8291a aVar3 = meta;
        boolean z2 = ignoreEditLists;
        C8264k kVar = gaplessInfoHolder;
        this.f17851s = firstVideoTrackIndex;
        this.f17852t = durationUs;
        this.f17849q = (C8310a[]) tracks.toArray(new C8310a[tracks.size()]);
        this.f17850r = m19400a(this.f17849q);
        this.f17848p.mo25353g();
        this.f17848p.mo25352a(this);
    }

    /* renamed from: a */
    private ArrayList<C8317q> m19396a(C8291a moov, C8264k gaplessInfoHolder, boolean ignoreEditLists) throws ParserException {
        ArrayList<TrackSampleTable> trackSampleTables = new ArrayList<>();
        for (int i = 0; i < moov.f17709Za.size(); i++) {
            C8291a atom = (C8291a) moov.f17709Za.get(i);
            if (atom.f17706Wa == C8290c.f17612D) {
                C8314n track = C8293d.m19299a(atom, moov.mo25436e(C8290c.f17610C), -9223372036854775807L, (DrmInitData) null, ignoreEditLists, this.f17853u);
                if (track != null) {
                    C8317q trackSampleTable = C8293d.m19301a(track, atom.mo25435d(C8290c.f17614E).mo25435d(C8290c.f17616F).mo25435d(C8290c.f17618G), gaplessInfoHolder);
                    if (trackSampleTable.f17898b != 0) {
                        trackSampleTables.add(trackSampleTable);
                    }
                }
            }
        }
        return trackSampleTables;
    }

    /* renamed from: c */
    private int m19405c(C8261h input, C8267n positionHolder) throws IOException, InterruptedException {
        long position;
        long skipAmount;
        int sampleSize;
        C8261h hVar = input;
        long inputPosition = input.getPosition();
        if (this.f17845m == -1) {
            this.f17845m = m19404c(inputPosition);
            if (this.f17845m == -1) {
                return -1;
            }
        }
        C8310a track = this.f17849q[this.f17845m];
        C8272q trackOutput = track.f17856c;
        int sampleIndex = track.f17857d;
        C8317q qVar = track.f17855b;
        long position2 = qVar.f17899c[sampleIndex];
        int sampleSize2 = qVar.f17900d[sampleIndex];
        long skipAmount2 = (position2 - inputPosition) + ((long) this.f17846n);
        if (skipAmount2 < 0) {
            position = position2;
        } else if (skipAmount2 >= 262144) {
            long j = inputPosition;
            position = position2;
        } else {
            if (track.f17854a.f17868g == 1) {
                sampleSize2 -= 8;
                skipAmount = skipAmount2 + 8;
            } else {
                skipAmount = skipAmount2;
            }
            hVar.mo25248c((int) skipAmount);
            C8314n nVar = track.f17854a;
            int i = nVar.f17871j;
            if (i != 0) {
                byte[] nalLengthData = this.f17837e.f18861a;
                nalLengthData[0] = 0;
                nalLengthData[1] = 0;
                nalLengthData[2] = 0;
                int nalUnitLengthFieldLength = nVar.f17871j;
                int nalUnitLengthFieldLengthDiff = 4 - i;
                while (this.f17846n < sampleSize2) {
                    int i2 = this.f17847o;
                    if (i2 == 0) {
                        hVar.readFully(this.f17837e.f18861a, nalUnitLengthFieldLengthDiff, nalUnitLengthFieldLength);
                        long inputPosition2 = inputPosition;
                        this.f17837e.mo26118e(0);
                        this.f17847o = this.f17837e.mo26135u();
                        this.f17836d.mo26118e(0);
                        trackOutput.mo25341a(this.f17836d, 4);
                        this.f17846n += 4;
                        sampleSize2 += nalUnitLengthFieldLengthDiff;
                        inputPosition = inputPosition2;
                    } else {
                        long inputPosition3 = inputPosition;
                        int writtenBytes = trackOutput.mo25338a(hVar, i2, false);
                        this.f17846n += writtenBytes;
                        this.f17847o -= writtenBytes;
                        inputPosition = inputPosition3;
                    }
                }
                sampleSize = sampleSize2;
            } else {
                while (true) {
                    int i3 = this.f17846n;
                    if (i3 >= sampleSize2) {
                        break;
                    }
                    int writtenBytes2 = trackOutput.mo25338a(hVar, sampleSize2 - i3, false);
                    this.f17846n += writtenBytes2;
                    this.f17847o -= writtenBytes2;
                }
                sampleSize = sampleSize2;
            }
            C8317q qVar2 = track.f17855b;
            long j2 = skipAmount;
            int i4 = sampleSize;
            long j3 = position2;
            trackOutput.mo25339a(qVar2.f17902f[sampleIndex], qVar2.f17903g[sampleIndex], sampleSize, 0, null);
            track.f17857d++;
            this.f17845m = -1;
            this.f17846n = 0;
            this.f17847o = 0;
            return 0;
        }
        positionHolder.f17510a = position;
        return 1;
    }

    /* renamed from: c */
    private int m19404c(long inputPosition) {
        long preferredSkipAmount = Long.MAX_VALUE;
        boolean preferredRequiresReload = true;
        int preferredTrackIndex = -1;
        long preferredAccumulatedBytes = Long.MAX_VALUE;
        long minAccumulatedBytes = Long.MAX_VALUE;
        boolean minAccumulatedBytesRequiresReload = true;
        int minAccumulatedBytesTrackIndex = -1;
        int trackIndex = 0;
        while (true) {
            C8310a[] aVarArr = this.f17849q;
            if (trackIndex >= aVarArr.length) {
                break;
            }
            C8310a track = aVarArr[trackIndex];
            int sampleIndex = track.f17857d;
            C8317q qVar = track.f17855b;
            if (sampleIndex != qVar.f17898b) {
                long sampleOffset = qVar.f17899c[sampleIndex];
                long sampleAccumulatedBytes = this.f17850r[trackIndex][sampleIndex];
                long skipAmount = sampleOffset - inputPosition;
                boolean requiresReload = skipAmount < 0 || skipAmount >= 262144;
                if ((!requiresReload && preferredRequiresReload) || (requiresReload == preferredRequiresReload && skipAmount < preferredSkipAmount)) {
                    preferredRequiresReload = requiresReload;
                    preferredSkipAmount = skipAmount;
                    preferredTrackIndex = trackIndex;
                    preferredAccumulatedBytes = sampleAccumulatedBytes;
                }
                if (sampleAccumulatedBytes < minAccumulatedBytes) {
                    minAccumulatedBytes = sampleAccumulatedBytes;
                    minAccumulatedBytesRequiresReload = requiresReload;
                    minAccumulatedBytesTrackIndex = trackIndex;
                }
            }
            trackIndex++;
        }
        return (minAccumulatedBytes == Long.MAX_VALUE || !minAccumulatedBytesRequiresReload || preferredAccumulatedBytes < 10485760 + minAccumulatedBytes) ? preferredTrackIndex : minAccumulatedBytesTrackIndex;
    }

    /* renamed from: e */
    private void m19407e(long timeUs) {
        C8310a[] aVarArr;
        for (C8310a track : this.f17849q) {
            C8317q sampleTable = track.f17855b;
            int sampleIndex = sampleTable.mo25457a(timeUs);
            if (sampleIndex == -1) {
                sampleIndex = sampleTable.mo25458b(timeUs);
            }
            track.f17857d = sampleIndex;
        }
    }

    /* renamed from: a */
    private static long[][] m19400a(C8310a[] tracks) {
        long[][] accumulatedSampleSizes = new long[tracks.length][];
        int[] nextSampleIndex = new int[tracks.length];
        long[] nextSampleTimesUs = new long[tracks.length];
        boolean[] tracksFinished = new boolean[tracks.length];
        for (int i = 0; i < tracks.length; i++) {
            accumulatedSampleSizes[i] = new long[tracks[i].f17855b.f17898b];
            nextSampleTimesUs[i] = tracks[i].f17855b.f17902f[0];
        }
        long accumulatedSampleSize = 0;
        int finishedTracks = 0;
        while (finishedTracks < tracks.length) {
            long minTimeUs = Long.MAX_VALUE;
            int minTimeTrackIndex = -1;
            for (int i2 = 0; i2 < tracks.length; i2++) {
                if (!tracksFinished[i2] && nextSampleTimesUs[i2] <= minTimeUs) {
                    minTimeTrackIndex = i2;
                    minTimeUs = nextSampleTimesUs[i2];
                }
            }
            int trackSampleIndex = nextSampleIndex[minTimeTrackIndex];
            accumulatedSampleSizes[minTimeTrackIndex][trackSampleIndex] = accumulatedSampleSize;
            accumulatedSampleSize += (long) tracks[minTimeTrackIndex].f17855b.f17900d[trackSampleIndex];
            int trackSampleIndex2 = trackSampleIndex + 1;
            nextSampleIndex[minTimeTrackIndex] = trackSampleIndex2;
            if (trackSampleIndex2 < accumulatedSampleSizes[minTimeTrackIndex].length) {
                nextSampleTimesUs[minTimeTrackIndex] = tracks[minTimeTrackIndex].f17855b.f17902f[trackSampleIndex2];
            } else {
                tracksFinished[minTimeTrackIndex] = true;
                finishedTracks++;
            }
        }
        return accumulatedSampleSizes;
    }

    /* renamed from: a */
    private static long m19395a(C8317q sampleTable, long seekTimeUs, long offset) {
        int sampleIndex = m19394a(sampleTable, seekTimeUs);
        if (sampleIndex == -1) {
            return offset;
        }
        return Math.min(sampleTable.f17899c[sampleIndex], offset);
    }

    /* renamed from: a */
    private static int m19394a(C8317q sampleTable, long timeUs) {
        int sampleIndex = sampleTable.mo25457a(timeUs);
        if (sampleIndex == -1) {
            return sampleTable.mo25458b(timeUs);
        }
        return sampleIndex;
    }

    /* renamed from: a */
    private static boolean m19399a(C8535t atomData) {
        atomData.mo26118e(8);
        if (atomData.mo26119f() == f17834b) {
            return true;
        }
        atomData.mo26120f(4);
        while (atomData.mo26104a() > 0) {
            if (atomData.mo26119f() == f17834b) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m19401b(int atom) {
        return atom == C8290c.f17640R || atom == C8290c.f17610C || atom == C8290c.f17642S || atom == C8290c.f17644T || atom == C8290c.f17679ma || atom == C8290c.f17681na || atom == C8290c.f17683oa || atom == C8290c.f17638Q || atom == C8290c.f17685pa || atom == C8290c.f17687qa || atom == C8290c.f17689ra || atom == C8290c.f17691sa || atom == C8290c.f17693ta || atom == C8290c.f17634O || atom == C8290c.f17654a || atom == C8290c.f17607Aa || atom == C8290c.f17611Ca || atom == C8290c.f17613Da;
    }

    /* renamed from: a */
    private static boolean m19398a(int atom) {
        return atom == C8290c.f17608B || atom == C8290c.f17612D || atom == C8290c.f17614E || atom == C8290c.f17616F || atom == C8290c.f17618G || atom == C8290c.f17636P || atom == C8290c.f17609Ba;
    }
}
