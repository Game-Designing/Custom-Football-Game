package kotlin.p382f;

import kotlin.p376c.p378b.C14281f;
import kotlin.p380d.C14288b;
import kotlin.p380d.C14291d;

/* renamed from: kotlin.f.l */
/* compiled from: Strings.kt */
class C14325l extends C14324k {
    /* renamed from: a */
    public static final int m45934a(CharSequence $this$lastIndex) {
        C14281f.m45916b($this$lastIndex, "$this$lastIndex");
        return $this$lastIndex.length() - 1;
    }

    /* renamed from: a */
    public static final boolean m45939a(CharSequence $this$regionMatchesImpl, int thisOffset, CharSequence other, int otherOffset, int length, boolean ignoreCase) {
        C14281f.m45916b($this$regionMatchesImpl, "$this$regionMatchesImpl");
        C14281f.m45916b(other, "other");
        if (otherOffset < 0 || thisOffset < 0 || thisOffset > $this$regionMatchesImpl.length() - length || otherOffset > other.length() - length) {
            return false;
        }
        for (int index = 0; index < length; index++) {
            if (!C14315b.m45931a($this$regionMatchesImpl.charAt(thisOffset + index), other.charAt(otherOffset + index), ignoreCase)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ int m45936a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return m45935a(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    /* renamed from: a */
    private static final int m45935a(CharSequence $this$indexOf, CharSequence other, int startIndex, int endIndex, boolean ignoreCase, boolean last) {
        C14288b bVar;
        if (!last) {
            bVar = new C14291d(C14296h.m45928a(startIndex, 0), C14296h.m45929b(endIndex, $this$indexOf.length()));
        } else {
            bVar = C14296h.m45930c(C14296h.m45929b(startIndex, m45934a($this$indexOf)), C14296h.m45928a(endIndex, 0));
        }
        C14288b indices = bVar;
        if (!($this$indexOf instanceof String) || !(other instanceof String)) {
            int index = indices.getFirst();
            int last2 = indices.getLast();
            int a = indices.mo44460a();
            if (a < 0 ? index >= last2 : index <= last2) {
                while (true) {
                    if (!m45939a(other, 0, $this$indexOf, index, other.length(), ignoreCase)) {
                        if (index == last2) {
                            break;
                        }
                        index += a;
                    } else {
                        return index;
                    }
                }
            }
        } else {
            int index2 = indices.getFirst();
            int last3 = indices.getLast();
            int a2 = indices.mo44460a();
            if (a2 < 0 ? index2 >= last3 : index2 <= last3) {
                while (true) {
                    if (!C14324k.m45933a((String) other, 0, (String) $this$indexOf, index2, other.length(), ignoreCase)) {
                        if (index2 == last3) {
                            break;
                        }
                        index2 += a2;
                    } else {
                        return index2;
                    }
                }
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static /* synthetic */ int m45938a(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m45937a(charSequence, str, i, z);
    }

    /* renamed from: a */
    public static final int m45937a(CharSequence $this$indexOf, String string, int startIndex, boolean ignoreCase) {
        C14281f.m45916b($this$indexOf, "$this$indexOf");
        C14281f.m45916b(string, "string");
        if (!ignoreCase && ($this$indexOf instanceof String)) {
            return ((String) $this$indexOf).indexOf(string, startIndex);
        }
        return m45936a($this$indexOf, string, startIndex, $this$indexOf.length(), ignoreCase, false, 16, null);
    }
}
