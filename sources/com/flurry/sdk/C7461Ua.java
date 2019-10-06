package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.flurry.sdk.C7369Dd.C7370a;
import com.flurry.sdk.C7570ob.C7571a;
import com.flurry.sdk.C7607ud.C7608a;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* renamed from: com.flurry.sdk.Ua */
public class C7461Ua implements C7608a {

    /* renamed from: a */
    static final String f14670a = C7461Ua.class.getSimpleName();

    /* renamed from: b */
    static int f14671b = 500;

    /* renamed from: c */
    static int f14672c = 10;

    /* renamed from: d */
    static int f14673d = 1000;

    /* renamed from: e */
    static int f14674e = 160000;

    /* renamed from: f */
    static int f14675f = 50;

    /* renamed from: A */
    Long f14676A;

    /* renamed from: B */
    private int f14677B = -1;

    /* renamed from: C */
    private boolean f14678C = true;

    /* renamed from: D */
    private int f14679D = 0;

    /* renamed from: E */
    private int f14680E = 0;

    /* renamed from: F */
    private int f14681F = 0;

    /* renamed from: G */
    boolean f14682G;
    /* access modifiers changed from: 0000 */

    /* renamed from: H */
    public boolean f14683H = true;

    /* renamed from: I */
    final C7452Sb<C7524gb> f14684I = new C7406Ka(this);
    /* access modifiers changed from: private */

    /* renamed from: J */
    public final C7452Sb<C7537id> f14685J = new C7361Ca(this);

    /* renamed from: g */
    private final AtomicInteger f14686g = new AtomicInteger(0);

    /* renamed from: h */
    private final AtomicInteger f14687h = new AtomicInteger(0);

    /* renamed from: i */
    private final List<C7631za> f14688i = new ArrayList();

    /* renamed from: j */
    private final Map<String, List<String>> f14689j = new HashMap();

    /* renamed from: k */
    private final Map<String, String> f14690k = new HashMap();

    /* renamed from: l */
    private final Map<String, C7582qa> f14691l = new HashMap();

    /* renamed from: m */
    private final List<C7587ra> f14692m = new ArrayList();

    /* renamed from: n */
    private final List<C7575pa> f14693n = new ArrayList();

    /* renamed from: o */
    private final List<String> f14694o = new ArrayList();

    /* renamed from: p */
    private final C7454Sd f14695p = new C7454Sd();
    /* access modifiers changed from: 0000 */

    /* renamed from: q */
    public WeakReference<C7531hd> f14696q;

    /* renamed from: r */
    File f14697r;

    /* renamed from: s */
    C7443Qb<List<C7631za>> f14698s;

    /* renamed from: t */
    public boolean f14699t;

    /* renamed from: u */
    private long f14700u;

    /* renamed from: v */
    private String f14701v;

    /* renamed from: w */
    private String f14702w;

    /* renamed from: x */
    boolean f14703x;

    /* renamed from: y */
    String f14704y;

    /* renamed from: z */
    byte f14705z;

    /* renamed from: a */
    static /* synthetic */ void m16504a(C7461Ua ua, long j, long j2, long j3, int i, String str, String str2, Map map) {
        C7631za a = ua.m16501a(j, j2, j3, i, str, str2, map);
        ua.f14688i.clear();
        ua.f14688i.add(a);
        ua.m16515f();
    }

    public C7461Ua() {
        C7462Ub.m16528a().mo23910a("com.flurry.android.sdk.FlurrySessionEvent", this.f14685J);
    }

