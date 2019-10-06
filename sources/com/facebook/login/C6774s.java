package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.login.s */
/* compiled from: LoginClient */
class C6774s implements Creator<LoginClient> {
    C6774s() {
    }

    public LoginClient createFromParcel(Parcel source) {
        return new LoginClient(source);
    }

    public LoginClient[] newArray(int size) {
        return new LoginClient[size];
    }
}
