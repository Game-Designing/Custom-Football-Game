package android.support.p000v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.e */
/* compiled from: MediaMetadataCompat */
class C0538e implements Creator<MediaMetadataCompat> {
    C0538e() {
    }

    public MediaMetadataCompat createFromParcel(Parcel in) {
        return new MediaMetadataCompat(in);
    }

    public MediaMetadataCompat[] newArray(int size) {
        return new MediaMetadataCompat[size];
    }
}
