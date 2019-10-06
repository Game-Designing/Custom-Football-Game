package android.support.p001v7.widget;

import android.support.p000v4.widget.C0700j;

/* renamed from: android.support.v7.widget.Va */
/* compiled from: SearchView */
class C1024Va implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SearchView f3424a;

    C1024Va(SearchView this$0) {
        this.f3424a = this$0;
    }

    public void run() {
        C0700j jVar = this.f3424a.mSuggestionsAdapter;
        if (jVar != null && (jVar instanceof C1083lb)) {
            jVar.changeCursor(null);
        }
    }
}
