package p019d.p143b.p144a.p147c;

import java.util.List;
import p019d.p143b.p149c.C7248b;
import p019d.p143b.p149c.C7249c;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.Db */
public class C7054Db extends C7050Cb {
    public C7054Db(C7142c cVar, List<C7154f> list, C7248b bVar) {
        super("TaskCacheNativeAdVideos", cVar, list, bVar);
    }

    public C7054Db(C7142c cVar, List<C7154f> list, C7249c cVar2) {
        super("TaskCacheNativeAdVideos", cVar, list, cVar2);
    }

    /* renamed from: b */
    private boolean m14662b(C7154f fVar) {
        C7262l lVar = this.f13626c;
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to cache video resource ");
        sb.append(fVar.mo23119e());
        lVar.mo22913a("TaskCacheNativeAdVideos", sb.toString());
        mo22794a(fVar, !C7202r.m15406a(this.f13627d, this.f13625b) ? -103 : -202);
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo22752a(C7154f fVar) {
        C7249c cVar = this.f13175i;
        if (cVar != null) {
            cVar.mo22974a(fVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo22794a(C7154f fVar, int i) {
        C7249c cVar = this.f13175i;
        if (cVar != null) {
            cVar.mo22977b(fVar, i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo22754a(C7154f fVar, C7068H h) {
        String str = "TaskCacheNativeAdVideos";
        if (!C7269s.m15819a(fVar.mo23119e())) {
            this.f13625b.mo23049b().mo22918c(str, "No video attached to ad, nothing to cache...");
            return true;
        }
        C7262l b = this.f13625b.mo23049b();
        StringBuilder sb = new StringBuilder();
        sb.append("Beginning slot video caching for ad ");
        sb.append(fVar.mo23127m());
        b.mo22918c(str, sb.toString());
        if (((Boolean) this.f13625b.mo23039a(C7196pb.f13724M)).booleanValue()) {
            String a = mo22772a(fVar.mo23119e(), h, fVar.mo23114b());
            if (a == null) {
                return m14662b(fVar);
            }
            fVar.mo23117c(a);
        } else {
            this.f13625b.mo23049b().mo22918c(str, "Resource caching is disabled, skipping...");
        }
        return true;
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }
}
