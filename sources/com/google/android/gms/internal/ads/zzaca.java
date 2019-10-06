package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzard
public final class zzaca extends AbstractSafeParcelable {
    public static final Creator<zzaca> CREATOR = new zzacb();

    /* renamed from: a */
    private final String f23876a;

    public zzaca(SearchAdRequest searchAdRequest) {
        this.f23876a = searchAdRequest.getQuery();
    }

    @Constructor
    zzaca(@Param(id = 15) String str) {
        this.f23876a = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 15, this.f23876a, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
