package com.flurry.sdk;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.flurry.sdk.jc */
public class C7543jc {

    /* renamed from: a */
    private final Pattern f14897a = Pattern.compile(".*?(%\\{\\w+\\}).*?");

    /* renamed from: a */
    public final String mo23965a(String str) {
        Matcher matcher = this.f14897a.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    /* renamed from: a */
    protected static boolean m16705a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        StringBuilder sb = new StringBuilder("%{");
        sb.append(str);
        sb.append("}");
        return str2.equals(sb.toString());
    }
}
