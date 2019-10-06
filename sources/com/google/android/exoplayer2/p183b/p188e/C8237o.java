package com.google.android.exoplayer2.p183b.p188e;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.util.C8518h;
import com.google.android.exoplayer2.util.C8531r;
import com.google.android.exoplayer2.util.C8531r.C8532a;
import com.google.android.exoplayer2.util.C8531r.C8533b;
import com.google.android.exoplayer2.util.C8535t;
import com.google.android.exoplayer2.util.C8536u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.b.e.o */
/* compiled from: H264Reader */
public final class C8237o implements C8233l {

    /* renamed from: a */
    private final C8207B f17314a;

    /* renamed from: b */
    private final boolean f17315b;

    /* renamed from: c */
    private final boolean f17316c;

    /* renamed from: d */
    private final C8245t f17317d = new C8245t(7, 128);

    /* renamed from: e */
    private final C8245t f17318e = new C8245t(8, 128);

    /* renamed from: f */
    private final C8245t f17319f = new C8245t(6, 128);

    /* renamed from: g */
    private long f17320g;

    /* renamed from: h */
    private final boolean[] f17321h = new boolean[3];

    /* renamed from: i */
    private String f17322i;

    /* renamed from: j */
    private C8272q f17323j;

    /* renamed from: k */
    private C8238a f17324k;

    /* renamed from: l */
    private boolean f17325l;

    /* renamed from: m */
    private long f17326m;

    /* renamed from: n */
    private boolean f17327n;

    /* renamed from: o */
    private final C8535t f17328o = new C8535t();

    /* renamed from: com.google.android.exoplayer2.b.e.o$a */
    /* compiled from: H264Reader */
    private static final class C8238a {

        /* renamed from: a */
        private final C8272q f17329a;

        /* renamed from: b */
        private final boolean f17330b;

        /* renamed from: c */
        private final boolean f17331c;

        /* renamed from: d */
        private final SparseArray<C8533b> f17332d = new SparseArray<>();

        /* renamed from: e */
        private final SparseArray<C8532a> f17333e = new SparseArray<>();

        /* renamed from: f */
        private final C8536u f17334f = new C8536u(this.f17335g, 0, 0);

        /* renamed from: g */
        private byte[] f17335g = new byte[128];

        /* renamed from: h */
        private int f17336h;

        /* renamed from: i */
        private int f17337i;

        /* renamed from: j */
        private long f17338j;

        /* renamed from: k */
        private boolean f17339k;

        /* renamed from: l */
        private long f17340l;

        /* renamed from: m */
        private C8239a f17341m = new C8239a();

        /* renamed from: n */
        private C8239a f17342n = new C8239a();

        /* renamed from: o */
        private boolean f17343o;

        /* renamed from: p */
        private long f17344p;

        /* renamed from: q */
        private long f17345q;

        /* renamed from: r */
        private boolean f17346r;

        /* renamed from: com.google.android.exoplayer2.b.e.o$a$a */
        /* compiled from: H264Reader */
        private static final class C8239a {

            /* renamed from: a */
            private boolean f17347a;

            /* renamed from: b */
            private boolean f17348b;

            /* renamed from: c */
            private C8533b f17349c;

            /* renamed from: d */
            private int f17350d;

            /* renamed from: e */
            private int f17351e;

            /* renamed from: f */
            private int f17352f;

            /* renamed from: g */
            private int f17353g;

            /* renamed from: h */
            private boolean f17354h;

            /* renamed from: i */
            private boolean f17355i;

            /* renamed from: j */
            private boolean f17356j;

            /* renamed from: k */
            private boolean f17357k;

            /* renamed from: l */
            private int f17358l;

            /* renamed from: m */
            private int f17359m;

            /* renamed from: n */
            private int f17360n;

            /* renamed from: o */
            private int f17361o;

            /* renamed from: p */
            private int f17362p;

            private C8239a() {
            }

            /* renamed from: a */
            public void mo25319a() {
                this.f17348b = false;
                this.f17347a = false;
            }

            /* renamed from: a */
            public void mo25320a(int sliceType) {
                this.f17351e = sliceType;
                this.f17348b = true;
            }

