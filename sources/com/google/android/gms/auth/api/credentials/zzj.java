package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzj implements Creator<HintRequest> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new HintRequest[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        CredentialPickerConfig credentialPickerConfig = null;
        String[] strArr = null;
        String str = null;
        String str2 = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 != 1000) {
                switch (a2) {
                    case 1:
                        credentialPickerConfig = (CredentialPickerConfig) SafeParcelReader.m21921a(parcel, a, CredentialPickerConfig.CREATOR);
                        break;
                    case 2:
                        z = SafeParcelReader.m21945s(parcel, a);
                        break;
                    case 3:
                        z2 = SafeParcelReader.m21945s(parcel, a);
                        break;
                    case 4:
                        strArr = SafeParcelReader.m21942p(parcel, a);
                        break;
                    case 5:
                        z3 = SafeParcelReader.m21945s(parcel, a);
                        break;
                    case 6:
                        str = SafeParcelReader.m21941o(parcel, a);
                        break;
                    case 7:
                        str2 = SafeParcelReader.m21941o(parcel, a);
                        break;
                    default:
                        SafeParcelReader.m21918C(parcel, a);
                        break;
                }
            } else {
                i = SafeParcelReader.m21949w(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        HintRequest hintRequest = new HintRequest(i, credentialPickerConfig, z, z2, strArr, z3, str, str2);
        return hintRequest;
    }
}
