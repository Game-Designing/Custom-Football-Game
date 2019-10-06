package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.share.model.b */
/* compiled from: ShareLinkContent */
class C6803b implements Creator<ShareLinkContent> {
    C6803b() {
    }

    public ShareLinkContent createFromParcel(Parcel in) {
        return new ShareLinkContent(in);
    }

    public ShareLinkContent[] newArray(int size) {
        return new ShareLinkContent[size];
    }
}
