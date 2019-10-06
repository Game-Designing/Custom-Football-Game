package com.flurry.sdk;

import android.content.SharedPreferences;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.flurry.sdk.fb */
public class C7517fb {

    /* renamed from: a */
    private static final String f14829a = C7517fb.class.getSimpleName();

    /* renamed from: b */
    private static C7517fb f14830b;

    /* renamed from: c */
    private final Set<String> f14831c;

    /* renamed from: d */
    public final Map<C7583qb, byte[]> f14832d = new HashMap();

    /* renamed from: e */
    private C7518a f14833e = C7518a.NONE;

    /* renamed from: f */
    private C7595sb f14834f;

    /* renamed from: g */
    public String f14835g;

    /* renamed from: h */
    private C7622xb f14836h;

    /* renamed from: i */
    private List<C7519b> f14837i = new ArrayList();

    /* renamed from: j */
    private final C7452Sb<C7537id> f14838j = new C7486_a(this);

    /* renamed from: k */
    private SharedPreferences f14839k = C7379Fb.m16300a().f14432d.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);

    /* renamed from: com.flurry.sdk.fb$a */
    enum C7518a {
        NONE,
        ADVERTISING,
        DEVICE,
        INSTALL_ID,
        REPORTED_IDS,
        FINISHED
    }

    /* renamed from: com.flurry.sdk.fb$b */
    public interface C7519b {
        /* renamed from: a */
        void mo23951a();
    }

    private C7517fb() {
        HashSet hashSet = new HashSet();
        hashSet.add("null");
        hashSet.add("9774d56d682e549c");
        hashSet.add("dead00beef");
        this.f14831c = Collections.unmodifiableSet(hashSet);
        C7462Ub.m16528a().mo23910a("com.flurry.android.sdk.FlurrySessionEvent", this.f14838j);
        C7379Fb.m16300a().mo23817b(new C7491ab(this));
    }

    /* renamed from: a */
    public static synchronized C7517fb m16656a() {
        C7517fb fbVar;
        synchronized (C7517fb.class) {
            if (f14830b == null) {
                f14830b = new C7517fb();
            }
            fbVar = f14830b;
        }
        return fbVar;
    }

    /* renamed from: b */
    public final boolean mo23947b() {
        return C7518a.FINISHED.equals(this.f14833e);
    }

    /* renamed from: c */
    public final String mo23948c() {
        C7595sb sbVar = this.f14834f;
        if (sbVar == null) {
            return null;
        }
        return sbVar.f15073a;
    }

    /* renamed from: d */
    public final byte[] mo23949d() {
        try {
            if (this.f14836h == null) {
                this.f14836h = new C7622xb();
            }
            return this.f14836h.mo24029a();
        } catch (Exception e) {
            String str = f14829a;
            StringBuilder sb = new StringBuilder("Error while generating Install ID");
            sb.append(e.getMessage());
            C7513ec.m16640a(5, str, sb.toString(), e);
            return null;
        }
    }

    /* renamed from: e */
    public final boolean mo23950e() {
        C7595sb sbVar = this.f14834f;
        if (sbVar != null && sbVar.f15074b) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m16662g() {
        C7595sb sbVar;
        C7354Ad.m16260a();
        String string = this.f14839k.getString("advertising_id", null);
        boolean z = this.f14839k.getBoolean("ad_tracking_enabled", false);
        if (string != null) {
            C7379Fb.m16300a().mo23816a((Runnable) new C7496bb(this), 5000);
            sbVar = new C7595sb(string, z);
        } else {
            sbVar = m16663h();
            C7379Fb.m16300a().mo23816a((Runnable) new C7501cb(this, sbVar), 5000);
        }
        this.f14834f = sbVar;
        if (mo23947b()) {
            m16666k();
            C7462Ub.m16528a().mo23908a((C7447Rb) new C7529hb());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static C7595sb m16663h() {
        String str = "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.";
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(C7379Fb.m16300a().f14432d);
            return new C7595sb(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (NoClassDefFoundError e) {
            C7513ec.m16646b(f14829a, str);
            return null;
        } catch (Exception e2) {
            String str2 = f14829a;
            StringBuilder sb = new StringBuilder("GOOGLE PLAY SERVICES ERROR: ");
            sb.append(e2.getMessage());
            C7513ec.m16646b(str2, sb.toString());
            C7513ec.m16646b(f14829a, str);
            return null;
        }
    }

    /* renamed from: a */
    private static void m16659a(String str, File file) {
        DataOutputStream dataOutputStream = null;
        try {
            DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream2.writeInt(1);
                dataOutputStream2.writeUTF(str);
                C7354Ad.m16261a((Closeable) dataOutputStream2);
            } catch (Throwable th) {
                th = th;
                dataOutputStream = dataOutputStream2;
                C7354Ad.m16261a((Closeable) dataOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            C7513ec.m16640a(6, f14829a, "Error when saving deviceId", th);
            C7354Ad.m16261a((Closeable) dataOutputStream);
        }
    }

    /* renamed from: i */
    private static String m16664i() {
        DataInputStream dataInputStream;
        File fileStreamPath = C7379Fb.m16300a().f14432d.getFileStreamPath(".flurryb.");
        String str = null;
        if (fileStreamPath == null || !fileStreamPath.exists()) {
            return null;
        }
        try {
            dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
            try {
                if (1 == dataInputStream.readInt()) {
                    str = dataInputStream.readUTF();
                }
            } catch (Throwable th) {
                th = th;
                try {
                    C7513ec.m16640a(6, f14829a, "Error when loading deviceId", th);
                    C7354Ad.m16261a((Closeable) dataInputStream);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    C7354Ad.m16261a((Closeable) dataInputStream);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            dataInputStream = null;
            C7354Ad.m16261a((Closeable) dataInputStream);
            throw th;
        }
        C7354Ad.m16261a((Closeable) dataInputStream);
        return str;
    }

    /* renamed from: j */
    private String m16665j() {
        DataInputStream dataInputStream;
        File filesDir = C7379Fb.m16300a().f14432d.getFilesDir();
        String str = null;
        if (filesDir == null) {
            return null;
        }
        String[] list = filesDir.list(new C7507db(this));
        if (list == null || list.length == 0) {
            return null;
        }
        File fileStreamPath = C7379Fb.m16300a().f14432d.getFileStreamPath(list[0]);
        if (fileStreamPath == null || !fileStreamPath.exists()) {
            return null;
        }
        try {
            dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
            try {
                if (46586 == dataInputStream.readUnsignedShort()) {
                    if (2 == dataInputStream.readUnsignedShort()) {
                        dataInputStream.readUTF();
                        str = dataInputStream.readUTF();
                    }
                }
            } catch (Throwable th) {
                th = th;
                try {
                    C7513ec.m16640a(6, f14829a, "Error when loading deviceId", th);
                    C7354Ad.m16261a((Closeable) dataInputStream);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    C7354Ad.m16261a((Closeable) dataInputStream);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            dataInputStream = null;
            C7354Ad.m16261a((Closeable) dataInputStream);
            throw th;
        }
        C7354Ad.m16261a((Closeable) dataInputStream);
        return str;
    }

    /* renamed from: k */
    private void m16666k() {
        String c = mo23948c();
        if (c != null) {
            C7513ec.m16639a(3, f14829a, "Fetched advertising id");
            this.f14832d.put(C7583qb.AndroidAdvertisingId, C7354Ad.m16267d(c));
        }
        byte[] d = mo23949d();
        if (d != null) {
            C7513ec.m16639a(3, f14829a, "Fetched install id");
            this.f14832d.put(C7583qb.AndroidInstallationId, d);
        }
        String str = this.f14835g;
        if (str != null) {
            C7513ec.m16639a(3, f14829a, "Fetched device id");
            this.f14832d.put(C7583qb.DeviceId, C7354Ad.m16267d(str));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0085 A[Catch:{ Exception -> 0x011b }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0087 A[Catch:{ Exception -> 0x011b }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0098 A[Catch:{ Exception -> 0x011b }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0099 A[Catch:{ Exception -> 0x011b }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m16660b(com.flurry.sdk.C7517fb r10) {
        /*
        L_0x0000:
            com.flurry.sdk.fb$a r0 = com.flurry.sdk.C7517fb.C7518a.FINISHED
            com.flurry.sdk.fb$a r1 = r10.f14833e
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x013b
            int[] r0 = com.flurry.sdk.C7512eb.f14814b
            com.flurry.sdk.fb$a r1 = r10.f14833e
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 5
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 4
            if (r0 == r4) goto L_0x0038
            if (r0 == r3) goto L_0x0033
            if (r0 == r2) goto L_0x002e
            if (r0 == r5) goto L_0x0029
            if (r0 == r1) goto L_0x0024
            goto L_0x003d
        L_0x0024:
            com.flurry.sdk.fb$a r0 = com.flurry.sdk.C7517fb.C7518a.FINISHED
            r10.f14833e = r0
            goto L_0x003d
        L_0x0029:
            com.flurry.sdk.fb$a r0 = com.flurry.sdk.C7517fb.C7518a.REPORTED_IDS
            r10.f14833e = r0
            goto L_0x003d
        L_0x002e:
            com.flurry.sdk.fb$a r0 = com.flurry.sdk.C7517fb.C7518a.DEVICE
            r10.f14833e = r0
            goto L_0x003d
        L_0x0033:
            com.flurry.sdk.fb$a r0 = com.flurry.sdk.C7517fb.C7518a.INSTALL_ID
            r10.f14833e = r0
            goto L_0x003d
        L_0x0038:
            com.flurry.sdk.fb$a r0 = com.flurry.sdk.C7517fb.C7518a.ADVERTISING
            r10.f14833e = r0
        L_0x003d:
            int[] r0 = com.flurry.sdk.C7512eb.f14814b     // Catch:{ Exception -> 0x011b }
            com.flurry.sdk.fb$a r6 = r10.f14833e     // Catch:{ Exception -> 0x011b }
            int r6 = r6.ordinal()     // Catch:{ Exception -> 0x011b }
            r0 = r0[r6]     // Catch:{ Exception -> 0x011b }
            if (r0 == r3) goto L_0x0116
            if (r0 == r2) goto L_0x0105
            if (r0 == r5) goto L_0x0056
            if (r0 == r1) goto L_0x0051
            goto L_0x0139
        L_0x0051:
            r10.m16666k()     // Catch:{ Exception -> 0x011b }
            goto L_0x0139
        L_0x0056:
            com.flurry.sdk.C7354Ad.m16260a()     // Catch:{ Exception -> 0x011b }
            com.flurry.sdk.Fb r0 = com.flurry.sdk.C7379Fb.m16300a()     // Catch:{ Exception -> 0x011b }
            android.content.Context r0 = r0.f14432d     // Catch:{ Exception -> 0x011b }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x011b }
            java.lang.String r1 = "android_id"
            java.lang.String r0 = android.provider.Settings.Secure.getString(r0, r1)     // Catch:{ Exception -> 0x011b }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x011b }
            if (r1 != 0) goto L_0x0082
            java.util.Locale r1 = java.util.Locale.US     // Catch:{ Exception -> 0x011b }
            java.lang.String r1 = r0.toLowerCase(r1)     // Catch:{ Exception -> 0x011b }
            java.util.Set<java.lang.String> r2 = r10.f14831c     // Catch:{ Exception -> 0x011b }
            boolean r1 = r2.contains(r1)     // Catch:{ Exception -> 0x011b }
            if (r1 != 0) goto L_0x0082
            goto L_0x0083
        L_0x0082:
            r4 = 0
        L_0x0083:
            if (r4 != 0) goto L_0x0087
            r0 = 0
            goto L_0x0091
        L_0x0087:
            java.lang.String r1 = "AND"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x011b }
            java.lang.String r0 = r1.concat(r0)     // Catch:{ Exception -> 0x011b }
        L_0x0091:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x011b }
            if (r1 != 0) goto L_0x0099
            goto L_0x0101
        L_0x0099:
            java.lang.String r0 = m16664i()     // Catch:{ Exception -> 0x011b }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x011b }
            if (r1 == 0) goto L_0x0100
            java.lang.String r0 = r10.m16665j()     // Catch:{ Exception -> 0x011b }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x011b }
            if (r1 == 0) goto L_0x00e4
            double r0 = java.lang.Math.random()     // Catch:{ Exception -> 0x011b }
            long r0 = java.lang.Double.doubleToLongBits(r0)     // Catch:{ Exception -> 0x011b }
            long r2 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x011b }
            com.flurry.sdk.Fb r4 = com.flurry.sdk.C7379Fb.m16300a()     // Catch:{ Exception -> 0x011b }
            android.content.Context r4 = r4.f14432d     // Catch:{ Exception -> 0x011b }
            java.lang.String r4 = com.flurry.sdk.C7619wd.m16849a(r4)     // Catch:{ Exception -> 0x011b }
            long r6 = com.flurry.sdk.C7354Ad.m16269f(r4)     // Catch:{ Exception -> 0x011b }
            r8 = 37
            long r6 = r6 * r8
            long r2 = r2 + r6
            long r2 = r2 * r8
            long r0 = r0 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011b }
            java.lang.String r3 = "ID"
            r2.<init>(r3)     // Catch:{ Exception -> 0x011b }
            r3 = 16
            java.lang.String r0 = java.lang.Long.toString(r0, r3)     // Catch:{ Exception -> 0x011b }
            r2.append(r0)     // Catch:{ Exception -> 0x011b }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x011b }
        L_0x00e4:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x011b }
            if (r1 != 0) goto L_0x0100
            com.flurry.sdk.Fb r1 = com.flurry.sdk.C7379Fb.m16300a()     // Catch:{ Exception -> 0x011b }
            android.content.Context r1 = r1.f14432d     // Catch:{ Exception -> 0x011b }
            java.lang.String r2 = ".flurryb."
            java.io.File r1 = r1.getFileStreamPath(r2)     // Catch:{ Exception -> 0x011b }
            boolean r2 = com.flurry.sdk.C7635zd.m16872a(r1)     // Catch:{ Exception -> 0x011b }
            if (r2 == 0) goto L_0x0100
            m16659a(r0, r1)     // Catch:{ Exception -> 0x011b }
        L_0x0100:
        L_0x0101:
            r10.f14835g = r0     // Catch:{ Exception -> 0x011b }
            goto L_0x0000
        L_0x0105:
            com.flurry.sdk.C7354Ad.m16260a()     // Catch:{ Exception -> 0x011b }
            com.flurry.sdk.xb r0 = r10.f14836h     // Catch:{ Exception -> 0x011b }
            if (r0 != 0) goto L_0x0114
            com.flurry.sdk.xb r0 = new com.flurry.sdk.xb     // Catch:{ Exception -> 0x011b }
            r0.<init>()     // Catch:{ Exception -> 0x011b }
            r10.f14836h = r0     // Catch:{ Exception -> 0x011b }
        L_0x0114:
            goto L_0x0000
        L_0x0116:
            r10.m16662g()     // Catch:{ Exception -> 0x011b }
            goto L_0x0000
        L_0x011b:
            r0 = move-exception
            java.lang.String r1 = f14829a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Exception during id fetch:"
            r2.<init>(r3)
            com.flurry.sdk.fb$a r3 = r10.f14833e
            r2.append(r3)
            java.lang.String r3 = ", "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.flurry.sdk.C7513ec.m16639a(r5, r1, r0)
        L_0x0139:
            goto L_0x0000
        L_0x013b:
            com.flurry.sdk.gb r0 = new com.flurry.sdk.gb
            r0.<init>()
            com.flurry.sdk.Ub r1 = com.flurry.sdk.C7462Ub.m16528a()
            r1.mo23908a(r0)
            java.util.List<com.flurry.sdk.fb$b> r0 = r10.f14837i
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0168
            java.util.List<com.flurry.sdk.fb$b> r10 = r10.f14837i
            java.util.Iterator r10 = r10.iterator()
        L_0x0155:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x0168
            java.lang.Object r0 = r10.next()
            com.flurry.sdk.fb$b r0 = (com.flurry.sdk.C7517fb.C7519b) r0
            r0.mo23951a()
            r10.remove()
            goto L_0x0155
        L_0x0168:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7517fb.m16660b(com.flurry.sdk.fb):void");
    }

    /* renamed from: a */
    static /* synthetic */ void m16658a(C7517fb fbVar, C7595sb sbVar) {
        if (sbVar != null) {
            String str = "ad_tracking_enabled";
            fbVar.f14839k.edit().putString("advertising_id", sbVar.f15073a).putBoolean(str, sbVar.f15074b).apply();
        }
    }
}
