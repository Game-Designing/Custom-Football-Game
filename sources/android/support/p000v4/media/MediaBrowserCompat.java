package android.support.p000v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.p037os.ResultReceiver;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.MediaBrowserCompat */
public final class MediaBrowserCompat {

    /* renamed from: a */
    static final boolean f1706a = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: android.support.v4.media.MediaBrowserCompat$CustomActionResultReceiver */
    private static class CustomActionResultReceiver extends ResultReceiver {

        /* renamed from: a */
        private final String f1707a;

        /* renamed from: b */
        private final Bundle f1708b;

        /* renamed from: c */
        private final C0528a f1709c;

        /* access modifiers changed from: protected */
        public void onReceiveResult(int resultCode, Bundle resultData) {
            C0528a aVar = this.f1709c;
            if (aVar != null) {
                if (resultCode == -1) {
                    aVar.mo5333a(this.f1707a, this.f1708b, resultData);
                } else if (resultCode == 0) {
                    aVar.mo5335c(this.f1707a, this.f1708b, resultData);
                } else if (resultCode != 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown result code: ");
                    sb.append(resultCode);
                    sb.append(" (extras=");
                    sb.append(this.f1708b);
                    sb.append(", resultData=");
                    sb.append(resultData);
                    sb.append(")");
                    Log.w("MediaBrowserCompat", sb.toString());
                } else {
                    aVar.mo5334b(this.f1707a, this.f1708b, resultData);
                }
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ItemReceiver */
    private static class ItemReceiver extends ResultReceiver {

        /* renamed from: a */
        private final String f1710a;

        /* renamed from: b */
        private final C0529b f1711b;

        /* access modifiers changed from: protected */
        public void onReceiveResult(int resultCode, Bundle resultData) {
            if (resultData != null) {
                resultData.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (resultCode == 0 && resultData != null) {
                String str = "media_item";
                if (resultData.containsKey(str)) {
                    Parcelable item = resultData.getParcelable(str);
                    if (item == null || (item instanceof MediaItem)) {
                        this.f1711b.mo5336a((MediaItem) item);
                    } else {
                        this.f1711b.mo5337a(this.f1710a);
                    }
                    return;
                }
            }
            this.f1711b.mo5337a(this.f1710a);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem */
    public static class MediaItem implements Parcelable {
        public static final Creator<MediaItem> CREATOR = new C0532a();

        /* renamed from: a */
        private final int f1712a;

        /* renamed from: b */
        private final MediaDescriptionCompat f1713b;

        MediaItem(Parcel in) {
            this.f1712a = in.readInt();
            this.f1713b = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(in);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            out.writeInt(this.f1712a);
            this.f1713b.writeToParcel(out, flags);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MediaItem{");
            sb.append("mFlags=");
            sb.append(this.f1712a);
            sb.append(", mDescription=");
            sb.append(this.f1713b);
            sb.append('}');
            return sb.toString();
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$SearchResultReceiver */
    private static class SearchResultReceiver extends ResultReceiver {

        /* renamed from: a */
        private final String f1714a;

        /* renamed from: b */
        private final Bundle f1715b;

        /* renamed from: c */
        private final C0530c f1716c;

        /* access modifiers changed from: protected */
        public void onReceiveResult(int resultCode, Bundle resultData) {
            if (resultData != null) {
                resultData.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (resultCode == 0 && resultData != null) {
                String str = "search_results";
                if (resultData.containsKey(str)) {
                    Parcelable[] items = resultData.getParcelableArray(str);
                    List<MediaItem> results = null;
                    if (items != null) {
                        results = new ArrayList<>();
                        int length = items.length;
                        for (int i = 0; i < length; i++) {
                            results.add((MediaItem) items[i]);
                        }
                    }
                    this.f1716c.mo5339a(this.f1714a, this.f1715b, results);
                    return;
                }
            }
            this.f1716c.mo5338a(this.f1714a, this.f1715b);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$a */
    public static abstract class C0528a {
        /* renamed from: a */
        public abstract void mo5333a(String str, Bundle bundle, Bundle bundle2);

        /* renamed from: b */
        public abstract void mo5334b(String str, Bundle bundle, Bundle bundle2);

        /* renamed from: c */
        public abstract void mo5335c(String str, Bundle bundle, Bundle bundle2);
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$b */
    public static abstract class C0529b {
        /* renamed from: a */
        public abstract void mo5336a(MediaItem mediaItem);

        /* renamed from: a */
        public abstract void mo5337a(String str);
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$c */
    public static abstract class C0530c {
        /* renamed from: a */
        public abstract void mo5338a(String str, Bundle bundle);

        /* renamed from: a */
        public abstract void mo5339a(String str, Bundle bundle, List<MediaItem> list);
    }
}
