package android.support.p001v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.p000v4.content.C0527k;
import android.util.Log;
import java.util.Calendar;
import p005cm.aptoide.p006pt.notification.PullingContentService;

/* renamed from: android.support.v7.app.L */
/* compiled from: TwilightManager */
class C0753L {

    /* renamed from: a */
    private static C0753L f2261a;

    /* renamed from: b */
    private final Context f2262b;

    /* renamed from: c */
    private final LocationManager f2263c;

    /* renamed from: d */
    private final C0754a f2264d = new C0754a();

    /* renamed from: android.support.v7.app.L$a */
    /* compiled from: TwilightManager */
    private static class C0754a {

        /* renamed from: a */
        boolean f2265a;

        /* renamed from: b */
        long f2266b;

        /* renamed from: c */
        long f2267c;

        /* renamed from: d */
        long f2268d;

        /* renamed from: e */
        long f2269e;

        /* renamed from: f */
        long f2270f;

        C0754a() {
        }
    }

    /* renamed from: a */
    static C0753L m3524a(Context context) {
        if (f2261a == null) {
            Context context2 = context.getApplicationContext();
            f2261a = new C0753L(context2, (LocationManager) context2.getSystemService("location"));
        }
        return f2261a;
    }

    C0753L(Context context, LocationManager locationManager) {
        this.f2262b = context;
        this.f2263c = locationManager;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo6169a() {
        C0754a state = this.f2264d;
        if (m3527c()) {
            return state.f2265a;
        }
        Location location = m3526b();
        if (location != null) {
            m3525a(location);
            return state.f2265a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int hour = Calendar.getInstance().get(11);
        return hour < 6 || hour >= 22;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    private Location m3526b() {
        Location coarseLoc = null;
        Location fineLoc = null;
        if (C0527k.m2620b(this.f2262b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            coarseLoc = m3523a("network");
        }
        if (C0527k.m2620b(this.f2262b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            fineLoc = m3523a("gps");
        }
        if (fineLoc == null || coarseLoc == null) {
            return fineLoc != null ? fineLoc : coarseLoc;
        }
        return fineLoc.getTime() > coarseLoc.getTime() ? fineLoc : coarseLoc;
    }

    /* renamed from: a */
    private Location m3523a(String provider) {
        try {
            if (this.f2263c.isProviderEnabled(provider)) {
                return this.f2263c.getLastKnownLocation(provider);
            }
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
        }
        return null;
    }

    /* renamed from: c */
    private boolean m3527c() {
        return this.f2264d.f2270f > System.currentTimeMillis();
    }

    /* renamed from: a */
    private void m3525a(Location location) {
        long nextUpdate;
        long nextUpdate2;
        C0754a state = this.f2264d;
        long now = System.currentTimeMillis();
        C0752K calculator = C0752K.m3521a();
        C0752K k = calculator;
        k.mo6168a(now - PullingContentService.UPDATES_INTERVAL, location.getLatitude(), location.getLongitude());
        long yesterdaySunset = calculator.f2258b;
        k.mo6168a(now, location.getLatitude(), location.getLongitude());
        boolean z = true;
        if (calculator.f2260d != 1) {
            z = false;
        }
        boolean isNight = z;
        long todaySunrise = calculator.f2259c;
        long todaySunset = calculator.f2258b;
        long j = PullingContentService.UPDATES_INTERVAL + now;
        long yesterdaySunset2 = yesterdaySunset;
        long todaySunset2 = todaySunset;
        long todaySunset3 = j;
        long todaySunrise2 = todaySunrise;
        boolean isNight2 = isNight;
        calculator.mo6168a(todaySunset3, location.getLatitude(), location.getLongitude());
        long tomorrowSunrise = calculator.f2259c;
        if (todaySunrise2 == -1 || todaySunset2 == -1) {
            nextUpdate = now + 43200000;
        } else {
            if (now > todaySunset2) {
                nextUpdate2 = 0 + tomorrowSunrise;
            } else if (now > todaySunrise2) {
                nextUpdate2 = 0 + todaySunset2;
            } else {
                nextUpdate2 = 0 + todaySunrise2;
            }
            nextUpdate = nextUpdate2 + 60000;
        }
        state.f2265a = isNight2;
        state.f2266b = yesterdaySunset2;
        state.f2267c = todaySunrise2;
        state.f2268d = todaySunset2;
        state.f2269e = tomorrowSunrise;
        state.f2270f = nextUpdate;
    }
}
