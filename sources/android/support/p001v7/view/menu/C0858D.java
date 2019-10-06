package android.support.p001v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p001v7.view.menu.C0873l.C0874a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.view.menu.D */
/* compiled from: SubMenuBuilder */
public class C0858D extends C0873l implements SubMenu {

    /* renamed from: A */
    private C0873l f2599A;

    /* renamed from: B */
    private C0879p f2600B;

    public C0858D(Context context, C0873l parentMenu, C0879p item) {
        super(context);
        this.f2599A = parentMenu;
        this.f2600B = item;
    }

    public void setQwertyMode(boolean isQwerty) {
        this.f2599A.setQwertyMode(isQwerty);
    }

    /* renamed from: o */
    public boolean mo6568o() {
        return this.f2599A.mo6568o();
    }

    /* renamed from: p */
    public boolean mo6569p() {
        return this.f2599A.mo6569p();
    }

    /* renamed from: s */
    public Menu mo6570s() {
        return this.f2599A;
    }

    public MenuItem getItem() {
        return this.f2600B;
    }

    /* renamed from: a */
    public void mo6561a(C0874a callback) {
        this.f2599A.mo6561a(callback);
    }

    /* renamed from: m */
    public C0873l mo6567m() {
        return this.f2599A.mo6567m();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo6562a(C0873l menu, MenuItem item) {
        return super.mo6562a(menu, item) || this.f2599A.mo6562a(menu, item);
    }

    public SubMenu setIcon(Drawable icon) {
        this.f2600B.setIcon(icon);
        return this;
    }

    public SubMenu setIcon(int iconRes) {
        this.f2600B.setIcon(iconRes);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable icon) {
        super.mo6702a(icon);
        return this;
    }

    public SubMenu setHeaderIcon(int iconRes) {
        super.mo6736d(iconRes);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence title) {
        super.mo6704a(title);
        return this;
    }

    public SubMenu setHeaderTitle(int titleRes) {
        super.mo6740e(titleRes);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.mo6703a(view);
        return this;
    }

    /* renamed from: b */
    public boolean mo6564b(C0879p item) {
        return this.f2599A.mo6564b(item);
    }

    /* renamed from: a */
    public boolean mo6563a(C0879p item) {
        return this.f2599A.mo6563a(item);
    }

    /* renamed from: d */
    public String mo6565d() {
        C0879p pVar = this.f2600B;
        int itemId = pVar != null ? pVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(super.mo6565d());
        sb.append(":");
        sb.append(itemId);
        return sb.toString();
    }
}
