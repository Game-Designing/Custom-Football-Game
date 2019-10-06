package com.google.zxing.p201d;

import com.google.zxing.C10197a;
import com.google.zxing.C10211c;
import com.google.zxing.WriterException;
import com.google.zxing.p198b.C10209b;
import java.util.Map;

/* renamed from: com.google.zxing.d.m */
/* compiled from: ITFWriter */
public final class C10244m extends C10246o {

    /* renamed from: a */
    private static final int[] f31051a = {1, 1, 1, 1};

    /* renamed from: b */
    private static final int[] f31052b = {3, 1, 1};

    /* renamed from: a */
    public C10209b mo33488a(String contents, C10197a format, int width, int height, Map<C10211c, ?> hints) throws WriterException {
        if (format == C10197a.ITF) {
            return super.mo33488a(contents, format, width, height, hints);
        }
        StringBuilder sb = new StringBuilder("Can only encode ITF, but got ");
        sb.append(format);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public boolean[] mo33598a(String contents) {
        int length = contents.length();
        int length2 = length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        } else if (length2 <= 80) {
            boolean[] zArr = new boolean[((length2 * 9) + 9)];
            boolean[] result = zArr;
            int pos = C10246o.m33383a(zArr, 0, f31051a, true);
            for (int i = 0; i < length2; i += 2) {
                int one = Character.digit(contents.charAt(i), 10);
                int two = Character.digit(contents.charAt(i + 1), 10);
                int[] encoding = new int[18];
                for (int j = 0; j < 5; j++) {
                    int i2 = j * 2;
                    int[][] iArr = C10243l.f31050d;
                    encoding[i2] = iArr[one][j];
                    encoding[(j * 2) + 1] = iArr[two][j];
                }
                pos += C10246o.m33383a(result, pos, encoding, true);
            }
            C10246o.m33383a(result, pos, f31052b, true);
            return result;
        } else {
            StringBuilder sb = new StringBuilder("Requested contents should be less than 80 digits long, but got ");
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
