package p024io.realm.p355a;

import p024io.realm.C0106Z;
import p024io.realm.C13990F;
import p024io.realm.C14000K;
import p026rx.p027b.C0128a;

/* renamed from: io.realm.a.b */
/* compiled from: RealmObservableFactory */
class C14023b implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C14000K f42503a;

    /* renamed from: b */
    final /* synthetic */ C13990F f42504b;

    /* renamed from: c */
    final /* synthetic */ C14024c f42505c;

    C14023b(C14024c this$1, C14000K k, C13990F f) {
        this.f42505c = this$1;
        this.f42503a = k;
        this.f42504b = f;
    }

    public void call() {
        C0106Z.removeChangeListener(this.f42505c.f42507b, this.f42503a);
        this.f42504b.close();
        ((C14038a) this.f42505c.f42508c.f42538c.get()).mo43650b(this.f42505c.f42507b);
    }
}
