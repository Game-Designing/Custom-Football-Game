package com.inmobi.commons.core.utilities;

import android.content.Context;
import com.inmobi.commons.core.p222e.C10659b;
import java.util.HashMap;

/* renamed from: com.inmobi.commons.core.utilities.e */
/* compiled from: PermissionUtils */
public final class C10701e {
    /* renamed from: a */
    public static boolean m35150a(Context context, String str, String str2) {
        try {
            return context.checkCallingOrSelfPermission(str2) == 0;
        } catch (Exception e) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("type", "RuntimeException");
                StringBuilder sb = new StringBuilder();
                sb.append(e.getMessage());
                hashMap.put("message", sb.toString());
                C10659b.m34983a();
                C10659b.m34987a(str, "ExceptionCaught", hashMap);
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder("Error in submitting telemetry event : (");
                sb2.append(e.getMessage());
                sb2.append(")");
            }
            return false;
        }
    }
}
