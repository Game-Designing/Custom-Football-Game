package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class zaab {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Map<BasePendingResult<?>, Boolean> f19784a = Collections.synchronizedMap(new WeakHashMap());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map<TaskCompletionSource<?>, Boolean> f19785b = Collections.synchronizedMap(new WeakHashMap());

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo27581a(BasePendingResult<? extends Result> basePendingResult, boolean z) {
        this.f19784a.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.mo27401a((StatusListener) new C8662b(this, basePendingResult));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final <TResult> void mo27582a(TaskCompletionSource<TResult> taskCompletionSource, boolean z) {
        this.f19785b.put(taskCompletionSource, Boolean.valueOf(z));
        taskCompletionSource.mo33180a().mo33173a((OnCompleteListener<TResult>) new C8663c<TResult>(this, taskCompletionSource));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo27583a() {
        return !this.f19784a.isEmpty() || !this.f19785b.isEmpty();
    }

    /* renamed from: b */
    public final void mo27584b() {
        m21418a(false, GoogleApiManager.f19645a);
    }

    /* renamed from: c */
    public final void mo27585c() {
        m21418a(true, zacp.f19880a);
    }

    /* renamed from: a */
    private final void m21418a(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f19784a) {
            hashMap = new HashMap(this.f19784a);
        }
        synchronized (this.f19785b) {
            hashMap2 = new HashMap(this.f19785b);
        }
        for (Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).mo27453b(status);
            }
        }
        for (Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).mo33183b((Exception) new ApiException(status));
            }
        }
    }
}
