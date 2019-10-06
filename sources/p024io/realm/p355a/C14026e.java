package p024io.realm.p355a;

import p024io.realm.C0106Z;
import p024io.realm.C14000K;
import p024io.realm.C14061h;
import p026rx.p027b.C0128a;

/* renamed from: io.realm.a.e */
/* compiled from: RealmObservableFactory */
class C14026e implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C14000K f42511a;

    /* renamed from: b */
    final /* synthetic */ C14061h f42512b;

    /* renamed from: c */
    final /* synthetic */ C14027f f42513c;

    C14026e(C14027f this$1, C14000K k, C14061h hVar) {
        this.f42513c = this$1;
        this.f42511a = k;
        this.f42512b = hVar;
    }

    public void call() {
        C0106Z.removeChangeListener(this.f42513c.f42515b, this.f42511a);
        this.f42512b.close();
        ((C14038a) this.f42513c.f42516c.f42538c.get()).mo43650b(this.f42513c.f42515b);
    }
}
