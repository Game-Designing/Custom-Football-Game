package p002b.p003c.p053g.p060e;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Locale;

/* renamed from: b.c.g.e.d */
/* compiled from: TextUtilsCompat */
public final class C1251d {

    /* renamed from: a */
    private static final Locale f4022a;

    static {
        String str = "";
        f4022a = new Locale(str, str);
    }

    /* renamed from: a */
    public static int m5875a(Locale locale) {
        if (VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale != null && !locale.equals(f4022a)) {
            String scriptSubtag = C1242a.m5864a(locale);
            if (scriptSubtag == null) {
                return m5876b(locale);
            }
            if (scriptSubtag.equalsIgnoreCase("Arab") || scriptSubtag.equalsIgnoreCase("Hebr")) {
                return 1;
            }
        }
        return 0;
    }

    /* renamed from: b */
    private static int m5876b(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }
}
