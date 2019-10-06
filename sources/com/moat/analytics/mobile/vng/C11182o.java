package com.moat.analytics.mobile.vng;

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

/* renamed from: com.moat.analytics.mobile.vng.o */
class C11182o implements LocationListener {

    /* renamed from: a */
    private static C11182o f34139a = null;

    /* renamed from: b */
    private ScheduledExecutorService f34140b;

    /* renamed from: c */
    private ScheduledFuture<?> f34141c;

    /* renamed from: d */
    private ScheduledFuture<?> f34142d;

    /* renamed from: e */
    private LocationManager f34143e;

    /* renamed from: f */
    private boolean f34144f;

    /* renamed from: g */
    private Location f34145g;

    /* renamed from: h */
    private boolean f34146h;

    private C11182o() {
        String str;
        try {
            this.f34144f = ((C11174k) MoatAnalytics.getInstance()).f34121c;
            String str2 = "LocationManager";
            if (this.f34144f) {
                str = "Moat location services disabled";
            } else {
                this.f34140b = Executors.newScheduledThreadPool(1);
                this.f34143e = (LocationManager) C11144a.m36673a().getSystemService("location");
                if (this.f34143e.getAllProviders().size() == 0) {
                    str = "Device has no location providers";
                } else {
                    m36803e();
                    return;
                }
            }
            C11185p.m36817a(3, str2, (Object) this, str);
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
    }

    /* renamed from: a */
    static C11182o m36794a() {
        if (f34139a == null) {
            f34139a = new C11182o();
        }
        return f34139a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36797a(boolean z) {
        try {
            C11185p.m36817a(3, "LocationManager", (Object) this, "stopping location fetch");
            m36806h();
            m36807i();
            if (z) {
                m36809k();
            } else {
                m36808j();
            }
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
    }

    /* renamed from: a */
    private static boolean m36798a(Location location) {
        if (location == null) {
            return false;
        }
        return !(location.getLatitude() == 0.0d && location.getLongitude() == 0.0d) && location.getAccuracy() >= 0.0f && m36801b(location) < 600.0f;
    }

    /* renamed from: a */
    static boolean m36799a(Location location, Location location2) {
        if (location == location2) {
            return true;
        }
        return (location == null || location2 == null || location.getTime() != location2.getTime()) ? false : true;
    }

    /* renamed from: a */
    private static boolean m36800a(String str) {
        return C0510b.m2565a(C11144a.m36673a().getApplicationContext(), str) == 0;
    }

    /* renamed from: b */
    private static float m36801b(Location location) {
        return (float) ((System.currentTimeMillis() - location.getTime()) / 1000);
    }

    /* renamed from: b */
    private static Location m36802b(Location location, Location location2) {
        boolean a = m36798a(location);
        boolean a2 = m36798a(location2);
        if (!a) {
            if (!a2) {
                return null;
            }
            return location2;
        } else if (!a2) {
            return location;
        } else {
            if (location.getAccuracy() >= location.getAccuracy()) {
                location = location2;
            }
            return location;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m36803e() {
        try {
            if (!this.f34144f) {
                if (this.f34143e != null) {
                    String str = "LocationManager";
                    if (this.f34146h) {
                        C11185p.m36817a(3, str, (Object) this, "already updating location");
                    }
                    C11185p.m36817a(3, str, (Object) this, "starting location fetch");
                    Location b = mo36373b();
                    if (b != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Have a valid location, won't fetch = ");
                        sb.append(b.toString());
                        C11185p.m36817a(3, str, (Object) this, sb.toString());
                        m36809k();
                        return;
                    }
                    m36805g();
                }
            }
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
    }

    /* renamed from: f */
    private Location m36804f() {
        try {
            boolean l = m36810l();
            boolean m = m36811m();
            String str = "network";
            String str2 = "gps";
            if (l && m) {
                return m36802b(this.f34143e.getLastKnownLocation(str2), this.f34143e.getLastKnownLocation(str));
            }
            if (l) {
                return this.f34143e.getLastKnownLocation(str2);
            }
            if (m) {
                return this.f34143e.getLastKnownLocation(str);
            }
            return null;
        } catch (SecurityException e) {
            C11176m.m36783a(e);
            return null;
        }
    }

    /* renamed from: g */
    private void m36805g() {
        String str = "LocationManager";
        try {
            if (!this.f34146h) {
                C11185p.m36817a(3, str, (Object) this, "Attempting to start update");
                if (m36810l()) {
                    C11185p.m36817a(3, str, (Object) this, "start updating gps location");
                    this.f34143e.requestLocationUpdates("gps", 0, 0.0f, this, Looper.getMainLooper());
                    this.f34146h = true;
                }
                if (m36811m()) {
                    C11185p.m36817a(3, str, (Object) this, "start updating network location");
                    this.f34143e.requestLocationUpdates("network", 0, 0.0f, this, Looper.getMainLooper());
                    this.f34146h = true;
                }
                if (this.f34146h) {
                    m36807i();
                    this.f34142d = this.f34140b.schedule(new Runnable() {
                        public void run() {
                            try {
                                C11185p.m36817a(3, "LocationManager", (Object) this, "fetchTimedOut");
                                C11182o.this.m36797a(true);
                            } catch (Exception e) {
                                C11176m.m36783a(e);
                            }
                        }
                    }, 60, TimeUnit.SECONDS);
                }
            }
        } catch (SecurityException e) {
            C11176m.m36783a(e);
        }
    }

    /* renamed from: h */
    private void m36806h() {
        try {
            C11185p.m36817a(3, "LocationManager", (Object) this, "Stopping to update location");
            if (m36812n() && this.f34143e != null) {
                this.f34143e.removeUpdates(this);
                this.f34146h = false;
            }
        } catch (SecurityException e) {
            C11176m.m36783a(e);
        }
    }

    /* renamed from: i */
    private void m36807i() {
        ScheduledFuture<?> scheduledFuture = this.f34142d;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f34142d.cancel(true);
            this.f34142d = null;
        }
    }

    /* renamed from: j */
    private void m36808j() {
        ScheduledFuture<?> scheduledFuture = this.f34141c;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f34141c.cancel(true);
            this.f34141c = null;
        }
    }

    /* renamed from: k */
    private void m36809k() {
        C11185p.m36817a(3, "LocationManager", (Object) this, "Resetting fetch timer");
        m36808j();
        Location b = mo36373b();
        float f = 600.0f;
        if (b != null) {
            f = Math.max(600.0f - m36801b(b), 0.0f);
        }
        this.f34141c = this.f34140b.schedule(new Runnable() {
            public void run() {
                try {
                    C11185p.m36817a(3, "LocationManager", (Object) this, "fetchTimerCompleted");
                    C11182o.this.m36803e();
                } catch (Exception e) {
                    C11176m.m36783a(e);
                }
            }
        }, (long) f, TimeUnit.SECONDS);
    }

    /* renamed from: l */
    private boolean m36810l() {
        if (m36800a("android.permission.ACCESS_FINE_LOCATION")) {
            String str = "gps";
            if (this.f34143e.getProvider(str) != null && this.f34143e.isProviderEnabled(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: m */
    private boolean m36811m() {
        if (m36812n()) {
            String str = "network";
            if (this.f34143e.getProvider(str) != null && this.f34143e.isProviderEnabled(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: n */
    private static boolean m36812n() {
        return m36800a("android.permission.ACCESS_FINE_LOCATION") || m36800a("android.permission.ACCESS_COARSE_LOCATION");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Location mo36373b() {
        if (!this.f34144f && this.f34143e != null) {
            try {
                this.f34145g = m36802b(this.f34145g, m36804f());
                return this.f34145g;
            } catch (Exception e) {
                C11176m.m36783a(e);
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo36374c() {
        m36803e();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo36375d() {
        m36797a(false);
    }

    public void onLocationChanged(Location location) {
        String str = "LocationManager";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Received an updated location = ");
            sb.append(location.toString());
            C11185p.m36817a(3, str, (Object) this, sb.toString());
            float b = m36801b(location);
            if (location.hasAccuracy() && location.getAccuracy() <= 100.0f && b < 600.0f) {
                this.f34145g = m36802b(this.f34145g, location);
                C11185p.m36817a(3, str, (Object) this, "fetchCompleted");
                m36797a(true);
            }
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
