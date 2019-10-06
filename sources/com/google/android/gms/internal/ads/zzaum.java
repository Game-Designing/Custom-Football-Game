package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzard
public final class zzaum extends AbstractSafeParcelable {
    public static final Creator<zzaum> CREATOR = new zzaun();

    /* renamed from: a */
    public final String f24827a;

    /* renamed from: b */
    public final String f24828b;

    public zzaum(ServerSideVerificationOptions serverSideVerificationOptions) {
        this(serverSideVerificationOptions.getUserId(), serverSideVerificationOptions.getCustomData());
    }

    @Constructor
    public zzaum(@Param(id = 1) String str, @Param(id = 2) String str2) {
        this.f24827a = str;
        this.f24828b = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 1, this.f24827a, false);
        SafeParcelWriter.m21965a(parcel, 2, this.f24828b, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
