package com.google.zxing.p201d;

import com.google.zxing.C10197a;
import com.google.zxing.C10211c;
import com.google.zxing.WriterException;
import com.google.zxing.p198b.C10209b;
import java.util.Map;

/* renamed from: com.google.zxing.d.t */
/* compiled from: UPCEWriter */
public final class C10251t extends C10249r {
    /* renamed from: a */
    public C10209b mo33488a(String contents, C10197a format, int width, int height, Map<C10211c, ?> hints) throws WriterException {
        if (format == C10197a.UPC_E) {
            return super.mo33488a(contents, format, width, height, hints);
        }
        StringBuilder sb = new StringBuilder("Can only encode UPC_E, but got ");
        sb.append(format);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public boolean[] mo33598a(String contents) {
        if (contents.length() == 8) {
            int parities = C10250s.f31059f[Integer.parseInt(contents.substring(7, 8))];
            boolean[] result = new boolean[51];
            int pos = C10246o.m33383a(result, 0, C10248q.f31054a, true) + 0;
            for (int i = 1; i <= 6; i++) {
                int digit = Integer.parseInt(contents.substring(i, i + 1));
                if (((parities >> (6 - i)) & 1) == 1) {
                    digit += 10;
                }
                pos += C10246o.m33383a(result, pos, C10248q.f31058e[digit], false);
            }
            C10246o.m33383a(result, pos, C10248q.f31056c, false);
            return result;
        }
        StringBuilder sb = new StringBuilder("Requested contents should be 8 digits long, but got ");
        sb.append(contents.length());
        throw new IllegalArgumentException(sb.toString());
    }
}
