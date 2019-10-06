package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.common.api.internal.c */
final class C8663c implements OnCompleteListener<TResult> {

    /* renamed from: a */
    private final /* synthetic */ TaskCompletionSource f19747a;

    /* renamed from: b */
    private final /* synthetic */ zaab f19748b;

    C8663c(zaab zaab, TaskCompletionSource taskCompletionSource) {
        this.f19748b = zaab;
        this.f19747a = taskCompletionSource;
    }

    /* renamed from: a */
    public final void mo10072a(Task<TResult> task) {
        this.f19748b.f19785b.remove(this.f19747a);
    }
}
