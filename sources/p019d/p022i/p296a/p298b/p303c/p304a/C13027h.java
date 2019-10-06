package p019d.p022i.p296a.p298b.p303c.p304a;

import android.support.p001v7.widget.SearchView;
import android.support.p001v7.widget.SearchView.C1010c;
import p026rx.C14980ia;

/* renamed from: d.i.a.b.c.a.h */
/* compiled from: SearchViewQueryTextChangeEventsOnSubscribe */
class C13027h implements C1010c {

    /* renamed from: a */
    final /* synthetic */ C14980ia f40000a;

    /* renamed from: b */
    final /* synthetic */ C13029j f40001b;

    C13027h(C13029j this$0, C14980ia iaVar) {
        this.f40001b = this$0;
        this.f40000a = iaVar;
    }

    public boolean onQueryTextChange(String s) {
        if (this.f40000a.isUnsubscribed()) {
            return false;
        }
        this.f40000a.onNext(C13030k.m42486a(this.f40001b.f40003a, s, false));
        return true;
    }

    public boolean onQueryTextSubmit(String query) {
        if (this.f40000a.isUnsubscribed()) {
            return false;
        }
        C14980ia iaVar = this.f40000a;
        SearchView searchView = this.f40001b.f40003a;
        iaVar.onNext(C13030k.m42486a(searchView, searchView.getQuery(), true));
        return true;
    }
}
