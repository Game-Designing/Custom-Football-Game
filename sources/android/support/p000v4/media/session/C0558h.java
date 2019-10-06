package android.support.p000v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.session.h */
/* compiled from: MediaSessionCompat */
class C0558h implements Creator<MediaSessionCompat$ResultReceiverWrapper> {
    C0558h() {
    }

    public MediaSessionCompat$ResultReceiverWrapper createFromParcel(Parcel p) {
        return new MediaSessionCompat$ResultReceiverWrapper(p);
    }

    public MediaSessionCompat$ResultReceiverWrapper[] newArray(int size) {
        return new MediaSessionCompat$ResultReceiverWrapper[size];
    }
}
