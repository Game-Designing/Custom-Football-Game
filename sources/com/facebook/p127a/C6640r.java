package com.facebook.p127a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.FacebookException;

/* renamed from: com.facebook.a.r */
/* compiled from: AppEventsLoggerImpl */
class C6640r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f12087a;

    /* renamed from: b */
    final /* synthetic */ C6643u f12088b;

    C6640r(Context context, C6643u uVar) {
        this.f12087a = context;
        this.f12088b = uVar;
    }

    public void run() {
        Bundle params = new Bundle();
        String[] classes = {"com.facebook.core.Core", "com.facebook.login.Login", "com.facebook.share.Share", "com.facebook.places.Places", "com.facebook.messenger.Messenger", "com.facebook.applinks.AppLinks", "com.facebook.marketing.Marketing", "com.facebook.all.All", "com.android.billingclient.api.BillingClient", "com.android.vending.billing.IInAppBillingService"};
        String[] keys = {"core_lib_included", "login_lib_included", "share_lib_included", "places_lib_included", "messenger_lib_included", "applinks_lib_included", "marketing_lib_included", "all_lib_included", "billing_client_lib_included", "billing_service_lib_included"};
        if (classes.length == keys.length) {
            int bitmask = 0;
            for (int i = 0; i < classes.length; i++) {
                String className = classes[i];
                String keyName = keys[i];
                try {
                    Class.forName(className);
                    params.putInt(keyName, 1);
                    bitmask |= 1 << i;
                } catch (ClassNotFoundException e) {
                }
            }
            SharedPreferences preferences = this.f12087a.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            String str = "kitsBitmask";
            if (preferences.getInt(str, 0) != bitmask) {
                preferences.edit().putInt(str, bitmask).apply();
                this.f12088b.mo19843a("fb_sdk_initialize", (Double) null, params);
                return;
            }
            return;
        }
        throw new FacebookException("Number of class names and key names should match");
    }
}
