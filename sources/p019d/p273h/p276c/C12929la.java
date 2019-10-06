package p019d.p273h.p276c;

import android.os.Handler;
import android.os.Looper;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12820l;
import p019d.p273h.p276c.p282f.C12879ja;

/* renamed from: d.h.c.la */
/* compiled from: RVListenerWrapper */
public class C12929la {

    /* renamed from: a */
    private static final C12929la f39791a = new C12929la();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C12879ja f39792b = null;

    /* renamed from: a */
    public static synchronized C12929la m42049a() {
        C12929la laVar;
        synchronized (C12929la.class) {
            laVar = f39791a;
        }
        return laVar;
    }

    private C12929la() {
    }

    /* renamed from: c */
    public synchronized void mo41721c() {
        if (this.f39792b != null) {
            new Handler(Looper.getMainLooper()).post(new C12900fa(this));
        }
    }

    /* renamed from: b */
    public synchronized void mo41719b() {
        if (this.f39792b != null) {
            new Handler(Looper.getMainLooper()).post(new C12904ga(this));
        }
    }

    /* renamed from: a */
    public synchronized void mo41718a(boolean available) {
        if (this.f39792b != null) {
            new Handler(Looper.getMainLooper()).post(new C12920ha(this, available));
        }
    }

    /* renamed from: b */
    public synchronized void mo41720b(C12820l placement) {
        if (this.f39792b != null) {
            new Handler(Looper.getMainLooper()).post(new C12922ia(this, placement));
        }
    }

    /* renamed from: a */
    public synchronized void mo41716a(C12799b error) {
        if (this.f39792b != null) {
            new Handler(Looper.getMainLooper()).post(new C12924ja(this, error));
        }
    }

    /* renamed from: a */
    public synchronized void mo41717a(C12820l placement) {
        if (this.f39792b != null) {
            new Handler(Looper.getMainLooper()).post(new C12926ka(this, placement));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m42051a(String text) {
        C12802d.m41613c().mo41427b(C12801a.CALLBACK, text, 1);
    }
}
