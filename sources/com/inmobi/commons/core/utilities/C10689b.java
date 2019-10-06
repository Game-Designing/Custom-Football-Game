package com.inmobi.commons.core.utilities;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.common.Constants;
import java.net.URISyntaxException;
import java.net.URLDecoder;

/* renamed from: com.inmobi.commons.core.utilities.b */
/* compiled from: ClickUrlHandler */
public class C10689b {

    /* renamed from: a */
    private static final String f32616a = C10689b.class.getSimpleName();

    /* renamed from: a */
    public static boolean m35092a(Context context, String str) {
        if (str == null) {
            return false;
        }
        if (context == null) {
            return m35093a(Uri.parse(str));
        }
        try {
            if (new Intent("android.intent.action.VIEW", Uri.parse(str)).resolveActivity(context.getPackageManager()) != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: b */
    public static void m35096b(Context context, String str) throws URISyntaxException, ActivityNotFoundException {
        while (context != null) {
            try {
                Intent parseUri = Intent.parseUri(str, 0);
                parseUri.setFlags(268435456);
                context.startActivity(parseUri);
                return;
            } catch (ActivityNotFoundException e) {
                if (Constants.INTENT_SCHEME.equals(Uri.parse(str).getScheme())) {
                    str = m35095b(str);
                    if (TextUtils.isEmpty(str)) {
                    }
                }
                throw e;
            }
        }
    }

    /* renamed from: a */
    public static String m35091a(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        try {
            Intent parseUri = Intent.parseUri(str, 0);
            if (parseUri.resolveActivity(context.getPackageManager()) != null) {
                parseUri.setFlags(268435456);
                context.startActivity(parseUri);
                return str;
            }
            StringBuilder sb = new StringBuilder("No app can handle the:");
            sb.append(str);
            sb.append(", trying with fallback URL if any");
            if (!TextUtils.isEmpty(str2)) {
                return m35091a(context, str2, null);
            }
            if (Constants.INTENT_SCHEME.equals(Uri.parse(str).getScheme())) {
                String b = m35095b(str);
                if (!TextUtils.isEmpty(b)) {
                    return m35091a(context, URLDecoder.decode(b, "UTF-8"), null);
                }
            }
            return null;
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder("No app can handle the url:");
            sb2.append(str);
            sb2.append(", Log : ");
            sb2.append(e.getMessage());
        }
    }

    /* renamed from: b */
    private static String m35095b(String str) {
        try {
            return Intent.parseUri(str, 1).getStringExtra("browser_fallback_url");
        } catch (URISyntaxException e) {
            new StringBuilder("Exception while getting Fallback Url :").append(e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m35093a(Uri uri) {
        if (!Constants.HTTP.equals(uri.getScheme())) {
            if (!"https".equals(uri.getScheme())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m35094a(String str) {
        Uri parse = Uri.parse(str);
        if (m35093a(parse)) {
            if (!"play.google.com".equals(parse.getHost())) {
                if (!"market.android.com".equals(parse.getHost())) {
                    if (!"market".equals(parse.getScheme())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
