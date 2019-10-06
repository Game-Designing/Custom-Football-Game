package android.support.p000v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.p000v4.media.session.PlaybackStateCompat.CustomAction;

/* renamed from: android.support.v4.media.session.m */
/* compiled from: PlaybackStateCompat */
class C0563m implements Creator<CustomAction> {
    C0563m() {
    }

    public CustomAction createFromParcel(Parcel p) {
        return new CustomAction(p);
    }

    public CustomAction[] newArray(int size) {
        return new CustomAction[size];
    }
}
