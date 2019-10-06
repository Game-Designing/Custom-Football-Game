package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

public final class zacm<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ResultTransform<? super R, ? extends Result> f19873a;

    /* renamed from: b */
    private zacm<? extends Result> f19874b;

    /* renamed from: c */
    private volatile ResultCallbacks<? super R> f19875c;

    /* renamed from: d */
    private final Object f19876d;

    /* renamed from: e */
    private Status f19877e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final WeakReference<GoogleApiClient> f19878f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final C8643I f19879g;

    /* renamed from: a */
    public final void mo27408a(R r) {
        synchronized (this.f19876d) {
            if (!r.getStatus().mo27421e()) {
                m21581a(r.getStatus());
                m21584b((Result) r);
            } else if (this.f19873a != null) {
                zacc.m21566a().submit(new C8642H(this, r));
            } else if (m21586b()) {
                this.f19875c.mo27409b(r);
            }
        }
    }

    /* renamed from: a */
    private final void m21581a(Status status) {
        synchronized (this.f19876d) {
            this.f19877e = status;
            m21585b(this.f19877e);
        }
    }

    /* renamed from: b */
    private final void m21585b(Status status) {
        synchronized (this.f19876d) {
            if (this.f19873a != null) {
                Status a = this.f19873a.mo27411a(status);
                Preconditions.m21858a(a, (Object) "onFailure must not return null");
                this.f19874b.m21581a(a);
            } else if (m21586b()) {
                this.f19875c.mo27404a(status);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo27619a() {
        this.f19875c = null;
    }

    /* renamed from: b */
    private final boolean m21586b() {
        return (this.f19875c == null || ((GoogleApiClient) this.f19878f.get()) == null) ? false : true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m21584b(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).mo27353a();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("TransformedResultImpl", sb.toString(), e);
            }
        }
    }
}
