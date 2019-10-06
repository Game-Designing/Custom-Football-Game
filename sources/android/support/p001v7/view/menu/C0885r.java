package android.support.p001v7.view.menu;

import android.content.Context;
import android.support.p000v4.view.C0620e.C0622b;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;
import p002b.p003c.p053g.p056b.p057a.C1224b;

/* renamed from: android.support.v7.view.menu.r */
/* compiled from: MenuItemWrapperJB */
class C0885r extends C0880q {

    /* renamed from: android.support.v7.view.menu.r$a */
    /* compiled from: MenuItemWrapperJB */
    class C0886a extends C0881a implements VisibilityListener {

        /* renamed from: f */
        C0622b f2781f;

        public C0886a(Context context, ActionProvider inner) {
            super(context, inner);
        }

        /* renamed from: a */
        public View mo5645a(MenuItem forItem) {
            return this.f2776d.onCreateActionView(forItem);
        }

        /* renamed from: e */
        public boolean mo5653e() {
            return this.f2776d.overridesItemVisibility();
        }

        /* renamed from: b */
        public boolean mo5650b() {
            return this.f2776d.isVisible();
        }

        /* renamed from: a */
        public void mo5647a(C0622b listener) {
            this.f2781f = listener;
            this.f2776d.setVisibilityListener(listener != null ? this : null);
        }

        public void onActionProviderVisibilityChanged(boolean isVisible) {
            C0622b bVar = this.f2781f;
            if (bVar != null) {
                bVar.onActionProviderVisibilityChanged(isVisible);
            }
        }
    }

    C0885r(Context context, C1224b object) {
        super(context, object);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0881a mo6823a(ActionProvider provider) {
        return new C0886a(this.f2651b, provider);
    }
}
