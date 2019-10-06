package com.google.zxing.p201d;

import com.google.zxing.C10197a;
import com.google.zxing.C10211c;
import com.google.zxing.WriterException;
import com.google.zxing.p198b.C10209b;
import java.util.Map;

/* renamed from: com.google.zxing.d.h */
/* compiled from: Code93Writer */
public class C10239h extends C10246o {
    /* renamed from: a */
    public C10209b mo33488a(String contents, C10197a format, int width, int height, Map<C10211c, ?> hints) throws WriterException {
        if (format == C10197a.CODE_93) {
            return super.mo33488a(contents, format, width, height, hints);
        }
        StringBuilder sb = new StringBuilder("Can only encode CODE_93, but got ");
        sb.append(format);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public boolean[] mo33598a(String contents) {
        int length = contents.length();
        int length2 = length;
        if (length <= 80) {
            int[] widths = new int[9];
            boolean[] result = new boolean[(((contents.length() + 2 + 2) * 9) + 1)];
            m33374a(C10238g.f31044b[47], widths);
            int pos = m33373a(result, 0, widths, true);
            int i = 0;
            while (true) {
                String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
                if (i < length2) {
                    m33374a(C10238g.f31044b[str.indexOf(contents.charAt(i))], widths);
                    pos += m33373a(result, pos, widths, true);
                    i++;
                } else {
                    int check1 = m33372a(contents, 20);
                    m33374a(C10238g.f31044b[check1], widths);
                    int pos2 = pos + m33373a(result, pos, widths, true);
                    StringBuilder sb = new StringBuilder();
                    sb.append(contents);
                    sb.append(str.charAt(check1));
                    m33374a(C10238g.f31044b[m33372a(sb.toString(), 15)], widths);
                    int pos3 = pos2 + m33373a(result, pos2, widths, true);
                    m33374a(C10238g.f31044b[47], widths);
                    result[pos3 + m33373a(result, pos3, widths, true)] = true;
                    return result;
                }
            }
        } else {
            StringBuilder sb2 = new StringBuilder("Requested contents should be less than 80 digits long, but got ");
            sb2.append(length2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* renamed from: a */
    private static void m33374a(int a, int[] toReturn) {
        for (int i = 0; i < 9; i++) {
            int i2 = 1;
            if (((1 << (8 - i)) & a) == 0) {
                i2 = 0;
            }
            toReturn[i] = i2;
        }
    }

    /* renamed from: a */
    protected static int m33373a(boolean[] target, int pos, int[] pattern, boolean startColor) {
        int length = pattern.length;
        int pos2 = pos;
        int pos3 = 0;
        while (pos3 < length) {
            int pos4 = pos2 + 1;
            target[pos2] = pattern[pos3] != 0;
            pos3++;
            pos2 = pos4;
        }
        return 9;
    }

    /* renamed from: a */
    private static int m33372a(String contents, int maxWeight) {
        int weight = 1;
        int total = 0;
        for (int i = contents.length() - 1; i >= 0; i--) {
            total += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(contents.charAt(i)) * weight;
            weight++;
            if (weight > maxWeight) {
                weight = 1;
            }
        }
        return total % 47;
    }
}
