package com.inmobi.p207a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.p222e.C10669f;
import com.inmobi.commons.core.utilities.C10701e;
import com.inmobi.commons.core.utilities.p225b.C10697g;
import com.inmobi.commons.p217a.C10619a;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;

/* renamed from: com.inmobi.a.m */
/* compiled from: LocationInfo */
public class C10296m implements LocationListener {

    /* renamed from: a */
    static boolean f31195a = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final String f31196e = C10296m.class.getSimpleName();

    /* renamed from: f */
    private static C10296m f31197f;

    /* renamed from: g */
    private static final Object f31198g = new Object();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static boolean f31199h = false;

    /* renamed from: b */
    LocationManager f31200b;

    /* renamed from: c */
    HandlerThread f31201c = new HandlerThread("LThread");

    /* renamed from: d */
    GoogleApiClient f31202d;

    /* renamed from: a */
    public static C10296m m33551a() {
        C10296m mVar = f31197f;
        if (mVar == null) {
            synchronized (f31198g) {
                mVar = f31197f;
                if (mVar == null) {
                    mVar = new C10296m();
                    f31197f = mVar;
                }
            }
        }
        return mVar;
    }

    private C10296m() {
        this.f31201c.start();
        this.f31200b = (LocationManager) C10619a.m34839b().getSystemService("location");
    }

    /* renamed from: b */
    static boolean m33554b() {
        try {
            GoogleApiClient.class.getName();
            FusedLocationProviderClient.class.getName();
            LocationServices.class.getName();
            return false;
        } catch (NoClassDefFoundError e) {
            return true;
        }
    }

