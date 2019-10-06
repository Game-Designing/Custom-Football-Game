package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zze implements Creator<CredentialPickerConfig> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new CredentialPickerConfig[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                z = SafeParcelReader.m21945s(parcel, a);
            } else if (a2 == 2) {
                z2 = SafeParcelReader.m21945s(parcel, a);
            } else if (a2 == 3) {
                z3 = SafeParcelReader.m21945s(parcel, a);
            } else if (a2 == 4) {
                i2 = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 != 1000) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                i = SafeParcelReader.m21949w(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        CredentialPickerConfig credentialPickerConfig = new CredentialPickerConfig(i, z, z2, z3, i2);
        return credentialPickerConfig;
    }
}
