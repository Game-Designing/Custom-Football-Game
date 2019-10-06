package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MediationAdConfiguration {
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;

    /* renamed from: a */
    private final String f19166a;

    /* renamed from: b */
    private final Bundle f19167b;

    /* renamed from: c */
    private final Bundle f19168c;

    /* renamed from: d */
    private final Context f19169d;

    /* renamed from: e */
    private final boolean f19170e;

    /* renamed from: f */
    private final Location f19171f;

    /* renamed from: g */
    private final int f19172g;

    /* renamed from: h */
    private final int f19173h;

    /* renamed from: i */
    private final String f19174i;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForChildDirectedTreatment {
    }

    public MediationAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z, Location location, int i, int i2, String str2) {
        this.f19166a = str;
        this.f19167b = bundle;
        this.f19168c = bundle2;
        this.f19169d = context;
        this.f19170e = z;
        this.f19171f = location;
        this.f19172g = i;
        this.f19173h = i2;
        this.f19174i = str2;
    }

    public String getBidResponse() {
        return this.f19166a;
    }

    public Bundle getServerParameters() {
        return this.f19167b;
    }

    public Bundle getMediationExtras() {
        return this.f19168c;
    }

    public Context getContext() {
        return this.f19169d;
    }

    public Location getLocation() {
        return this.f19171f;
    }

    public int taggedForChildDirectedTreatment() {
        return this.f19172g;
    }

    public boolean isTestRequest() {
        return this.f19170e;
    }

    public int taggedForUnderAgeTreatment() {
        return this.f19173h;
    }

    public String getMaxAdContentRating() {
        return this.f19174i;
    }
}
