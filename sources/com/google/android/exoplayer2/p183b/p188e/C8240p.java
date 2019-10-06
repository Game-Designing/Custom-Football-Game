package com.google.android.exoplayer2.p183b.p188e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8531r;
import com.google.android.exoplayer2.util.C8535t;
import com.google.android.exoplayer2.util.C8536u;
import java.util.Collections;

/* renamed from: com.google.android.exoplayer2.b.e.p */
/* compiled from: H265Reader */
public final class C8240p implements C8233l {

    /* renamed from: a */
    private final C8207B f17363a;

    /* renamed from: b */
    private String f17364b;

    /* renamed from: c */
    private C8272q f17365c;

    /* renamed from: d */
    private C8241a f17366d;

    /* renamed from: e */
    private boolean f17367e;

    /* renamed from: f */
    private final boolean[] f17368f = new boolean[3];

    /* renamed from: g */
    private final C8245t f17369g = new C8245t(32, 128);

    /* renamed from: h */
    private final C8245t f17370h = new C8245t(33, 128);

    /* renamed from: i */
    private final C8245t f17371i = new C8245t(34, 128);

    /* renamed from: j */
    private final C8245t f17372j = new C8245t(39, 128);

    /* renamed from: k */
    private final C8245t f17373k = new C8245t(40, 128);

    /* renamed from: l */
    private long f17374l;

    /* renamed from: m */
    private long f17375m;

    /* renamed from: n */
    private final C8535t f17376n = new C8535t();

    /* renamed from: com.google.android.exoplayer2.b.e.p$a */
    /* compiled from: H265Reader */
    private static final class C8241a {

        /* renamed from: a */
        private final C8272q f17377a;

        /* renamed from: b */
        private long f17378b;

        /* renamed from: c */
        private boolean f17379c;

        /* renamed from: d */
        private int f17380d;

        /* renamed from: e */
        private long f17381e;

        /* renamed from: f */
        private boolean f17382f;

        /* renamed from: g */
        private boolean f17383g;

        /* renamed from: h */
        private boolean f17384h;

        /* renamed from: i */
        private boolean f17385i;

        /* renamed from: j */
        private boolean f17386j;

        /* renamed from: k */
        private long f17387k;

        /* renamed from: l */
        private long f17388l;

        /* renamed from: m */
        private boolean f17389m;

        public C8241a(C8272q output) {
            this.f17377a = output;
        }

        /* renamed from: a */
        public void mo25323a() {
            this.f17382f = false;
            this.f17383g = false;
            this.f17384h = false;
            this.f17385i = false;
            this.f17386j = false;
        }

        /* renamed from: a */
        public void mo25325a(long position, int offset, int nalUnitType, long pesTimeUs) {
            boolean z = false;
            this.f17383g = false;
            this.f17384h = false;
            this.f17381e = pesTimeUs;
            this.f17380d = 0;
            this.f17378b = position;
            if (nalUnitType >= 32) {
                if (!this.f17386j && this.f17385i) {
                    m19069a(offset);
                    this.f17385i = false;
                }
                if (nalUnitType <= 34) {
                    this.f17384h = !this.f17386j;
                    this.f17386j = true;
                }
            }
            this.f17379c = nalUnitType >= 16 && nalUnitType <= 21;
            if (this.f17379c || nalUnitType <= 9) {
                z = true;
            }
            this.f17382f = z;
        }

        /* renamed from: a */
        public void mo25326a(byte[] data, int offset, int limit) {
            if (this.f17382f) {
                int i = offset + 2;
                int i2 = this.f17380d;
                int headerOffset = i - i2;
                if (headerOffset < limit) {
                    this.f17383g = (data[headerOffset] & 128) != 0;
                    this.f17382f = false;
                    return;
                }
                this.f17380d = i2 + (limit - offset);
            }
        }

        /* renamed from: a */
        public void mo25324a(long position, int offset) {
            if (this.f17386j && this.f17383g) {
                this.f17389m = this.f17379c;
                this.f17386j = false;
            } else if (this.f17384h || this.f17383g) {
                if (this.f17385i) {
                    m19069a(offset + ((int) (position - this.f17378b)));
                }
                this.f17387k = this.f17378b;
                this.f17388l = this.f17381e;
                this.f17385i = true;
                this.f17389m = this.f17379c;
            }
        }

