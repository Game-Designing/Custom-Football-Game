package com.mopub.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.privacy.MoPubIdentifier;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import java.util.Locale;

public class ClientMetadata {

    /* renamed from: a */
    private static volatile ClientMetadata f34237a;

    /* renamed from: b */
    private String f34238b;

    /* renamed from: c */
    private String f34239c;

    /* renamed from: d */
    private String f34240d;

    /* renamed from: e */
    private String f34241e;

    /* renamed from: f */
    private String f34242f;

    /* renamed from: g */
    private String f34243g;

    /* renamed from: h */
    private String f34244h;

    /* renamed from: i */
    private final MoPubIdentifier f34245i;

    /* renamed from: j */
    private final String f34246j = Build.MANUFACTURER;

    /* renamed from: k */
    private final String f34247k = Build.MODEL;

    /* renamed from: l */
    private final String f34248l = Build.PRODUCT;

    /* renamed from: m */
    private final String f34249m = VERSION.RELEASE;

    /* renamed from: n */
    private final String f34250n = "5.7.1";

    /* renamed from: o */
    private final String f34251o = m36953a(this.f34254r);

    /* renamed from: p */
    private final String f34252p;

    /* renamed from: q */
    private String f34253q;

    /* renamed from: r */
    private final Context f34254r;

    /* renamed from: s */
    private final ConnectivityManager f34255s = ((ConnectivityManager) this.f34254r.getSystemService("connectivity"));

    public enum MoPubNetworkType {
        UNKNOWN(0),
        ETHERNET(1),
        WIFI(2),
        MOBILE(3),
        GG(4),
        GGG(5),
        GGGG(6);
        

        /* renamed from: b */
        private final int f34258b;

        private MoPubNetworkType(int id) {
            this.f34258b = id;
        }

        public String toString() {
            return Integer.toString(this.f34258b);
        }

        public int getId() {
            return this.f34258b;
        }
    }

    public static ClientMetadata getInstance(Context context) {
        ClientMetadata result = f34237a;
        if (result == null) {
            synchronized (ClientMetadata.class) {
                result = f34237a;
                if (result == null) {
                    result = new ClientMetadata(context);
                    f34237a = result;
                }
            }
        }
        return result;
    }

    public static ClientMetadata getInstance() {
        ClientMetadata result = f34237a;
        if (result == null) {
            synchronized (ClientMetadata.class) {
                result = f34237a;
            }
        }
        return result;
    }

    private ClientMetadata(Context context) {
        Preconditions.checkNotNull(context);
        this.f34254r = context.getApplicationContext();
        PackageManager packageManager = this.f34254r.getPackageManager();
        ApplicationInfo applicationInfo = null;
        this.f34252p = this.f34254r.getPackageName();
        try {
            applicationInfo = packageManager.getApplicationInfo(this.f34252p, 0);
        } catch (NameNotFoundException e) {
        }
        if (applicationInfo != null) {
            this.f34253q = (String) packageManager.getApplicationLabel(applicationInfo);
        }
        TelephonyManager telephonyManager = (TelephonyManager) this.f34254r.getSystemService("phone");
        if (telephonyManager != null) {
            this.f34238b = telephonyManager.getNetworkOperator();
            this.f34239c = telephonyManager.getNetworkOperator();
            if (telephonyManager.getPhoneType() == 2 && telephonyManager.getSimState() == 5) {
                this.f34238b = telephonyManager.getSimOperator();
                this.f34240d = telephonyManager.getSimOperator();
            }
            if (MoPub.canCollectPersonalInformation()) {
                this.f34241e = telephonyManager.getNetworkCountryIso();
                this.f34242f = telephonyManager.getSimCountryIso();
            } else {
                String str = "";
                this.f34241e = str;
                this.f34242f = str;
            }
            try {
                this.f34243g = telephonyManager.getNetworkOperatorName();
                if (telephonyManager.getSimState() == 5) {
                    this.f34244h = telephonyManager.getSimOperatorName();
                }
            } catch (SecurityException e2) {
                this.f34243g = null;
                this.f34244h = null;
            }
        }
        this.f34245i = new MoPubIdentifier(this.f34254r);
    }

