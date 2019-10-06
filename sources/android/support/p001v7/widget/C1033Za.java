package android.support.p001v7.widget;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

/* renamed from: android.support.v7.widget.Za */
/* compiled from: SearchView */
class C1033Za implements OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ SearchView f3445a;

    C1033Za(SearchView this$0) {
        this.f3445a = this$0;
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        SearchView searchView = this.f3445a;
        if (searchView.mSearchable == null) {
            return false;
        }
        if (searchView.mSearchSrcTextView.isPopupShowing() && this.f3445a.mSearchSrcTextView.getListSelection() != -1) {
            return this.f3445a.onSuggestionsKey(v, keyCode, event);
        }
        if (this.f3445a.mSearchSrcTextView.m5005a() || !event.hasNoModifiers() || event.getAction() != 1 || keyCode != 66) {
            return false;
        }
        v.cancelLongPress();
        SearchView searchView2 = this.f3445a;
        searchView2.launchQuerySearch(0, null, searchView2.mSearchSrcTextView.getText().toString());
        return true;
    }
}
