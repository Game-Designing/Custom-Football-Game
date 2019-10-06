package android.support.p000v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.session.g */
/* compiled from: MediaSessionCompat */
class C0557g implements Creator<MediaSessionCompat$QueueItem> {
    C0557g() {
    }

    public MediaSessionCompat$QueueItem createFromParcel(Parcel p) {
        return new MediaSessionCompat$QueueItem(p);
    }

    public MediaSessionCompat$QueueItem[] newArray(int size) {
        return new MediaSessionCompat$QueueItem[size];
    }
}
