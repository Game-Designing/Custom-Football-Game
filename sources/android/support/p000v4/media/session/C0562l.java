package android.support.p000v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.session.l */
/* compiled from: PlaybackStateCompat */
class C0562l implements Creator<PlaybackStateCompat> {
    C0562l() {
    }

    public PlaybackStateCompat createFromParcel(Parcel in) {
        return new PlaybackStateCompat(in);
    }

    public PlaybackStateCompat[] newArray(int size) {
        return new PlaybackStateCompat[size];
    }
}
