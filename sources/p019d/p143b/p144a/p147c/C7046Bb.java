package p019d.p143b.p144a.p147c;

import java.util.List;
import p019d.p143b.p149c.C7248b;
import p019d.p143b.p149c.C7249c;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.Bb */
public class C7046Bb extends C7050Cb {
    public C7046Bb(C7142c cVar, List<C7154f> list, C7248b bVar) {
        super("TaskCacheNativeAdImages", cVar, list, bVar);
    }

    public C7046Bb(C7142c cVar, List<C7154f> list, C7249c cVar2) {
        super("TaskCacheNativeAdImages", cVar, list, cVar2);
    }

    /* renamed from: b */
    private boolean m14604b(C7154f fVar) {
        this.f13626c.mo22913a("TaskCacheNativeAdImages", "Unable to cache image resource");
        mo22753a(fVar, !C7202r.m15406a(this.f13627d, this.f13625b) ? -103 : -201);
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo22752a(C7154f fVar) {
        C7249c cVar = this.f13175i;
        if (cVar != null) {
            cVar.mo22976b(fVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo22753a(C7154f fVar, int i) {
        C7249c cVar = this.f13175i;
        if (cVar != null) {
            cVar.mo22975a(fVar, i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo22754a(C7154f fVar, C7068H h) {
        C7262l b = this.f13625b.mo23049b();
        StringBuilder sb = new StringBuilder();
        sb.append("Beginning slot image caching for ad ");
        sb.append(fVar.mo23127m());
        String str = "TaskCacheNativeAdImages";
        b.mo22918c(str, sb.toString());
        if (((Boolean) this.f13625b.mo23039a(C7196pb.f13724M)).booleanValue()) {
            String a = mo22772a(fVar.mo23116c(), h, fVar.mo23114b());
            if (a == null) {
                return m14604b(fVar);
            }
            fVar.mo23113a(a);
            String a2 = mo22772a(fVar.mo23118d(), h, fVar.mo23114b());
            if (a2 == null) {
                return m14604b(fVar);
            }
            fVar.mo23115b(a2);
        } else {
            this.f13625b.mo23049b().mo22918c(str, "Resource caching is disabled, skipping...");
        }
        return true;
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }
}
