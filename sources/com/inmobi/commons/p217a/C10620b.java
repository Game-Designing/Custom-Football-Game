package com.inmobi.commons.p217a;

import android.content.Context;
import com.inmobi.commons.core.p221d.C10657c;

/* renamed from: com.inmobi.commons.a.b */
/* compiled from: SdkInfo */
public final class C10620b {
    /* renamed from: a */
    public static String m34851a() {
        char[] charArray;
        String str = "";
        for (char c : "7.2.7".toCharArray()) {
            if (c == '.') {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("T");
                str = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append((char) ((c - '0') + 65));
                str = sb2.toString();
            }
        }
        StringBuilder sb3 = new StringBuilder("pr-SAND-");
        sb3.append(str);
        sb3.append("-20190225");
        return sb3.toString();
    }

    /* renamed from: a */
    public static String m34852a(Context context) {
        return C10657c.m34972a(context, "sdk_version_store").mo34483c("sdk_version");
    }

    /* renamed from: a */
    public static void m34853a(Context context, boolean z) {
        C10657c.m34972a(context, "sdk_version_store").mo34480a("db_deletion_failed", z);
    }
}
