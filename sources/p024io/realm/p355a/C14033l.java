package p024io.realm.p355a;

import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import p024io.realm.C13990F;
import p024io.realm.C14000K;
import p024io.realm.C14001L;
import p024io.realm.C14052da;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p029i.C14978f;

/* renamed from: io.realm.a.l */
/* compiled from: RealmObservableFactory */
class C14033l implements C0122a<C14052da<E>> {

    /* renamed from: a */
    final /* synthetic */ C14001L f42525a;

    /* renamed from: b */
    final /* synthetic */ C14052da f42526b;

    /* renamed from: c */
    final /* synthetic */ C14037p f42527c;

    C14033l(C14037p this$0, C14001L l, C14052da daVar) {
        this.f42527c = this$0;
        this.f42525a = l;
        this.f42526b = daVar;
    }

    /* renamed from: a */
    public void call(C14980ia<? super C14052da<E>> subscriber) {
        C13990F observableRealm = C13990F.m44516b(this.f42525a);
        ((C14038a) this.f42527c.f42536a.get()).mo43649a(this.f42526b);
        RealmChangeListener<RealmResults<E>> listener = new C14031j<>(this, subscriber);
        this.f42526b.mo43705a((C14000K<C14052da<E>>) listener);
        subscriber.add(C14978f.m46781a(new C14032k(this, listener, observableRealm)));
        subscriber.onNext(this.f42526b);
    }
}
