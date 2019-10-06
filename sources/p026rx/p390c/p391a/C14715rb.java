package p026rx.p390c.p391a;

import p026rx.C0126V.C0127a;
import p026rx.p027b.C0128a;

/* renamed from: rx.c.a.rb */
/* compiled from: OperatorUnsubscribeOn */
class C14715rb implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C0127a f43795a;

    /* renamed from: b */
    final /* synthetic */ C14725sb f43796b;

    C14715rb(C14725sb sbVar, C0127a aVar) {
        this.f43796b = sbVar;
        this.f43795a = aVar;
    }

    public void call() {
        this.f43796b.f43814a.unsubscribe();
        this.f43795a.unsubscribe();
    }
}
