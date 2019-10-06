package com.moat.analytics.mobile.vng;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.AsyncTask;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;

/* renamed from: com.moat.analytics.mobile.vng.s */
class C11187s {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f34149a;

    /* renamed from: com.moat.analytics.mobile.vng.s$a */
    static class C11189a {

        /* renamed from: a */
        private boolean f34151a = false;

        /* renamed from: b */
        private String f34152b;

        /* renamed from: c */
        private String f34153c;

        C11189a() {
            String str = "_unknown_";
            this.f34152b = str;
            this.f34153c = str;
        }

        /* renamed from: c */
        private void m36830c() {
            try {
                Context c = C11187s.m36827c();
                if (c != null) {
                    PackageManager packageManager = c.getPackageManager();
                    this.f34153c = c.getPackageName();
                    this.f34152b = packageManager.getApplicationLabel(c.getApplicationInfo()).toString();
                    this.f34151a = true;
                    return;
                }
                C11185p.m36817a(3, "Util", (Object) this, "Can't get app name, appContext is null.");
            } catch (Exception e) {
                C11176m.m36783a(e);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public String mo36383a() {
            if (this.f34151a) {
                return this.f34152b;
            }
            m36830c();
            return this.f34152b;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public String mo36384b() {
            if (this.f34151a) {
                return this.f34153c;
            }
            m36830c();
            return this.f34153c;
        }
    }

    C11187s() {
    }

    /* renamed from: a */
    static double m36823a() {
        try {
            double e = (double) m36829e();
            double streamMaxVolume = (double) ((AudioManager) C11144a.m36673a().getSystemService("audio")).getStreamMaxVolume(3);
            Double.isNaN(e);
            Double.isNaN(streamMaxVolume);
            return e / streamMaxVolume;
        } catch (Exception e2) {
            C11176m.m36783a(e2);
            return 0.0d;
        }
    }

    /* renamed from: a */
    static void m36825a(final Context context) {
        try {
            AsyncTask.execute(new Runnable() {
                public void run() {
                    String str;
                    try {
                        Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                        String str2 = "Util";
                        if (!advertisingIdInfo.isLimitAdTrackingEnabled()) {
                            C11187s.f34149a = advertisingIdInfo.getId();
                            StringBuilder sb = new StringBuilder();
                            sb.append("Retrieved Advertising ID = ");
                            sb.append(C11187s.f34149a);
                            str = sb.toString();
                        } else {
                            str = "User has limited ad tracking";
                        }
                        C11185p.m36817a(3, str2, (Object) this, str);
                    } catch (Exception e) {
                        C11176m.m36783a(e);
                    }
                }
            });
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
    }

    /* renamed from: b */
    static String m36826b() {
        return f34149a;
    }

    /* renamed from: c */
    static Context m36827c() {
        return (Context) ((C11174k) MoatAnalytics.getInstance()).f34123e.get();
    }

    /* renamed from: e */
    private static int m36829e() {
        try {
            return ((AudioManager) C11144a.m36673a().getSystemService("audio")).getStreamVolume(3);
        } catch (Exception e) {
            C11176m.m36783a(e);
            return 0;
        }
    }
}
