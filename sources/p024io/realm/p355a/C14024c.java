package p024io.realm.p355a;

import io.realm.RealmChangeListener;
import p024io.realm.C0105Y;
import p024io.realm.C0106Z;
import p024io.realm.C13990F;
import p024io.realm.C14000K;
import p024io.realm.C14001L;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p029i.C14978f;

/* renamed from: io.realm.a.c */
/* compiled from: RealmObservableFactory */
class C14024c implements C0122a<E> {

    /* renamed from: a */
    final /* synthetic */ C14001L f42506a;

    /* renamed from: b */
    final /* synthetic */ C0105Y f42507b;

    /* renamed from: c */
    final /* synthetic */ C14037p f42508c;

    C14024c(C14037p this$0, C14001L l, C0105Y y) {
        this.f42508c = this$0;
        this.f42506a = l;
        this.f42507b = y;
    }

    /* renamed from: a */
    public void call(C14980ia<? super E> subscriber) {
        C13990F observableRealm = C13990F.m44516b(this.f42506a);
        ((C14038a) this.f42508c.f42538c.get()).mo43649a(this.f42507b);
        RealmChangeListener<E> listener = new C14022a<>(this, subscriber);
        C0106Z.addChangeListener(this.f42507b, (C14000K<E>) listener);
        subscriber.add(C14978f.m46781a(new C14023b(this, listener, observableRealm)));
        subscriber.onNext(this.f42507b);
    }
}
