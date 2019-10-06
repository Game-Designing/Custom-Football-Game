package com.google.zxing.p201d;

import com.google.zxing.C10197a;
import com.google.zxing.C10211c;
import com.google.zxing.WriterException;
import com.google.zxing.p198b.C10209b;
import java.util.Map;

/* renamed from: com.google.zxing.d.f */
/* compiled from: Code39Writer */
public final class C10237f extends C10246o {
    /* renamed from: a */
    public C10209b mo33488a(String contents, C10197a format, int width, int height, Map<C10211c, ?> hints) throws WriterException {
        if (format == C10197a.CODE_39) {
            return super.mo33488a(contents, format, width, height, hints);
        }
        StringBuilder sb = new StringBuilder("Can only encode CODE_39, but got ");
        sb.append(format);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public boolean[] mo33598a(String contents) {
        int length = contents.length();
        int length2 = length;
        if (length <= 80) {
            int[] widths = new int[9];
            int codeWidth = length2 + 25;
            int i = 0;
            while (true) {
                String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";
                if (i < length2) {
                    int indexOf = str.indexOf(contents.charAt(i));
                    int indexInString = indexOf;
                    if (indexOf >= 0) {
                        m33369a(C10236e.f31041a[indexInString], widths);
                        int codeWidth2 = codeWidth;
                        for (int codeWidth3 = 0; codeWidth3 < 9; codeWidth3++) {
                            codeWidth2 += widths[codeWidth3];
                        }
                        i++;
                        codeWidth = codeWidth2;
                    } else {
                        StringBuilder sb = new StringBuilder("Bad contents: ");
                        sb.append(contents);
                        throw new IllegalArgumentException(sb.toString());
                    }
                } else {
                    boolean[] result = new boolean[codeWidth];
                    m33369a(C10236e.f31042b, widths);
                    int pos = C10246o.m33383a(result, 0, widths, true);
                    int[] narrowWhite = {1};
                    int pos2 = pos + C10246o.m33383a(result, pos, narrowWhite, false);
                    for (int i2 = 0; i2 < length2; i2++) {
                        m33369a(C10236e.f31041a[str.indexOf(contents.charAt(i2))], widths);
                        int a = C10246o.m33383a(result, pos2, widths, true) + pos2;
                        pos2 = a + C10246o.m33383a(result, a, narrowWhite, false);
                    }
                    m33369a(C10236e.f31042b, widths);
                    C10246o.m33383a(result, pos2, widths, true);
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
    private static void m33369a(int a, int[] toReturn) {
        for (int i = 0; i < 9; i++) {
            int i2 = 1;
            if (((1 << (8 - i)) & a) != 0) {
                i2 = 2;
            }
            toReturn[i] = i2;
        }
    }
}
