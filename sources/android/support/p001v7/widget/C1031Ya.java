package android.support.p001v7.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: android.support.v7.widget.Ya */
/* compiled from: SearchView */
class C1031Ya implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SearchView f3440a;

    C1031Ya(SearchView this$0) {
        this.f3440a = this$0;
    }

    public void onClick(View v) {
        SearchView searchView = this.f3440a;
        if (v == searchView.mSearchButton) {
            searchView.onSearchClicked();
        } else if (v == searchView.mCloseButton) {
            searchView.onCloseClicked();
        } else if (v == searchView.mGoButton) {
            searchView.onSubmitQuery();
        } else if (v == searchView.mVoiceButton) {
            searchView.onVoiceClicked();
        } else if (v == searchView.mSearchSrcTextView) {
            searchView.forceSuggestionQuery();
        }
    }
}
