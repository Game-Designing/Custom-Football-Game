package kotlin.p382f;

/* renamed from: kotlin.f.b */
/* compiled from: Char.kt */
class C14315b extends C14314a {
    /* renamed from: a */
    public static final boolean m45931a(char $this$equals, char other, boolean ignoreCase) {
        if ($this$equals == other) {
            return true;
        }
        if (!ignoreCase) {
            return false;
        }
        if (Character.toUpperCase($this$equals) == Character.toUpperCase(other) || Character.toLowerCase($this$equals) == Character.toLowerCase(other)) {
            return true;
        }
        return false;
    }
}
