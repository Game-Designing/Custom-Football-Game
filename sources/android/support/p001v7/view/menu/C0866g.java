package android.support.p001v7.view.menu;

import android.view.MenuItem;

/* renamed from: android.support.v7.view.menu.g */
/* compiled from: CascadingMenuPopup */
class C0866g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0869a f2657a;

    /* renamed from: b */
    final /* synthetic */ MenuItem f2658b;

    /* renamed from: c */
    final /* synthetic */ C0873l f2659c;

    /* renamed from: d */
    final /* synthetic */ C0867h f2660d;

    C0866g(C0867h this$1, C0869a aVar, MenuItem menuItem, C0873l lVar) {
        this.f2660d = this$1;
        this.f2657a = aVar;
        this.f2658b = menuItem;
        this.f2659c = lVar;
    }

    public void run() {
        C0869a aVar = this.f2657a;
        if (aVar != null) {
            this.f2660d.f2661a.f2662A = true;
            aVar.f2689b.mo6712a(false);
            this.f2660d.f2661a.f2662A = false;
        }
        if (this.f2658b.isEnabled() && this.f2658b.hasSubMenu()) {
            this.f2659c.mo6713a(this.f2658b, 4);
        }
    }
}
