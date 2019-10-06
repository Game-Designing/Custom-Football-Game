package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@KeepForSdkWithMembers
public class ProxyResponse extends AbstractSafeParcelable {
    public static final Creator<ProxyResponse> CREATOR = new zzb();

    /* renamed from: a */
    private final int f19404a;

    /* renamed from: b */
    public final int f19405b;

    /* renamed from: c */
    public final PendingIntent f19406c;

    /* renamed from: d */
    public final int f19407d;

    /* renamed from: e */
    private final Bundle f19408e;

    /* renamed from: f */
    public final byte[] f19409f;

    @Constructor
    ProxyResponse(@Param(id = 1000) int i, @Param(id = 1) int i2, @Param(id = 2) PendingIntent pendingIntent, @Param(id = 3) int i3, @Param(id = 4) Bundle bundle, @Param(id = 5) byte[] bArr) {
        this.f19404a = i;
        this.f19405b = i2;
        this.f19407d = i3;
        this.f19408e = bundle;
        this.f19409f = bArr;
        this.f19406c = pendingIntent;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f19405b);
        SafeParcelWriter.m21962a(parcel, 2, (Parcelable) this.f19406c, i, false);
        SafeParcelWriter.m21957a(parcel, 3, this.f19407d);
        SafeParcelWriter.m21959a(parcel, 4, this.f19408e, false);
        SafeParcelWriter.m21969a(parcel, 5, this.f19409f, false);
        SafeParcelWriter.m21957a(parcel, 1000, this.f19404a);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
