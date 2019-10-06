package com.mopub.common;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.SystemClock;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.DeviceUtils;
import java.math.BigDecimal;

public class LocationService {

    /* renamed from: a */
    private static volatile LocationService f34333a;
    @VisibleForTesting

    /* renamed from: b */
    Location f34334b;
    @VisibleForTesting

    /* renamed from: c */
    long f34335c;

    public enum LocationAwareness {
        NORMAL,
        TRUNCATED,
        DISABLED;

        @Deprecated
        public com.mopub.common.MoPub.LocationAwareness getNewLocationAwareness() {
            if (this == TRUNCATED) {
                return com.mopub.common.MoPub.LocationAwareness.TRUNCATED;
            }
            if (this == DISABLED) {
                return com.mopub.common.MoPub.LocationAwareness.DISABLED;
            }
            return com.mopub.common.MoPub.LocationAwareness.NORMAL;
        }

        @Deprecated
        public static LocationAwareness fromMoPubLocationAwareness(com.mopub.common.MoPub.LocationAwareness awareness) {
            if (awareness == com.mopub.common.MoPub.LocationAwareness.DISABLED) {
                return DISABLED;
            }
            if (awareness == com.mopub.common.MoPub.LocationAwareness.TRUNCATED) {
                return TRUNCATED;
            }
            return NORMAL;
        }
    }

    public enum ValidLocationProvider {
        NETWORK("network"),
        GPS("gps");
        

        /* renamed from: b */
        final String f34338b;

        private ValidLocationProvider(String name) {
            this.f34338b = name;
        }

        public String toString() {
            return this.f34338b;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean m37022a(Context context) {
            int i = C11255o.f34429a[ordinal()];
            String str = "android.permission.ACCESS_FINE_LOCATION";
            boolean z = false;
            if (i == 1) {
                if (DeviceUtils.isPermissionGranted(context, str) || DeviceUtils.isPermissionGranted(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = true;
                }
                return z;
            } else if (i != 2) {
                return false;
            } else {
                return DeviceUtils.isPermissionGranted(context, str);
            }
        }
    }

    private LocationService() {
    }

    @VisibleForTesting
    /* renamed from: a */
    static LocationService m37019a() {
        LocationService locationService = f34333a;
        if (locationService == null) {
            synchronized (LocationService.class) {
                locationService = f34333a;
                if (locationService == null) {
                    locationService = new LocationService();
                    f34333a = locationService;
                }
            }
        }
        return locationService;
    }

    public static Location getLastKnownLocation(Context context, int locationPrecision, com.mopub.common.MoPub.LocationAwareness locationAwareness) {
        if (!MoPub.canCollectPersonalInformation()) {
            return null;
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(locationAwareness);
        if (locationAwareness == com.mopub.common.MoPub.LocationAwareness.DISABLED) {
            return null;
        }
        LocationService locationService = m37019a();
        if (m37021b()) {
            return locationService.f34334b;
        }
        Location result = m37018a(m37017a(context, ValidLocationProvider.GPS), m37017a(context, ValidLocationProvider.NETWORK));
        if (locationAwareness == com.mopub.common.MoPub.LocationAwareness.TRUNCATED) {
            m37020a(result, locationPrecision);
        }
        locationService.f34334b = result;
        locationService.f34335c = SystemClock.elapsedRealtime();
        return result;
    }

    @VisibleForTesting
    /* renamed from: a */
    static Location m37017a(Context context, ValidLocationProvider provider) {
        String str = " location provider.";
        String str2 = "Failed to retrieve location: device has no ";
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(provider);
        if (!MoPub.canCollectPersonalInformation() || !provider.m37022a(context)) {
            return null;
        }
        try {
            return ((LocationManager) context.getSystemService("location")).getLastKnownLocation(provider.toString());
        } catch (SecurityException e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve location from ");
            sb.append(provider.toString());
            sb.append(" provider: access appears to be disabled.");
            MoPubLog.log(sdkLogEvent, sb.toString());
            return null;
        } catch (IllegalArgumentException e2) {
            SdkLogEvent sdkLogEvent2 = SdkLogEvent.CUSTOM;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(provider.toString());
            sb2.append(str);
            MoPubLog.log(sdkLogEvent2, sb2.toString());
            return null;
        } catch (NullPointerException e3) {
            SdkLogEvent sdkLogEvent3 = SdkLogEvent.CUSTOM;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str2);
            sb3.append(provider.toString());
            sb3.append(str);
            MoPubLog.log(sdkLogEvent3, sb3.toString());
            return null;
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    static Location m37018a(Location a, Location b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        return a.getTime() > b.getTime() ? a : b;
    }

    @VisibleForTesting
    /* renamed from: a */
    static void m37020a(Location location, int precision) {
        if (location != null && precision >= 0) {
            location.setLatitude(BigDecimal.valueOf(location.getLatitude()).setScale(precision, 5).doubleValue());
            location.setLongitude(BigDecimal.valueOf(location.getLongitude()).setScale(precision, 5).doubleValue());
        }
    }

    /* renamed from: b */
    private static boolean m37021b() {
        LocationService locationService = m37019a();
        boolean z = false;
        if (locationService.f34334b == null) {
            return false;
        }
        if (SystemClock.elapsedRealtime() - locationService.f34335c <= MoPub.getMinimumLocationRefreshTimeMillis()) {
            z = true;
        }
        return z;
    }

    @Deprecated
    @VisibleForTesting
    public static void clearLastKnownLocation() {
        m37019a().f34334b = null;
    }
}
