package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public class DeviceMetaData extends AbstractSafeParcelable {
    public static final Creator<DeviceMetaData> CREATOR = new zzv();

    /* renamed from: a */
    private final int f19312a;

    /* renamed from: b */
    private boolean f19313b;

    /* renamed from: c */
    private long f19314c;

    /* renamed from: d */
    private final boolean f19315d;

    /* renamed from: d */
    public boolean mo27098d() {
        return this.f19313b;
    }

    /* renamed from: a */
    public long mo27096a() {
        return this.f19314c;
    }

    /* renamed from: c */
    public boolean mo27097c() {
        return this.f19315d;
    }

    @Constructor
    DeviceMetaData(@Param(id = 1) int i, @Param(id = 2) boolean z, @Param(id = 3) long j, @Param(id = 4) boolean z2) {
        this.f19312a = i;
        this.f19313b = z;
        this.f19314c = j;
        this.f19315d = z2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f19312a);
        SafeParcelWriter.m21968a(parcel, 2, mo27098d());
        SafeParcelWriter.m21958a(parcel, 3, mo27096a());
        SafeParcelWriter.m21968a(parcel, 4, mo27097c());
        SafeParcelWriter.m21954a(parcel, a);
    }
}
