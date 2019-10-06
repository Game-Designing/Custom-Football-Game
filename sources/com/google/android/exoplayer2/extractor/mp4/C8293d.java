package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.C8122h;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8518h;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8529q;
import com.google.android.exoplayer2.util.C8535t;
import com.google.android.exoplayer2.video.C8554h;
import com.google.android.exoplayer2.video.C8557k;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.extractor.mp4.d */
/* compiled from: AtomParsers */
final class C8293d {

    /* renamed from: a */
    private static final int f17711a = C8509F.m20464b("vide");

    /* renamed from: b */
    private static final int f17712b = C8509F.m20464b("soun");

    /* renamed from: c */
    private static final int f17713c = C8509F.m20464b(CommandHandler.TEXT);

    /* renamed from: d */
    private static final int f17714d = C8509F.m20464b("sbtl");

    /* renamed from: e */
    private static final int f17715e = C8509F.m20464b("subt");

    /* renamed from: f */
    private static final int f17716f = C8509F.m20464b("clcp");

    /* renamed from: g */
    private static final int f17717g = C8509F.m20464b("meta");

    /* renamed from: h */
    private static final int f17718h = C8509F.m20464b("mdta");

    /* renamed from: i */
    private static final byte[] f17719i = C8509F.m20472c("OpusHead");

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.d$a */
    /* compiled from: AtomParsers */
    private static final class C8294a {

        /* renamed from: a */
        public final int f17720a;

        /* renamed from: b */
        public int f17721b;

        /* renamed from: c */
        public int f17722c;

        /* renamed from: d */
        public long f17723d;

        /* renamed from: e */
        private final boolean f17724e;

        /* renamed from: f */
        private final C8535t f17725f;

        /* renamed from: g */
        private final C8535t f17726g;

        /* renamed from: h */
        private int f17727h;

        /* renamed from: i */
        private int f17728i;

        public C8294a(C8535t stsc, C8535t chunkOffsets, boolean chunkOffsetsAreLongs) {
            this.f17726g = stsc;
            this.f17725f = chunkOffsets;
            this.f17724e = chunkOffsetsAreLongs;
            chunkOffsets.mo26118e(12);
            this.f17720a = chunkOffsets.mo26135u();
            stsc.mo26118e(12);
            this.f17728i = stsc.mo26135u();
            boolean z = true;
            if (stsc.mo26119f() != 1) {
                z = false;
            }
            C8514e.m20491b(z, "first_chunk must be 1");
            this.f17721b = -1;
        }

        /* renamed from: a */
        public boolean mo25437a() {
            long j;
            int i = this.f17721b + 1;
            this.f17721b = i;
            if (i == this.f17720a) {
                return false;
            }
            if (this.f17724e) {
                j = this.f17725f.mo26136v();
            } else {
                j = this.f17725f.mo26133s();
            }
            this.f17723d = j;
            if (this.f17721b == this.f17727h) {
                this.f17722c = this.f17726g.mo26135u();
                this.f17726g.mo26120f(4);
                int i2 = this.f17728i - 1;
                this.f17728i = i2;
                this.f17727h = i2 > 0 ? this.f17726g.mo26135u() - 1 : -1;
            }
            return true;
        }
    }

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.d$b */
    /* compiled from: AtomParsers */
    private interface C8295b {
        /* renamed from: a */
        boolean mo25438a();

        /* renamed from: b */
        int mo25439b();

        /* renamed from: c */
        int mo25440c();
    }

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.d$c */
    /* compiled from: AtomParsers */
    private static final class C8296c {

        /* renamed from: a */
        public final C8315o[] f17729a;

        /* renamed from: b */
        public Format f17730b;

        /* renamed from: c */
        public int f17731c;

        /* renamed from: d */
        public int f17732d = 0;

        public C8296c(int numberOfEntries) {
            this.f17729a = new C8315o[numberOfEntries];
        }
    }

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.d$d */
    /* compiled from: AtomParsers */
    static final class C8297d implements C8295b {

        /* renamed from: a */
        private final int f17733a = this.f17735c.mo26135u();

        /* renamed from: b */
        private final int f17734b = this.f17735c.mo26135u();

        /* renamed from: c */
        private final C8535t f17735c;

        public C8297d(C8292b stszAtom) {
            this.f17735c = stszAtom.f17710Xa;
            this.f17735c.mo26118e(12);
        }

        /* renamed from: c */
        public int mo25440c() {
            return this.f17734b;
        }

        /* renamed from: b */
        public int mo25439b() {
            int i = this.f17733a;
            return i == 0 ? this.f17735c.mo26135u() : i;
        }

        /* renamed from: a */
        public boolean mo25438a() {
            return this.f17733a != 0;
        }
    }

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.d$e */
    /* compiled from: AtomParsers */
    static final class C8298e implements C8295b {

        /* renamed from: a */
        private final C8535t f17736a;

        /* renamed from: b */
        private final int f17737b = this.f17736a.mo26135u();

        /* renamed from: c */
        private final int f17738c = (this.f17736a.mo26135u() & 255);

        /* renamed from: d */
        private int f17739d;

        /* renamed from: e */
        private int f17740e;

        public C8298e(C8292b stz2Atom) {
            this.f17736a = stz2Atom.f17710Xa;
            this.f17736a.mo26118e(12);
        }

        /* renamed from: c */
        public int mo25440c() {
            return this.f17737b;
        }

        /* renamed from: b */
        public int mo25439b() {
            int i = this.f17738c;
            if (i == 8) {
                return this.f17736a.mo26131q();
            }
            if (i == 16) {
                return this.f17736a.mo26137w();
            }
            int i2 = this.f17739d;
            this.f17739d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.f17740e & 15;
            }
            this.f17740e = this.f17736a.mo26131q();
            return (this.f17740e & 240) >> 4;
        }

