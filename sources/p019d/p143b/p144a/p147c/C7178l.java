package p019d.p143b.p144a.p147c;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: d.b.a.c.l */
public class C7178l {
    /* renamed from: a */
    public static List<String> m15309a(String str) {
        return m15310a(str, ",\\s*");
    }

    /* renamed from: a */
    public static List<String> m15310a(String str, String str2) {
        return TextUtils.isEmpty(str) ? Collections.emptyList() : Arrays.asList(str.split(str2));
    }
}
