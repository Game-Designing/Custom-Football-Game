package p019d.p135a.p136a.p142e;

import android.content.Context;
import android.os.Build.VERSION;
import java.util.Locale;

/* renamed from: d.a.a.e.j */
/* compiled from: StringUtils */
public final class C6912j {
    /* renamed from: a */
    public static Locale m14059a(Context context) {
        if (VERSION.SDK_INT >= 24) {
            return context.getResources().getConfiguration().getLocales().get(0);
        }
        return context.getResources().getConfiguration().locale;
    }

    /* renamed from: a */
    public static boolean m14060a(String value) {
        return value == null || m14061b(value);
    }

    /* renamed from: b */
    private static boolean m14061b(String value) {
        return "".equals(value.trim());
    }
}
