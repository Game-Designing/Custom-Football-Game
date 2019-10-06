package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface LifecycleFragment {
    @KeepForSdk
    /* renamed from: a */
    Activity mo27522a();

    @KeepForSdk
    /* renamed from: a */
    <T extends LifecycleCallback> T mo27523a(String str, Class<T> cls);

    @KeepForSdk
    /* renamed from: a */
    void mo27524a(String str, LifecycleCallback lifecycleCallback);

    @KeepForSdk
    void startActivityForResult(Intent intent, int i);
}
