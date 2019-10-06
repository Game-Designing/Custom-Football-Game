package com.google.zxing.p201d;

import com.google.zxing.C10197a;
import com.google.zxing.C10211c;
import com.google.zxing.C10275g;
import com.google.zxing.WriterException;
import com.google.zxing.p198b.C10209b;
import java.util.Map;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.google.zxing.d.p */
/* compiled from: UPCAWriter */
public final class C10247p implements C10275g {

    /* renamed from: a */
    private final C10241j f31053a = new C10241j();

    /* renamed from: a */
    public C10209b mo33488a(String contents, C10197a format, int width, int height, Map<C10211c, ?> hints) throws WriterException {
        if (format == C10197a.UPC_A) {
            return this.f31053a.mo33488a(m33388a(contents), C10197a.EAN_13, width, height, hints);
        }
        StringBuilder sb = new StringBuilder("Can only encode UPC-A, but got ");
        sb.append(format);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    private static String m33388a(String contents) {
        int length = contents.length();
        int length2 = length;
        if (length == 11) {
            int sum = 0;
            for (int i = 0; i < 11; i++) {
                sum += (contents.charAt(i) - '0') * (i % 2 == 0 ? 3 : 1);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(contents);
            sb.append((1000 - sum) % 10);
            contents = sb.toString();
        } else if (length2 != 12) {
            StringBuilder sb2 = new StringBuilder("Requested contents should be 11 or 12 digits long, but got ");
            sb2.append(contents.length());
            throw new IllegalArgumentException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        sb3.append(contents);
        return sb3.toString();
    }
}
