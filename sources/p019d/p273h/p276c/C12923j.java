package p019d.p273h.p276c;

import android.os.Handler;
import android.os.Looper;
import p019d.p273h.p276c.p280d.C12799b;

/* renamed from: d.h.c.j */
/* compiled from: BannerCallbackThrottler */
public class C12923j {

    /* renamed from: a */
    private static C12923j f39763a;

    /* renamed from: b */
    private long f39764b = 0;

    /* renamed from: c */
    private boolean f39765c = false;

    /* renamed from: a */
    public static synchronized C12923j m42015a() {
        C12923j jVar;
        synchronized (C12923j.class) {
            if (f39763a == null) {
                f39763a = new C12923j();
            }
            jVar = f39763a;
        }
        return jVar;
    }

    private C12923j() {
    }

    /* renamed from: a */
    public void mo41706a(C12745G banner, C12799b error) {
        synchronized (this) {
            if (!this.f39765c) {
                long timeSinceLastCallMs = System.currentTimeMillis() - this.f39764b;
                if (timeSinceLastCallMs > 15000) {
                    m42017b(banner, error);
                    return;
                }
                this.f39765c = true;
                new Handler(Looper.getMainLooper()).postDelayed(new C12921i(this, banner, error), 15000 - timeSinceLastCallMs);
            }
        }
    }

    /* renamed from: b */
    public boolean mo41707b() {
        boolean z;
        synchronized (this) {
            z = this.f39765c;
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m42017b(C12745G banner, C12799b error) {
        this.f39764b = System.currentTimeMillis();
        this.f39765c = false;
        banner.mo41192a(error);
    }
}
