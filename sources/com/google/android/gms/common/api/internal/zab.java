package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager.zaa;
import com.google.android.gms.common.util.PlatformVersion;

public abstract class zab {

    /* renamed from: a */
    private final int f19838a;

    public zab(int i) {
        this.f19838a = i;
    }

    /* renamed from: a */
    public abstract void mo27532a(Status status);

    /* renamed from: a */
    public abstract void mo27533a(zaa<?> zaa) throws DeadObjectException;

    /* renamed from: a */
    public abstract void mo27604a(zaab zaab, boolean z);

    /* renamed from: a */
    public abstract void mo27534a(RuntimeException runtimeException);

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Status m21519b(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (PlatformVersion.m22108b() && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }
}
