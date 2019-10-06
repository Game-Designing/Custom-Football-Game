package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.share.model.e */
/* compiled from: ShareOpenGraphContent */
class C6806e implements Creator<ShareOpenGraphContent> {
    C6806e() {
    }

    public ShareOpenGraphContent createFromParcel(Parcel in) {
        return new ShareOpenGraphContent(in);
    }

    public ShareOpenGraphContent[] newArray(int size) {
        return new ShareOpenGraphContent[size];
    }
}
