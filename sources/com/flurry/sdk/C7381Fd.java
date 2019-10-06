package com.flurry.sdk;

import android.text.TextUtils;
import com.mopub.common.Constants;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

/* renamed from: com.flurry.sdk.Fd */
public final class C7381Fd {

    /* renamed from: a */
    private static final Pattern f14441a = Pattern.compile("/");

    /* renamed from: b */
    private static URI m16311b(String str) {
        try {
            return new URI(str);
        } catch (URISyntaxException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m16310a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        URI b = m16311b(str);
        if (b == null) {
            return false;
        }
        if (b.getScheme() != null) {
            if (!Constants.HTTP.equalsIgnoreCase(b.getScheme())) {
                if (!"https".equalsIgnoreCase(b.getScheme())) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public static String m16309a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (new URI(str).isAbsolute() || TextUtils.isEmpty(str2)) {
                    return str;
                }
                URI uri = new URI(str2);
                StringBuilder sb = new StringBuilder();
                sb.append(uri.getScheme());
                sb.append("://");
                sb.append(uri.getHost());
                sb.append(str);
                return sb.toString();
            } catch (Exception e) {
            }
        }
        return str;
    }
}
