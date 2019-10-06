package p024io.fabric.sdk.android.p348a.p350b;

/* renamed from: io.fabric.sdk.android.a.b.p */
/* compiled from: DeliveryMechanism */
public enum C13859p {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    

    /* renamed from: f */
    private final int f42057f;

    private C13859p(int id) {
        this.f42057f = id;
    }

    public int getId() {
        return this.f42057f;
    }

    public String toString() {
        return Integer.toString(this.f42057f);
    }

    /* renamed from: a */
    public static C13859p m44071a(String installerPackageName) {
        if ("io.crash.air".equals(installerPackageName)) {
            return TEST_DISTRIBUTION;
        }
        if (installerPackageName != null) {
            return APP_STORE;
        }
        return DEVELOPER;
    }
}
