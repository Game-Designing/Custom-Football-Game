package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.facebook.internal.C6694S;
import com.facebook.p127a.C6647y;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;

/* renamed from: com.facebook.O */
/* compiled from: UserSettingsManager */
final class C6557O {

    /* renamed from: a */
    private static final String f11853a = C6557O.class.getName();

    /* renamed from: b */
    private static AtomicBoolean f11854b = new AtomicBoolean(false);

    /* renamed from: c */
    private static C6558a f11855c = new C6558a(true, "com.facebook.sdk.AutoInitEnabled");

    /* renamed from: d */
    private static C6558a f11856d = new C6558a(true, "com.facebook.sdk.AutoLogAppEventsEnabled");
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static C6558a f11857e = new C6558a(true, "com.facebook.sdk.AdvertiserIDCollectionEnabled");
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static C6558a f11858f = new C6558a(false, "auto_event_setup_enabled");

    /* renamed from: g */
    private static SharedPreferences f11859g;

    /* renamed from: h */
    private static Editor f11860h;

    /* renamed from: com.facebook.O$a */
    /* compiled from: UserSettingsManager */
    private static class C6558a {

        /* renamed from: a */
        String f11861a;

        /* renamed from: b */
        Boolean f11862b;

        /* renamed from: c */
        boolean f11863c;

        /* renamed from: d */
        long f11864d;

        C6558a(boolean defaultVal, String key) {
            this.f11863c = defaultVal;
            this.f11861a = key;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo19730a() {
            Boolean bool = this.f11862b;
            return bool == null ? this.f11863c : bool.booleanValue();
        }
    }

    C6557O() {
    }

    /* renamed from: g */
    public static void m12976g() {
        if (C6787r.m13829s() && f11854b.compareAndSet(false, true)) {
            f11859g = C6787r.m13815e().getSharedPreferences("com.facebook.sdk.USER_SETTINGS", 0);
            f11860h = f11859g.edit();
            m12967a(f11856d, f11857e, f11855c);
            m12977h();
            m12979j();
            m12978i();
        }
    }

    /* renamed from: a */
    private static void m12967a(C6558a... userSettings) {
        for (C6558a userSetting : userSettings) {
            if (userSetting == f11858f) {
                m12977h();
            } else if (userSetting.f11862b == null) {
                m12970c(userSetting);
                if (userSetting.f11862b == null) {
                    m12969b(userSetting);
                }
            } else {
                m12972d(userSetting);
            }
        }
    }

