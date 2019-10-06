package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.ic */
final /* synthetic */ class C9487ic implements Callable {

    /* renamed from: a */
    private final Context f22539a;

    /* renamed from: b */
    private final WebSettings f22540b;

    C9487ic(Context context, WebSettings webSettings) {
        this.f22539a = context;
        this.f22540b = webSettings;
    }

    public final Object call() {
        Context context = this.f22539a;
        WebSettings webSettings = this.f22540b;
        if (context.getCacheDir() != null) {
            webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
            webSettings.setAppCacheMaxSize(0);
            webSettings.setAppCacheEnabled(true);
        }
        webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setAllowContentAccess(false);
        return Boolean.valueOf(true);
    }
}
