package android.support.p001v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/* renamed from: android.support.v7.widget.ua */
/* compiled from: ListPopupWindow */
class C1117ua implements OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ C1120va f3703a;

    C1117ua(C1120va this$0) {
        this.f3703a = this$0;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        if (position != -1) {
            C1058ga dropDownList = this.f3703a.f3722f;
            if (dropDownList != null) {
                dropDownList.setListSelectionHidden(false);
            }
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
