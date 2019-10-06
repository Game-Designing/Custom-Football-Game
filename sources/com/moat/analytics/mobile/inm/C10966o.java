package com.moat.analytics.mobile.inm;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.support.p000v4.content.C0510b;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.moat.analytics.mobile.inm.o */
class C10966o implements LocationListener {

    /* renamed from: a */
    private static C10966o f33531a = null;

    /* renamed from: b */
    private ScheduledExecutorService f33532b;

    /* renamed from: c */
    private ScheduledFuture<?> f33533c;

    /* renamed from: d */
    private ScheduledFuture<?> f33534d;

    /* renamed from: e */
    private LocationManager f33535e;

    /* renamed from: f */
    private boolean f33536f;

    /* renamed from: g */
    private Location f33537g;

    /* renamed from: h */
    private boolean f33538h;

    private C10966o() {
        try {
            this.f33536f = ((C10958k) MoatAnalytics.getInstance()).f33508c;
            String str = "LocationManager";
            if (this.f33536f) {
                C10969p.m36113a(3, str, (Object) this, "Moat location services disabled");
                return;
            }
            this.f33532b = Executors.newScheduledThreadPool(1);
            this.f33535e = (LocationManager) C10929a.m35944a().getSystemService("location");
            if (this.f33535e.getAllProviders().size() == 0) {
                C10969p.m36113a(3, str, (Object) this, "Device has no location providers");
            } else {
                m36098e();
            }
        } catch (Exception e) {
            C10960m.m36077a(e);
        }
    }

    /* renamed from: a */
    static C10966o m36089a() {
        if (f33531a == null) {
            f33531a = new C10966o();
        }
        return f33531a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36092a(boolean z) {
        try {
            C10969p.m36113a(3, "LocationManager", (Object) this, "stopping location fetch");
            m36101h();
            m36102i();
            if (z) {
                m36104k();
            } else {
                m36103j();
            }
        } catch (Exception e) {
            C10960m.m36077a(e);
        }
    }

    /* renamed from: a */
    private static boolean m36093a(Location location) {
        if (location == null) {
            return false;
        }
        return !(location.getLatitude() == 0.0d && location.getLongitude() == 0.0d) && location.getAccuracy() >= 0.0f && m36096b(location) < 600.0f;
    }

    /* renamed from: a */
    static boolean m36094a(Location location, Location location2) {
        if (location == location2) {
            return true;
        }
        return (location == null || location2 == null || location.getTime() != location2.getTime()) ? false : true;
    }

    /* renamed from: a */
    private static boolean m36095a(String str) {
        return C0510b.m2565a(C10929a.m35944a().getApplicationContext(), str) == 0;
    }

    /* renamed from: b */
    private static float m36096b(Location location) {
        return (float) ((System.currentTimeMillis() - location.getTime()) / 1000);
    }

    /* renamed from: b */
    private static Location m36097b(Location location, Location location2) {
        boolean a = m36093a(location);
        boolean a2 = m36093a(location2);
        if (a) {
            return (a2 && location.getAccuracy() >= location.getAccuracy()) ? location2 : location;
        }
        if (!a2) {
            return null;
        }
        return location2;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m36098e() {
        try {
            if (!this.f33536f) {
                if (this.f33535e != null) {
                    String str = "LocationManager";
                    if (this.f33538h) {
                        C10969p.m36113a(3, str, (Object) this, "already updating location");
                    }
                    C10969p.m36113a(3, str, (Object) this, "starting location fetch");
                    this.f33537g = m36097b(this.f33537g, m36099f());
                    if (this.f33537g != null) {
                        StringBuilder sb = new StringBuilder("Have a valid location, won't fetch = ");
                        sb.append(this.f33537g.toString());
                        C10969p.m36113a(3, str, (Object) this, sb.toString());
                        m36104k();
                        return;
                    }
                    m36100g();
                }
            }
        } catch (Exception e) {
            C10960m.m36077a(e);
        }
    }

    /* renamed from: f */
    private Location m36099f() {
        try {
            boolean l = m36105l();
            boolean m = m36106m();
            String str = "network";
            String str2 = "gps";
            if (l && m) {
                return m36097b(this.f33535e.getLastKnownLocation(str2), this.f33535e.getLastKnownLocation(str));
            }
            if (l) {
                return this.f33535e.getLastKnownLocation(str2);
            }
            if (m) {
                return this.f33535e.getLastKnownLocation(str);
            }
            return null;
        } catch (SecurityException e) {
            C10960m.m36077a(e);
            return null;
        }
    }

    /* renamed from: g */
    private void m36100g() {
        String str = "LocationManager";
        try {
            if (!this.f33538h) {
                C10969p.m36113a(3, str, (Object) this, "Attempting to start update");
                if (m36105l()) {
                    C10969p.m36113a(3, str, (Object) this, "start updating gps location");
                    this.f33535e.requestLocationUpdates("gps", 0, 0.0f, this, Looper.getMainLooper());
                    this.f33538h = true;
                }
                if (m36106m()) {
                    C10969p.m36113a(3, str, (Object) this, "start updating network location");
                    this.f33535e.requestLocationUpdates("network", 0, 0.0f, this, Looper.getMainLooper());
                    this.f33538h = true;
                }
                if (this.f33538h) {
                    m36102i();
                    this.f33534d = this.f33532b.schedule(new Runnable() {
                        public void run() {
                            try {
                                C10969p.m36113a(3, "LocationManager", (Object) this, "fetchTimedOut");
                                C10966o.this.m36092a(true);
                            } catch (Exception e) {
                                C10960m.m36077a(e);
                            }
                        }
                    }, 60, TimeUnit.SECONDS);
                }
            }
        } catch (SecurityException e) {
            C10960m.m36077a(e);
        }
    }

    /* renamed from: h */
    private void m36101h() {
        try {
            C10969p.m36113a(3, "LocationManager", (Object) this, "Stopping to update location");
            if (m36107n() && this.f33535e != null) {
                this.f33535e.removeUpdates(this);
                this.f33538h = false;
            }
        } catch (SecurityException e) {
            C10960m.m36077a(e);
        }
    }

    /* renamed from: i */
    private void m36102i() {
        ScheduledFuture<?> scheduledFuture = this.f33534d;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f33534d.cancel(true);
            this.f33534d = null;
        }
    }

    /* renamed from: j */
    private void m36103j() {
        ScheduledFuture<?> scheduledFuture = this.f33533c;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f33533c.cancel(true);
            this.f33533c = null;
        }
    }

