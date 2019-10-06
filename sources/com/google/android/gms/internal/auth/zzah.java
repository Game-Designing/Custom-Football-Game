package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zzah extends AbstractSafeParcelable {
    public static final Creator<zzah> CREATOR = new zzai();

    /* renamed from: a */
    private final int f29830a = 1;

    /* renamed from: b */
    private final String f29831b;

    /* renamed from: c */
    private final PendingIntent f29832c;

    @Constructor
    zzah(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) PendingIntent pendingIntent) {
        Preconditions.m21857a(str);
        this.f29831b = str;
        Preconditions.m21857a(pendingIntent);
        this.f29832c = pendingIntent;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f29830a);
        SafeParcelWriter.m21965a(parcel, 2, this.f29831b, false);
        SafeParcelWriter.m21962a(parcel, 3, (Parcelable) this.f29832c, i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
