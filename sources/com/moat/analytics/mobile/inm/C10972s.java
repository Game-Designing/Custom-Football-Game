package com.moat.analytics.mobile.inm;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.mopub.common.GpsHelper;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.inm.s */
class C10972s {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f33542a;

    /* renamed from: b */
    private static C10974a f33543b = null;

    /* renamed from: c */
    private static C10975b f33544c = null;

    /* renamed from: com.moat.analytics.mobile.inm.s$a */
    static class C10974a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public boolean f33546a;

        /* renamed from: b */
        private String f33547b;

        /* renamed from: c */
        private String f33548c;

        /* renamed from: d */
        private String f33549d;

        private C10974a() {
            this.f33546a = false;
            String str = "_unknown_";
            this.f33547b = str;
            this.f33548c = str;
            this.f33549d = str;
            try {
                Context c = C10972s.m36126c();
                if (c != null) {
                    this.f33546a = true;
                    PackageManager packageManager = c.getPackageManager();
                    this.f33548c = c.getPackageName();
                    this.f33547b = packageManager.getApplicationLabel(c.getApplicationInfo()).toString();
                    this.f33549d = packageManager.getInstallerPackageName(this.f33548c);
                    return;
                }
                C10969p.m36113a(3, "Util", (Object) this, "Can't get app name, appContext is null.");
            } catch (Exception e) {
                C10960m.m36077a(e);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public String mo35972a() {
            return this.f33547b;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public String mo35973b() {
            return this.f33548c;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public String mo35974c() {
            String str = this.f33549d;
            return str != null ? str : "_unknown_";
        }
    }

    /* renamed from: com.moat.analytics.mobile.inm.s$b */
    static class C10975b {

        /* renamed from: a */
        String f33550a;

        /* renamed from: b */
        String f33551b;

        /* renamed from: c */
        Integer f33552c;

        /* renamed from: d */
        boolean f33553d;

        /* renamed from: e */
        boolean f33554e;

        /* renamed from: f */
        boolean f33555f;

        private C10975b() {
            String str = "_unknown_";
            this.f33550a = str;
            this.f33551b = str;
            this.f33552c = Integer.valueOf(-1);
            this.f33553d = false;
            this.f33554e = false;
            this.f33555f = false;
            try {
                Context c = C10972s.m36126c();
                if (c != null) {
                    this.f33555f = true;
                    TelephonyManager telephonyManager = (TelephonyManager) c.getSystemService("phone");
                    this.f33550a = telephonyManager.getSimOperatorName();
                    this.f33551b = telephonyManager.getNetworkOperatorName();
                    this.f33552c = Integer.valueOf(telephonyManager.getPhoneType());
                    this.f33553d = C10972s.m36132i();
                    this.f33554e = C10972s.m36125b(c);
                }
            } catch (Exception e) {
                C10960m.m36077a(e);
            }
        }
    }

    C10972s() {
    }

    /* renamed from: a */
    static double m36121a() {
        try {
            double h = (double) m36131h();
            double streamMaxVolume = (double) ((AudioManager) C10929a.m35944a().getSystemService("audio")).getStreamMaxVolume(3);
            Double.isNaN(h);
            Double.isNaN(streamMaxVolume);
            return h / streamMaxVolume;
        } catch (Exception e) {
            C10960m.m36077a(e);
            return 0.0d;
        }
    }

    /* renamed from: a */
    static void m36123a(final Context context) {
        try {
            AsyncTask.execute(new Runnable() {
                public final void run() {
                    String str;
                    String str2 = "Util";
                    try {
                        Class cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                        Class cls2 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
                        Object invoke = cls.getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{context});
                        if (!((Boolean) cls2.getMethod(GpsHelper.IS_LIMIT_AD_TRACKING_ENABLED_KEY, new Class[0]).invoke(invoke, new Object[0])).booleanValue()) {
                            C10972s.f33542a = (String) cls2.getMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
                            StringBuilder sb = new StringBuilder("Retrieved Advertising ID = ");
                            sb.append(C10972s.f33542a);
                            C10969p.m36113a(3, str2, (Object) this, sb.toString());
                            return;
                        }
                        C10969p.m36113a(3, str2, (Object) this, "User has limited ad tracking");
                    } catch (ClassNotFoundException e) {
                        e = e;
                        str = "ClassNotFoundException while retrieving Advertising ID";
                        C10969p.m36115a(str2, (Object) this, str, e);
                    } catch (NoSuchMethodException e2) {
                        e = e2;
                        str = "NoSuchMethodException while retrieving Advertising ID";
                        C10969p.m36115a(str2, (Object) this, str, e);
                    } catch (Exception e3) {
                        C10960m.m36077a(e3);
                    }
                }
            });
        } catch (Exception e) {
            C10960m.m36077a(e);
        }
    }

    /* renamed from: b */
    static String m36124b() {
        return f33542a;
    }

    /* renamed from: b */
    static boolean m36125b(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    /* renamed from: c */
    static Context m36126c() {
        WeakReference<Context> weakReference = ((C10958k) MoatAnalytics.getInstance()).f33510e;
        if (weakReference != null) {
            return (Context) weakReference.get();
        }
        return null;
    }

    /* renamed from: d */
    static C10974a m36127d() {
        C10974a aVar = f33543b;
        if (aVar == null || !aVar.f33546a) {
            f33543b = new C10974a();
        }
        return f33543b;
    }

    /* renamed from: e */
    static C10975b m36128e() {
        C10975b bVar = f33544c;
        if (bVar == null || !bVar.f33555f) {
            f33544c = new C10975b();
        }
        return f33544c;
    }

    /* renamed from: h */
    private static int m36131h() {
        try {
            return ((AudioManager) C10929a.m35944a().getSystemService("audio")).getStreamVolume(3);
        } catch (Exception e) {
            C10960m.m36077a(e);
            return 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static boolean m36132i() {
        int i;
        Context c = m36126c();
        if (c != null) {
            String str = "adb_enabled";
            i = VERSION.SDK_INT >= 17 ? Global.getInt(c.getContentResolver(), str, 0) : Secure.getInt(c.getContentResolver(), str, 0);
        } else {
            i = 0;
        }
        return i == 1;
    }
}
