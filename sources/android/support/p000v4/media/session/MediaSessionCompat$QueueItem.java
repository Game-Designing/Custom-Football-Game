package android.support.p000v4.media.session;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem */
public final class MediaSessionCompat$QueueItem implements Parcelable {
    public static final Creator<MediaSessionCompat$QueueItem> CREATOR = new C0557g();

    /* renamed from: a */
    private final MediaDescriptionCompat f1746a;

    /* renamed from: b */
    private final long f1747b;

    /* renamed from: c */
    private Object f1748c;

    private MediaSessionCompat$QueueItem(Object queueItem, MediaDescriptionCompat description, long id) {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null.");
        } else if (id != -1) {
            this.f1746a = description;
            this.f1747b = id;
            this.f1748c = queueItem;
        } else {
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        }
    }

    MediaSessionCompat$QueueItem(Parcel in) {
        this.f1746a = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(in);
        this.f1747b = in.readLong();
    }

    public void writeToParcel(Parcel dest, int flags) {
        this.f1746a.writeToParcel(dest, flags);
        dest.writeLong(this.f1747b);
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: a */
    public static MediaSessionCompat$QueueItem m2670a(Object queueItem) {
        if (queueItem == null || VERSION.SDK_INT < 21) {
            return null;
        }
        return new MediaSessionCompat$QueueItem(queueItem, MediaDescriptionCompat.m2628a(C0560j.m2733a(queueItem)), C0560j.m2734b(queueItem));
    }

    /* renamed from: a */
    public static List<MediaSessionCompat$QueueItem> m2671a(List<?> itemList) {
        if (itemList == null || VERSION.SDK_INT < 21) {
            return null;
        }
        List<MediaSessionCompat$QueueItem> items = new ArrayList<>();
        for (Object itemObj : itemList) {
            items.add(m2670a(itemObj));
        }
        return items;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediaSession.QueueItem {Description=");
        sb.append(this.f1746a);
        sb.append(", Id=");
        sb.append(this.f1747b);
        sb.append(" }");
        return sb.toString();
    }
}
