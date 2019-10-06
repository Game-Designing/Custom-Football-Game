package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zzard
public final class zzank implements MediationAdRequest {

    /* renamed from: a */
    private final Date f24480a;

    /* renamed from: b */
    private final int f24481b;

    /* renamed from: c */
    private final Set<String> f24482c;

    /* renamed from: d */
    private final boolean f24483d;

    /* renamed from: e */
    private final Location f24484e;

    /* renamed from: f */
    private final int f24485f;

    /* renamed from: g */
    private final boolean f24486g;

    /* renamed from: h */
    private final int f24487h;

    /* renamed from: i */
    private final String f24488i;

    public zzank(Date date, int i, Set<String> set, Location location, boolean z, int i2, boolean z2, int i3, String str) {
        this.f24480a = date;
        this.f24481b = i;
        this.f24482c = set;
        this.f24484e = location;
        this.f24483d = z;
        this.f24485f = i2;
        this.f24486g = z2;
        this.f24487h = i3;
        this.f24488i = str;
    }

    @Deprecated
    public final Date getBirthday() {
        return this.f24480a;
    }

    @Deprecated
    public final int getGender() {
        return this.f24481b;
    }

    public final Set<String> getKeywords() {
        return this.f24482c;
    }

    public final Location getLocation() {
        return this.f24484e;
    }

    public final boolean isTesting() {
        return this.f24483d;
    }

    public final int taggedForChildDirectedTreatment() {
        return this.f24485f;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.f24486g;
    }
}