            /* renamed from: a */
            public void mo25321a(C8533b spsData, int nalRefIdc, int sliceType, int frameNum, int picParameterSetId, boolean fieldPicFlag, boolean bottomFieldFlagPresent, boolean bottomFieldFlag, boolean idrPicFlag, int idrPicId, int picOrderCntLsb, int deltaPicOrderCntBottom, int deltaPicOrderCnt0, int deltaPicOrderCnt1) {
                this.f17349c = spsData;
                this.f17350d = nalRefIdc;
                this.f17351e = sliceType;
                this.f17352f = frameNum;
                this.f17353g = picParameterSetId;
                this.f17354h = fieldPicFlag;
                this.f17355i = bottomFieldFlagPresent;
                this.f17356j = bottomFieldFlag;
                this.f17357k = idrPicFlag;
                this.f17358l = idrPicId;
                this.f17359m = picOrderCntLsb;
                this.f17360n = deltaPicOrderCntBottom;
                this.f17361o = deltaPicOrderCnt0;
                this.f17362p = deltaPicOrderCnt1;
                this.f17347a = true;
                this.f17348b = true;
            }

            /* renamed from: b */
            public boolean mo25322b() {
                if (this.f17348b) {
                    int i = this.f17351e;
                    if (i == 7 || i == 2) {
                        return true;
                    }
                }
                return false;
            }

            /* access modifiers changed from: private */
            /* renamed from: a */
            public boolean m19052a(C8239a other) {
                if (this.f17347a) {
                    if (!other.f17347a || this.f17352f != other.f17352f || this.f17353g != other.f17353g || this.f17354h != other.f17354h) {
                        return true;
                    }
                    if (this.f17355i && other.f17355i && this.f17356j != other.f17356j) {
                        return true;
                    }
                    int i = this.f17350d;
                    int i2 = other.f17350d;
                    if (i != i2 && (i == 0 || i2 == 0)) {
                        return true;
                    }
                    if (this.f17349c.f18854k == 0 && other.f17349c.f18854k == 0 && (this.f17359m != other.f17359m || this.f17360n != other.f17360n)) {
                        return true;
                    }
                    if (this.f17349c.f18854k == 1 && other.f17349c.f18854k == 1 && (this.f17361o != other.f17361o || this.f17362p != other.f17362p)) {
                        return true;
                    }
                    boolean z = this.f17357k;
                    boolean z2 = other.f17357k;
                    if (z != z2) {
                        return true;
                    }
                    if (z && z2 && this.f17358l != other.f17358l) {
                        return true;
                    }
                }
                return false;
            }
        }

        public C8238a(C8272q output, boolean allowNonIdrKeyframes, boolean detectAccessUnits) {
            this.f17329a = output;
            this.f17330b = allowNonIdrKeyframes;
            this.f17331c = detectAccessUnits;
            mo25318b();
        }

        /* renamed from: a */
        public boolean mo25316a() {
            return this.f17331c;
        }

        /* renamed from: a */
        public void mo25314a(C8533b spsData) {
            this.f17332d.append(spsData.f18847d, spsData);
        }

        /* renamed from: a */
        public void mo25313a(C8532a ppsData) {
            this.f17333e.append(ppsData.f18841a, ppsData);
        }

        /* renamed from: b */
        public void mo25318b() {
            this.f17339k = false;
            this.f17343o = false;
            this.f17342n.mo25319a();
        }

        /* renamed from: a */
        public void mo25312a(long position, int type, long pesTimeUs) {
            this.f17337i = type;
            this.f17340l = pesTimeUs;
            this.f17338j = position;
            if (!this.f17330b || this.f17337i != 1) {
                if (this.f17331c) {
                    int i = this.f17337i;
                    if (!(i == 5 || i == 1 || i == 2)) {
                        return;
                    }
                } else {
                    return;
                }
            }
            C8239a newSliceHeader = this.f17341m;
            this.f17341m = this.f17342n;
            this.f17342n = newSliceHeader;
            this.f17342n.mo25319a();
            this.f17336h = 0;
            this.f17339k = true;
        }

