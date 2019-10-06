package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.location.zzu;
import com.google.android.gms.location.zzv;
import com.google.android.gms.location.zzx;
import com.google.android.gms.location.zzy;

public final class zzbf extends AbstractSafeParcelable {
    public static final Creator<zzbf> CREATOR = new zzbg();

    /* renamed from: a */
    private int f29955a;

    /* renamed from: b */
    private zzbd f29956b;

    /* renamed from: c */
    private zzx f29957c;

    /* renamed from: d */
    private PendingIntent f29958d;

    /* renamed from: e */
    private zzu f29959e;

    /* renamed from: f */
    private zzaj f29960f;

    @Constructor
    zzbf(@Param(id = 1) int i, @Param(id = 2) zzbd zzbd, @Param(id = 3) IBinder iBinder, @Param(id = 4) PendingIntent pendingIntent, @Param(id = 5) IBinder iBinder2, @Param(id = 6) IBinder iBinder3) {
        this.f29955a = i;
        this.f29956b = zzbd;
        zzaj zzaj = null;
        this.f29957c = iBinder == null ? null : zzy.m32694a(iBinder);
        this.f29958d = pendingIntent;
        this.f29959e = iBinder2 == null ? null : zzv.m32692a(iBinder2);
        if (!(iBinder3 == null || iBinder3 == null)) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzaj = queryLocalInterface instanceof zzaj ? (zzaj) queryLocalInterface : new zzal(iBinder3);
        }
        this.f29960f = zzaj;
    }

    /* renamed from: a */
    public static zzbf m31751a(zzu zzu, zzaj zzaj) {
        zzbf zzbf = new zzbf(2, null, null, null, zzu.asBinder(), zzaj != null ? zzaj.asBinder() : null);
        return zzbf;
    }

    /* renamed from: a */
    public static zzbf m31752a(zzx zzx, zzaj zzaj) {
        zzbf zzbf = new zzbf(2, null, zzx.asBinder(), null, null, zzaj != null ? zzaj.asBinder() : null);
        return zzbf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f29955a);
        SafeParcelWriter.m21962a(parcel, 2, (Parcelable) this.f29956b, i, false);
        zzx zzx = this.f29957c;
        IBinder iBinder = null;
        SafeParcelWriter.m21960a(parcel, 3, zzx == null ? null : zzx.asBinder(), false);
        SafeParcelWriter.m21962a(parcel, 4, (Parcelable) this.f29958d, i, false);
        zzu zzu = this.f29959e;
        SafeParcelWriter.m21960a(parcel, 5, zzu == null ? null : zzu.asBinder(), false);
        zzaj zzaj = this.f29960f;
        if (zzaj != null) {
            iBinder = zzaj.asBinder();
        }
        SafeParcelWriter.m21960a(parcel, 6, iBinder, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
