package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.C8531r;
import com.google.android.exoplayer2.util.C8535t;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.video.k */
/* compiled from: HevcConfig */
public final class C8557k {

    /* renamed from: a */
    public final List<byte[]> f18926a;

    /* renamed from: b */
    public final int f18927b;

    /* renamed from: a */
    public static C8557k m20663a(C8535t data) throws ParserException {
        try {
            data.mo26120f(21);
            int lengthSizeMinusOne = data.mo26131q() & 3;
            int numberOfArrays = data.mo26131q();
            int csdLength = 0;
            int csdStartPosition = data.mo26113c();
            for (int i = 0; i < numberOfArrays; i++) {
                data.mo26120f(1);
                int numberOfNalUnits = data.mo26137w();
                for (int j = 0; j < numberOfNalUnits; j++) {
                    int nalUnitLength = data.mo26137w();
                    csdLength += nalUnitLength + 4;
                    data.mo26120f(nalUnitLength);
                }
            }
            data.mo26118e(csdStartPosition);
            byte[] buffer = new byte[csdLength];
            int bufferPosition = 0;
            for (int i2 = 0; i2 < numberOfArrays; i2++) {
                data.mo26120f(1);
                int numberOfNalUnits2 = data.mo26137w();
                for (int j2 = 0; j2 < numberOfNalUnits2; j2++) {
                    int nalUnitLength2 = data.mo26137w();
                    System.arraycopy(C8531r.f18837a, 0, buffer, bufferPosition, C8531r.f18837a.length);
                    int bufferPosition2 = bufferPosition + C8531r.f18837a.length;
                    System.arraycopy(data.f18861a, data.mo26113c(), buffer, bufferPosition2, nalUnitLength2);
                    bufferPosition = bufferPosition2 + nalUnitLength2;
                    data.mo26120f(nalUnitLength2);
                }
            }
            return new C8557k(csdLength == 0 ? null : Collections.singletonList(buffer), lengthSizeMinusOne + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParserException("Error parsing HEVC config", e);
        }
    }

    private C8557k(List<byte[]> initializationData, int nalUnitLengthFieldLength) {
        this.f18926a = initializationData;
        this.f18927b = nalUnitLengthFieldLength;
    }
}
