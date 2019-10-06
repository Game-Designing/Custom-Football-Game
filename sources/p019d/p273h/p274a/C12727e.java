package p019d.p273h.p274a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import android.util.Log;
import java.util.List;

/* renamed from: d.h.a.e */
/* compiled from: LocationService */
public class C12727e {

    /* renamed from: a */
    private static String f39049a = C12727e.class.getSimpleName();

    /* renamed from: d.h.a.e$a */
    /* compiled from: LocationService */
    public interface C12728a {
        void onLocationChanged(Location location);
    }

    /* renamed from: a */
    public static Location m41108a(Context context) {
        Location bestLocation = null;
        List<String> providers = null;
        if (C12723a.m41067b(context, "android.permission.ACCESS_FINE_LOCATION") || C12723a.m41067b(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager != null) {
                    providers = locationManager.getAllProviders();
                }
                if (providers != null) {
                    for (String provider : providers) {
                        try {
                            Location location = locationManager.getLastKnownLocation(provider);
                            if (location != null && location.getTime() > Long.MIN_VALUE) {
                                bestLocation = location;
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            } catch (Exception e2) {
            }
            return bestLocation;
        }
        Log.d(f39049a, "Location Permission Not Granted (ACCESS_FINE_LOCATION or ACCESS_COARSE_LOCATION)");
        return null;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    public static void m41109a(Context context, C12728a isLocationListener) {
        if (!C12723a.m41067b(context, "android.permission.ACCESS_FINE_LOCATION")) {
            Log.d(f39049a, "Location Permission Not Granted (ACCESS_FINE_LOCATION)");
            if (isLocationListener != null) {
                isLocationListener.onLocationChanged(null);
                return;
            }
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (isLocationListener == null || locationManager.isProviderEnabled("gps")) {
                locationManager.requestSingleUpdate(new Criteria(), new C12726d(isLocationListener), Looper.myLooper());
                return;
            }
            Log.d(f39049a, "GPS Provider is turned off");
            isLocationListener.onLocationChanged(null);
        } catch (Exception e) {
            if (isLocationListener != null) {
                isLocationListener.onLocationChanged(null);
            }
        }
    }

    /* renamed from: b */
    public static boolean m41110b(Context context) {
        boolean z = false;
        try {
            if (C12723a.m41067b(context, "android.permission.ACCESS_FINE_LOCATION") || C12723a.m41067b(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                boolean gps_enabled = false;
                boolean network_enabled = false;
                try {
                    gps_enabled = locationManager.isProviderEnabled("gps");
                } catch (Exception e) {
                }
                try {
                    network_enabled = locationManager.isProviderEnabled("network");
                } catch (Exception e2) {
                }
                if (gps_enabled || network_enabled) {
                    z = true;
                }
                return z;
            }
            Log.d(f39049a, "Location Permission Not Granted (ACCESS_FINE_LOCATION or ACCESS_COARSE_LOCATION)");
            return false;
        } catch (Exception e3) {
            return false;
        }
    }
}
