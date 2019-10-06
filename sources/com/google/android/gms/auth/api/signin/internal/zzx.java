package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzx implements Creator<SignInConfiguration> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInConfiguration[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        String str = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 2) {
                str = SafeParcelReader.m21941o(parcel, a);
            } else if (a2 != 5) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                googleSignInOptions = (GoogleSignInOptions) SafeParcelReader.m21921a(parcel, a, GoogleSignInOptions.CREATOR);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new SignInConfiguration(str, googleSignInOptions);
    }
}
