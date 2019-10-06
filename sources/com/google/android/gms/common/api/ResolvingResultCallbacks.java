package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender.SendIntentException;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;

public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {

    /* renamed from: a */
    private final Activity f19592a;

    /* renamed from: b */
    private final int f19593b;

    /* renamed from: b */
    public abstract void mo27405b(Status status);

    @KeepForSdk
    /* renamed from: a */
    public final void mo27404a(Status status) {
        if (status.mo27420d()) {
            try {
                status.mo27418a(this.f19592a, this.f19593b);
            } catch (SendIntentException e) {
                Log.e("ResolvingResultCallback", "Failed to start resolution", e);
                mo27405b(new Status(8));
            }
        } else {
            mo27405b(status);
        }
    }
}
