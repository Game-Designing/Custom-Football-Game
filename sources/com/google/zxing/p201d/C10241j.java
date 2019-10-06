package com.google.zxing.p201d;

import com.google.zxing.C10197a;
import com.google.zxing.C10211c;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.p198b.C10209b;
import java.util.Map;

/* renamed from: com.google.zxing.d.j */
/* compiled from: EAN13Writer */
public final class C10241j extends C10249r {
    /* renamed from: a */
    public C10209b mo33488a(String contents, C10197a format, int width, int height, Map<C10211c, ?> hints) throws WriterException {
        if (format == C10197a.EAN_13) {
            return super.mo33488a(contents, format, width, height, hints);
        }
        StringBuilder sb = new StringBuilder("Can only encode EAN_13, but got ");
        sb.append(format);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public boolean[] mo33598a(String contents) {
        if (contents.length() == 13) {
            try {
                if (C10248q.m33390a(contents)) {
                    int parities = C10240i.f31046f[Integer.parseInt(contents.substring(0, 1))];
                    boolean[] result = new boolean[95];
                    int pos = C10246o.m33383a(result, 0, C10248q.f31054a, true) + 0;
                    for (int i = 1; i <= 6; i++) {
                        int digit = Integer.parseInt(contents.substring(i, i + 1));
                        if (((parities >> (6 - i)) & 1) == 1) {
                            digit += 10;
                        }
                        pos += C10246o.m33383a(result, pos, C10248q.f31058e[digit], false);
                    }
                    int pos2 = pos + C10246o.m33383a(result, pos, C10248q.f31055b, false);
                    for (int i2 = 7; i2 <= 12; i2++) {
                        pos2 += C10246o.m33383a(result, pos2, C10248q.f31057d[Integer.parseInt(contents.substring(i2, i2 + 1))], true);
                    }
                    C10246o.m33383a(result, pos2, C10248q.f31054a, true);
                    return result;
                }
                throw new IllegalArgumentException("Contents do not pass checksum");
            } catch (FormatException e) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            StringBuilder sb = new StringBuilder("Requested contents should be 13 digits long, but got ");
            sb.append(contents.length());
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
