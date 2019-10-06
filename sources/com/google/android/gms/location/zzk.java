package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public final class zzk implements Creator<zzj> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = SafeParcelReader.m21925b(parcel);
        long j = 50;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        float f = 0.0f;
        int i = MoPubClientPositioning.NO_REPEAT;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                z = SafeParcelReader.m21945s(parcel2, a);
            } else if (a2 == 2) {
                j = SafeParcelReader.m21951y(parcel2, a);
            } else if (a2 == 3) {
                f = SafeParcelReader.m21947u(parcel2, a);
            } else if (a2 == 4) {
                j2 = SafeParcelReader.m21951y(parcel2, a);
            } else if (a2 != 5) {
                SafeParcelReader.m21918C(parcel2, a);
            } else {
                i = SafeParcelReader.m21949w(parcel2, a);
            }
        }
        SafeParcelReader.m21944r(parcel2, b);
        zzj zzj = new zzj(z, j, f, j2, i);
        return zzj;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzj[i];
    }
}
