package p024io.realm.internal.android;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p024io.realm.exceptions.RealmException;

/* renamed from: io.realm.internal.android.c */
/* compiled from: JsonUtils */
public class C7321c {

    /* renamed from: a */
    private static Pattern f14285a = Pattern.compile("/Date\\((\\d*)(?:[+-]\\d*)?\\)/");

    /* renamed from: b */
    private static Pattern f14286b = Pattern.compile("-?\\d+");

    /* renamed from: c */
    private static ParsePosition f14287c = new ParsePosition(0);

    /* renamed from: a */
    public static Date m16083a(String date) {
        if (date == null || date.length() == 0) {
            return null;
        }
        Matcher matcher = f14285a.matcher(date);
        if (matcher.find()) {
            return new Date(Long.parseLong(matcher.group(1)));
        }
        if (f14286b.matcher(date).matches()) {
            try {
                return new Date(Long.parseLong(date));
            } catch (NumberFormatException e) {
                throw new RealmException(e.getMessage(), e);
            }
        } else {
            try {
                f14287c.setIndex(0);
                return C7320b.m16081a(date, f14287c);
            } catch (ParseException e2) {
                throw new RealmException(e2.getMessage(), e2);
            }
        }
    }
}
