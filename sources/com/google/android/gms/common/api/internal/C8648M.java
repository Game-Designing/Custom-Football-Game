package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager.zaa;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.common.api.internal.M */
abstract class C8648M<T> extends zac {

    /* renamed from: b */
    protected final TaskCompletionSource<T> f19703b;

    public C8648M(int i, TaskCompletionSource<T> taskCompletionSource) {
        super(i);
        this.f19703b = taskCompletionSource;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract void mo27535d(zaa<?> zaa) throws RemoteException;

    /* renamed from: a */
    public void mo27532a(Status status) {
        this.f19703b.mo33183b((Exception) new ApiException(status));
    }

    /* renamed from: a */
    public void mo27534a(RuntimeException runtimeException) {
        this.f19703b.mo33183b((Exception) runtimeException);
    }

    /* renamed from: a */
    public final void mo27533a(zaa<?> zaa) throws DeadObjectException {
        try {
            mo27535d(zaa);
        } catch (DeadObjectException e) {
            mo27532a(zab.m21519b(e));
            throw e;
        } catch (RemoteException e2) {
            mo27532a(zab.m21519b(e2));
        } catch (RuntimeException e3) {
            mo27534a(e3);
        }
    }
}