        /* renamed from: a */
        public boolean mo25438a() {
            return false;
        }
    }

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.d$f */
    /* compiled from: AtomParsers */
    private static final class C8299f {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final int f17741a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final long f17742b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final int f17743c;

        public C8299f(int id, long duration, int rotationDegrees) {
            this.f17741a = id;
            this.f17742b = duration;
            this.f17743c = rotationDegrees;
        }
    }

    /* renamed from: a */
    public static C8314n m19299a(C8291a trak, C8292b mvhd, long duration, DrmInitData drmInitData, boolean ignoreEditLists, boolean isQuickTime) throws ParserException {
        long duration2;
        long durationUs;
        long[] editListMediaTimes;
        long[] editListDurations;
        C8314n nVar;
        C8291a aVar = trak;
        C8291a mdia = aVar.mo25435d(C8290c.f17614E);
        int trackType = m19294a(m19308b(mdia.mo25436e(C8290c.f17642S).f17710Xa));
        if (trackType == -1) {
            return null;
        }
        C8299f tkhdData = m19318e(aVar.mo25436e(C8290c.f17634O).f17710Xa);
        if (duration == -9223372036854775807L) {
            duration2 = tkhdData.f17742b;
        } else {
            duration2 = duration;
        }
        long movieTimescale = m19315d(mvhd.f17710Xa);
        if (duration2 == -9223372036854775807L) {
            durationUs = -9223372036854775807L;
        } else {
            durationUs = C8509F.m20471c(duration2, 1000000, movieTimescale);
        }
        C8291a stbl = mdia.mo25435d(C8290c.f17616F).mo25435d(C8290c.f17618G);
        Pair<Long, String> mdhdData = m19313c(mdia.mo25436e(C8290c.f17640R).f17710Xa);
        C8296c stsdData = m19298a(stbl.mo25436e(C8290c.f17644T).f17710Xa, tkhdData.f17741a, tkhdData.f17743c, (String) mdhdData.second, drmInitData, isQuickTime);
        if (!ignoreEditLists) {
            Pair<long[], long[]> edtsData = m19310b(aVar.mo25435d(C8290c.f17636P));
            editListDurations = (long[]) edtsData.first;
            editListMediaTimes = (long[]) edtsData.second;
        } else {
            editListDurations = null;
            editListMediaTimes = null;
        }
        if (stsdData.f17730b == null) {
            nVar = null;
            C8296c cVar = stsdData;
            Pair pair = mdhdData;
            C8291a aVar2 = stbl;
        } else {
            int b = tkhdData.f17741a;
            long longValue = ((Long) mdhdData.first).longValue();
            Format format = stsdData.f17730b;
            int i = stsdData.f17732d;
            C8296c cVar2 = stsdData;
            Format format2 = format;
            Pair pair2 = mdhdData;
            int i2 = i;
            C8291a aVar3 = stbl;
            nVar = new C8314n(b, trackType, longValue, movieTimescale, durationUs, format2, i2, stsdData.f17729a, stsdData.f17731c, editListDurations, editListMediaTimes);
        }
        return nVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x05fc  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0286  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.extractor.mp4.C8317q m19301a(com.google.android.exoplayer2.extractor.mp4.C8314n r71, com.google.android.exoplayer2.extractor.mp4.C8290c.C8291a r72, com.google.android.exoplayer2.p183b.C8264k r73) throws com.google.android.exoplayer2.ParserException {
        /*
            r9 = r71
            r10 = r72
            r11 = r73
            int r0 = com.google.android.exoplayer2.extractor.mp4.C8290c.f17687qa
            com.google.android.exoplayer2.extractor.mp4.c$b r12 = r10.mo25436e(r0)
            if (r12 == 0) goto L_0x0015
            com.google.android.exoplayer2.extractor.mp4.d$d r0 = new com.google.android.exoplayer2.extractor.mp4.d$d
            r0.<init>(r12)
            r13 = r0
            goto L_0x0024
        L_0x0015:
            int r0 = com.google.android.exoplayer2.extractor.mp4.C8290c.f17689ra
            com.google.android.exoplayer2.extractor.mp4.c$b r0 = r10.mo25436e(r0)
            if (r0 == 0) goto L_0x062f
            com.google.android.exoplayer2.extractor.mp4.d$e r1 = new com.google.android.exoplayer2.extractor.mp4.d$e
            r1.<init>(r0)
            r0 = r1
            r13 = r0
        L_0x0024:
            int r14 = r13.mo25440c()
            r0 = 0
            if (r14 != 0) goto L_0x0042
            com.google.android.exoplayer2.extractor.mp4.q r15 = new com.google.android.exoplayer2.extractor.mp4.q
            long[] r2 = new long[r0]
            int[] r3 = new int[r0]
            r4 = 0
            long[] r5 = new long[r0]
            int[] r6 = new int[r0]
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0 = r15
            r1 = r71
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r15
        L_0x0042:
            r1 = 0
            int r2 = com.google.android.exoplayer2.extractor.mp4.C8290c.f17691sa
            com.google.android.exoplayer2.extractor.mp4.c$b r2 = r10.mo25436e(r2)
            if (r2 != 0) goto L_0x0055
            r1 = 1
            int r3 = com.google.android.exoplayer2.extractor.mp4.C8290c.f17693ta
            com.google.android.exoplayer2.extractor.mp4.c$b r2 = r10.mo25436e(r3)
            r7 = r1
            r15 = r2
            goto L_0x0057
        L_0x0055:
            r7 = r1
            r15 = r2
        L_0x0057:
            com.google.android.exoplayer2.util.t r8 = r15.f17710Xa
            int r1 = com.google.android.exoplayer2.extractor.mp4.C8290c.f17685pa
            com.google.android.exoplayer2.extractor.mp4.c$b r1 = r10.mo25436e(r1)
            com.google.android.exoplayer2.util.t r6 = r1.f17710Xa
            int r1 = com.google.android.exoplayer2.extractor.mp4.C8290c.f17679ma
            com.google.android.exoplayer2.extractor.mp4.c$b r1 = r10.mo25436e(r1)
            com.google.android.exoplayer2.util.t r5 = r1.f17710Xa
            int r1 = com.google.android.exoplayer2.extractor.mp4.C8290c.f17681na
            com.google.android.exoplayer2.extractor.mp4.c$b r4 = r10.mo25436e(r1)
            r1 = 0
            if (r4 == 0) goto L_0x0075
            com.google.android.exoplayer2.util.t r2 = r4.f17710Xa
            goto L_0x0076
        L_0x0075:
            r2 = r1
        L_0x0076:
            int r3 = com.google.android.exoplayer2.extractor.mp4.C8290c.f17683oa
            com.google.android.exoplayer2.extractor.mp4.c$b r3 = r10.mo25436e(r3)
            if (r3 == 0) goto L_0x0080
            com.google.android.exoplayer2.util.t r1 = r3.f17710Xa
        L_0x0080:
            com.google.android.exoplayer2.extractor.mp4.d$a r0 = new com.google.android.exoplayer2.extractor.mp4.d$a
            r0.<init>(r6, r8, r7)
            r17 = r3
            r3 = 12
            r5.mo26118e(r3)
            int r18 = r5.mo26135u()
            r3 = 1
            int r18 = r18 + -1
            int r20 = r5.mo26135u()
            int r3 = r5.mo26135u()
            r22 = 0
            r23 = 0
            r24 = 0
            if (r1 == 0) goto L_0x00af
            r25 = r4
            r4 = 12
            r1.mo26118e(r4)
            int r23 = r1.mo26135u()
            goto L_0x00b1
        L_0x00af:
            r25 = r4
        L_0x00b1:
            r4 = -1
            r26 = 0
            if (r2 == 0) goto L_0x00d4
            r27 = r4
            r4 = 12
            r2.mo26118e(r4)
            int r26 = r2.mo26135u()
            if (r26 <= 0) goto L_0x00d0
            int r4 = r2.mo26135u()
            r19 = 1
            int r4 = r4 + -1
            r19 = r2
            r27 = r4
            goto L_0x00d8
        L_0x00d0:
            r2 = 0
            r19 = r2
            goto L_0x00d8
        L_0x00d4:
            r27 = r4
            r19 = r2
        L_0x00d8:
            boolean r2 = r13.mo25438a()
            if (r2 == 0) goto L_0x00f3
            com.google.android.exoplayer2.Format r2 = r9.f17867f
            java.lang.String r2 = r2.f16507g
            java.lang.String r4 = "audio/raw"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x00f3
            if (r18 != 0) goto L_0x00f3
            if (r23 != 0) goto L_0x00f3
            if (r26 != 0) goto L_0x00f3
            r2 = 1
            goto L_0x00f4
        L_0x00f3:
            r2 = 0
        L_0x00f4:
            r28 = r2
            r2 = 0
            r29 = 0
            if (r28 != 0) goto L_0x0286
            long[] r4 = new long[r14]
            r31 = r2
            int[] r2 = new int[r14]
            r32 = r6
            long[] r6 = new long[r14]
            r33 = r7
            int[] r7 = new int[r14]
            r34 = 0
            r36 = 0
            r37 = 0
            r10 = r26
            r9 = r27
            r11 = r31
            r26 = r34
            r34 = r8
            r35 = r12
            r12 = r20
            r20 = r24
            r8 = r3
            r3 = r37
            r37 = r15
            r15 = r18
            r18 = r22
        L_0x0128:
            r38 = r5
            java.lang.String r5 = "AtomParsers"
            if (r3 >= r14) goto L_0x01d9
            r22 = 1
        L_0x0130:
            if (r36 != 0) goto L_0x014b
            boolean r24 = r0.mo25437a()
            r22 = r24
            if (r24 == 0) goto L_0x014b
            r39 = r14
            r24 = r15
            long r14 = r0.f17723d
            r26 = r14
            int r14 = r0.f17722c
            r36 = r14
            r15 = r24
            r14 = r39
            goto L_0x0130
        L_0x014b:
            r39 = r14
            r24 = r15
            if (r22 != 0) goto L_0x016c
            java.lang.String r14 = "Unexpected end of chunk data"
            com.google.android.exoplayer2.util.C8526n.m20534d(r5, r14)
            r14 = r3
            long[] r4 = java.util.Arrays.copyOf(r4, r14)
            int[] r2 = java.util.Arrays.copyOf(r2, r14)
            long[] r6 = java.util.Arrays.copyOf(r6, r14)
            int[] r7 = java.util.Arrays.copyOf(r7, r14)
            r3 = r2
            r2 = r36
            goto L_0x01e2
        L_0x016c:
            if (r1 == 0) goto L_0x0182
        L_0x016e:
            if (r18 != 0) goto L_0x017d
            if (r23 <= 0) goto L_0x017d
            int r18 = r1.mo26135u()
            int r20 = r1.mo26119f()
            int r23 = r23 + -1
            goto L_0x016e
        L_0x017d:
            int r18 = r18 + -1
            r5 = r20
            goto L_0x0184
        L_0x0182:
            r5 = r20
        L_0x0184:
            r4[r3] = r26
            int r14 = r13.mo25439b()
            r2[r3] = r14
            r14 = r2[r3]
            if (r14 <= r11) goto L_0x0192
            r11 = r2[r3]
        L_0x0192:
            long r14 = (long) r5
            long r14 = r29 + r14
            r6[r3] = r14
            if (r19 != 0) goto L_0x019b
            r14 = 1
            goto L_0x019c
        L_0x019b:
            r14 = 0
        L_0x019c:
            r7[r3] = r14
            if (r3 != r9) goto L_0x01ad
            r14 = 1
            r7[r3] = r14
            int r10 = r10 + -1
            if (r10 <= 0) goto L_0x01ad
            int r15 = r19.mo26135u()
            int r9 = r15 + -1
        L_0x01ad:
            long r14 = (long) r8
            long r29 = r29 + r14
            int r12 = r12 + -1
            if (r12 != 0) goto L_0x01c1
            if (r24 <= 0) goto L_0x01c1
            int r12 = r38.mo26135u()
            int r8 = r38.mo26119f()
            int r15 = r24 + -1
            goto L_0x01c3
        L_0x01c1:
            r15 = r24
        L_0x01c3:
            r14 = r2[r3]
            r40 = r4
            r20 = r5
            long r4 = (long) r14
            long r26 = r26 + r4
            int r36 = r36 + -1
            int r3 = r3 + 1
            r5 = r38
            r14 = r39
            r4 = r40
            goto L_0x0128
        L_0x01d9:
            r40 = r4
            r39 = r14
            r24 = r15
            r3 = r2
            r2 = r36
        L_0x01e2:
            r22 = r3
            r15 = r20
            r20 = r4
            long r3 = (long) r15
            long r3 = r29 + r3
            r31 = 1
        L_0x01ed:
            if (r23 <= 0) goto L_0x01fe
            int r36 = r1.mo26135u()
            if (r36 == 0) goto L_0x01f8
            r31 = 0
            goto L_0x01fe
        L_0x01f8:
            r1.mo26119f()
            int r23 = r23 + -1
            goto L_0x01ed
        L_0x01fe:
            if (r10 != 0) goto L_0x0218
            if (r12 != 0) goto L_0x0218
            if (r2 != 0) goto L_0x0218
            if (r24 != 0) goto L_0x0218
            if (r18 != 0) goto L_0x0218
            if (r31 != 0) goto L_0x020b
            goto L_0x0218
        L_0x020b:
            r36 = r1
            r39 = r3
            r3 = r18
            r4 = r71
            r18 = r6
            r6 = r24
            goto L_0x026e
        L_0x0218:
            r36 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r39 = r3
            java.lang.String r3 = "Inconsistent stbl box for track "
            r1.append(r3)
            r4 = r71
            r3 = r18
            r18 = r6
            int r6 = r4.f17862a
            r1.append(r6)
            java.lang.String r6 = ": remainingSynchronizationSamples "
            r1.append(r6)
            r1.append(r10)
            java.lang.String r6 = ", remainingSamplesAtTimestampDelta "
            r1.append(r6)
            r1.append(r12)
            java.lang.String r6 = ", remainingSamplesInChunk "
            r1.append(r6)
            r1.append(r2)
            java.lang.String r6 = ", remainingTimestampDeltaChanges "
            r1.append(r6)
            r6 = r24
            r1.append(r6)
            r24 = r2
            java.lang.String r2 = ", remainingSamplesAtTimestampOffset "
            r1.append(r2)
            r1.append(r3)
            if (r31 != 0) goto L_0x0262
            java.lang.String r2 = ", ctts invalid"
            goto L_0x0264
        L_0x0262:
            java.lang.String r2 = ""
        L_0x0264:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.google.android.exoplayer2.util.C8526n.m20534d(r5, r1)
        L_0x026e:
            r5 = r7
            r27 = r9
            r26 = r10
            r7 = r20
            r9 = r39
            r20 = r12
            r12 = r11
            r11 = r8
            r8 = r22
            r22 = r3
            r70 = r18
            r18 = r6
            r6 = r70
            goto L_0x02d4
        L_0x0286:
            r36 = r1
            r31 = r2
            r38 = r5
            r32 = r6
            r33 = r7
            r34 = r8
            r4 = r9
            r35 = r12
            r39 = r14
            r37 = r15
            int r1 = r0.f17720a
            long[] r2 = new long[r1]
            int[] r1 = new int[r1]
        L_0x029f:
            boolean r5 = r0.mo25437a()
            if (r5 == 0) goto L_0x02b0
            int r5 = r0.f17721b
            long r6 = r0.f17723d
            r2[r5] = r6
            int r6 = r0.f17722c
            r1[r5] = r6
            goto L_0x029f
        L_0x02b0:
            com.google.android.exoplayer2.Format r5 = r4.f17867f
            int r6 = r5.f16522v
            int r5 = r5.f16520t
            int r5 = com.google.android.exoplayer2.util.C8509F.m20462b(r6, r5)
            long r6 = (long) r3
            com.google.android.exoplayer2.extractor.mp4.g$a r6 = com.google.android.exoplayer2.extractor.mp4.C8302g.m19332a(r5, r2, r1, r6)
            long[] r7 = r6.f17748a
            int[] r8 = r6.f17749b
            int r9 = r6.f17750c
            long[] r10 = r6.f17751d
            int[] r11 = r6.f17752e
            long r1 = r6.f17753f
            r12 = r9
            r6 = r10
            r5 = r11
            r15 = r24
            r14 = r39
            r9 = r1
            r11 = r3
        L_0x02d4:
            r42 = 1000000(0xf4240, double:4.940656E-318)
            long r1 = r4.f17864c
            r40 = r9
            r44 = r1
            long r47 = com.google.android.exoplayer2.util.C8509F.m20471c(r40, r42, r44)
            long[] r1 = r4.f17869h
            if (r1 == 0) goto L_0x05fc
            boolean r1 = r73.mo25354a()
            if (r1 == 0) goto L_0x0304
            r41 = r0
            r69 = r5
            r68 = r6
            r57 = r9
            r42 = r11
            r24 = r13
            r31 = r14
            r39 = r15
            r40 = r34
            r11 = r4
            r10 = r7
            r34 = r12
            r12 = r8
            goto L_0x0613
        L_0x0304:
            long[] r1 = r4.f17869h
            int r2 = r1.length
            r51 = 0
            r3 = 1
            if (r2 != r3) goto L_0x03f3
            int r2 = r4.f17863b
            if (r2 != r3) goto L_0x03f3
            int r2 = r6.length
            r3 = 2
            if (r2 < r3) goto L_0x03f3
            long[] r2 = r4.f17870i
            r3 = 0
            r53 = r2[r3]
            r39 = r1[r3]
            long r1 = r4.f17864c
            r24 = r13
            r31 = r14
            long r13 = r4.f17865d
            r41 = r1
            r43 = r13
            long r1 = com.google.android.exoplayer2.util.C8509F.m20471c(r39, r41, r43)
            long r13 = r53 + r1
            r40 = r6
            r41 = r9
            r43 = r53
            r45 = r13
            boolean r1 = m19307a(r40, r41, r43, r45)
            if (r1 == 0) goto L_0x03e0
            long r45 = r9 - r13
            r1 = 0
            r2 = r6[r1]
            long r39 = r53 - r2
            com.google.android.exoplayer2.Format r1 = r4.f17867f
            int r1 = r1.f16521u
            long r1 = (long) r1
            r55 = r13
            long r13 = r4.f17864c
            r41 = r1
            r43 = r13
            long r13 = com.google.android.exoplayer2.util.C8509F.m20471c(r39, r41, r43)
            com.google.android.exoplayer2.Format r1 = r4.f17867f
            int r1 = r1.f16521u
            long r1 = (long) r1
            r57 = r9
            long r9 = r4.f17864c
            r39 = r45
            r41 = r1
            r43 = r9
            long r9 = com.google.android.exoplayer2.util.C8509F.m20471c(r39, r41, r43)
            int r1 = (r13 > r51 ? 1 : (r13 == r51 ? 0 : -1))
            if (r1 != 0) goto L_0x037f
            int r1 = (r9 > r51 ? 1 : (r9 == r51 ? 0 : -1))
            if (r1 == 0) goto L_0x036f
            goto L_0x037f
        L_0x036f:
            r41 = r0
            r43 = r5
            r13 = r6
            r44 = r8
            r42 = r11
            r14 = r34
            r11 = r4
            r34 = r7
            goto L_0x0407
        L_0x037f:
            r1 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r3 > 0) goto L_0x03cd
            int r3 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r3 > 0) goto L_0x03cd
            int r1 = (int) r13
            r3 = r73
            r3.f17493b = r1
            int r1 = (int) r9
            r3.f17494c = r1
            long r1 = r4.f17864c
            r39 = r9
            r9 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.exoplayer2.util.C8509F.m20453a(r6, r9, r1)
            long[] r1 = r4.f17869h
            r2 = 0
            r59 = r1[r2]
            r61 = 1000000(0xf4240, double:4.940656E-318)
            long r1 = r4.f17865d
            r63 = r1
            long r9 = com.google.android.exoplayer2.util.C8509F.m20471c(r59, r61, r63)
            com.google.android.exoplayer2.extractor.mp4.q r16 = new com.google.android.exoplayer2.extractor.mp4.q
            r41 = r0
            r0 = r16
            r1 = r71
            r2 = r7
            r3 = r8
            r42 = r11
            r11 = r4
            r4 = r12
            r43 = r5
            r5 = r6
            r49 = r13
            r13 = r6
            r6 = r43
            r44 = r8
            r14 = r34
            r34 = r7
            r7 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r16
        L_0x03cd:
            r41 = r0
            r43 = r5
            r44 = r8
            r39 = r9
            r42 = r11
            r49 = r13
            r14 = r34
            r11 = r4
            r13 = r6
            r34 = r7
            goto L_0x0407
        L_0x03e0:
            r41 = r0
            r43 = r5
            r44 = r8
            r57 = r9
            r42 = r11
            r55 = r13
            r14 = r34
            r11 = r4
            r13 = r6
            r34 = r7
            goto L_0x0407
        L_0x03f3:
            r41 = r0
            r43 = r5
            r44 = r8
            r57 = r9
            r42 = r11
            r24 = r13
            r31 = r14
            r14 = r34
            r11 = r4
            r13 = r6
            r34 = r7
        L_0x0407:
            long[] r0 = r11.f17869h
            int r1 = r0.length
            r2 = 1
            if (r1 != r2) goto L_0x044d
            r1 = 0
            r2 = r0[r1]
            int r0 = (r2 > r51 ? 1 : (r2 == r51 ? 0 : -1))
            if (r0 != 0) goto L_0x044d
            long[] r0 = r11.f17870i
            r9 = r0[r1]
            r0 = 0
        L_0x0419:
            int r1 = r13.length
            if (r0 >= r1) goto L_0x042e
            r1 = r13[r0]
            long r3 = r1 - r9
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = r11.f17864c
            long r1 = com.google.android.exoplayer2.util.C8509F.m20471c(r3, r5, r7)
            r13[r0] = r1
            int r0 = r0 + 1
            goto L_0x0419
        L_0x042e:
            long r1 = r57 - r9
            r3 = 1000000(0xf4240, double:4.940656E-318)
            long r5 = r11.f17864c
            long r39 = com.google.android.exoplayer2.util.C8509F.m20471c(r1, r3, r5)
            com.google.android.exoplayer2.extractor.mp4.q r16 = new com.google.android.exoplayer2.extractor.mp4.q
            r0 = r16
            r1 = r71
            r2 = r34
            r3 = r44
            r4 = r12
            r5 = r13
            r6 = r43
            r7 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r16
        L_0x044d:
            int r0 = r11.f17863b
            r1 = 1
            if (r0 != r1) goto L_0x0454
            r0 = 1
            goto L_0x0455
        L_0x0454:
            r0 = 0
        L_0x0455:
            r9 = r0
            r0 = 0
            r1 = 0
            r2 = 0
            long[] r3 = r11.f17869h
            int r4 = r3.length
            int[] r10 = new int[r4]
            int r3 = r3.length
            int[] r7 = new int[r3]
            r3 = 0
            r8 = r0
            r6 = r1
        L_0x0464:
            long[] r0 = r11.f17869h
            int r1 = r0.length
            if (r3 >= r1) goto L_0x04d7
            long[] r1 = r11.f17870i
            r4 = r1[r3]
            r39 = -1
            int r1 = (r4 > r39 ? 1 : (r4 == r39 ? 0 : -1))
            if (r1 == 0) goto L_0x04c6
            r49 = r0[r3]
            long r0 = r11.f17864c
            r40 = r14
            r39 = r15
            long r14 = r11.f17865d
            r51 = r0
            r53 = r14
            long r0 = com.google.android.exoplayer2.util.C8509F.m20471c(r49, r51, r53)
            r14 = 1
            int r15 = com.google.android.exoplayer2.util.C8509F.m20437a(r13, r4, r14, r14)
            r10[r3] = r15
            long r14 = r4 + r0
            r45 = r0
            r0 = 0
            int r1 = com.google.android.exoplayer2.util.C8509F.m20437a(r13, r14, r9, r0)
            r7[r3] = r1
        L_0x0497:
            r1 = r10[r3]
            r14 = r7[r3]
            if (r1 >= r14) goto L_0x04af
            r1 = r10[r3]
            r14 = r43
            r1 = r14[r1]
            r15 = 1
            r1 = r1 & r15
            if (r1 != 0) goto L_0x04b2
            r1 = r10[r3]
            int r1 = r1 + r15
            r10[r3] = r1
            r43 = r14
            goto L_0x0497
        L_0x04af:
            r14 = r43
            r15 = 1
        L_0x04b2:
            r1 = r7[r3]
            r16 = r10[r3]
            int r1 = r1 - r16
            int r8 = r8 + r1
            r1 = r10[r3]
            if (r6 == r1) goto L_0x04bf
            r1 = 1
            goto L_0x04c0
        L_0x04bf:
            r1 = 0
        L_0x04c0:
            r1 = r1 | r2
            r2 = r7[r3]
            r6 = r2
            r2 = r1
            goto L_0x04ce
        L_0x04c6:
            r40 = r14
            r39 = r15
            r14 = r43
            r0 = 0
            r15 = 1
        L_0x04ce:
            int r3 = r3 + 1
            r43 = r14
            r15 = r39
            r14 = r40
            goto L_0x0464
        L_0x04d7:
            r40 = r14
            r39 = r15
            r14 = r43
            r0 = 0
            r15 = 1
            r5 = r31
            if (r8 == r5) goto L_0x04e4
            goto L_0x04e5
        L_0x04e4:
            r15 = 0
        L_0x04e5:
            r15 = r15 | r2
            if (r15 == 0) goto L_0x04eb
            long[] r1 = new long[r8]
            goto L_0x04ed
        L_0x04eb:
            r1 = r34
        L_0x04ed:
            r4 = r1
            if (r15 == 0) goto L_0x04f3
            int[] r1 = new int[r8]
            goto L_0x04f5
        L_0x04f3:
            r1 = r44
        L_0x04f5:
            r3 = r1
            if (r15 == 0) goto L_0x04f9
            goto L_0x04fa
        L_0x04f9:
            r0 = r12
        L_0x04fa:
            if (r15 == 0) goto L_0x04ff
            int[] r1 = new int[r8]
            goto L_0x0500
        L_0x04ff:
            r1 = r14
        L_0x0500:
            r2 = r1
            long[] r1 = new long[r8]
            r45 = 0
            r16 = 0
            r21 = 0
            r70 = r16
            r16 = r0
            r0 = r21
            r21 = r9
            r9 = r70
        L_0x0513:
            r31 = r5
            long[] r5 = r11.f17869h
            int r5 = r5.length
            if (r0 >= r5) goto L_0x05bf
            long[] r5 = r11.f17870i
            r55 = r5[r0]
            r5 = r10[r0]
            r43 = r6
            r6 = r7[r0]
            if (r15 == 0) goto L_0x053c
            r59 = r7
            int r7 = r6 - r5
            r60 = r10
            r10 = r34
            java.lang.System.arraycopy(r10, r5, r4, r9, r7)
            r34 = r12
            r12 = r44
            java.lang.System.arraycopy(r12, r5, r3, r9, r7)
            java.lang.System.arraycopy(r14, r5, r2, r9, r7)
            goto L_0x0546
        L_0x053c:
            r59 = r7
            r60 = r10
            r10 = r34
            r34 = r12
            r12 = r44
        L_0x0546:
            r7 = r5
            r70 = r16
            r16 = r9
            r9 = r70
        L_0x054d:
            if (r7 >= r6) goto L_0x0595
            r51 = 1000000(0xf4240, double:4.940656E-318)
            r44 = r5
            r61 = r6
            long r5 = r11.f17865d
            r49 = r45
            r53 = r5
            long r5 = com.google.android.exoplayer2.util.C8509F.m20471c(r49, r51, r53)
            r49 = r13[r7]
            long r62 = r49 - r55
            r64 = 1000000(0xf4240, double:4.940656E-318)
            r68 = r13
            r69 = r14
            long r13 = r11.f17864c
            r66 = r13
            long r13 = com.google.android.exoplayer2.util.C8509F.m20471c(r62, r64, r66)
            long r49 = r5 + r13
            r1[r16] = r49
            if (r15 == 0) goto L_0x0583
            r62 = r1
            r1 = r3[r16]
            if (r1 <= r9) goto L_0x0585
            r1 = r12[r7]
            r9 = r1
            goto L_0x0585
        L_0x0583:
            r62 = r1
        L_0x0585:
            int r16 = r16 + 1
            int r7 = r7 + 1
            r5 = r44
            r6 = r61
            r1 = r62
            r13 = r68
            r14 = r69
            goto L_0x054d
        L_0x0595:
            r62 = r1
            r44 = r5
            r61 = r6
            r68 = r13
            r69 = r14
            long[] r1 = r11.f17869h
            r5 = r1[r0]
            long r45 = r45 + r5
            int r0 = r0 + 1
            r44 = r12
            r5 = r31
            r12 = r34
            r6 = r43
            r7 = r59
            r1 = r62
            r34 = r10
            r10 = r60
            r70 = r16
            r16 = r9
            r9 = r70
            goto L_0x0513
        L_0x05bf:
            r62 = r1
            r43 = r6
            r59 = r7
            r60 = r10
            r68 = r13
            r69 = r14
            r10 = r34
            r34 = r12
            r12 = r44
            r51 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r11.f17865d
            r49 = r45
            r53 = r0
            long r13 = com.google.android.exoplayer2.util.C8509F.m20471c(r49, r51, r53)
            com.google.android.exoplayer2.extractor.mp4.q r44 = new com.google.android.exoplayer2.extractor.mp4.q
            r0 = r44
            r49 = r62
            r1 = r71
            r50 = r2
            r2 = r4
            r51 = r3
            r52 = r4
            r4 = r16
            r5 = r49
            r6 = r50
            r54 = r8
            r53 = r59
            r7 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r44
        L_0x05fc:
            r41 = r0
            r69 = r5
            r68 = r6
            r57 = r9
            r42 = r11
            r24 = r13
            r31 = r14
            r39 = r15
            r40 = r34
            r11 = r4
            r10 = r7
            r34 = r12
            r12 = r8
        L_0x0613:
            long r0 = r11.f17864c
            r9 = r68
            r2 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.exoplayer2.util.C8509F.m20453a(r9, r2, r0)
            com.google.android.exoplayer2.extractor.mp4.q r13 = new com.google.android.exoplayer2.extractor.mp4.q
            r0 = r13
            r1 = r71
            r2 = r10
            r3 = r12
            r4 = r34
            r5 = r9
            r6 = r69
            r7 = r47
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r13
        L_0x062f:
            r11 = r9
            r35 = r12
            com.google.android.exoplayer2.ParserException r1 = new com.google.android.exoplayer2.ParserException
            java.lang.String r2 = "Track has no sample table size information"
            r1.<init>(r2)
            goto L_0x063b
        L_0x063a:
            throw r1
        L_0x063b:
            goto L_0x063a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.C8293d.m19301a(com.google.android.exoplayer2.extractor.mp4.n, com.google.android.exoplayer2.extractor.mp4.c$a, com.google.android.exoplayer2.b.k):com.google.android.exoplayer2.extractor.mp4.q");
    }

    /* renamed from: a */
    public static Metadata m19303a(C8292b udtaAtom, boolean isQuickTime) {
        if (isQuickTime) {
            return null;
        }
        C8535t udtaData = udtaAtom.f17710Xa;
        udtaData.mo26118e(8);
        while (udtaData.mo26104a() >= 8) {
            int atomPosition = udtaData.mo26113c();
            int atomSize = udtaData.mo26119f();
            if (udtaData.mo26119f() == C8290c.f17609Ba) {
                udtaData.mo26118e(atomPosition);
                return m19317d(udtaData, atomPosition + atomSize);
            }
            udtaData.mo26118e(atomPosition + atomSize);
        }
        return null;
    }

    /* renamed from: a */
    public static Metadata m19302a(C8291a meta) {
        C8292b hdlrAtom = meta.mo25436e(C8290c.f17642S);
        C8292b keysAtom = meta.mo25436e(C8290c.f17611Ca);
        C8292b ilstAtom = meta.mo25436e(C8290c.f17613Da);
        Metadata metadata = null;
        if (hdlrAtom == null || keysAtom == null || ilstAtom == null || m19308b(hdlrAtom.f17710Xa) != f17718h) {
            return null;
        }
        C8535t keys = keysAtom.f17710Xa;
        keys.mo26118e(12);
        int entryCount = keys.mo26119f();
        String[] keyNames = new String[entryCount];
        for (int i = 0; i < entryCount; i++) {
            int entrySize = keys.mo26119f();
            keys.mo26120f(4);
            keyNames[i] = keys.mo26112b(entrySize - 8);
        }
        C8535t ilst = ilstAtom.f17710Xa;
        ilst.mo26118e(8);
        ArrayList<Entry> entries = new ArrayList<>();
        while (ilst.mo26104a() > 8) {
            int atomPosition = ilst.mo26113c();
            int atomSize = ilst.mo26119f();
            int keyIndex = ilst.mo26119f() - 1;
            if (keyIndex < 0 || keyIndex >= keyNames.length) {
                StringBuilder sb = new StringBuilder();
                sb.append("Skipped metadata with unknown key index: ");
                sb.append(keyIndex);
                C8526n.m20534d("AtomParsers", sb.toString());
            } else {
                Entry entry = C8308j.m19384a(ilst, atomPosition + atomSize, keyNames[keyIndex]);
                if (entry != null) {
                    entries.add(entry);
                }
            }
            ilst.mo26118e(atomPosition + atomSize);
        }
        if (!entries.isEmpty()) {
            metadata = new Metadata((List<? extends Entry>) entries);
        }
        return metadata;
    }

    /* renamed from: d */
    private static Metadata m19317d(C8535t meta, int limit) {
        meta.mo26120f(12);
        while (meta.mo26113c() < limit) {
            int atomPosition = meta.mo26113c();
            int atomSize = meta.mo26119f();
            if (meta.mo26119f() == C8290c.f17613Da) {
                meta.mo26118e(atomPosition);
                return m19311b(meta, atomPosition + atomSize);
            }
            meta.mo26118e(atomPosition + atomSize);
        }
        return null;
    }

    /* renamed from: b */
    private static Metadata m19311b(C8535t ilst, int limit) {
        ilst.mo26120f(8);
        ArrayList<Entry> entries = new ArrayList<>();
        while (ilst.mo26113c() < limit) {
            Entry entry = C8308j.m19385a(ilst);
            if (entry != null) {
                entries.add(entry);
            }
        }
        if (entries.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Entry>) entries);
    }

    /* renamed from: d */
    private static long m19315d(C8535t mvhd) {
        int i = 8;
        mvhd.mo26118e(8);
        if (C8290c.m19289c(mvhd.mo26119f()) != 0) {
            i = 16;
        }
        mvhd.mo26120f(i);
        return mvhd.mo26133s();
    }

    /* renamed from: e */
    private static C8299f m19318e(C8535t tkhd) {
        long duration;
        int rotationDegrees;
        int durationByteCount = 8;
        tkhd.mo26118e(8);
        int version = C8290c.m19289c(tkhd.mo26119f());
        tkhd.mo26120f(version == 0 ? 8 : 16);
        int trackId = tkhd.mo26119f();
        tkhd.mo26120f(4);
        boolean durationUnknown = true;
        int durationPosition = tkhd.mo26113c();
        if (version == 0) {
            durationByteCount = 4;
        }
        int i = 0;
        while (true) {
            if (i >= durationByteCount) {
                break;
            } else if (tkhd.f18861a[durationPosition + i] != -1) {
                durationUnknown = false;
                break;
            } else {
                i++;
            }
        }
        if (durationUnknown) {
            tkhd.mo26120f(durationByteCount);
            duration = -9223372036854775807L;
        } else {
            duration = version == 0 ? tkhd.mo26133s() : tkhd.mo26136v();
            if (duration == 0) {
                duration = -9223372036854775807L;
            }
        }
        tkhd.mo26120f(16);
        int a00 = tkhd.mo26119f();
        int a01 = tkhd.mo26119f();
        tkhd.mo26120f(4);
        int a10 = tkhd.mo26119f();
        int a11 = tkhd.mo26119f();
        if (a00 == 0 && a01 == 65536 && a10 == (-65536) && a11 == 0) {
            rotationDegrees = 90;
        } else if (a00 == 0 && a01 == (-65536) && a10 == 65536 && a11 == 0) {
            rotationDegrees = 270;
        } else if (a00 == (-65536) && a01 == 0 && a10 == 0 && a11 == (-65536)) {
            rotationDegrees = Opcodes.GETFIELD;
        } else {
            rotationDegrees = 0;
        }
        return new C8299f(trackId, duration, rotationDegrees);
    }

    /* renamed from: b */
    private static int m19308b(C8535t hdlr) {
        hdlr.mo26118e(16);
        return hdlr.mo26119f();
    }

    /* renamed from: a */
    private static int m19294a(int hdlr) {
        if (hdlr == f17712b) {
            return 1;
        }
        if (hdlr == f17711a) {
            return 2;
        }
        if (hdlr == f17713c || hdlr == f17714d || hdlr == f17715e || hdlr == f17716f) {
            return 3;
        }
        if (hdlr == f17717g) {
            return 4;
        }
        return -1;
    }

    /* renamed from: c */
    private static Pair<Long, String> m19313c(C8535t mdhd) {
        int i = 8;
        mdhd.mo26118e(8);
        int version = C8290c.m19289c(mdhd.mo26119f());
        mdhd.mo26120f(version == 0 ? 8 : 16);
        long timescale = mdhd.mo26133s();
        if (version == 0) {
            i = 4;
        }
        mdhd.mo26120f(i);
        int languageCode = mdhd.mo26137w();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((char) (((languageCode >> 10) & 31) + 96));
        sb.append((char) (((languageCode >> 5) & 31) + 96));
        sb.append((char) ((languageCode & 31) + 96));
        return Pair.create(Long.valueOf(timescale), sb.toString());
    }

    /* renamed from: a */
    private static C8296c m19298a(C8535t stsd, int trackId, int rotationDegrees, String language, DrmInitData drmInitData, boolean isQuickTime) throws ParserException {
        int childAtomType;
        C8535t tVar = stsd;
        tVar.mo26118e(12);
        int numberOfEntries = stsd.mo26119f();
        C8296c out = new C8296c(numberOfEntries);
        for (int i = 0; i < numberOfEntries; i++) {
            int childStartPosition = stsd.mo26113c();
            int childAtomSize = stsd.mo26119f();
            C8514e.m20489a(childAtomSize > 0, "childAtomSize should be positive");
            int childAtomType2 = stsd.mo26119f();
            if (childAtomType2 == C8290c.f17656b || childAtomType2 == C8290c.f17658c || childAtomType2 == C8290c.f17653Z || childAtomType2 == C8290c.f17677la || childAtomType2 == C8290c.f17660d || childAtomType2 == C8290c.f17662e || childAtomType2 == C8290c.f17664f || childAtomType2 == C8290c.f17629La) {
                childAtomType = childAtomType2;
            } else if (childAtomType2 == C8290c.f17631Ma) {
                childAtomType = childAtomType2;
            } else if (childAtomType2 == C8290c.f17670i || childAtomType2 == C8290c.f17655aa || childAtomType2 == C8290c.f17680n || childAtomType2 == C8290c.f17684p || childAtomType2 == C8290c.f17688r || childAtomType2 == C8290c.f17694u || childAtomType2 == C8290c.f17690s || childAtomType2 == C8290c.f17692t || childAtomType2 == C8290c.f17703ya || childAtomType2 == C8290c.f17705za || childAtomType2 == C8290c.f17676l || childAtomType2 == C8290c.f17678m || childAtomType2 == C8290c.f17672j || childAtomType2 == C8290c.f17637Pa || childAtomType2 == C8290c.f17639Qa || childAtomType2 == C8290c.f17641Ra || childAtomType2 == C8290c.f17643Sa || childAtomType2 == C8290c.f17647Ua) {
                int i2 = childAtomType2;
                m19306a(stsd, childAtomType2, childStartPosition, childAtomSize, trackId, language, isQuickTime, drmInitData, out, i);
                tVar.mo26118e(childStartPosition + childAtomSize);
            } else if (childAtomType2 == C8290c.f17673ja || childAtomType2 == C8290c.f17695ua || childAtomType2 == C8290c.f17697va || childAtomType2 == C8290c.f17699wa || childAtomType2 == C8290c.f17701xa) {
                m19305a(stsd, childAtomType2, childStartPosition, childAtomSize, trackId, language, out);
                int i3 = childAtomType2;
                tVar.mo26118e(childStartPosition + childAtomSize);
            } else {
                if (childAtomType2 == C8290c.f17635Oa) {
                    out.f17730b = Format.m18253a(Integer.toString(trackId), "application/x-camera-motion", (String) null, -1, (DrmInitData) null);
                    int i4 = childAtomType2;
                } else {
                    int i5 = childAtomType2;
                }
                tVar.mo26118e(childStartPosition + childAtomSize);
            }
            m19304a(stsd, childAtomType, childStartPosition, childAtomSize, trackId, rotationDegrees, drmInitData, out, i);
            tVar.mo26118e(childStartPosition + childAtomSize);
        }
        return out;
    }

    /* renamed from: a */
    private static void m19305a(C8535t parent, int atomType, int position, int atomSize, int trackId, String language, C8296c out) throws ParserException {
        String mimeType;
        C8535t tVar = parent;
        int i = atomType;
        C8296c cVar = out;
        tVar.mo26118e(position + 8 + 8);
        List<byte[]> initializationData = null;
        long subsampleOffsetUs = Long.MAX_VALUE;
        if (i == C8290c.f17673ja) {
            mimeType = "application/ttml+xml";
        } else if (i == C8290c.f17695ua) {
            mimeType = "application/x-quicktime-tx3g";
            int sampleDescriptionLength = (atomSize - 8) - 8;
            byte[] sampleDescriptionData = new byte[sampleDescriptionLength];
            tVar.mo26110a(sampleDescriptionData, 0, sampleDescriptionLength);
            initializationData = Collections.singletonList(sampleDescriptionData);
        } else if (i == C8290c.f17697va) {
            mimeType = "application/x-mp4-vtt";
        } else if (i == C8290c.f17699wa) {
            mimeType = "application/ttml+xml";
            subsampleOffsetUs = 0;
        } else if (i == C8290c.f17701xa) {
            mimeType = "application/x-mp4-cea-608";
            cVar.f17732d = 1;
        } else {
            throw new IllegalStateException();
        }
        cVar.f17730b = Format.m18251a(Integer.toString(trackId), mimeType, null, -1, 0, language, -1, null, subsampleOffsetUs, initializationData);
    }

    /* renamed from: a */
    private static void m19304a(C8535t parent, int atomType, int position, int size, int trackId, int rotationDegrees, DrmInitData drmInitData, C8296c out, int entryIndex) throws ParserException {
        int atomType2;
        DrmInitData drmInitData2;
        C8535t tVar = parent;
        int i = position;
        int i2 = size;
        DrmInitData drmInitData3 = drmInitData;
        C8296c cVar = out;
        tVar.mo26118e(i + 8 + 8);
        tVar.mo26120f(16);
        int width = parent.mo26137w();
        int height = parent.mo26137w();
        tVar.mo26120f(50);
        int childPosition = parent.mo26113c();
        int atomType3 = atomType;
        if (atomType3 == C8290c.f17653Z) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = m19316d(tVar, i, i2);
            if (sampleEntryEncryptionData != null) {
                atomType3 = ((Integer) sampleEntryEncryptionData.first).intValue();
                if (drmInitData3 == null) {
                    drmInitData2 = null;
                } else {
                    drmInitData2 = drmInitData3.mo25389a(((C8315o) sampleEntryEncryptionData.second).f17874b);
                }
                drmInitData3 = drmInitData2;
                cVar.f17729a[entryIndex] = (C8315o) sampleEntryEncryptionData.second;
            }
            tVar.mo26118e(childPosition);
            atomType2 = atomType3;
        } else {
            atomType2 = atomType3;
        }
        boolean pixelWidthHeightRatioFromPasp = false;
        float pixelWidthHeightRatio = 1.0f;
        int childPosition2 = childPosition;
        List list = null;
        String mimeType = null;
        byte[] projectionData = null;
        int stereoMode = -1;
        while (childPosition2 - i < i2) {
            tVar.mo26118e(childPosition2);
            int childStartPosition = parent.mo26113c();
            int childAtomSize = parent.mo26119f();
            if (childAtomSize == 0 && parent.mo26113c() - i == i2) {
                break;
            }
            boolean z = false;
            C8514e.m20489a(childAtomSize > 0, "childAtomSize should be positive");
            int childAtomType = parent.mo26119f();
            if (childAtomType == C8290c.f17620H) {
                if (mimeType == null) {
                    z = true;
                }
                C8514e.m20490b(z);
                mimeType = "video/avc";
                tVar.mo26118e(childStartPosition + 8);
                C8554h avcConfig = C8554h.m20661a(parent);
                List<byte[]> initializationData = avcConfig.f18921a;
                cVar.f17731c = avcConfig.f18922b;
                if (!pixelWidthHeightRatioFromPasp) {
                    pixelWidthHeightRatio = avcConfig.f18925e;
                }
                list = initializationData;
            } else if (childAtomType == C8290c.f17622I) {
                if (mimeType == null) {
                    z = true;
                }
                C8514e.m20490b(z);
                mimeType = "video/hevc";
                tVar.mo26118e(childStartPosition + 8);
                C8557k hevcConfig = C8557k.m20663a(parent);
                List<byte[]> initializationData2 = hevcConfig.f18926a;
                cVar.f17731c = hevcConfig.f18927b;
                list = initializationData2;
            } else if (childAtomType == C8290c.f17633Na) {
                if (mimeType == null) {
                    z = true;
                }
                C8514e.m20490b(z);
                mimeType = atomType2 == C8290c.f17629La ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
            } else if (childAtomType == C8290c.f17666g) {
                if (mimeType == null) {
                    z = true;
                }
                C8514e.m20490b(z);
                mimeType = "video/3gpp";
            } else if (childAtomType == C8290c.f17624J) {
                if (mimeType == null) {
                    z = true;
                }
                C8514e.m20490b(z);
                Pair<String, byte[]> mimeTypeAndInitializationData = m19296a(tVar, childStartPosition);
                mimeType = (String) mimeTypeAndInitializationData.first;
                list = Collections.singletonList(mimeTypeAndInitializationData.second);
            } else if (childAtomType == C8290c.f17671ia) {
                pixelWidthHeightRatio = m19312c(tVar, childStartPosition);
                pixelWidthHeightRatioFromPasp = true;
            } else if (childAtomType == C8290c.f17625Ja) {
                projectionData = m19314c(tVar, childStartPosition, childAtomSize);
            } else if (childAtomType == C8290c.f17623Ia) {
                int version = parent.mo26131q();
                tVar.mo26120f(3);
                if (version == 0) {
                    int layout = parent.mo26131q();
                    if (layout == 0) {
                        stereoMode = 0;
                    } else if (layout == 1) {
                        stereoMode = 1;
                    } else if (layout == 2) {
                        stereoMode = 2;
                    } else if (layout == 3) {
                        stereoMode = 3;
                    }
                }
            }
            childPosition2 += childAtomSize;
        }
        if (mimeType != null) {
            int i3 = childPosition2;
            int i4 = atomType2;
            cVar.f17730b = Format.m18247a(Integer.toString(trackId), mimeType, (String) null, -1, -1, width, height, -1.0f, list, rotationDegrees, pixelWidthHeightRatio, projectionData, stereoMode, (ColorInfo) null, drmInitData3);
        }
    }

    /* renamed from: b */
    private static Pair<long[], long[]> m19310b(C8291a edtsAtom) {
        if (edtsAtom != null) {
            C8292b e = edtsAtom.mo25436e(C8290c.f17638Q);
            C8292b elst = e;
            if (e != null) {
                C8535t elstData = elst.f17710Xa;
                elstData.mo26118e(8);
                int version = C8290c.m19289c(elstData.mo26119f());
                int entryCount = elstData.mo26135u();
                long[] editListDurations = new long[entryCount];
                long[] editListMediaTimes = new long[entryCount];
                int i = 0;
                while (i < entryCount) {
                    editListDurations[i] = version == 1 ? elstData.mo26136v() : elstData.mo26133s();
                    editListMediaTimes[i] = version == 1 ? elstData.mo26127m() : (long) elstData.mo26119f();
                    if (elstData.mo26129o() == 1) {
                        elstData.mo26120f(2);
                        i++;
                    } else {
                        throw new IllegalArgumentException("Unsupported media rate.");
                    }
                }
                return Pair.create(editListDurations, editListMediaTimes);
            }
        }
        return Pair.create(null, null);
    }

    /* renamed from: c */
    private static float m19312c(C8535t parent, int position) {
        parent.mo26118e(position + 8);
        return ((float) parent.mo26135u()) / ((float) parent.mo26135u());
    }

    /* renamed from: a */
    private static void m19306a(C8535t parent, int atomType, int position, int size, int trackId, String language, boolean isQuickTime, DrmInitData drmInitData, C8296c out, int entryIndex) throws ParserException {
        int quickTimeSoundDescriptionVersion;
        int sampleRate;
        int channelCount;
        int atomType2;
        DrmInitData drmInitData2;
        List list;
        int quickTimeSoundDescriptionVersion2;
        int atomType3;
        DrmInitData drmInitData3;
        int quickTimeSoundDescriptionVersion3;
        String mimeType;
        int childAtomType;
        int i;
        String mimeType2;
        DrmInitData drmInitData4;
        C8535t tVar = parent;
        int i2 = position;
        int i3 = size;
        String str = language;
        DrmInitData drmInitData5 = drmInitData;
        C8296c cVar = out;
        tVar.mo26118e(i2 + 8 + 8);
        if (isQuickTime) {
            int quickTimeSoundDescriptionVersion4 = parent.mo26137w();
            tVar.mo26120f(6);
            quickTimeSoundDescriptionVersion = quickTimeSoundDescriptionVersion4;
        } else {
            tVar.mo26120f(8);
            quickTimeSoundDescriptionVersion = 0;
        }
        if (quickTimeSoundDescriptionVersion == 0 || quickTimeSoundDescriptionVersion == 1) {
            int channelCount2 = parent.mo26137w();
            tVar.mo26120f(6);
            sampleRate = parent.mo26132r();
            if (quickTimeSoundDescriptionVersion == 1) {
                tVar.mo26120f(16);
            }
            channelCount = channelCount2;
        } else if (quickTimeSoundDescriptionVersion == 2) {
            tVar.mo26120f(16);
            int sampleRate2 = (int) Math.round(parent.mo26117e());
            channelCount = parent.mo26135u();
            tVar.mo26120f(20);
            sampleRate = sampleRate2;
        } else {
            return;
        }
        int childPosition = parent.mo26113c();
        int atomType4 = atomType;
        if (atomType4 == C8290c.f17655aa) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = m19316d(tVar, i2, i3);
            if (sampleEntryEncryptionData != null) {
                atomType4 = ((Integer) sampleEntryEncryptionData.first).intValue();
                if (drmInitData5 == null) {
                    drmInitData4 = null;
                } else {
                    drmInitData4 = drmInitData5.mo25389a(((C8315o) sampleEntryEncryptionData.second).f17874b);
                }
                drmInitData5 = drmInitData4;
                cVar.f17729a[entryIndex] = (C8315o) sampleEntryEncryptionData.second;
            }
            tVar.mo26118e(childPosition);
            drmInitData2 = drmInitData5;
            atomType2 = atomType4;
        } else {
            drmInitData2 = drmInitData5;
            atomType2 = atomType4;
        }
        String mimeType3 = null;
        if (atomType2 == C8290c.f17680n) {
            mimeType3 = "audio/ac3";
        } else if (atomType2 == C8290c.f17684p) {
            mimeType3 = "audio/eac3";
        } else if (atomType2 == C8290c.f17688r) {
            mimeType3 = "audio/vnd.dts";
        } else if (atomType2 == C8290c.f17690s || atomType2 == C8290c.f17692t) {
            mimeType3 = "audio/vnd.dts.hd";
        } else if (atomType2 == C8290c.f17694u) {
            mimeType3 = "audio/vnd.dts.hd;profile=lbr";
        } else if (atomType2 == C8290c.f17703ya) {
            mimeType3 = "audio/3gpp";
        } else if (atomType2 == C8290c.f17705za) {
            mimeType3 = "audio/amr-wb";
        } else if (atomType2 == C8290c.f17676l || atomType2 == C8290c.f17678m) {
            mimeType3 = "audio/raw";
        } else if (atomType2 == C8290c.f17672j) {
            mimeType3 = "audio/mpeg";
        } else if (atomType2 == C8290c.f17637Pa) {
            mimeType3 = "audio/alac";
        } else if (atomType2 == C8290c.f17639Qa) {
            mimeType3 = "audio/g711-alaw";
        } else if (atomType2 == C8290c.f17641Ra) {
            mimeType3 = "audio/g711-mlaw";
        } else if (atomType2 == C8290c.f17643Sa) {
            mimeType3 = "audio/opus";
        } else if (atomType2 == C8290c.f17647Ua) {
            mimeType3 = "audio/flac";
        }
        int channelCount3 = channelCount;
        int childPosition2 = childPosition;
        int sampleRate3 = sampleRate;
        byte[] initializationData = null;
        String mimeType4 = mimeType3;
        while (childPosition2 - i2 < i3) {
            tVar.mo26118e(childPosition2);
            int childAtomSize = parent.mo26119f();
            C8514e.m20489a(childAtomSize > 0, "childAtomSize should be positive");
            int childAtomType2 = parent.mo26119f();
            if (childAtomType2 == C8290c.f17624J) {
                mimeType = mimeType4;
                drmInitData3 = drmInitData2;
                atomType3 = atomType2;
                childAtomType = childAtomType2;
                quickTimeSoundDescriptionVersion2 = quickTimeSoundDescriptionVersion;
                quickTimeSoundDescriptionVersion3 = childPosition2;
            } else if (!isQuickTime || childAtomType2 != C8290c.f17674k) {
                if (childAtomType2 == C8290c.f17682o) {
                    tVar.mo26118e(childPosition2 + 8);
                    cVar.f17730b = C8122h.m18395a(tVar, Integer.toString(trackId), str, drmInitData2);
                    mimeType2 = mimeType4;
                    drmInitData3 = drmInitData2;
                    atomType3 = atomType2;
                    int i4 = childAtomType2;
                    quickTimeSoundDescriptionVersion2 = quickTimeSoundDescriptionVersion;
                    quickTimeSoundDescriptionVersion3 = childPosition2;
                } else if (childAtomType2 == C8290c.f17686q) {
                    tVar.mo26118e(childPosition2 + 8);
                    cVar.f17730b = C8122h.m18399b(tVar, Integer.toString(trackId), str, drmInitData2);
                    mimeType2 = mimeType4;
                    drmInitData3 = drmInitData2;
                    atomType3 = atomType2;
                    int i5 = childAtomType2;
                    quickTimeSoundDescriptionVersion2 = quickTimeSoundDescriptionVersion;
                    quickTimeSoundDescriptionVersion3 = childPosition2;
                } else if (childAtomType2 == C8290c.f17696v) {
                    int childAtomSize2 = childAtomSize;
                    mimeType2 = mimeType4;
                    int childPosition3 = childPosition2;
                    drmInitData3 = drmInitData2;
                    atomType3 = atomType2;
                    int childAtomType3 = childAtomType2;
                    quickTimeSoundDescriptionVersion2 = quickTimeSoundDescriptionVersion;
                    cVar.f17730b = Format.m18250a(Integer.toString(trackId), mimeType4, null, -1, -1, channelCount3, sampleRate3, null, drmInitData3, 0, language);
                    childAtomSize = childAtomSize2;
                    quickTimeSoundDescriptionVersion3 = childPosition3;
                    int i6 = childAtomType3;
                } else {
                    int childAtomSize3 = childAtomSize;
                    mimeType2 = mimeType4;
                    int childPosition4 = childPosition2;
                    drmInitData3 = drmInitData2;
                    atomType3 = atomType2;
                    quickTimeSoundDescriptionVersion2 = quickTimeSoundDescriptionVersion;
                    int childAtomType4 = childAtomType2;
                    if (childAtomType4 == C8290c.f17637Pa) {
                        childAtomSize = childAtomSize3;
                        byte[] initializationData2 = new byte[childAtomSize];
                        quickTimeSoundDescriptionVersion3 = childPosition4;
                        tVar.mo26118e(quickTimeSoundDescriptionVersion3);
                        tVar.mo26110a(initializationData2, 0, childAtomSize);
                        initializationData = initializationData2;
                        mimeType4 = mimeType2;
                    } else {
                        childAtomSize = childAtomSize3;
                        quickTimeSoundDescriptionVersion3 = childPosition4;
                        if (childAtomType4 == C8290c.f17645Ta) {
                            int childAtomBodySize = childAtomSize - 8;
                            byte[] bArr = f17719i;
                            byte[] initializationData3 = new byte[(bArr.length + childAtomBodySize)];
                            System.arraycopy(bArr, 0, initializationData3, 0, bArr.length);
                            tVar.mo26118e(quickTimeSoundDescriptionVersion3 + 8);
                            tVar.mo26110a(initializationData3, f17719i.length, childAtomBodySize);
                            initializationData = initializationData3;
                            mimeType4 = mimeType2;
                        } else if (childAtomSize == C8290c.f17649Va) {
                            int childAtomBodySize2 = childAtomSize - 12;
                            byte[] initializationData4 = new byte[childAtomBodySize2];
                            tVar.mo26118e(quickTimeSoundDescriptionVersion3 + 12);
                            tVar.mo26110a(initializationData4, 0, childAtomBodySize2);
                            initializationData = initializationData4;
                            mimeType4 = mimeType2;
                        }
                    }
                    childPosition2 = quickTimeSoundDescriptionVersion3 + childAtomSize;
                    drmInitData2 = drmInitData3;
                    atomType2 = atomType3;
                    quickTimeSoundDescriptionVersion = quickTimeSoundDescriptionVersion2;
                }
                mimeType4 = mimeType2;
                childPosition2 = quickTimeSoundDescriptionVersion3 + childAtomSize;
                drmInitData2 = drmInitData3;
                atomType2 = atomType3;
                quickTimeSoundDescriptionVersion = quickTimeSoundDescriptionVersion2;
            } else {
                mimeType = mimeType4;
                drmInitData3 = drmInitData2;
                atomType3 = atomType2;
                childAtomType = childAtomType2;
                quickTimeSoundDescriptionVersion2 = quickTimeSoundDescriptionVersion;
                quickTimeSoundDescriptionVersion3 = childPosition2;
            }
            if (childAtomType == C8290c.f17624J) {
                i = quickTimeSoundDescriptionVersion3;
            } else {
                i = m19309b(tVar, quickTimeSoundDescriptionVersion3, childAtomSize);
            }
            int esdsAtomPosition = i;
            if (esdsAtomPosition != -1) {
                Pair<String, byte[]> mimeTypeAndInitializationData = m19296a(tVar, esdsAtomPosition);
                mimeType4 = (String) mimeTypeAndInitializationData.first;
                initializationData = (byte[]) mimeTypeAndInitializationData.second;
                if ("audio/mp4a-latm".equals(mimeType4)) {
                    Pair<Integer, Integer> audioSpecificConfig = C8518h.m20502a(initializationData);
                    sampleRate3 = ((Integer) audioSpecificConfig.first).intValue();
                    channelCount3 = ((Integer) audioSpecificConfig.second).intValue();
                }
            } else {
                mimeType4 = mimeType;
            }
            childPosition2 = quickTimeSoundDescriptionVersion3 + childAtomSize;
            drmInitData2 = drmInitData3;
            atomType2 = atomType3;
            quickTimeSoundDescriptionVersion = quickTimeSoundDescriptionVersion2;
        }
        String mimeType5 = mimeType4;
        DrmInitData drmInitData6 = drmInitData2;
        int i7 = atomType2;
        int i8 = quickTimeSoundDescriptionVersion;
        int childPosition5 = childPosition2;
        if (cVar.f17730b == null) {
            String mimeType6 = mimeType5;
            if (mimeType6 != null) {
                int pcmEncoding = "audio/raw".equals(mimeType6) ? 2 : -1;
                String num = Integer.toString(trackId);
                if (initializationData == null) {
                    list = null;
                } else {
                    list = Collections.singletonList(initializationData);
                }
                String str2 = mimeType6;
                int i9 = childPosition5;
                cVar.f17730b = Format.m18249a(num, mimeType6, (String) null, -1, -1, channelCount3, sampleRate3, pcmEncoding, list, drmInitData6, 0, language);
            } else {
                int i10 = childPosition5;
                C8296c cVar2 = cVar;
            }
        } else {
            C8296c cVar3 = cVar;
            String str3 = mimeType5;
        }
    }

    /* renamed from: b */
    private static int m19309b(C8535t parent, int position, int size) {
        int childAtomPosition = parent.mo26113c();
        while (childAtomPosition - position < size) {
            parent.mo26118e(childAtomPosition);
            int childAtomSize = parent.mo26119f();
            C8514e.m20489a(childAtomSize > 0, "childAtomSize should be positive");
            if (parent.mo26119f() == C8290c.f17624J) {
                return childAtomPosition;
            }
            childAtomPosition += childAtomSize;
        }
        return -1;
    }

    /* renamed from: a */
    private static Pair<String, byte[]> m19296a(C8535t parent, int position) {
        parent.mo26118e(position + 8 + 4);
        parent.mo26120f(1);
        m19295a(parent);
        parent.mo26120f(2);
        int flags = parent.mo26131q();
        if ((flags & 128) != 0) {
            parent.mo26120f(2);
        }
        if ((flags & 64) != 0) {
            parent.mo26120f(parent.mo26137w());
        }
        if ((flags & 32) != 0) {
            parent.mo26120f(2);
        }
        parent.mo26120f(1);
        m19295a(parent);
        String mimeType = C8529q.m20541a(parent.mo26131q());
        if ("audio/mpeg".equals(mimeType) || "audio/vnd.dts".equals(mimeType) || "audio/vnd.dts.hd".equals(mimeType)) {
            return Pair.create(mimeType, null);
        }
        parent.mo26120f(12);
        parent.mo26120f(1);
        int initializationDataSize = m19295a(parent);
        byte[] initializationData = new byte[initializationDataSize];
        parent.mo26110a(initializationData, 0, initializationDataSize);
        return Pair.create(mimeType, initializationData);
    }

    /* renamed from: d */
    private static Pair<Integer, C8315o> m19316d(C8535t parent, int position, int size) {
        int childPosition = parent.mo26113c();
        while (childPosition - position < size) {
            parent.mo26118e(childPosition);
            int childAtomSize = parent.mo26119f();
            C8514e.m20489a(childAtomSize > 0, "childAtomSize should be positive");
            if (parent.mo26119f() == C8290c.f17648V) {
                Pair<Integer, TrackEncryptionBox> result = m19297a(parent, childPosition, childAtomSize);
                if (result != null) {
                    return result;
                }
            }
            childPosition += childAtomSize;
        }
        return null;
    }

    /* renamed from: a */
    static Pair<Integer, C8315o> m19297a(C8535t parent, int position, int size) {
        int childPosition = position + 8;
        int schemeInformationBoxPosition = -1;
        int schemeInformationBoxSize = 0;
        String schemeType = null;
        Integer dataFormat = null;
        while (childPosition - position < size) {
            parent.mo26118e(childPosition);
            int childAtomSize = parent.mo26119f();
            int childAtomType = parent.mo26119f();
            if (childAtomType == C8290c.f17657ba) {
                dataFormat = Integer.valueOf(parent.mo26119f());
            } else if (childAtomType == C8290c.f17650W) {
                parent.mo26120f(4);
                schemeType = parent.mo26112b(4);
            } else if (childAtomType == C8290c.f17651X) {
                schemeInformationBoxPosition = childPosition;
                schemeInformationBoxSize = childAtomSize;
            }
            childPosition += childAtomSize;
        }
        if (!"cenc".equals(schemeType) && !"cbc1".equals(schemeType) && !"cens".equals(schemeType) && !"cbcs".equals(schemeType)) {
            return null;
        }
        boolean z = true;
        C8514e.m20489a(dataFormat != null, "frma atom is mandatory");
        C8514e.m20489a(schemeInformationBoxPosition != -1, "schi atom is mandatory");
        C8315o encryptionBox = m19300a(parent, schemeInformationBoxPosition, schemeInformationBoxSize, schemeType);
        if (encryptionBox == null) {
            z = false;
        }
        C8514e.m20489a(z, "tenc atom is mandatory");
        return Pair.create(dataFormat, encryptionBox);
    }

    /* renamed from: a */
    private static C8315o m19300a(C8535t parent, int position, int size, String schemeType) {
        byte[] constantIv;
        C8535t tVar = parent;
        int childPosition = position + 8;
        while (childPosition - position < size) {
            tVar.mo26118e(childPosition);
            int childAtomSize = parent.mo26119f();
            if (parent.mo26119f() == C8290c.f17652Y) {
                int version = C8290c.m19289c(parent.mo26119f());
                boolean defaultIsProtected = true;
                tVar.mo26120f(1);
                int defaultCryptByteBlock = 0;
                int defaultSkipByteBlock = 0;
                if (version == 0) {
                    tVar.mo26120f(1);
                } else {
                    int patternByte = parent.mo26131q();
                    defaultCryptByteBlock = (patternByte & 240) >> 4;
                    defaultSkipByteBlock = patternByte & 15;
                }
                if (parent.mo26131q() != 1) {
                    defaultIsProtected = false;
                }
                int defaultPerSampleIvSize = parent.mo26131q();
                byte[] defaultKeyId = new byte[16];
                tVar.mo26110a(defaultKeyId, 0, defaultKeyId.length);
                if (!defaultIsProtected || defaultPerSampleIvSize != 0) {
                    constantIv = null;
                } else {
                    int constantIvSize = parent.mo26131q();
                    byte[] constantIv2 = new byte[constantIvSize];
                    tVar.mo26110a(constantIv2, 0, constantIvSize);
                    constantIv = constantIv2;
                }
                byte[] bArr = defaultKeyId;
                C8315o oVar = new C8315o(defaultIsProtected, schemeType, defaultPerSampleIvSize, defaultKeyId, defaultCryptByteBlock, defaultSkipByteBlock, constantIv);
                return oVar;
            }
            childPosition += childAtomSize;
        }
        return null;
    }

    /* renamed from: c */
    private static byte[] m19314c(C8535t parent, int position, int size) {
        int childPosition = position + 8;
        while (childPosition - position < size) {
            parent.mo26118e(childPosition);
            int childAtomSize = parent.mo26119f();
            if (parent.mo26119f() == C8290c.f17627Ka) {
                return Arrays.copyOfRange(parent.f18861a, childPosition, childPosition + childAtomSize);
            }
            childPosition += childAtomSize;
        }
        return null;
    }

    /* renamed from: a */
    private static int m19295a(C8535t data) {
        int currentByte = data.mo26131q();
        int size = currentByte & Opcodes.LAND;
        while ((currentByte & 128) == 128) {
            currentByte = data.mo26131q();
            size = (size << 7) | (currentByte & Opcodes.LAND);
        }
        return size;
    }

    /* renamed from: a */
    private static boolean m19307a(long[] timestamps, long duration, long editStartTime, long editEndTime) {
        int lastIndex = timestamps.length - 1;
        int latestDelayIndex = C8509F.m20433a(3, 0, lastIndex);
        int earliestPaddingIndex = C8509F.m20433a(timestamps.length - 3, 0, lastIndex);
        if (timestamps[0] > editStartTime || editStartTime >= timestamps[latestDelayIndex] || timestamps[earliestPaddingIndex] >= editEndTime || editEndTime > duration) {
            return false;
        }
        return true;
    }
}
