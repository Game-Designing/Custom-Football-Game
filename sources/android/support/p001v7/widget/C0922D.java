package android.support.p001v7.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow.OnDismissListener;

/* renamed from: android.support.v7.widget.D */
/* compiled from: AppCompatSpinner */
class C0922D implements OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ OnGlobalLayoutListener f2948a;

    /* renamed from: b */
    final /* synthetic */ C0899b f2949b;

    C0922D(C0899b this$1, OnGlobalLayoutListener onGlobalLayoutListener) {
        this.f2949b = this$1;
        this.f2948a = onGlobalLayoutListener;
    }

    public void onDismiss() {
        ViewTreeObserver vto = C0897A.this.getViewTreeObserver();
        if (vto != null) {
            vto.removeGlobalOnLayoutListener(this.f2948a);
        }
    }
}
