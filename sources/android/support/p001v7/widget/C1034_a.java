package android.support.p001v7.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* renamed from: android.support.v7.widget._a */
/* compiled from: SearchView */
class C1034_a implements OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ SearchView f3446a;

    C1034_a(SearchView this$0) {
        this.f3446a = this$0;
    }

    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        this.f3446a.onSubmitQuery();
        return true;
    }
}
