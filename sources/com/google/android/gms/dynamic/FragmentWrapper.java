package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IFragmentWrapper.Stub;

@SuppressLint({"NewApi"})
@KeepForSdk
public final class FragmentWrapper extends Stub {

    /* renamed from: b */
    private Fragment f20338b;

    @KeepForSdk
    /* renamed from: a */
    public static FragmentWrapper m22142a(Fragment fragment) {
        if (fragment != null) {
            return new FragmentWrapper(fragment);
        }
        return null;
    }

    private FragmentWrapper(Fragment fragment) {
        this.f20338b = fragment;
    }

    /* renamed from: aa */
    public final IObjectWrapper mo27966aa() {
        return ObjectWrapper.m22188a(this.f20338b.getActivity());
    }

    /* renamed from: Va */
    public final Bundle mo27964Va() {
        return this.f20338b.getArguments();
    }

    public final int getId() {
        return this.f20338b.getId();
    }

    /* renamed from: ea */
    public final IFragmentWrapper mo27968ea() {
        return m22142a(this.f20338b.getParentFragment());
    }

    /* renamed from: R */
    public final IObjectWrapper mo27962R() {
        return ObjectWrapper.m22188a(this.f20338b.getResources());
    }

    /* renamed from: Ga */
    public final boolean mo27957Ga() {
        return this.f20338b.getRetainInstance();
    }

    public final String getTag() {
        return this.f20338b.getTag();
    }

    /* renamed from: V */
    public final IFragmentWrapper mo27963V() {
        return m22142a(this.f20338b.getTargetFragment());
    }

    /* renamed from: oa */
    public final int mo27979oa() {
        return this.f20338b.getTargetRequestCode();
    }

    /* renamed from: P */
    public final boolean mo27961P() {
        return this.f20338b.getUserVisibleHint();
    }

    /* renamed from: sa */
    public final IObjectWrapper mo27980sa() {
        return ObjectWrapper.m22188a(this.f20338b.getView());
    }

    /* renamed from: ka */
    public final boolean mo27976ka() {
        return this.f20338b.isAdded();
    }

    /* renamed from: Ea */
    public final boolean mo27956Ea() {
        return this.f20338b.isDetached();
    }

    public final boolean isHidden() {
        return this.f20338b.isHidden();
    }

    /* renamed from: Ja */
    public final boolean mo27958Ja() {
        return this.f20338b.isInLayout();
    }

    /* renamed from: Ma */
    public final boolean mo27959Ma() {
        return this.f20338b.isRemoving();
    }

    /* renamed from: Na */
    public final boolean mo27960Na() {
        return this.f20338b.isResumed();
    }

    public final boolean isVisible() {
        return this.f20338b.isVisible();
    }

    /* renamed from: n */
    public final void mo27978n(IObjectWrapper iObjectWrapper) {
        this.f20338b.registerForContextMenu((View) ObjectWrapper.m22187H(iObjectWrapper));
    }

    /* renamed from: l */
    public final void mo27977l(boolean z) {
        this.f20338b.setHasOptionsMenu(z);
    }

    /* renamed from: f */
    public final void mo27969f(boolean z) {
        this.f20338b.setMenuVisibility(z);
    }

    /* renamed from: j */
    public final void mo27974j(boolean z) {
        this.f20338b.setRetainInstance(z);
    }

    /* renamed from: e */
    public final void mo27967e(boolean z) {
        this.f20338b.setUserVisibleHint(z);
    }

    /* renamed from: a */
    public final void mo27965a(Intent intent) {
        this.f20338b.startActivity(intent);
    }

    public final void startActivityForResult(Intent intent, int i) {
        this.f20338b.startActivityForResult(intent, i);
    }

    /* renamed from: k */
    public final void mo27975k(IObjectWrapper iObjectWrapper) {
        this.f20338b.unregisterForContextMenu((View) ObjectWrapper.m22187H(iObjectWrapper));
    }
}
