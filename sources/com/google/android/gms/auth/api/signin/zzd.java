package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzd implements Creator<SignInAccount> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInAccount[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        String str = "";
        GoogleSignInAccount googleSignInAccount = null;
        String str2 = str;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 4) {
                str = SafeParcelReader.m21941o(parcel, a);
            } else if (a2 == 7) {
                googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.m21921a(parcel, a, GoogleSignInAccount.CREATOR);
            } else if (a2 != 8) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                str2 = SafeParcelReader.m21941o(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new SignInAccount(str, googleSignInAccount, str2);
    }
}