    /* renamed from: h */
    private static void m12977h() {
        m12970c(f11858f);
        long currTime = System.currentTimeMillis();
        C6558a aVar = f11858f;
        if (aVar.f11862b == null || currTime - aVar.f11864d >= 604800000) {
            C6558a aVar2 = f11858f;
            aVar2.f11862b = null;
            aVar2.f11864d = 0;
            C6787r.m13822l().execute(new C6556N(currTime));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m12972d(C6558a userSetting) {
        m12980k();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(DonationsAnalytics.VALUE, userSetting.f11862b);
            jsonObject.put("last_timestamp", userSetting.f11864d);
            f11860h.putString(userSetting.f11861a, jsonObject.toString()).commit();
            m12978i();
        } catch (JSONException je) {
            C6694S.m13422a(f11853a, (Exception) je);
        }
    }

    /* renamed from: c */
    private static void m12970c(C6558a userSetting) {
        m12980k();
        try {
            String settingStr = f11859g.getString(userSetting.f11861a, "");
            if (!settingStr.isEmpty()) {
                JSONObject setting = new JSONObject(settingStr);
                userSetting.f11862b = Boolean.valueOf(setting.getBoolean(DonationsAnalytics.VALUE));
                userSetting.f11864d = setting.getLong("last_timestamp");
            }
        } catch (JSONException je) {
            C6694S.m13422a(f11853a, (Exception) je);
        }
    }

    /* renamed from: b */
    private static void m12969b(C6558a userSetting) {
        m12980k();
        try {
            Context ctx = C6787r.m13815e();
            ApplicationInfo ai = ctx.getPackageManager().getApplicationInfo(ctx.getPackageName(), 128);
            if (ai != null && ai.metaData != null && ai.metaData.containsKey(userSetting.f11861a)) {
                userSetting.f11862b = Boolean.valueOf(ai.metaData.getBoolean(userSetting.f11861a, userSetting.f11863c));
            }
        } catch (NameNotFoundException e) {
            C6694S.m13422a(f11853a, (Exception) e);
        }
    }

    /* renamed from: j */
    private static void m12979j() {
        try {
            Context ctx = C6787r.m13815e();
            ApplicationInfo ai = ctx.getPackageManager().getApplicationInfo(ctx.getPackageName(), 128);
            if (ai != null && ai.metaData != null) {
                if (!ai.metaData.containsKey("com.facebook.sdk.AutoLogAppEventsEnabled")) {
                    Log.w(f11853a, "Please set a value for AutoLogAppEventsEnabled. Set the flag to TRUE if you want to collect app install, app launch and in-app purchase events automatically. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
                }
                if (!ai.metaData.containsKey("com.facebook.sdk.AdvertiserIDCollectionEnabled")) {
                    Log.w(f11853a, "You haven't set a value for AdvertiserIDCollectionEnabled. Set the flag to TRUE if you want to collect Advertiser ID for better advertising and analytics results. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
                }
                if (!m12971c()) {
                    Log.w(f11853a, "The value for AdvertiserIDCollectionEnabled is currently set to FALSE so you're sending app events without collecting Advertiser ID. This can affect the quality of your advertising and analytics results.");
                }
            }
        } catch (NameNotFoundException e) {
        }
    }

    /* renamed from: i */
    private static void m12978i() {
        if (f11854b.get() && C6787r.m13829s()) {
            Context ctx = C6787r.m13815e();
            int bit = 0 + 1;
            int bit2 = bit + 1;
            int i = bit2 + 1;
            int bitmask = 0 | ((f11855c.mo19730a() ? 1 : 0) << false) | ((f11856d.mo19730a() ? 1 : 0) << bit) | ((f11857e.mo19730a() ? 1 : 0) << bit2);
            String str = "com.facebook.sdk.USER_SETTINGS_BITMASK";
            int previousBitmask = f11859g.getInt(str, 0);
            if (previousBitmask != bitmask) {
                f11860h.putInt(str, bitmask).commit();
                int initialBitmask = 0;
                int usageBitmask = 0;
                try {
                    ApplicationInfo ai = ctx.getPackageManager().getApplicationInfo(ctx.getPackageName(), 128);
                    if (!(ai == null || ai.metaData == null)) {
                        String[] keys = {"com.facebook.sdk.AutoInitEnabled", "com.facebook.sdk.AutoLogAppEventsEnabled", "com.facebook.sdk.AdvertiserIDCollectionEnabled"};
                        boolean[] defaultValues = {true, true, true};
                        for (int i2 = 0; i2 < keys.length; i2++) {
                            usageBitmask |= (ai.metaData.containsKey(keys[i2]) ? 1 : 0) << i2;
                            initialBitmask |= (ai.metaData.getBoolean(keys[i2], defaultValues[i2]) ? 1 : 0) << i2;
                        }
                    }
                } catch (NameNotFoundException e) {
                }
                C6647y logger = new C6647y(ctx);
                Bundle parameters = new Bundle();
                parameters.putInt("usage", usageBitmask);
                parameters.putInt("initial", initialBitmask);
                parameters.putInt("previous", previousBitmask);
                parameters.putInt("current", bitmask);
                logger.mo19856b("fb_sdk_settings_changed", parameters);
            }
        }
    }

    /* renamed from: k */
    private static void m12980k() {
        if (!f11854b.get()) {
            throw new FacebookSdkNotInitializedException("The UserSettingManager has not been initialized successfully");
        }
    }

    /* renamed from: d */
    public static boolean m12973d() {
        m12976g();
        return f11855c.mo19730a();
    }

    /* renamed from: e */
    public static boolean m12974e() {
        m12976g();
        return f11856d.mo19730a();
    }

    /* renamed from: c */
    public static boolean m12971c() {
        m12976g();
        return f11857e.mo19730a();
    }

    /* renamed from: f */
    public static boolean m12975f() {
        m12976g();
        return f11858f.mo19730a();
    }
}
