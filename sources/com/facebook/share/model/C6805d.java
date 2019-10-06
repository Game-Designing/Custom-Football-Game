package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.share.model.d */
/* compiled from: ShareOpenGraphAction */
class C6805d implements Creator<ShareOpenGraphAction> {
    C6805d() {
    }

    public ShareOpenGraphAction createFromParcel(Parcel in) {
        return new ShareOpenGraphAction(in);
    }

    public ShareOpenGraphAction[] newArray(int size) {
        return new ShareOpenGraphAction[size];
    }
}
