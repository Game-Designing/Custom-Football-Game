package p019d.p143b.p144a.p147c;

import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7264n;

/* renamed from: d.b.a.c.db */
class C7148db implements C7264n {

    /* renamed from: a */
    final /* synthetic */ C7152eb f13492a;

    /* renamed from: b */
    final /* synthetic */ C7144cb f13493b;

    C7148db(C7144cb cbVar, C7152eb ebVar) {
        this.f13493b = cbVar;
        this.f13492a = ebVar;
    }

    public void onPostbackFailure(String str, int i) {
        C7262l a = this.f13493b.f13483b;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to submit postback with errorCode ");
        sb.append(i);
        sb.append(". Will retry later...  Postback: ");
        sb.append(this.f13492a);
        a.mo22920d("PersistentPostbackManager", sb.toString());
        this.f13493b.m15112e(this.f13492a);
    }

    public void onPostbackSuccess(String str) {
        this.f13493b.m15111d(this.f13492a);
        C7262l a = this.f13493b.f13483b;
        StringBuilder sb = new StringBuilder();
        sb.append("Successfully submitted postback: ");
        sb.append(this.f13492a);
        a.mo22918c("PersistentPostbackManager", sb.toString());
        this.f13493b.mo23087b();
    }
}
