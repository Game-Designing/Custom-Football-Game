package android.support.p000v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

/* renamed from: android.support.v4.media.c */
/* compiled from: MediaDescriptionCompatApi21 */
class C0534c {

    /* renamed from: android.support.v4.media.c$a */
    /* compiled from: MediaDescriptionCompatApi21 */
    static class C0535a {
        /* renamed from: a */
        public static Object m2649a() {
            return new Builder();
        }

        /* renamed from: a */
        public static void m2655a(Object builderObj, String mediaId) {
            ((Builder) builderObj).setMediaId(mediaId);
        }

        /* renamed from: c */
        public static void m2657c(Object builderObj, CharSequence title) {
            ((Builder) builderObj).setTitle(title);
        }

        /* renamed from: b */
        public static void m2656b(Object builderObj, CharSequence subtitle) {
            ((Builder) builderObj).setSubtitle(subtitle);
        }

        /* renamed from: a */
        public static void m2654a(Object builderObj, CharSequence description) {
            ((Builder) builderObj).setDescription(description);
        }

        /* renamed from: a */
        public static void m2651a(Object builderObj, Bitmap iconBitmap) {
            ((Builder) builderObj).setIconBitmap(iconBitmap);
        }

        /* renamed from: a */
        public static void m2652a(Object builderObj, Uri iconUri) {
            ((Builder) builderObj).setIconUri(iconUri);
        }

        /* renamed from: a */
        public static void m2653a(Object builderObj, Bundle extras) {
            ((Builder) builderObj).setExtras(extras);
        }

        /* renamed from: a */
        public static Object m2650a(Object builderObj) {
            return ((Builder) builderObj).build();
        }
    }

    /* renamed from: e */
    public static String m2646e(Object descriptionObj) {
        return ((MediaDescription) descriptionObj).getMediaId();
    }

    /* renamed from: g */
    public static CharSequence m2648g(Object descriptionObj) {
        return ((MediaDescription) descriptionObj).getTitle();
    }

    /* renamed from: f */
    public static CharSequence m2647f(Object descriptionObj) {
        return ((MediaDescription) descriptionObj).getSubtitle();
    }

    /* renamed from: a */
    public static CharSequence m2640a(Object descriptionObj) {
        return ((MediaDescription) descriptionObj).getDescription();
    }

    /* renamed from: c */
    public static Bitmap m2644c(Object descriptionObj) {
        return ((MediaDescription) descriptionObj).getIconBitmap();
    }

    /* renamed from: d */
    public static Uri m2645d(Object descriptionObj) {
        return ((MediaDescription) descriptionObj).getIconUri();
    }

    /* renamed from: b */
    public static Bundle m2643b(Object descriptionObj) {
        return ((MediaDescription) descriptionObj).getExtras();
    }

    /* renamed from: a */
    public static void m2642a(Object descriptionObj, Parcel dest, int flags) {
        ((MediaDescription) descriptionObj).writeToParcel(dest, flags);
    }

    /* renamed from: a */
    public static Object m2641a(Parcel in) {
        return MediaDescription.CREATOR.createFromParcel(in);
    }
}
