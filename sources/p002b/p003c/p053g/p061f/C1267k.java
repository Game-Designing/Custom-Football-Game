package p002b.p003c.p053g.p061f;

import android.os.Build.VERSION;
import java.util.Objects;

/* renamed from: b.c.g.f.k */
/* compiled from: ObjectsCompat */
public class C1267k {
    /* renamed from: a */
    public static boolean m5950a(Object a, Object b) {
        if (VERSION.SDK_INT >= 19) {
            return Objects.equals(a, b);
        }
        return a == b || (a != null && a.equals(b));
    }
}
