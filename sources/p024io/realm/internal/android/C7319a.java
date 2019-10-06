package p024io.realm.internal.android;

import android.os.Looper;
import p024io.realm.internal.C7314a;

/* renamed from: io.realm.internal.android.a */
/* compiled from: AndroidCapabilities */
public class C7319a implements C7314a {

    /* renamed from: a */
    private final Looper f14281a = Looper.myLooper();

    /* renamed from: b */
    private final boolean f14282b = m16076c();

    /* renamed from: a */
    public boolean mo23728a() {
        return m16075b() && !this.f14282b;
    }

    /* renamed from: a */
    public void mo23727a(String exceptionMessage) {
        String str = "";
        String str2 = " ";
        if (!m16075b()) {
            if (exceptionMessage != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(exceptionMessage);
                sb.append(str2);
                sb.append("Realm cannot be automatically updated on a thread without a looper.");
                str = sb.toString();
            }
            throw new IllegalStateException(str);
        } else if (this.f14282b) {
            if (exceptionMessage != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(exceptionMessage);
                sb2.append(str2);
                sb2.append("Realm cannot be automatically updated on an IntentService thread.");
                str = sb2.toString();
            }
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: b */
    private boolean m16075b() {
        return this.f14281a != null;
    }

    /* renamed from: c */
    private static boolean m16076c() {
        String threadName = Thread.currentThread().getName();
        return threadName != null && threadName.startsWith("IntentService[");
    }
}
