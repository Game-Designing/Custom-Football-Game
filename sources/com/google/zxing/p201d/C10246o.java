package com.google.zxing.p201d;

import com.google.zxing.C10197a;
import com.google.zxing.C10211c;
import com.google.zxing.C10275g;
import com.google.zxing.WriterException;
import com.google.zxing.p198b.C10209b;
import java.util.Map;

/* renamed from: com.google.zxing.d.o */
/* compiled from: OneDimensionalCodeWriter */
public abstract class C10246o implements C10275g {
    /* renamed from: a */
    public abstract boolean[] mo33598a(String str);

    /* renamed from: a */
    public C10209b mo33488a(String contents, C10197a format, int width, int height, Map<C10211c, ?> hints) throws WriterException {
        if (contents.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (width < 0 || height < 0) {
            StringBuilder sb = new StringBuilder("Negative size is not allowed. Input: ");
            sb.append(width);
            sb.append('x');
            sb.append(height);
            throw new IllegalArgumentException(sb.toString());
        } else {
            int sidesMargin = mo33599a();
            if (hints != null && hints.containsKey(C10211c.MARGIN)) {
                sidesMargin = Integer.parseInt(hints.get(C10211c.MARGIN).toString());
            }
            return m33384a(mo33598a(contents), width, height, sidesMargin);
        }
    }

    /* renamed from: a */
    private static C10209b m33384a(boolean[] code, int width, int height, int sidesMargin) {
        int length = code.length;
        int inputWidth = length;
        int fullWidth = length + sidesMargin;
        int outputWidth = Math.max(width, fullWidth);
        int outputHeight = Math.max(1, height);
        int multiple = outputWidth / fullWidth;
        int leftPadding = (outputWidth - (inputWidth * multiple)) / 2;
        C10209b output = new C10209b(outputWidth, outputHeight);
        int inputX = 0;
        int outputX = leftPadding;
        while (inputX < inputWidth) {
            if (code[inputX]) {
                output.mo33533a(outputX, 0, multiple, outputHeight);
            }
            inputX++;
            outputX += multiple;
        }
        return output;
    }

    /* renamed from: a */
    protected static int m33383a(boolean[] target, int pos, int[] pattern, boolean startColor) {
        boolean color = startColor;
        int numAdded = 0;
        boolean color2 = color;
        int pos2 = pos;
        for (int len : pattern) {
            int j = 0;
            while (j < len) {
                int pos3 = pos2 + 1;
                target[pos2] = color2;
                j++;
                pos2 = pos3;
            }
            numAdded += len;
            color2 = !color2;
        }
        return numAdded;
    }

    /* renamed from: a */
    public int mo33599a() {
        return 10;
    }
}
