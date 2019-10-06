package p019d.p273h.p274a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* renamed from: d.h.a.g */
/* compiled from: UrlHandler */
public class C12731g {
    /* renamed from: a */
    public static void m41114a(Context context, String url) throws Exception {
        if (url != null) {
            context.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(url)));
            return;
        }
        throw new Exception("url is null");
    }
}
