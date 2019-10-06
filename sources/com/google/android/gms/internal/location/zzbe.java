package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public final class zzbe implements Creator<zzbd> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        List<ClientIdentity> list = zzbd.f29946a;
        LocationRequest locationRequest = null;
        String str = null;
        String str2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 != 1) {
                switch (a2) {
                    case 5:
                        list = SafeParcelReader.m21929c(parcel, a, ClientIdentity.CREATOR);
                        break;
                    case 6:
                        str = SafeParcelReader.m21941o(parcel, a);
                        break;
                    case 7:
                        z = SafeParcelReader.m21945s(parcel, a);
                        break;
                    case 8:
                        z2 = SafeParcelReader.m21945s(parcel, a);
                        break;
                    case 9:
                        z3 = SafeParcelReader.m21945s(parcel, a);
                        break;
                    case 10:
                        str2 = SafeParcelReader.m21941o(parcel, a);
                        break;
                    default:
                        SafeParcelReader.m21918C(parcel, a);
                        break;
                }
            } else {
                locationRequest = (LocationRequest) SafeParcelReader.m21921a(parcel, a, LocationRequest.CREATOR);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        zzbd zzbd = new zzbd(locationRequest, list, str, z, z2, z3, str2);
        return zzbd;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbd[i];
    }
}
