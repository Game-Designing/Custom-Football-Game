package android.support.p001v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/* renamed from: android.support.v7.widget.bb */
/* compiled from: SearchView */
class C1042bb implements OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ SearchView f3470a;

    C1042bb(SearchView this$0) {
        this.f3470a = this$0;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        this.f3470a.onItemSelected(position);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
