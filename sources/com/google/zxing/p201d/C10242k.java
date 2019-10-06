package com.google.zxing.p201d;

import com.google.zxing.C10197a;
import com.google.zxing.C10211c;
import com.google.zxing.WriterException;
import com.google.zxing.p198b.C10209b;
import java.util.Map;

/* renamed from: com.google.zxing.d.k */
/* compiled from: EAN8Writer */
public final class C10242k extends C10249r {
    /* renamed from: a */
    public C10209b mo33488a(String contents, C10197a format, int width, int height, Map<C10211c, ?> hints) throws WriterException {
        if (format == C10197a.EAN_8) {
            return super.mo33488a(contents, format, width, height, hints);
        }
        StringBuilder sb = new StringBuilder("Can only encode EAN_8, but got ");
        sb.append(format);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public boolean[] mo33598a(String contents) {
        if (contents.length() == 8) {
            boolean[] result = new boolean[67];
            int pos = C10246o.m33383a(result, 0, C10248q.f31054a, true) + 0;
            for (int i = 0; i <= 3; i++) {
                pos += C10246o.m33383a(result, pos, C10248q.f31057d[Integer.parseInt(contents.substring(i, i + 1))], false);
            }
            int pos2 = pos + C10246o.m33383a(result, pos, C10248q.f31055b, false);
            for (int i2 = 4; i2 <= 7; i2++) {
                pos2 += C10246o.m33383a(result, pos2, C10248q.f31057d[Integer.parseInt(contents.substring(i2, i2 + 1))], true);
            }
            C10246o.m33383a(result, pos2, C10248q.f31054a, true);
            return result;
        }
        StringBuilder sb = new StringBuilder("Requested contents should be 8 digits long, but got ");
        sb.append(contents.length());
        throw new IllegalArgumentException(sb.toString());
    }
}
