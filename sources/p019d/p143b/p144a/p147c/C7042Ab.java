package p019d.p143b.p144a.p147c;

import android.net.Uri;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.Ab */
public class C7042Ab extends C7232yb {

    /* renamed from: k */
    private final C7043Ac f13147k;

    /* renamed from: l */
    private boolean f13148l;

    public C7042Ab(C7043Ac ac, C7254d dVar, C7142c cVar) {
        super("TaskCacheAppLovinAd", ac, dVar, cVar);
        this.f13147k = ac;
    }

    /* renamed from: e */
    private void m14574e() {
        this.f13626c.mo22918c(this.f13624a, "Caching HTML resources...");
        this.f13147k.mo22738b(mo23389b(this.f13147k.mo22740oa(), this.f13147k.mo23400F()));
        C7262l lVar = this.f13626c;
        String str = this.f13624a;
        StringBuilder sb = new StringBuilder();
        sb.append("Finish caching non-video resources for ad #");
        sb.append(this.f13147k.mo22758b());
        lVar.mo22918c(str, sb.toString());
        C7262l lVar2 = this.f13626c;
        String str2 = this.f13624a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Ad updated with cachedHTML = ");
        sb2.append(this.f13147k.mo22740oa());
        lVar2.mo22918c(str2, sb2.toString());
    }

    /* renamed from: f */
    private void m14575f() {
        Uri a = mo23383a(this.f13147k.mo22742qa());
        if (a != null) {
            this.f13147k.mo22741pa();
            this.f13147k.mo22739c(a);
        }
    }

    /* renamed from: a */
    public void mo22736a(boolean z) {
        this.f13148l = z;
    }

    public void run() {
        String str = "...";
        if (this.f13147k.mo22405ha()) {
            C7262l lVar = this.f13626c;
            String str2 = this.f13624a;
            StringBuilder sb = new StringBuilder();
            sb.append("Begin caching for streaming ad #");
            sb.append(this.f13147k.mo22758b());
            sb.append(str);
            lVar.mo22918c(str2, sb.toString());
            mo23390b();
            if (this.f13148l) {
                this.f13626c.mo22918c(this.f13624a, "Calling back ad load immediately");
                mo23393c();
            }
            m14574e();
            if (!this.f13148l) {
                this.f13626c.mo22918c(this.f13624a, "Calling back ad load AFTER caching endcard");
                mo23393c();
            }
            m14575f();
        } else {
            C7262l lVar2 = this.f13626c;
            String str3 = this.f13624a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Begin processing for non-streaming ad #");
            sb2.append(this.f13147k.mo22758b());
            sb2.append(str);
            lVar2.mo22918c(str3, sb2.toString());
            mo23390b();
            m14574e();
            m14575f();
            this.f13626c.mo22918c(this.f13624a, "Caching finished. Calling back ad load success...");
            mo23393c();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f13147k.mo22404f();
        C7086Lb.m14819a(this.f13147k, this.f13625b);
        C7086Lb.m14818a(currentTimeMillis, (C7071Hc) this.f13147k, this.f13625b);
        mo23386a((C7071Hc) this.f13147k);
    }
}