    /* renamed from: c */
    static boolean m33556c() {
        String str = "signals";
        try {
            if (C10701e.m35150a(C10619a.m34839b(), str, "android.permission.ACCESS_FINE_LOCATION") || C10701e.m35150a(C10619a.m34839b(), str, "android.permission.ACCESS_COARSE_LOCATION")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void onLocationChanged(Location location) {
        if (location != null) {
            try {
                StringBuilder sb = new StringBuilder("location changed. ts:");
                sb.append(location.getTime());
                sb.append(" lat:");
                sb.append(location.getLatitude());
                sb.append(":");
                sb.append(location.getLongitude());
                sb.append(" accu:");
                sb.append(location.getAccuracy());
            } catch (Exception e) {
                C10621a.m34854a().mo34423a(new C10658a(e));
                return;
            }
        }
        if (m33556c()) {
            this.f31200b.removeUpdates(this);
        }
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onProviderDisabled(String str) {
    }

    /* renamed from: d */
    public final synchronized HashMap<String, Object> mo33655d() {
        return m33552a(m33558i(), true);
    }

    /* renamed from: e */
    public final HashMap<String, String> mo33656e() {
        HashMap<String, String> hashMap = new HashMap<>();
        String str = "DENIED";
        if (m33556c() && mo33658g()) {
            str = "AUTHORISED";
        }
        hashMap.put("loc-consent-status", str.toLowerCase(Locale.ENGLISH));
        return hashMap;
    }

    /* renamed from: f */
    public final synchronized HashMap<String, String> mo33657f() {
        HashMap<String, String> hashMap;
        HashMap hashMap2;
        hashMap = new HashMap<>();
        Location i = m33558i();
        if (i != null) {
            hashMap2 = m33552a(i, true);
        } else {
            hashMap2 = m33552a(C10697g.m35126c(), false);
        }
        for (Entry entry : hashMap2.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return hashMap;
    }

    /* renamed from: a */
    public static void m33553a(boolean z) {
        f31195a = z;
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"newApi"})
    @TargetApi(19)
    /* renamed from: g */
    public final boolean mo33658g() {
        boolean z;
        boolean z2;
        int i;
        Context b = C10619a.m34839b();
        if (b == null) {
            return false;
        }
        int i2 = VERSION.SDK_INT;
        if (i2 >= 28) {
            LocationManager locationManager = this.f31200b;
            if (locationManager != null) {
                return locationManager.isLocationEnabled();
            }
            return false;
        } else if (i2 < 19 || i2 >= 28) {
            if (this.f31200b != null) {
                String str = "signals";
                if (C10701e.m35150a(b, str, "android.permission.ACCESS_FINE_LOCATION")) {
                    z = this.f31200b.isProviderEnabled("gps");
                    z2 = false;
                } else if (C10701e.m35150a(b, str, "android.permission.ACCESS_COARSE_LOCATION")) {
                    z2 = this.f31200b.isProviderEnabled("network");
                    z = false;
                } else {
                    z2 = false;
                    z = false;
                }
                if (z2 || z) {
                    return true;
                }
            }
            return false;
        } else {
            try {
                i = Secure.getInt(b.getContentResolver(), "location_mode");
            } catch (SettingNotFoundException e) {
                i = 0;
            }
            if (i != 0) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: i */
    private Location m33558i() {
        Location location;
        Location location2;
        Location location3 = null;
        try {
            if (!f31195a || !mo33658g() || !m33556c()) {
                location = null;
                return m33550a(location, location3);
            }
            if (f31199h) {
                location = m33560k();
            } else {
                location = null;
            }
            try {
                if (this.f31200b != null) {
                    location3 = m33559j();
                }
            } catch (Exception e) {
                Exception exc = e;
                location2 = location;
                e = exc;
                new StringBuilder("SDK encountered unexpected error in getting a location fix; ").append(e.getMessage());
                location = location2;
                return m33550a(location, location3);
            }
            return m33550a(location, location3);
        } catch (Exception e2) {
            e = e2;
            location2 = null;
            new StringBuilder("SDK encountered unexpected error in getting a location fix; ").append(e.getMessage());
            location = location2;
            return m33550a(location, location3);
        }
    }

    /* renamed from: a */
    private static Location m33550a(Location location, Location location2) {
        if (location == null && location2 == null) {
            try {
                C10659b.m34983a().mo34485a(new C10669f("signals", "LocationFixFailed"));
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("Error in submitting telemetry event : (");
                sb.append(e.getMessage());
                sb.append(")");
            }
            return null;
        }
        String str = "Location info provided by Android Api client:";
        String str2 = " ts : ";
        if (location == null) {
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append(location2);
            sb2.append(str2);
            sb2.append(location2.getTime());
            return location2;
        }
        String str3 = "Location info provided by Google Api client:";
        if (location2 == null) {
            StringBuilder sb3 = new StringBuilder(str3);
            sb3.append(location);
            sb3.append(str2);
            sb3.append(location.getTime());
            return location;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = true;
        boolean z2 = time > 120000;
        boolean z3 = time < -120000;
        boolean z4 = time > 0;
        if (z2) {
            StringBuilder sb4 = new StringBuilder(str3);
            sb4.append(location);
            sb4.append(str2);
            sb4.append(location.getTime());
            return location;
        } else if (z3) {
            StringBuilder sb5 = new StringBuilder(str);
            sb5.append(location2);
            sb5.append(str2);
            sb5.append(location2.getTime());
            return location2;
        } else {
            int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
            boolean z5 = accuracy > 0;
            boolean z6 = accuracy < 0;
            if (accuracy <= 200) {
                z = false;
            }
            if (z6 || (z4 && (!z5 || !z))) {
                StringBuilder sb6 = new StringBuilder(str3);
                sb6.append(location);
                sb6.append(str2);
                sb6.append(location.getTime());
                return location;
            }
            StringBuilder sb7 = new StringBuilder(str);
            sb7.append(location2);
            sb7.append(str2);
            sb7.append(location2.getTime());
            return location2;
        }
    }

    /* renamed from: j */
    private Location m33559j() {
        Criteria criteria = new Criteria();
        String str = "signals";
        if (C10701e.m35150a(C10619a.m34839b(), str, "android.permission.ACCESS_FINE_LOCATION")) {
            criteria.setAccuracy(1);
        } else if (C10701e.m35150a(C10619a.m34839b(), str, "android.permission.ACCESS_COARSE_LOCATION")) {
            criteria.setAccuracy(2);
        }
        boolean z = false;
        criteria.setCostAllowed(false);
        String bestProvider = this.f31200b.getBestProvider(criteria, true);
        Location location = null;
        if (bestProvider != null) {
            try {
                location = this.f31200b.getLastKnownLocation(bestProvider);
            } catch (Exception e) {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", "SecurityException");
                    StringBuilder sb = new StringBuilder();
                    sb.append(e.getMessage());
                    hashMap.put("message", sb.toString());
                    C10659b.m34983a();
                    C10659b.m34987a(str, "ExceptionCaught", hashMap);
                } catch (Exception e2) {
                    StringBuilder sb2 = new StringBuilder("Error in submitting telemetry event : (");
                    sb2.append(e2.getMessage());
                    sb2.append(")");
                }
            }
            if (location == null) {
                location = m33561l();
            }
        }
        StringBuilder sb3 = new StringBuilder("Location info provided by Location manager:");
        if (location != null) {
            z = true;
        }
        sb3.append(z);
        return location;
    }

    /* renamed from: k */
    private static Location m33560k() {
        try {
            return (Location) LocationServices.m32675a(C10619a.m34839b()).mo33017h().mo33177b();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: l */
    private Location m33561l() {
        LocationManager locationManager = this.f31200b;
        Location location = null;
        if (locationManager != null) {
            List providers = locationManager.getProviders(true);
            for (int size = providers.size() - 1; size >= 0; size--) {
                String str = (String) providers.get(size);
                if (this.f31200b.isProviderEnabled(str)) {
                    try {
                        location = this.f31200b.getLastKnownLocation(str);
                    } catch (SecurityException e) {
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put("type", "SecurityException");
                            StringBuilder sb = new StringBuilder();
                            sb.append(e.getMessage());
                            hashMap.put("message", sb.toString());
                            C10659b.m34983a();
                            C10659b.m34987a("signals", "ExceptionCaught", hashMap);
                        } catch (Exception e2) {
                            StringBuilder sb2 = new StringBuilder("Error in submitting telemetry event : (");
                            sb2.append(e2.getMessage());
                            sb2.append(")");
                        }
                    }
                    if (location != null) {
                        break;
                    }
                }
            }
        }
        return location;
    }

    /* renamed from: a */
    private HashMap<String, Object> m33552a(Location location, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Context b = C10619a.m34839b();
        if (b == null) {
            return hashMap;
        }
        if (location != null) {
            if (location.getTime() > 0) {
                hashMap.put("u-ll-ts", Long.valueOf(location.getTime()));
            }
            StringBuilder sb = new StringBuilder();
            sb.append(location.getLatitude());
            String str = ",";
            sb.append(str);
            sb.append(location.getLongitude());
            sb.append(str);
            sb.append((int) location.getAccuracy());
            hashMap.put("u-latlong-accu", sb.toString());
            hashMap.put("sdk-collected", Integer.valueOf(z ? 1 : 0));
        }
        if (f31195a) {
            hashMap.put("loc-allowed", Integer.valueOf(mo33658g() ? 1 : 0));
        }
        String str2 = "loc-granularity";
        if (!mo33658g() || !m33556c()) {
            hashMap.put(str2, "none");
        } else {
            String str3 = "signals";
            if (C10701e.m35150a(b, str3, "android.permission.ACCESS_COARSE_LOCATION")) {
                hashMap.put(str2, "coarse");
            }
            if (C10701e.m35150a(b, str3, "android.permission.ACCESS_FINE_LOCATION")) {
                hashMap.put(str2, "fine");
            }
        }
        return hashMap;
    }
}
