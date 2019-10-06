package p024io.realm.p355a;

import io.realm.DynamicRealmObject;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import p024io.realm.C14000K;
import p024io.realm.C14001L;
import p024io.realm.C14052da;
import p024io.realm.C14061h;
import p024io.realm.C14065j;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p029i.C14978f;

/* renamed from: io.realm.a.o */
/* compiled from: RealmObservableFactory */
class C14036o implements C0122a<C14052da<C14065j>> {

    /* renamed from: a */
    final /* synthetic */ C14001L f42533a;

    /* renamed from: b */
    final /* synthetic */ C14052da f42534b;

    /* renamed from: c */
    final /* synthetic */ C14037p f42535c;

    C14036o(C14037p this$0, C14001L l, C14052da daVar) {
        this.f42535c = this$0;
        this.f42533a = l;
        this.f42534b = daVar;
    }

    /* renamed from: a */
    public void call(C14980ia<? super C14052da<C14065j>> subscriber) {
        C14061h observableRealm = C14061h.m44876c(this.f42533a);
        ((C14038a) this.f42535c.f42536a.get()).mo43649a(this.f42534b);
        RealmChangeListener<RealmResults<DynamicRealmObject>> listener = new C14034m<>(this, subscriber);
        this.f42534b.mo43705a((C14000K<C14052da<E>>) listener);
        subscriber.add(C14978f.m46781a(new C14035n(this, listener, observableRealm)));
        subscriber.onNext(this.f42534b);
    }
}
