package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager.zaa;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zag<ResultT> extends zac {

    /* renamed from: b */
    private final TaskApiCall<AnyClient, ResultT> f19888b;

    /* renamed from: c */
    private final TaskCompletionSource<ResultT> f19889c;

    /* renamed from: d */
    private final StatusExceptionMapper f19890d;

    public zag(int i, TaskApiCall<AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        super(i);
        this.f19889c = taskCompletionSource;
        this.f19888b = taskApiCall;
        this.f19890d = statusExceptionMapper;
    }

    /* renamed from: a */
    public final void mo27533a(zaa<?> zaa) throws DeadObjectException {
        try {
            this.f19888b.mo27558a(zaa.mo27496f(), this.f19889c);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            mo27532a(zab.m21519b(e2));
        } catch (RuntimeException e3) {
            mo27534a(e3);
        }
    }

    /* renamed from: a */
    public final void mo27532a(Status status) {
        this.f19889c.mo33183b(this.f19890d.mo27429a(status));
    }

    /* renamed from: a */
    public final void mo27534a(RuntimeException runtimeException) {
        this.f19889c.mo33183b((Exception) runtimeException);
    }

    /* renamed from: a */
    public final void mo27604a(zaab zaab, boolean z) {
        zaab.mo27582a(this.f19889c, z);
    }

    /* renamed from: b */
    public final Feature[] mo27614b(zaa<?> zaa) {
        return this.f19888b.mo27560b();
    }

    /* renamed from: c */
    public final boolean mo27615c(zaa<?> zaa) {
        return this.f19888b.mo27559a();
    }
}
