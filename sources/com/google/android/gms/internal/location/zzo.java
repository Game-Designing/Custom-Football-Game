package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.location.zzr;
import com.google.android.gms.location.zzs;

public final class zzo extends AbstractSafeParcelable {
    public static final Creator<zzo> CREATOR = new zzp();

    /* renamed from: a */
    private int f29978a;

    /* renamed from: b */
    private zzm f29979b;

    /* renamed from: c */
    private zzr f29980c;

    /* renamed from: d */
    private zzaj f29981d;

    @Constructor
    zzo(@Param(id = 1) int i, @Param(id = 2) zzm zzm, @Param(id = 3) IBinder iBinder, @Param(id = 4) IBinder iBinder2) {
        this.f29978a = i;
        this.f29979b = zzm;
        zzaj zzaj = null;
        this.f29980c = iBinder == null ? null : zzs.m32688a(iBinder);
        if (!(iBinder2 == null || iBinder2 == null)) {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzaj = queryLocalInterface instanceof zzaj ? (zzaj) queryLocalInterface : new zzal(iBinder2);
        }
        this.f29981d = zzaj;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f29978a);
        SafeParcelWriter.m21962a(parcel, 2, (Parcelable) this.f29979b, i, false);
        zzr zzr = this.f29980c;
        IBinder iBinder = null;
        SafeParcelWriter.m21960a(parcel, 3, zzr == null ? null : zzr.asBinder(), false);
        zzaj zzaj = this.f29981d;
        if (zzaj != null) {
            iBinder = zzaj.asBinder();
        }
        SafeParcelWriter.m21960a(parcel, 4, iBinder, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
