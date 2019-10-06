package android.support.p000v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.session.k */
/* compiled from: ParcelableVolumeInfo */
class C0561k implements Creator<ParcelableVolumeInfo> {
    C0561k() {
    }

    public ParcelableVolumeInfo createFromParcel(Parcel in) {
        return new ParcelableVolumeInfo(in);
    }

    public ParcelableVolumeInfo[] newArray(int size) {
        return new ParcelableVolumeInfo[size];
    }
}
