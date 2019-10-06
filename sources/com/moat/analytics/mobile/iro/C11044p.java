package com.moat.analytics.mobile.iro;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.iro.p */
final class C11044p {

    /* renamed from: ˊ */
    private static long f33760 = 9141242330850693853L;
    /* access modifiers changed from: private */

    /* renamed from: ˋ */
    public static String f33761;

    /* renamed from: ˏ */
    private static C11046a f33762 = null;

    /* renamed from: ॱ */
    private static C11047b f33763 = null;

    /* renamed from: com.moat.analytics.mobile.iro.p$a */
    static class C11046a {

        /* renamed from: ˊ */
        String f33765;

        /* renamed from: ˋ */
        String f33766;

        /* renamed from: ˎ */
        Integer f33767;

        /* renamed from: ˏ */
        boolean f33768;

        /* renamed from: ॱ */
        boolean f33769;

        /* renamed from: ᐝ */
        boolean f33770;

        /* synthetic */ C11046a(byte b) {
            this();
        }

        private C11046a() {
            String str = "_unknown_";
            this.f33766 = str;
            this.f33765 = str;
            this.f33767 = Integer.valueOf(-1);
            this.f33768 = false;
            this.f33769 = false;
            this.f33770 = false;
            try {
                Context r0 = C11044p.m36357();
                if (r0 != null) {
                    this.f33770 = true;
                    TelephonyManager telephonyManager = (TelephonyManager) r0.getSystemService("phone");
                    this.f33766 = telephonyManager.getSimOperatorName();
                    this.f33765 = telephonyManager.getNetworkOperatorName();
                    this.f33767 = Integer.valueOf(telephonyManager.getPhoneType());
                    this.f33768 = C11044p.m36356();
                    this.f33769 = C11044p.m36360(r0);
                }
            } catch (Exception e) {
                C11043o.m36351(e);
            }
        }
    }

    /* renamed from: com.moat.analytics.mobile.iro.p$b */
    static class C11047b {

        /* renamed from: ˋ */
        private String f33771;

        /* renamed from: ˎ */
        private String f33772;

        /* renamed from: ˏ */
        private String f33773;
        /* access modifiers changed from: private */

        /* renamed from: ॱ */
        public boolean f33774;

        /* synthetic */ C11047b(byte b) {
            this();
        }

        private C11047b() {
            this.f33774 = false;
            String str = "_unknown_";
            this.f33772 = str;
            this.f33771 = str;
            this.f33773 = str;
            try {
                Context r0 = C11044p.m36357();
                if (r0 != null) {
                    this.f33774 = true;
                    PackageManager packageManager = r0.getPackageManager();
                    this.f33771 = r0.getPackageName();
                    this.f33772 = packageManager.getApplicationLabel(r0.getApplicationInfo()).toString();
                    this.f33773 = packageManager.getInstallerPackageName(this.f33771);
                    return;
                }
                C11011b.m36234(3, "Util", this, "Can't get app name, appContext is null.");
            } catch (Exception e) {
                C11043o.m36351(e);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: ˏ */
        public final String mo36122() {
            return this.f33772;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: ˋ */
        public final String mo36121() {
            return this.f33771;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: ॱ */
        public final String mo36123() {
            String str = this.f33773;
            return str != null ? str : "_unknown_";
        }
    }

    C11044p() {
    }

    /* renamed from: ॱ */
    static double m36362() {
        try {
            double r1 = (double) m36353();
            double streamMaxVolume = (double) ((AudioManager) C11009a.m36225().getSystemService(m36363("㇕ꍩ߆嗠殛").intern())).getStreamMaxVolume(3);
            Double.isNaN(r1);
            Double.isNaN(streamMaxVolume);
            return r1 / streamMaxVolume;
        } catch (Exception e) {
            C11043o.m36351(e);
            return 0.0d;
        }
    }

    /* renamed from: ʼ */
    private static int m36353() {
        try {
            return ((AudioManager) C11009a.m36225().getSystemService(m36363("㇕ꍩ߆嗠殛").intern())).getStreamVolume(3);
        } catch (Exception e) {
            C11043o.m36351(e);
            return 0;
        }
    }

    /* renamed from: ˊ */
    static void m36355(final Application application) {
        try {
            AsyncTask.execute(new Runnable() {
                public final void run() {
                    try {
                        Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(application);
                        String str = "Util";
                        if (!advertisingIdInfo.isLimitAdTrackingEnabled()) {
                            C11044p.f33761 = advertisingIdInfo.getId();
                            StringBuilder sb = new StringBuilder("Retrieved Advertising ID = ");
                            sb.append(C11044p.f33761);
                            C11011b.m36234(3, str, this, sb.toString());
                            return;
                        }
                        C11011b.m36234(3, str, this, "User has limited ad tracking");
                    } catch (Exception e) {
                        C11043o.m36351(e);
                    }
                }
            });
        } catch (Exception e) {
            C11043o.m36351(e);
        }
    }

    /* renamed from: ॱ */
    private static String m36363(String str) {
        char[] charArray = str.toCharArray();
        char c = charArray[0];
        int i = 1;
        char[] cArr = new char[(charArray.length - 1)];
        while (true) {
            if ((i < charArray.length ? 'K' : 11) != 'K') {
                return new String(cArr);
            }
            cArr[i - 1] = (char) ((int) (((long) (charArray[i] ^ (i * c))) ^ f33760));
            i++;
        }
    }

    /* renamed from: ˏ */
    static String m36361() {
        return f33761;
    }

    /* renamed from: ˋ */
    static Context m36357() {
        WeakReference<Context> weakReference = ((C11031j) MoatAnalytics.getInstance()).f33732;
        if (weakReference != null) {
            return (Context) weakReference.get();
        }
        return null;
    }

    /* renamed from: ˎ */
    static C11047b m36358() {
        C11047b bVar = f33763;
        if (bVar == null || !bVar.f33774) {
            f33763 = new C11047b(0);
        }
        return f33763;
    }

    /* renamed from: ˊ */
    static C11046a m36354() {
        C11046a aVar = f33762;
        if (aVar == null || !aVar.f33770) {
            f33762 = new C11046a(0);
        }
        return f33762;
    }

    /* renamed from: ˎ */
    static boolean m36360(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    /* renamed from: ˊॱ */
    static /* synthetic */ boolean m36356() {
        Context context;
        int i;
        WeakReference<Context> weakReference = ((C11031j) MoatAnalytics.getInstance()).f33732;
        if (weakReference != null) {
            context = (Context) weakReference.get();
        } else {
            context = null;
        }
        if ((context == null ? '9' : 'X') != '9') {
            String str = "涓Ｏ䦟?Ⓨ녧ρ涹︧䢚픆⟨";
            i = (VERSION.SDK_INT < 17 ? 14 : 'J') != 'J' ? Secure.getInt(context.getContentResolver(), m36363(str).intern(), 0) : Global.getInt(context.getContentResolver(), m36363(str).intern(), 0);
        } else {
            i = 0;
        }
        return (i != 1 ? 'c' : '/') != 'c';
    }
}
