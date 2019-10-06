package android.support.p001v7.widget;

import android.support.p001v7.view.menu.C0860a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window.Callback;

/* renamed from: android.support.v7.widget.xb */
/* compiled from: ToolbarWidgetWrapper */
class C1133xb implements OnClickListener {

    /* renamed from: a */
    final C0860a f3759a;

    /* renamed from: b */
    final /* synthetic */ C1140zb f3760b;

    C1133xb(C1140zb this$0) {
        this.f3760b = this$0;
        C0860a aVar = new C0860a(this.f3760b.f3773a.getContext(), 0, 16908332, 0, 0, this.f3760b.f3781i);
        this.f3759a = aVar;
    }

    public void onClick(View v) {
        C1140zb zbVar = this.f3760b;
        Callback callback = zbVar.f3784l;
        if (callback != null && zbVar.f3785m) {
            callback.onMenuItemSelected(0, this.f3759a);
        }
    }
}
