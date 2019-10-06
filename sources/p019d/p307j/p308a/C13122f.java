package p019d.p307j.p308a;

import p019d.p307j.p308a.p310b.C13091c;
import p019d.p307j.p308a.p310b.C13091c.C13092a;
import p019d.p307j.p308a.p310b.C13093d;
import p019d.p307j.p308a.p310b.C13095f;

/* renamed from: d.j.a.f */
/* compiled from: FileDownloadConnectListener */
public abstract class C13122f extends C13095f {

    /* renamed from: a */
    private C13092a f40153a;

    /* renamed from: a */
    public abstract void mo41997a();

    /* renamed from: b */
    public abstract void mo41998b();

    /* renamed from: a */
    public boolean mo42069a(C13093d event) {
        if (event instanceof C13091c) {
            this.f40153a = ((C13091c) event).mo42067b();
            if (this.f40153a == C13092a.connected) {
                mo41997a();
            } else {
                mo41998b();
            }
        }
        return false;
    }

    /* renamed from: c */
    public C13092a mo42094c() {
        return this.f40153a;
    }
}
