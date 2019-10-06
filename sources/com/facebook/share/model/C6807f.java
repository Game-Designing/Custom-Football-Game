package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.share.model.f */
/* compiled from: ShareOpenGraphObject */
class C6807f implements Creator<ShareOpenGraphObject> {
    C6807f() {
    }

    public ShareOpenGraphObject createFromParcel(Parcel in) {
        return new ShareOpenGraphObject(in);
    }

    public ShareOpenGraphObject[] newArray(int size) {
        return new ShareOpenGraphObject[size];
    }
}
