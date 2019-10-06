package com.moat.analytics.mobile.sma;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.AsyncTask;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;

/* renamed from: com.moat.analytics.mobile.sma.s */
class C11113s {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f33962a;

    /* renamed from: com.moat.analytics.mobile.sma.s$a */
    static class C11115a {

        /* renamed from: a */
        private boolean f33964a = false;

        /* renamed from: b */
        private String f33965b;

        /* renamed from: c */
        private String f33966c;

        C11115a() {
            String str = "_unknown_";
            this.f33965b = str;
            this.f33966c = str;
        }

        /* renamed from: c */
        private void m36590c() {
            try {
                Context c = C11113s.m36587c();
                if (c != null) {
                    PackageManager packageManager = c.getPackageManager();
                    this.f33966c = c.getPackageName();
                    this.f33965b = packageManager.getApplicationLabel(c.getApplicationInfo()).toString();
                    this.f33964a = true;
                    return;
                }
                C11111p.m36577a(3, "Util", (Object) this, "Can't get app name, appContext is null.");
            } catch (Exception e) {
                C11102m.m36543a(e);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public String mo36251a() {
            if (this.f33964a) {
                return this.f33965b;
            }
            m36590c();
            return this.f33965b;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public String mo36252b() {
            if (this.f33964a) {
                return this.f33966c;
            }
            m36590c();
            return this.f33966c;
        }
    }

    C11113s() {
    }

    /* renamed from: a */
    static double m36583a() {
        try {
            double e = (double) m36589e();
            double streamMaxVolume = (double) ((AudioManager) C11073a.m36432a().getSystemService("audio")).getStreamMaxVolume(3);
            Double.isNaN(e);
            Double.isNaN(streamMaxVolume);
            return e / streamMaxVolume;
        } catch (Exception e2) {
            C11102m.m36543a(e2);
            return 0.0d;
        }
    }

    /* renamed from: a */
    static void m36585a(final Context context) {
        try {
            AsyncTask.execute(new Runnable() {
                public void run() {
                    String str;
                    try {
                        Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                        String str2 = "Util";
                        if (!advertisingIdInfo.isLimitAdTrackingEnabled()) {
                            C11113s.f33962a = advertisingIdInfo.getId();
                            StringBuilder sb = new StringBuilder();
                            sb.append("Retrieved Advertising ID = ");
                            sb.append(C11113s.f33962a);
                            str = sb.toString();
                        } else {
                            str = "User has limited ad tracking";
                        }
                        C11111p.m36577a(3, str2, (Object) this, str);
                    } catch (Exception e) {
                        C11102m.m36543a(e);
                    }
                }
            });
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
    }

    /* renamed from: b */
    static String m36586b() {
        return f33962a;
    }

    /* renamed from: c */
    static Context m36587c() {
        return (Context) ((C11100k) MoatAnalytics.getInstance()).f33936e.get();
    }

    /* renamed from: e */
    private static int m36589e() {
        try {
            return ((AudioManager) C11073a.m36432a().getSystemService("audio")).getStreamVolume(3);
        } catch (Exception e) {
            C11102m.m36543a(e);
            return 0;
        }
    }
}