        /* renamed from: a */
        public void mo25315a(byte[] data, int offset, int limit) {
            boolean bottomFieldFlag;
            boolean bottomFieldFlagPresent;
            int idrPicId;
            int deltaPicOrderCnt1;
            int deltaPicOrderCnt0;
            int deltaPicOrderCntBottom;
            int picOrderCntLsb;
            int i = offset;
            if (this.f17339k) {
                int readLength = limit - i;
                byte[] bArr = this.f17335g;
                int length = bArr.length;
                int i2 = this.f17336h;
                if (length < i2 + readLength) {
                    this.f17335g = Arrays.copyOf(bArr, (i2 + readLength) * 2);
                }
                System.arraycopy(data, i, this.f17335g, this.f17336h, readLength);
                this.f17336h += readLength;
                this.f17334f.mo26140a(this.f17335g, 0, this.f17336h);
                if (this.f17334f.mo26142a(8)) {
                    this.f17334f.mo26148e();
                    int nalRefIdc = this.f17334f.mo26143b(2);
                    this.f17334f.mo26146c(5);
                    if (this.f17334f.mo26141a()) {
                        this.f17334f.mo26147d();
                        if (this.f17334f.mo26141a()) {
                            int sliceType = this.f17334f.mo26147d();
                            if (!this.f17331c) {
                                this.f17339k = false;
                                this.f17342n.mo25320a(sliceType);
                            } else if (this.f17334f.mo26141a()) {
                                int picParameterSetId = this.f17334f.mo26147d();
                                if (this.f17333e.indexOfKey(picParameterSetId) < 0) {
                                    this.f17339k = false;
                                    return;
                                }
                                C8532a ppsData = (C8532a) this.f17333e.get(picParameterSetId);
                                C8533b spsData = (C8533b) this.f17332d.get(ppsData.f18842b);
                                if (spsData.f18851h) {
                                    if (this.f17334f.mo26142a(2)) {
                                        this.f17334f.mo26146c(2);
                                    } else {
                                        return;
                                    }
                                }
                                if (this.f17334f.mo26142a(spsData.f18853j)) {
                                    boolean fieldPicFlag = false;
                                    int frameNum = this.f17334f.mo26143b(spsData.f18853j);
                                    if (spsData.f18852i) {
                                        bottomFieldFlagPresent = false;
                                        bottomFieldFlag = false;
                                    } else if (this.f17334f.mo26142a(1)) {
                                        fieldPicFlag = this.f17334f.mo26144b();
                                        if (!fieldPicFlag) {
                                            bottomFieldFlagPresent = false;
                                            bottomFieldFlag = false;
                                        } else if (this.f17334f.mo26142a(1)) {
                                            bottomFieldFlagPresent = true;
                                            bottomFieldFlag = this.f17334f.mo26144b();
                                        } else {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                    boolean idrPicFlag = this.f17337i == 5;
                                    if (!idrPicFlag) {
                                        idrPicId = 0;
                                    } else if (this.f17334f.mo26141a()) {
                                        idrPicId = this.f17334f.mo26147d();
                                    } else {
                                        return;
                                    }
                                    int picOrderCntLsb2 = spsData.f18854k;
                                    if (picOrderCntLsb2 == 0) {
                                        if (this.f17334f.mo26142a(spsData.f18855l)) {
                                            picOrderCntLsb = this.f17334f.mo26143b(spsData.f18855l);
                                            if (ppsData.f18843c == 0 || fieldPicFlag) {
                                                deltaPicOrderCntBottom = 0;
                                                deltaPicOrderCnt0 = 0;
                                                deltaPicOrderCnt1 = 0;
                                            } else if (this.f17334f.mo26141a()) {
                                                deltaPicOrderCntBottom = this.f17334f.mo26145c();
                                                deltaPicOrderCnt0 = 0;
                                                deltaPicOrderCnt1 = 0;
                                            } else {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } else if (picOrderCntLsb2 != 1 || spsData.f18856m) {
                                        picOrderCntLsb = 0;
                                        deltaPicOrderCntBottom = 0;
                                        deltaPicOrderCnt0 = 0;
                                        deltaPicOrderCnt1 = 0;
                                    } else if (this.f17334f.mo26141a()) {
                                        int deltaPicOrderCnt02 = this.f17334f.mo26145c();
                                        if (ppsData.f18843c == 0 || fieldPicFlag) {
                                            deltaPicOrderCnt0 = deltaPicOrderCnt02;
                                            picOrderCntLsb = 0;
                                            deltaPicOrderCntBottom = 0;
                                            deltaPicOrderCnt1 = 0;
                                        } else if (this.f17334f.mo26141a()) {
                                            deltaPicOrderCnt0 = deltaPicOrderCnt02;
                                            picOrderCntLsb = 0;
                                            deltaPicOrderCntBottom = 0;
                                            deltaPicOrderCnt1 = this.f17334f.mo26145c();
                                        } else {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                    C8533b bVar = spsData;
                                    C8532a aVar = ppsData;
                                    int i3 = picParameterSetId;
                                    this.f17342n.mo25321a(spsData, nalRefIdc, sliceType, frameNum, picParameterSetId, fieldPicFlag, bottomFieldFlagPresent, bottomFieldFlag, idrPicFlag, idrPicId, picOrderCntLsb, deltaPicOrderCntBottom, deltaPicOrderCnt0, deltaPicOrderCnt1);
                                    this.f17339k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        public boolean mo25317a(long position, int offset, boolean hasOutputFormat, boolean randomAccessIndicator) {
            boolean z = false;
            if (this.f17337i == 9 || (this.f17331c && this.f17342n.m19052a(this.f17341m))) {
                if (hasOutputFormat && this.f17343o) {
                    m19044a(offset + ((int) (position - this.f17338j)));
                }
                this.f17344p = this.f17338j;
                this.f17345q = this.f17340l;
                this.f17346r = false;
                this.f17343o = true;
            }
            boolean treatIFrameAsKeyframe = this.f17330b ? this.f17342n.mo25322b() : randomAccessIndicator;
            boolean z2 = this.f17346r;
            int i = this.f17337i;
            if (i == 5 || (treatIFrameAsKeyframe && i == 1)) {
                z = true;
            }
            this.f17346r = z | z2;
            return this.f17346r;
        }

        /* renamed from: a */
        private void m19044a(int offset) {
            int flags = (int) this.f17346r;
            this.f17329a.mo25339a(this.f17345q, flags, (int) (this.f17338j - this.f17344p), offset, null);
        }
    }

    public C8237o(C8207B seiReader, boolean allowNonIdrKeyframes, boolean detectAccessUnits) {
        this.f17314a = seiReader;
        this.f17315b = allowNonIdrKeyframes;
        this.f17316c = detectAccessUnits;
    }

    /* renamed from: a */
    public void mo25303a() {
        C8531r.m20558a(this.f17321h);
        this.f17317d.mo25330b();
        this.f17318e.mo25330b();
        this.f17319f.mo25330b();
        this.f17324k.mo25318b();
        this.f17320g = 0;
        this.f17327n = false;
    }

    /* renamed from: a */
    public void mo25305a(C8262i extractorOutput, C8219d idGenerator) {
        idGenerator.mo25298a();
        this.f17322i = idGenerator.mo25299b();
        this.f17323j = extractorOutput.mo25351a(idGenerator.mo25300c(), 2);
        this.f17324k = new C8238a(this.f17323j, this.f17315b, this.f17316c);
        this.f17314a.mo25289a(extractorOutput, idGenerator);
    }

    /* renamed from: a */
    public void mo25304a(long pesTimeUs, int flags) {
        this.f17326m = pesTimeUs;
        this.f17327n |= (flags & 2) != 0;
    }

    /* renamed from: a */
    public void mo25306a(C8535t data) {
        C8535t tVar = data;
        int offset = data.mo26113c();
        int limit = data.mo26115d();
        byte[] dataArray = tVar.f18861a;
        this.f17320g += (long) data.mo26104a();
        this.f17323j.mo25341a(tVar, data.mo26104a());
        int offset2 = offset;
        while (true) {
            int nalUnitOffset = C8531r.m20554a(dataArray, offset2, limit, this.f17321h);
            if (nalUnitOffset == limit) {
                m19038a(dataArray, offset2, limit);
                return;
            }
            int nalUnitType = C8531r.m20560b(dataArray, nalUnitOffset);
            int lengthToNalUnit = nalUnitOffset - offset2;
            if (lengthToNalUnit > 0) {
                m19038a(dataArray, offset2, nalUnitOffset);
            }
            int bytesWrittenPastPosition = limit - nalUnitOffset;
            long j = this.f17320g - ((long) bytesWrittenPastPosition);
            m19036a(j, bytesWrittenPastPosition, lengthToNalUnit < 0 ? -lengthToNalUnit : 0, this.f17326m);
            m19037a(j, nalUnitType, this.f17326m);
            offset2 = nalUnitOffset + 3;
        }
    }

    /* renamed from: b */
    public void mo25307b() {
    }

    /* renamed from: a */
    private void m19037a(long position, int nalUnitType, long pesTimeUs) {
        if (!this.f17325l || this.f17324k.mo25316a()) {
            this.f17317d.mo25331b(nalUnitType);
            this.f17318e.mo25331b(nalUnitType);
        }
        this.f17319f.mo25331b(nalUnitType);
        this.f17324k.mo25312a(position, nalUnitType, pesTimeUs);
    }

    /* renamed from: a */
    private void m19038a(byte[] dataArray, int offset, int limit) {
        if (!this.f17325l || this.f17324k.mo25316a()) {
            this.f17317d.mo25327a(dataArray, offset, limit);
            this.f17318e.mo25327a(dataArray, offset, limit);
        }
        this.f17319f.mo25327a(dataArray, offset, limit);
        this.f17324k.mo25315a(dataArray, offset, limit);
    }

    /* renamed from: a */
    private void m19036a(long position, int offset, int discardPadding, long pesTimeUs) {
        int i = discardPadding;
        if (!this.f17325l || this.f17324k.mo25316a()) {
            this.f17317d.mo25329a(i);
            this.f17318e.mo25329a(i);
            if (!this.f17325l) {
                if (this.f17317d.mo25328a() && this.f17318e.mo25328a()) {
                    ArrayList arrayList = new ArrayList();
                    C8245t tVar = this.f17317d;
                    arrayList.add(Arrays.copyOf(tVar.f17431d, tVar.f17432e));
                    C8245t tVar2 = this.f17318e;
                    arrayList.add(Arrays.copyOf(tVar2.f17431d, tVar2.f17432e));
                    C8245t tVar3 = this.f17317d;
                    C8533b spsData = C8531r.m20561b(tVar3.f17431d, 3, tVar3.f17432e);
                    C8245t tVar4 = this.f17318e;
                    C8532a ppsData = C8531r.m20555a(tVar4.f17431d, 3, tVar4.f17432e);
                    C8272q qVar = this.f17323j;
                    String str = this.f17322i;
                    String b = C8518h.m20507b(spsData.f18844a, spsData.f18845b, spsData.f18846c);
                    int i2 = spsData.f18848e;
                    int i3 = spsData.f18849f;
                    ArrayList arrayList2 = arrayList;
                    C8272q qVar2 = qVar;
                    float f = spsData.f18850g;
                    ArrayList arrayList3 = arrayList;
                    C8533b spsData2 = spsData;
                    qVar2.mo25340a(Format.m18246a(str, "video/avc", b, -1, -1, i2, i3, -1.0f, (List<byte[]>) arrayList2, -1, f, (DrmInitData) null));
                    this.f17325l = true;
                    this.f17324k.mo25314a(spsData2);
                    this.f17324k.mo25313a(ppsData);
                    this.f17317d.mo25330b();
                    this.f17318e.mo25330b();
                }
            } else if (this.f17317d.mo25328a()) {
                C8245t tVar5 = this.f17317d;
                this.f17324k.mo25314a(C8531r.m20561b(tVar5.f17431d, 3, tVar5.f17432e));
                this.f17317d.mo25330b();
            } else if (this.f17318e.mo25328a()) {
                C8245t tVar6 = this.f17318e;
                this.f17324k.mo25313a(C8531r.m20555a(tVar6.f17431d, 3, tVar6.f17432e));
                this.f17318e.mo25330b();
            }
        }
        if (this.f17319f.mo25329a(i)) {
            C8245t tVar7 = this.f17319f;
            this.f17328o.mo26109a(this.f17319f.f17431d, C8531r.m20562c(tVar7.f17431d, tVar7.f17432e));
            this.f17328o.mo26118e(4);
            this.f17314a.mo25288a(pesTimeUs, this.f17328o);
        } else {
            long j = pesTimeUs;
        }
        if (this.f17324k.mo25317a(position, offset, this.f17325l, this.f17327n)) {
            this.f17327n = false;
        }
    }
}
