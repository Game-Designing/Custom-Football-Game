package android.support.p001v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* renamed from: android.support.v7.widget.ab */
/* compiled from: SearchView */
class C1039ab implements OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ SearchView f3464a;

    C1039ab(SearchView this$0) {
        this.f3464a = this$0;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        this.f3464a.onItemClicked(position, 0, null);
    }
}
