package android.support.p000v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;

/* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper */
final class MediaSessionCompat$ResultReceiverWrapper implements Parcelable {
    public static final Creator<MediaSessionCompat$ResultReceiverWrapper> CREATOR = new C0558h();

    /* renamed from: a */
    private ResultReceiver f1749a;

    MediaSessionCompat$ResultReceiverWrapper(Parcel in) {
        this.f1749a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(in);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        this.f1749a.writeToParcel(dest, flags);
    }
}
