package kotlin.p382f;

import kotlin.p376c.p378b.C14281f;

/* renamed from: kotlin.f.k */
/* compiled from: StringsJVM.kt */
class C14324k extends C14323j {
    /* renamed from: a */
    public static final boolean m45933a(String $this$regionMatches, int thisOffset, String other, int otherOffset, int length, boolean ignoreCase) {
        C14281f.m45916b($this$regionMatches, "$this$regionMatches");
        C14281f.m45916b(other, "other");
        if (!ignoreCase) {
            return $this$regionMatches.regionMatches(thisOffset, other, otherOffset, length);
        }
        return $this$regionMatches.regionMatches(ignoreCase, thisOffset, other, otherOffset, length);
    }
}
