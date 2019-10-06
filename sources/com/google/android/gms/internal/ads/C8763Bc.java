package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.util.SharedPreferencesUtils;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.Bc */
final class C8763Bc implements Callable<String> {

    /* renamed from: a */
    private final /* synthetic */ Context f20493a;

    C8763Bc(zzazm zzazm, Context context) {
        this.f20493a = context;
    }

    public final /* synthetic */ Object call() throws Exception {
        String str = "admob_user_agent";
        SharedPreferences sharedPreferences = this.f20493a.getSharedPreferences(str, 0);
        String str2 = "user_agent";
        String string = sharedPreferences.getString(str2, "");
        if (TextUtils.isEmpty(string)) {
            zzawz.m26003f("User agent is not initialized on Google Play Services. Initializing.");
            String defaultUserAgent = WebSettings.getDefaultUserAgent(this.f20493a);
            SharedPreferencesUtils.m22119a(this.f20493a, sharedPreferences.edit().putString(str2, defaultUserAgent), str);
            return defaultUserAgent;
        }
        zzawz.m26003f("User agent is already initialized on Google Play Services.");
        return string;
    }
}
