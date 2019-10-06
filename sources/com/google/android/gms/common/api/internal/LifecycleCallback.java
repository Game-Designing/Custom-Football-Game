package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@KeepForSdk
public class LifecycleCallback {
    @KeepForSdk

    /* renamed from: a */
    protected final LifecycleFragment f19696a;

    @Keep
    private static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity lifecycleActivity) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    @KeepForSdk
    /* renamed from: a */
    protected static LifecycleFragment m21320a(LifecycleActivity lifecycleActivity) {
        if (lifecycleActivity.mo27511c()) {
            return zzc.m21686a(lifecycleActivity.mo27510b());
        }
        if (lifecycleActivity.mo27512d()) {
            return zza.m21680a(lifecycleActivity.mo27509a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @KeepForSdk
    protected LifecycleCallback(LifecycleFragment lifecycleFragment) {
        this.f19696a = lifecycleFragment;
    }

    @KeepForSdk
    /* renamed from: a */
    public Activity mo27513a() {
        return this.f19696a.mo27522a();
    }

    @KeepForSdk
    /* renamed from: a */
    public void mo27515a(Bundle bundle) {
    }

    @KeepForSdk
    /* renamed from: d */
    public void mo27520d() {
    }

    @KeepForSdk
    /* renamed from: c */
    public void mo27519c() {
    }

    @KeepForSdk
    /* renamed from: b */
    public void mo27518b(Bundle bundle) {
    }

    @KeepForSdk
    /* renamed from: a */
    public void mo27514a(int i, int i2, Intent intent) {
    }

    @KeepForSdk
    /* renamed from: e */
    public void mo27521e() {
    }

    @KeepForSdk
    /* renamed from: b */
    public void mo27517b() {
    }

    @KeepForSdk
    /* renamed from: a */
    public void mo27516a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }
}
