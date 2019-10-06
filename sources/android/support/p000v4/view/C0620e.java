package android.support.p000v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v4.view.e */
/* compiled from: ActionProvider */
public abstract class C0620e {

    /* renamed from: a */
    private final Context f1845a;

    /* renamed from: b */
    private C0621a f1846b;

    /* renamed from: c */
    private C0622b f1847c;

    /* renamed from: android.support.v4.view.e$a */
    /* compiled from: ActionProvider */
    public interface C0621a {
    }

    /* renamed from: android.support.v4.view.e$b */
    /* compiled from: ActionProvider */
    public interface C0622b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    /* renamed from: c */
    public abstract View mo5651c();

    public C0620e(Context context) {
        this.f1845a = context;
    }

    /* renamed from: a */
    public View mo5645a(MenuItem forItem) {
        return mo5651c();
    }

    /* renamed from: e */
    public boolean mo5653e() {
        return false;
    }

    /* renamed from: b */
    public boolean mo5650b() {
        return true;
    }

    /* renamed from: d */
    public boolean mo5652d() {
        return false;
    }

    /* renamed from: a */
    public boolean mo5649a() {
        return false;
    }

    /* renamed from: a */
    public void mo5648a(SubMenu subMenu) {
    }

    /* renamed from: a */
    public void mo5646a(C0621a listener) {
        this.f1846b = listener;
    }

    /* renamed from: a */
    public void mo5647a(C0622b listener) {
        if (!(this.f1847c == null || listener == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            sb.append(getClass().getSimpleName());
            sb.append(" instance while it is still in use somewhere else?");
            Log.w("ActionProvider(support)", sb.toString());
        }
        this.f1847c = listener;
    }

    /* renamed from: f */
    public void mo5654f() {
        this.f1847c = null;
        this.f1846b = null;
    }
}
