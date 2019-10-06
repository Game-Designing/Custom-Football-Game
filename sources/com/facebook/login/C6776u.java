package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.login.LoginClient.Result;

/* renamed from: com.facebook.login.u */
/* compiled from: LoginClient */
class C6776u implements Creator<Result> {
    C6776u() {
    }

    public Result createFromParcel(Parcel source) {
        return new Result(source, null);
    }

    public Result[] newArray(int size) {
        return new Result[size];
    }
}
