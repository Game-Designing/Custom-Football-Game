package android.support.design.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: android.support.design.widget.Q */
/* compiled from: Snackbar */
class C0264Q implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ OnClickListener f1034a;

    /* renamed from: b */
    final /* synthetic */ Snackbar f1035b;

    C0264Q(Snackbar this$0, OnClickListener onClickListener) {
        this.f1035b = this$0;
        this.f1034a = onClickListener;
    }

    public void onClick(View view) {
        this.f1034a.onClick(view);
        this.f1035b.mo4679a(1);
    }
}
