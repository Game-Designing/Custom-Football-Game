package com.google.android.exoplayer2.util;

import java.nio.ByteBuffer;
import java.util.Arrays;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.util.r */
/* compiled from: NalUnitUtil */
public final class C8531r {

    /* renamed from: a */
    public static final byte[] f18837a = {0, 0, 0, 1};

    /* renamed from: b */
    public static final float[] f18838b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c */
    private static final Object f18839c = new Object();

    /* renamed from: d */
    private static int[] f18840d = new int[10];

    /* renamed from: com.google.android.exoplayer2.util.r$a */
    /* compiled from: NalUnitUtil */
    public static final class C8532a {

        /* renamed from: a */
        public final int f18841a;

        /* renamed from: b */
        public final int f18842b;

        /* renamed from: c */
        public final boolean f18843c;

        public C8532a(int picParameterSetId, int seqParameterSetId, boolean bottomFieldPicOrderInFramePresentFlag) {
            this.f18841a = picParameterSetId;
            this.f18842b = seqParameterSetId;
            this.f18843c = bottomFieldPicOrderInFramePresentFlag;
        }
    }

    /* renamed from: com.google.android.exoplayer2.util.r$b */
    /* compiled from: NalUnitUtil */
    public static final class C8533b {

        /* renamed from: a */
        public final int f18844a;

        /* renamed from: b */
        public final int f18845b;

        /* renamed from: c */
        public final int f18846c;

        /* renamed from: d */
        public final int f18847d;

        /* renamed from: e */
        public final int f18848e;

        /* renamed from: f */
        public final int f18849f;

        /* renamed from: g */
        public final float f18850g;

        /* renamed from: h */
        public final boolean f18851h;

        /* renamed from: i */
        public final boolean f18852i;

        /* renamed from: j */
        public final int f18853j;

        /* renamed from: k */
        public final int f18854k;

        /* renamed from: l */
        public final int f18855l;

        /* renamed from: m */
        public final boolean f18856m;

        public C8533b(int profileIdc, int constraintsFlagsAndReservedZero2Bits, int levelIdc, int seqParameterSetId, int width, int height, float pixelWidthAspectRatio, boolean separateColorPlaneFlag, boolean frameMbsOnlyFlag, int frameNumLength, int picOrderCountType, int picOrderCntLsbLength, boolean deltaPicOrderAlwaysZeroFlag) {
            this.f18844a = profileIdc;
            this.f18845b = constraintsFlagsAndReservedZero2Bits;
            this.f18846c = levelIdc;
            this.f18847d = seqParameterSetId;
            this.f18848e = width;
            this.f18849f = height;
            this.f18850g = pixelWidthAspectRatio;
            this.f18851h = separateColorPlaneFlag;
            this.f18852i = frameMbsOnlyFlag;
            this.f18853j = frameNumLength;
            this.f18854k = picOrderCountType;
            this.f18855l = picOrderCntLsbLength;
            this.f18856m = deltaPicOrderAlwaysZeroFlag;
        }
    }

    /* renamed from: c */
    public static int m20562c(byte[] data, int limit) {
        int unescapedLength;
        synchronized (f18839c) {
            int position = 0;
            int scratchEscapeCount = 0;
            while (position < limit) {
                try {
                    position = m20563c(data, position, limit);
                    if (position < limit) {
                        if (f18840d.length <= scratchEscapeCount) {
                            f18840d = Arrays.copyOf(f18840d, f18840d.length * 2);
                        }
                        int scratchEscapeCount2 = scratchEscapeCount + 1;
                        f18840d[scratchEscapeCount] = position;
                        position += 3;
                        scratchEscapeCount = scratchEscapeCount2;
                    }
                } finally {
                }
            }
            unescapedLength = limit - scratchEscapeCount;
            int escapedPosition = 0;
            int unescapedPosition = 0;
            for (int i = 0; i < scratchEscapeCount; i++) {
                int copyLength = f18840d[i] - escapedPosition;
                System.arraycopy(data, escapedPosition, data, unescapedPosition, copyLength);
                int unescapedPosition2 = unescapedPosition + copyLength;
                int unescapedPosition3 = unescapedPosition2 + 1;
                data[unescapedPosition2] = 0;
                unescapedPosition = unescapedPosition3 + 1;
                data[unescapedPosition3] = 0;
                escapedPosition += copyLength + 3;
            }
            System.arraycopy(data, escapedPosition, data, unescapedPosition, unescapedLength - unescapedPosition);
        }
        return unescapedLength;
    }

