package p024io.realm.internal;

import android.content.Context;
import com.getkeepsafe.relinker.C8065b;
import java.io.File;

/* renamed from: io.realm.internal.n */
/* compiled from: RealmCore */
public class C7342n {

    /* renamed from: a */
    private static final String f14326a = File.separator;

    /* renamed from: b */
    private static final String f14327b = File.pathSeparator;

    /* renamed from: c */
    private static final String f14328c;

    /* renamed from: d */
    private static volatile boolean f14329d = false;

    static {
        StringBuilder sb = new StringBuilder();
        String str = "lib";
        sb.append(str);
        sb.append(f14327b);
        sb.append("..");
        sb.append(f14326a);
        sb.append(str);
        f14328c = sb.toString();
    }

    /* renamed from: a */
    public static synchronized void m16192a(Context context) {
        synchronized (C7342n.class) {
            if (!f14329d) {
                C8065b.m18168a(context, "realm-jni", "3.5.0");
                f14329d = true;
            }
        }
    }
}
