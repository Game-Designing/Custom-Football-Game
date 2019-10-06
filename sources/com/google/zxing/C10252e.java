package com.google.zxing;

import com.google.zxing.p196a.C10198a;
import com.google.zxing.p198b.C10209b;
import com.google.zxing.p199c.C10212a;
import com.google.zxing.p201d.C10232b;
import com.google.zxing.p201d.C10234d;
import com.google.zxing.p201d.C10237f;
import com.google.zxing.p201d.C10239h;
import com.google.zxing.p201d.C10241j;
import com.google.zxing.p201d.C10242k;
import com.google.zxing.p201d.C10244m;
import com.google.zxing.p201d.C10247p;
import com.google.zxing.p201d.C10251t;
import com.google.zxing.p202e.C10253a;
import com.google.zxing.p204f.C10262a;
import java.util.Map;

/* renamed from: com.google.zxing.e */
/* compiled from: MultiFormatWriter */
public final class C10252e implements C10275g {
    /* renamed from: a */
    public C10209b mo33488a(String contents, C10197a format, int width, int height, Map<C10211c, ?> hints) throws WriterException {
        C10275g writer;
        switch (C10230d.f31027a[format.ordinal()]) {
            case 1:
                writer = new C10242k();
                break;
            case 2:
                writer = new C10251t();
                break;
            case 3:
                writer = new C10241j();
                break;
            case 4:
                writer = new C10247p();
                break;
            case 5:
                writer = new C10262a();
                break;
            case 6:
                writer = new C10237f();
                break;
            case 7:
                writer = new C10239h();
                break;
            case 8:
                writer = new C10234d();
                break;
            case 9:
                writer = new C10244m();
                break;
            case 10:
                writer = new C10253a();
                break;
            case 11:
                writer = new C10232b();
                break;
            case 12:
                writer = new C10212a();
                break;
            case 13:
                writer = new C10198a();
                break;
            default:
                StringBuilder sb = new StringBuilder("No encoder available for format ");
                sb.append(format);
                throw new IllegalArgumentException(sb.toString());
        }
        return writer.mo33488a(contents, format, width, height, hints);
    }
}
