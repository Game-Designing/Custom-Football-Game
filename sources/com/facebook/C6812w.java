package com.facebook;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.GraphRequest.ParcelableResourceWithMimeType;

/* renamed from: com.facebook.w */
/* compiled from: GraphRequest */
class C6812w implements Creator<ParcelableResourceWithMimeType> {
    C6812w() {
    }

    public ParcelableResourceWithMimeType createFromParcel(Parcel in) {
        return new ParcelableResourceWithMimeType(in, (C6789s) null);
    }

    public ParcelableResourceWithMimeType[] newArray(int size) {
        return new ParcelableResourceWithMimeType[size];
    }
}
