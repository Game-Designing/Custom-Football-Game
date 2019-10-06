package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.login.LoginClient.Request;

/* renamed from: com.facebook.login.t */
/* compiled from: LoginClient */
class C6775t implements Creator<Request> {
    C6775t() {
    }

    public Request createFromParcel(Parcel source) {
        return new Request(source, null);
    }

    public Request[] newArray(int size) {
        return new Request[size];
    }
}
