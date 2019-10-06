package com.facebook.internal;

import com.facebook.C6787r;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

/* renamed from: com.facebook.internal.G */
/* compiled from: LockOnGetVariable */
public class C6675G<T> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public T f12184a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CountDownLatch f12185b = new CountDownLatch(1);

    public C6675G(Callable<T> callable) {
        C6787r.m13822l().execute(new FutureTask(new C6674F(this, callable)));
    }
}