    /* renamed from: c */
    private static String m16509c() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d").getInputStream()));
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null && i < 1000) {
                    sb.append(readLine);
                    sb.append("\n");
                    i++;
                }
            }
            return sb.toString();
        } catch (IOException e) {
            String str = f14670a;
            StringBuilder sb2 = new StringBuilder("There was an issue grabbing logcat. ");
            sb2.append(e.getMessage());
            C7513ec.m16639a(6, str, sb2.toString());
            return "";
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo23903a(Context context) {
        if (context instanceof Activity) {
            Bundle extras = ((Activity) context).getIntent().getExtras();
            if (extras != null) {
                String str = f14670a;
                StringBuilder sb = new StringBuilder("Launch Options Bundle is present ");
                sb.append(extras.toString());
                C7513ec.m16639a(3, str, sb.toString());
                for (String str2 : extras.keySet()) {
                    if (str2 != null) {
                        Object obj = extras.get(str2);
                        String obj2 = obj != null ? obj.toString() : "null";
                        this.f14689j.put(str2, Collections.singletonList(obj2));
                        String str3 = f14670a;
                        StringBuilder sb2 = new StringBuilder("Launch options Key: ");
                        sb2.append(str2);
                        sb2.append(". Its value: ");
                        sb2.append(obj2);
                        C7513ec.m16639a(3, str3, sb2.toString());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @android.annotation.TargetApi(18)
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo23906a(boolean r11) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x00c7
            java.util.Map<java.lang.String, java.lang.String> r0 = r10.f14690k
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r1 = r1 - r3
            java.lang.String r1 = java.lang.Long.toString(r1)
            java.lang.String r2 = "boot.time"
            r0.put(r2, r1)
            android.os.StatFs r0 = new android.os.StatFs
            java.io.File r1 = android.os.Environment.getRootDirectory()
            java.lang.String r1 = r1.getAbsolutePath()
            r0.<init>(r1)
            android.os.StatFs r1 = new android.os.StatFs
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r2 = r2.getAbsolutePath()
            r1.<init>(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 18
            java.lang.String r4 = "disk.size.available.external"
            java.lang.String r5 = "disk.size.total.external"
            java.lang.String r6 = "disk.size.available.internal"
            java.lang.String r7 = "disk.size.total.internal"
            if (r2 < r3) goto L_0x0073
            java.util.Map<java.lang.String, java.lang.String> r2 = r10.f14690k
            long r8 = r0.getAvailableBlocksLong()
            java.lang.String r3 = java.lang.Long.toString(r8)
            r2.put(r7, r3)
            java.util.Map<java.lang.String, java.lang.String> r2 = r10.f14690k
            long r7 = r0.getAvailableBlocksLong()
            java.lang.String r0 = java.lang.Long.toString(r7)
            r2.put(r6, r0)
            java.util.Map<java.lang.String, java.lang.String> r0 = r10.f14690k
            long r2 = r1.getAvailableBlocksLong()
            java.lang.String r2 = java.lang.Long.toString(r2)
            r0.put(r5, r2)
            java.util.Map<java.lang.String, java.lang.String> r0 = r10.f14690k
            long r1 = r1.getAvailableBlocksLong()
            java.lang.String r1 = java.lang.Long.toString(r1)
            r0.put(r4, r1)
            goto L_0x00ab
        L_0x0073:
            java.util.Map<java.lang.String, java.lang.String> r2 = r10.f14690k
            int r3 = r0.getAvailableBlocks()
            long r8 = (long) r3
            java.lang.String r3 = java.lang.Long.toString(r8)
            r2.put(r7, r3)
            java.util.Map<java.lang.String, java.lang.String> r2 = r10.f14690k
            int r0 = r0.getAvailableBlocks()
            long r7 = (long) r0
            java.lang.String r0 = java.lang.Long.toString(r7)
            r2.put(r6, r0)
            java.util.Map<java.lang.String, java.lang.String> r0 = r10.f14690k
            int r2 = r1.getAvailableBlocks()
            long r2 = (long) r2
            java.lang.String r2 = java.lang.Long.toString(r2)
            r0.put(r5, r2)
            java.util.Map<java.lang.String, java.lang.String> r0 = r10.f14690k
            int r1 = r1.getAvailableBlocks()
            long r1 = (long) r1
            java.lang.String r1 = java.lang.Long.toString(r1)
            r0.put(r4, r1)
        L_0x00ab:
            java.util.Map<java.lang.String, java.lang.String> r0 = r10.f14690k
            com.flurry.sdk.C7576pb.m16765a()
            java.lang.String r1 = com.flurry.sdk.C7576pb.m16766b()
            java.lang.String r2 = "carrier.name"
            r0.put(r2, r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r10.f14690k
            com.flurry.sdk.C7576pb.m16765a()
            java.lang.String r1 = com.flurry.sdk.C7576pb.m16767c()
            java.lang.String r2 = "carrier.details"
            r0.put(r2, r1)
        L_0x00c7:
            com.flurry.sdk.Fb r0 = com.flurry.sdk.C7379Fb.m16300a()
            android.content.Context r0 = r0.f14432d
            java.lang.String r1 = "activity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0
            android.app.ActivityManager$MemoryInfo r1 = new android.app.ActivityManager$MemoryInfo
            r1.<init>()
            r0.getMemoryInfo(r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r10.f14690k
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "memory.available"
            r2.<init>(r3)
            java.lang.String r3 = ".start"
            java.lang.String r4 = ".end"
            if (r11 == 0) goto L_0x00ef
            r5 = r3
            goto L_0x00f0
        L_0x00ef:
            r5 = r4
        L_0x00f0:
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            long r5 = r1.availMem
            java.lang.String r5 = java.lang.Long.toString(r5)
            r0.put(r2, r5)
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r0 < r2) goto L_0x0124
            java.util.Map<java.lang.String, java.lang.String> r0 = r10.f14690k
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "memory.total"
            r2.<init>(r5)
            if (r11 == 0) goto L_0x0113
            r5 = r3
            goto L_0x0114
        L_0x0113:
            r5 = r4
        L_0x0114:
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            long r5 = r1.availMem
            java.lang.String r1 = java.lang.Long.toString(r5)
            r0.put(r2, r1)
        L_0x0124:
            r0 = 5
            r1 = 0
            r2 = -1
            android.content.IntentFilter r5 = new android.content.IntentFilter     // Catch:{ Exception -> 0x015c }
            java.lang.String r6 = "android.intent.action.BATTERY_CHANGED"
            r5.<init>(r6)     // Catch:{ Exception -> 0x015c }
            com.flurry.sdk.Fb r6 = com.flurry.sdk.C7379Fb.m16300a()     // Catch:{ Exception -> 0x015c }
            android.content.Context r6 = r6.f14432d     // Catch:{ Exception -> 0x015c }
            r7 = 0
            android.content.Intent r5 = r6.registerReceiver(r7, r5)     // Catch:{ Exception -> 0x015c }
            if (r5 == 0) goto L_0x015a
            java.lang.String r6 = "status"
            int r6 = r5.getIntExtra(r6, r2)     // Catch:{ Exception -> 0x015c }
            r7 = 2
            if (r6 == r7) goto L_0x0149
            if (r6 != r0) goto L_0x014a
        L_0x0149:
            r1 = 1
        L_0x014a:
            java.lang.String r6 = "level"
            int r6 = r5.getIntExtra(r6, r2)     // Catch:{ Exception -> 0x015c }
            java.lang.String r7 = "scale"
            int r0 = r5.getIntExtra(r7, r2)     // Catch:{ Exception -> 0x0158 }
            r2 = r6
            goto L_0x015b
        L_0x0158:
            r5 = move-exception
            goto L_0x015e
        L_0x015a:
            r0 = -1
        L_0x015b:
            goto L_0x016f
        L_0x015c:
            r5 = move-exception
            r6 = -1
        L_0x015e:
            java.lang.String r7 = f14670a
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r8 = "Error getting battery status: "
            java.lang.String r5 = r8.concat(r5)
            com.flurry.sdk.C7513ec.m16639a(r0, r7, r5)
            r2 = r6
            r0 = -1
        L_0x016f:
            float r2 = (float) r2
            float r0 = (float) r0
            float r2 = r2 / r0
            java.util.Map<java.lang.String, java.lang.String> r0 = r10.f14690k
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "battery.charging"
            r5.<init>(r6)
            if (r11 == 0) goto L_0x017f
            r6 = r3
            goto L_0x0180
        L_0x017f:
            r6 = r4
        L_0x0180:
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r1 = java.lang.Boolean.toString(r1)
            r0.put(r5, r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r10.f14690k
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r5 = "battery.remaining"
            r1.<init>(r5)
            if (r11 == 0) goto L_0x019a
            goto L_0x019b
        L_0x019a:
            r3 = r4
        L_0x019b:
            r1.append(r3)
            java.lang.String r11 = r1.toString()
            java.lang.String r1 = java.lang.Float.toString(r2)
            r0.put(r11, r1)
            com.flurry.sdk.dc r11 = com.flurry.sdk.C7508dc.m16634a()
            boolean r11 = r11.f14800c
            if (r11 == 0) goto L_0x01d5
            com.flurry.sdk.dc r11 = com.flurry.sdk.C7508dc.m16634a()
            java.lang.String r11 = r11.mo23946b()
            java.util.Map<java.lang.String, java.lang.String> r0 = r10.f14690k
            if (r11 == 0) goto L_0x01bf
            r1 = r11
            goto L_0x01c1
        L_0x01bf:
            java.lang.String r1 = "instant app"
        L_0x01c1:
            java.lang.String r2 = "instantapp.name"
            r0.put(r2, r1)
            java.lang.String r0 = f14670a
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r1 = "instantAppName: "
            java.lang.String r11 = r1.concat(r11)
            com.flurry.sdk.C7513ec.m16649c(r0, r11)
        L_0x01d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7461Ua.mo23906a(boolean):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
        return;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m16511d() {
        /*
            r7 = this;
            monitor-enter(r7)
            com.flurry.sdk.C7354Ad.m16260a()     // Catch:{ all -> 0x0069 }
            java.lang.String r0 = f14670a     // Catch:{ all -> 0x0069 }
            java.lang.String r1 = "Loading persistent session report data."
            r2 = 4
            com.flurry.sdk.C7513ec.m16639a(r2, r0, r1)     // Catch:{ all -> 0x0069 }
            com.flurry.sdk.Qb<java.util.List<com.flurry.sdk.za>> r0 = r7.f14698s     // Catch:{ all -> 0x0069 }
            java.lang.Object r0 = r0.mo23881a()     // Catch:{ all -> 0x0069 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x001d
            java.util.List<com.flurry.sdk.za> r1 = r7.f14688i     // Catch:{ all -> 0x0069 }
            r1.addAll(r0)     // Catch:{ all -> 0x0069 }
            monitor-exit(r7)
            return
        L_0x001d:
            java.io.File r0 = r7.f14697r     // Catch:{ all -> 0x0069 }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x0067
            java.lang.String r0 = f14670a     // Catch:{ all -> 0x0069 }
            java.lang.String r1 = "Legacy persistent agent data found, converting."
            com.flurry.sdk.C7513ec.m16639a(r2, r0, r1)     // Catch:{ all -> 0x0069 }
            java.io.File r0 = r7.f14697r     // Catch:{ all -> 0x0069 }
            com.flurry.sdk.Wa r0 = com.flurry.sdk.C7489a.m16573a(r0)     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x005f
            boolean r1 = r0.f14715c     // Catch:{ all -> 0x0069 }
            long r2 = r0.f14716d     // Catch:{ all -> 0x0069 }
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0049
            com.flurry.sdk.C7475Xa.m16549a()     // Catch:{ all -> 0x0069 }
            long r2 = com.flurry.sdk.C7475Xa.m16551c()     // Catch:{ all -> 0x0069 }
        L_0x0049:
            r7.f14699t = r1     // Catch:{ all -> 0x0069 }
            r7.f14700u = r2     // Catch:{ all -> 0x0069 }
            r7.m16513e()     // Catch:{ all -> 0x0069 }
            java.util.List<com.flurry.sdk.za> r0 = r0.f14714b     // Catch:{ all -> 0x0069 }
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x005f
            java.util.List<com.flurry.sdk.za> r1 = r7.f14688i     // Catch:{ all -> 0x0069 }
            r1.addAll(r0)     // Catch:{ all -> 0x0069 }
        L_0x005f:
            java.io.File r0 = r7.f14697r     // Catch:{ all -> 0x0069 }
            r0.delete()     // Catch:{ all -> 0x0069 }
            r7.m16515f()     // Catch:{ all -> 0x0069 }
        L_0x0067:
            monitor-exit(r7)
            return
        L_0x0069:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7461Ua.m16511d():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m16506a(boolean z, long j) {
        synchronized (this) {
            if (!this.f14683H) {
                C7513ec.m16639a(3, f14670a, "Analytics disabled, not sending agent report.");
                return;
            }
            if (!z) {
                if (this.f14688i.isEmpty()) {
                    return;
                }
            }
            String str = f14670a;
            StringBuilder sb = new StringBuilder("generating agent report with ");
            sb.append(this.f14688i.size());
            sb.append(" session reports.");
            C7513ec.m16639a(3, str, sb.toString());
            byte[] bArr = null;
            try {
                String str2 = C7379Fb.m16300a().f14436h;
                String d = C7588rb.m16810a().mo24014d();
                boolean z2 = this.f14699t;
                boolean e = C7517fb.m16656a().mo23950e();
                long j2 = this.f14700u;
                List<C7631za> list = this.f14688i;
                Map unmodifiableMap = Collections.unmodifiableMap(C7517fb.m16656a().f14832d);
                Map a = this.f14695p.mo23896a();
                Map<String, List<String>> map = this.f14689j;
                C7594sa saVar = new C7594sa(str2, d, z2, e, j2, j, list, unmodifiableMap, a, map, C7389Hb.m16355a().mo23826b(), System.currentTimeMillis(), C7602td.m16825a(), this.f14682G);
                bArr = saVar.f15072b;
            } catch (Exception e2) {
                C7513ec.m16651d(f14670a, "Exception while generating report: ".concat(String.valueOf(e2)));
            }
            if (bArr == null) {
                C7513ec.m16651d(f14670a, "Error generating report");
            } else {
                String str3 = f14670a;
                StringBuilder sb2 = new StringBuilder("generated report of size ");
                sb2.append(bArr.length);
                sb2.append(" with ");
                sb2.append(this.f14688i.size());
                sb2.append(" reports.");
                C7513ec.m16639a(3, str3, sb2.toString());
                C7616wa waVar = C7449Rd.m16479a().f14638c;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(C7384Gb.m16351a());
                waVar.mo23831b(bArr, C7379Fb.m16300a().f14436h, sb3.toString());
            }
            this.f14688i.clear();
            this.f14698s.mo23883b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m16513e() {
        Editor edit = C7379Fb.m16300a().f14432d.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        edit.putBoolean("com.flurry.sdk.previous_successful_report", this.f14699t);
        edit.putLong("com.flurry.sdk.initial_run_time", this.f14700u);
        edit.putString("com.flurry.sdk.api_key", C7379Fb.m16300a().f14436h);
        edit.apply();
    }

    /* renamed from: f */
    private synchronized void m16515f() {
        C7513ec.m16639a(4, f14670a, "Saving persistent agent data.");
        this.f14698s.mo23882a(this.f14688i);
    }

    /* renamed from: a */
    public final synchronized void mo23901a() {
        this.f14677B = C7624xd.m16861a();
        if (C7449Rd.m16479a().f14639d != null) {
            C7379Fb.m16300a().mo23817b(new C7400Ja(this));
        }
        if (this.f14683H && C7449Rd.m16479a().f14637b != null) {
            C7379Fb.m16300a().mo23817b(new C7411La(this));
        }
    }

    /* renamed from: b */
    public final synchronized void mo23907b() {
        m16517g();
    }

    /* renamed from: g */
    private synchronized void m16517g() {
        mo23906a(false);
        C7475Xa.m16549a();
        long c = C7475Xa.m16551c();
        long e = C7475Xa.m16553e();
        long g = C7475Xa.m16555g();
        int k = C7475Xa.m16559k() - 1;
        String h = C7475Xa.m16556h();
        String i = C7475Xa.m16557i();
        Map j = C7475Xa.m16558j();
        if (this.f14683H && C7449Rd.m16479a().f14637b != null) {
            C7379Fb.m16300a().mo23817b(new C7418Ma(this, c));
        }
        C7379Fb.m16300a().mo23817b(new C7425Na(this));
        if (C7517fb.m16656a().mo23947b()) {
            C7379Fb a = C7379Fb.m16300a();
            C7430Oa oa = new C7430Oa(this, c, e, g, k, h, i, j);
            a.mo23817b(oa);
        }
    }

    /* renamed from: a */
    private synchronized C7631za m16501a(long j, long j2, long j3, int i, String str, String str2, Map<String, String> map) {
        C7631za zaVar;
        C7351Aa aa = new C7351Aa();
        aa.f14355s = ((Boolean) C7602td.m16825a().mo24023a("IncludeBackgroundSessionsInMetrics")).booleanValue();
        if (this.f14682G) {
            aa.f14354r = C7370a.BACKGROUND.f14400f;
        } else {
            aa.f14354r = C7370a.ACTIVE.f14400f;
        }
        aa.f14337a = C7588rb.m16810a().mo24014d();
        aa.f14338b = j;
        aa.f14339c = j2;
        aa.f14340d = j3;
        aa.f14341e = this.f14690k;
        aa.f14342f = str;
        aa.f14343g = str2;
        aa.f14344h = map;
        C7535ib.m16696a();
        aa.f14345i = C7535ib.m16697b();
        C7535ib.m16696a();
        aa.f14346j = TimeZone.getDefault().getID();
        aa.f14347k = i;
        aa.f14348l = this.f14677B != -1 ? this.f14677B : C7624xd.m16861a();
        aa.f14349m = this.f14704y == null ? "" : this.f14704y;
        aa.f14350n = C7547kb.m16712a().mo23968f();
        aa.f14351o = this.f14681F;
        aa.f14360x = C7369Dd.m16282a(C7379Fb.m16300a().f14432d).f14410j;
        aa.f14352p = this.f14705z;
        aa.f14353q = this.f14676A;
        aa.f14356t = this.f14691l;
        List<C7587ra> list = this.f14692m;
        String str3 = f14670a;
        StringBuilder sb = new StringBuilder("Total events in session report: ");
        sb.append(list.size());
        C7513ec.m16639a(3, str3, sb.toString());
        aa.f14357u = list;
        aa.f14359w = this.f14678C;
        aa.f14362z = this.f14693n;
        aa.f14361y = this.f14680E;
        String str4 = f14670a;
        StringBuilder sb2 = new StringBuilder("Total errors in session report: ");
        sb2.append(this.f14680E);
        C7513ec.m16639a(3, str4, sb2.toString());
        aa.f14358v = this.f14694o;
        aa.f14336A = this.f14702w;
        zaVar = null;
        try {
            zaVar = new C7631za(aa);
        } catch (IOException e) {
            C7513ec.m16639a(5, f14670a, "Error creating analytics session report: ".concat(String.valueOf(e)));
        }
        if (zaVar == null) {
            C7513ec.m16651d(f14670a, "New session report wasn't created");
        }
        return zaVar;
    }

    /* renamed from: a */
    private synchronized C7631za m16502a(long j, long j2, C7575pa paVar) {
        C7631za zaVar;
        C7351Aa aa = new C7351Aa();
        aa.f14355s = false;
        aa.f14354r = C7370a.UNKNOWN.f14400f;
        aa.f14337a = C7588rb.m16810a().mo24014d();
        aa.f14338b = j;
        aa.f14339c = j2;
        aa.f14340d = 0;
        zaVar = null;
        aa.f14341e = null;
        aa.f14342f = null;
        aa.f14343g = null;
        aa.f14344h = null;
        aa.f14345i = "";
        aa.f14346j = "";
        aa.f14347k = C7571a.f14974a - 1;
        aa.f14348l = 0;
        aa.f14349m = "";
        aa.f14350n = null;
        aa.f14351o = 0;
        aa.f14360x = C7369Dd.m16282a(C7379Fb.m16300a().f14432d).f14410j;
        aa.f14352p = -1;
        aa.f14353q = null;
        aa.f14356t = null;
        aa.f14357u = null;
        aa.f14359w = true;
        ArrayList arrayList = new ArrayList();
        arrayList.add(paVar);
        aa.f14362z = arrayList;
        aa.f14361y = arrayList.size();
        String str = f14670a;
        StringBuilder sb = new StringBuilder("Total errors in native crash session report: ");
        sb.append(arrayList.size());
        C7513ec.m16639a(3, str, sb.toString());
        aa.f14358v = new ArrayList();
        aa.f14336A = null;
        try {
            zaVar = new C7631za(aa);
        } catch (IOException e) {
            C7513ec.m16639a(5, f14670a, "Error creating analytics native crash session report: ".concat(String.valueOf(e)));
        }
        if (zaVar == null) {
            C7513ec.m16651d(f14670a, "New native crash session report wasn't created");
        }
        return zaVar;
    }

    /* renamed from: b */
    private synchronized void m16508b(long j) {
        for (C7587ra raVar : this.f14692m) {
            if (raVar.f15052e && !raVar.f15053f) {
                raVar.mo24010a(j);
            }
        }
    }

    /* renamed from: a */
    public final synchronized void mo23902a(long j) {
        synchronized (this) {
            C7462Ub.m16528a().mo23909a(this.f14684I);
            C7475Xa.m16549a();
            m16508b(C7475Xa.m16553e());
            C7379Fb.m16300a().mo23817b(new C7442Qa(this));
            if (C7517fb.m16656a().mo23947b()) {
                C7475Xa.m16549a();
                long e = C7475Xa.m16553e();
                long g = C7475Xa.m16555g();
                int k = C7475Xa.m16559k() - 1;
                String h = C7475Xa.m16556h();
                String i = C7475Xa.m16557i();
                Map j2 = C7475Xa.m16558j();
                C7379Fb a = C7379Fb.m16300a();
                C7446Ra ra = new C7446Ra(this, j, e, g, k, h, i, j2);
                a.mo23817b(ra);
            }
            C7602td.m16825a().mo24026b("Gender", this);
            C7602td.m16825a().mo24026b("UserId", this);
            C7602td.m16825a().mo24026b("Age", this);
            C7602td.m16825a().mo24026b("LogEvents", this);
        }
    }

    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo23820a(java.lang.String r6, java.lang.Object r7) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            r4 = 4
            switch(r0) {
                case -1752163738: goto L_0x0034;
                case -1720015653: goto L_0x002a;
                case -738063011: goto L_0x0020;
                case 65759: goto L_0x0016;
                case 2129321697: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x003e
        L_0x000c:
            java.lang.String r0 = "Gender"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x000b
            r6 = 2
            goto L_0x003f
        L_0x0016:
            java.lang.String r0 = "Age"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x000b
            r6 = 3
            goto L_0x003f
        L_0x0020:
            java.lang.String r0 = "LogEvents"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x000b
            r6 = 0
            goto L_0x003f
        L_0x002a:
            java.lang.String r0 = "analyticsEnabled"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x000b
            r6 = 4
            goto L_0x003f
        L_0x0034:
            java.lang.String r0 = "UserId"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x000b
            r6 = 1
            goto L_0x003f
        L_0x003e:
            r6 = -1
        L_0x003f:
            if (r6 == 0) goto L_0x00c2
            if (r6 == r3) goto L_0x00a8
            if (r6 == r2) goto L_0x008a
            if (r6 == r1) goto L_0x0070
            if (r6 == r4) goto L_0x0052
            r6 = 6
            java.lang.String r7 = f14670a
            java.lang.String r0 = "onSettingUpdate internal error!"
            com.flurry.sdk.C7513ec.m16639a(r6, r7, r0)
            return
        L_0x0052:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r6 = r7.booleanValue()
            r5.f14683H = r6
            java.lang.String r6 = f14670a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "onSettingUpdate, AnalyticsEnabled = "
            r7.<init>(r0)
            boolean r0 = r5.f14683H
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.flurry.sdk.C7513ec.m16639a(r4, r6, r7)
            return
        L_0x0070:
            java.lang.Long r7 = (java.lang.Long) r7
            r5.f14676A = r7
            java.lang.String r6 = f14670a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "onSettingUpdate, Birthdate = "
            r7.<init>(r0)
            java.lang.Long r0 = r5.f14676A
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.flurry.sdk.C7513ec.m16639a(r4, r6, r7)
            return
        L_0x008a:
            java.lang.Byte r7 = (java.lang.Byte) r7
            byte r6 = r7.byteValue()
            r5.f14705z = r6
            java.lang.String r6 = f14670a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "onSettingUpdate, Gender = "
            r7.<init>(r0)
            byte r0 = r5.f14705z
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.flurry.sdk.C7513ec.m16639a(r4, r6, r7)
            return
        L_0x00a8:
            java.lang.String r7 = (java.lang.String) r7
            r5.f14704y = r7
            java.lang.String r6 = f14670a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "onSettingUpdate, UserId = "
            r7.<init>(r0)
            java.lang.String r0 = r5.f14704y
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.flurry.sdk.C7513ec.m16639a(r4, r6, r7)
            return
        L_0x00c2:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r6 = r7.booleanValue()
            r5.f14703x = r6
            java.lang.String r6 = f14670a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "onSettingUpdate, LogEvents = "
            r7.<init>(r0)
            boolean r0 = r5.f14703x
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.flurry.sdk.C7513ec.m16639a(r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7461Ua.mo23820a(java.lang.String, java.lang.Object):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x016d, code lost:
        return r0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized p019d.p020e.p021a.C7296g mo23900a(java.lang.String r14, java.util.Map<java.lang.String, java.lang.String> r15, boolean r16, int r17) {
        /*
            r13 = this;
            r1 = r13
            monitor-enter(r13)
            d.e.a.g r0 = p019d.p020e.p021a.C7296g.kFlurryEventRecorded     // Catch:{ all -> 0x016e }
            boolean r2 = r1.f14683H     // Catch:{ all -> 0x016e }
            if (r2 != 0) goto L_0x0013
            d.e.a.g r0 = p019d.p020e.p021a.C7296g.kFlurryEventAnalyticsDisabled     // Catch:{ all -> 0x016e }
            java.lang.String r2 = f14670a     // Catch:{ all -> 0x016e }
            java.lang.String r3 = "Analytics has been disabled, not logging event."
            com.flurry.sdk.C7513ec.m16651d(r2, r3)     // Catch:{ all -> 0x016e }
            monitor-exit(r13)
            return r0
        L_0x0013:
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x016e }
            com.flurry.sdk.C7475Xa.m16549a()     // Catch:{ all -> 0x016e }
            long r4 = com.flurry.sdk.C7475Xa.m16552d()     // Catch:{ all -> 0x016e }
            long r10 = r2 - r4
            java.lang.String r2 = com.flurry.sdk.C7354Ad.m16265b(r14)     // Catch:{ all -> 0x016e }
            int r3 = r2.length()     // Catch:{ all -> 0x016e }
            if (r3 != 0) goto L_0x002e
            d.e.a.g r0 = p019d.p020e.p021a.C7296g.kFlurryEventFailed     // Catch:{ all -> 0x016e }
            monitor-exit(r13)
            return r0
        L_0x002e:
            java.util.Map<java.lang.String, com.flurry.sdk.qa> r3 = r1.f14691l     // Catch:{ all -> 0x016e }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x016e }
            com.flurry.sdk.qa r3 = (com.flurry.sdk.C7582qa) r3     // Catch:{ all -> 0x016e }
            r4 = 1
            if (r3 != 0) goto L_0x0071
            java.util.Map<java.lang.String, com.flurry.sdk.qa> r3 = r1.f14691l     // Catch:{ all -> 0x016e }
            int r3 = r3.size()     // Catch:{ all -> 0x016e }
            int r5 = f14671b     // Catch:{ all -> 0x016e }
            if (r3 >= r5) goto L_0x005f
            com.flurry.sdk.qa r3 = new com.flurry.sdk.qa     // Catch:{ all -> 0x016e }
            r3.<init>()     // Catch:{ all -> 0x016e }
            r3.f15029a = r4     // Catch:{ all -> 0x016e }
            java.util.Map<java.lang.String, com.flurry.sdk.qa> r4 = r1.f14691l     // Catch:{ all -> 0x016e }
            r4.put(r2, r3)     // Catch:{ all -> 0x016e }
            java.lang.String r3 = f14670a     // Catch:{ all -> 0x016e }
            java.lang.String r4 = "Event count started: "
            java.lang.String r5 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x016e }
            java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x016e }
            com.flurry.sdk.C7513ec.m16651d(r3, r4)     // Catch:{ all -> 0x016e }
            goto L_0x0087
        L_0x005f:
            java.lang.String r0 = f14670a     // Catch:{ all -> 0x016e }
            java.lang.String r3 = "Too many different events. Event not counted: "
            java.lang.String r4 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x016e }
            java.lang.String r3 = r3.concat(r4)     // Catch:{ all -> 0x016e }
            com.flurry.sdk.C7513ec.m16651d(r0, r3)     // Catch:{ all -> 0x016e }
            d.e.a.g r0 = p019d.p020e.p021a.C7296g.kFlurryEventUniqueCountExceeded     // Catch:{ all -> 0x016e }
            goto L_0x0087
        L_0x0071:
            int r0 = r3.f15029a     // Catch:{ all -> 0x016e }
            int r0 = r0 + r4
            r3.f15029a = r0     // Catch:{ all -> 0x016e }
            java.lang.String r0 = f14670a     // Catch:{ all -> 0x016e }
            java.lang.String r3 = "Event count incremented: "
            java.lang.String r4 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x016e }
            java.lang.String r3 = r3.concat(r4)     // Catch:{ all -> 0x016e }
            com.flurry.sdk.C7513ec.m16651d(r0, r3)     // Catch:{ all -> 0x016e }
            d.e.a.g r0 = p019d.p020e.p021a.C7296g.kFlurryEventRecorded     // Catch:{ all -> 0x016e }
        L_0x0087:
            boolean r3 = r1.f14703x     // Catch:{ all -> 0x016e }
            r4 = 0
            if (r3 == 0) goto L_0x016a
            java.util.List<com.flurry.sdk.ra> r3 = r1.f14692m     // Catch:{ all -> 0x016e }
            int r3 = r3.size()     // Catch:{ all -> 0x016e }
            int r5 = f14673d     // Catch:{ all -> 0x016e }
            if (r3 >= r5) goto L_0x016a
            int r3 = r1.f14679D     // Catch:{ all -> 0x016e }
            int r5 = f14674e     // Catch:{ all -> 0x016e }
            if (r3 >= r5) goto L_0x016a
            if (r15 != 0) goto L_0x00a3
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x016e }
            goto L_0x00a4
        L_0x00a3:
            r0 = r15
        L_0x00a4:
            int r3 = r0.size()     // Catch:{ all -> 0x016e }
            int r3 = r3 - r17
            int r5 = f14672c     // Catch:{ all -> 0x016e }
            if (r3 <= r5) goto L_0x00cb
            java.lang.String r2 = f14670a     // Catch:{ all -> 0x016e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x016e }
            java.lang.String r4 = "MaxEventParams exceeded: "
            r3.<init>(r4)     // Catch:{ all -> 0x016e }
            int r0 = r0.size()     // Catch:{ all -> 0x016e }
            int r0 = r0 - r17
            r3.append(r0)     // Catch:{ all -> 0x016e }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x016e }
            com.flurry.sdk.C7513ec.m16651d(r2, r0)     // Catch:{ all -> 0x016e }
            d.e.a.g r0 = p019d.p020e.p021a.C7296g.kFlurryEventParamsCountExceeded     // Catch:{ all -> 0x016e }
            goto L_0x016c
        L_0x00cb:
            com.flurry.sdk.ra r3 = new com.flurry.sdk.ra     // Catch:{ all -> 0x016e }
            java.util.concurrent.atomic.AtomicInteger r5 = r1.f14686g     // Catch:{ all -> 0x016e }
            int r7 = r5.incrementAndGet()     // Catch:{ all -> 0x016e }
            r6 = r3
            r8 = r2
            r9 = r0
            r12 = r16
            r6.<init>(r7, r8, r9, r10, r12)     // Catch:{ all -> 0x016e }
            byte[] r5 = r3.mo24013b()     // Catch:{ all -> 0x016e }
            int r5 = r5.length     // Catch:{ all -> 0x016e }
            int r6 = r1.f14679D     // Catch:{ all -> 0x016e }
            int r5 = r5 + r6
            int r6 = f14674e     // Catch:{ all -> 0x016e }
            if (r5 > r6) goto L_0x015a
            java.util.List<com.flurry.sdk.ra> r4 = r1.f14692m     // Catch:{ all -> 0x016e }
            r4.add(r3)     // Catch:{ all -> 0x016e }
            int r4 = r1.f14679D     // Catch:{ all -> 0x016e }
            byte[] r5 = r3.mo24013b()     // Catch:{ all -> 0x016e }
            int r5 = r5.length     // Catch:{ all -> 0x016e }
            int r4 = r4 + r5
            r1.f14679D = r4     // Catch:{ all -> 0x016e }
            d.e.a.g r4 = p019d.p020e.p021a.C7296g.kFlurryEventRecorded     // Catch:{ all -> 0x016e }
            java.lang.String r5 = "Flurry.purchase"
            boolean r5 = r5.equals(r2)     // Catch:{ all -> 0x016e }
            if (r5 == 0) goto L_0x0140
            java.util.Map r5 = r3.mo24009a()     // Catch:{ all -> 0x016e }
            java.lang.String r6 = "fl.OrderJSON"
            java.lang.Object r6 = r5.get(r6)     // Catch:{ all -> 0x016e }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x016e }
            java.lang.String r7 = "fl.OrderJSONSignature"
            java.lang.Object r7 = r5.get(r7)     // Catch:{ all -> 0x016e }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x016e }
            if (r6 == 0) goto L_0x0140
            if (r7 == 0) goto L_0x0140
            java.lang.String r8 = "fl.OrderJSON"
            r5.remove(r8)     // Catch:{ all -> 0x016e }
            java.lang.String r8 = "fl.OrderJSONSignature"
            r5.remove(r8)     // Catch:{ all -> 0x016e }
            r3.mo24012b(r5)     // Catch:{ all -> 0x016e }
            java.util.List<java.lang.String> r3 = r1.f14694o     // Catch:{ all -> 0x016e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x016e }
            r5.<init>()     // Catch:{ all -> 0x016e }
            r5.append(r7)     // Catch:{ all -> 0x016e }
            r7 = 10
            r5.append(r7)     // Catch:{ all -> 0x016e }
            r5.append(r6)     // Catch:{ all -> 0x016e }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x016e }
            r3.add(r5)     // Catch:{ all -> 0x016e }
        L_0x0140:
            boolean r3 = r1.f14683H     // Catch:{ all -> 0x016e }
            if (r3 == 0) goto L_0x0158
            com.flurry.sdk.Rd r3 = com.flurry.sdk.C7449Rd.m16479a()     // Catch:{ all -> 0x016e }
            com.flurry.sdk.G r3 = r3.f14637b     // Catch:{ all -> 0x016e }
            if (r3 == 0) goto L_0x0158
            com.flurry.sdk.Fb r3 = com.flurry.sdk.C7379Fb.m16300a()     // Catch:{ all -> 0x016e }
            com.flurry.sdk.Sa r5 = new com.flurry.sdk.Sa     // Catch:{ all -> 0x016e }
            r5.<init>(r13, r2, r0)     // Catch:{ all -> 0x016e }
            r3.mo23817b(r5)     // Catch:{ all -> 0x016e }
        L_0x0158:
            r0 = r4
            goto L_0x016c
        L_0x015a:
            int r0 = f14674e     // Catch:{ all -> 0x016e }
            r1.f14679D = r0     // Catch:{ all -> 0x016e }
            r1.f14678C = r4     // Catch:{ all -> 0x016e }
            java.lang.String r0 = f14670a     // Catch:{ all -> 0x016e }
            java.lang.String r2 = "Event Log size exceeded. No more event details logged."
            com.flurry.sdk.C7513ec.m16651d(r0, r2)     // Catch:{ all -> 0x016e }
            d.e.a.g r0 = p019d.p020e.p021a.C7296g.kFlurryEventLogCountExceeded     // Catch:{ all -> 0x016e }
            goto L_0x016c
        L_0x016a:
            r1.f14678C = r4     // Catch:{ all -> 0x016e }
        L_0x016c:
            monitor-exit(r13)
            return r0
        L_0x016e:
            r0 = move-exception
            monitor-exit(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7461Ua.mo23900a(java.lang.String, java.util.Map, boolean, int):d.e.a.g");
    }

    /* renamed from: a */
    public final synchronized void mo23905a(String str, Map<String, String> map) {
        boolean z;
        for (C7587ra raVar : this.f14692m) {
            if (!raVar.f15052e || raVar.f15054g != 0 || !raVar.f15050c.equals(str)) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                C7475Xa.m16549a();
                long d = elapsedRealtime - C7475Xa.m16552d();
                if (map != null && map.size() > 0 && this.f14679D < f14674e) {
                    int length = this.f14679D - raVar.mo24013b().length;
                    HashMap hashMap = new HashMap(raVar.mo24009a());
                    raVar.mo24011a(map);
                    if (raVar.mo24013b().length + length > f14674e) {
                        raVar.mo24012b(hashMap);
                        this.f14678C = false;
                        this.f14679D = f14674e;
                        C7513ec.m16651d(f14670a, "Event Log size exceeded. No more event details logged.");
                    } else if (raVar.mo24009a().size() > f14672c) {
                        String str2 = f14670a;
                        StringBuilder sb = new StringBuilder("MaxEventParams exceeded on endEvent: ");
                        sb.append(raVar.mo24009a().size());
                        C7513ec.m16651d(str2, sb.toString());
                        raVar.mo24012b(hashMap);
                    } else {
                        this.f14679D = length + raVar.mo24013b().length;
                    }
                }
                raVar.mo24010a(d);
                return;
            }
        }
    }

    /* renamed from: a */
    public final synchronized void mo23904a(C7428Nd nd) {
        int i = 0;
        boolean z = nd.f14570a != null && "uncaught".equals(nd.f14570a);
        this.f14680E++;
        if (this.f14693n.size() < f14675f) {
            C7575pa paVar = new C7575pa(this.f14687h.incrementAndGet(), Long.valueOf(System.currentTimeMillis()).longValue(), nd.f14570a, nd.f14571b, nd.f14572c, nd.f14573d, nd.f14574e, nd.f14575f);
            paVar.mo23984a(nd.f14576g);
            this.f14693n.add(paVar);
            String str = f14670a;
            StringBuilder sb = new StringBuilder("Error logged: ");
            sb.append(paVar.f14985c);
            C7513ec.m16651d(str, sb.toString());
        } else if (z) {
            while (i < this.f14693n.size()) {
                C7575pa paVar2 = (C7575pa) this.f14693n.get(i);
                if (paVar2.f14985c == null || "uncaught".equals(paVar2.f14985c)) {
                    i++;
                } else {
                    C7575pa paVar3 = new C7575pa(this.f14687h.incrementAndGet(), Long.valueOf(System.currentTimeMillis()).longValue(), nd.f14570a, nd.f14571b, nd.f14572c, nd.f14573d, nd.f14574e, nd.f14575f);
                    paVar3.mo23984a(nd.f14576g);
                    this.f14693n.set(i, paVar3);
                    return;
                }
            }
        } else {
            C7513ec.m16651d(f14670a, "Max errors logged. No more errors logged.");
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m16512d(C7461Ua ua) {
        SharedPreferences sharedPreferences = C7379Fb.m16300a().f14432d.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
        ua.f14699t = sharedPreferences.getBoolean("com.flurry.sdk.previous_successful_report", false);
        C7475Xa.m16549a();
        ua.f14700u = sharedPreferences.getLong("com.flurry.sdk.initial_run_time", C7475Xa.m16551c());
        ua.f14701v = sharedPreferences.getString("com.flurry.sdk.api_key", "");
        ua.f14702w = sharedPreferences.getString("com.flurry.sdk.variant_ids", null);
        if (!TextUtils.isEmpty(ua.f14701v) || ua.f14700u <= 0) {
            if (!ua.f14701v.equals(C7379Fb.m16300a().f14436h)) {
                C7475Xa.m16549a();
                ua.f14700u = C7475Xa.m16551c();
            }
            return;
        }
        ua.f14701v = C7379Fb.m16300a().f14436h;
    }

    /* renamed from: e */
    static /* synthetic */ void m16514e(C7461Ua ua) {
        String[] a;
        boolean z;
        C7354Ad.m16260a();
        File fileStreamPath = C7379Fb.m16300a().f14432d.getFileStreamPath(".yflurrynativecrash");
        StringBuilder sb = new StringBuilder(".*");
        sb.append(Pattern.quote(".dmp"));
        sb.append("$");
        for (String str : C7635zd.m16873a(fileStreamPath, Pattern.compile(sb.toString()))) {
            C7513ec.m16639a(3, f14670a, "Native crash occurred in previous session! Found minidump file - ".concat(String.valueOf(str)));
            String a2 = C7369Dd.m16283a(fileStreamPath, str);
            if (TextUtils.isEmpty(a2)) {
                C7513ec.m16639a(6, f14670a, "There was no breadcrumbs file associated with the minidump file.");
                z = true;
            } else {
                z = false;
            }
            C7513ec.m16639a(2, f14670a, "Breadcrumbs file associated with minidump file - ".concat(String.valueOf(a2)));
            String a3 = C7369Dd.m16284a(a2);
            String b = C7369Dd.m16285b(a2);
            if (TextUtils.isEmpty(a3)) {
                C7513ec.m16639a(6, f14670a, "There is no session id specified with crash breadcrumbs file: ".concat(String.valueOf(a2)));
                z = true;
            }
            long j = 0;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                j = Long.parseLong(a3);
                currentTimeMillis = Long.parseLong(b);
            } catch (NumberFormatException e) {
                C7513ec.m16639a(6, f14670a, "Issue parsing session id into start time: ".concat(String.valueOf(a3)));
                z = true;
            }
            C7575pa paVar = new C7575pa(1, currentTimeMillis, "native", "", "", null, null, null);
            paVar.f14992j = m16509c();
            File file = new File(fileStreamPath, a2);
            if (file.exists()) {
                List a4 = new C7392Hd(file).mo23834a();
                String str2 = f14670a;
                StringBuilder sb2 = new StringBuilder("Number of crash breadcrumbs - ");
                sb2.append(a4.size());
                C7513ec.m16639a(2, str2, sb2.toString());
                paVar.mo23984a(a4);
                file.delete();
            } else {
                C7513ec.m16639a(6, f14670a, "Breadcrumbs file does not exist.");
                z = true;
            }
            File file2 = new File(fileStreamPath, str);
            if (!file2.exists()) {
                C7461Ua ua2 = ua;
                C7513ec.m16639a(6, f14670a, "Minidump file doesn't exist.");
            } else if (z) {
                C7513ec.m16639a(6, f14670a, "Some error occurred with minidump file. Deleting it.");
                file2.delete();
                C7461Ua ua3 = ua;
            } else {
                paVar.f14993k = C7635zd.m16875c(file2);
                file2.delete();
                C7631za a5 = ua.m16502a(j, currentTimeMillis - j, paVar);
                if (a5 != null) {
                    ua.f14688i.add(a5);
                } else {
                    C7461Ua ua4 = ua;
                }
            }
        }
    }
}
