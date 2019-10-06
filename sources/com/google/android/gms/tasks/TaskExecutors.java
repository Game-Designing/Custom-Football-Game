package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class TaskExecutors {

    /* renamed from: a */
    public static final Executor f30615a = new C10042a();

    /* renamed from: b */
    static final Executor f30616b = new C10050h();

    /* renamed from: com.google.android.gms.tasks.TaskExecutors$a */
    private static final class C10042a implements Executor {

        /* renamed from: a */
        private final Handler f30617a = new Handler(Looper.getMainLooper());

        public final void execute(Runnable runnable) {
            this.f30617a.post(runnable);
        }
    }

    private TaskExecutors() {
    }
}
