package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ThreadFactory;

@KeepForSdk
public class NamedThreadFactory implements ThreadFactory {

    /* renamed from: a */
    private final String f20316a;

    /* renamed from: b */
    private final ThreadFactory f20317b;

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f20317b.newThread(new C8726a(runnable, 0));
        newThread.setName(this.f20316a);
        return newThread;
    }
}