        /* renamed from: a */
        private void m19069a(int offset) {
            int flags = (int) this.f17389m;
            this.f17377a.mo25339a(this.f17388l, flags, (int) (this.f17378b - this.f17387k), offset, null);
        }
    }

    public C8240p(C8207B seiReader) {
        this.f17363a = seiReader;
    }

    /* renamed from: a */
    public void mo25303a() {
        C8531r.m20558a(this.f17368f);
        this.f17369g.mo25330b();
        this.f17370h.mo25330b();
        this.f17371i.mo25330b();
        this.f17372j.mo25330b();
        this.f17373k.mo25330b();
        this.f17366d.mo25323a();
        this.f17374l = 0;
    }

    /* renamed from: a */
    public void mo25305a(C8262i extractorOutput, C8219d idGenerator) {
        idGenerator.mo25298a();
        this.f17364b = idGenerator.mo25299b();
        this.f17365c = extractorOutput.mo25351a(idGenerator.mo25300c(), 2);
        this.f17366d = new C8241a(this.f17365c);
        this.f17363a.mo25289a(extractorOutput, idGenerator);
    }

    /* renamed from: a */
    public void mo25304a(long pesTimeUs, int flags) {
        this.f17375m = pesTimeUs;
    }

    /* renamed from: a */
    public void mo25306a(C8535t data) {
        C8535t tVar = data;
        while (data.mo26104a() > 0) {
            int offset = data.mo26113c();
            int limit = data.mo26115d();
            byte[] dataArray = tVar.f18861a;
            this.f17374l += (long) data.mo26104a();
            this.f17365c.mo25341a(tVar, data.mo26104a());
            int offset2 = offset;
            while (true) {
                if (offset2 < limit) {
                    int nalUnitOffset = C8531r.m20554a(dataArray, offset2, limit, this.f17368f);
                    if (nalUnitOffset == limit) {
                        m19061a(dataArray, offset2, limit);
                        return;
                    }
                    int nalUnitType = C8531r.m20553a(dataArray, nalUnitOffset);
                    int lengthToNalUnit = nalUnitOffset - offset2;
                    if (lengthToNalUnit > 0) {
                        m19061a(dataArray, offset2, nalUnitOffset);
                    }
                    int bytesWrittenPastPosition = limit - nalUnitOffset;
                    long j = this.f17374l - ((long) bytesWrittenPastPosition);
                    int i = bytesWrittenPastPosition;
                    m19059a(j, i, lengthToNalUnit < 0 ? -lengthToNalUnit : 0, this.f17375m);
                    m19062b(j, i, nalUnitType, this.f17375m);
                    offset2 = nalUnitOffset + 3;
                }
            }
        }
    }

    /* renamed from: b */
    public void mo25307b() {
    }

    /* renamed from: b */
    private void m19062b(long position, int offset, int nalUnitType, long pesTimeUs) {
        if (this.f17367e) {
            this.f17366d.mo25325a(position, offset, nalUnitType, pesTimeUs);
        } else {
            this.f17369g.mo25331b(nalUnitType);
            this.f17370h.mo25331b(nalUnitType);
            this.f17371i.mo25331b(nalUnitType);
        }
        this.f17372j.mo25331b(nalUnitType);
        this.f17373k.mo25331b(nalUnitType);
    }

    /* renamed from: a */
    private void m19061a(byte[] dataArray, int offset, int limit) {
        if (this.f17367e) {
            this.f17366d.mo25326a(dataArray, offset, limit);
        } else {
            this.f17369g.mo25327a(dataArray, offset, limit);
            this.f17370h.mo25327a(dataArray, offset, limit);
            this.f17371i.mo25327a(dataArray, offset, limit);
        }
        this.f17372j.mo25327a(dataArray, offset, limit);
        this.f17373k.mo25327a(dataArray, offset, limit);
    }

