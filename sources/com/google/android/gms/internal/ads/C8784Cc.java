package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.Cc */
final class C8784Cc implements Callable<String> {

    /* renamed from: a */
    private final /* synthetic */ Context f20537a;

    /* renamed from: b */
    private final /* synthetic */ Context f20538b;

    C8784Cc(zzazm zzazm, Context context, Context context2) {
        this.f20537a = context;
        this.f20538b = context2;
    }

    public final /* synthetic */ Object call() throws Exception {
        SharedPreferences sharedPreferences;
        String str = "admob_user_agent";
        boolean z = false;
        if (this.f20537a != null) {
            zzawz.m26003f("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.f20537a.getSharedPreferences(str, 0);
        } else {
            zzawz.m26003f("Attempting to read user agent from local cache.");
            sharedPreferences = this.f20538b.getSharedPreferences(str, 0);
            z = true;
        }
        String str2 = "user_agent";
        String string = sharedPreferences.getString(str2, "");
        if (TextUtils.isEmpty(string)) {
            zzawz.m26003f("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.f20538b);
            if (z) {
                sharedPreferences.edit().putString(str2, string).apply();
                zzawz.m26003f("Persisting user agent.");
            }
        }
        return string;
    }
}
