package android.support.p001v7.widget;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* renamed from: android.support.v7.widget.C */
/* compiled from: AppCompatSpinner */
class C0918C implements OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ C0899b f2928a;

    C0918C(C0899b this$1) {
        this.f2928a = this$1;
    }

    public void onGlobalLayout() {
        C0899b bVar = this.f2928a;
        if (!bVar.mo6963b(C0897A.this)) {
            this.f2928a.dismiss();
            return;
        }
        this.f2928a.mo6964k();
        C0918C.super.show();
    }
}
