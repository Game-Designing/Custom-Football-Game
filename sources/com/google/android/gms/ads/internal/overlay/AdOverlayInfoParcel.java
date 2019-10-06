package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzagv;
import com.google.android.gms.internal.ads.zzagx;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzxr;

@zzard
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<AdOverlayInfoParcel> CREATOR = new zzn();
    public final int orientation;
    public final String url;
    public final zzbai zzbtc;
    public final zzxr zzcgi;
    public final zzagv zzczo;
    public final zzagx zzczp;
    public final zzbgz zzdbs;
    public final zzc zzdkl;
    public final zzo zzdkm;
    public final String zzdkn;
    public final boolean zzdko;
    public final String zzdkp;
    public final zzu zzdkq;
    public final int zzdkr;
    public final String zzdks;
    public final zzh zzdkt;

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        String str = "com.google.android.gms.ads.inernal.overlay.AdOverlayInfo";
        bundle.putParcelable(str, adOverlayInfoParcel);
        intent.putExtra(str, bundle);
    }

    public static AdOverlayInfoParcel zzc(Intent intent) {
        String str = "com.google.android.gms.ads.inernal.overlay.AdOverlayInfo";
        try {
            Bundle bundleExtra = intent.getBundleExtra(str);
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable(str);
        } catch (Exception e) {
            return null;
        }
    }

    public AdOverlayInfoParcel(zzxr zzxr, zzo zzo, zzu zzu, zzbgz zzbgz, int i, zzbai zzbai, String str, zzh zzh) {
        this.zzdkl = null;
        this.zzcgi = null;
        this.zzdkm = zzo;
        this.zzdbs = zzbgz;
        this.zzczo = null;
        this.zzczp = null;
        this.zzdkn = null;
        this.zzdko = false;
        this.zzdkp = null;
        this.zzdkq = null;
        this.orientation = i;
        this.zzdkr = 1;
        this.url = null;
        this.zzbtc = zzbai;
        this.zzdks = str;
        this.zzdkt = zzh;
    }

    public AdOverlayInfoParcel(zzxr zzxr, zzo zzo, zzu zzu, zzbgz zzbgz, boolean z, int i, zzbai zzbai) {
        this.zzdkl = null;
        this.zzcgi = zzxr;
        this.zzdkm = zzo;
        this.zzdbs = zzbgz;
        this.zzczo = null;
        this.zzczp = null;
        this.zzdkn = null;
        this.zzdko = z;
        this.zzdkp = null;
        this.zzdkq = zzu;
        this.orientation = i;
        this.zzdkr = 2;
        this.url = null;
        this.zzbtc = zzbai;
        this.zzdks = null;
        this.zzdkt = null;
    }

    public AdOverlayInfoParcel(zzxr zzxr, zzo zzo, zzagv zzagv, zzagx zzagx, zzu zzu, zzbgz zzbgz, boolean z, int i, String str, zzbai zzbai) {
        this.zzdkl = null;
        this.zzcgi = zzxr;
        this.zzdkm = zzo;
        this.zzdbs = zzbgz;
        this.zzczo = zzagv;
        this.zzczp = zzagx;
        this.zzdkn = null;
        this.zzdko = z;
        this.zzdkp = null;
        this.zzdkq = zzu;
        this.orientation = i;
        this.zzdkr = 3;
        this.url = str;
        this.zzbtc = zzbai;
        this.zzdks = null;
        this.zzdkt = null;
    }

    public AdOverlayInfoParcel(zzxr zzxr, zzo zzo, zzagv zzagv, zzagx zzagx, zzu zzu, zzbgz zzbgz, boolean z, int i, String str, String str2, zzbai zzbai) {
        this.zzdkl = null;
        this.zzcgi = zzxr;
        this.zzdkm = zzo;
        this.zzdbs = zzbgz;
        this.zzczo = zzagv;
        this.zzczp = zzagx;
        this.zzdkn = str2;
        this.zzdko = z;
        this.zzdkp = str;
        this.zzdkq = zzu;
        this.orientation = i;
        this.zzdkr = 3;
        this.url = null;
        this.zzbtc = zzbai;
        this.zzdks = null;
        this.zzdkt = null;
    }

    public AdOverlayInfoParcel(zzc zzc, zzxr zzxr, zzo zzo, zzu zzu, zzbai zzbai) {
        this.zzdkl = zzc;
        this.zzcgi = zzxr;
        this.zzdkm = zzo;
        this.zzdbs = null;
        this.zzczo = null;
        this.zzczp = null;
        this.zzdkn = null;
        this.zzdko = false;
        this.zzdkp = null;
        this.zzdkq = zzu;
        this.orientation = -1;
        this.zzdkr = 4;
        this.url = null;
        this.zzbtc = zzbai;
        this.zzdks = null;
        this.zzdkt = null;
    }

    @Constructor
    AdOverlayInfoParcel(@Param(id = 2) zzc zzc, @Param(id = 3) IBinder iBinder, @Param(id = 4) IBinder iBinder2, @Param(id = 5) IBinder iBinder3, @Param(id = 6) IBinder iBinder4, @Param(id = 7) String str, @Param(id = 8) boolean z, @Param(id = 9) String str2, @Param(id = 10) IBinder iBinder5, @Param(id = 11) int i, @Param(id = 12) int i2, @Param(id = 13) String str3, @Param(id = 14) zzbai zzbai, @Param(id = 16) String str4, @Param(id = 17) zzh zzh, @Param(id = 18) IBinder iBinder6) {
        this.zzdkl = zzc;
        this.zzcgi = (zzxr) ObjectWrapper.m22187H(Stub.m22186a(iBinder));
        this.zzdkm = (zzo) ObjectWrapper.m22187H(Stub.m22186a(iBinder2));
        this.zzdbs = (zzbgz) ObjectWrapper.m22187H(Stub.m22186a(iBinder3));
        this.zzczo = (zzagv) ObjectWrapper.m22187H(Stub.m22186a(iBinder6));
        this.zzczp = (zzagx) ObjectWrapper.m22187H(Stub.m22186a(iBinder4));
        this.zzdkn = str;
        this.zzdko = z;
        this.zzdkp = str2;
        this.zzdkq = (zzu) ObjectWrapper.m22187H(Stub.m22186a(iBinder5));
        this.orientation = i;
        this.zzdkr = i2;
        this.url = str3;
        this.zzbtc = zzbai;
        this.zzdks = str4;
        this.zzdkt = zzh;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21962a(parcel, 2, (Parcelable) this.zzdkl, i, false);
        SafeParcelWriter.m21960a(parcel, 3, ObjectWrapper.m22188a(this.zzcgi).asBinder(), false);
        SafeParcelWriter.m21960a(parcel, 4, ObjectWrapper.m22188a(this.zzdkm).asBinder(), false);
        SafeParcelWriter.m21960a(parcel, 5, ObjectWrapper.m22188a(this.zzdbs).asBinder(), false);
        SafeParcelWriter.m21960a(parcel, 6, ObjectWrapper.m22188a(this.zzczp).asBinder(), false);
        SafeParcelWriter.m21965a(parcel, 7, this.zzdkn, false);
        SafeParcelWriter.m21968a(parcel, 8, this.zzdko);
        SafeParcelWriter.m21965a(parcel, 9, this.zzdkp, false);
        SafeParcelWriter.m21960a(parcel, 10, ObjectWrapper.m22188a(this.zzdkq).asBinder(), false);
        SafeParcelWriter.m21957a(parcel, 11, this.orientation);
        SafeParcelWriter.m21957a(parcel, 12, this.zzdkr);
        SafeParcelWriter.m21965a(parcel, 13, this.url, false);
        SafeParcelWriter.m21962a(parcel, 14, (Parcelable) this.zzbtc, i, false);
        SafeParcelWriter.m21965a(parcel, 16, this.zzdks, false);
        SafeParcelWriter.m21962a(parcel, 17, (Parcelable) this.zzdkt, i, false);
        SafeParcelWriter.m21960a(parcel, 18, ObjectWrapper.m22188a(this.zzczo).asBinder(), false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
