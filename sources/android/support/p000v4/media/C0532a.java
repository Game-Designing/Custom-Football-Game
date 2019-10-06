package android.support.p000v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.p000v4.media.MediaBrowserCompat.MediaItem;

/* renamed from: android.support.v4.media.a */
/* compiled from: MediaBrowserCompat */
class C0532a implements Creator<MediaItem> {
    C0532a() {
    }

    public MediaItem createFromParcel(Parcel in) {
        return new MediaItem(in);
    }

    public MediaItem[] newArray(int size) {
        return new MediaItem[size];
    }
}
