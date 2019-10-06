package android.support.p001v7.preference;

import android.content.Context;
import android.support.p000v4.content.p036a.C0509e;
import android.support.p000v4.view.p038a.C0604b;
import android.support.p000v4.view.p038a.C0604b.C0606b;
import android.util.AttributeSet;

/* renamed from: android.support.v7.preference.PreferenceCategory */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public PreferenceCategory(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attrs) {
        this(context, attrs, C0509e.m2548a(context, C0797C.preferenceCategoryStyle, 16842892));
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo6393d(Preference preference) {
        if (!(preference instanceof PreferenceCategory)) {
            return super.mo6393d(preference);
        }
        throw new IllegalArgumentException("Cannot add a PreferenceCategory directly to a PreferenceCategory");
    }

    /* renamed from: D */
    public boolean mo6329D() {
        return false;
    }

    /* renamed from: P */
    public boolean mo6305P() {
        return !super.mo6329D();
    }

    /* renamed from: a */
    public void mo6346a(C0604b info) {
        super.mo6346a(info);
        C0606b existingItemInfo = info.mo5590c();
        if (existingItemInfo != null) {
            info.mo5588b((Object) C0606b.m2844a(existingItemInfo.mo5614c(), existingItemInfo.mo5615d(), existingItemInfo.mo5612a(), existingItemInfo.mo5613b(), true, existingItemInfo.mo5616e()));
        }
    }
}
