package android.support.p001v7.widget;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

/* renamed from: android.support.v7.widget.Xa */
/* compiled from: SearchView */
class C1029Xa implements OnLayoutChangeListener {

    /* renamed from: a */
    final /* synthetic */ SearchView f3435a;

    C1029Xa(SearchView this$0) {
        this.f3435a = this$0;
    }

    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        this.f3435a.adjustDropDownSizeAndPosition();
    }
}
