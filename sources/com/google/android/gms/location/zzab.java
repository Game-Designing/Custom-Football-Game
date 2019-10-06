package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public final class zzab implements Creator<LocationRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = SafeParcelReader.m21925b(parcel);
        long j = 3600000;
        long j2 = 600000;
        long j3 = Long.MAX_VALUE;
        long j4 = 0;
        int i = 102;
        boolean z = false;
        int i2 = MoPubClientPositioning.NO_REPEAT;
        float f = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            switch (SafeParcelReader.m21919a(a)) {
                case 1:
                    i = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 2:
                    j = SafeParcelReader.m21951y(parcel2, a);
                    break;
                case 3:
                    j2 = SafeParcelReader.m21951y(parcel2, a);
                    break;
                case 4:
                    z = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 5:
                    j3 = SafeParcelReader.m21951y(parcel2, a);
                    break;
                case 6:
                    i2 = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 7:
                    f = SafeParcelReader.m21947u(parcel2, a);
                    break;
                case 8:
                    j4 = SafeParcelReader.m21951y(parcel2, a);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel2, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel2, b);
        LocationRequest locationRequest = new LocationRequest(i, j, j2, z, j3, i2, f, j4);
        return locationRequest;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationRequest[i];
    }
}
