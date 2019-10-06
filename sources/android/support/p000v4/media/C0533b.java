package android.support.p000v4.media;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.b */
/* compiled from: MediaDescriptionCompat */
class C0533b implements Creator<MediaDescriptionCompat> {
    C0533b() {
    }

    public MediaDescriptionCompat createFromParcel(Parcel in) {
        if (VERSION.SDK_INT < 21) {
            return new MediaDescriptionCompat(in);
        }
        return MediaDescriptionCompat.m2628a(C0534c.m2641a(in));
    }

    public MediaDescriptionCompat[] newArray(int size) {
        return new MediaDescriptionCompat[size];
    }
}
