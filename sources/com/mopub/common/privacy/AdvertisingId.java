package com.mopub.common.privacy;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;
import p005cm.aptoide.p006pt.notification.PullingContentService;

public class AdvertisingId implements Serializable {

    /* renamed from: a */
    final Calendar f34431a = Calendar.getInstance();

    /* renamed from: b */
    final String f34432b;

    /* renamed from: c */
    final String f34433c;

    /* renamed from: d */
    final boolean f34434d;

    AdvertisingId(String ifaId, String mopubId, boolean limitAdTrackingEnabled, long rotationTime) {
        Preconditions.checkNotNull(ifaId);
        Preconditions.checkNotNull(mopubId);
        this.f34432b = ifaId;
        this.f34433c = mopubId;
        this.f34434d = limitAdTrackingEnabled;
        this.f34431a.setTimeInMillis(rotationTime);
    }

    public String getIdentifier(boolean consent) {
        return (this.f34434d || !consent) ? this.f34433c : this.f34432b;
    }

    public String getIdWithPrefix(boolean consent) {
        if (this.f34434d || !consent || this.f34432b.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("mopub:");
            sb.append(this.f34433c);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ifa:");
        sb2.append(this.f34432b);
        return sb2.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public String mo36649d() {
        if (TextUtils.isEmpty(this.f34432b)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ifa:");
        sb.append(this.f34432b);
        return sb.toString();
    }

    public boolean isDoNotTrack() {
        return this.f34434d;
    }

    /* renamed from: a */
    static AdvertisingId m37090a() {
        Calendar time = Calendar.getInstance();
        AdvertisingId advertisingId = new AdvertisingId("", m37092c(), false, (time.getTimeInMillis() - PullingContentService.UPDATES_INTERVAL) - 1);
        return advertisingId;
    }

    /* renamed from: b */
    static AdvertisingId m37091b() {
        Calendar time = Calendar.getInstance();
        AdvertisingId advertisingId = new AdvertisingId("", m37092c(), false, time.getTimeInMillis());
        return advertisingId;
    }

    /* renamed from: c */
    static String m37092c() {
        return UUID.randomUUID().toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo36650e() {
        String str = "GMT";
        Calendar now = Calendar.getInstance(TimeZone.getTimeZone(str));
        Calendar lastRotation = Calendar.getInstance(TimeZone.getTimeZone(str));
        lastRotation.setTimeInMillis(this.f34431a.getTimeInMillis());
        if (now.get(6) == lastRotation.get(6) && now.get(1) == lastRotation.get(1)) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdvertisingId{mLastRotation=");
        sb.append(this.f34431a);
        sb.append(", mAdvertisingId='");
        sb.append(this.f34432b);
        sb.append('\'');
        sb.append(", mMopubId='");
        sb.append(this.f34433c);
        sb.append('\'');
        sb.append(", mDoNotTrack=");
        sb.append(this.f34434d);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AdvertisingId)) {
            return false;
        }
        AdvertisingId that = (AdvertisingId) o;
        if (this.f34434d == that.f34434d && this.f34432b.equals(that.f34432b)) {
            return this.f34433c.equals(that.f34433c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f34432b.hashCode() * 31) + this.f34433c.hashCode()) * 31) + (this.f34434d ? 1 : 0);
    }
}
