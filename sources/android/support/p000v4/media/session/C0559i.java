package android.support.p000v4.media.session;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.session.i */
/* compiled from: MediaSessionCompat */
class C0559i implements Creator<MediaSessionCompat$Token> {
    C0559i() {
    }

    public MediaSessionCompat$Token createFromParcel(Parcel in) {
        Object inner;
        if (VERSION.SDK_INT >= 21) {
            inner = in.readParcelable(null);
        } else {
            inner = in.readStrongBinder();
        }
        return new MediaSessionCompat$Token(inner);
    }

    public MediaSessionCompat$Token[] newArray(int size) {
        return new MediaSessionCompat$Token[size];
    }
}
