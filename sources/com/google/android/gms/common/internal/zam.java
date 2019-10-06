package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zam implements Creator<ResolveAccountRequest> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new ResolveAccountRequest[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        Account account = null;
        int i = 0;
        GoogleSignInAccount googleSignInAccount = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                i = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 == 2) {
                account = (Account) SafeParcelReader.m21921a(parcel, a, Account.CREATOR);
            } else if (a2 == 3) {
                i2 = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 != 4) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.m21921a(parcel, a, GoogleSignInAccount.CREATOR);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new ResolveAccountRequest(i, account, i2, googleSignInAccount);
    }
}
