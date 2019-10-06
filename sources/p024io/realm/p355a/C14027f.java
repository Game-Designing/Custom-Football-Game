package p024io.realm.p355a;

import io.realm.DynamicRealmObject;
import io.realm.RealmChangeListener;
import p024io.realm.C0106Z;
import p024io.realm.C14000K;
import p024io.realm.C14001L;
import p024io.realm.C14061h;
import p024io.realm.C14065j;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p029i.C14978f;

/* renamed from: io.realm.a.f */
/* compiled from: RealmObservableFactory */
class C14027f implements C0122a<C14065j> {

    /* renamed from: a */
    final /* synthetic */ C14001L f42514a;

    /* renamed from: b */
    final /* synthetic */ C14065j f42515b;

    /* renamed from: c */
    final /* synthetic */ C14037p f42516c;

    C14027f(C14037p this$0, C14001L l, C14065j jVar) {
        this.f42516c = this$0;
        this.f42514a = l;
        this.f42515b = jVar;
    }

    /* renamed from: a */
    public void call(C14980ia<? super C14065j> subscriber) {
        C14061h observableRealm = C14061h.m44876c(this.f42514a);
        ((C14038a) this.f42516c.f42538c.get()).mo43649a(this.f42515b);
        RealmChangeListener<DynamicRealmObject> listener = new C14025d<>(this, subscriber);
        C0106Z.addChangeListener(this.f42515b, (C14000K<E>) listener);
        subscriber.add(C14978f.m46781a(new C14026e(this, listener, observableRealm)));
        subscriber.onNext(this.f42515b);
    }
}
