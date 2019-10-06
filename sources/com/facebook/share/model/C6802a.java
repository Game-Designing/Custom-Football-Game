package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.share.model.a */
/* compiled from: ShareHashtag */
class C6802a implements Creator<ShareHashtag> {
    C6802a() {
    }

    public ShareHashtag createFromParcel(Parcel in) {
        return new ShareHashtag(in);
    }

    public ShareHashtag[] newArray(int size) {
        return new ShareHashtag[size];
    }
}
