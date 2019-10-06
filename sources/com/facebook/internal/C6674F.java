package com.facebook.internal;

import java.util.concurrent.Callable;

/* renamed from: com.facebook.internal.F */
/* compiled from: LockOnGetVariable */
class C6674F implements Callable<Void> {

    /* renamed from: a */
    final /* synthetic */ Callable f12181a;

    /* renamed from: b */
    final /* synthetic */ C6675G f12182b;

    C6674F(C6675G this$0, Callable callable) {
        this.f12182b = this$0;
        this.f12181a = callable;
    }

    /* JADX INFO: finally extract failed */
    public Void call() throws Exception {
        try {
            this.f12182b.f12184a = this.f12181a.call();
            this.f12182b.f12185b.countDown();
            return null;
        } catch (Throwable th) {
            this.f12182b.f12185b.countDown();
            throw th;
        }
    }
}