    public void repopulateCountryData() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f34254r.getSystemService("phone");
        if (MoPub.canCollectPersonalInformation() && telephonyManager != null) {
            this.f34241e = telephonyManager.getNetworkCountryIso();
            this.f34242f = telephonyManager.getSimCountryIso();
        }
    }

    /* renamed from: a */
    private static String m36953a(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), i).versionName;
        } catch (Exception e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Failed to retrieve PackageInfo#versionName.");
            return null;
        }
    }

    public String getOrientationString() {
        int orientationInt = this.f34254r.getResources().getConfiguration().orientation;
        String orientation = "u";
        if (orientationInt == 1) {
            return "p";
        }
        if (orientationInt == 2) {
            return "l";
        }
        if (orientationInt == 3) {
            return "s";
        }
        return orientation;
    }

    @SuppressLint({"MissingPermission"})
    public MoPubNetworkType getActiveNetworkType() {
        if (!DeviceUtils.isPermissionGranted(this.f34254r, "android.permission.ACCESS_NETWORK_STATE")) {
            return MoPubNetworkType.UNKNOWN;
        }
        NetworkInfo activeNetworkInfo = this.f34255s.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return MoPubNetworkType.UNKNOWN;
        }
        if (VERSION.SDK_INT >= 21) {
            for (Network network : this.f34255s.getAllNetworks()) {
                NetworkCapabilities capabilities = this.f34255s.getNetworkCapabilities(network);
                if (capabilities != null && capabilities.hasTransport(3)) {
                    return MoPubNetworkType.ETHERNET;
                }
            }
        } else if (activeNetworkInfo.getType() == 9) {
            return MoPubNetworkType.ETHERNET;
        }
        NetworkInfo networkInfo = this.f34255s.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.isConnected()) {
            return MoPubNetworkType.WIFI;
        }
        NetworkInfo networkInfo2 = this.f34255s.getNetworkInfo(0);
        if (networkInfo2 == null || !networkInfo2.isConnected()) {
            return MoPubNetworkType.UNKNOWN;
        }
        switch (networkInfo2.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return MoPubNetworkType.GG;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
                return MoPubNetworkType.GGG;
            case 13:
            case 15:
                return MoPubNetworkType.GGGG;
            default:
                return MoPubNetworkType.MOBILE;
        }
    }

    public float getDensity() {
        return this.f34254r.getResources().getDisplayMetrics().density;
    }

    public String getNetworkOperatorForUrl() {
        return this.f34238b;
    }

    public String getNetworkOperator() {
        return this.f34239c;
    }

    public Locale getDeviceLocale() {
        return this.f34254r.getResources().getConfiguration().locale;
    }

    public String getSimOperator() {
        return this.f34240d;
    }

    public String getIsoCountryCode() {
        return MoPub.canCollectPersonalInformation() ? this.f34241e : "";
    }

    public String getSimIsoCountryCode() {
        return MoPub.canCollectPersonalInformation() ? this.f34242f : "";
    }

    public String getNetworkOperatorName() {
        return this.f34243g;
    }

    public String getSimOperatorName() {
        return this.f34244h;
    }

    public MoPubIdentifier getMoPubIdentifier() {
        return this.f34245i;
    }

    public String getDeviceManufacturer() {
        return this.f34246j;
    }

    public String getDeviceModel() {
        return this.f34247k;
    }

    public String getDeviceProduct() {
        return this.f34248l;
    }

    public String getDeviceOsVersion() {
        return this.f34249m;
    }

    public int getDeviceScreenWidthDip() {
        return Dips.screenWidthAsIntDips(this.f34254r);
    }

    public int getDeviceScreenHeightDip() {
        return Dips.screenHeightAsIntDips(this.f34254r);
    }

    public Point getDeviceDimensions() {
        if (NoThrow.checkNotNull(this.f34254r)) {
            return DeviceUtils.getDeviceDimensions(this.f34254r);
        }
        return new Point(0, 0);
    }

    public String getSdkVersion() {
        return this.f34250n;
    }

    public String getAppVersion() {
        return this.f34251o;
    }

    public String getAppPackageName() {
        return this.f34252p;
    }

    public String getAppName() {
        return this.f34253q;
    }

    public static String getCurrentLanguage(Context context) {
        String languageCode = Locale.getDefault().getLanguage().trim();
        Locale userLocale = context.getResources().getConfiguration().locale;
        if (userLocale == null || userLocale.getLanguage().trim().isEmpty()) {
            return languageCode;
        }
        return userLocale.getLanguage().trim();
    }

    @Deprecated
    @VisibleForTesting
    public static void setInstance(ClientMetadata clientMetadata) {
        synchronized (ClientMetadata.class) {
            f34237a = clientMetadata;
        }
    }

    @Deprecated
    @VisibleForTesting
    public static void clearForTesting() {
        f34237a = null;
    }
}
