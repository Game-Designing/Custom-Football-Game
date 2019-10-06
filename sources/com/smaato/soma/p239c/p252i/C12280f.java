package com.smaato.soma.p239c.p252i;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.smaato.soma.c.i.f */
/* compiled from: StringUtils */
public class C12280f {
    /* renamed from: b */
    public static String m40429b(String toFormat) {
        try {
            return URLEncoder.encode(toFormat, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public static boolean m40428a(CharSequence str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: a */
    public static String m40425a(CharSequence delimiter, Iterable tokens) {
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = tokens.iterator();
        if (it.hasNext()) {
            sb.append(it.next());
            while (it.hasNext()) {
                sb.append(delimiter);
                sb.append(it.next());
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m40426a(String value) {
        String str = "";
        return value.trim().replace("\r", str).replace("\n", str);
    }

    /* renamed from: a */
    public static String m40427a(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            stringBuilder.append(s);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
