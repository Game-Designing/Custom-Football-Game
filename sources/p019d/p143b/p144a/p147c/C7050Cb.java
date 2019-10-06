package p019d.p143b.p144a.p147c;

import java.util.List;
import p019d.p143b.p149c.C7247a;
import p019d.p143b.p149c.C7248b;
import p019d.p143b.p149c.C7249c;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.Cb */
abstract class C7050Cb extends C7184mb {

    /* renamed from: f */
    private List<C7154f> f13172f;

    /* renamed from: g */
    private int f13173g = 0;

    /* renamed from: h */
    protected C7248b f13174h;

    /* renamed from: i */
    protected C7249c f13175i;

    C7050Cb(String str, C7142c cVar, List<C7154f> list, C7248b bVar) {
        super(str, cVar);
        this.f13174h = bVar;
        this.f13172f = list;
    }

    C7050Cb(String str, C7142c cVar, List<C7154f> list, C7249c cVar2) {
        super(str, cVar);
        if (list != null) {
            this.f13172f = list;
            this.f13175i = cVar2;
            return;
        }
        throw new IllegalArgumentException("Slots cannot be null");
    }

    /* renamed from: a */
    private void m14628a(int i) {
        C7248b bVar = this.f13174h;
        if (bVar != null) {
            bVar.onNativeAdsFailedToLoad(i);
        }
    }

    /* renamed from: a */
    private void m14629a(List<C7247a> list) {
        C7248b bVar = this.f13174h;
        if (bVar != null) {
            bVar.onNativeAdsLoaded(list);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo22772a(String str, C7068H h, List<String> list) {
        String str2 = "Unable to cache icon resource ";
        if (!C7269s.m15819a(str)) {
            this.f13625b.mo23049b().mo22918c(mo23203a(), "Asked to cache file with null/empty URL, nothing to do.");
            return null;
        } else if (!C7209sc.m15480a(str, list)) {
            C7262l b = this.f13625b.mo23049b();
            String a = mo23203a();
            StringBuilder sb = new StringBuilder();
            sb.append("Domain is not whitelisted, skipping precache for URL ");
            sb.append(str);
            b.mo22918c(a, sb.toString());
            return null;
        } else {
            try {
                String a2 = h.mo22828a(this.f13627d, str, null, list, true, true, null);
                if (a2 != null) {
                    return a2;
                }
                C7262l lVar = this.f13626c;
                String a3 = mo23203a();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(str);
                lVar.mo22913a(a3, sb2.toString());
                return null;
            } catch (Exception e) {
                C7262l lVar2 = this.f13626c;
                String a4 = mo23203a();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str2);
                sb3.append(str);
                lVar2.mo22914a(a4, sb3.toString(), e);
                return null;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo22752a(C7154f fVar);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo22754a(C7154f fVar, C7068H h);

    public void run() {
        List<C7154f> list;
        for (C7154f fVar : this.f13172f) {
            C7068H q = this.f13625b.mo23072q();
            this.f13625b.mo23049b().mo22918c(mo23203a(), "Beginning resource caching phase...");
            if (mo22754a(fVar, q)) {
                this.f13173g++;
                mo22752a(fVar);
            } else {
                this.f13625b.mo23049b().mo22916b(mo23203a(), "Unable to cache resources");
            }
        }
        try {
            if (this.f13173g == this.f13172f.size()) {
                list = this.f13172f;
            } else if (((Boolean) this.f13625b.mo23039a(C7196pb.f13899wb)).booleanValue()) {
                this.f13625b.mo23049b().mo22916b(mo23203a(), "Mismatch between successful populations and requested size");
                m14628a(-6);
                return;
            } else {
                list = this.f13172f;
            }
            m14629a(list);
        } catch (Throwable th) {
            this.f13625b.mo23049b().mo22919c(mo23203a(), "Encountered exception while notifying publisher code", th);
        }
    }
}
