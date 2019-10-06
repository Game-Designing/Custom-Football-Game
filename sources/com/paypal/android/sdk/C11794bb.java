package com.paypal.android.sdk;

import android.content.Context;
import android.util.Log;
import java.util.Collections;
import java.util.concurrent.ExecutorService;

/* renamed from: com.paypal.android.sdk.bb */
public final class C11794bb {

    /* renamed from: a */
    private static final String f37143a = C11794bb.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static C11719Ea f37144b;

    /* renamed from: a */
    public static final synchronized String m39061a(ExecutorService executorService, Context context, String str, String str2, String str3) {
        synchronized (C11794bb.class) {
            if (f37144b == null) {
                try {
                    f37144b = new C11719Ea();
                    String a = f37144b.mo38560a(context, str, str2, Collections.emptyMap());
                    executorService.submit(new C12016vb());
                    StringBuilder sb = new StringBuilder("Init risk component: ");
                    sb.append(f37144b.mo38563c());
                    sb.append(" returning new clientMetadataId:");
                    sb.append(a);
                    return a;
                } catch (Throwable th) {
                    String str4 = "paypal.sdk";
                    StringBuilder sb2 = new StringBuilder("An internal component failed to initialize: ");
                    sb2.append(th.getMessage());
                    Log.e(str4, sb2.toString());
                    return null;
                }
            } else {
                String b = f37144b.mo38562b();
                new StringBuilder("risk component already initialized, returning new clientMetadataId:").append(b);
                return b;
            }
        }
    }
}
