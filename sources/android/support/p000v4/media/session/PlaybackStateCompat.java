package android.support.p000v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.session.PlaybackStateCompat */
public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR = new C0562l();

    /* renamed from: a */
    final int f1757a;

    /* renamed from: b */
    final long f1758b;

    /* renamed from: c */
    final long f1759c;

    /* renamed from: d */
    final float f1760d;

    /* renamed from: e */
    final long f1761e;

    /* renamed from: f */
    final int f1762f;

    /* renamed from: g */
    final CharSequence f1763g;

    /* renamed from: h */
    final long f1764h;

    /* renamed from: i */
    List<CustomAction> f1765i;

    /* renamed from: j */
    final long f1766j;

    /* renamed from: k */
    final Bundle f1767k;

    /* renamed from: l */
    private Object f1768l;

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction */
    public static final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR = new C0563m();

        /* renamed from: a */
        private final String f1769a;

        /* renamed from: b */
        private final CharSequence f1770b;

        /* renamed from: c */
        private final int f1771c;

        /* renamed from: d */
        private final Bundle f1772d;

        /* renamed from: e */
        private Object f1773e;

        CustomAction(String action, CharSequence name, int icon, Bundle extras) {
            this.f1769a = action;
            this.f1770b = name;
            this.f1771c = icon;
            this.f1772d = extras;
        }

        CustomAction(Parcel in) {
            this.f1769a = in.readString();
            this.f1770b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            this.f1771c = in.readInt();
            this.f1772d = in.readBundle();
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.f1769a);
            TextUtils.writeToParcel(this.f1770b, dest, flags);
            dest.writeInt(this.f1771c);
            dest.writeBundle(this.f1772d);
        }

        public int describeContents() {
            return 0;
        }

        /* renamed from: a */
        public static CustomAction m2673a(Object customActionObj) {
            if (customActionObj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(C0565a.m2744a(customActionObj), C0565a.m2747d(customActionObj), C0565a.m2746c(customActionObj), C0565a.m2745b(customActionObj));
            customAction.f1773e = customActionObj;
            return customAction;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Action:mName='");
            sb.append(this.f1770b);
            sb.append(", mIcon=");
            sb.append(this.f1771c);
            sb.append(", mExtras=");
            sb.append(this.f1772d);
            return sb.toString();
        }
    }

    PlaybackStateCompat(int state, long position, long bufferedPosition, float rate, long actions, int errorCode, CharSequence errorMessage, long updateTime, List<CustomAction> customActions, long activeItemId, Bundle extras) {
        this.f1757a = state;
        this.f1758b = position;
        this.f1759c = bufferedPosition;
        this.f1760d = rate;
        this.f1761e = actions;
        this.f1762f = errorCode;
        this.f1763g = errorMessage;
        this.f1764h = updateTime;
        this.f1765i = new ArrayList(customActions);
        this.f1766j = activeItemId;
        this.f1767k = extras;
    }

    PlaybackStateCompat(Parcel in) {
        this.f1757a = in.readInt();
        this.f1758b = in.readLong();
        this.f1760d = in.readFloat();
        this.f1764h = in.readLong();
        this.f1759c = in.readLong();
        this.f1761e = in.readLong();
        this.f1763g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        this.f1765i = in.createTypedArrayList(CustomAction.CREATOR);
        this.f1766j = in.readLong();
        this.f1767k = in.readBundle();
        this.f1762f = in.readInt();
    }

    public String toString() {
        StringBuilder bob = new StringBuilder("PlaybackState {");
        bob.append("state=");
        bob.append(this.f1757a);
        bob.append(", position=");
        bob.append(this.f1758b);
        bob.append(", buffered position=");
        bob.append(this.f1759c);
        bob.append(", speed=");
        bob.append(this.f1760d);
        bob.append(", updated=");
        bob.append(this.f1764h);
        bob.append(", actions=");
        bob.append(this.f1761e);
        bob.append(", error code=");
        bob.append(this.f1762f);
        bob.append(", error message=");
        bob.append(this.f1763g);
        bob.append(", custom actions=");
        bob.append(this.f1765i);
        bob.append(", active item id=");
        bob.append(this.f1766j);
        bob.append("}");
        return bob.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f1757a);
        dest.writeLong(this.f1758b);
        dest.writeFloat(this.f1760d);
        dest.writeLong(this.f1764h);
        dest.writeLong(this.f1759c);
        dest.writeLong(this.f1761e);
        TextUtils.writeToParcel(this.f1763g, dest, flags);
        dest.writeTypedList(this.f1765i);
        dest.writeLong(this.f1766j);
        dest.writeBundle(this.f1767k);
        dest.writeInt(this.f1762f);
    }

    /* renamed from: a */
    public static PlaybackStateCompat m2672a(Object stateObj) {
        Bundle extras;
        Object obj = stateObj;
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> customActionObjs = C0564n.m2738d(stateObj);
        List<CustomAction> customActions = null;
        if (customActionObjs != null) {
            customActions = new ArrayList<>(customActionObjs.size());
            for (Object customActionObj : customActionObjs) {
                customActions.add(CustomAction.m2673a(customActionObj));
            }
        }
        if (VERSION.SDK_INT >= 22) {
            extras = C0566o.m2748a(stateObj);
        } else {
            extras = null;
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(C0564n.m2743i(stateObj), C0564n.m2742h(stateObj), C0564n.m2737c(stateObj), C0564n.m2741g(stateObj), C0564n.m2735a(stateObj), 0, C0564n.m2739e(stateObj), C0564n.m2740f(stateObj), customActions, C0564n.m2736b(stateObj), extras);
        playbackStateCompat.f1768l = obj;
        return playbackStateCompat;
    }
}
