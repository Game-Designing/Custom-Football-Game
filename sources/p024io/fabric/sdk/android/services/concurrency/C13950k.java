package p024io.fabric.sdk.android.services.concurrency;

/* renamed from: io.fabric.sdk.android.services.concurrency.k */
/* compiled from: Priority */
public enum C13950k {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    /* renamed from: a */
    static <Y> int m44332a(C13956p self, Y other) {
        C13950k otherPriority;
        if (other instanceof C13956p) {
            otherPriority = ((C13956p) other).getPriority();
        } else {
            otherPriority = NORMAL;
        }
        return otherPriority.ordinal() - self.getPriority().ordinal();
    }
}
