package com.paypal.android.sdk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.paypal.android.sdk.sb */
public class C12004sb extends SimpleDateFormat {

    /* renamed from: a */
    private static final String f37688a = C12004sb.class.getSimpleName();

    public C12004sb() {
        this(TimeZone.getTimeZone("UTC"));
    }

    private C12004sb(TimeZone timeZone) {
        super("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
        setTimeZone(timeZone);
    }

    /* renamed from: a */
    public static Date m39705a(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        String[] strArr = {"yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "yyyy-MM-dd'T'HH:mm:ss'Z'"};
        while (true) {
            String str2 = "'";
            if (i < 4) {
                String str3 = strArr[i];
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str3, Locale.US);
                simpleDateFormat.setLenient(true);
                try {
                    Date parse = simpleDateFormat.parse(str);
                    if (parse != null) {
                        return parse;
                    }
                    i++;
                } catch (ParseException e) {
                    StringBuilder sb = new StringBuilder("unsuccessful attempt to parse date '");
                    sb.append(str);
                    sb.append("': ");
                    sb.append(e.getMessage());
                    sb.append(" while using format:'");
                    sb.append(str3);
                    sb.append(str2);
                }
            } else {
                StringBuilder sb2 = new StringBuilder("couldn't parse '");
                sb2.append(str);
                sb2.append(str2);
                return null;
            }
        }
    }
}
