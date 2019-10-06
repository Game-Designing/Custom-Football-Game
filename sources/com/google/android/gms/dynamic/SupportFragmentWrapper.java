package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IFragmentWrapper.Stub;

@KeepForSdk
public final class SupportFragmentWrapper extends Stub {

    /* renamed from: b */
    private Fragment f20342b;

    @KeepForSdk
    /* renamed from: a */
    public static SupportFragmentWrapper m22191a(Fragment fragment) {
        if (fragment != null) {
            return new SupportFragmentWrapper(fragment);
        }
        return null;
    }

    private SupportFragmentWrapper(Fragment fragment) {
        this.f20342b = fragment;
    }

    /* renamed from: aa */
    public final IObjectWrapper mo27966aa() {
        return ObjectWrapper.m22188a(this.f20342b.getActivity());
    }

    /* renamed from: Va */
    public final Bundle mo27964Va() {
        return this.f20342b.getArguments();
    }

    public final int getId() {
        return this.f20342b.getId();
    }

    /* renamed from: ea */
    public final IFragmentWrapper mo27968ea() {
        return m22191a(this.f20342b.getParentFragment());
    }

    /* renamed from: R */
    public final IObjectWrapper mo27962R() {
        return ObjectWrapper.m22188a(this.f20342b.getResources());
    }

    /* renamed from: Ga */
    public final boolean mo27957Ga() {
        return this.f20342b.getRetainInstance();
    }

    public final String getTag() {
        return this.f20342b.getTag();
    }

    /* renamed from: V */
    public final IFragmentWrapper mo27963V() {
        return m22191a(this.f20342b.getTargetFragment());
    }

    /* renamed from: oa */
    public final int mo27979oa() {
        return this.f20342b.getTargetRequestCode();
    }

    /* renamed from: P */
    public final boolean mo27961P() {
        return this.f20342b.getUserVisibleHint();
    }

    /* renamed from: sa */
    public final IObjectWrapper mo27980sa() {
        return ObjectWrapper.m22188a(this.f20342b.getView());
    }

    /* renamed from: ka */
    public final boolean mo27976ka() {
        return this.f20342b.isAdded();
    }

    /* renamed from: Ea */
    public final boolean mo27956Ea() {
        return this.f20342b.isDetached();
    }

    public final boolean isHidden() {
        return this.f20342b.isHidden();
    }

    /* renamed from: Ja */
    public final boolean mo27958Ja() {
        return this.f20342b.isInLayout();
    }

    /* renamed from: Ma */
    public final boolean mo27959Ma() {
        return this.f20342b.isRemoving();
    }

    /* renamed from: Na */
    public final boolean mo27960Na() {
        return this.f20342b.isResumed();
    }

    public final boolean isVisible() {
        return this.f20342b.isVisible();
    }

    /* renamed from: n */
    public final void mo27978n(IObjectWrapper iObjectWrapper) {
        this.f20342b.registerForContextMenu((View) ObjectWrapper.m22187H(iObjectWrapper));
    }

    /* renamed from: l */
    public final void mo27977l(boolean z) {
        this.f20342b.setHasOptionsMenu(z);
    }

    /* renamed from: f */
    public final void mo27969f(boolean z) {
        this.f20342b.setMenuVisibility(z);
    }

    /* renamed from: j */
    public final void mo27974j(boolean z) {
        this.f20342b.setRetainInstance(z);
    }

    /* renamed from: e */
    public final void mo27967e(boolean z) {
        this.f20342b.setUserVisibleHint(z);
    }

    /* renamed from: a */
    public final void mo27965a(Intent intent) {
        this.f20342b.startActivity(intent);
    }

    public final void startActivityForResult(Intent intent, int i) {
        this.f20342b.startActivityForResult(intent, i);
    }

    /* renamed from: k */
    public final void mo27975k(IObjectWrapper iObjectWrapper) {
        this.f20342b.unregisterForContextMenu((View) ObjectWrapper.m22187H(iObjectWrapper));
    }
}
