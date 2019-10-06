package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.C8345b;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8534s;
import com.google.android.exoplayer2.util.C8535t;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* renamed from: com.google.android.exoplayer2.metadata.id3.h */
/* compiled from: Id3Decoder */
public final class C8353h implements C8345b {

    /* renamed from: a */
    public static final C8354a f18111a = C8346a.f18110a;

    /* renamed from: b */
    public static final int f18112b = C8509F.m20464b("ID3");

    /* renamed from: c */
    private final C8354a f18113c;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.h$a */
    /* compiled from: Id3Decoder */
    public interface C8354a {
        /* renamed from: a */
        boolean mo25236a(int i, int i2, int i3, int i4, int i5);
    }

    /* renamed from: com.google.android.exoplayer2.metadata.id3.h$b */
    /* compiled from: Id3Decoder */
    private static final class C8355b {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final int f18114a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final boolean f18115b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final int f18116c;

        public C8355b(int majorVersion, boolean isUnsynchronized, int framesSize) {
            this.f18114a = majorVersion;
            this.f18115b = isUnsynchronized;
            this.f18116c = framesSize;
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m19691a(int majorVersion, int id0, int id1, int id2, int id3) {
        return false;
    }

    public C8353h(C8354a framePredicate) {
        this.f18113c = framePredicate;
    }

    /* renamed from: a */
    public Metadata mo25596a(byte[] data, int size) {
        List<Id3Frame> id3Frames = new ArrayList<>();
        C8535t id3Data = new C8535t(data, size);
        C8355b id3Header = m19689a(id3Data);
        if (id3Header == null) {
            return null;
        }
        int startPosition = id3Data.mo26113c();
        int frameHeaderSize = id3Header.f18114a == 2 ? 6 : 10;
        int framesSize = id3Header.f18116c;
        if (id3Header.f18115b) {
            framesSize = m19706g(id3Data, id3Header.f18116c);
        }
        id3Data.mo26116d(startPosition + framesSize);
        boolean unsignedIntFrameSizeHack = false;
        if (!m19692a(id3Data, id3Header.f18114a, frameHeaderSize, false)) {
            if (id3Header.f18114a != 4 || !m19692a(id3Data, 4, frameHeaderSize, true)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to validate ID3 tag with majorVersion=");
                sb.append(id3Header.f18114a);
                C8526n.m20534d("Id3Decoder", sb.toString());
                return null;
            }
            unsignedIntFrameSizeHack = true;
        }
        while (id3Data.mo26104a() >= frameHeaderSize) {
            Id3Frame frame = m19688a(id3Header.f18114a, id3Data, unsignedIntFrameSizeHack, frameHeaderSize, this.f18113c);
            if (frame != null) {
                id3Frames.add(frame);
            }
        }
        return new Metadata(id3Frames);
    }

    /* renamed from: a */
    private static C8355b m19689a(C8535t data) {
        String str = "Id3Decoder";
        if (data.mo26104a() < 10) {
            C8526n.m20534d(str, "Data too short to be an ID3 tag");
            return null;
        }
        int id = data.mo26134t();
        if (id != f18112b) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected first three bytes of ID3 tag header: ");
            sb.append(id);
            C8526n.m20534d(str, sb.toString());
            return null;
        }
        int majorVersion = data.mo26131q();
        boolean z = true;
        data.mo26120f(1);
        int flags = data.mo26131q();
        int framesSize = data.mo26130p();
        if (majorVersion == 2) {
            if ((flags & 64) != 0) {
                C8526n.m20534d(str, "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (majorVersion == 3) {
            if ((flags & 64) != 0) {
                int extendedHeaderSize = data.mo26119f();
                data.mo26120f(extendedHeaderSize);
                framesSize -= extendedHeaderSize + 4;
            }
        } else if (majorVersion == 4) {
            if ((flags & 64) != 0) {
                int extendedHeaderSize2 = data.mo26130p();
                data.mo26120f(extendedHeaderSize2 - 4);
                framesSize -= extendedHeaderSize2;
            }
            if ((flags & 16) != 0) {
                framesSize -= 10;
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Skipped ID3 tag with unsupported majorVersion=");
            sb2.append(majorVersion);
            C8526n.m20534d(str, sb2.toString());
            return null;
        }
        if (majorVersion >= 4 || (flags & 128) == 0) {
            z = false;
        }
        return new C8355b(majorVersion, z, framesSize);
    }

    /* renamed from: a */
    private static boolean m19692a(C8535t id3Data, int majorVersion, int frameHeaderSize, boolean unsignedIntFrameSizeHack) {
        int flags;
        long frameSize;
        int id;
        C8535t tVar = id3Data;
        int i = majorVersion;
        int startPosition = id3Data.mo26113c();
        while (true) {
            try {
                boolean z = true;
                if (id3Data.mo26104a() >= frameHeaderSize) {
                    if (i >= 3) {
                        try {
                            id = id3Data.mo26119f();
                            frameSize = id3Data.mo26133s();
                            flags = id3Data.mo26137w();
                        } catch (Throwable th) {
                            th = th;
                        }
                    } else {
                        id = id3Data.mo26134t();
                        frameSize = (long) id3Data.mo26134t();
                        flags = 0;
                    }
                    if (id == 0 && frameSize == 0 && flags == 0) {
                        tVar.mo26118e(startPosition);
                        return true;
                    }
                    if (i == 4 && !unsignedIntFrameSizeHack) {
                        if ((8421504 & frameSize) != 0) {
                            tVar.mo26118e(startPosition);
                            return false;
                        }
                        frameSize = (frameSize & 255) | (((frameSize >> 8) & 255) << 7) | (((frameSize >> 16) & 255) << 14) | (((frameSize >> 24) & 255) << 21);
                    }
                    boolean hasGroupIdentifier = false;
                    boolean hasDataLength = false;
                    if (i == 4) {
                        hasGroupIdentifier = (flags & 64) != 0;
                        if ((flags & 1) == 0) {
                            z = false;
                        }
                        hasDataLength = z;
                    } else if (i == 3) {
                        hasGroupIdentifier = (flags & 32) != 0;
                        if ((flags & 128) == 0) {
                            z = false;
                        }
                        hasDataLength = z;
                    }
                    int minimumFrameSize = 0;
                    if (hasGroupIdentifier) {
                        minimumFrameSize = 0 + 1;
                    }
                    if (hasDataLength) {
                        minimumFrameSize += 4;
                    }
                    if (frameSize < ((long) minimumFrameSize)) {
                        tVar.mo26118e(startPosition);
                        return false;
                    } else if (((long) id3Data.mo26104a()) < frameSize) {
                        tVar.mo26118e(startPosition);
                        return false;
                    } else {
                        tVar.mo26120f((int) frameSize);
                    }
                } else {
                    tVar.mo26118e(startPosition);
                    return true;
                }
            } catch (Throwable th2) {
                th = th2;
                int i2 = frameHeaderSize;
                tVar.mo26118e(startPosition);
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01bf, code lost:
        if (r13 == 67) goto L_0x01c1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.metadata.id3.Id3Frame m19688a(int r23, com.google.android.exoplayer2.util.C8535t r24, boolean r25, int r26, com.google.android.exoplayer2.metadata.id3.C8353h.C8354a r27) {
        /*
            r7 = r23
            r8 = r24
            int r9 = r24.mo26131q()
            int r10 = r24.mo26131q()
            int r11 = r24.mo26131q()
            r0 = 3
            if (r7 < r0) goto L_0x0018
            int r1 = r24.mo26131q()
            goto L_0x0019
        L_0x0018:
            r1 = 0
        L_0x0019:
            r13 = r1
            r14 = 4
            if (r7 != r14) goto L_0x003f
            int r1 = r24.mo26135u()
            if (r25 != 0) goto L_0x003d
            r2 = r1 & 255(0xff, float:3.57E-43)
            int r3 = r1 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 7
            r2 = r2 | r3
            int r3 = r1 >> 16
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 14
            r2 = r2 | r3
            int r3 = r1 >> 24
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 21
            r1 = r2 | r3
            r15 = r1
            goto L_0x004c
        L_0x003d:
            r15 = r1
            goto L_0x004c
        L_0x003f:
            if (r7 != r0) goto L_0x0047
            int r1 = r24.mo26135u()
            r15 = r1
            goto L_0x004c
        L_0x0047:
            int r1 = r24.mo26134t()
            r15 = r1
        L_0x004c:
            if (r7 < r0) goto L_0x0053
            int r1 = r24.mo26137w()
            goto L_0x0054
        L_0x0053:
            r1 = 0
        L_0x0054:
            r6 = r1
            r16 = 0
            if (r9 != 0) goto L_0x006b
            if (r10 != 0) goto L_0x006b
            if (r11 != 0) goto L_0x006b
            if (r13 != 0) goto L_0x006b
            if (r15 != 0) goto L_0x006b
            if (r6 != 0) goto L_0x006b
            int r0 = r24.mo26115d()
            r8.mo26118e(r0)
            return r16
        L_0x006b:
            int r1 = r24.mo26113c()
            int r5 = r1 + r15
            int r1 = r24.mo26115d()
            java.lang.String r4 = "Id3Decoder"
            if (r5 <= r1) goto L_0x0086
            java.lang.String r0 = "Frame size exceeds remaining tag data"
            com.google.android.exoplayer2.util.C8526n.m20534d(r4, r0)
            int r0 = r24.mo26115d()
            r8.mo26118e(r0)
            return r16
        L_0x0086:
            if (r27 == 0) goto L_0x009f
            r1 = r27
            r2 = r23
            r3 = r9
            r12 = r4
            r4 = r10
            r14 = r5
            r5 = r11
            r18 = r12
            r12 = r6
            r6 = r13
            boolean r1 = r1.mo25236a(r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x00a3
            r8.mo26118e(r14)
            return r16
        L_0x009f:
            r18 = r4
            r14 = r5
            r12 = r6
        L_0x00a3:
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 1
            if (r7 != r0) goto L_0x00d2
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00b1
            r0 = 1
            goto L_0x00b2
        L_0x00b1:
            r0 = 0
        L_0x00b2:
            r1 = r0
            r0 = r12 & 64
            if (r0 == 0) goto L_0x00b9
            r0 = 1
            goto L_0x00ba
        L_0x00b9:
            r0 = 0
        L_0x00ba:
            r2 = r0
            r0 = r12 & 32
            if (r0 == 0) goto L_0x00c2
            r17 = 1
            goto L_0x00c4
        L_0x00c2:
            r17 = 0
        L_0x00c4:
            r5 = r17
            r4 = r1
            r17 = r1
            r19 = r2
            r21 = r3
            r22 = r4
            r20 = r5
            goto L_0x0115
        L_0x00d2:
            r0 = 4
            if (r7 != r0) goto L_0x010b
            r0 = r12 & 64
            if (r0 == 0) goto L_0x00db
            r0 = 1
            goto L_0x00dc
        L_0x00db:
            r0 = 0
        L_0x00dc:
            r5 = r0
            r0 = r12 & 8
            if (r0 == 0) goto L_0x00e3
            r0 = 1
            goto L_0x00e4
        L_0x00e3:
            r0 = 0
        L_0x00e4:
            r1 = r0
            r0 = r12 & 4
            if (r0 == 0) goto L_0x00eb
            r0 = 1
            goto L_0x00ec
        L_0x00eb:
            r0 = 0
        L_0x00ec:
            r2 = r0
            r0 = r12 & 2
            if (r0 == 0) goto L_0x00f3
            r0 = 1
            goto L_0x00f4
        L_0x00f3:
            r0 = 0
        L_0x00f4:
            r3 = r0
            r0 = r12 & 1
            if (r0 == 0) goto L_0x00fc
            r17 = 1
            goto L_0x00fe
        L_0x00fc:
            r17 = 0
        L_0x00fe:
            r4 = r17
            r17 = r1
            r19 = r2
            r21 = r3
            r22 = r4
            r20 = r5
            goto L_0x0115
        L_0x010b:
            r17 = r1
            r19 = r2
            r21 = r3
            r22 = r4
            r20 = r5
        L_0x0115:
            if (r17 != 0) goto L_0x0260
            if (r19 == 0) goto L_0x011d
            r2 = r18
            goto L_0x0262
        L_0x011d:
            if (r20 == 0) goto L_0x0124
            int r15 = r15 + -1
            r8.mo26120f(r6)
        L_0x0124:
            if (r22 == 0) goto L_0x012c
            int r15 = r15 + -4
            r0 = 4
            r8.mo26120f(r0)
        L_0x012c:
            if (r21 == 0) goto L_0x0133
            int r0 = m19706g(r8, r15)
            r15 = r0
        L_0x0133:
            r0 = 84
            r1 = 2
            r2 = 88
            if (r9 != r0) goto L_0x0148
            if (r10 != r2) goto L_0x0148
            if (r11 != r2) goto L_0x0148
            if (r7 == r1) goto L_0x0142
            if (r13 != r2) goto L_0x0148
        L_0x0142:
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r0 = m19704e(r8, r15)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            goto L_0x0226
        L_0x0148:
            if (r9 != r0) goto L_0x015d
            java.lang.String r0 = m19700b(r7, r9, r10, r11, r13)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = m19698b(r8, r15, r0)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            r0 = r1
            goto L_0x0226
        L_0x0155:
            r0 = move-exception
            goto L_0x025c
        L_0x0158:
            r0 = move-exception
            r2 = r18
            goto L_0x0252
        L_0x015d:
            r3 = 87
            if (r9 != r3) goto L_0x016f
            if (r10 != r2) goto L_0x016f
            if (r11 != r2) goto L_0x016f
            if (r7 == r1) goto L_0x0169
            if (r13 != r2) goto L_0x016f
        L_0x0169:
            com.google.android.exoplayer2.metadata.id3.UrlLinkFrame r0 = m19705f(r8, r15)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            goto L_0x0226
        L_0x016f:
            r2 = 87
            if (r9 != r2) goto L_0x017e
            java.lang.String r0 = m19700b(r7, r9, r10, r11, r13)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            com.google.android.exoplayer2.metadata.id3.UrlLinkFrame r1 = m19702c(r8, r15, r0)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            r0 = r1
            goto L_0x0226
        L_0x017e:
            r2 = 73
            r3 = 80
            if (r9 != r3) goto L_0x0194
            r4 = 82
            if (r10 != r4) goto L_0x0194
            if (r11 != r2) goto L_0x0194
            r4 = 86
            if (r13 != r4) goto L_0x0194
            com.google.android.exoplayer2.metadata.id3.PrivFrame r0 = m19703d(r8, r15)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            goto L_0x0226
        L_0x0194:
            r4 = 71
            r5 = 79
            if (r9 != r4) goto L_0x01ac
            r4 = 69
            if (r10 != r4) goto L_0x01ac
            if (r11 != r5) goto L_0x01ac
            r4 = 66
            if (r13 == r4) goto L_0x01a6
            if (r7 != r1) goto L_0x01ac
        L_0x01a6:
            com.google.android.exoplayer2.metadata.id3.GeobFrame r0 = m19697b(r8, r15)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            goto L_0x0226
        L_0x01ac:
            r4 = 67
            if (r7 != r1) goto L_0x01b7
            if (r9 != r3) goto L_0x01c7
            if (r10 != r2) goto L_0x01c7
            if (r11 != r4) goto L_0x01c7
            goto L_0x01c1
        L_0x01b7:
            r6 = 65
            if (r9 != r6) goto L_0x01c7
            if (r10 != r3) goto L_0x01c7
            if (r11 != r2) goto L_0x01c7
            if (r13 != r4) goto L_0x01c7
        L_0x01c1:
            com.google.android.exoplayer2.metadata.id3.ApicFrame r0 = m19684a(r8, r15, r7)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            goto L_0x0226
        L_0x01c7:
            r2 = 77
            if (r9 != r4) goto L_0x01d8
            if (r10 != r5) goto L_0x01d8
            if (r11 != r2) goto L_0x01d8
            if (r13 == r2) goto L_0x01d3
            if (r7 != r1) goto L_0x01d8
        L_0x01d3:
            com.google.android.exoplayer2.metadata.id3.CommentFrame r0 = m19687a(r8, r15)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            goto L_0x0226
        L_0x01d8:
            if (r9 != r4) goto L_0x01f4
            r1 = 72
            if (r10 != r1) goto L_0x01f4
            r1 = 65
            if (r11 != r1) goto L_0x01f4
            if (r13 != r3) goto L_0x01f4
            r1 = r24
            r2 = r15
            r3 = r23
            r4 = r25
            r5 = r26
            r6 = r27
            com.google.android.exoplayer2.metadata.id3.ChapterFrame r0 = m19686a(r1, r2, r3, r4, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            goto L_0x0226
        L_0x01f4:
            if (r9 != r4) goto L_0x020c
            if (r10 != r0) goto L_0x020c
            if (r11 != r5) goto L_0x020c
            if (r13 != r4) goto L_0x020c
            r1 = r24
            r2 = r15
            r3 = r23
            r4 = r25
            r5 = r26
            r6 = r27
            com.google.android.exoplayer2.metadata.id3.ChapterTocFrame r0 = m19696b(r1, r2, r3, r4, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            goto L_0x0226
        L_0x020c:
            if (r9 != r2) goto L_0x021d
            r1 = 76
            if (r10 != r1) goto L_0x021d
            r1 = 76
            if (r11 != r1) goto L_0x021d
            if (r13 != r0) goto L_0x021d
            com.google.android.exoplayer2.metadata.id3.MlltFrame r0 = m19701c(r8, r15)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            goto L_0x0226
        L_0x021d:
            java.lang.String r0 = m19700b(r7, r9, r10, r11, r13)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            com.google.android.exoplayer2.metadata.id3.BinaryFrame r1 = m19685a(r8, r15, r0)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            r0 = r1
        L_0x0226:
            if (r0 != 0) goto L_0x024d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            r1.<init>()     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            java.lang.String r2 = "Failed to decode frame: id="
            r1.append(r2)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            java.lang.String r2 = m19700b(r7, r9, r10, r11, r13)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            r1.append(r2)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            java.lang.String r2 = ", frameSize="
            r1.append(r2)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            r1.append(r15)     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            java.lang.String r1 = r1.toString()     // Catch:{ UnsupportedEncodingException -> 0x0158 }
            r2 = r18
            com.google.android.exoplayer2.util.C8526n.m20534d(r2, r1)     // Catch:{ UnsupportedEncodingException -> 0x024b }
            goto L_0x024d
        L_0x024b:
            r0 = move-exception
            goto L_0x0252
        L_0x024d:
            r8.mo26118e(r14)
            return r0
        L_0x0252:
            java.lang.String r1 = "Unsupported character encoding"
            com.google.android.exoplayer2.util.C8526n.m20534d(r2, r1)     // Catch:{ all -> 0x0155 }
            r8.mo26118e(r14)
            return r16
        L_0x025c:
            r8.mo26118e(r14)
            throw r0
        L_0x0260:
            r2 = r18
        L_0x0262:
            java.lang.String r0 = "Skipping unsupported compressed or encrypted frame"
            com.google.android.exoplayer2.util.C8526n.m20534d(r2, r0)
            r8.mo26118e(r14)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.C8353h.m19688a(int, com.google.android.exoplayer2.util.t, boolean, int, com.google.android.exoplayer2.metadata.id3.h$a):com.google.android.exoplayer2.metadata.id3.Id3Frame");
    }

    /* renamed from: e */
    private static TextInformationFrame m19704e(C8535t id3Data, int frameSize) throws UnsupportedEncodingException {
        if (frameSize < 1) {
            return null;
        }
        int encoding = id3Data.mo26131q();
        String charset = m19699b(encoding);
        byte[] data = new byte[(frameSize - 1)];
        id3Data.mo26110a(data, 0, frameSize - 1);
        int descriptionEndIndex = m19695b(data, 0, encoding);
        String description = new String(data, 0, descriptionEndIndex, charset);
        int valueStartIndex = m19683a(encoding) + descriptionEndIndex;
        return new TextInformationFrame("TXXX", description, m19690a(data, valueStartIndex, m19695b(data, valueStartIndex, encoding), charset));
    }

    /* renamed from: b */
    private static TextInformationFrame m19698b(C8535t id3Data, int frameSize, String id) throws UnsupportedEncodingException {
        if (frameSize < 1) {
            return null;
        }
        int encoding = id3Data.mo26131q();
        String charset = m19699b(encoding);
        byte[] data = new byte[(frameSize - 1)];
        id3Data.mo26110a(data, 0, frameSize - 1);
        return new TextInformationFrame(id, null, new String(data, 0, m19695b(data, 0, encoding), charset));
    }

    /* renamed from: f */
    private static UrlLinkFrame m19705f(C8535t id3Data, int frameSize) throws UnsupportedEncodingException {
        if (frameSize < 1) {
            return null;
        }
        int encoding = id3Data.mo26131q();
        String charset = m19699b(encoding);
        byte[] data = new byte[(frameSize - 1)];
        id3Data.mo26110a(data, 0, frameSize - 1);
        int descriptionEndIndex = m19695b(data, 0, encoding);
        String description = new String(data, 0, descriptionEndIndex, charset);
        int urlStartIndex = m19683a(encoding) + descriptionEndIndex;
        return new UrlLinkFrame("WXXX", description, m19690a(data, urlStartIndex, m19694b(data, urlStartIndex), "ISO-8859-1"));
    }

    /* renamed from: c */
    private static UrlLinkFrame m19702c(C8535t id3Data, int frameSize, String id) throws UnsupportedEncodingException {
        byte[] data = new byte[frameSize];
        id3Data.mo26110a(data, 0, frameSize);
        return new UrlLinkFrame(id, null, new String(data, 0, m19694b(data, 0), "ISO-8859-1"));
    }

    /* renamed from: d */
    private static PrivFrame m19703d(C8535t id3Data, int frameSize) throws UnsupportedEncodingException {
        byte[] data = new byte[frameSize];
        id3Data.mo26110a(data, 0, frameSize);
        int ownerEndIndex = m19694b(data, 0);
        return new PrivFrame(new String(data, 0, ownerEndIndex, "ISO-8859-1"), m19693a(data, ownerEndIndex + 1, data.length));
    }

    /* renamed from: b */
    private static GeobFrame m19697b(C8535t id3Data, int frameSize) throws UnsupportedEncodingException {
        int encoding = id3Data.mo26131q();
        String charset = m19699b(encoding);
        byte[] data = new byte[(frameSize - 1)];
        id3Data.mo26110a(data, 0, frameSize - 1);
        int mimeTypeEndIndex = m19694b(data, 0);
        String mimeType = new String(data, 0, mimeTypeEndIndex, "ISO-8859-1");
        int filenameStartIndex = mimeTypeEndIndex + 1;
        int filenameEndIndex = m19695b(data, filenameStartIndex, encoding);
        String filename = m19690a(data, filenameStartIndex, filenameEndIndex, charset);
        int descriptionStartIndex = m19683a(encoding) + filenameEndIndex;
        int descriptionEndIndex = m19695b(data, descriptionStartIndex, encoding);
        return new GeobFrame(mimeType, filename, m19690a(data, descriptionStartIndex, descriptionEndIndex, charset), m19693a(data, m19683a(encoding) + descriptionEndIndex, data.length));
    }

    /* renamed from: a */
    private static ApicFrame m19684a(C8535t id3Data, int frameSize, int majorVersion) throws UnsupportedEncodingException {
        int mimeTypeEndIndex;
        String mimeType;
        int encoding = id3Data.mo26131q();
        String charset = m19699b(encoding);
        byte[] data = new byte[(frameSize - 1)];
        id3Data.mo26110a(data, 0, frameSize - 1);
        String str = "image/";
        String str2 = "ISO-8859-1";
        if (majorVersion == 2) {
            mimeTypeEndIndex = 2;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(C8509F.m20480g(new String(data, 0, 3, str2)));
            mimeType = sb.toString();
            if ("image/jpg".equals(mimeType)) {
                mimeType = "image/jpeg";
            }
        } else {
            mimeTypeEndIndex = m19694b(data, 0);
            String mimeType2 = C8509F.m20480g(new String(data, 0, mimeTypeEndIndex, str2));
            if (mimeType2.indexOf(47) == -1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(mimeType2);
                mimeType = sb2.toString();
            } else {
                mimeType = mimeType2;
            }
        }
        int pictureType = data[mimeTypeEndIndex + 1] & 255;
        int descriptionStartIndex = mimeTypeEndIndex + 2;
        int descriptionEndIndex = m19695b(data, descriptionStartIndex, encoding);
        return new ApicFrame(mimeType, new String(data, descriptionStartIndex, descriptionEndIndex - descriptionStartIndex, charset), pictureType, m19693a(data, m19683a(encoding) + descriptionEndIndex, data.length));
    }

    /* renamed from: a */
    private static CommentFrame m19687a(C8535t id3Data, int frameSize) throws UnsupportedEncodingException {
        if (frameSize < 4) {
            return null;
        }
        int encoding = id3Data.mo26131q();
        String charset = m19699b(encoding);
        byte[] data = new byte[3];
        id3Data.mo26110a(data, 0, 3);
        String language = new String(data, 0, 3);
        byte[] data2 = new byte[(frameSize - 4)];
        id3Data.mo26110a(data2, 0, frameSize - 4);
        int descriptionEndIndex = m19695b(data2, 0, encoding);
        String description = new String(data2, 0, descriptionEndIndex, charset);
        int textStartIndex = m19683a(encoding) + descriptionEndIndex;
        return new CommentFrame(language, description, m19690a(data2, textStartIndex, m19695b(data2, textStartIndex, encoding), charset));
    }

    /* renamed from: a */
    private static ChapterFrame m19686a(C8535t id3Data, int frameSize, int majorVersion, boolean unsignedIntFrameSizeHack, int frameHeaderSize, C8354a framePredicate) throws UnsupportedEncodingException {
        long startOffset;
        long endOffset;
        C8535t tVar = id3Data;
        int framePosition = id3Data.mo26113c();
        int chapterIdEndIndex = m19694b(tVar.f18861a, framePosition);
        String chapterId = new String(tVar.f18861a, framePosition, chapterIdEndIndex - framePosition, "ISO-8859-1");
        tVar.mo26118e(chapterIdEndIndex + 1);
        int startTime = id3Data.mo26119f();
        int endTime = id3Data.mo26119f();
        long startOffset2 = id3Data.mo26133s();
        if (startOffset2 == 4294967295L) {
            startOffset = -1;
        } else {
            startOffset = startOffset2;
        }
        long endOffset2 = id3Data.mo26133s();
        if (endOffset2 == 4294967295L) {
            endOffset = -1;
        } else {
            endOffset = endOffset2;
        }
        ArrayList arrayList = new ArrayList();
        int limit = framePosition + frameSize;
        while (id3Data.mo26113c() < limit) {
            Id3Frame frame = m19688a(majorVersion, tVar, unsignedIntFrameSizeHack, frameHeaderSize, framePredicate);
            if (frame != null) {
                arrayList.add(frame);
            }
        }
        int i = majorVersion;
        boolean z = unsignedIntFrameSizeHack;
        int i2 = frameHeaderSize;
        C8354a aVar = framePredicate;
        Id3Frame[] subFrameArray = new Id3Frame[arrayList.size()];
        arrayList.toArray(subFrameArray);
        int i3 = limit;
        ArrayList arrayList2 = arrayList;
        ChapterFrame chapterFrame = new ChapterFrame(chapterId, startTime, endTime, startOffset, endOffset, subFrameArray);
        return chapterFrame;
    }

    /* renamed from: b */
    private static ChapterTocFrame m19696b(C8535t id3Data, int frameSize, int majorVersion, boolean unsignedIntFrameSizeHack, int frameHeaderSize, C8354a framePredicate) throws UnsupportedEncodingException {
        C8535t tVar = id3Data;
        int framePosition = id3Data.mo26113c();
        int elementIdEndIndex = m19694b(tVar.f18861a, framePosition);
        String str = "ISO-8859-1";
        String elementId = new String(tVar.f18861a, framePosition, elementIdEndIndex - framePosition, str);
        tVar.mo26118e(elementIdEndIndex + 1);
        int ctocFlags = id3Data.mo26131q();
        boolean isOrdered = false;
        boolean isRoot = (ctocFlags & 2) != 0;
        if ((ctocFlags & 1) != 0) {
            isOrdered = true;
        }
        int childCount = id3Data.mo26131q();
        String[] children = new String[childCount];
        for (int i = 0; i < childCount; i++) {
            int startIndex = id3Data.mo26113c();
            int endIndex = m19694b(tVar.f18861a, startIndex);
            children[i] = new String(tVar.f18861a, startIndex, endIndex - startIndex, str);
            tVar.mo26118e(endIndex + 1);
        }
        ArrayList arrayList = new ArrayList();
        int limit = framePosition + frameSize;
        while (id3Data.mo26113c() < limit) {
            Id3Frame frame = m19688a(majorVersion, tVar, unsignedIntFrameSizeHack, frameHeaderSize, framePredicate);
            if (frame != null) {
                arrayList.add(frame);
            }
        }
        int i2 = majorVersion;
        boolean z = unsignedIntFrameSizeHack;
        int i3 = frameHeaderSize;
        C8354a aVar = framePredicate;
        Id3Frame[] subFrameArray = new Id3Frame[arrayList.size()];
        arrayList.toArray(subFrameArray);
        ChapterTocFrame chapterTocFrame = new ChapterTocFrame(elementId, isRoot, isOrdered, children, subFrameArray);
        return chapterTocFrame;
    }

    /* renamed from: c */
    private static MlltFrame m19701c(C8535t id3Data, int frameSize) {
        int mpegFramesBetweenReference = id3Data.mo26137w();
        int bytesBetweenReference = id3Data.mo26134t();
        int millisecondsBetweenReference = id3Data.mo26134t();
        int bitsForBytesDeviation = id3Data.mo26131q();
        int bitsForMillisecondsDeviation = id3Data.mo26131q();
        C8534s references = new C8534s();
        references.mo26094a(id3Data);
        int referencesCount = ((frameSize - 10) * 8) / (bitsForBytesDeviation + bitsForMillisecondsDeviation);
        int[] bytesDeviations = new int[referencesCount];
        int[] millisecondsDeviations = new int[referencesCount];
        for (int i = 0; i < referencesCount; i++) {
            int bytesDeviation = references.mo26092a(bitsForBytesDeviation);
            int millisecondsDeviation = references.mo26092a(bitsForMillisecondsDeviation);
            bytesDeviations[i] = bytesDeviation;
            millisecondsDeviations[i] = millisecondsDeviation;
        }
        int[] iArr = bytesDeviations;
        MlltFrame mlltFrame = new MlltFrame(mpegFramesBetweenReference, bytesBetweenReference, millisecondsBetweenReference, bytesDeviations, millisecondsDeviations);
        return mlltFrame;
    }

    /* renamed from: a */
    private static BinaryFrame m19685a(C8535t id3Data, int frameSize, String id) {
        byte[] frame = new byte[frameSize];
        id3Data.mo26110a(frame, 0, frameSize);
        return new BinaryFrame(id, frame);
    }

    /* renamed from: g */
    private static int m19706g(C8535t data, int length) {
        byte[] bytes = data.f18861a;
        for (int i = data.mo26113c(); i + 1 < length; i++) {
            if ((bytes[i] & 255) == 255 && bytes[i + 1] == 0) {
                System.arraycopy(bytes, i + 2, bytes, i + 1, (length - i) - 2);
                length--;
            }
        }
        return length;
    }

    /* renamed from: b */
    private static String m19699b(int encodingByte) {
        if (encodingByte == 1) {
            return "UTF-16";
        }
        if (encodingByte == 2) {
            return "UTF-16BE";
        }
        if (encodingByte != 3) {
            return "ISO-8859-1";
        }
        return "UTF-8";
    }

    /* renamed from: b */
    private static String m19700b(int majorVersion, int frameId0, int frameId1, int frameId2, int frameId3) {
        if (majorVersion == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(frameId0), Integer.valueOf(frameId1), Integer.valueOf(frameId2)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(frameId0), Integer.valueOf(frameId1), Integer.valueOf(frameId2), Integer.valueOf(frameId3)});
    }

    /* renamed from: b */
    private static int m19695b(byte[] data, int fromIndex, int encoding) {
        int terminationPos = m19694b(data, fromIndex);
        if (encoding == 0 || encoding == 3) {
            return terminationPos;
        }
        while (terminationPos < data.length - 1) {
            if (terminationPos % 2 == 0 && data[terminationPos + 1] == 0) {
                return terminationPos;
            }
            terminationPos = m19694b(data, terminationPos + 1);
        }
        return data.length;
    }

    /* renamed from: b */
    private static int m19694b(byte[] data, int fromIndex) {
        for (int i = fromIndex; i < data.length; i++) {
            if (data[i] == 0) {
                return i;
            }
        }
        return data.length;
    }

    /* renamed from: a */
    private static int m19683a(int encodingByte) {
        return (encodingByte == 0 || encodingByte == 3) ? 1 : 2;
    }

    /* renamed from: a */
    private static byte[] m19693a(byte[] data, int from, int to) {
        if (to <= from) {
            return C8509F.f18798f;
        }
        return Arrays.copyOfRange(data, from, to);
    }

    /* renamed from: a */
    private static String m19690a(byte[] data, int from, int to, String charsetName) throws UnsupportedEncodingException {
        if (to <= from || to > data.length) {
            return "";
        }
        return new String(data, from, to - from, charsetName);
    }
}
