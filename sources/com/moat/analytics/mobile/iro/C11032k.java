package com.moat.analytics.mobile.iro;

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

/* renamed from: com.moat.analytics.mobile.iro.k */
final class C11032k implements LocationListener {

    /* renamed from: ˏ */
    private static C11032k f33737 = null;

    /* renamed from: ʼ */
    private boolean f33738;

    /* renamed from: ʽ */
    private Location f33739;

    /* renamed from: ˊ */
    private ScheduledFuture<?> f33740;

    /* renamed from: ˋ */
    private ScheduledFuture<?> f33741;

    /* renamed from: ˎ */
    private LocationManager f33742;

    /* renamed from: ॱ */
    private ScheduledExecutorService f33743;

    /* renamed from: ᐝ */
    private boolean f33744;

    /* renamed from: ˎ */
    static C11032k m36332() {
        if (f33737 == null) {
            f33737 = new C11032k();
        }
        return f33737;
    }

    private C11032k() {
        try {
            this.f33744 = ((C11031j) MoatAnalytics.getInstance()).f33734;
            String str = "LocationManager";
            if (this.f33744) {
                C11011b.m36234(3, str, this, "Moat location services disabled");
                return;
            }
            this.f33743 = Executors.newScheduledThreadPool(1);
            this.f33742 = (LocationManager) C11009a.m36225().getSystemService("location");
            if (this.f33742.getAllProviders().size() == 0) {
                C11011b.m36234(3, str, this, "Device has no location providers");
            } else {
                m36334();
            }
        } catch (Exception e) {
            C11043o.m36351(e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ */
    public final Location mo36116() {
        if (this.f33744 || this.f33742 == null) {
            return null;
        }
        return this.f33739;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˋ */
    public final void mo36115() {
        m36334();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ */
    public final void mo36114() {
        m36329(false);
    }

    public final void onLocationChanged(Location location) {
        String str = "LocationManager";
        try {
            StringBuilder sb = new StringBuilder("Received an updated location = ");
            sb.append(location.toString());
            C11011b.m36234(3, str, this, sb.toString());
            float currentTimeMillis = (float) ((System.currentTimeMillis() - location.getTime()) / 1000);
            if (location.hasAccuracy() && location.getAccuracy() <= 100.0f && currentTimeMillis < 600.0f) {
                this.f33739 = m36326(this.f33739, location);
                C11011b.m36234(3, str, this, "fetchCompleted");
                m36329(true);
            }
        } catch (Exception e) {
            C11043o.m36351(e);
        }
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onProviderDisabled(String str) {
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ */
    public void m36334() {
        try {
            if (!this.f33744) {
                if (this.f33742 != null) {
                    String str = "LocationManager";
                    if (this.f33738) {
                        C11011b.m36234(3, str, this, "already updating location");
                    }
                    C11011b.m36234(3, str, this, "starting location fetch");
                    this.f33739 = m36326(this.f33739, m36323());
                    if (this.f33739 != null) {
                        StringBuilder sb = new StringBuilder("Have a valid location, won't fetch = ");
                        sb.append(this.f33739.toString());
                        C11011b.m36234(3, str, this, sb.toString());
                        m36335();
                        return;
                    }
                    m36338();
                }
            }
        } catch (Exception e) {
            C11043o.m36351(e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˋ */
    public void m36329(boolean z) {
        try {
            C11011b.m36234(3, "LocationManager", this, "stopping location fetch");
            m36325();
            m36328();
            if (z) {
                m36335();
            } else {
                m36324();
            }
        } catch (Exception e) {
            C11043o.m36351(e);
        }
    }

    /* renamed from: ʻ */
    private Location m36323() {
        try {
            boolean r1 = m36331();
            boolean r2 = m36337();
            String str = "network";
            String str2 = "gps";
            if (r1 && r2) {
                return m36326(this.f33742.getLastKnownLocation(str2), this.f33742.getLastKnownLocation(str));
            }
            if (r1) {
                return this.f33742.getLastKnownLocation(str2);
            }
            if (r2) {
                return this.f33742.getLastKnownLocation(str);
            }
            return null;
        } catch (SecurityException e) {
            C11043o.m36351(e);
            return null;
        }
    }

    /* renamed from: ᐝ */
    private void m36338() {
        String str = "LocationManager";
        try {
            if (!this.f33738) {
                C11011b.m36234(3, str, this, "Attempting to start update");
                if (m36331()) {
                    C11011b.m36234(3, str, this, "start updating gps location");
                    this.f33742.requestLocationUpdates("gps", 0, 0.0f, this, Looper.getMainLooper());
                    this.f33738 = true;
                }
                if (m36337()) {
                    C11011b.m36234(3, str, this, "start updating network location");
                    this.f33742.requestLocationUpdates("network", 0, 0.0f, this, Looper.getMainLooper());
                    this.f33738 = true;
                }
                if (this.f33738) {
                    m36328();
                    this.f33741 = this.f33743.schedule(new Runnable() {
                        public final void run() {
                            try {
                                C11011b.m36234(3, "LocationManager", this, "fetchTimedOut");
                                C11032k.this.m36329(true);
                            } catch (Exception e) {
                                C11043o.m36351(e);
                            }
                        }
                    }, 60, TimeUnit.SECONDS);
                }
            }
        } catch (SecurityException e) {
            C11043o.m36351(e);
        }
    }

    /* renamed from: ʽ */
    private void m36325() {
        try {
            C11011b.m36234(3, "LocationManager", this, "Stopping to update location");
            boolean z = true;
            if (!(C0510b.m2565a(C11009a.m36225().getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0)) {
                if (!(C0510b.m2565a(C11009a.m36225().getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0)) {
                    z = false;
                }
            }
            if (z && this.f33742 != null) {
                this.f33742.removeUpdates(this);
                this.f33738 = false;
            }
        } catch (SecurityException e) {
            C11043o.m36351(e);
        }
    }

    /* renamed from: ˊॱ */
    private void m36328() {
        ScheduledFuture<?> scheduledFuture = this.f33741;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f33741.cancel(true);
            this.f33741 = null;
        }
    }

    /* renamed from: ʼ */
    private void m36324() {
        ScheduledFuture<?> scheduledFuture = this.f33740;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f33740.cancel(true);
            this.f33740 = null;
        }
    }

    /* renamed from: ˏॱ */
    private void m36335() {
        C11011b.m36234(3, "LocationManager", this, "Resetting fetch timer");
        m36324();
        Location location = this.f33739;
        float f = 600.0f;
        if (location != null) {
            f = Math.max(600.0f - ((float) ((System.currentTimeMillis() - location.getTime()) / 1000)), 0.0f);
        }
        this.f33740 = this.f33743.schedule(new Runnable() {
            public final void run() {
                try {
                    C11011b.m36234(3, "LocationManager", this, "fetchTimerCompleted");
                    C11032k.this.m36334();
                } catch (Exception e) {
                    C11043o.m36351(e);
                }
            }
        }, (long) f, TimeUnit.SECONDS);
    }

    /* renamed from: ˋॱ */
    private boolean m36331() {
        if (C0510b.m2565a(C11009a.m36225().getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            String str = "gps";
            return this.f33742.getProvider(str) != null && this.f33742.isProviderEnabled(str);
        }
    }

    /* renamed from: ˊ */
    private static Location m36326(Location location, Location location2) {
        boolean r0 = m36330(location);
        boolean r1 = m36330(location2);
        if (r0) {
            return (r1 && location.getAccuracy() >= location.getAccuracy()) ? location2 : location;
        }
        if (!r1) {
            return null;
        }
        return location2;
    }

    /* renamed from: ˋ */
    private static boolean m36330(Location location) {
        if (location == null) {
            return false;
        }
        if ((location.getLatitude() != 0.0d || location.getLongitude() != 0.0d) && location.getAccuracy() >= 0.0f && ((float) ((System.currentTimeMillis() - location.getTime()) / 1000)) < 600.0f) {
            return true;
        }
        return false;
    }

    /* renamed from: ˎ */
    static boolean m36333(Location location, Location location2) {
        if (location == location2) {
            return true;
        }
        if (location == null || location2 == null || location.getTime() != location2.getTime()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* renamed from: ॱˋ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m36337() {
        /*
            r4 = this;
            android.app.Application r0 = com.moat.analytics.mobile.iro.C11009a.m36225()
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "android.permission.ACCESS_FINE_LOCATION"
            int r0 = android.support.p000v4.content.C0510b.m2565a(r0, r1)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            if (r0 != 0) goto L_0x0031
            android.app.Application r0 = com.moat.analytics.mobile.iro.C11009a.m36225()
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r3 = "android.permission.ACCESS_COARSE_LOCATION"
            int r0 = android.support.p000v4.content.C0510b.m2565a(r0, r3)
            if (r0 != 0) goto L_0x002b
            r0 = 1
            goto L_0x002c
        L_0x002b:
            r0 = 0
        L_0x002c:
            if (r0 == 0) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            r0 = 0
            goto L_0x0032
        L_0x0031:
            r0 = 1
        L_0x0032:
            if (r0 == 0) goto L_0x0047
            android.location.LocationManager r0 = r4.f33742
            java.lang.String r3 = "network"
            android.location.LocationProvider r0 = r0.getProvider(r3)
            if (r0 == 0) goto L_0x0047
            android.location.LocationManager r0 = r4.f33742
            boolean r0 = r0.isProviderEnabled(r3)
            if (r0 == 0) goto L_0x0047
            return r1
        L_0x0047:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.iro.C11032k.m36337():boolean");
    }
}
