package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.zzj;
import java.util.List;

public final class zzn implements Creator<zzm> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        zzj zzj = zzm.f29974b;
        List<ClientIdentity> list = zzm.f29973a;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                zzj = (zzj) SafeParcelReader.m21921a(parcel, a, zzj.CREATOR);
            } else if (a2 == 2) {
                list = SafeParcelReader.m21929c(parcel, a, ClientIdentity.CREATOR);
            } else if (a2 != 3) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                str = SafeParcelReader.m21941o(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new zzm(zzj, list, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzm[i];
    }
}
