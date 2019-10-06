package android.support.p000v4.view;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* renamed from: android.support.v4.view.x */
/* compiled from: ViewCompat */
class C0657x implements OnApplyWindowInsetsListener {

    /* renamed from: a */
    final /* synthetic */ C0641r f1872a;

    /* renamed from: b */
    final /* synthetic */ C0652f f1873b;

    C0657x(C0652f this$0, C0641r rVar) {
        this.f1873b = this$0;
        this.f1872a = rVar;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
        return (WindowInsets) C0592M.m2793a(this.f1872a.mo4252a(view, C0592M.m2792a((Object) insets)));
    }
}
