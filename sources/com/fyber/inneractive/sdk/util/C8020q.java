package com.fyber.inneractive.sdk.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import com.fyber.inneractive.sdk.util.C8001g.C8002a;

/* renamed from: com.fyber.inneractive.sdk.util.q */
public final class C8020q {

    /* renamed from: a */
    public Context f16351a;

    /* renamed from: b */
    public Location f16352b;

    /* renamed from: c */
    public C8002a f16353c;

    /* renamed from: d */
    public Handler f16354d;

    /* renamed from: e */
    public Runnable f16355e;

    /* renamed from: f */
    public LocationListener f16356f;

    /* renamed from: g */
    public LocationListener f16357g;

    /* renamed from: h */
    public long f16358h;

    /* renamed from: com.fyber.inneractive.sdk.util.q$a */
    private static class C8025a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static C8020q f16363a = new C8020q(0);
    }

    /* synthetic */ C8020q(byte b) {
        this();
    }

    private C8020q() {
        this.f16352b = null;
    }

    /* renamed from: a */
    public final void mo24854a() {
        Runnable runnable = this.f16355e;
        if (runnable != null) {
            Handler handler = this.f16354d;
            if (handler != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }

    /* renamed from: a */
    public final void mo24855a(LocationListener locationListener) {
        if (locationListener != null) {
            StringBuilder sb = new StringBuilder("Location Manager: unregistering location listener: ");
            sb.append(locationListener);
            IAlog.m18021b(sb.toString());
            Context context = this.f16351a;
            if (context == null) {
                IAlog.m18021b("Location Manager: unregisterFromLocationUpdates called, but context is null!");
            } else if (locationListener != null) {
                try {
                    ((LocationManager) context.getSystemService("location")).removeUpdates(locationListener);
                } catch (Exception e) {
                    IAlog.m18021b("Location Manager: Error retrieved when trying to stop location updates - updates were already paused.");
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo24856a(String str, LocationListener locationListener) {
        Context context = this.f16351a;
        if (context == null) {
            IAlog.m18021b("Location Manager: registerForASingleLocationUpdate called, but context is null!");
            return;
        }
        try {
            ((LocationManager) context.getSystemService("location")).requestLocationUpdates(str, 0, 0.0f, locationListener, this.f16351a.getMainLooper());
            StringBuilder sb = new StringBuilder("Location Manager: Successfully registered for ");
            sb.append(str);
            sb.append(" location update");
            IAlog.m18021b(sb.toString());
        } catch (SecurityException e) {
            IAlog.m18021b("Location Manager: Error retrieved when trying to get the network location - access appears to be disabled.");
        } catch (IllegalArgumentException e2) {
            IAlog.m18021b("Location Manager: Error retrieved when trying to get the network location - device has no network provider.");
        } catch (NullPointerException e3) {
            IAlog.m18021b("Location Manager: Error retrieved when trying to get the network location - NPE.");
        }
    }

    /* renamed from: a */
    public static Location m18104a(Location location, Location location2) {
        if (location == null && location2 == null) {
            return null;
        }
        if (location == null || location2 == null) {
            if (location != null) {
                return location;
            }
            return location2;
        } else if (location.getTime() > location2.getTime()) {
            return location;
        } else {
            return location2;
        }
    }
}
