package android.support.p000v4.media.session;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.session.MediaSessionCompat$Token */
public final class MediaSessionCompat$Token implements Parcelable {
    public static final Creator<MediaSessionCompat$Token> CREATOR = new C0559i();

    /* renamed from: a */
    private final Object f1750a;

    /* renamed from: b */
    private final C0544b f1751b;

    MediaSessionCompat$Token(Object inner) {
        this(inner, null);
    }

    MediaSessionCompat$Token(Object inner, C0544b extraBinder) {
        this.f1750a = inner;
        this.f1751b = extraBinder;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (VERSION.SDK_INT >= 21) {
            dest.writeParcelable((Parcelable) this.f1750a, flags);
        } else {
            dest.writeStrongBinder((IBinder) this.f1750a);
        }
    }

    public int hashCode() {
        Object obj = this.f1750a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSessionCompat$Token)) {
            return false;
        }
        MediaSessionCompat$Token other = (MediaSessionCompat$Token) obj;
        Object obj2 = this.f1750a;
        if (obj2 == null) {
            if (other.f1750a != null) {
                z = false;
            }
            return z;
        }
        Object obj3 = other.f1750a;
        if (obj3 == null) {
            return false;
        }
        return obj2.equals(obj3);
    }
}
