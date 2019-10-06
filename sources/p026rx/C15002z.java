package p026rx;

import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p029i.C14976d;
import p026rx.p400f.C14948s;

/* renamed from: rx.z */
/* compiled from: Completable */
class C15002z implements C14503O {

    /* renamed from: a */
    boolean f44381a;

    /* renamed from: b */
    final /* synthetic */ C0128a f44382b;

    /* renamed from: c */
    final /* synthetic */ C14976d f44383c;

    /* renamed from: d */
    final /* synthetic */ C0129b f44384d;

    /* renamed from: e */
    final /* synthetic */ C0117M f44385e;

    C15002z(C0117M m, C0128a aVar, C14976d dVar, C0129b bVar) {
        this.f44385e = m;
        this.f44382b = aVar;
        this.f44383c = dVar;
        this.f44384d = bVar;
    }

    public void onCompleted() {
        if (!this.f44381a) {
            this.f44381a = true;
            try {
                this.f44382b.call();
                this.f44383c.unsubscribe();
            } catch (Throwable e) {
                mo46214a(e);
            }
        }
    }

    public void onError(Throwable e) {
        if (!this.f44381a) {
            this.f44381a = true;
            mo46214a(e);
            return;
        }
        C14948s.m46719b(e);
        C0117M.m588a(e);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo46214a(Throwable e) {
        try {
            this.f44384d.call(e);
        } catch (Throwable th) {
            this.f44383c.unsubscribe();
            throw th;
        }
        this.f44383c.unsubscribe();
    }

    /* renamed from: a */
    public void mo45688a(C0137ja d) {
        this.f44383c.mo46196a(d);
    }
}
