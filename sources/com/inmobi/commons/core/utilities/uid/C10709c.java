package com.inmobi.commons.core.utilities.uid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.inmobi.commons.core.utilities.C10702f;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.p217a.C10619a;
import java.security.MessageDigest;
import p024io.realm.internal.Collection;

/* renamed from: com.inmobi.commons.core.utilities.uid.c */
/* compiled from: UidHelper */
public class C10709c {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f32669a = C10709c.class.getSimpleName();

    /* renamed from: b */
    private static final Object f32670b = new Object();

    /* renamed from: c */
    private static C10709c f32671c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static C10707a f32672d;

    /* renamed from: a */
    public static C10709c m35160a() {
        C10709c cVar = f32671c;
        if (cVar == null) {
            synchronized (f32670b) {
                cVar = f32671c;
                if (cVar == null) {
                    cVar = new C10709c();
                    f32671c = cVar;
                }
            }
        }
        return cVar;
    }

    private C10709c() {
    }

    /* renamed from: b */
    public final void mo34529b() {
        String str = "limit_ad_tracking";
        try {
            final C10708b bVar = new C10708b();
            C10707a aVar = new C10707a();
            f32672d = aVar;
            aVar.f32666a = bVar.f32668a.mo34483c("adv_id");
            f32672d.f32667b = bVar.f32668a.f32495a.contains(str) ? Boolean.valueOf(bVar.f32668a.mo34482b(str, true)) : null;
            if (C10702f.m35151a("root") && m35169j()) {
                new Thread(new Runnable() {
                    public final void run() {
                        try {
                            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(C10619a.m34839b());
                            String id = advertisingIdInfo.getId();
                            boolean isLimitAdTrackingEnabled = advertisingIdInfo.isLimitAdTrackingEnabled();
                            C10709c.f32672d.f32666a = id;
                            bVar.f32668a.mo34479a("adv_id", id);
                            C10709c.f32672d.f32667b = Boolean.valueOf(isLimitAdTrackingEnabled);
                            bVar.f32668a.mo34480a("limit_ad_tracking", isLimitAdTrackingEnabled);
                        } catch (Exception e) {
                            C10709c.f32669a;
                            new StringBuilder("SDK encountered unexpected error in trying to set the advertising ID ").append(e.getMessage());
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in setting the advertising ID; ").append(e.getMessage());
        }
    }

    /* renamed from: c */
    public static void m35162c() {
        try {
            String str = "Publisher device Id is ";
            if (C10702f.m35151a("root")) {
                C10707a aVar = f32672d;
                if (aVar != null) {
                    String str2 = aVar.f32666a;
                    if (str2 != null) {
                        InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
                        String str3 = f32669a;
                        StringBuilder sb = new StringBuilder(str);
                        sb.append(str2);
                        Logger.m35065a(internalLogLevel, str3, sb.toString());
                    }
                }
                return;
            }
            String e = m35164e();
            InternalLogLevel internalLogLevel2 = InternalLogLevel.DEBUG;
            String str4 = f32669a;
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append(m35161a(e, "SHA-1"));
            Logger.m35065a(internalLogLevel2, str4, sb2.toString());
        } catch (Exception e2) {
            new StringBuilder("SDK encountered an unexpected error attempting to print the publisher test ID; ").append(e2.getMessage());
        }
    }

    /* renamed from: d */
    public static String m35163d() {
        return "1";
    }

    /* renamed from: a */
    static String m35161a(String str, String str2) {
        if (str != null) {
            try {
                if (!"".equals(str.trim())) {
                    MessageDigest instance = MessageDigest.getInstance(str2);
                    instance.update(str.getBytes());
                    byte[] digest = instance.digest();
                    StringBuffer stringBuffer = new StringBuffer();
                    for (byte b : digest) {
                        stringBuffer.append(Integer.toString((b & 255) + Collection.MODE_EMPTY, 16).substring(1));
                    }
                    return stringBuffer.toString();
                }
            } catch (Exception e) {
                new StringBuilder("SDK encountered an unexpected error attempting to get digested UID; ").append(e.getMessage());
                return null;
            }
        }
        return "TEST_EMULATOR";
    }

    @SuppressLint({"HardwareIds"})
    /* renamed from: e */
    static String m35164e() {
        String str = "android_id";
        Context b = C10619a.m34839b();
        String str2 = "";
        if (b == null) {
            return str2;
        }
        try {
            String string = Secure.getString(b.getContentResolver(), str);
            if (string == null) {
                return System.getString(b.getContentResolver(), str);
            }
            return string;
        } catch (Exception e) {
            return str2;
        }
    }

    /* renamed from: f */
    static C10707a m35165f() {
        return f32672d;
    }

    /* renamed from: j */
    private static boolean m35169j() {
        try {
            AdvertisingIdClient.class.getName();
            return true;
        } catch (NoClassDefFoundError e) {
            return false;
        }
    }

    /* renamed from: g */
    public static Boolean m35166g() {
        m35160a();
        C10707a aVar = f32672d;
        if (aVar == null) {
            return null;
        }
        return aVar.f32667b;
    }
}
