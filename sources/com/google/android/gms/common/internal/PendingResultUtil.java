package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public class PendingResultUtil {

    /* renamed from: a */
    private static final zaa f20120a = new C8705f();

    @KeepForSdk
    public interface ResultConverter<R extends Result, T> {
        @KeepForSdk
        /* renamed from: a */
        T mo27190a(R r);
    }

    public interface zaa {
        /* renamed from: a */
        ApiException mo27812a(Status status);
    }

    @KeepForSdk
    /* renamed from: a */
    public static <R extends Result, T> Task<T> m21854a(PendingResult<R> pendingResult, ResultConverter<R, T> resultConverter) {
        zaa zaa2 = f20120a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.mo27401a((StatusListener) new C8706g(pendingResult, taskCompletionSource, resultConverter, zaa2));
        return taskCompletionSource.mo33180a();
    }

    @KeepForSdk
    /* renamed from: a */
    public static <R extends Result, T extends Response<R>> Task<T> m21853a(PendingResult<R> pendingResult, T t) {
        return m21854a(pendingResult, (ResultConverter<R, T>) new C8707h<R,T>(t));
    }
}