    /* renamed from: a */
    private void m19059a(long position, int offset, int discardPadding, long pesTimeUs) {
        if (this.f17367e) {
            this.f17366d.mo25324a(position, offset);
        } else {
            this.f17369g.mo25329a(discardPadding);
            this.f17370h.mo25329a(discardPadding);
            this.f17371i.mo25329a(discardPadding);
            if (this.f17369g.mo25328a() && this.f17370h.mo25328a() && this.f17371i.mo25328a()) {
                this.f17365c.mo25340a(m19058a(this.f17364b, this.f17369g, this.f17370h, this.f17371i));
                this.f17367e = true;
            }
        }
        if (this.f17372j.mo25329a(discardPadding)) {
            C8245t tVar = this.f17372j;
            this.f17376n.mo26109a(this.f17372j.f17431d, C8531r.m20562c(tVar.f17431d, tVar.f17432e));
            this.f17376n.mo26120f(5);
            this.f17363a.mo25288a(pesTimeUs, this.f17376n);
        }
        if (this.f17373k.mo25329a(discardPadding)) {
            C8245t tVar2 = this.f17373k;
            this.f17376n.mo26109a(this.f17373k.f17431d, C8531r.m20562c(tVar2.f17431d, tVar2.f17432e));
            this.f17376n.mo26120f(5);
            this.f17363a.mo25288a(pesTimeUs, this.f17376n);
        }
    }

    /* renamed from: a */
    private static Format m19058a(String formatId, C8245t vps, C8245t sps, C8245t pps) {
        C8245t tVar = vps;
        C8245t tVar2 = sps;
        C8245t tVar3 = pps;
        int i = tVar.f17432e;
        byte[] csd = new byte[(tVar2.f17432e + i + tVar3.f17432e)];
        System.arraycopy(tVar.f17431d, 0, csd, 0, i);
        System.arraycopy(tVar2.f17431d, 0, csd, tVar.f17432e, tVar2.f17432e);
        System.arraycopy(tVar3.f17431d, 0, csd, tVar.f17432e + tVar2.f17432e, tVar3.f17432e);
        C8536u bitArray = new C8536u(tVar2.f17431d, 0, tVar2.f17432e);
        bitArray.mo26146c(44);
        int maxSubLayersMinus1 = bitArray.mo26143b(3);
        bitArray.mo26148e();
        bitArray.mo26146c(88);
        bitArray.mo26146c(8);
        int toSkip = 0;
        for (int i2 = 0; i2 < maxSubLayersMinus1; i2++) {
            if (bitArray.mo26144b()) {
                toSkip += 89;
            }
            if (bitArray.mo26144b()) {
                toSkip += 8;
            }
        }
        bitArray.mo26146c(toSkip);
        if (maxSubLayersMinus1 > 0) {
            bitArray.mo26146c((8 - maxSubLayersMinus1) * 2);
        }
        bitArray.mo26147d();
        int chromaFormatIdc = bitArray.mo26147d();
        if (chromaFormatIdc == 3) {
            bitArray.mo26148e();
        }
        int picWidthInLumaSamples = bitArray.mo26147d();
        int picHeightInLumaSamples = bitArray.mo26147d();
        if (bitArray.mo26144b()) {
            int confWinLeftOffset = bitArray.mo26147d();
            int confWinRightOffset = bitArray.mo26147d();
            int confWinTopOffset = bitArray.mo26147d();
            int confWinBottomOffset = bitArray.mo26147d();
            int subHeightC = 1;
            int subWidthC = (chromaFormatIdc == 1 || chromaFormatIdc == 2) ? 2 : 1;
            if (chromaFormatIdc == 1) {
                subHeightC = 2;
            }
            picWidthInLumaSamples -= (confWinLeftOffset + confWinRightOffset) * subWidthC;
            picHeightInLumaSamples -= (confWinTopOffset + confWinBottomOffset) * subHeightC;
        }
        bitArray.mo26147d();
        bitArray.mo26147d();
        int log2MaxPicOrderCntLsbMinus4 = bitArray.mo26147d();
        for (int i3 = bitArray.mo26144b() ? 0 : maxSubLayersMinus1; i3 <= maxSubLayersMinus1; i3++) {
            bitArray.mo26147d();
            bitArray.mo26147d();
            bitArray.mo26147d();
        }
        bitArray.mo26147d();
        bitArray.mo26147d();
        bitArray.mo26147d();
        bitArray.mo26147d();
        bitArray.mo26147d();
        bitArray.mo26147d();
        if (bitArray.mo26144b() && bitArray.mo26144b()) {
            m19060a(bitArray);
        }
        bitArray.mo26146c(2);
        if (bitArray.mo26144b()) {
            bitArray.mo26146c(8);
            bitArray.mo26147d();
            bitArray.mo26147d();
            bitArray.mo26148e();
        }
        m19063b(bitArray);
        if (bitArray.mo26144b()) {
            for (int i4 = 0; i4 < bitArray.mo26147d(); i4++) {
                bitArray.mo26146c(log2MaxPicOrderCntLsbMinus4 + 4 + 1);
            }
        }
        bitArray.mo26146c(2);
        float pixelWidthHeightRatio = 1.0f;
        if (bitArray.mo26144b() && bitArray.mo26144b()) {
            int aspectRatioIdc = bitArray.mo26143b(8);
            if (aspectRatioIdc == 255) {
                int sarWidth = bitArray.mo26143b(16);
                int sarHeight = bitArray.mo26143b(16);
                if (!(sarWidth == 0 || sarHeight == 0)) {
                    pixelWidthHeightRatio = ((float) sarWidth) / ((float) sarHeight);
                }
            } else {
                float[] fArr = C8531r.f18838b;
                if (aspectRatioIdc < fArr.length) {
                    pixelWidthHeightRatio = fArr[aspectRatioIdc];
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected aspect_ratio_idc value: ");
                    sb.append(aspectRatioIdc);
                    C8526n.m20534d("H265Reader", sb.toString());
                }
            }
        }
        return Format.m18246a(formatId, "video/hevc", (String) null, -1, -1, picWidthInLumaSamples, picHeightInLumaSamples, -1.0f, Collections.singletonList(csd), -1, pixelWidthHeightRatio, (DrmInitData) null);
    }

