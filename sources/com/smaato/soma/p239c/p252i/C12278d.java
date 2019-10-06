package com.smaato.soma.p239c.p252i;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import java.security.MessageDigest;

/* renamed from: com.smaato.soma.c.i.d */
/* compiled from: Converter */
public class C12278d {

    /* renamed from: a */
    private static C12278d f38432a;

    private C12278d() {
    }

    /* renamed from: a */
    public static C12278d m40415a() {
        if (f38432a == null) {
            f38432a = new C12278d();
        }
        return f38432a;
    }

    /* renamed from: a */
    private String m40416a(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 15;
            int two_halfs = 0;
            while (true) {
                if (halfbyte < 0 || halfbyte > 9) {
                    buf.append((char) ((halfbyte - 10) + 97));
                } else {
                    buf.append((char) (halfbyte + 48));
                }
                halfbyte = data[i] & 15;
                int two_halfs2 = two_halfs + 1;
                if (two_halfs >= 1) {
                    break;
                }
                two_halfs = two_halfs2;
            }
        }
        return buf.toString();
    }

    /* renamed from: a */
    public String mo39672a(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(text.getBytes("iso-8859-1"), 0, text.length());
            return m40416a(md.digest());
        } catch (Throwable th) {
            String str = "SOMA Converter";
            String str2 = "Error generating generating SHA-1: ";
            C12147e eVar = new C12147e(str, str2, 1, C12143a.EXCEPTION, th);
            C12146d.m39965a(eVar);
            return null;
        }
    }

    /* renamed from: a */
    public int mo39671a(Context context) {
        return (int) TypedValue.applyDimension(1, 50.0f, context.getResources().getDisplayMetrics());
    }

    /* renamed from: a */
    public int mo39670a(int dp) {
        return (int) (((float) dp) * Resources.getSystem().getDisplayMetrics().density);
    }

    /* renamed from: b */
    public int mo39673b(int pixels) {
        return (int) (((float) pixels) / Resources.getSystem().getDisplayMetrics().density);
    }

    /* renamed from: a */
    public float mo39669a(float px) {
        return px / (((float) Resources.getSystem().getDisplayMetrics().densityDpi) / 160.0f);
    }
}
