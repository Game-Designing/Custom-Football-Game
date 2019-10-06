package android.support.p001v7.widget;

import android.support.p001v7.view.menu.C0896z;
import android.view.View;

/* renamed from: android.support.v7.widget.h */
/* compiled from: ActionMenuPresenter */
class C1062h extends C1080la {

    /* renamed from: j */
    final /* synthetic */ ActionMenuPresenter f3526j;

    /* renamed from: k */
    final /* synthetic */ C0907d f3527k;

    C1062h(C0907d this$1, View src, ActionMenuPresenter actionMenuPresenter) {
        this.f3527k = this$1;
        this.f3526j = actionMenuPresenter;
        super(src);
    }

    /* renamed from: h */
    public C0896z mo6541h() {
        C0908e eVar = ActionMenuPresenter.this.f2882z;
        if (eVar == null) {
            return null;
        }
        return eVar.mo6897b();
    }

    /* renamed from: i */
    public boolean mo6542i() {
        ActionMenuPresenter.this.mo7074j();
        return true;
    }

    /* renamed from: j */
    public boolean mo8453j() {
        ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
        if (actionMenuPresenter.f2863B != null) {
            return false;
        }
        actionMenuPresenter.mo7070f();
        return true;
    }
}
