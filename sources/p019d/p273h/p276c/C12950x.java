package p019d.p273h.p276c;

import android.os.Handler;
import android.os.Looper;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p282f.C12884m;

/* renamed from: d.h.c.x */
/* compiled from: ISListenerWrapper */
public class C12950x {

    /* renamed from: a */
    private static final C12950x f39855a = new C12950x();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C12884m f39856b = null;

    /* renamed from: a */
    public static synchronized C12950x m42157a() {
        C12950x xVar;
        synchronized (C12950x.class) {
            xVar = f39855a;
        }
        return xVar;
    }

    private C12950x() {
    }

    /* renamed from: e */
    public synchronized void mo41776e() {
        if (this.f39856b != null) {
            new Handler(Looper.getMainLooper()).post(new C12941r(this));
        }
    }

    /* renamed from: d */
    public synchronized void mo41775d() {
        if (this.f39856b != null) {
            new Handler(Looper.getMainLooper()).post(new C12943s(this));
        }
    }

    /* renamed from: c */
    public synchronized void mo41774c() {
        if (this.f39856b != null) {
            new Handler(Looper.getMainLooper()).post(new C12945t(this));
        }
    }

    /* renamed from: f */
    public synchronized void mo41777f() {
        if (this.f39856b != null) {
            new Handler(Looper.getMainLooper()).post(new C12947u(this));
        }
    }

    /* renamed from: a */
    public synchronized void mo41772a(C12799b error) {
        if (this.f39856b != null) {
            new Handler(Looper.getMainLooper()).post(new C12948v(this, error));
        }
    }

    /* renamed from: b */
    public synchronized void mo41773b() {
        if (this.f39856b != null) {
            new Handler(Looper.getMainLooper()).post(new C12949w(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m42159a(String text) {
        C12802d.m41613c().mo41427b(C12801a.CALLBACK, text, 1);
    }
}
