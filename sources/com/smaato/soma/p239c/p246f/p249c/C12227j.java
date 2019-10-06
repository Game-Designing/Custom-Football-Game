package com.smaato.soma.p239c.p246f.p249c;

import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.p000v4.content.C0510b;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p246f.C12253x;
import com.smaato.soma.p239c.p252i.C12280f;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.smaato.soma.c.f.c.j */
/* compiled from: LocationCollector */
public class C12227j implements LocationListener {

    /* renamed from: a */
    private double f38300a = 0.0d;

    /* renamed from: b */
    private double f38301b = 0.0d;

    /* renamed from: c */
    private final Context f38302c;

    /* renamed from: d */
    private LocationManager f38303d;

    /* renamed from: e */
    private C12228a f38304e;

    /* renamed from: com.smaato.soma.c.f.c.j$a */
    /* compiled from: LocationCollector */
    public interface C12228a {
        /* renamed from: a */
        List<Address> mo39387a(double d, double d2, int i) throws IOException;
    }

    public C12227j(Context applicationContext, LocationManager locationManager, C12228a geocoder) {
        this.f38302c = applicationContext;
        this.f38303d = locationManager;
        this.f38304e = geocoder;
    }

    /* renamed from: a */
    public void mo39573a() {
        try {
            mo39574a(false);
            this.f38303d = null;
            this.f38304e = null;
        } catch (Exception e) {
        }
    }

    public void onLocationChanged(Location location) {
        if (location != null) {
            this.f38300a = location.getLatitude();
            this.f38301b = location.getLongitude();
            return;
        }
        m40228d();
    }

    /* renamed from: d */
    private void m40228d() {
        this.f38300a = 0.0d;
        this.f38301b = 0.0d;
    }

    public void onProviderDisabled(String provider) {
        m40228d();
    }

    public void onProviderEnabled(String provider) {
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    /* renamed from: a */
    public final void mo39574a(boolean locationUpdateEnabled) {
        C12146d.m39966a((Object) new C12226i(this));
        if (mo39575b()) {
            if (locationUpdateEnabled) {
                String c = m40226c();
                String best = c;
                if (c != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Best location provider: ");
                    sb.append(best);
                    C12146d.m39965a(new C12147e("Location_Collector", sb.toString(), 1, C12143a.INFO));
                    this.f38303d.requestLocationUpdates(best, 300000, 0.0f, this);
                }
            }
            this.f38303d.removeUpdates(this);
            m40228d();
        }
    }

    /* renamed from: c */
    private String m40226c() {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(2);
        criteria.setPowerRequirement(1);
        return this.f38303d.getBestProvider(criteria, true);
    }

    /* renamed from: a */
    public Map<String, String> mo39572a(double latitude, double longitude) {
        if (longitude == 0.0d || latitude == 0.0d) {
            latitude = this.f38300a;
            longitude = this.f38301b;
        }
        Map<String, String> params = new HashMap<>();
        if (!(latitude == 0.0d && longitude == 0.0d) && m40227c(latitude, longitude)) {
            if (C12253x.m40319b(this.f38302c)) {
                params.put("gps", String.format(Locale.US, "%.6f,%.6f", new Object[]{Double.valueOf(latitude), Double.valueOf(longitude)}));
            }
            Address mAddress = m40225b(latitude, longitude);
            if (mAddress != null) {
                String zip = mAddress.getPostalCode();
                if (!C12280f.m40428a((CharSequence) zip)) {
                    params.put("zip", zip);
                }
            }
        }
        return params;
    }

    /* renamed from: c */
    private boolean m40227c(double latitude, double longitude) {
        return latitude >= -90.0d && latitude <= 90.0d && longitude >= -180.0d && longitude <= 180.0d;
    }

    /* renamed from: b */
    private Address m40225b(double latitude, double longitude) {
        C12228a aVar = this.f38304e;
        if (aVar == null) {
            return null;
        }
        List list = null;
        try {
            list = aVar.mo39387a(latitude, longitude, 1);
        } catch (IOException e) {
            C12146d.m39965a(new C12147e("Location_Collector", "Reverse Geocoding failed", 2, C12143a.ERROR));
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (Address) list.get(0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo39575b() {
        boolean z = false;
        try {
            if (C0510b.m2565a(this.f38302c, "android.permission.ACCESS_FINE_LOCATION") == 0 || C0510b.m2565a(this.f38302c, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }
}
