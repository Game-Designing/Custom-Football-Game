package com.paypal.android.sdk;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p001v7.widget.LinearLayoutManager;
import android.telephony.TelephonyManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.account.AccountAnalytics;

/* renamed from: com.paypal.android.sdk.u */
public class C12010u implements LocationListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f37757a = C12010u.class.getSimpleName();

    /* renamed from: b */
    private static C12002s f37758b = new C12002s();

    /* renamed from: c */
    public static C11718E f37759c = null;

    /* renamed from: d */
    private static final Object f37760d = new Object();

    /* renamed from: e */
    private static C12010u f37761e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Context f37762f;

    /* renamed from: g */
    private String f37763g;

    /* renamed from: h */
    private long f37764h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f37765i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f37766j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f37767k;

    /* renamed from: l */
    private long f37768l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f37769m;

    /* renamed from: n */
    private C11994q f37770n;

    /* renamed from: o */
    private C12006t f37771o;

    /* renamed from: p */
    private C12006t f37772p;

    /* renamed from: q */
    private String f37773q;

    /* renamed from: r */
    private Map f37774r;

    /* renamed from: s */
    private Location f37775s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public Timer f37776t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public Handler f37777u;

    /* renamed from: v */
    private C12030z f37778v;

    /* renamed from: w */
    private String f37779w;

    /* renamed from: x */
    private String f37780x;

    /* renamed from: y */
    private boolean f37781y;

    /* renamed from: z */
    private String f37782z;

    private C12010u() {
    }

    /* renamed from: a */
    private static long m39717a(Context context) {
        long j = 0;
        if (context == null) {
            return 0;
        }
        try {
            if (VERSION.SDK_INT > 8) {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            }
            String str = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir;
            if (str != null) {
                j = new File(str).lastModified();
            }
            return j;
        } catch (NameNotFoundException e) {
            return 0;
        }
    }

    /* renamed from: a */
    public static C12010u m39718a() {
        C12010u uVar;
        synchronized (f37760d) {
            if (f37761e == null) {
                f37761e = new C12010u();
            }
            uVar = f37761e;
        }
        return uVar;
    }

    /* renamed from: a */
    private static String m39719a(TelephonyManager telephonyManager) {
        try {
            return telephonyManager.getSimOperatorName();
        } catch (SecurityException e) {
            C11754P.m38932a(f37757a, "Known SecurityException on some devices", (Throwable) e);
            return null;
        }
    }

    /* renamed from: a */
    private String m39720a(String str, Map map) {
        String str2;
        this.f37774r = null;
        if (str != null) {
            String str3 = this.f37780x;
            if (str3 != null && str.equals(str3)) {
                return str;
            }
        }
        if (str == null || str.trim().length() == 0) {
            str2 = m39735i();
        } else {
            str2 = str.trim();
            C11754P.m38929a(3, "PRD", "Using custom pairing id");
        }
        this.f37780x = str2;
        mo39196e();
        m39736j();
        return str2;
    }

    /* renamed from: a */
    private static ArrayList m39721a(WifiManager wifiManager) {
        ArrayList arrayList = new ArrayList();
        List scanResults = wifiManager.getScanResults();
        if (scanResults == null || scanResults.size() == 0) {
            return null;
        }
        String bssid = wifiManager.getConnectionInfo().getBSSID();
        int i = -1;
        int i2 = LinearLayoutManager.INVALID_OFFSET;
        for (int i3 = 0; i3 < scanResults.size(); i3++) {
            if (!bssid.equals(((ScanResult) scanResults.get(i3)).BSSID)) {
                int i4 = ((ScanResult) scanResults.get(i3)).level;
                if (i2 < i4) {
                    i = i3;
                    i2 = i4;
                }
            }
        }
        arrayList.add(bssid);
        if (i != -1) {
            arrayList.add(((ScanResult) scanResults.get(i)).BSSID);
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m39722a(C11994q qVar) {
        this.f37770n = qVar;
        C11754P.m38931a(f37757a, "Configuration loaded");
        String str = f37757a;
        StringBuilder sb = new StringBuilder("URL:     ");
        sb.append(this.f37770n.mo39172a());
        C11754P.m38931a(str, sb.toString());
        String str2 = f37757a;
        StringBuilder sb2 = new StringBuilder("Version: ");
        sb2.append(this.f37770n.mo39173b());
        C11754P.m38931a(str2, sb2.toString());
        m39739k();
        this.f37776t = new Timer();
        long c = this.f37770n.mo39174c();
        long d = this.f37770n.mo39175d();
        long e = this.f37770n.mo39176e();
        String str3 = f37757a;
        StringBuilder sb3 = new StringBuilder("Sending logRiskMetadata every ");
        sb3.append(c);
        String str4 = " seconds.";
        sb3.append(str4);
        C11754P.m38931a(str3, sb3.toString());
        String str5 = f37757a;
        StringBuilder sb4 = new StringBuilder("sessionTimeout set to ");
        sb4.append(d);
        sb4.append(str4);
        C11754P.m38931a(str5, sb4.toString());
        String str6 = f37757a;
        StringBuilder sb5 = new StringBuilder("compTimeout set to    ");
        sb5.append(e);
        sb5.append(str4);
        C11754P.m38931a(str6, sb5.toString());
        this.f37764h = c * 1000;
        this.f37765i = e * 1000;
        C12026y.m39770a(d * 1000);
        if (this.f37770n != null && this.f37781y) {
            m39739k();
            this.f37776t = new Timer();
            C11754P.m38931a(f37757a, "Starting LogRiskMetadataTask");
            this.f37776t.scheduleAtFixedRate(new C12014v(this), 0, this.f37764h);
        }
    }

    /* renamed from: a */
    private void m39723a(C12006t tVar, C12006t tVar2) {
        if (tVar != null) {
            tVar.f37735ia = this.f37774r;
            JSONObject a = tVar2 != null ? tVar.mo39189a(tVar2) : tVar.mo39188a();
            HashMap hashMap = new HashMap();
            hashMap.put("appGuid", this.f37763g);
            hashMap.put("libraryVersion", m39728d());
            hashMap.put("additionalData", a.toString());
            String str = f37757a;
            StringBuilder sb = new StringBuilder("Dyson Risk Data ");
            sb.append(a.toString());
            C11754P.m38931a(str, sb.toString());
            C11994q qVar = this.f37770n;
            if (qVar != null) {
                String g = qVar.mo39178g();
                boolean h = this.f37770n.mo39179h();
                String str2 = f37757a;
                StringBuilder sb2 = new StringBuilder("new LogRiskMetadataRequest to: ");
                sb2.append(g);
                C11754P.m38931a(str2, sb2.toString());
                String str3 = f37757a;
                StringBuilder sb3 = new StringBuilder("endpointIsStage: ");
                sb3.append(h);
                sb3.append(" (using SSL: ");
                sb3.append(!h);
                sb3.append(")");
                C11754P.m38931a(str3, sb3.toString());
                C11739K.m38870a().mo38579a(new C11726G(g, hashMap, this.f37777u, !h));
            }
        }
    }

    /* renamed from: b */
    private static long m39725b(Context context) {
        long j = 0;
        if (context == null) {
            return 0;
        }
        try {
            if (VERSION.SDK_INT > 8) {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
            }
            String str = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir;
            if (str != null) {
                j = new File(str).lastModified();
            }
            return j;
        } catch (NameNotFoundException e) {
            return 0;
        }
    }

    /* renamed from: c */
    static /* synthetic */ boolean m39726c(C12010u uVar) {
        return System.currentTimeMillis() - uVar.f37768l > uVar.f37765i;
    }

    /* renamed from: d */
    public static String m39728d() {
        return String.format(Locale.US, "Dyson/%S (%S %S)", new Object[]{"3.5.6.release", "Android", VERSION.RELEASE});
    }

    /* renamed from: f */
    static /* synthetic */ void m39730f(C12010u uVar) {
        String str = "full";
        if (uVar.f37772p != null) {
            String str2 = f37757a;
            StringBuilder sb = new StringBuilder();
            sb.append(uVar.f37773q);
            sb.append(" update not sent correctly, retrying...");
            C11754P.m38931a(str2, sb.toString());
            if (str.equals(uVar.f37773q)) {
                uVar.m39723a(uVar.f37772p, (C12006t) null);
                return;
            }
            uVar.m39723a(uVar.f37772p, uVar.m39740l());
        } else if (!C12026y.m39772c() || uVar.f37771o == null) {
            C12026y.m39769a();
            uVar.f37773q = str;
            C12006t l = uVar.m39740l();
            uVar.m39723a(l, (C12006t) null);
            uVar.f37772p = l;
        } else {
            uVar.f37773q = "incremental";
            C12006t l2 = uVar.m39740l();
            uVar.m39723a(uVar.f37771o, l2);
            uVar.f37772p = l2;
        }
    }

    /* renamed from: i */
    private static String m39735i() {
        return C11754P.m38941b(Boolean.FALSE.booleanValue());
    }

    /* renamed from: j */
    private String m39736j() {
        StringBuilder sb = new StringBuilder("https://b.stats.paypal.com/counter.cgi?p=");
        C12030z zVar = this.f37778v;
        if (zVar == null || zVar == C12030z.UNKNOWN) {
            return "Beacon not recognize host app";
        }
        int a = zVar.mo39219a();
        String str = this.f37780x;
        if (str == null) {
            return "Beacon pairing id empty";
        }
        sb.append(str);
        sb.append("&i=");
        String b = C11754P.m38937b();
        String str2 = "&t=";
        if (b.equals("")) {
            try {
                sb.append(C12002s.m39704a("emptyIp"));
                sb.append(str2);
            } catch (IOException e) {
                C11754P.m38932a(f37757a, "error reading property file", (Throwable) e);
            }
        } else {
            sb.append(b);
            sb.append(str2);
        }
        sb.append(String.valueOf(System.currentTimeMillis() / 1000));
        sb.append("&a=");
        sb.append(a);
        String str3 = f37757a;
        StringBuilder sb2 = new StringBuilder("Beacon Request URL ");
        sb2.append(sb.toString());
        C11754P.m38931a(str3, sb2.toString());
        C11710C c = new C11710C(sb.toString(), this.f37763g, this.f37779w, C11754P.m38921a(this.f37762f), this.f37777u);
        C11739K.m38870a().mo38579a(c);
        return sb.toString();
    }

    /* renamed from: k */
    private void m39739k() {
        Timer timer = this.f37776t;
        if (timer != null) {
            timer.cancel();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01a6 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01b8 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01ca A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01dc A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01ee A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01f0 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0200 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0212 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0224 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0230 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x023c A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x024a A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0258 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0266 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0278 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0286 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0298 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02aa A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x02c1 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x02d2 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x02e4 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x02f0 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x02fe A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0315 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0323 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0333 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x033f A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0359 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x036b A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x037d A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x038b A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0399 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x03b5 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x03cb A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x03e5 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x03f7 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0409 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x045e A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x046e A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x0482 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0492 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x04a0 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x04ae A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d4 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e1 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00eb A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f7 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0103 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x011f A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x012b A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0137 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0153 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0161 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0170 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0182 A[Catch:{ Exception -> 0x04f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0194 A[Catch:{ Exception -> 0x04f1 }] */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.paypal.android.sdk.C12006t m39740l() {
        /*
            r15 = this;
            android.content.Context r0 = r15.f37762f
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            com.paypal.android.sdk.t r0 = new com.paypal.android.sdk.t
            r0.<init>()
            com.paypal.android.sdk.q r2 = r15.f37770n     // Catch:{ Exception -> 0x04f1 }
            com.paypal.android.sdk.N r2 = r2.mo39180i()     // Catch:{ Exception -> 0x04f1 }
            android.content.Context r3 = r15.f37762f     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r4 = "phone"
            java.lang.Object r3 = r3.getSystemService(r4)     // Catch:{ Exception -> 0x04f1 }
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3     // Catch:{ Exception -> 0x04f1 }
            android.content.Context r4 = r15.f37762f     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r5 = "wifi"
            java.lang.Object r4 = r4.getSystemService(r5)     // Catch:{ Exception -> 0x04f1 }
            android.net.wifi.WifiManager r4 = (android.net.wifi.WifiManager) r4     // Catch:{ Exception -> 0x04f1 }
            android.content.Context r5 = r15.f37762f     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r6 = "connectivity"
            java.lang.Object r5 = r5.getSystemService(r6)     // Catch:{ Exception -> 0x04f1 }
            android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5     // Catch:{ Exception -> 0x04f1 }
            android.content.Context r6 = r15.f37762f     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r7 = "android.permission.ACCESS_WIFI_STATE"
            boolean r6 = com.paypal.android.sdk.C11754P.m38934a(r6, r7)     // Catch:{ Exception -> 0x04f1 }
            if (r6 == 0) goto L_0x003e
            android.net.wifi.WifiInfo r6 = r4.getConnectionInfo()     // Catch:{ Exception -> 0x04f1 }
            goto L_0x003f
        L_0x003e:
            r6 = r1
        L_0x003f:
            android.content.Context r7 = r15.f37762f     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r8 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r7 = com.paypal.android.sdk.C11754P.m38934a(r7, r8)     // Catch:{ Exception -> 0x04f1 }
            if (r7 == 0) goto L_0x004e
            android.net.NetworkInfo r5 = r5.getActiveNetworkInfo()     // Catch:{ Exception -> 0x04f1 }
            goto L_0x004f
        L_0x004e:
            r5 = r1
        L_0x004f:
            android.content.Context r7 = r15.f37762f     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r8 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r7 = com.paypal.android.sdk.C11754P.m38934a(r7, r8)     // Catch:{ Exception -> 0x04f1 }
            r8 = 1
            if (r7 != 0) goto L_0x0067
            android.content.Context r7 = r15.f37762f     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r9 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r7 = com.paypal.android.sdk.C11754P.m38934a(r7, r9)     // Catch:{ Exception -> 0x04f1 }
            if (r7 == 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r7 = 0
            goto L_0x0068
        L_0x0067:
            r7 = 1
        L_0x0068:
            android.content.Context r9 = r15.f37762f     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r10 = "android.permission.READ_PHONE_STATE"
            boolean r9 = com.paypal.android.sdk.C11754P.m38934a(r9, r10)     // Catch:{ Exception -> 0x04f1 }
            java.util.Date r10 = new java.util.Date     // Catch:{ Exception -> 0x04f1 }
            r10.<init>()     // Catch:{ Exception -> 0x04f1 }
            int r11 = r3.getPhoneType()     // Catch:{ Exception -> 0x04f1 }
            if (r11 == 0) goto L_0x00d4
            java.lang.String r12 = "Known SecurityException on some devices: "
            if (r11 == r8) goto L_0x00b9
            r13 = 2
            if (r11 == r13) goto L_0x009c
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r12 = "unknown ("
            r11.<init>(r12)     // Catch:{ Exception -> 0x04f1 }
            int r12 = r3.getPhoneType()     // Catch:{ Exception -> 0x04f1 }
            r11.append(r12)     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r12 = ")"
            r11.append(r12)     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x04f1 }
        L_0x0099:
            r0.f37693B = r11     // Catch:{ Exception -> 0x04f1 }
            goto L_0x00d7
        L_0x009c:
            java.lang.String r11 = "cdma"
            r0.f37693B = r11     // Catch:{ Exception -> 0x04f1 }
            if (r7 == 0) goto L_0x00b6
            android.telephony.CellLocation r11 = r3.getCellLocation()     // Catch:{ SecurityException -> 0x00af }
            java.lang.Class<android.telephony.cdma.CdmaCellLocation> r13 = android.telephony.cdma.CdmaCellLocation.class
            java.lang.Object r11 = com.paypal.android.sdk.C11754P.m38922a(r11, r13)     // Catch:{ SecurityException -> 0x00af }
            android.telephony.cdma.CdmaCellLocation r11 = (android.telephony.cdma.CdmaCellLocation) r11     // Catch:{ SecurityException -> 0x00af }
            goto L_0x00b7
        L_0x00af:
            r11 = move-exception
            java.lang.String r13 = f37757a     // Catch:{ Exception -> 0x04f1 }
        L_0x00b2:
            com.paypal.android.sdk.C11754P.m38932a(r13, r12, r11)     // Catch:{ Exception -> 0x04f1 }
            goto L_0x00d7
        L_0x00b6:
            r11 = r1
        L_0x00b7:
            r12 = r1
            goto L_0x00d9
        L_0x00b9:
            java.lang.String r11 = "gsm"
            r0.f37693B = r11     // Catch:{ Exception -> 0x04f1 }
            if (r7 == 0) goto L_0x00d0
            android.telephony.CellLocation r11 = r3.getCellLocation()     // Catch:{ SecurityException -> 0x00cc }
            java.lang.Class<android.telephony.gsm.GsmCellLocation> r13 = android.telephony.gsm.GsmCellLocation.class
            java.lang.Object r11 = com.paypal.android.sdk.C11754P.m38922a(r11, r13)     // Catch:{ SecurityException -> 0x00cc }
            android.telephony.gsm.GsmCellLocation r11 = (android.telephony.gsm.GsmCellLocation) r11     // Catch:{ SecurityException -> 0x00cc }
            goto L_0x00d1
        L_0x00cc:
            r11 = move-exception
            java.lang.String r13 = f37757a     // Catch:{ Exception -> 0x04f1 }
            goto L_0x00b2
        L_0x00d0:
            r11 = r1
        L_0x00d1:
            r12 = r11
            r11 = r1
            goto L_0x00d9
        L_0x00d4:
            java.lang.String r11 = "none"
            goto L_0x0099
        L_0x00d7:
            r11 = r1
            r12 = r11
        L_0x00d9:
            com.paypal.android.sdk.O r13 = com.paypal.android.sdk.C11751O.PPRiskDataPhoneType     // Catch:{ Exception -> 0x04f1 }
            boolean r13 = r2.mo38602a(r13)     // Catch:{ Exception -> 0x04f1 }
            if (r13 != 0) goto L_0x00e3
            r0.f37693B = r1     // Catch:{ Exception -> 0x04f1 }
        L_0x00e3:
            com.paypal.android.sdk.O r13 = com.paypal.android.sdk.C11751O.PPRiskDataAppGuid     // Catch:{ Exception -> 0x04f1 }
            boolean r13 = r2.mo38602a(r13)     // Catch:{ Exception -> 0x04f1 }
            if (r13 == 0) goto L_0x00ef
            java.lang.String r13 = r15.f37763g     // Catch:{ Exception -> 0x04f1 }
            r0.f37718a = r13     // Catch:{ Exception -> 0x04f1 }
        L_0x00ef:
            com.paypal.android.sdk.O r13 = com.paypal.android.sdk.C11751O.PPRiskDataPairingId     // Catch:{ Exception -> 0x04f1 }
            boolean r13 = r2.mo38602a(r13)     // Catch:{ Exception -> 0x04f1 }
            if (r13 == 0) goto L_0x00fb
            java.lang.String r13 = r15.f37780x     // Catch:{ Exception -> 0x04f1 }
            r0.f37713V = r13     // Catch:{ Exception -> 0x04f1 }
        L_0x00fb:
            com.paypal.android.sdk.O r13 = com.paypal.android.sdk.C11751O.PPRiskDataSourceApp     // Catch:{ Exception -> 0x04f1 }
            boolean r13 = r2.mo38602a(r13)     // Catch:{ Exception -> 0x04f1 }
            if (r13 == 0) goto L_0x0117
            com.paypal.android.sdk.z r13 = r15.f37778v     // Catch:{ Exception -> 0x04f1 }
            if (r13 != 0) goto L_0x0110
            com.paypal.android.sdk.z r13 = com.paypal.android.sdk.C12030z.UNKNOWN     // Catch:{ Exception -> 0x04f1 }
            int r13 = r13.mo39219a()     // Catch:{ Exception -> 0x04f1 }
        L_0x010d:
            r0.f37709R = r13     // Catch:{ Exception -> 0x04f1 }
            goto L_0x0117
        L_0x0110:
            com.paypal.android.sdk.z r13 = r15.f37778v     // Catch:{ Exception -> 0x04f1 }
            int r13 = r13.mo39219a()     // Catch:{ Exception -> 0x04f1 }
            goto L_0x010d
        L_0x0117:
            com.paypal.android.sdk.O r13 = com.paypal.android.sdk.C11751O.PPRiskDataSourceAppVersion     // Catch:{ Exception -> 0x04f1 }
            boolean r13 = r2.mo38602a(r13)     // Catch:{ Exception -> 0x04f1 }
            if (r13 == 0) goto L_0x0123
            java.lang.String r13 = r15.f37779w     // Catch:{ Exception -> 0x04f1 }
            r0.f37710S = r13     // Catch:{ Exception -> 0x04f1 }
        L_0x0123:
            com.paypal.android.sdk.O r13 = com.paypal.android.sdk.C11751O.PPRiskDataNotifToken     // Catch:{ Exception -> 0x04f1 }
            boolean r13 = r2.mo38602a(r13)     // Catch:{ Exception -> 0x04f1 }
            if (r13 == 0) goto L_0x012f
            java.lang.String r13 = r15.f37782z     // Catch:{ Exception -> 0x04f1 }
            r0.f37717Z = r13     // Catch:{ Exception -> 0x04f1 }
        L_0x012f:
            com.paypal.android.sdk.O r13 = com.paypal.android.sdk.C11751O.PPRiskDataAndroidId     // Catch:{ Exception -> 0x04f1 }
            boolean r13 = r2.mo38602a(r13)     // Catch:{ Exception -> 0x04f1 }
            if (r13 == 0) goto L_0x0145
            android.content.Context r13 = r15.f37762f     // Catch:{ Exception -> 0x04f1 }
            android.content.ContentResolver r13 = r13.getContentResolver()     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r14 = "android_id"
            java.lang.String r13 = android.provider.Settings.Secure.getString(r13, r14)     // Catch:{ Exception -> 0x04f1 }
            r0.f37716Y = r13     // Catch:{ Exception -> 0x04f1 }
        L_0x0145:
            android.content.Context r13 = r15.f37762f     // Catch:{ Exception -> 0x04f1 }
            com.paypal.android.sdk.p r13 = com.paypal.android.sdk.C11754P.m38921a(r13)     // Catch:{ Exception -> 0x04f1 }
            com.paypal.android.sdk.O r14 = com.paypal.android.sdk.C11751O.PPRiskDataAppId     // Catch:{ Exception -> 0x04f1 }
            boolean r14 = r2.mo38602a(r14)     // Catch:{ Exception -> 0x04f1 }
            if (r14 == 0) goto L_0x0159
            java.lang.String r14 = r13.mo38832a()     // Catch:{ Exception -> 0x04f1 }
            r0.f37720b = r14     // Catch:{ Exception -> 0x04f1 }
        L_0x0159:
            com.paypal.android.sdk.O r14 = com.paypal.android.sdk.C11751O.PPRiskDataAppVersion     // Catch:{ Exception -> 0x04f1 }
            boolean r14 = r2.mo38602a(r14)     // Catch:{ Exception -> 0x04f1 }
            if (r14 == 0) goto L_0x0167
            java.lang.String r13 = r13.mo38834b()     // Catch:{ Exception -> 0x04f1 }
            r0.f37722c = r13     // Catch:{ Exception -> 0x04f1 }
        L_0x0167:
            com.paypal.android.sdk.O r13 = com.paypal.android.sdk.C11751O.PPRiskDataBaseStationId     // Catch:{ Exception -> 0x04f1 }
            boolean r13 = r2.mo38602a(r13)     // Catch:{ Exception -> 0x04f1 }
            r14 = -1
            if (r13 == 0) goto L_0x017a
            if (r11 != 0) goto L_0x0174
            r13 = -1
            goto L_0x0178
        L_0x0174:
            int r13 = r11.getBaseStationId()     // Catch:{ Exception -> 0x04f1 }
        L_0x0178:
            r0.f37724d = r13     // Catch:{ Exception -> 0x04f1 }
        L_0x017a:
            com.paypal.android.sdk.O r13 = com.paypal.android.sdk.C11751O.PPRiskDataCdmaNetworkId     // Catch:{ Exception -> 0x04f1 }
            boolean r13 = r2.mo38602a(r13)     // Catch:{ Exception -> 0x04f1 }
            if (r13 == 0) goto L_0x018c
            if (r11 != 0) goto L_0x0186
            r13 = -1
            goto L_0x018a
        L_0x0186:
            int r13 = r11.getNetworkId()     // Catch:{ Exception -> 0x04f1 }
        L_0x018a:
            r0.f37707P = r13     // Catch:{ Exception -> 0x04f1 }
        L_0x018c:
            com.paypal.android.sdk.O r13 = com.paypal.android.sdk.C11751O.PPRiskDataCdmaSystemId     // Catch:{ Exception -> 0x04f1 }
            boolean r13 = r2.mo38602a(r13)     // Catch:{ Exception -> 0x04f1 }
            if (r13 == 0) goto L_0x019e
            if (r11 != 0) goto L_0x0198
            r11 = -1
            goto L_0x019c
        L_0x0198:
            int r11 = r11.getSystemId()     // Catch:{ Exception -> 0x04f1 }
        L_0x019c:
            r0.f37706O = r11     // Catch:{ Exception -> 0x04f1 }
        L_0x019e:
            com.paypal.android.sdk.O r11 = com.paypal.android.sdk.C11751O.PPRiskDataBssid     // Catch:{ Exception -> 0x04f1 }
            boolean r11 = r2.mo38602a(r11)     // Catch:{ Exception -> 0x04f1 }
            if (r11 == 0) goto L_0x01b0
            if (r6 != 0) goto L_0x01aa
            r11 = r1
            goto L_0x01ae
        L_0x01aa:
            java.lang.String r11 = r6.getBSSID()     // Catch:{ Exception -> 0x04f1 }
        L_0x01ae:
            r0.f37726e = r11     // Catch:{ Exception -> 0x04f1 }
        L_0x01b0:
            com.paypal.android.sdk.O r11 = com.paypal.android.sdk.C11751O.PPRiskDataBssidArray     // Catch:{ Exception -> 0x04f1 }
            boolean r11 = r2.mo38602a(r11)     // Catch:{ Exception -> 0x04f1 }
            if (r11 == 0) goto L_0x01c2
            if (r7 == 0) goto L_0x01bf
            java.util.ArrayList r4 = m39721a(r4)     // Catch:{ Exception -> 0x04f1 }
            goto L_0x01c0
        L_0x01bf:
            r4 = r1
        L_0x01c0:
            r0.f37733ha = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x01c2:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataCellId     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x01d4
            if (r12 != 0) goto L_0x01ce
            r4 = -1
            goto L_0x01d2
        L_0x01ce:
            int r4 = r12.getCid()     // Catch:{ Exception -> 0x04f1 }
        L_0x01d2:
            r0.f37728f = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x01d4:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataNetworkOperator     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x01e2
            java.lang.String r4 = r3.getNetworkOperator()     // Catch:{ Exception -> 0x04f1 }
            r0.f37708Q = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x01e2:
            java.lang.String r4 = "3.5.6.release"
            r0.f37730g = r4     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r4 = r15.f37769m     // Catch:{ Exception -> 0x04f1 }
            r0.f37732h = r4     // Catch:{ Exception -> 0x04f1 }
            com.paypal.android.sdk.q r4 = r15.f37770n     // Catch:{ Exception -> 0x04f1 }
            if (r4 != 0) goto L_0x01f0
            r4 = r1
            goto L_0x01f6
        L_0x01f0:
            com.paypal.android.sdk.q r4 = r15.f37770n     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r4 = r4.mo39173b()     // Catch:{ Exception -> 0x04f1 }
        L_0x01f6:
            r0.f37734i = r4     // Catch:{ Exception -> 0x04f1 }
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataConnType     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x020a
            if (r5 != 0) goto L_0x0204
            r4 = r1
            goto L_0x0208
        L_0x0204:
            java.lang.String r4 = r5.getTypeName()     // Catch:{ Exception -> 0x04f1 }
        L_0x0208:
            r0.f37736j = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x020a:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataDeviceId     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x021c
            if (r9 == 0) goto L_0x0219
            java.lang.String r4 = r3.getDeviceId()     // Catch:{ Exception -> 0x04f1 }
            goto L_0x021a
        L_0x0219:
            r4 = r1
        L_0x021a:
            r0.f37737k = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x021c:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataDeviceModel     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x0228
            java.lang.String r4 = android.os.Build.MODEL     // Catch:{ Exception -> 0x04f1 }
            r0.f37738l = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x0228:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataDeviceName     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x0234
            java.lang.String r4 = android.os.Build.DEVICE     // Catch:{ Exception -> 0x04f1 }
            r0.f37739m = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x0234:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataDeviceUptime     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x0242
            long r4 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception -> 0x04f1 }
            r0.f37740n = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x0242:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataIpAddrs     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x0250
            java.lang.String r4 = com.paypal.android.sdk.C11754P.m38937b()     // Catch:{ Exception -> 0x04f1 }
            r0.f37741o = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x0250:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataIpAddresses     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x025e
            java.util.List r4 = com.paypal.android.sdk.C11754P.m38928a(r8)     // Catch:{ Exception -> 0x04f1 }
            r0.f37742p = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x025e:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataLine1Number     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x0270
            if (r9 == 0) goto L_0x026d
            java.lang.String r4 = r3.getLine1Number()     // Catch:{ Exception -> 0x04f1 }
            goto L_0x026e
        L_0x026d:
            r4 = r1
        L_0x026e:
            r0.f37744r = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x0270:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataLinkerId     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x027e
            java.lang.String r4 = com.paypal.android.sdk.C11754P.m38924a()     // Catch:{ Exception -> 0x04f1 }
            r0.f37745s = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x027e:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataLocaleCountry     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x0290
            java.util.Locale r4 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r4 = r4.getCountry()     // Catch:{ Exception -> 0x04f1 }
            r0.f37746t = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x0290:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataLocaleLang     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x02a2
            java.util.Locale r4 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r4 = r4.getLanguage()     // Catch:{ Exception -> 0x04f1 }
            r0.f37747u = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x02a2:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataLocation     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x02b9
            android.location.Location r4 = r15.f37775s     // Catch:{ Exception -> 0x04f1 }
            if (r4 != 0) goto L_0x02b0
            r4 = r1
            goto L_0x02b7
        L_0x02b0:
            android.location.Location r4 = new android.location.Location     // Catch:{ Exception -> 0x04f1 }
            android.location.Location r5 = r15.f37775s     // Catch:{ Exception -> 0x04f1 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x04f1 }
        L_0x02b7:
            r0.f37748v = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x02b9:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataLocationAreaCode     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x02ca
            if (r12 != 0) goto L_0x02c4
            goto L_0x02c8
        L_0x02c4:
            int r14 = r12.getLac()     // Catch:{ Exception -> 0x04f1 }
        L_0x02c8:
            r0.f37749w = r14     // Catch:{ Exception -> 0x04f1 }
        L_0x02ca:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataMacAddrs     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x02dc
            if (r6 != 0) goto L_0x02d6
            r4 = r1
            goto L_0x02da
        L_0x02d6:
            java.lang.String r4 = r6.getMacAddress()     // Catch:{ Exception -> 0x04f1 }
        L_0x02da:
            r0.f37750x = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x02dc:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataOsType     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x02e8
            java.lang.String r4 = android.os.Build.VERSION.RELEASE     // Catch:{ Exception -> 0x04f1 }
            r0.f37752z = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x02e8:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataRiskCompSessionId     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x02f6
            java.lang.String r4 = com.paypal.android.sdk.C12026y.m39771b()     // Catch:{ Exception -> 0x04f1 }
            r0.f37694C = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x02f6:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataRoaming     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x030d
            android.telephony.ServiceState r4 = new android.telephony.ServiceState     // Catch:{ Exception -> 0x04f1 }
            r4.<init>()     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r4.getRoaming()     // Catch:{ Exception -> 0x04f1 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x04f1 }
            r0.f37695D = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x030d:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataSimOperatorName     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x031b
            java.lang.String r4 = m39719a(r3)     // Catch:{ Exception -> 0x04f1 }
            r0.f37696E = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x031b:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataSerialNumber     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x032d
            if (r9 == 0) goto L_0x032a
            java.lang.String r4 = r3.getSimSerialNumber()     // Catch:{ Exception -> 0x04f1 }
            goto L_0x032b
        L_0x032a:
            r4 = r1
        L_0x032b:
            r0.f37697F = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x032d:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x04f1 }
            r5 = 9
            if (r4 < r5) goto L_0x0337
            java.lang.String r4 = android.os.Build.SERIAL     // Catch:{ Exception -> 0x04f1 }
            r0.f37719aa = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x0337:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataSmsEnabled     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x0351
            android.content.Context r4 = r15.f37762f     // Catch:{ Exception -> 0x04f1 }
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r5 = "android.hardware.telephony"
            boolean r4 = r4.hasSystemFeature(r5)     // Catch:{ Exception -> 0x04f1 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x04f1 }
            r0.f37698G = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x0351:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataSsid     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x0363
            if (r6 != 0) goto L_0x035d
            r4 = r1
            goto L_0x0361
        L_0x035d:
            java.lang.String r4 = r6.getSSID()     // Catch:{ Exception -> 0x04f1 }
        L_0x0361:
            r0.f37699H = r4     // Catch:{ Exception -> 0x04f1 }
        L_0x0363:
            com.paypal.android.sdk.O r4 = com.paypal.android.sdk.C11751O.PPRiskDataSubscriberId     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r2.mo38602a(r4)     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x0375
            if (r9 == 0) goto L_0x0372
            java.lang.String r3 = r3.getSubscriberId()     // Catch:{ Exception -> 0x04f1 }
            goto L_0x0373
        L_0x0372:
            r3 = r1
        L_0x0373:
            r0.f37700I = r3     // Catch:{ Exception -> 0x04f1 }
        L_0x0375:
            com.paypal.android.sdk.O r3 = com.paypal.android.sdk.C11751O.PPRiskDataTimestamp     // Catch:{ Exception -> 0x04f1 }
            boolean r3 = r2.mo38602a(r3)     // Catch:{ Exception -> 0x04f1 }
            if (r3 == 0) goto L_0x0383
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x04f1 }
            r0.f37701J = r3     // Catch:{ Exception -> 0x04f1 }
        L_0x0383:
            com.paypal.android.sdk.O r3 = com.paypal.android.sdk.C11751O.PPRiskDataTotalStorageSpace     // Catch:{ Exception -> 0x04f1 }
            boolean r3 = r2.mo38602a(r3)     // Catch:{ Exception -> 0x04f1 }
            if (r3 == 0) goto L_0x0391
            long r3 = com.paypal.android.sdk.C11754P.m38943c()     // Catch:{ Exception -> 0x04f1 }
            r0.f37702K = r3     // Catch:{ Exception -> 0x04f1 }
        L_0x0391:
            com.paypal.android.sdk.O r3 = com.paypal.android.sdk.C11751O.PPRiskDataTzName     // Catch:{ Exception -> 0x04f1 }
            boolean r3 = r2.mo38602a(r3)     // Catch:{ Exception -> 0x04f1 }
            if (r3 == 0) goto L_0x03ad
            java.util.TimeZone r3 = java.util.TimeZone.getDefault()     // Catch:{ Exception -> 0x04f1 }
            java.util.TimeZone r4 = java.util.TimeZone.getDefault()     // Catch:{ Exception -> 0x04f1 }
            boolean r4 = r4.inDaylightTime(r10)     // Catch:{ Exception -> 0x04f1 }
            java.util.Locale r5 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r3 = r3.getDisplayName(r4, r8, r5)     // Catch:{ Exception -> 0x04f1 }
            r0.f37703L = r3     // Catch:{ Exception -> 0x04f1 }
        L_0x03ad:
            com.paypal.android.sdk.O r3 = com.paypal.android.sdk.C11751O.PPRiskDataIsDaylightSaving     // Catch:{ Exception -> 0x04f1 }
            boolean r3 = r2.mo38602a(r3)     // Catch:{ Exception -> 0x04f1 }
            if (r3 == 0) goto L_0x03c3
            java.util.TimeZone r3 = java.util.TimeZone.getDefault()     // Catch:{ Exception -> 0x04f1 }
            boolean r3 = r3.inDaylightTime(r10)     // Catch:{ Exception -> 0x04f1 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x04f1 }
            r0.f37704M = r3     // Catch:{ Exception -> 0x04f1 }
        L_0x03c3:
            com.paypal.android.sdk.O r3 = com.paypal.android.sdk.C11751O.PPRiskDataTimeZoneOffset     // Catch:{ Exception -> 0x04f1 }
            boolean r3 = r2.mo38602a(r3)     // Catch:{ Exception -> 0x04f1 }
            if (r3 == 0) goto L_0x03dd
            java.util.TimeZone r3 = java.util.TimeZone.getDefault()     // Catch:{ Exception -> 0x04f1 }
            long r4 = r10.getTime()     // Catch:{ Exception -> 0x04f1 }
            int r3 = r3.getOffset(r4)     // Catch:{ Exception -> 0x04f1 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x04f1 }
            r0.f37705N = r3     // Catch:{ Exception -> 0x04f1 }
        L_0x03dd:
            com.paypal.android.sdk.O r3 = com.paypal.android.sdk.C11751O.PPRiskDataIsEmulator     // Catch:{ Exception -> 0x04f1 }
            boolean r3 = r2.mo38602a(r3)     // Catch:{ Exception -> 0x04f1 }
            if (r3 == 0) goto L_0x03ef
            boolean r3 = com.paypal.android.sdk.C11723Fa.m38817a()     // Catch:{ Exception -> 0x04f1 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x04f1 }
            r0.f37711T = r3     // Catch:{ Exception -> 0x04f1 }
        L_0x03ef:
            com.paypal.android.sdk.O r3 = com.paypal.android.sdk.C11751O.PPRiskDataIsRooted     // Catch:{ Exception -> 0x04f1 }
            boolean r3 = r2.mo38602a(r3)     // Catch:{ Exception -> 0x04f1 }
            if (r3 == 0) goto L_0x0401
            boolean r3 = com.paypal.android.sdk.C11702A.m38680a()     // Catch:{ Exception -> 0x04f1 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x04f1 }
            r0.f37712U = r3     // Catch:{ Exception -> 0x04f1 }
        L_0x0401:
            com.paypal.android.sdk.O r3 = com.paypal.android.sdk.C11751O.PPRiskDataKnownApps     // Catch:{ Exception -> 0x04f1 }
            boolean r3 = r2.mo38602a(r3)     // Catch:{ Exception -> 0x04f1 }
            if (r3 == 0) goto L_0x0456
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x04f1 }
            r3.<init>()     // Catch:{ Exception -> 0x04f1 }
            com.paypal.android.sdk.q r4 = r15.f37770n     // Catch:{ Exception -> 0x04f1 }
            if (r4 == 0) goto L_0x044d
            com.paypal.android.sdk.q r4 = r15.f37770n     // Catch:{ Exception -> 0x04f1 }
            java.util.List r4 = r4.mo39177f()     // Catch:{ Exception -> 0x04f1 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x0445 }
        L_0x041c:
            boolean r5 = r4.hasNext()     // Catch:{ Exception -> 0x0445 }
            if (r5 == 0) goto L_0x044d
            java.lang.Object r5 = r4.next()     // Catch:{ Exception -> 0x0445 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0445 }
            android.content.Context r6 = r15.f37762f     // Catch:{ Exception -> 0x0445 }
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch:{ Exception -> 0x0445 }
            android.content.Intent r7 = new android.content.Intent     // Catch:{ Exception -> 0x0445 }
            r7.<init>()     // Catch:{ Exception -> 0x0445 }
            android.content.ComponentName r8 = android.content.ComponentName.unflattenFromString(r5)     // Catch:{ Exception -> 0x0445 }
            android.content.Intent r7 = r7.setComponent(r8)     // Catch:{ Exception -> 0x0445 }
            boolean r6 = com.paypal.android.sdk.C11754P.m38935a(r6, r7)     // Catch:{ Exception -> 0x0445 }
            if (r6 == 0) goto L_0x041c
            r3.add(r5)     // Catch:{ Exception -> 0x0445 }
            goto L_0x041c
        L_0x0445:
            r4 = move-exception
            java.lang.String r4 = f37757a     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r5 = "knownApps error"
            com.paypal.android.sdk.C11754P.m38932a(r4, r5, r1)     // Catch:{ Exception -> 0x04f1 }
        L_0x044d:
            int r4 = r3.size()     // Catch:{ Exception -> 0x04f1 }
            if (r4 != 0) goto L_0x0454
            r3 = r1
        L_0x0454:
            r0.f37743q = r3     // Catch:{ Exception -> 0x04f1 }
        L_0x0456:
            com.paypal.android.sdk.O r3 = com.paypal.android.sdk.C11751O.PPRiskDataAppFirstInstallTime     // Catch:{ Exception -> 0x04f1 }
            boolean r3 = r2.mo38602a(r3)     // Catch:{ Exception -> 0x04f1 }
            if (r3 == 0) goto L_0x0466
            android.content.Context r3 = r15.f37762f     // Catch:{ Exception -> 0x04f1 }
            long r3 = m39717a(r3)     // Catch:{ Exception -> 0x04f1 }
            r0.f37714W = r3     // Catch:{ Exception -> 0x04f1 }
        L_0x0466:
            com.paypal.android.sdk.O r3 = com.paypal.android.sdk.C11751O.PPRiskDataAppLastUpdateTime     // Catch:{ Exception -> 0x04f1 }
            boolean r3 = r2.mo38602a(r3)     // Catch:{ Exception -> 0x04f1 }
            if (r3 == 0) goto L_0x0476
            android.content.Context r3 = r15.f37762f     // Catch:{ Exception -> 0x04f1 }
            long r3 = m39725b(r3)     // Catch:{ Exception -> 0x04f1 }
            r0.f37715X = r3     // Catch:{ Exception -> 0x04f1 }
        L_0x0476:
            java.util.Map r3 = r15.f37774r     // Catch:{ Exception -> 0x04f1 }
            r0.f37735ia = r3     // Catch:{ Exception -> 0x04f1 }
            com.paypal.android.sdk.O r3 = com.paypal.android.sdk.C11751O.PPRiskDataGsfId     // Catch:{ Exception -> 0x04f1 }
            boolean r3 = r2.mo38602a(r3)     // Catch:{ Exception -> 0x04f1 }
            if (r3 == 0) goto L_0x048a
            android.content.Context r3 = r15.f37762f     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r3 = com.paypal.android.sdk.C11754P.m38938b(r3)     // Catch:{ Exception -> 0x04f1 }
            r0.f37721ba = r3     // Catch:{ Exception -> 0x04f1 }
        L_0x048a:
            com.paypal.android.sdk.O r3 = com.paypal.android.sdk.C11751O.PPRiskDataVPNSetting     // Catch:{ Exception -> 0x04f1 }
            boolean r3 = r2.mo38602a(r3)     // Catch:{ Exception -> 0x04f1 }
            if (r3 == 0) goto L_0x0498
            java.lang.String r3 = com.paypal.android.sdk.C11754P.m38948e()     // Catch:{ Exception -> 0x04f1 }
            r0.f37725da = r3     // Catch:{ Exception -> 0x04f1 }
        L_0x0498:
            com.paypal.android.sdk.O r3 = com.paypal.android.sdk.C11751O.PPRiskDataProxySetting     // Catch:{ Exception -> 0x04f1 }
            boolean r3 = r2.mo38602a(r3)     // Catch:{ Exception -> 0x04f1 }
            if (r3 == 0) goto L_0x04a6
            java.lang.String r3 = com.paypal.android.sdk.C11754P.m38946d()     // Catch:{ Exception -> 0x04f1 }
            r0.f37723ca = r3     // Catch:{ Exception -> 0x04f1 }
        L_0x04a6:
            com.paypal.android.sdk.O r3 = com.paypal.android.sdk.C11751O.PPRiskDataOsType     // Catch:{ Exception -> 0x04f1 }
            boolean r3 = r2.mo38602a(r3)     // Catch:{ Exception -> 0x04f1 }
            if (r3 != 0) goto L_0x04b0
            r0.f37751y = r1     // Catch:{ Exception -> 0x04f1 }
        L_0x04b0:
            com.paypal.android.sdk.O r1 = com.paypal.android.sdk.C11751O.PPRiskDataCounter     // Catch:{ Exception -> 0x04f1 }
            boolean r1 = r2.mo38602a(r1)     // Catch:{ Exception -> 0x04f1 }
            if (r1 == 0) goto L_0x04cf
            int r1 = r0.f37709R     // Catch:{ Exception -> 0x04f1 }
            com.paypal.android.sdk.z r2 = com.paypal.android.sdk.C12030z.PAYPAL     // Catch:{ Exception -> 0x04f1 }
            int r2 = r2.mo39219a()     // Catch:{ Exception -> 0x04f1 }
            if (r1 != r2) goto L_0x04cf
            android.content.Context r1 = r15.f37762f     // Catch:{ Exception -> 0x04f1 }
            com.paypal.android.sdk.C11754P.m38945c(r1)     // Catch:{ Exception -> 0x04f1 }
            android.content.Context r1 = r15.f37762f     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r1 = com.paypal.android.sdk.C11754P.m38947d(r1)     // Catch:{ Exception -> 0x04f1 }
            r0.f37727ea = r1     // Catch:{ Exception -> 0x04f1 }
        L_0x04cf:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04f1 }
            r1.<init>()     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r2 = r15.f37763g     // Catch:{ Exception -> 0x04f1 }
            r1.append(r2)     // Catch:{ Exception -> 0x04f1 }
            long r2 = r0.f37701J     // Catch:{ Exception -> 0x04f1 }
            r1.append(r2)     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r1 = com.paypal.android.sdk.C11754P.m38926a(r1)     // Catch:{ Exception -> 0x04f1 }
            r0.f37729fa = r1     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r1 = r15.f37780x     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r1 = com.paypal.android.sdk.C11754P.m38940b(r1)     // Catch:{ Exception -> 0x04f1 }
            r0.f37731ga = r1     // Catch:{ Exception -> 0x04f1 }
            goto L_0x04f9
        L_0x04f1:
            r1 = move-exception
            java.lang.String r2 = f37757a
            java.lang.String r3 = "Unknown error in RiskComponent"
            com.paypal.android.sdk.C11754P.m38932a(r2, r3, r1)
        L_0x04f9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.C12010u.m39740l():com.paypal.android.sdk.t");
    }

    /* renamed from: a */
    public final String mo39192a(Context context, String str, C12030z zVar, String str2, Map map) {
        String str3;
        String a = C11754P.m38927a(map, "RISK_MANAGER_CONF_URL", (String) null);
        this.f37781y = C11754P.m38936a(map, "RISK_MANAGER_IS_START_ASYNC_SERVICE", Boolean.FALSE);
        String a2 = C11754P.m38927a(map, "RISK_MANAGER_PAIRING_ID", (String) null);
        this.f37782z = C11754P.m38927a(map, "RISK_MANAGER_NOTIF_TOKEN", (String) null);
        f37759c = (C11718E) C11754P.m38923a(map, C11718E.class, "RISK_MANAGER_NETWORK_ADAPTER", (Object) new C11730H());
        boolean a3 = C11754P.m38936a(map, "RISK_MANAGER_IS_DISABLE_REMOTE_CONFIG", Boolean.valueOf(false));
        this.f37762f = context;
        this.f37763g = C11754P.m38944c(context, str);
        if (zVar == null) {
            this.f37778v = C12030z.UNKNOWN;
        } else {
            this.f37778v = zVar;
        }
        this.f37779w = str2;
        this.f37771o = null;
        this.f37772p = null;
        this.f37767k = 0;
        this.f37766j = 0;
        if (a2 == null || a2.trim().length() == 0) {
            str3 = m39735i();
        } else {
            C11754P.m38929a(3, "PRD", "Using custom pairing id");
            str3 = a2.trim();
        }
        this.f37780x = str3;
        if (a == null) {
            a = "https://www.paypalobjects.com/webstatic/risk/dyson_config_android_v3.json";
        }
        try {
            this.f37769m = a;
            mo39197f();
            if (this.f37777u == null) {
                this.f37777u = new C12022x(this);
                LocationManager locationManager = (LocationManager) this.f37762f.getSystemService("location");
                if (locationManager != null) {
                    onLocationChanged(C11754P.m38920a(locationManager));
                    if (locationManager.isProviderEnabled("network")) {
                        locationManager.requestLocationUpdates("network", 3600000, 10.0f, this);
                    }
                }
            }
            m39739k();
        } catch (Exception e) {
            C11754P.m38932a(f37757a, (String) null, (Throwable) e);
        }
        m39736j();
        m39722a(new C11994q(this.f37762f, !a3));
        return this.f37780x;
    }

    /* renamed from: a */
    public final void mo39193a(Message message) {
        String str;
        String sb;
        Object obj;
        String str2;
        String str3;
        try {
            int i = message.what;
            if (i == 0) {
                str = f37757a;
                StringBuilder sb2 = new StringBuilder("Dyson Async URL: ");
                sb2.append(message.obj);
                sb = sb2.toString();
            } else if (i != 1) {
                if (i != 2) {
                    switch (i) {
                        case 10:
                            str = f37757a;
                            StringBuilder sb3 = new StringBuilder("Load Configuration URL: ");
                            sb3.append(message.obj);
                            sb = sb3.toString();
                            break;
                        case 11:
                            str2 = f37757a;
                            str3 = "LoadConfigurationRequest failed.";
                            break;
                        case 12:
                            C11994q qVar = (C11994q) message.obj;
                            if (qVar != null) {
                                m39722a(qVar);
                                break;
                            }
                            break;
                        default:
                            switch (i) {
                                case 20:
                                    str = f37757a;
                                    StringBuilder sb4 = new StringBuilder("Beacon URL: ");
                                    sb4.append(message.obj);
                                    sb = sb4.toString();
                                    break;
                                case 21:
                                    String str4 = f37757a;
                                    StringBuilder sb5 = new StringBuilder("BeaconRequest failed ");
                                    sb5.append(((Exception) message.obj).getMessage());
                                    C11754P.m38931a(str4, sb5.toString());
                                    break;
                                case 22:
                                    str = f37757a;
                                    StringBuilder sb6 = new StringBuilder("Beacon returned: ");
                                    sb6.append(message.obj);
                                    sb = sb6.toString();
                                    break;
                            }
                    }
                } else {
                    String str5 = (String) message.obj;
                    String str6 = f37757a;
                    StringBuilder sb7 = new StringBuilder("LogRiskMetadataRequest Server returned: ");
                    sb7.append(str5);
                    C11754P.m38931a(str6, sb7.toString());
                    StringBuilder sb8 = new StringBuilder("?");
                    sb8.append(str5);
                    try {
                        obj = Uri.parse(sb8.toString()).getQueryParameter("responseEnvelope.ack");
                    } catch (UnsupportedOperationException e) {
                        obj = null;
                    }
                    if (AccountAnalytics.SUCCESS.equals(obj)) {
                        str2 = f37757a;
                        str3 = "LogRiskMetadataRequest Success";
                    }
                    return;
                }
                C11754P.m38931a(str2, str3);
            } else {
                str = f37757a;
                StringBuilder sb9 = new StringBuilder("LogRiskMetadataRequest failed.");
                sb9.append(((Exception) message.obj).getMessage());
                sb = sb9.toString();
            }
            C11754P.m38931a(str, sb);
        } catch (Exception e2) {
            C11754P.m38932a(f37757a, (String) null, (Throwable) e2);
        }
    }

    /* renamed from: b */
    public final void mo39194b() {
        new Timer().schedule(new C12018w(this), 0);
    }

    /* renamed from: c */
    public final JSONObject mo39195c() {
        C12026y.m39769a();
        this.f37771o = m39740l();
        C12006t tVar = this.f37771o;
        if (tVar == null) {
            return null;
        }
        return tVar.mo39188a();
    }

    /* renamed from: e */
    public final void mo39196e() {
        C12026y.m39769a();
        this.f37771o = m39740l();
        m39723a(this.f37771o, (C12006t) null);
    }

    /* renamed from: f */
    public final void mo39197f() {
        C11754P.m38931a(f37757a, "Host activity detected");
        this.f37768l = System.currentTimeMillis();
    }

    /* renamed from: g */
    public final String mo39198g() {
        return m39720a((String) null, (Map) null);
    }

    public void onLocationChanged(Location location) {
        if (location != null) {
            this.f37775s = new Location(location);
            String str = f37757a;
            StringBuilder sb = new StringBuilder("Location Update: ");
            sb.append(location.toString());
            C11754P.m38931a(str, sb.toString());
        }
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
