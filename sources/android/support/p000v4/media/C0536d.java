package android.support.p000v4.media;

import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;

/* renamed from: android.support.v4.media.d */
/* compiled from: MediaDescriptionCompatApi23 */
class C0536d extends C0534c {

    /* renamed from: android.support.v4.media.d$a */
    /* compiled from: MediaDescriptionCompatApi23 */
    static class C0537a extends C0535a {
        /* renamed from: b */
        public static void m2659b(Object builderObj, Uri mediaUri) {
            ((Builder) builderObj).setMediaUri(mediaUri);
        }
    }

    /* renamed from: h */
    public static Uri m2658h(Object descriptionObj) {
        return ((MediaDescription) descriptionObj).getMediaUri();
    }
}
