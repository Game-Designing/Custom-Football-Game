package android.support.p001v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.p001v7.appcompat.C0793R;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import p002b.p003c.p062h.p071g.C1300b;
import p002b.p003c.p062h.p071g.C1300b.C1301a;

/* renamed from: android.support.v7.app.F */
/* compiled from: AppCompatDialog */
public class C0744F extends Dialog implements C0020o {

    /* renamed from: a */
    private C0776p f2234a;

    public C0744F(Context context, int theme) {
        super(context, m3486a(context, theme));
        mo6130a().mo6082a((Bundle) null);
        mo6130a().mo6243a();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        mo6130a().mo6105f();
        super.onCreate(savedInstanceState);
        mo6130a().mo6082a(savedInstanceState);
    }

    public void setContentView(int layoutResID) {
        mo6130a().mo6100c(layoutResID);
    }

    public void setContentView(View view) {
        mo6130a().mo6085a(view);
    }

    public void setContentView(View view, LayoutParams params) {
        mo6130a().mo6096b(view, params);
    }

    public <T extends View> T findViewById(int id) {
        return mo6130a().mo6077a(id);
    }

    public void setTitle(CharSequence title) {
        super.setTitle(title);
        mo6130a().mo6242a(title);
    }

    public void setTitle(int titleId) {
        super.setTitle(titleId);
        mo6130a().mo6242a((CharSequence) getContext().getString(titleId));
    }

    public void addContentView(View view, LayoutParams params) {
        mo6130a().mo6086a(view, params);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        mo6130a().mo6109l();
    }

    /* renamed from: a */
    public boolean mo6131a(int featureId) {
        return mo6130a().mo6098b(featureId);
    }

    public void invalidateOptionsMenu() {
        mo6130a().mo6106g();
    }

    /* renamed from: a */
    public C0776p mo6130a() {
        if (this.f2234a == null) {
            this.f2234a = C0776p.m3635a((Dialog) this, (C0020o) this);
        }
        return this.f2234a;
    }

    /* renamed from: a */
    private static int m3486a(Context context, int themeId) {
        if (themeId != 0) {
            return themeId;
        }
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(C0793R.attr.dialogTheme, outValue, true);
        return outValue.resourceId;
    }

    public void onSupportActionModeStarted(C1300b mode) {
    }

    public void onSupportActionModeFinished(C1300b mode) {
    }

    public C1300b onWindowStartingSupportActionMode(C1301a callback) {
        return null;
    }
}
