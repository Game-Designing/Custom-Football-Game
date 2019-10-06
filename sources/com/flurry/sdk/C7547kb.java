package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.flurry.sdk.C7607ud.C7608a;
import java.util.Timer;

@SuppressLint({"MissingPermission"})
/* renamed from: com.flurry.sdk.kb */
public class C7547kb implements C7608a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f14908a = C7547kb.class.getSimpleName();

    /* renamed from: b */
    private static int f14909b = -1;

    /* renamed from: c */
    private static int f14910c = -1;

    /* renamed from: d */
    private static int f14911d = -1;

    /* renamed from: e */
    private static C7547kb f14912e;

    /* renamed from: f */
    private boolean f14913f;

    /* renamed from: g */
    private Location f14914g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public long f14915h = 0;

    /* renamed from: i */
    private LocationManager f14916i = ((LocationManager) C7379Fb.m16300a().f14432d.getSystemService("location"));

    /* renamed from: j */
    private C7548a f14917j = new C7548a();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Location f14918k;

    /* renamed from: l */
    private boolean f14919l = false;

    /* renamed from: m */
    private int f14920m = 0;

    /* renamed from: n */
    private Timer f14921n = null;

    /* renamed from: com.flurry.sdk.kb$a */
    class C7548a implements LocationListener {
        public C7548a() {
        }

        public final void onLocationChanged(Location location) {
            if (location != null) {
                C7547kb.this.f14918k = location;
            }
            if (C7547kb.m16718c(C7547kb.this) >= 3) {
                C7513ec.m16639a(4, C7547kb.f14908a, "Max location reports reached, stopping");
                C7547kb.this.m16720h();
            }
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onProviderDisabled(String str) {
        }
    }

    /* renamed from: c */
    static /* synthetic */ int m16718c(C7547kb kbVar) {
        int i = kbVar.f14920m + 1;
        kbVar.f14920m = i;
        return i;
    }

    private C7547kb() {
        C7602td a = C7602td.m16825a();
        String str = "ReportLocation";
        this.f14913f = ((Boolean) a.mo24023a(str)).booleanValue();
        a.mo24024a(str, (C7608a) this);
        String str2 = f14908a;
        StringBuilder sb = new StringBuilder("initSettings, ReportLocation = ");
        sb.append(this.f14913f);
        C7513ec.m16639a(4, str2, sb.toString());
        String str3 = "ExplicitLocation";
        this.f14914g = (Location) a.mo24023a(str3);
        a.mo24024a(str3, (C7608a) this);
        String str4 = f14908a;
        StringBuilder sb2 = new StringBuilder("initSettings, ExplicitLocation = ");
        sb2.append(this.f14914g);
        C7513ec.m16639a(4, str4, sb2.toString());
    }

    /* renamed from: a */
    public static synchronized C7547kb m16712a() {
        C7547kb kbVar;
        synchronized (C7547kb.class) {
            if (f14912e == null) {
                f14912e = new C7547kb();
            }
            kbVar = f14912e;
        }
        return kbVar;
    }

    /* renamed from: b */
    public static int m16714b() {
        return f14909b;
    }

    /* renamed from: c */
    public static int m16717c() {
        return f14911d;
    }

    /* renamed from: d */
    public final synchronized void mo23966d() {
        String str;
        C7513ec.m16639a(4, f14908a, "Location update requested");
        if (this.f14920m < 3 && !this.f14919l && this.f14913f && this.f14914g == null) {
            Context context = C7379Fb.m16300a().f14432d;
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                this.f14920m = 0;
                if (m16713a(context)) {
                    str = "passive";
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.f14916i.requestLocationUpdates(str, 10000, 0.0f, this.f14917j, Looper.getMainLooper());
                }
                this.f14918k = m16711a(str);
                this.f14915h = System.currentTimeMillis() + 90000;
                if (this.f14921n != null) {
                    this.f14921n.cancel();
                    this.f14921n = null;
                }
                C7513ec.m16639a(4, f14908a, "Register location timer");
                this.f14921n = new Timer();
                this.f14921n.schedule(new C7542jb(this), 90000);
                this.f14919l = true;
                C7513ec.m16639a(4, f14908a, "LocationProvider started");
            }
        }
    }

    /* renamed from: a */
    private static boolean m16713a(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    /* renamed from: b */
    private static boolean m16716b(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    /* renamed from: a */
    private Location m16711a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f14916i.getLastKnownLocation(str);
        }
        return null;
    }

    /* renamed from: e */
    public final synchronized void mo23967e() {
        C7513ec.m16639a(4, f14908a, "Stop update location requested");
        m16720h();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m16720h() {
        if (this.f14919l) {
            this.f14916i.removeUpdates(this.f14917j);
            this.f14920m = 0;
            this.f14915h = 0;
            m16721i();
            this.f14919l = false;
            C7513ec.m16639a(4, f14908a, "LocationProvider stopped");
        }
    }

    /* renamed from: i */
    private void m16721i() {
        C7513ec.m16639a(4, f14908a, "Unregister location timer");
        Timer timer = this.f14921n;
        if (timer != null) {
            timer.cancel();
            this.f14921n = null;
        }
    }

    /* renamed from: f */
    public final Location mo23968f() {
        String str;
        Location location = this.f14914g;
        if (location != null) {
            return location;
        }
        Location location2 = null;
        if (this.f14913f) {
            Context context = C7379Fb.m16300a().f14432d;
            if (!m16713a(context) && !m16716b(context)) {
                return null;
            }
            if (m16713a(context)) {
                str = "passive";
            } else {
                str = null;
            }
            if (str != null) {
                Location a = m16711a(str);
                if (a != null) {
                    this.f14918k = a;
                }
                location2 = this.f14918k;
            }
        }
        C7513ec.m16639a(4, f14908a, "getLocation() = ".concat(String.valueOf(location2)));
        return location2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo23820a(java.lang.String r4, java.lang.Object r5) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = -864112343(0xffffffffcc7eb129, float:-6.6765988E7)
            r2 = 1
            if (r0 == r1) goto L_0x001a
            r1 = -300729815(0xffffffffee133a29, float:-1.1391152E28)
            if (r0 == r1) goto L_0x0010
        L_0x000f:
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "ExplicitLocation"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x000f
            r4 = 1
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "ReportLocation"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x000f
            r4 = 0
            goto L_0x0025
        L_0x0024:
            r4 = -1
        L_0x0025:
            r0 = 4
            if (r4 == 0) goto L_0x004d
            if (r4 == r2) goto L_0x0033
            r4 = 6
            java.lang.String r5 = f14908a
            java.lang.String r0 = "LocationProvider internal error! Had to be LocationCriteria, ReportLocation or ExplicitLocation key."
            com.flurry.sdk.C7513ec.m16639a(r4, r5, r0)
            return
        L_0x0033:
            android.location.Location r5 = (android.location.Location) r5
            r3.f14914g = r5
            java.lang.String r4 = f14908a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r1 = "onSettingUpdate, ExplicitLocation = "
            r5.<init>(r1)
            android.location.Location r1 = r3.f14914g
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            com.flurry.sdk.C7513ec.m16639a(r0, r4, r5)
            return
        L_0x004d:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r4 = r5.booleanValue()
            r3.f14913f = r4
            java.lang.String r4 = f14908a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r1 = "onSettingUpdate, ReportLocation = "
            r5.<init>(r1)
            boolean r1 = r3.f14913f
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            com.flurry.sdk.C7513ec.m16639a(r0, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7547kb.mo23820a(java.lang.String, java.lang.Object):void");
    }
}
