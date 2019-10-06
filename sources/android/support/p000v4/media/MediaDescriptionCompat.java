package android.support.p000v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

/* renamed from: android.support.v4.media.MediaDescriptionCompat */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new C0533b();

    /* renamed from: a */
    private final String f1717a;

    /* renamed from: b */
    private final CharSequence f1718b;

    /* renamed from: c */
    private final CharSequence f1719c;

    /* renamed from: d */
    private final CharSequence f1720d;

    /* renamed from: e */
    private final Bitmap f1721e;

    /* renamed from: f */
    private final Uri f1722f;

    /* renamed from: g */
    private final Bundle f1723g;

    /* renamed from: h */
    private final Uri f1724h;

    /* renamed from: i */
    private Object f1725i;

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$a */
    public static final class C0531a {

        /* renamed from: a */
        private String f1726a;

        /* renamed from: b */
        private CharSequence f1727b;

        /* renamed from: c */
        private CharSequence f1728c;

        /* renamed from: d */
        private CharSequence f1729d;

        /* renamed from: e */
        private Bitmap f1730e;

        /* renamed from: f */
        private Uri f1731f;

        /* renamed from: g */
        private Bundle f1732g;

        /* renamed from: h */
        private Uri f1733h;

        /* renamed from: a */
        public C0531a mo5348a(String mediaId) {
            this.f1726a = mediaId;
            return this;
        }

        /* renamed from: c */
        public C0531a mo5352c(CharSequence title) {
            this.f1727b = title;
            return this;
        }

        /* renamed from: b */
        public C0531a mo5351b(CharSequence subtitle) {
            this.f1728c = subtitle;
            return this;
        }

        /* renamed from: a */
        public C0531a mo5347a(CharSequence description) {
            this.f1729d = description;
            return this;
        }

        /* renamed from: a */
        public C0531a mo5344a(Bitmap icon) {
            this.f1730e = icon;
            return this;
        }

        /* renamed from: a */
        public C0531a mo5345a(Uri iconUri) {
            this.f1731f = iconUri;
            return this;
        }

        /* renamed from: a */
        public C0531a mo5346a(Bundle extras) {
            this.f1732g = extras;
            return this;
        }

        /* renamed from: b */
        public C0531a mo5350b(Uri mediaUri) {
            this.f1733h = mediaUri;
            return this;
        }

        /* renamed from: a */
        public MediaDescriptionCompat mo5349a() {
            MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(this.f1726a, this.f1727b, this.f1728c, this.f1729d, this.f1730e, this.f1731f, this.f1732g, this.f1733h);
            return mediaDescriptionCompat;
        }
    }

    MediaDescriptionCompat(String mediaId, CharSequence title, CharSequence subtitle, CharSequence description, Bitmap icon, Uri iconUri, Bundle extras, Uri mediaUri) {
        this.f1717a = mediaId;
        this.f1718b = title;
        this.f1719c = subtitle;
        this.f1720d = description;
        this.f1721e = icon;
        this.f1722f = iconUri;
        this.f1723g = extras;
        this.f1724h = mediaUri;
    }

    MediaDescriptionCompat(Parcel in) {
        this.f1717a = in.readString();
        this.f1718b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        this.f1719c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        this.f1720d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        this.f1721e = (Bitmap) in.readParcelable(null);
        this.f1722f = (Uri) in.readParcelable(null);
        this.f1723g = in.readBundle();
        this.f1724h = (Uri) in.readParcelable(null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (VERSION.SDK_INT < 21) {
            dest.writeString(this.f1717a);
            TextUtils.writeToParcel(this.f1718b, dest, flags);
            TextUtils.writeToParcel(this.f1719c, dest, flags);
            TextUtils.writeToParcel(this.f1720d, dest, flags);
            dest.writeParcelable(this.f1721e, flags);
            dest.writeParcelable(this.f1722f, flags);
            dest.writeBundle(this.f1723g);
            dest.writeParcelable(this.f1724h, flags);
            return;
        }
        C0534c.m2642a(mo5340a(), dest, flags);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1718b);
        String str = ", ";
        sb.append(str);
        sb.append(this.f1719c);
        sb.append(str);
        sb.append(this.f1720d);
        return sb.toString();
    }

    /* renamed from: a */
    public Object mo5340a() {
        if (this.f1725i != null || VERSION.SDK_INT < 21) {
            return this.f1725i;
        }
        Object bob = C0535a.m2649a();
        C0535a.m2655a(bob, this.f1717a);
        C0535a.m2657c(bob, this.f1718b);
        C0535a.m2656b(bob, this.f1719c);
        C0535a.m2654a(bob, this.f1720d);
        C0535a.m2651a(bob, this.f1721e);
        C0535a.m2652a(bob, this.f1722f);
        Bundle extras = this.f1723g;
        if (VERSION.SDK_INT < 23 && this.f1724h != null) {
            if (extras == null) {
                extras = new Bundle();
                extras.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            extras.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f1724h);
        }
        C0535a.m2653a(bob, extras);
        if (VERSION.SDK_INT >= 23) {
            C0537a.m2659b(bob, this.f1724h);
        }
        this.f1725i = C0535a.m2650a(bob);
        return this.f1725i;
    }

    /* renamed from: a */
    public static MediaDescriptionCompat m2628a(Object descriptionObj) {
        Uri mediaUri = null;
        if (descriptionObj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        C0531a bob = new C0531a();
        bob.mo5348a(C0534c.m2646e(descriptionObj));
        bob.mo5352c(C0534c.m2648g(descriptionObj));
        bob.mo5351b(C0534c.m2647f(descriptionObj));
        bob.mo5347a(C0534c.m2640a(descriptionObj));
        bob.mo5344a(C0534c.m2644c(descriptionObj));
        bob.mo5345a(C0534c.m2645d(descriptionObj));
        Bundle extras = C0534c.m2643b(descriptionObj);
        String str = "android.support.v4.media.description.MEDIA_URI";
        if (extras != null) {
            mediaUri = (Uri) extras.getParcelable(str);
        }
        if (mediaUri != null) {
            String str2 = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
            if (!extras.containsKey(str2) || extras.size() != 2) {
                extras.remove(str);
                extras.remove(str2);
            } else {
                extras = null;
            }
        }
        bob.mo5346a(extras);
        if (mediaUri != null) {
            bob.mo5350b(mediaUri);
        } else if (VERSION.SDK_INT >= 23) {
            bob.mo5350b(C0536d.m2658h(descriptionObj));
        }
        MediaDescriptionCompat descriptionCompat = bob.mo5349a();
        descriptionCompat.f1725i = descriptionObj;
        return descriptionCompat;
    }
}
