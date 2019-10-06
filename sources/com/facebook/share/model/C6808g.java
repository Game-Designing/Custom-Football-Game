package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.share.model.g */
/* compiled from: SharePhoto */
class C6808g implements Creator<SharePhoto> {
    C6808g() {
    }

    public SharePhoto createFromParcel(Parcel source) {
        return new SharePhoto(source);
    }

    public SharePhoto[] newArray(int size) {
        return new SharePhoto[size];
    }
}
