package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.C8518h;
import com.google.android.exoplayer2.util.C8531r;
import com.google.android.exoplayer2.util.C8531r.C8533b;
import com.google.android.exoplayer2.util.C8535t;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.video.h */
/* compiled from: AvcConfig */
public final class C8554h {

    /* renamed from: a */
    public final List<byte[]> f18921a;

    /* renamed from: b */
    public final int f18922b;

    /* renamed from: c */
    public final int f18923c;

    /* renamed from: d */
    public final int f18924d;

    /* renamed from: e */
    public final float f18925e;

    /* renamed from: a */
    public static C8554h m20661a(C8535t data) throws ParserException {
        float pixelWidthAspectRatio;
        int height;
        int width;
        try {
            data.mo26120f(4);
            int nalUnitLengthFieldLength = (data.mo26131q() & 3) + 1;
            if (nalUnitLengthFieldLength != 3) {
                ArrayList arrayList = new ArrayList();
                int numSequenceParameterSets = data.mo26131q() & 31;
                for (int j = 0; j < numSequenceParameterSets; j++) {
                    arrayList.add(m20662b(data));
                }
                int numPictureParameterSets = data.mo26131q();
                for (int j2 = 0; j2 < numPictureParameterSets; j2++) {
                    arrayList.add(m20662b(data));
                }
                if (numSequenceParameterSets > 0) {
                    C8533b spsData = C8531r.m20561b((byte[]) arrayList.get(0), nalUnitLengthFieldLength, ((byte[]) arrayList.get(0)).length);
                    int width2 = spsData.f18848e;
                    width = width2;
                    height = spsData.f18849f;
                    pixelWidthAspectRatio = spsData.f18850g;
                } else {
                    width = -1;
                    height = -1;
                    pixelWidthAspectRatio = 1.0f;
                }
                C8554h hVar = new C8554h(arrayList, nalUnitLengthFieldLength, width, height, pixelWidthAspectRatio);
                return hVar;
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParserException("Error parsing AVC config", e);
        }
    }

    private C8554h(List<byte[]> initializationData, int nalUnitLengthFieldLength, int width, int height, float pixelWidthAspectRatio) {
        this.f18921a = initializationData;
        this.f18922b = nalUnitLengthFieldLength;
        this.f18923c = width;
        this.f18924d = height;
        this.f18925e = pixelWidthAspectRatio;
    }

    /* renamed from: b */
    private static byte[] m20662b(C8535t data) {
        int length = data.mo26137w();
        int offset = data.mo26113c();
        data.mo26120f(length);
        return C8518h.m20505a(data.f18861a, offset, length);
    }
}
