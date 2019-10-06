package com.google.android.gms.common.api;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;

public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    /* renamed from: a */
    public abstract void mo27404a(Status status);

    /* renamed from: b */
    public abstract void mo27409b(R r);

    @KeepForSdk
    /* renamed from: a */
    public final void mo27408a(R r) {
        Status status = r.getStatus();
        if (status.mo27421e()) {
            mo27409b(r);
            return;
        }
        mo27404a(status);
        if (r instanceof Releasable) {
            try {
                ((Releasable) r).mo27353a();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(r);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("ResultCallbacks", sb.toString(), e);
            }
        }
    }
}
