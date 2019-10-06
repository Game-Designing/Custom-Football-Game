package com.smaato.soma;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.b */
/* compiled from: ActivityIntentHandler */
public class C12142b {
    /* renamed from: a */
    public static boolean m39962a(String url, Context context) {
        Intent intent = m39961a(url);
        if (intent == null || context.getPackageManager().resolveActivity(intent, 0) == null) {
            return false;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
        return true;
    }

    /* renamed from: b */
    public static void m39963b(String url, Context context) {
        Intent intent = m39961a(url);
        if (intent != null && context.getPackageManager().resolveActivity(intent, 0) != null) {
            intent.addFlags(335544320);
            context.startActivity(intent);
        }
    }

    /* renamed from: a */
    private static Intent m39961a(String url) {
        try {
            return new Intent("android.intent.action.VIEW", Uri.parse(url));
        } catch (Exception exception) {
            C12146d.m39965a(new C12147e("SMAATO", exception.getMessage(), C12146d.f38074a, C12143a.EXCEPTION));
            return null;
        }
    }
}
