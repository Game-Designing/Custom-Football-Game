package p019d.p151c.p152a.p153a;

import android.text.TextUtils;
import java.util.Calendar;

/* renamed from: d.c.a.a.c */
/* compiled from: DateValidator */
public class C7273c {

    /* renamed from: a */
    private static final C7273c f14134a = new C7273c(Calendar.getInstance());

    /* renamed from: b */
    private final Calendar f14135b;

    protected C7273c(Calendar calendar) {
        this.f14135b = calendar;
    }

    /* renamed from: a */
    public static boolean m15832a(String month, String year) {
        return f14134a.mo23496b(month, year);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo23496b(String monthString, String yearString) {
        int year;
        if (TextUtils.isEmpty(monthString) || TextUtils.isEmpty(yearString) || !TextUtils.isDigitsOnly(monthString) || !TextUtils.isDigitsOnly(yearString)) {
            return false;
        }
        int month = Integer.parseInt(monthString);
        if (month < 1 || month > 12) {
            return false;
        }
        int currentYear = m15833b();
        int yearLength = yearString.length();
        if (yearLength == 2) {
            year = Integer.parseInt(yearString);
        } else if (yearLength != 4) {
            return false;
        } else {
            year = Integer.parseInt(yearString.substring(2));
        }
        if (year == currentYear && month < m15831a()) {
            return false;
        }
        if ((year >= currentYear || (year + 100) - currentYear <= 20) && year <= currentYear + 20) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private int m15831a() {
        return this.f14135b.get(2) + 1;
    }

    /* renamed from: b */
    private int m15833b() {
        return this.f14135b.get(1) % 100;
    }
}