    /* renamed from: a */
    private static void m19060a(C8536u bitArray) {
        for (int sizeId = 0; sizeId < 4; sizeId++) {
            int matrixId = 0;
            while (matrixId < 6) {
                if (!bitArray.mo26144b()) {
                    bitArray.mo26147d();
                } else {
                    int coefNum = Math.min(64, 1 << ((sizeId << 1) + 4));
                    if (sizeId > 1) {
                        bitArray.mo26145c();
                    }
                    for (int i = 0; i < coefNum; i++) {
                        bitArray.mo26145c();
                    }
                }
                int coefNum2 = 3;
                if (sizeId != 3) {
                    coefNum2 = 1;
                }
                matrixId += coefNum2;
            }
        }
    }

    /* renamed from: b */
    private static void m19063b(C8536u bitArray) {
        int numShortTermRefPicSets = bitArray.mo26147d();
        boolean interRefPicSetPredictionFlag = false;
        int previousNumDeltaPocs = 0;
        for (int stRpsIdx = 0; stRpsIdx < numShortTermRefPicSets; stRpsIdx++) {
            if (stRpsIdx != 0) {
                interRefPicSetPredictionFlag = bitArray.mo26144b();
            }
            if (interRefPicSetPredictionFlag) {
                bitArray.mo26148e();
                bitArray.mo26147d();
                for (int j = 0; j <= previousNumDeltaPocs; j++) {
                    if (bitArray.mo26144b()) {
                        bitArray.mo26148e();
                    }
                }
            } else {
                int numNegativePics = bitArray.mo26147d();
                int numPositivePics = bitArray.mo26147d();
                previousNumDeltaPocs = numNegativePics + numPositivePics;
                for (int i = 0; i < numNegativePics; i++) {
                    bitArray.mo26147d();
                    bitArray.mo26148e();
                }
                for (int i2 = 0; i2 < numPositivePics; i2++) {
                    bitArray.mo26147d();
                    bitArray.mo26148e();
                }
            }
        }
    }
}
