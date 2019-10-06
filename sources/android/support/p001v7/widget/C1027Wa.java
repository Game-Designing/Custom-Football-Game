package android.support.p001v7.widget;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* renamed from: android.support.v7.widget.Wa */
/* compiled from: SearchView */
class C1027Wa implements OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ SearchView f3432a;

    C1027Wa(SearchView this$0) {
        this.f3432a = this$0;
    }

    public void onFocusChange(View v, boolean hasFocus) {
        SearchView searchView = this.f3432a;
        OnFocusChangeListener onFocusChangeListener = searchView.mOnQueryTextFocusChangeListener;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(searchView, hasFocus);
        }
    }
}
