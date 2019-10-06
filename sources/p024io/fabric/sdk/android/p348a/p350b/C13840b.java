package p024io.fabric.sdk.android.p348a.p350b;

/* renamed from: io.fabric.sdk.android.a.b.b */
/* compiled from: AdvertisingInfo */
class C13840b {

    /* renamed from: a */
    public final String f42016a;

    /* renamed from: b */
    public final boolean f42017b;

    C13840b(String advertisingId, boolean limitAdTrackingEnabled) {
        this.f42016a = advertisingId;
        this.f42017b = limitAdTrackingEnabled;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        C13840b infoToCompare = (C13840b) o;
        if (this.f42017b != infoToCompare.f42017b) {
            return false;
        }
        String str = this.f42016a;
        if (str == null ? infoToCompare.f42016a == null : str.equals(infoToCompare.f42016a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f42016a;
        return ((str != null ? str.hashCode() : 0) * 31) + (this.f42017b ? 1 : 0);
    }
}
