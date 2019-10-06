package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzc implements Creator<PublisherAdViewOptions> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new PublisherAdViewOptions[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        IBinder iBinder = null;
        boolean z = false;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                z = SafeParcelReader.m21945s(parcel, a);
            } else if (a2 == 2) {
                iBinder = SafeParcelReader.m21948v(parcel, a);
            } else if (a2 != 3) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                iBinder2 = SafeParcelReader.m21948v(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new PublisherAdViewOptions(z, iBinder, iBinder2);
    }
}
