package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailability;
import java.io.File;
import java.util.regex.Pattern;

/* renamed from: com.flurry.sdk.Dd */
public class C7369Dd {

    /* renamed from: a */
    public static final String f14394a = C7369Dd.class.getSimpleName();

    /* renamed from: com.flurry.sdk.Dd$a */
    public enum C7370a {
        UNKNOWN(-1),
        ACTIVE(0),
        INACTIVE(1),
        BACKGROUND(2);
        

        /* renamed from: f */
        public byte f14400f;

        private C7370a(byte b) {
            this.f14400f = b;
        }
    }

    /* renamed from: com.flurry.sdk.Dd$b */
    public enum C7371b {
        UNAVAILABLE(-2),
        UNKNOWN(-1),
        SUCCESS(0),
        SERVICE_MISSING(1),
        SERVICE_UPDATING(2),
        SERVICE_VERSION_UPDATE_REQUIRED(3),
        SERVICE_DISABLED(4),
        SERVICE_INVALID(5);
        

        /* renamed from: j */
        public int f14410j;

        private C7371b(int i) {
            this.f14410j = i;
        }
    }

    /* renamed from: a */
    public static String m16284a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\.");
        if (split.length != 5) {
            return null;
        }
        return split[3];
    }

    /* renamed from: b */
    public static String m16285b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\.");
        if (split.length != 5) {
            return null;
        }
        return split[4];
    }

    /* renamed from: a */
    public static String m16283a(File file, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".fcb");
        String sb2 = sb.toString();
        String str2 = ".*";
        StringBuilder sb3 = new StringBuilder(str2);
        sb3.append(Pattern.quote(sb2));
        sb3.append(str2);
        String[] a = C7635zd.m16873a(file, Pattern.compile(sb3.toString()));
        if (a.length > 0) {
            return a[0];
        }
        return null;
    }

    /* renamed from: a */
    public static C7371b m16282a(Context context) {
        try {
            int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
            if (isGooglePlayServicesAvailable == 0) {
                return C7371b.SUCCESS;
            }
            if (isGooglePlayServicesAvailable == 1) {
                return C7371b.SERVICE_MISSING;
            }
            if (isGooglePlayServicesAvailable == 2) {
                return C7371b.SERVICE_VERSION_UPDATE_REQUIRED;
            }
            if (isGooglePlayServicesAvailable == 3) {
                return C7371b.SERVICE_DISABLED;
            }
            if (isGooglePlayServicesAvailable == 9) {
                return C7371b.SERVICE_INVALID;
            }
            if (isGooglePlayServicesAvailable != 18) {
                return C7371b.UNAVAILABLE;
            }
            return C7371b.SERVICE_UPDATING;
        } catch (Exception | NoClassDefFoundError e) {
            C7513ec.m16641a(f14394a, "Error retrieving Google Play Services Availability. This probably means google play services is unavailable.");
            return C7371b.UNAVAILABLE;
        }
    }
}
