package com.facebook;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.m */
/* compiled from: FacebookRequestError */
class C6782m implements Creator<FacebookRequestError> {
    C6782m() {
    }

    public FacebookRequestError createFromParcel(Parcel in) {
        return new FacebookRequestError(in, (C6782m) null);
    }

    public FacebookRequestError[] newArray(int size) {
        return new FacebookRequestError[size];
    }
}
