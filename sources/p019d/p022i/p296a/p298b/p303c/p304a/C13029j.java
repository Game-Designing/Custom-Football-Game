package p019d.p022i.p296a.p298b.p303c.p304a;

import android.support.p001v7.widget.SearchView;
import android.support.p001v7.widget.SearchView.C1010c;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p387a.C14521b;

/* renamed from: d.i.a.b.c.a.j */
/* compiled from: SearchViewQueryTextChangeEventsOnSubscribe */
final class C13029j implements C0122a<C13030k> {

    /* renamed from: a */
    final SearchView f40003a;

    C13029j(SearchView view) {
        this.f40003a = view;
    }

    /* renamed from: a */
    public void call(C14980ia<? super C13030k> subscriber) {
        C14521b.verifyMainThread();
        C1010c watcher = new C13027h(this, subscriber);
        subscriber.add(new C13028i(this));
        this.f40003a.setOnQueryTextListener(watcher);
        SearchView searchView = this.f40003a;
        subscriber.onNext(C13030k.m42486a(searchView, searchView.getQuery(), false));
    }
}