    /* renamed from: a */
    public static void m20557a(ByteBuffer data) {
        int length = data.position();
        int consecutiveZeros = 0;
        for (int offset = 0; offset + 1 < length; offset++) {
            int value = data.get(offset) & 255;
            if (consecutiveZeros == 3) {
                if (value == 1 && (data.get(offset + 1) & 31) == 7) {
                    ByteBuffer offsetData = data.duplicate();
                    offsetData.position(offset - 3);
                    offsetData.limit(length);
                    data.position(0);
                    data.put(offsetData);
                    return;
                }
            } else if (value == 0) {
                consecutiveZeros++;
            }
            if (value != 0) {
                consecutiveZeros = 0;
            }
        }
        data.clear();
    }

    /* renamed from: a */
    public static boolean m20559a(String mimeType, byte nalUnitHeaderFirstByte) {
        if ("video/avc".equals(mimeType) && (nalUnitHeaderFirstByte & 31) == 6) {
            return true;
        }
        if (!"video/hevc".equals(mimeType) || ((nalUnitHeaderFirstByte & 126) >> 1) != 39) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public static int m20560b(byte[] data, int offset) {
        return data[offset + 3] & 31;
    }

    /* renamed from: a */
    public static int m20553a(byte[] data, int offset) {
        return (data[offset + 3] & 126) >> 1;
    }

    /* renamed from: b */
    public static C8533b m20561b(byte[] nalData, int nalOffset, int nalLimit) {
        boolean separateColorPlaneFlag;
        int chromaFormatIdc;
        boolean deltaPicOrderAlwaysZeroFlag;
        int picOrderCntLsbLength;
        int frameHeight;
        int cropUnitX;
        float pixelWidthHeightRatio;
        int cropUnitX2;
        int cropUnitY;
        int picOrderCntLsbLength2;
        C8536u data = new C8536u(nalData, nalOffset, nalLimit);
        data.mo26146c(8);
        int profileIdc = data.mo26143b(8);
        int constraintsFlagsAndReservedZero2Bits = data.mo26143b(8);
        int levelIdc = data.mo26143b(8);
        int seqParameterSetId = data.mo26147d();
        boolean separateColorPlaneFlag2 = false;
        if (profileIdc == 100 || profileIdc == 110 || profileIdc == 122 || profileIdc == 244 || profileIdc == 44 || profileIdc == 83 || profileIdc == 86 || profileIdc == 118 || profileIdc == 128 || profileIdc == 138) {
            int chromaFormatIdc2 = data.mo26147d();
            if (chromaFormatIdc2 == 3) {
                separateColorPlaneFlag2 = data.mo26144b();
            }
            data.mo26147d();
            data.mo26147d();
            data.mo26148e();
            if (data.mo26144b()) {
                int limit = chromaFormatIdc2 != 3 ? 8 : 12;
                int i = 0;
                while (i < limit) {
                    if (data.mo26144b()) {
                        m20556a(data, i < 6 ? 16 : 64);
                    }
                    i++;
                }
            }
            chromaFormatIdc = chromaFormatIdc2;
            separateColorPlaneFlag = separateColorPlaneFlag2;
        } else {
            chromaFormatIdc = 1;
            separateColorPlaneFlag = false;
        }
        int frameNumLength = data.mo26147d() + 4;
        int picOrderCntType = data.mo26147d();
        int picOrderCntLsbLength3 = 0;
        int subHeightC = 1;
        if (picOrderCntType == 0) {
            deltaPicOrderAlwaysZeroFlag = false;
            picOrderCntLsbLength = data.mo26147d() + 4;
        } else if (picOrderCntType == 1) {
            boolean deltaPicOrderAlwaysZeroFlag2 = data.mo26144b();
            data.mo26145c();
            data.mo26145c();
            long numRefFramesInPicOrderCntCycle = (long) data.mo26147d();
            int i2 = 0;
            while (true) {
                picOrderCntLsbLength2 = picOrderCntLsbLength3;
                if (((long) i2) >= numRefFramesInPicOrderCntCycle) {
                    break;
                }
                data.mo26147d();
                i2++;
                picOrderCntLsbLength3 = picOrderCntLsbLength2;
            }
            deltaPicOrderAlwaysZeroFlag = deltaPicOrderAlwaysZeroFlag2;
            picOrderCntLsbLength = picOrderCntLsbLength2;
        } else {
            deltaPicOrderAlwaysZeroFlag = false;
            picOrderCntLsbLength = 0;
        }
        data.mo26147d();
        data.mo26148e();
        int picWidthInMbs = data.mo26147d() + 1;
        int picHeightInMapUnits = data.mo26147d() + 1;
        boolean frameMbsOnlyFlag = data.mo26144b();
        int frameHeightInMbs = (true - frameMbsOnlyFlag) * picHeightInMapUnits;
        if (!frameMbsOnlyFlag) {
            data.mo26148e();
        }
        data.mo26148e();
        int frameWidth = picWidthInMbs * 16;
        int frameHeight2 = frameHeightInMbs * 16;
        if (data.mo26144b()) {
            int frameCropLeftOffset = data.mo26147d();
            int frameCropRightOffset = data.mo26147d();
            int frameCropTopOffset = data.mo26147d();
            int frameCropBottomOffset = data.mo26147d();
            if (chromaFormatIdc == 0) {
                cropUnitY = true - frameMbsOnlyFlag;
                cropUnitX2 = 1;
            } else {
                int subWidthC = chromaFormatIdc == 3 ? 1 : 2;
                if (chromaFormatIdc == 1) {
                    subHeightC = 2;
                }
                cropUnitX2 = subWidthC;
                cropUnitY = (true - frameMbsOnlyFlag) * subHeightC;
            }
            cropUnitX = frameWidth - ((frameCropLeftOffset + frameCropRightOffset) * cropUnitX2);
            frameHeight = frameHeight2 - ((frameCropTopOffset + frameCropBottomOffset) * cropUnitY);
        } else {
            cropUnitX = frameWidth;
            frameHeight = frameHeight2;
        }
        float pixelWidthHeightRatio2 = 1.0f;
        if (data.mo26144b() && data.mo26144b()) {
            int aspectRatioIdc = data.mo26143b(8);
            if (aspectRatioIdc == 255) {
                int sarWidth = data.mo26143b(16);
                int sarHeight = data.mo26143b(16);
                if (!(sarWidth == 0 || sarHeight == 0)) {
                    pixelWidthHeightRatio2 = ((float) sarWidth) / ((float) sarHeight);
                }
                pixelWidthHeightRatio = pixelWidthHeightRatio2;
            } else {
                float[] fArr = f18838b;
                if (aspectRatioIdc < fArr.length) {
                    pixelWidthHeightRatio = fArr[aspectRatioIdc];
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected aspect_ratio_idc value: ");
                    sb.append(aspectRatioIdc);
                    C8526n.m20534d("NalUnitUtil", sb.toString());
                }
            }
            int i3 = chromaFormatIdc;
            int i4 = profileIdc;
            C8533b bVar = new C8533b(profileIdc, constraintsFlagsAndReservedZero2Bits, levelIdc, seqParameterSetId, cropUnitX, frameHeight, pixelWidthHeightRatio, separateColorPlaneFlag, frameMbsOnlyFlag, frameNumLength, picOrderCntType, picOrderCntLsbLength, deltaPicOrderAlwaysZeroFlag);
            return bVar;
        }
        pixelWidthHeightRatio = 1.0f;
        int i32 = chromaFormatIdc;
        int i42 = profileIdc;
        C8533b bVar2 = new C8533b(profileIdc, constraintsFlagsAndReservedZero2Bits, levelIdc, seqParameterSetId, cropUnitX, frameHeight, pixelWidthHeightRatio, separateColorPlaneFlag, frameMbsOnlyFlag, frameNumLength, picOrderCntType, picOrderCntLsbLength, deltaPicOrderAlwaysZeroFlag);
        return bVar2;
    }

    /* renamed from: a */
    public static C8532a m20555a(byte[] nalData, int nalOffset, int nalLimit) {
        C8536u data = new C8536u(nalData, nalOffset, nalLimit);
        data.mo26146c(8);
        int picParameterSetId = data.mo26147d();
        int seqParameterSetId = data.mo26147d();
        data.mo26148e();
        return new C8532a(picParameterSetId, seqParameterSetId, data.mo26144b());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00a2, code lost:
        r5 = true;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m20554a(byte[] r7, int r8, int r9, boolean[] r10) {
        /*
            int r0 = r9 - r8
            r1 = 0
            r2 = 1
            if (r0 < 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            com.google.android.exoplayer2.util.C8514e.m20490b(r3)
            if (r0 != 0) goto L_0x000f
            return r9
        L_0x000f:
            r3 = 2
            if (r10 == 0) goto L_0x0042
            boolean r4 = r10[r1]
            if (r4 == 0) goto L_0x001c
            m20558a(r10)
            int r1 = r8 + -3
            return r1
        L_0x001c:
            if (r0 <= r2) goto L_0x002c
            boolean r4 = r10[r2]
            if (r4 == 0) goto L_0x002c
            byte r4 = r7[r8]
            if (r4 != r2) goto L_0x002c
            m20558a(r10)
            int r1 = r8 + -2
            return r1
        L_0x002c:
            if (r0 <= r3) goto L_0x0042
            boolean r4 = r10[r3]
            if (r4 == 0) goto L_0x0042
            byte r4 = r7[r8]
            if (r4 != 0) goto L_0x0042
            int r4 = r8 + 1
            byte r4 = r7[r4]
            if (r4 != r2) goto L_0x0042
            m20558a(r10)
            int r1 = r8 + -1
            return r1
        L_0x0042:
            int r4 = r9 + -1
            int r5 = r8 + 2
        L_0x0046:
            if (r5 >= r4) goto L_0x006c
            byte r6 = r7[r5]
            r6 = r6 & 254(0xfe, float:3.56E-43)
            if (r6 == 0) goto L_0x004f
            goto L_0x0069
        L_0x004f:
            int r6 = r5 + -2
            byte r6 = r7[r6]
            if (r6 != 0) goto L_0x0067
            int r6 = r5 + -1
            byte r6 = r7[r6]
            if (r6 != 0) goto L_0x0067
            byte r6 = r7[r5]
            if (r6 != r2) goto L_0x0067
            if (r10 == 0) goto L_0x0064
            m20558a(r10)
        L_0x0064:
            int r1 = r5 + -2
            return r1
        L_0x0067:
            int r5 = r5 + -2
        L_0x0069:
            int r5 = r5 + 3
            goto L_0x0046
        L_0x006c:
            if (r10 == 0) goto L_0x00cc
            if (r0 <= r3) goto L_0x0085
            int r5 = r9 + -3
            byte r5 = r7[r5]
            if (r5 != 0) goto L_0x0083
            int r5 = r9 + -2
            byte r5 = r7[r5]
            if (r5 != 0) goto L_0x0083
            int r5 = r9 + -1
            byte r5 = r7[r5]
            if (r5 != r2) goto L_0x0083
            goto L_0x00a2
        L_0x0083:
            r5 = 0
            goto L_0x00a3
        L_0x0085:
            if (r0 != r3) goto L_0x0098
            boolean r5 = r10[r3]
            if (r5 == 0) goto L_0x0083
            int r5 = r9 + -2
            byte r5 = r7[r5]
            if (r5 != 0) goto L_0x0083
            int r5 = r9 + -1
            byte r5 = r7[r5]
            if (r5 != r2) goto L_0x0083
            goto L_0x00a2
        L_0x0098:
            boolean r5 = r10[r2]
            if (r5 == 0) goto L_0x0083
            int r5 = r9 + -1
            byte r5 = r7[r5]
            if (r5 != r2) goto L_0x0083
        L_0x00a2:
            r5 = 1
        L_0x00a3:
            r10[r1] = r5
            if (r0 <= r2) goto L_0x00b4
            int r5 = r9 + -2
            byte r5 = r7[r5]
            if (r5 != 0) goto L_0x00c0
            int r5 = r9 + -1
            byte r5 = r7[r5]
            if (r5 != 0) goto L_0x00c0
            goto L_0x00be
        L_0x00b4:
            boolean r5 = r10[r3]
            if (r5 == 0) goto L_0x00c0
            int r5 = r9 + -1
            byte r5 = r7[r5]
            if (r5 != 0) goto L_0x00c0
        L_0x00be:
            r5 = 1
            goto L_0x00c1
        L_0x00c0:
            r5 = 0
        L_0x00c1:
            r10[r2] = r5
            int r5 = r9 + -1
            byte r5 = r7[r5]
            if (r5 != 0) goto L_0x00ca
            r1 = 1
        L_0x00ca:
            r10[r3] = r1
        L_0x00cc:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.C8531r.m20554a(byte[], int, int, boolean[]):int");
    }

    /* renamed from: a */
    public static void m20558a(boolean[] prefixFlags) {
        prefixFlags[0] = false;
        prefixFlags[1] = false;
        prefixFlags[2] = false;
    }

    /* renamed from: c */
    private static int m20563c(byte[] bytes, int offset, int limit) {
        for (int i = offset; i < limit - 2; i++) {
            if (bytes[i] == 0 && bytes[i + 1] == 0 && bytes[i + 2] == 3) {
                return i;
            }
        }
        return limit;
    }

    /* renamed from: a */
    private static void m20556a(C8536u bitArray, int size) {
        int lastScale = 8;
        int nextScale = 8;
        for (int i = 0; i < size; i++) {
            if (nextScale != 0) {
                nextScale = ((lastScale + bitArray.mo26145c()) + Opcodes.ACC_NATIVE) % Opcodes.ACC_NATIVE;
            }
            lastScale = nextScale == 0 ? lastScale : nextScale;
        }
    }
}
