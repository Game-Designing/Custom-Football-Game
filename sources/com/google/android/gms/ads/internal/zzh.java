package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.internal.ads.zzard;

@zzard
public final class zzh extends AbstractSafeParcelable {
    public static final Creator<zzh> CREATOR = new zzi();

    /* renamed from: a */
    private final String f19132a;
    public final boolean zzbre;
    public final boolean zzbrf;
    public final boolean zzbrh;
    public final float zzbri;
    public final int zzbrj;
    public final boolean zzbrk;
    public final boolean zzbrl;
    public final boolean zzbrm;

    public zzh(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this(false, z2, null, false, 0.0f, -1, z4, z5, z6);
    }

    @Constructor
    zzh(@Param(id = 2) boolean z, @Param(id = 3) boolean z2, @Param(id = 4) String str, @Param(id = 5) boolean z3, @Param(id = 6) float f, @Param(id = 7) int i, @Param(id = 8) boolean z4, @Param(id = 9) boolean z5, @Param(id = 10) boolean z6) {
        this.zzbre = z;
        this.zzbrf = z2;
        this.f19132a = str;
        this.zzbrh = z3;
        this.zzbri = f;
        this.zzbrj = i;
        this.zzbrk = z4;
        this.zzbrl = z5;
        this.zzbrm = z6;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21968a(parcel, 2, this.zzbre);
        SafeParcelWriter.m21968a(parcel, 3, this.zzbrf);
        SafeParcelWriter.m21965a(parcel, 4, this.f19132a, false);
        SafeParcelWriter.m21968a(parcel, 5, this.zzbrh);
        SafeParcelWriter.m21956a(parcel, 6, this.zzbri);
        SafeParcelWriter.m21957a(parcel, 7, this.zzbrj);
        SafeParcelWriter.m21968a(parcel, 8, this.zzbrk);
        SafeParcelWriter.m21968a(parcel, 9, this.zzbrl);
        SafeParcelWriter.m21968a(parcel, 10, this.zzbrm);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
