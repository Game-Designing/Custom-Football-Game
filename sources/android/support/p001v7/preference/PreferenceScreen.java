package android.support.p001v7.preference;

import android.content.Context;
import android.support.p000v4.content.p036a.C0509e;
import android.support.p001v7.preference.C0847y.C0849b;
import android.util.AttributeSet;

/* renamed from: android.support.v7.preference.PreferenceScreen */
public final class PreferenceScreen extends PreferenceGroup {

    /* renamed from: W */
    private boolean f2467W = true;

    public PreferenceScreen(Context context, AttributeSet attrs) {
        super(context, attrs, C0509e.m2548a(context, C0797C.preferenceScreenStyle, 16842891));
    }

    /* access modifiers changed from: protected */
    /* renamed from: K */
    public void mo6294K() {
        if (mo6380s() == null && mo6379j() == null && mo6296S() != 0) {
            C0849b listener = mo6386x().mo6515c();
            if (listener != null) {
                listener.onNavigateToScreen(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: T */
    public boolean mo6297T() {
        return false;
    }

    /* renamed from: V */
    public boolean mo6404V() {
        return this.f2467W;
    }
}
