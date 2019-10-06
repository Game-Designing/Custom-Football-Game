package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.Pi */
final /* synthetic */ class C9063Pi implements Callable {

    /* renamed from: a */
    private final Context f21585a;

    C9063Pi(Context context) {
        this.f21585a = context;
    }

    public final Object call() {
        CookieManager c = zzk.zzli().mo30259c(this.f21585a);
        if (c != null) {
            return c.getCookie("googleads.g.doubleclick.net");
        }
        return "";
    }
}
