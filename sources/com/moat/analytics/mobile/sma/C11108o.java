package com.moat.analytics.mobile.sma;

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

/* renamed from: com.moat.analytics.mobile.sma.o */
class C11108o implements LocationListener {

    /* renamed from: a */
    private static C11108o f33952a = null;

    /* renamed from: b */
    private ScheduledExecutorService f33953b;

    /* renamed from: c */
    private ScheduledFuture<?> f33954c;

    /* renamed from: d */
    private ScheduledFuture<?> f33955d;

    /* renamed from: e */
    private LocationManager f33956e;

    /* renamed from: f */
    private boolean f33957f;

    /* renamed from: g */
    private Location f33958g;

    /* renamed from: h */
    private boolean f33959h;

    private C11108o() {
        String str;
        try {
            this.f33957f = ((C11100k) MoatAnalytics.getInstance()).f33934c;
            String str2 = "LocationManager";
            if (this.f33957f) {
                str = "Moat location services disabled";
            } else {
                this.f33953b = Executors.newScheduledThreadPool(1);
                this.f33956e = (LocationManager) C11073a.m36432a().getSystemService("location");
                if (this.f33956e.getAllProviders().size() == 0) {
                    str = "Device has no location providers";
                } else {
                    m36563e();
                    return;
                }
            }
            C11111p.m36577a(3, str2, (Object) this, str);
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
    }

    /* renamed from: a */
    static C11108o m36554a() {
        if (f33952a == null) {
            f33952a = new C11108o();
        }
        return f33952a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36557a(boolean z) {
        try {
            C11111p.m36577a(3, "LocationManager", (Object) this, "stopping location fetch");
            m36566h();
            m36567i();
            if (z) {
                m36569k();
            } else {
                m36568j();
            }
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
    }

    /* renamed from: a */
    private static boolean m36558a(Location location) {
        if (location == null) {
            return false;
        }
        return !(location.getLatitude() == 0.0d && location.getLongitude() == 0.0d) && location.getAccuracy() >= 0.0f && m36561b(location) < 600.0f;
    }

    /* renamed from: a */
    static boolean m36559a(Location location, Location location2) {
        if (location == location2) {
            return true;
        }
        return (location == null || location2 == null || location.getTime() != location2.getTime()) ? false : true;
    }

    /* renamed from: a */
    private static boolean m36560a(String str) {
        return C0510b.m2565a(C11073a.m36432a().getApplicationContext(), str) == 0;
    }

    /* renamed from: b */
    private static float m36561b(Location location) {
        return (float) ((System.currentTimeMillis() - location.getTime()) / 1000);
    }

    /* renamed from: b */
    private static Location m36562b(Location location, Location location2) {
        boolean a = m36558a(location);
        boolean a2 = m36558a(location2);
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
    public void m36563e() {
        try {
            if (!this.f33957f) {
                if (this.f33956e != null) {
                    String str = "LocationManager";
                    if (this.f33959h) {
                        C11111p.m36577a(3, str, (Object) this, "already updating location");
                    }
                    C11111p.m36577a(3, str, (Object) this, "starting location fetch");
                    Location b = mo36241b();
                    if (b != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Have a valid location, won't fetch = ");
                        sb.append(b.toString());
                        C11111p.m36577a(3, str, (Object) this, sb.toString());
                        m36569k();
                        return;
                    }
                    m36565g();
                }
            }
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
    }

    /* renamed from: f */
    private Location m36564f() {
        try {
            boolean l = m36570l();
            boolean m = m36571m();
            String str = "network";
            String str2 = "gps";
            if (l && m) {
                return m36562b(this.f33956e.getLastKnownLocation(str2), this.f33956e.getLastKnownLocation(str));
            }
            if (l) {
                return this.f33956e.getLastKnownLocation(str2);
            }
            if (m) {
                return this.f33956e.getLastKnownLocation(str);
            }
            return null;
        } catch (SecurityException e) {
            C11102m.m36543a(e);
            return null;
        }
    }

    /* renamed from: g */
    private void m36565g() {
        String str = "LocationManager";
        try {
            if (!this.f33959h) {
                C11111p.m36577a(3, str, (Object) this, "Attempting to start update");
                if (m36570l()) {
                    C11111p.m36577a(3, str, (Object) this, "start updating gps location");
                    this.f33956e.requestLocationUpdates("gps", 0, 0.0f, this, Looper.getMainLooper());
                    this.f33959h = true;
                }
                if (m36571m()) {
                    C11111p.m36577a(3, str, (Object) this, "start updating network location");
                    this.f33956e.requestLocationUpdates("network", 0, 0.0f, this, Looper.getMainLooper());
                    this.f33959h = true;
                }
                if (this.f33959h) {
                    m36567i();
                    this.f33955d = this.f33953b.schedule(new Runnable() {
                        public void run() {
                            try {
                                C11111p.m36577a(3, "LocationManager", (Object) this, "fetchTimedOut");
                                C11108o.this.m36557a(true);
                            } catch (Exception e) {
                                C11102m.m36543a(e);
                            }
                        }
                    }, 60, TimeUnit.SECONDS);
                }
            }
        } catch (SecurityException e) {
            C11102m.m36543a(e);
        }
    }

    /* renamed from: h */
    private void m36566h() {
        try {
            C11111p.m36577a(3, "LocationManager", (Object) this, "Stopping to update location");
            if (m36572n() && this.f33956e != null) {
                this.f33956e.removeUpdates(this);
                this.f33959h = false;
            }
        } catch (SecurityException e) {
            C11102m.m36543a(e);
        }
    }

    /* renamed from: i */
    private void m36567i() {
        ScheduledFuture<?> scheduledFuture = this.f33955d;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f33955d.cancel(true);
            this.f33955d = null;
        }
    }

    /* renamed from: j */
    private void m36568j() {
        ScheduledFuture<?> scheduledFuture = this.f33954c;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f33954c.cancel(true);
            this.f33954c = null;
        }
    }

    /* renamed from: k */
    private void m36569k() {
        C11111p.m36577a(3, "LocationManager", (Object) this, "Resetting fetch timer");
        m36568j();
        Location b = mo36241b();
        float f = 600.0f;
        if (b != null) {
            f = Math.max(600.0f - m36561b(b), 0.0f);
        }
        this.f33954c = this.f33953b.schedule(new Runnable() {
            public void run() {
                try {
                    C11111p.m36577a(3, "LocationManager", (Object) this, "fetchTimerCompleted");
                    C11108o.this.m36563e();
                } catch (Exception e) {
                    C11102m.m36543a(e);
                }
            }
        }, (long) f, TimeUnit.SECONDS);
    }

    /* renamed from: l */
    private boolean m36570l() {
        if (m36560a("android.permission.ACCESS_FINE_LOCATION")) {
            String str = "gps";
            if (this.f33956e.getProvider(str) != null && this.f33956e.isProviderEnabled(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: m */
    private boolean m36571m() {
        if (m36572n()) {
            String str = "network";
            if (this.f33956e.getProvider(str) != null && this.f33956e.isProviderEnabled(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: n */
    private static boolean m36572n() {
        return m36560a("android.permission.ACCESS_FINE_LOCATION") || m36560a("android.permission.ACCESS_COARSE_LOCATION");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Location mo36241b() {
        if (!this.f33957f && this.f33956e != null) {
            try {
                this.f33958g = m36562b(this.f33958g, m36564f());
                return this.f33958g;
            } catch (Exception e) {
                C11102m.m36543a(e);
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo36242c() {
        m36563e();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo36243d() {
        m36557a(false);
    }

    public void onLocationChanged(Location location) {
        String str = "LocationManager";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Received an updated location = ");
            sb.append(location.toString());
            C11111p.m36577a(3, str, (Object) this, sb.toString());
            float b = m36561b(location);
            if (location.hasAccuracy() && location.getAccuracy() <= 100.0f && b < 600.0f) {
                this.f33958g = m36562b(this.f33958g, location);
                C11111p.m36577a(3, str, (Object) this, "fetchCompleted");
                m36557a(true);
            }
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