    /* renamed from: k */
    private void m36104k() {
        C10969p.m36113a(3, "LocationManager", (Object) this, "Resetting fetch timer");
        m36103j();
        Location location = this.f33537g;
        float f = 600.0f;
        if (location != null) {
            f = Math.max(600.0f - m36096b(location), 0.0f);
        }
        this.f33533c = this.f33532b.schedule(new Runnable() {
            public void run() {
                try {
                    C10969p.m36113a(3, "LocationManager", (Object) this, "fetchTimerCompleted");
                    C10966o.this.m36098e();
                } catch (Exception e) {
                    C10960m.m36077a(e);
                }
            }
        }, (long) f, TimeUnit.SECONDS);
    }

    /* renamed from: l */
    private boolean m36105l() {
        if (m36095a("android.permission.ACCESS_FINE_LOCATION")) {
            String str = "gps";
            if (this.f33535e.getProvider(str) != null && this.f33535e.isProviderEnabled(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: m */
    private boolean m36106m() {
        if (m36107n()) {
            String str = "network";
            if (this.f33535e.getProvider(str) != null && this.f33535e.isProviderEnabled(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: n */
    private static boolean m36107n() {
        return m36095a("android.permission.ACCESS_FINE_LOCATION") || m36095a("android.permission.ACCESS_COARSE_LOCATION");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Location mo35961b() {
        if (this.f33536f || this.f33535e == null) {
            return null;
        }
        return this.f33537g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo35962c() {
        m36098e();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo35963d() {
        m36092a(false);
    }

    public void onLocationChanged(Location location) {
        String str = "LocationManager";
        try {
            StringBuilder sb = new StringBuilder("Received an updated location = ");
            sb.append(location.toString());
            C10969p.m36113a(3, str, (Object) this, sb.toString());
            float b = m36096b(location);
            if (location.hasAccuracy() && location.getAccuracy() <= 100.0f && b < 600.0f) {
                this.f33537g = m36097b(this.f33537g, location);
                C10969p.m36113a(3, str, (Object) this, "fetchCompleted");
                m36092a(true);
            }
        } catch (Exception e) {
            C10960m.m36077a(e);
        }
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
