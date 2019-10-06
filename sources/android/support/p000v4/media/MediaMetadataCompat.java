package android.support.p000v4.media;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import p002b.p003c.p053g.p061f.C1253b;

/* renamed from: android.support.v4.media.MediaMetadataCompat */
public final class MediaMetadataCompat implements Parcelable {
    public static final Creator<MediaMetadataCompat> CREATOR = new C0538e();

    /* renamed from: a */
    static final C1253b<String, Integer> f1734a = new C1253b<>();

    /* renamed from: b */
    private static final String[] f1735b;

    /* renamed from: c */
    private static final String[] f1736c;

    /* renamed from: d */
    private static final String[] f1737d;

    /* renamed from: e */
    final Bundle f1738e;

    /* renamed from: f */
    private Object f1739f;

    static {
        C1253b<String, Integer> bVar = f1734a;
        Integer valueOf = Integer.valueOf(1);
        String str = "android.media.metadata.TITLE";
        bVar.put(str, valueOf);
        String str2 = "android.media.metadata.ARTIST";
        f1734a.put(str2, valueOf);
        C1253b<String, Integer> bVar2 = f1734a;
        Integer valueOf2 = Integer.valueOf(0);
        bVar2.put("android.media.metadata.DURATION", valueOf2);
        String str3 = "android.media.metadata.ALBUM";
        f1734a.put(str3, valueOf);
        String str4 = "android.media.metadata.AUTHOR";
        f1734a.put(str4, valueOf);
        String str5 = "android.media.metadata.WRITER";
        f1734a.put(str5, valueOf);
        String str6 = "android.media.metadata.COMPOSER";
        f1734a.put(str6, valueOf);
        f1734a.put("android.media.metadata.COMPILATION", valueOf);
        f1734a.put("android.media.metadata.DATE", valueOf);
        f1734a.put("android.media.metadata.YEAR", valueOf2);
        f1734a.put("android.media.metadata.GENRE", valueOf);
        f1734a.put("android.media.metadata.TRACK_NUMBER", valueOf2);
        f1734a.put("android.media.metadata.NUM_TRACKS", valueOf2);
        f1734a.put("android.media.metadata.DISC_NUMBER", valueOf2);
        String str7 = "android.media.metadata.ALBUM_ARTIST";
        f1734a.put(str7, valueOf);
        C1253b<String, Integer> bVar3 = f1734a;
        Integer valueOf3 = Integer.valueOf(2);
        String str8 = "android.media.metadata.ART";
        bVar3.put(str8, valueOf3);
        String str9 = "android.media.metadata.ART_URI";
        f1734a.put(str9, valueOf);
        String str10 = "android.media.metadata.ALBUM_ART";
        f1734a.put(str10, valueOf3);
        String str11 = "android.media.metadata.ALBUM_ART_URI";
        f1734a.put(str11, valueOf);
        C1253b<String, Integer> bVar4 = f1734a;
        String str12 = str11;
        Integer valueOf4 = Integer.valueOf(3);
        bVar4.put("android.media.metadata.USER_RATING", valueOf4);
        f1734a.put("android.media.metadata.RATING", valueOf4);
        f1734a.put("android.media.metadata.DISPLAY_TITLE", valueOf);
        f1734a.put("android.media.metadata.DISPLAY_SUBTITLE", valueOf);
        f1734a.put("android.media.metadata.DISPLAY_DESCRIPTION", valueOf);
        f1734a.put("android.media.metadata.DISPLAY_ICON", valueOf3);
        f1734a.put("android.media.metadata.DISPLAY_ICON_URI", valueOf);
        f1734a.put("android.media.metadata.MEDIA_ID", valueOf);
        f1734a.put("android.media.metadata.BT_FOLDER_TYPE", valueOf2);
        f1734a.put("android.media.metadata.MEDIA_URI", valueOf);
        f1734a.put("android.media.metadata.ADVERTISEMENT", valueOf2);
        f1734a.put("android.media.metadata.DOWNLOAD_STATUS", valueOf2);
        f1735b = new String[]{str, str2, str3, str7, str5, str4, str6};
        f1736c = new String[]{"android.media.metadata.DISPLAY_ICON", str8, str10};
        f1737d = new String[]{"android.media.metadata.DISPLAY_ICON_URI", str9, str12};
    }

    MediaMetadataCompat(Parcel in) {
        this.f1738e = in.readBundle();
        this.f1738e.setClassLoader(MediaMetadataCompat.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeBundle(this.f1738e);
    }

    /* renamed from: a */
    public static MediaMetadataCompat m2639a(Object metadataObj) {
        if (metadataObj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel p = Parcel.obtain();
        C0539f.m2660a(metadataObj, p, 0);
        p.setDataPosition(0);
        MediaMetadataCompat metadata = (MediaMetadataCompat) CREATOR.createFromParcel(p);
        p.recycle();
        metadata.f1739f = metadataObj;
        return metadata;
    }
}
