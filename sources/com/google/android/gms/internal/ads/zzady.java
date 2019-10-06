package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzard
public final class zzady extends AbstractSafeParcelable {
    public static final Creator<zzady> CREATOR = new zzadz();

    /* renamed from: a */
    public final int f24265a;

    /* renamed from: b */
    public final boolean f24266b;

    /* renamed from: c */
    public final int f24267c;

    /* renamed from: d */
    public final boolean f24268d;

    /* renamed from: e */
    public final int f24269e;

    /* renamed from: f */
    public final zzacd f24270f;

    /* renamed from: g */
    public final boolean f24271g;

    /* renamed from: h */
    public final int f24272h;

    public zzady(NativeAdOptions nativeAdOptions) {
        zzacd zzacd;
        boolean shouldReturnUrlsForImageAssets = nativeAdOptions.shouldReturnUrlsForImageAssets();
        int imageOrientation = nativeAdOptions.getImageOrientation();
        boolean shouldRequestMultipleImages = nativeAdOptions.shouldRequestMultipleImages();
        int adChoicesPlacement = nativeAdOptions.getAdChoicesPlacement();
        if (nativeAdOptions.getVideoOptions() != null) {
            zzacd = new zzacd(nativeAdOptions.getVideoOptions());
        } else {
            zzacd = null;
        }
        this(4, shouldReturnUrlsForImageAssets, imageOrientation, shouldRequestMultipleImages, adChoicesPlacement, zzacd, nativeAdOptions.zzkr(), 0);
    }

    @Constructor
    public zzady(@Param(id = 1) int i, @Param(id = 2) boolean z, @Param(id = 3) int i2, @Param(id = 4) boolean z2, @Param(id = 5) int i3, @Param(id = 6) zzacd zzacd, @Param(id = 7) boolean z3, @Param(id = 8) int i4) {
        this.f24265a = i;
        this.f24266b = z;
        this.f24267c = i2;
        this.f24268d = z2;
        this.f24269e = i3;
        this.f24270f = zzacd;
        this.f24271g = z3;
        this.f24272h = i4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f24265a);
        SafeParcelWriter.m21968a(parcel, 2, this.f24266b);
        SafeParcelWriter.m21957a(parcel, 3, this.f24267c);
        SafeParcelWriter.m21968a(parcel, 4, this.f24268d);
        SafeParcelWriter.m21957a(parcel, 5, this.f24269e);
        SafeParcelWriter.m21962a(parcel, 6, (Parcelable) this.f24270f, i, false);
        SafeParcelWriter.m21968a(parcel, 7, this.f24271g);
        SafeParcelWriter.m21957a(parcel, 8, this.f24272h);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
